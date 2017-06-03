package oldark.fathoms.proxy;

/**
 * Created by Oldark on 6/3/2017.
 */
import net.minecraft.item.Item;
import oldark.fathoms.*;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


public class CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {

        // Initialization of blocks and items typically goes here:
        ModItems.init();

    }

    public void registerItemRenderer(Item item, int meta, String id) {

    }

    public void init(FMLInitializationEvent e) {
//        NetworkRegistry.INSTANCE.registerGuiHandler(ModTut.instance, new GuiProxy());
    }

    public void postInit(FMLPostInitializationEvent e) {

    }
}

