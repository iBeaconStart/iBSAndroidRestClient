package com.ibeaconstart.ibsrestclient.model;

/**
 * Created by rgiurea on 20/07/15.
 */
public class IBSError {

    private IBSErrorType errorType;
    private IBSServerReason serverReason; //Only valid if IBSErrorType == SERVER
    private String message;

    public IBSError(IBSErrorType errorType, String message) {
        this.errorType = errorType;
        this.message = message;
        this.serverReason = IBSServerReason.UNKNOWN;
    }

    public IBSError(IBSServerReason serverReason) {
        this.errorType = IBSErrorType.SERVER;
        this.message = null;
        this.serverReason = serverReason;
    }

    public IBSErrorType getErrorType() {
        return errorType;
    }

    public IBSServerReason getServerReason() {
        return serverReason;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "IBSError{" +
                "errorType=" + errorType +
                ", serverReason=" + serverReason +
                ", message='" + message + '\'' +
                '}';
    }
}
