package com.feyonor.caostaotal.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.callback.CallbackInfo;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import com.feyonor.caostaotal.config.CaosConfig;

@Mixin(PlayerEntity.class)
public class PlayerHealthMixin {
    @Inject(method = "<init>", at = @At("TAIL"))
    private void onPlayerInit(CallbackInfo ci) {
        PlayerEntity player = (PlayerEntity)(Object)this;
        player.setHealth(CaosConfig.PLAYER_MAX_HEALTH);
        ((LivingEntity)(Object)player).setMaxHealth(CaosConfig.PLAYER_MAX_HEALTH);
    }
}