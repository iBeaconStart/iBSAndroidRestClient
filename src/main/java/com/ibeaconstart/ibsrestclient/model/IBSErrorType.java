package com.ibeaconstart.ibsrestclient.model;

import java.io.IOException;

import retrofit.RetrofitError;

/**
 * Created by rgiurea on 20/07/15.
 */
public enum IBSErrorType {

    /** An {@link IOException} occurred while communicating to the server. */
    NETWORK("NETWORK"),
    /** An exception was thrown while (de)serializing a body. */
    CONVERSION("CONVERSION"),
    /** A non-200 HTTP status code was received from the server. */
    HTTP("HTTP"),
    /** An unsuccessful response was returned from the server **/
    SERVER("SERVER"),
    /**
     * An internal error occurred while attempting to execute a request. It is best practice to
     * re-throw this exception so your application crashes.
     */
    UNEXPECTED("UNEXPECTED"),
    /** Should never occure, only fromString() or fromKind() failes **/
    UNKNOWN("UNKNOWN");

    private String typeString;

    IBSErrorType(String typeString) {
        this.typeString = typeString;
    }

    public String getValue() {
        return typeString;
    }

    public static IBSErrorType fromString(String typeString) {
        for(IBSErrorType v : values()) {
            if(v.getValue().equalsIgnoreCase(typeString)) {
                return v;
            }
        }

        return UNKNOWN;
    }

    public static IBSErrorType fromKind(RetrofitError.Kind kind) {
        for(IBSErrorType v : values()) {
            if(v.getValue().equalsIgnoreCase(kind.toString())) {
                return v;
            }
        }

        return UNKNOWN;
    }
}
