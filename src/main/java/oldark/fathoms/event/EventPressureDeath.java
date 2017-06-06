package oldark.fathoms.event;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import oldark.fathoms.ModItems;
import oldark.fathoms.item.ItemDivingArmor;

/**
 * Created by Oldark on 6/5/2017.
 * Contains events for dieing due to water pressure as well as cause faster drowning.
 */
@Mod.EventBusSubscriber
public class EventPressureDeath {

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {

        EntityPlayer playerIn = event.player;

        if(playerIn.isInsideOfMaterial(Material.WATER)) {

            double pressure;
            double depth = 0;
            World worldIn = playerIn.world;
            BlockPos blockPosition, playerPosition;

            blockPosition = playerPosition = playerIn.getPosition();
            blockPosition = blockPosition.add(0, 2, 0);  //this retrieves the block directly above player's head.
            IBlockState thisIBlock = worldIn.getBlockState(blockPosition);
            Block thisBlock = thisIBlock.getBlock();
            Block currentBlock = thisBlock;
            BlockPos currentBlockPosition = blockPosition;

            //Convert depth to pressure? 1 cm3 (block) of water is 1.422 psi
            //Basically every 10 blocks down will add 14.6 psi
            if (playerPosition.getY() > 60) {
                while (currentBlock.getUnlocalizedName().equals("tile.water")) {
                    depth++;
                    currentBlockPosition = currentBlockPosition.add(0, 1, 0);
                    thisIBlock = worldIn.getBlockState(currentBlockPosition);
                    currentBlock = thisIBlock.getBlock();
                }
            } else {
                depth = 60 - playerPosition.getY();
                BlockPos seaLevelBlockPos = new BlockPos(playerPosition.getX(), 62, playerPosition.getZ());
                Block seaLevelBlock = worldIn.getBlockState(seaLevelBlockPos).getBlock();
                while (seaLevelBlock.getUnlocalizedName().equals("tile.water")) {
                    depth++;
                    seaLevelBlockPos = seaLevelBlockPos.add(0, 1, 0);
                    seaLevelBlock = worldIn.getBlockState(seaLevelBlockPos).getBlock();
                }
            }
            pressure = Math.round((depth * 1.422 * 100) * 10) / 10.0;
            //Unaided, human beings can withstand 3-4 atm of pressure or 43.5-59 psi. In this case steve has to be  a
            //bit of a weakling or we'll run out of depth to play with
            if (pressure > 45) {
                if(!(playerIn.inventory.armorItemInSlot(2) != null && playerIn.inventory.armorItemInSlot(1) != null
                       && playerIn.inventory.armorItemInSlot(2).getItem() == ModItems.divingSuit
                       && playerIn.inventory.armorItemInSlot(1).getItem() == ModItems.divingSuitPants)){
                    playerIn.setHealth(0.0F);
                }

            }
        }
    }

    @SubscribeEvent
    public void onLivingUpdate(LivingEvent.LivingUpdateEvent event){
        if (event.getEntity() instanceof EntityPlayer){
            if (!event.getEntity().world.isRemote){
                //such more air out every 5 time increments
                if (event.getEntity().world.getWorldTime() % 5 == 0){
                    EntityPlayer player = (EntityPlayer)event.getEntity();

                    //if player still has air, lets suck some out of em
                    if (player.getAir() > 0){
                        player.setAir(player.getAir() - 30);
                    }
                }
            }
        }
    }
}
