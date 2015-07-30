package com.ibeaconstart.ibsrestclient.helper;


import com.ibeaconstart.ibsrestclient.requests.IBSCampaignsRequest;
import com.ibeaconstart.ibsrestclient.responses.IBSCampaignsResponse;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by rgiurea on 01/06/15.
 */

public interface IBSBackendService {

    @FormUrlEncoded
    @POST("/api/returnAppCampaigns")
    void getAppCampaigns(@Field("data") IBSCampaignsRequest requestData, Callback<IBSCampaignsResponse> response);

}
