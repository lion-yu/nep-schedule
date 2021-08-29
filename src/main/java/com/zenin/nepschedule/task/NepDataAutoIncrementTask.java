package com.zenin.nepschedule.task;

import com.zenin.nepschedule.utils.DateFormatter;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 86227
 * @date 2021/8/29 19:26
 */
@Component
public class NepDataAutoIncrementTask {

    private final Logger logger = LoggerFactory.getLogger(NepDataAutoIncrementTask.class);

    @Autowired
    @Qualifier("database")
    private MongoTemplate database;

    @Autowired
    @Qualifier("runningDatabase")
    private MongoTemplate runningDatabase;

    private static List<String> pvgIds = null;

    /**
     * 每五分钟执行一次
     */
    @Scheduled(cron = "0 0/5 * * * ?")
    public void execute() {
        //获取采集器序列号
        if (pvgIds == null) {
            Document pvgDevices = database.getCollection("assets").
                    find(new Document().append("asset_id", "609d04fefa7eca42607a3259")).first();
            if (pvgDevices == null) {
                return;
            }
            pvgIds = pvgDevices.getList("pvg_ids", String.class);
            if (pvgIds == null) {
                return;
            }
        }
        //今天复制十天前的数据
        Calendar calendar = Calendar.getInstance();
        Date begin = calendar.getTime();
        String formatDate = DateFormatter.dateToStr(begin, DateFormatter.YYYY_MM_DD);
        Calendar earlyTen = (Calendar)calendar.clone();
        earlyTen.add(Calendar.DATE, -10);
        String earlyTenFormatDate = DateFormatter.dateToStr(earlyTen.getTime(), DateFormatter.YYYY_MM_DD);
        long totalSecond = 0;
        String collection = "pvg_panel_";
        for (String pvgId : pvgIds) {
            long startTime = System.currentTimeMillis();
            List<Document> docs = new LinkedList<>();
            //复制前五分钟的数据
            runningDatabase.getCollection(collection + earlyTenFormatDate).
                    find(new Document().append("pvg_id", pvgId).append("upload_time",
                            new Document("$gte", begin).append("$lte",
                                    new Date(begin.getTime() - DateFormatter.MILLISECOND_MINUTE * 5)))).
                    forEach(docs::add);
            //处理数据
            for (Document doc : docs) {
                doc.remove("_id");
                long newUploadTime = doc.getDate("upload_time").getTime() - 10 * DateFormatter.MILLISECOND_DAY;
                //修改上报时间
                doc.append("upload_time", new Date(newUploadTime));
                //修改采集器发电量?
            }
            runningDatabase.getCollection(collection + formatDate).insertMany(docs);
            long endTime = System.currentTimeMillis();
            long consumeTime = (endTime - startTime) / 1000;
            totalSecond += consumeTime;
            logger.info("pvgId {} , spend time {} s", pvgId, consumeTime);
        }
        logger.info("time consuming {} s", totalSecond);
    }
}
