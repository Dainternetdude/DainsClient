package dainsclient.mixin;

import net.minecraft.client.renderer.ItemRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ItemRenderer.class)
public abstract class MixinItemRenderer
{
    @Redirect(method = "updateEquippedItem()V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/MathHelper;clamp(FFF)F", ordinal = 3))
    private float clamp(float num, float min, float max)
    {
        if(true)
        {
            return 100;
        }
        else
        {
            return 0;
        }
    }
}
