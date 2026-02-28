package com.domovishche.gentweaker.mixin;

import com.domovishche.gentweaker.config.ModConfig;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenDoublePlant;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(WorldGenDoublePlant.class)
public class MixinBlockDoublePlant {

    // @Shadow lets us read a variable that exists in the vanilla class
    @Shadow private BlockDoublePlant.EnumPlantType plantType;

    @Inject(method = "generate", at = @At("HEAD"), cancellable = true)
    private void onGenerateDoublePlant(World worldIn, Random rand, BlockPos position, CallbackInfoReturnable<Boolean> cir) {
        if (this.plantType == null) return; // Safety check

        boolean shouldCancel = false;

        // Check which plant is about to generate and match it to your config
        switch (this.plantType) {
            case SUNFLOWER:
                shouldCancel = ModConfig.disableSunflowers;
                break;
            case SYRINGA: // Vanilla internal name for Lilac
                shouldCancel = ModConfig.disableLilac;
                break;
            case GRASS:
                shouldCancel = ModConfig.disableDoubleTallgrass;
                break;
            case FERN:
                shouldCancel = ModConfig.disableLargeFern;
                break;
            case ROSE:
                shouldCancel = ModConfig.disableRoseBush;
                break;
            case PAEONIA: // Vanilla internal name for Peony
                shouldCancel = ModConfig.disablePeony;
                break;
        }

        // If the config is set to true, cancel the generation
        if (shouldCancel) {
            cir.setReturnValue(false);
        }
    }
}
