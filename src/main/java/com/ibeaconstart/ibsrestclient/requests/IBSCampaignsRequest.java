package com.ibeaconstart.ibsrestclient.requests;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by rgiurea on 01/06/15.
 */
public class IBSCampaignsRequest {
    private Gson gson;

    @Expose
    @SerializedName("udid")
    private String deviceId;

    @Expose
    @SerializedName("app_id")
    private String appId;

    @Expose
    @SerializedName("event_time")
    private long eventTime;

    @Expose
    @SerializedName("last_update")
    private long lastUpdate;

    public IBSCampaignsRequest(Gson gson) {
        this.gson = gson;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public void setEventTime(long eventTime) {
        this.eventTime = eventTime;
    }

    public void setLastUpdate(long lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getAppId() {
        return appId;
    }

    public long getEventTime() {
        return eventTime;
    }

    public long getLastUpdate() {
        return lastUpdate;
    }

    @Override
    public String toString() {
        return gson.toJson(this);
    }
}
