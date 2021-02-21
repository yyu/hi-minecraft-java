package org.yuyuan.forge.mods;

import net.minecraft.entity.item.TNTEntity;
import net.minecraft.entity.item.minecart.TNTMinecartEntity;
import net.minecraft.entity.projectile.SnowballEntity;
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
        LOGGER.info("YYYYYYYYYY - snowball - {}", event);

        SnowballEntity snowballEntity = (SnowballEntity)event.getEntity();

        final double x = snowballEntity.getPosX();
        final double y = snowballEntity.getPosY();
        final double z = snowballEntity.getPosZ();
        LOGGER.info("YYYYYYYYYY - {}, {}, {}", x, y, z);

        if (!event.getWorld().isRemote) {
//            TNTMinecartEntity tntMinecartEntity = new TNTMinecartEntity(event.getWorld(), x, y, z);
//            tntMinecartEntity.setMotion(snowballEntity.getMotion());
//            tntMinecartEntity.setRawPosition(
//                    tntMinecartEntity.getPosX() + tntMinecartEntity.getMotion().getX(),
//                    tntMinecartEntity.getPosY() + tntMinecartEntity.getMotion().getY(),
//                    tntMinecartEntity.getPosZ() + tntMinecartEntity.getMotion().getZ());
//
//            event.getWorld().addEntity(tntMinecartEntity);

            TNTEntity tntEntity = new TNTEntity(event.getWorld(), x, y, z, null);
            tntEntity.setFuse(80);
            tntEntity.setMotion(snowballEntity.getMotion());
            tntEntity.setRawPosition(
                    tntEntity.getPosX() + tntEntity.getMotion().getX(),
                    tntEntity.getPosY() + tntEntity.getMotion().getY(),
                    tntEntity.getPosZ() + tntEntity.getMotion().getZ());

            event.getWorld().addEntity(tntEntity);

            snowballEntity.remove();
        }
    }
}
