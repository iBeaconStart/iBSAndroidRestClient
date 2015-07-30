package com.ibeaconstart.ibsrestclient;

import android.content.Context;
import android.util.Log;

import com.ibeaconstart.ibsrestclient.helper.IBSBackendService;
import com.ibeaconstart.ibsrestclient.helper.IBSDeviceInfo;
import com.ibeaconstart.ibsrestclient.helper.IBSRequestFactory;
import com.ibeaconstart.ibsrestclient.model.IBSError;
import com.ibeaconstart.ibsrestclient.model.IBSErrorType;
import com.ibeaconstart.ibsrestclient.model.IBSServerReason;
import com.ibeaconstart.ibsrestclient.requests.IBSCampaignsRequest;
import com.ibeaconstart.ibsrestclient.responses.IBSCampaignsResponse;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.converter.GsonConverter;

/**
 * Created by rgiurea on 20/07/15.
 */
public class IBSRestClient {

    private IBSRequestFactory requestFactory;
    private IBSBackendService backendService;

    public IBSRestClient(Context context, String apiKey) {
        IBSConfig config = new IBSConfig(context, apiKey);
        IBSDeviceInfo deviceInfo = new IBSDeviceInfo(context);

        requestFactory = new IBSRequestFactory(config, deviceInfo);

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://ibeacon.breakingpoint.ro")
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setLog(new RestAdapter.Log() {
                    public void log(String msg) {
                        Log.i("retrofit", msg);
                    }
                })
                .setConverter(new GsonConverter(requestFactory.getGson()))
                .build();

        backendService = restAdapter.create(IBSBackendService.class);
    }

    public void getAppCampains(long lastUpdateTimestamp, final IBSResponseHandler handler) {
        IBSCampaignsRequest request = requestFactory.getFetchCampaignRequest(lastUpdateTimestamp);

        backendService.getAppCampaigns(request, new Callback<IBSCampaignsResponse>() {
            @Override
            public void success(IBSCampaignsResponse ibsResponse, Response response) {
                if(ibsResponse.isSuccess()) {
                    handler.getAppCampainsSuccess(ibsResponse.getCampaigns());

                } else {
                    IBSError error = new IBSError(IBSServerReason.fromString(ibsResponse.getErrorMessage()));
                    handler.getAppCampainsFailed(error);

                }
            }

            @Override
            public void failure(RetrofitError error) {
                IBSError ibsError = new IBSError(IBSErrorType.fromKind(error.getKind()), error.getMessage());
                handler.getAppCampainsFailed(ibsError);
            }
        });
    }

}
