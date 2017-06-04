package oldark.fathoms;

/**
 * Created by Oldark on 6/3/2017.
 */
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;
import oldark.fathoms.item.ItemBase;
import oldark.fathoms.item.ItemDepthGauge;
import oldark.fathoms.item.ItemDivingArmor;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static net.minecraftforge.fml.common.registry.GameRegistry.register;

public class ModItems {

    public static ItemArmor.ArmorMaterial divingSuitMaterial = EnumHelper.addArmorMaterial("DIVINGMATERIAL", "fathoms:divingsuittexture", 12,
            new int[]{1, 4, 5, 1}, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);

    public static ItemDivingArmor divingHelmet;
    public static ItemDivingArmor divingFins;
    public static ItemDepthGauge depthGauge;

    public static void init() {

        divingHelmet = register(new ItemDivingArmor(divingSuitMaterial, EntityEquipmentSlot.HEAD, "diving_helmet"));
        divingFins = register(new ItemDivingArmor(divingSuitMaterial, EntityEquipmentSlot.FEET, "diving_fins"));
        depthGauge = register(new ItemDepthGauge("depth_gauge"));
    }

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        divingHelmet.initModel();
        divingFins.initModel();
        depthGauge.initModel();
    }

}
