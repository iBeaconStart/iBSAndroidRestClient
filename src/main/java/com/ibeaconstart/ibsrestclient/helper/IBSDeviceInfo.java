package com.ibeaconstart.ibsrestclient.helper;

import android.content.Context;
import android.provider.Settings;

/**
 * Created by rgiurea on 03/06/15.
 */
public class IBSDeviceInfo {
    private String deviceUniqueId;

    public IBSDeviceInfo(Context context) {
        this.deviceUniqueId = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    public String getUniqueDeviceId() {
        return deviceUniqueId;
    }
}
