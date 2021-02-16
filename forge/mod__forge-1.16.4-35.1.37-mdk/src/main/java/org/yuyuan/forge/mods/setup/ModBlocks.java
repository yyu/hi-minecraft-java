package org.yuyuan.forge.mods.setup;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Supplier;

public class ModBlocks {
    private static final Logger LOGGER = LogManager.getLogger();

    public static final RegistryObject<Block> SILVER_ORE = registerBlock("silver_ore", () ->
            new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(3, 10)
                    .harvestLevel(2)
                    .sound(SoundType.STONE)));
    public static final RegistryObject<Block> SILVER_BLOCK = registerBlock("silver_block", () ->
            new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(3, 10)
                    .sound(SoundType.METAL)));

    static void register() {
        LOGGER.info("YYYYYYYYYY - {}", ModBlocks.class);
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> blockSupplier) {
        LOGGER.info("YYYYYYYYYY - registering Block {}", name);
        RegistryObject<T> blockRegistry = Registration.BLOCKS.register(name, blockSupplier);

        LOGGER.info("YYYYYYYYYY - registering BlockItem {} (the Item for block {})", name, name);
        Registration.ITEMS.register(name, () ->
                new BlockItem(blockRegistry.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));

        return blockRegistry;
    }
}
