package oldark.fathoms;

/**
 * Created by Oldark on 6/3/2017.
 */

import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;
import oldark.fathoms.dimension.DepthsWorldProvider;

public class ModDimensions {

    public static DimensionType depthsDimensionType;

    public static void init() {
        registerDimensionTypes();
        registerDimensions();
    }

    private static void registerDimensionTypes() {
        depthsDimensionType = DimensionType.register(FathomsMod.MOD_ID, "_depths", Config.dimensionId, DepthsWorldProvider.class, false);
    }

    private static void registerDimensions() {

        //These two lines for testing purposes, show dimension ID for depths in console.
        System.out.println("Whatever Text");
        System.out.println(Config.dimensionId);

        DimensionManager.registerDimension(Config.dimensionId, depthsDimensionType);
    }

}
