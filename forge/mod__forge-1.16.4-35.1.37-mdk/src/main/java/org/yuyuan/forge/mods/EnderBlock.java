package org.yuyuan.forge.mods;

import net.minecraft.block.Block;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EnderBlock extends Block {
    private static final Logger LOGGER = LogManager.getLogger();

    public EnderBlock(Properties properties) {
        super(properties);
        this.setRegistryName("ender_block");
        // LOGGER.info("YYYYYYYYYY - getRegistryName(): {}", this.getRegistryName());
    }
}
