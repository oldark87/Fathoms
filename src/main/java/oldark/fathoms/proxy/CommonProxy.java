package oldark.fathoms.proxy;

/**
 * Created by Oldark on 6/3/2017.
 */
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.registry.GameRegistry;
import oldark.fathoms.*;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import oldark.fathoms.ModBlocks;
import oldark.fathoms.world.DepthsWorldGenerator;
import oldark.fathoms.world.FathomsBiomeRegistry;

import java.io.File;


public class CommonProxy {

    public static Configuration config;


    public void preInit(FMLPreInitializationEvent e) {

        File directory = e.getModConfigurationDirectory();
        config = new Configuration(new File(directory.getPath(), "modtut.cfg"));
        Config.readConfig();

        // Initialization of blocks and items typically goes here:
        ModItems.init();
        ModBlocks.init();
        FathomsBiomeRegistry.mainRegistry();
        ModDimensions.init();

    }

    public void registerItemRenderer(Item item, int meta, String id) {

    }

    public void registerBlockRenderer(Block block, int meta, String id) {

    }

    public void init(FMLInitializationEvent e) {
//        NetworkRegistry.INSTANCE.registerGuiHandler(ModTut.instance, new GuiProxy());
        GameRegistry.registerWorldGenerator(new DepthsWorldGenerator(), 0);
    }

    public void postInit(FMLPostInitializationEvent e) {
        if (config.hasChanged()) {
            config.save();
        }
    }
}

