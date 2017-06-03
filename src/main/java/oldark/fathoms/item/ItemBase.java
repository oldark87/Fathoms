package oldark.fathoms.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import oldark.fathoms.FathomsMod;

/**
 * Created by Oldark on 6/3/2017.
 */
public class ItemBase extends Item implements ItemModelProvider {

    protected String name;

    public ItemBase(String name) {
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);

        setCreativeTab(FathomsMod.CREATIVE_TAB);
    }

    @Override
    public void registerItemModel(Item item) {
        FathomsMod.proxy.registerItemRenderer(item, 0, name);
    }

    @Override
    public ItemBase setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }

}
