package oldark.fathoms.proxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import oldark.fathoms.FathomsMod;
import oldark.fathoms.ModBlocks;
import oldark.fathoms.ModItems;

/**
 * Created by Oldark on 6/3/2017.
 */
public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);

        OBJLoader.INSTANCE.addDomain(FathomsMod.MOD_ID);

        // Typically initialization of models and such goes here:

        ModItems.initModels();
//        ModEntities.initModels();
    }

    @Override
    public void registerItemRenderer(Item item, int meta, String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(FathomsMod.MOD_ID+ ":" + id, "inventory"));
    }


    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);

        // Initialize our input handler so we can listen to keys
//        MinecraftForge.EVENT_BUS.register(new InputHandler());
//        KeyBindings.init();

//        ModBlocks.initItemModels();
    }
}