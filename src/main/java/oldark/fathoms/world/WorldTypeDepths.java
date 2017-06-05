package oldark.fathoms.world;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.gen.ChunkProviderFlat;
import net.minecraft.world.gen.ChunkProviderSettings;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerBiome;
import net.minecraft.world.gen.layer.GenLayerBiomeEdge;
import net.minecraft.world.gen.layer.GenLayerZoom;

import javax.annotation.Nonnull;

/**
 * Created by Oldark on 6/4/2017.
 */
public class WorldTypeDepths extends WorldType {

    public WorldTypeDepths(String name){
        super(name);
    }

//    public GenLayer getBiomeLayer(long worldSeed, GenLayer parentLayer, ChunkProviderSettings chunkProviderSettings) {
//
//        GenLayer ret = new DepthsGenLayerBiome(200L, parentLayer, this, chunkProviderSettings);
//        ret = GenLayerZoom.magnify(1000L, ret, 2);
//        ret = new GenLayerBiomeEdge(1000L, ret);
//        return ret;
//
//    }

    @Nonnull
    @Override
    public IChunkGenerator getChunkGenerator(@Nonnull World world, String generatorOptions) {
        ChunkProviderFlat flat = new ChunkProviderFlat(world, world.getSeed(), false, "3;minecraft:bedrock,100*minecraft:water;2*minecraft:bedrock;biome_1,oceanmonument;");
        world.setSeaLevel(64);
        return flat;
    }

}
