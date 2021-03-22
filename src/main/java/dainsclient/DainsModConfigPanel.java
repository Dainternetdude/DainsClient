package dainsclient;

import com.mumfrey.liteloader.Configurable;
import com.mumfrey.liteloader.client.gui.GuiCheckbox;
import com.mumfrey.liteloader.modconfig.AbstractConfigPanel;
import com.mumfrey.liteloader.modconfig.ConfigPanelHost;
import com.mumfrey.liteloader.util.log.LiteLoaderLogger;
import net.minecraft.client.resources.I18n;

/**
 * This is a simple example of adding a config panel to a mod. Your LiteMod
 * class should implement {@link Configurable} and return this class in order to
 * support the settings functionality of the mod panel.
 * 
 * @author Adam Mummery-Smith
 */
public class DainsModConfigPanel extends AbstractConfigPanel
{
    // Preserve references to the text field handles so we can read the values
    private ConfigTextField txtString, txtNumeric;
    
    /* (non-Javadoc)
     * @see com.mumfrey.liteloader.modconfig.ConfigPanel#getPanelTitle()
     */
    @Override
    public String getPanelTitle()
    {
        return I18n.format("dainsclient.config.title");
    }
    
    /* (non-Javadoc)
     * @see com.mumfrey.liteloader.modconfig.AbstractConfigPanel#addOptions(
     *      com.mumfrey.liteloader.modconfig.ConfigPanelHost)
     */
    @Override
    protected void addOptions(ConfigPanelHost host)
    {
        final LiteModDainsClient mod = host.<LiteModDainsClient>getMod();

        this.addControl(new GuiCheckbox(0, 0, 0, I18n.format("dainsclient.config.itemRefreshCooldown")), new ConfigOptionListener<GuiCheckbox>()
        {
            @Override
            public void actionPerformed(GuiCheckbox control)
            {
                DainsConfigs.setValueOfBooleanConfig("itemRefreshCooldown", !DainsConfigs.getValueOfBooleanConfig("itemRefreshCooldown"));
                control.checked = !control.checked;
            }
        }).checked = DainsConfigs.getValueOfBooleanConfig("itemRefreshCooldown");

        /*
        this.addControl(new GuiCheckbox(0, 0, 32, I18n.format("examplemod.config.option.enabled")), new ConfigOptionListener<GuiCheckbox>()
        {
            @Override
            public void actionPerformed(GuiCheckbox control)
            {
                mod.setClockVisibility(control.checked = !control.checked);
            }
        }).checked = mod.getClockVisibility();
         */
        
        //this.txtString = this.addTextField(2, 0, 50, 200, 20).setMaxLength(255);
        //this.txtNumeric = this.addTextField(3, 0, 75, 200, 20).setRegex("^[0-9]*$", false).setMaxLength(6);
    }

    private void addControl(GuiCheckbox guiCheckbox) {
    }

    @Override
    public void onPanelHidden()
    {
        // This example applies the changes immediately, however you may wish to
        // only save changes when the user clicks "save and close". In which
        // case you should apply your changes here
        
        
        // Code below shows how to read and handle the values out of the text
        // fields, what you do with the values is up to you.

        /*
        LiteLoaderLogger.info("Text field value was %s", this.txtString.getText());
        
        if (this.txtNumeric.isValid())
        {
            // Prefix 0 on the value since an empty string is valid, this saves
            // us having to special-case the string being empty. Alternatively
            // we could disallow empty strings in the validation regex.
            int intValue = Integer.parseInt("0" + this.txtNumeric.getText());
            LiteLoaderLogger.info("Numeric field value was %d", intValue);
        }
        else
        {
            LiteLoaderLogger.info("Numeric field value was not valid!");
        }
        */
    }
}
