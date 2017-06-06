package oldark.fathoms.item;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

/**
 * Created by Oldark on 6/3/2017.
 */
public class ItemDepthGauge extends ItemBase {

    public ItemDepthGauge(String name) {
        super(name);
    }

    /*
     * If player is in water below sea level depth is estimated by distance below sea level (sorry people swimming in cavern pools!)
     *  If player is above sea level, depth is calculated by the number of uninterrupted water blocks directly above their head.
     */
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn){

        if(playerIn.isInsideOfMaterial(Material.WATER)) {

            double depth = 0;
            double pressure;

            BlockPos blockPosition, playerPosition;

            blockPosition = playerPosition = playerIn.getPosition();
            blockPosition = blockPosition.add(0, 2, 0);  //this retrieves the block directly above player's head.
            IBlockState thisIBlock = worldIn.getBlockState(blockPosition);
            Block thisBlock = thisIBlock.getBlock();
            Block currentBlock = thisBlock;
            BlockPos currentBlockPosition = blockPosition;

            //Convert depth to pressure? 1 cm3 (block) of water is 1.422 psi
            //Basically every 10 blocks down will add 14.6 psi
            if(playerPosition.getY() > 60) {
                while (currentBlock.getUnlocalizedName().equals("tile.water")) {
                    depth++;
                    currentBlockPosition = currentBlockPosition.add(0, 1, 0);
                    thisIBlock = worldIn.getBlockState(currentBlockPosition);
                    currentBlock = thisIBlock.getBlock();
                }
            }
            else{
                depth = 60 - playerPosition.getY();
                BlockPos seaLevelBlockPos = new BlockPos(playerPosition.getX(), 62, playerPosition.getZ());
                Block seaLevelBlock = worldIn.getBlockState(seaLevelBlockPos).getBlock();
                while (seaLevelBlock.getUnlocalizedName().equals("tile.water")){
                    depth++;
                    seaLevelBlockPos = seaLevelBlockPos.add(0,1,0);
                    seaLevelBlock = worldIn.getBlockState(seaLevelBlockPos).getBlock();
                }
            }

            pressure = Math.round((depth * 1.422 * 100) * 10) / 10.0;
            playerIn.sendMessage(new TextComponentString("Relative Pressure: " + pressure + "psi."));

        }

        else{
            playerIn.sendMessage(new TextComponentString("Relative Pressure: 0 psi."));
        }

        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

}
