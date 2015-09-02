package com.ibeaconstart.ibsrestclient.model;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONException;

/**
 * Created by rgiurea on 28/08/15.
 */
public class IBSContent implements IBSTextContent{

    public enum Type {
        TEXT,
        MEDIA_IMAGE,
        MEDIA_VIDEO,
        URL_IN_APP,
        URL_DEFAULT_BROWSER,
        USER_DEFINED_JSON,
        USER_DEFINED_WEBPAGE,
        USER_DEFINED_XML
    }

    private String title;
    private String description;
    private Type type;
    private boolean triggeredWhenOffline;
    private String stringContent;
    private JsonObject jsonObjectContent;

    private String onClickUrl;
    private String offlineFallback;

    public String getTitle() {
        return title;
    }

    public void setTitle(JsonElement titleElement) {
        if(titleElement != null) {
            this.title = titleElement.getAsString();
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(JsonElement descriptionElement) {
        if(descriptionElement != null) {
            this.description = descriptionElement.getAsString();
        }
    }

    public Type getType() {
        return type;
    }

    public void setType(JsonElement typeElement) {
        if(typeElement == null) { //text
            type = Type.TEXT;

        } else { //all others
            String typeString = typeElement.getAsString();

            if(typeString.equals("image")) {
                type = Type.MEDIA_IMAGE;

            } else if(typeString.equals("video")) {
                type = Type.MEDIA_VIDEO;

            } else if(typeString.equals("in-app")) {
                type = Type.URL_IN_APP;

            } else if(typeString.equals("default-browser")) {
                type = Type.URL_DEFAULT_BROWSER;

            } else if(typeString.equals("json")) {
                type = Type.USER_DEFINED_JSON;

            } else if(typeString.equals("webpage")) {
                type = Type.USER_DEFINED_WEBPAGE;

            } else if(typeString.equals("xml")) {
                type = Type.USER_DEFINED_XML;

            }
        }
    }

    public boolean isTriggeredWhenOffline() {
        return triggeredWhenOffline;
    }

    public void setTriggeredWhenOffline(JsonElement triggeredWhenOfflineElement) {
        if(triggeredWhenOfflineElement != null) {
            this.triggeredWhenOffline = triggeredWhenOfflineElement.getAsBoolean();
        } else {
            this.triggeredWhenOffline = false;
        }
    }

    public String getStringContent() {
        return stringContent;
    }

    public JsonObject getJSONContent() {
        return jsonObjectContent;
    }

    public void setContent(JsonElement contentElement) {
        if(contentElement != null) {
            if(type == Type.USER_DEFINED_JSON) {
                this.jsonObjectContent = contentElement.getAsJsonObject();

            } else {
                this.stringContent = contentElement.getAsString();

            }
        }
    }

    public String getOnClickUrl() {
        return onClickUrl;
    }

    public void setOnClickUrl(JsonElement onClickUrlElement) {
        if(onClickUrlElement != null) {
            this.onClickUrl = onClickUrlElement.getAsString();
        }
    }

    public String getOfflineFallback() {
        return offlineFallback;
    }

    public void setOfflineFallback(JsonElement offlineFallbackElement) {
        if(offlineFallbackElement != null) {
            this.offlineFallback = offlineFallbackElement.getAsString();
        }
    }

    @Override
    public String toString() {
        return "IBSContent{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", triggeredWhenOffline=" + triggeredWhenOffline +
                ", stringContent='" + stringContent + '\'' +
                ", onClickUrl='" + onClickUrl + '\'' +
                ", offlineFallback='" + offlineFallback + '\'' +
                '}';
    }
}
