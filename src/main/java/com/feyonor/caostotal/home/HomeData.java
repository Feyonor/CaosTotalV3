package com.feyonor.caostotal.home;

import com.google.gson.JsonObject;

public class HomeData {
    public String name;
    public double x;
    public double y;
    public double z;
    public String dimension;
    public long createdAt;

    public HomeData(String name, double x, double y, double z, String dimension, long createdAt) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.z = z;
        this.dimension = dimension;
        this.createdAt = createdAt;
    }

    public JsonObject toJson() {
        JsonObject json = new JsonObject();
        json.addProperty("name", name);
        json.addProperty("x", x);
        json.addProperty("y", y);
        json.addProperty("z", z);
        json.addProperty("dimension", dimension);
        json.addProperty("createdAt", createdAt);
        return json;
    }

    public static HomeData fromJson(JsonObject json) {
        return new HomeData(
            json.get("name").getAsString(),
            json.get("x").getAsDouble(),
            json.get("y").getAsDouble(),
            json.get("z").getAsDouble(),
            json.get("dimension").getAsString(),
            json.get("createdAt").getAsLong()
        );
    }
}
