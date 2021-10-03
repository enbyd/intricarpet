package intricarpet.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.At;

import carpet.helpers.OptimizedExplosion;
import intricarpet.intricarpetRules;

@Mixin(OptimizedExplosion.class)
public class intricarpetOptimizedExplosionMixin
{
    @Inject(method = "doExplosionA", at = @At("HEAD"), cancellable = true)
    private static void cancelDoExplosionA(CallbackInfo ci)
    {
        if(intricarpetRules.optimizedTNTExtra) ci.cancel();
    }
}