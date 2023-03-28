package org.shootingstar;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Slf4j
@Singleton
public class ShootingStarsDataManager
{
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    @Inject
    private OkHttpClient okHttpClient;

    @Inject
    private Gson gson;

    @Inject
    private ShootingStarsPlugin plugin;

    private List<Object> data = new ArrayList<>();

    public void storeEvent(Object event)
    {
        synchronized (this)
        {
            data.add(event);
        }
    }

    private ArrayList<ShootingStarsData> parseData(JsonArray j)
    {
        ArrayList<ShootingStarsData> l = new ArrayList<>();
        for (JsonElement jsonElement : j)
        {
            JsonObject jObj = jsonElement.getAsJsonObject();
            ShootingStarsData d = new ShootingStarsData(ShootingStarsLocation.getLocation(jObj.get("location").getAsInt()),
                    jObj.get("world").getAsInt(), jObj.get("minTime").getAsLong(), jObj.get("maxTime").getAsLong());
            l.add(d);
        }
        return l;
    }


}