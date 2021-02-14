package org.yuyuan.forge.mods;

import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SpawnAlert {
    private static final Logger LOGGER = LogManager.getLogger();

    public SpawnAlert() {
        LOGGER.info("YYYYYYYYYY - {}", this.getClass());
    }

    @SubscribeEvent
    public void onEntityJoinWorldEvent(EntityJoinWorldEvent event) {
        if (!(event.getEntity() instanceof EnderDragonEntity)) {
            return;
        }

        for (PlayerEntity player : event.getWorld().getPlayers()) {
            LOGGER.info("YYYYYYYYYY - {} (is{} remote)", player, event.getWorld().isRemote ? "" : " not");

            if (event.getWorld().isRemote) {
                String msg = TextFormatting.GREEN + "Dragon!!! Dragon!!!!!";
                LOGGER.info("YYYYYYYYYY - sending message '{}' to {}", msg, player);
                player.sendStatusMessage(new StringTextComponent(msg), false);
            }
        }
    }
}
