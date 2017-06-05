package oldark.fathoms.world;

/**
 * Created by Oldark on 6/4/2017.
 */

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import oldark.fathoms.Config;

public class FathomsBiomeRegistry {

    public static void mainRegistry(){
        initalizeBiome();
        registerBiome();
    }

    public static Biome depthsBiome;
    public static final int depthsBiomeId = Config.depthsBiomeId;

    public static void initalizeBiome(){
        depthsBiome = new BiomeDepths(new Biome.BiomeProperties("Depths").setBaseHeight(-1.8F).setHeightVariation(0.1F));
        Biome.registerBiome(depthsBiomeId, "Depths", depthsBiome);
    }

    public static void registerBiome(){
        Biome.registerBiome(depthsBiomeId, "Depths", depthsBiome);
    }

}


