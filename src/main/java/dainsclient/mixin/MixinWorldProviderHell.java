package dainsclient.mixin;

import dainsclient.DainsConfigs;
import net.minecraft.world.WorldProviderHell;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WorldProviderHell.class)
public abstract class MixinWorldProviderHell {

    @Inject(method = "doesXZShowFog",
            at = @At(value = "HEAD"), cancellable = true)
    public void mixin(int x, int z, CallbackInfoReturnable<Boolean> callbackInfoReturnable  )
    {
        if(!DainsConfigs.nearNetherFog) {
            callbackInfoReturnable.setReturnValue(false);
        }
    }
}
