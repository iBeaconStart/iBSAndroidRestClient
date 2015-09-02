package com.ibeaconstart.ibsrestclient.helper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ibeaconstart.ibsrestclient.IBSConfig;
import com.ibeaconstart.ibsrestclient.model.IBSContent;
import com.ibeaconstart.ibsrestclient.requests.IBSCampaignsRequest;
import com.ibeaconstart.ibsrestclient.responses.IBSCampaignsResponse;
import com.ibeaconstart.ibsrestclient.responses.IBSCampainsResponseDeserializer;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by rgiurea on 03/06/15.
 */
public class IBSRequestFactory {

    private IBSDeviceInfo deviceInfo;
    private IBSConfig config;
    private Gson gson;

    public IBSRequestFactory(IBSConfig config, IBSDeviceInfo deviceInfo) {
        this.deviceInfo = deviceInfo;
        this.config = config;

        gson = new GsonBuilder()
                .registerTypeAdapter(IBSCampaignsResponse.class, new IBSCampainsResponseDeserializer())
                .registerTypeAdapter(IBSContent.class, new IBSContentDeserializer())
                .excludeFieldsWithoutExposeAnnotation()
                .create();

    }

    public Gson getGson() {
        return gson;
    }

    public IBSCampaignsRequest getFetchCampaignRequest(long lastUpdateTimestamp) {
        IBSCampaignsRequest request = new IBSCampaignsRequest(gson);

        request.setDeviceId(deviceInfo.getUniqueDeviceId());
        request.setAppId(config.getApiKey());
        request.setLastUpdate(lastUpdateTimestamp);

        return request;
    }
}
