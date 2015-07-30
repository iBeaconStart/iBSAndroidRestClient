package com.ibeaconstart.ibsrestclient.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by rgiurea on 03/06/15.
 */
public class IBSAction {

    @Expose
    @SerializedName("Name")
    private String name;

    @Expose
    @SerializedName("Description")
    private String description;

    @Expose
    @SerializedName("StartDate")
    private String startDate;

    @Expose
    @SerializedName("EndDate")
    private String endDate;

    @Expose
    @SerializedName("Type")
    private String type;

    @Expose
    @SerializedName("Content")
    private String content;

    @Expose
    @SerializedName("BeaconId")
    private String beaconId;

    @Expose
    @SerializedName("Major")
    private String major;

    @Expose
    @SerializedName("Minor")
    private String minor;

    @Override
    public String toString() {
        return "Action{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", type='" + type + '\'' +
                ", content='" + content + '\'' +
                ", beaconId='" + beaconId + '\'' +
                ", major='" + major + '\'' +
                ", minor='" + minor + '\'' +
                '}';
    }
}
