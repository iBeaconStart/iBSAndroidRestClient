package com.ibeaconstart.ibsrestclient.responses;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.ibeaconstart.ibsrestclient.model.IBSCampaign;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by rgiurea on 20/07/15.
 */
public class IBSCampainsResponseDeserializer implements JsonDeserializer<IBSCampaignsResponse> {

    @Override
    public IBSCampaignsResponse deserialize(JsonElement json, Type type,
                                            JsonDeserializationContext context) throws JsonParseException {

        JsonObject jObject = json.getAsJsonObject();
        String statusString = jObject.get("response").getAsString();

        if(statusString.equals("error")) {
            String errorMsg = jObject.get("data").getAsString();
            return new IBSCampaignsResponse(errorMsg);

        } else if(statusString.equals("ok")) {
            JsonArray campainsJson = jObject.get("data").getAsJsonArray();
            Type listType = new TypeToken<List<IBSCampaign>>(){}.getType();
            List<IBSCampaign> campains = context.deserialize(campainsJson, listType);
            return new IBSCampaignsResponse(campains);

        } else {
            return new IBSCampaignsResponse("INVALID_SERVER_RESPONSE");

        }
    }

}
