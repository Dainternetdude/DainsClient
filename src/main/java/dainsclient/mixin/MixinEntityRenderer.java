package dainsclient.mixin;

import dainsclient.DainsConfigs;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(EntityRenderer.class)
public abstract class MixinEntityRenderer implements IResourceManagerReloadListener
{
    @Shadow @Final private Minecraft mc;

    @ModifyVariable(method = "getFOVModifier(FZ)F",
            at = @At(value = "STORE", ordinal = 2),
            ordinal = 1)
    private float fmixin(float f) {
        return DainsConfigs.constantFOV ? this.mc.gameSettings.fovSetting : f;
    }
}
