package com.ibeaconstart.ibsrestclient.model;

/**
 * Created by rgiurea on 20/07/15.
 */
public enum IBSServerReason {
    UNKNOWN("UNKNOWN");

    private String serverReason;
    IBSServerReason (String serverReason) {
        this.serverReason = serverReason;
    }

    public String getValue() {
        return serverReason;
    }


    public static IBSServerReason fromString(String reasonString) {
        for(IBSServerReason v : values()) {
            if(v.getValue().equalsIgnoreCase(reasonString)) {
                return v;
            }
        }

        return UNKNOWN;
    }
}
