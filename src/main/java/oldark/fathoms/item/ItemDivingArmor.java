package oldark.fathoms.item;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import oldark.fathoms.FathomsMod;
import oldark.fathoms.ModItems;


/**
 * Created by Oldark on 6/3/2017.
 */

public class ItemDivingArmor extends ItemArmor implements ItemModelProvider {

        private String unlocalizedName;

        private static final double SPEED_MULT = 1.2;
        private static final double MAX_SPEED = 1.3;

        public ItemDivingArmor(ArmorMaterial material, EntityEquipmentSlot slot, String unlocalizedName) {
            super(material, 0, slot);
            setRegistryName(unlocalizedName);
            setUnlocalizedName(unlocalizedName);
            this.unlocalizedName = unlocalizedName;
            setCreativeTab(FathomsMod.CREATIVE_TAB);
        }

        @Override
        public void registerItemModel(Item item) {
            FathomsMod.proxy.registerItemRenderer(this, 0, unlocalizedName);
        }

        @SideOnly(Side.CLIENT)
        public void initModel() {
            ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
        }


        @Override
        public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack){
            if(player.isInsideOfMaterial(Material.WATER)) {

                //Diving Helmet see good
                if (itemStack.getItem() == ModItems.divingHelmet) {

                    PotionEffect effect = player.getActivePotionEffect(MobEffects.NIGHT_VISION);

                    if(effect == null || effect.getDuration() <= 201){
                        //this part makes bad crashy
//                    if(effect.getDuration() < 190){
//                        player.removePotionEffect(MobEffects.NIGHT_VISION);
//                    }
//                    else {
                        PotionEffect neweffect = new PotionEffect(MobEffects.NIGHT_VISION, 220, 0, true, true);
                        player.addPotionEffect(neweffect);
//                    }
                    }
                /*
                You probably just want to hook PlayerTickEvent and check if the helment isn't warn to remove the effect(edited)
                 */
                }

                //Flippers let you swim fast
                if (itemStack.getItem() == ModItems.divingFins){

                    double motionX = player.motionX * SPEED_MULT;
                    double motionY = player.motionY * SPEED_MULT;
                    double motionZ = player.motionZ * SPEED_MULT;

                    if(Math.abs(motionX) < MAX_SPEED)
                        player.motionX = motionX;
                    if(Math.abs(motionY) < MAX_SPEED)
                        player.motionY = motionY;
                    if(Math.abs(motionZ) < MAX_SPEED)
                        player.motionZ = motionZ;

                }
            }
        }

}
