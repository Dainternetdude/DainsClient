package dainsclient.mixin;

import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiMainMenu.class)
public abstract class MixinGuiMainMenu extends GuiScreen
{
    @Shadow private float panoramaTimer;

    @Inject(method = "drawScreen(IIF)V", at = @At("HEAD"))
    private void onUpdateScreen(int mouseX, int mouseY, float partialTicks, CallbackInfo ci)
    {
        this.panoramaTimer += partialTicks * 6;
    }
}
