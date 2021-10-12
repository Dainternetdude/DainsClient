package dainsclient;

import com.mumfrey.liteloader.Configurable;
import com.mumfrey.liteloader.Tickable;
import com.mumfrey.liteloader.modconfig.ConfigPanel;
import com.mumfrey.liteloader.modconfig.ConfigStrategy;
import com.mumfrey.liteloader.modconfig.ExposableOptions;
import net.minecraft.client.Minecraft;

import java.io.File;

/**
 * Dainternetdude's custom client ported to Liteloader
 *
 * @author Dainternetdude
 */
@ExposableOptions(strategy = ConfigStrategy.Versioned, filename="dainsclient.json")
public class LiteModDainsClient implements Tickable, Configurable
{
    /**
     * This is a keybinding that we will register with the game and use to
     * toggle the clock
     * 
     * Notice that we specify the key name as an *unlocalised* string. The
     * localisation is provided from the included resource file.
     */
    // private static KeyBinding clockKeyBinding = new KeyBinding("key.clock.toggle", Keyboard.KEY_F12, "key.categories.litemods");

    /**
     * Default constructor. All LiteMods must have a default constructor. In
     * general you should do very little in the mod constructor EXCEPT for
     * initialising any non-game-interfacing components or performing sanity
     * checking prior to initialisation
     */
    public LiteModDainsClient() {
    }
    
    /**
     * getName() should be used to return the display name of your mod and MUST
     * NOT return null
     * 
     * @see com.mumfrey.liteloader.LiteMod#getName()
     */
    @Override
    public String getName()
    {
        return "DainsClient";
    }
    
    /**
     * getVersion() should return the same version string present in the mod
     * metadata, although this is not a strict requirement.
     * 
     * @see com.mumfrey.liteloader.LiteMod#getVersion()
     */
    @Override
    public String getVersion()
    {
        return "0.1.1";
    }
    
    @Override
    public Class<? extends ConfigPanel> getConfigPanelClass()
    {
        return DainsModConfigPanel.class;
    }
    
    /**
     * init() is called very early in the initialisation cycle, before the game
     * is fully initialised, this means that it is important that your mod does
     * not interact with the game in any way at this point.
     * 
     * @see com.mumfrey.liteloader.LiteMod#init(java.io.File)
     */
    @Override
    public void init(File configPath)
    {
        DainsConfigs.load();
        System.out.println("settings loaded");
    }
    
    /**
     * upgradeSettings is used to notify a mod that its version-specific
     * settings are being migrated
     * 
     * @see com.mumfrey.liteloader.LiteMod#upgradeSettings(java.lang.String,
     *         java.io.File, java.io.File)
     */
    @Override
    public void upgradeSettings(String version, File configPath, File oldConfigPath) {
    }

    /**
     * called each tick
    */
    @Override
    public void onTick(Minecraft minecraft, float partialTicks, boolean inGame, boolean clock) {
    }
}
