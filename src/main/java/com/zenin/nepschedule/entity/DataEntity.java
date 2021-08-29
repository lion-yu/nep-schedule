package com.zenin.nepschedule.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;
import java.util.Date;
import java.util.List;

/**
 * @author 86227
 * @date 2021/8/29 20:48
 */
@Document
public class DataEntity {
    @Id
    private String id;
    @Field("asset_id")
    private String assetId;
    @Field("mod+id")
    private Integer modId;
    @Field("normal")
    private Boolean normal;
    @Field("failure")
    private Boolean failure;
    @Field("gateway_location_id")
    private String gatewayLocationId;
    @Field("upload_time")
    private Date uploadTime;
    @Field("pvg_id")
    private String pvgId;
    @Field("pvg_version")
    private Integer pvgVersion;
    @Field("status")
    private Integer status;
    @Field("status_desc")
    private String statusDesc;
    @Field("temperature")
    private Double temperature;
    @Field("energy_today")
    private Double energyToday;
    @Field("active_power")
    private Double activePower;
    @Field("energy_diff")
    private double energyDiff;
    @Field("pv_current")
    private Double pvCurrent;
    @Field("panels")
    private List<EachPanelData> panels;
    @Field("top_segment_accumulator")
    private Double topSegmentAccumulator;
    @Field("result")
    private Byte result;
    @Field("result_desc")
    private String resultDesc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public Integer getModId() {
        return modId;
    }

    public void setModId(Integer modId) {
        this.modId = modId;
    }

    public Boolean getNormal() {
        return normal;
    }

    public void setNormal(Boolean normal) {
        this.normal = normal;
    }

    public Boolean getFailure() {
        return failure;
    }

    public void setFailure(Boolean failure) {
        this.failure = failure;
    }

    public String getGatewayLocationId() {
        return gatewayLocationId;
    }

    public void setGatewayLocationId(String gatewayLocationId) {
        this.gatewayLocationId = gatewayLocationId;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getPvgId() {
        return pvgId;
    }

    public void setPvgId(String pvgId) {
        this.pvgId = pvgId;
    }

    public Integer getPvgVersion() {
        return pvgVersion;
    }

    public void setPvgVersion(Integer pvgVersion) {
        this.pvgVersion = pvgVersion;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getEnergyToday() {
        return energyToday;
    }

    public void setEnergyToday(Double energyToday) {
        this.energyToday = energyToday;
    }

    public Double getActivePower() {
        return activePower;
    }

    public void setActivePower(Double activePower) {
        this.activePower = activePower;
    }

    public double getEnergyDiff() {
        return energyDiff;
    }

    public void setEnergyDiff(double energyDiff) {
        this.energyDiff = energyDiff;
    }

    public Double getPvCurrent() {
        return pvCurrent;
    }

    public void setPvCurrent(Double pvCurrent) {
        this.pvCurrent = pvCurrent;
    }

    public List<EachPanelData> getPanels() {
        return panels;
    }

    public void setPanels(List<EachPanelData> panels) {
        this.panels = panels;
    }

    public Double getTopSegmentAccumulator() {
        return topSegmentAccumulator;
    }

    public void setTopSegmentAccumulator(Double topSegmentAccumulator) {
        this.topSegmentAccumulator = topSegmentAccumulator;
    }

    public Byte getResult() {
        return result;
    }

    public void setResult(Byte result) {
        this.result = result;
    }

    public String getResultDesc() {
        return resultDesc;
    }

    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }
}
