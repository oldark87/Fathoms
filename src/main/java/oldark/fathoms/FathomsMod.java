package oldark.fathoms;

/**
 * Created by Oldark on 6/3/2017.
 */

import net.minecraft.world.WorldType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import oldark.fathoms.client.FathomsCreativeTab;
import oldark.fathoms.commands.TeleportCommand;
import oldark.fathoms.proxy.CommonProxy;

import oldark.fathoms.world.WorldTypeDepths;
import org.apache.logging.log4j.Logger;

@Mod(modid = FathomsMod.MOD_ID, name = FathomsMod.MOD_NAME, version = FathomsMod.VERSION)
public class FathomsMod {

    public static final String MOD_ID = "fathoms";
    public static final String MOD_NAME = "Fathoms";
    public static final String VERSION = "0.0.1";
    public static final FathomsCreativeTab CREATIVE_TAB = new FathomsCreativeTab();
    public static Logger logger;

    @Mod.Instance(MOD_ID)
    public static FathomsMod instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        System.out.println(MOD_NAME + " is loading!");
        logger = event.getModLog();
        proxy.preInit(event);

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        WorldType DEPTHS = new WorldTypeDepths("depths");
    }

    @SidedProxy(clientSide = "oldark.fathoms.proxy.ClientProxy", serverSide = "oldark.fathoms.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
        event.registerServerCommand(new TeleportCommand());
    }
}