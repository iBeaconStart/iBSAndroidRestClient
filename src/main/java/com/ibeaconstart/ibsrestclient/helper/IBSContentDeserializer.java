package com.ibeaconstart.ibsrestclient.helper;


import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.ibeaconstart.ibsrestclient.model.IBSContent;

import java.lang.reflect.Type;

/**
 * Created by rgiurea on 01/09/15.
 */
public class IBSContentDeserializer implements JsonDeserializer<IBSContent> {

    @Override
    public IBSContent deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        IBSContent content = new IBSContent();
        JsonObject obj = json.getAsJsonObject();

        content.setType(obj.get("Type"));
        content.setTitle(obj.get("Title"));
        content.setDescription(obj.get("Description"));
        content.setTriggeredWhenOffline(obj.get("TriggerWhenOffline"));
        content.setOnClickUrl(obj.get("OnClickUrl"));
        content.setOfflineFallback(obj.get("OfflineFallback"));
        content.setContent(obj.get("Content"));

        return  content;
    }
}
