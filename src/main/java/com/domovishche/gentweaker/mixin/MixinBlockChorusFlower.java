package com.domovishche.gentweaker.mixin;

import net.minecraft.block.BlockChorusFlower;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

// Import your config class
import com.domovishche.gentweaker.config.ModConfig;

@Mixin(BlockChorusFlower.class)
public class MixinBlockChorusFlower {

    /**
     * This vanilla method is strictly used during World Generation
     * to spawn the Chorus structures on End Islands.
     */
    @Inject(method = "generatePlant", at = @At("HEAD"), cancellable = true)
    private static void onGeneratePlant(World worldIn, BlockPos pos, Random rand, int p_185603_4_, CallbackInfo ci) {

        // 1 is the Dimension ID for The End.
        // We check this so we don't accidentally break other mods if they try to spawn Chorus in the Overworld.
        if (ModConfig.disableChorusPlants && worldIn.provider.getDimension() == 1) {

            // Cancels the method before it can place any blocks
            ci.cancel();
        }
    }
}
