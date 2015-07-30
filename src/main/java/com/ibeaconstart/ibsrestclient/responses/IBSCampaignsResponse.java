package com.ibeaconstart.ibsrestclient.responses;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.ibeaconstart.ibsrestclient.model.IBSCampaign;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by rgiurea on 01/06/15.
 */
public class IBSCampaignsResponse {

    private boolean success;
    private String errorMessage;
    private List<IBSCampaign> campaigns;


    public IBSCampaignsResponse(String errorMessage) {
        this.success = false;
        this.errorMessage = errorMessage;
    }

    public IBSCampaignsResponse(List<IBSCampaign> campaigns) {
        this.success = campaigns != null;
        this.campaigns = campaigns;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public List<IBSCampaign> getCampaigns() {
        return campaigns;
    }

    @Override
    public String toString() {
        return "IBSCampaignsResponse{" +
                "success=" + success +
                ", errorMessage='" + errorMessage + '\'' +
                ", campaigns=" + campaigns +
                '}';
    }
}
