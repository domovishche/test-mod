package com.domovishche.gentweaker.config;

import net.minecraftforge.common.config.Config;

@Config(modid = "gentweaker", name = "gentweakerconfig")
public class ModConfig {

    @Config.Comment("Set to true to disable the generation of Chorus Plants in The End")
    public static boolean disableChorusPlants = true;

    @Config.Comment("Set to true to disable Sunflowers generation")
    public static boolean disableSunflowers = true;

    @Config.Comment("Set to true to disable Lilac generation")
    public static boolean disableLilac = true;

    @Config.Comment("Set to true to disable Double Tallgrass generation")
    public static boolean disableDoubleTallgrass = false;

    @Config.Comment("Set to true to disable Large Fern generation")
    public static boolean disableLargeFern = false;

    @Config.Comment("Set to true to disable Rose Bush generation")
    public static boolean disableRoseBush = true;

    @Config.Comment("Set to true to disable Peony generation")
    public static boolean disablePeony = true;
}
