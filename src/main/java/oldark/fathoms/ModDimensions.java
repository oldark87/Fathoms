package oldark.fathoms;

/**
 * Created by Oldark on 6/3/2017.
 */

import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;
import oldark.fathoms.dimension.DepthsWorldProvider;

public class ModDimensions {

    public static DimensionType testDimensionType;

    public static void init() {
        registerDimensionTypes();
        registerDimensions();
    }

    private static void registerDimensionTypes() {
        testDimensionType = DimensionType.register(FathomsMod.MOD_ID, "_depths", Config.dimensionId, DepthsWorldProvider.class, false);
    }

    private static void registerDimensions() {
        DimensionManager.registerDimension(Config.dimensionId, testDimensionType);
    }

}
