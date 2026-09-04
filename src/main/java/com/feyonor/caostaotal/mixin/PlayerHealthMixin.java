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
    
    @Inject(method = "tick", at = @At("HEAD"))
    private void onPlayerTick(CallbackInfo ci) {
        PlayerEntity player = (PlayerEntity)(Object)this;
        
        // Aplicar salud máxima al jugador
        if (player.getMaxHealth() != CaosConfig.PLAYER_MAX_HEALTH) {
            player.getAttributeInstance(net.minecraft.entity.attribute.EntityAttributes.GENERIC_MAX_HEALTH)
                .setBaseValue(CaosConfig.PLAYER_MAX_HEALTH);
            player.setHealth(CaosConfig.PLAYER_MAX_HEALTH);
        }
    }
}
