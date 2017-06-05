package oldark.fathoms.world;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

/**
 * Created by Oldark on 6/4/2017.
 */
public class BiomeDepths extends Biome {

    public BiomeDepths(BiomeProperties properties){
        super(properties);
        this.topBlock = Blocks.WATER.getDefaultState();
        this.fillerBlock = Blocks.WATER.getDefaultState();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
    }
    

}
