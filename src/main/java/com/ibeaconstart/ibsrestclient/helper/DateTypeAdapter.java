package com.ibeaconstart.ibsrestclient.helper;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by rgiurea on 20/07/15.
 */
public class DateTypeAdapter implements JsonSerializer<Date>, JsonDeserializer<Date> {
    private final static String DATE_FORMAT = "yyyy-MMM-dd HH:mm:ss";
    DateFormat df = new SimpleDateFormat(DATE_FORMAT);

    @Override
    public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
        String dateAsString = df.format(src);
        return new JsonPrimitive(dateAsString);
    }

    @Override
    public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        if (!(json instanceof JsonPrimitive)) {
            throw new JsonParseException("The date should be a string value");
        }

        try {
            return df.parse(json.getAsString());
        } catch (ParseException e) {
            throw new JsonParseException(e);
        }
    }

}
