package com.tankmania.adminpanel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tankmania.common.config.Configuration;
import com.tankmania.common.service.AssetService;

import java.util.List;

public class TankManiaServices {

    private static AssetService assetService = Configuration.getInstance(AssetService.class);
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static String getAssets() {
        return gson.toJson(assetService.getAssets(), List.class);
    }

    public static void setAssets(String assets) {
        assetService.setAssets(assets);
    }
}
