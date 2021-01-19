package dainsclient.mixin;

import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import sun.reflect.generics.tree.ReturnType;
import net.minecraft.util.math.MathHelper;

import java.util.Objects;

@Mixin(ItemRenderer.class)
public abstract class MixinItemRenderer {
    @Redirect(method = "updateEquippedItem()V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/MathHelper;clamp(FFF)F", ordinal = 3))
    private static float clamp(float num, float min, float max) {
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
