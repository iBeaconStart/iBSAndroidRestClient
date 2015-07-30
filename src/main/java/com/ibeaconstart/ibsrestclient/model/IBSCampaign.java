package com.ibeaconstart.ibsrestclient.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rgiurea on 03/06/15.
 */
public class IBSCampaign {
    @Expose
    @SerializedName("Name")
    private String name;

    @Expose
    @SerializedName("Description")
    private String description;

    @Expose
    @SerializedName("GId")
    private String gid;

    @Expose
    @SerializedName("DateAdded")
    private String dateAdded;

    @Expose
    @SerializedName("Actions")
    private List<IBSAction> actions = new ArrayList<IBSAction>();

    @Override
    public String toString() {
        return "IBSCampaign{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", gid='" + gid + '\'' +
                ", dateAdded='" + dateAdded + '\'' +
                ", actions=" + actions +
                '}';
    }
}
