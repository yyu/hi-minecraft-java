package org.yuyuan.forge.mods;

import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.item.TNTEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExplosiveSnowballs {
    private static final Logger LOGGER = LogManager.getLogger();

    public ExplosiveSnowballs() {
        LOGGER.info("YYYYYYYYYY - {}", this.getClass());
    }

    @SubscribeEvent
    public void onEntityJoinWorldEvent(EntityJoinWorldEvent event) {
        if (!(event.getEntity() instanceof SnowballEntity)) {
            return;
        }

        SnowballEntity snowballEntity = (SnowballEntity)event.getEntity();

        final double x = snowballEntity.getPosX();
        final double y = snowballEntity.getPosY();
        final double z = snowballEntity.getPosZ();
        LOGGER.info("YYYYYYYYYY - {}, {}, {}", x, y, z);

        LOGGER.info("YYYYYYYYYY - snowball - {}", event);

        if (!event.getWorld().isRemote) {
            TNTEntity tnt = new TNTEntity(event.getWorld(), x, y, z, null);
            tnt.setFuse(80);

            tnt.setMotion(snowballEntity.getMotion());

            tnt.setRawPosition(
                    tnt.getPosX() + tnt.getMotion().getX(),
                    tnt.getPosY() + tnt.getMotion().getY(),
                    tnt.getPosZ() + tnt.getMotion().getZ());

            event.getWorld().addEntity(tnt);
            snowballEntity.remove();
        }
    }
}
