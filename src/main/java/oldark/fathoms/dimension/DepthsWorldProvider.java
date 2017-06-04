package oldark.fathoms.dimension;

/**
 * Created by Oldark on 6/3/2017.
 */
import oldark.fathoms.ModDimensions;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkGenerator;

public class DepthsWorldProvider extends WorldProvider {

    @Override
    public DimensionType getDimensionType() {
        return ModDimensions.depthsDimensionType;
    }

    @Override
    public String getSaveFolder() {
        return "DEPTHS";
    }

    @Override
    public IChunkGenerator createChunkGenerator() {
        return new DepthsChunkGenerator(world);
    }
}