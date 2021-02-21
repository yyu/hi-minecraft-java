package org.yuyuan.forge.mods.setup;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.yuyuan.forge.mods.TntGun;

import java.util.function.Supplier;

public class ModItems {
    private static final Logger LOGGER = LogManager.getLogger();

    public static final RegistryObject<Item> SILVER_INGOT = registerItem("silver_ingot", () ->
            new Item(new Item.Properties().group(ItemGroup.MATERIALS)));

    public static final RegistryObject<Item> TNT_GUN = registerItem("tnt_gun", () ->
            new TntGun(new Item.Properties().group(ItemGroup.MATERIALS)));

    static void register() {
        LOGGER.info("YYYYYYYYYY - {}", ModItems.class);
    }

    private static <T extends Item> RegistryObject<T> registerItem(String name, Supplier<T> itemSupplier) {
        LOGGER.info("YYYYYYYYYY - registering Item {}", name);
        return Registration.ITEMS.register(name, itemSupplier);
    }
}
