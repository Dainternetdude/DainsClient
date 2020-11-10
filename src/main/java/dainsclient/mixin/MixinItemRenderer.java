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
    @Redirect(method = "updateEquippedItem",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/ItemRenderer;clamp(F)F", ordinal = 2))
    private static int clamp(int num, int min, int max) {
        if(true)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
}
