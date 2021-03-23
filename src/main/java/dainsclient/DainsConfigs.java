package dainsclient;

public class DainsConfigs {

    public static boolean itemRefreshCooldown = true;
    public static boolean constantFOV = false;

    public static boolean getValueOfBooleanConfig(String configName) {

        // yeah i know you shouldn't do switch on a string especially not like this
        // @ me if you know how to do it properly I'll look into it for a future version
        switch(configName) {

            case "itemRefreshCooldown":
                return itemRefreshCooldown;
            case "constantFOV":
                return constantFOV;
        }
        return false;
    }

    public static void setValueOfBooleanConfig(String configName, boolean value) {

        // see getValueOfBooleanConfig()
        switch(configName) {

            case "itemRefreshCooldown":
                itemRefreshCooldown = value;
            case "constantFOV":
                constantFOV = value;
        }
    }
}
