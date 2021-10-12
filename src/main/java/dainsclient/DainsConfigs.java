package dainsclient;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DainsConfigs {

    //todo make wrapper for configs
    public static boolean itemRefreshCooldown = true;
    public static boolean constantFOV = false;
    public static boolean nearNetherFog = true;

    /**
     * saves configs to file
     */
    public static void save() {
        String configFile = "config/dainsclient.cfg";
        JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("itemRefreshCooldown", itemRefreshCooldown);
        jsonObject.addProperty("constantFOV", constantFOV);
        jsonObject.addProperty("nearNetherFog", nearNetherFog);

        try {
            FileWriter writer = new FileWriter(configFile);
            writer.write((new GsonBuilder().setPrettyPrinting().create()).toJson(jsonObject));
            writer.close();
        } catch (IOException e) {
            new File("config/").mkdirs();
        }
    }

    /**
     * loads configs from file
     */
    public static void load() {
        String configFile = "config/dainsclient.cfg";
        JsonParser jsonParser = new JsonParser();
        String json = "";
        try {
            json = new String(Files.readAllBytes(Paths.get(configFile)));
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        try {
            JsonElement jsonTree = jsonParser.parse(json);
            if (jsonTree.isJsonObject()) {
                JsonObject jsonObject = jsonTree.getAsJsonObject();

                itemRefreshCooldown = jsonObject.get("itemRefreshCooldown").getAsBoolean();
                constantFOV = jsonObject.get("constantFOV").getAsBoolean();
                nearNetherFog = jsonObject.get("nearNetherFog").getAsBoolean();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
