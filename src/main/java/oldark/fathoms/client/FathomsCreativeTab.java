package oldark.fathoms.client;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import oldark.fathoms.FathomsMod;
import oldark.fathoms.ModItems;

/**
 * Created by Oldark on 6/3/2017.
 */
public class FathomsCreativeTab extends CreativeTabs {

    public FathomsCreativeTab() {
        super(FathomsMod.MOD_ID);
    }

    @Override
    public ItemStack getTabIconItem(){
        return new ItemStack(ModItems.divingHelmet);
    }

}

