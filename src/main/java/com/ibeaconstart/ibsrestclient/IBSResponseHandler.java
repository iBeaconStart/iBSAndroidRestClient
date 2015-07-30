package com.ibeaconstart.ibsrestclient;

import com.ibeaconstart.ibsrestclient.model.IBSCampaign;
import com.ibeaconstart.ibsrestclient.model.IBSError;

import java.util.List;

/**
 * Created by rgiurea on 20/07/15.
 */
public interface IBSResponseHandler {

    void getAppCampainsSuccess(List<IBSCampaign> campains);
    void getAppCampainsFailed(IBSError error);

}
