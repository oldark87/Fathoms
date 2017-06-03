package oldark.fathoms.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

/**
 * Created by Oldark on 6/3/2017.
 */
public class ItemDepthGauge extends ItemBase {

    public ItemDepthGauge(String name) {
        super(name);
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn){
        playerIn.sendMessage(new TextComponentString("Your depth is amazingly indeterminate!"));
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
