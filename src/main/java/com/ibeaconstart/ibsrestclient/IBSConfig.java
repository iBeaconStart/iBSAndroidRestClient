package com.ibeaconstart.ibsrestclient;

import android.content.Context;

/**
 * Created by rgiurea on 03/06/15.
 */
public class IBSConfig {
    private String apiKey;

    public IBSConfig(Context context, String apiKey) {
        this.apiKey = apiKey;
    }

    public String getApiKey() {
        return apiKey;
    }

    public boolean isValid() {
        return apiKey != null &&
                !apiKey.equals("");
    }
}
