package org.yuyuan.forge.mods;

import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.boss.dragon.phase.PhaseType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DragonSpawner {
    private static final Logger LOGGER = LogManager.getLogger();

    public DragonSpawner() {
        LOGGER.info("YYYYYYYYYY - DragonSpawner");
    }

    @SubscribeEvent
    public void onEntityPlaceEvent(BlockEvent.EntityPlaceEvent event) {
        LOGGER.info("YYYYYYYYYY - {} BlockEvent.EntityPlaceEvent", this.getClass());

        if (event.getPlacedBlock() == Blocks.DRAGON_EGG.getBlock().getDefaultState()) {
            LOGGER.info("YYYYYYYYYY - {}", Blocks.DRAGON_EGG);

            final BlockPos pos = event.getPos();
            final int x = pos.getX();
            final int y = pos.getY();
            final int z = pos.getZ();
            LOGGER.info("YYYYYYYYYY - {}, {}, {}", x, y, z);

            // this is an EntityPlaceEvent, therefore we should have a ServerWorld
            LOGGER.info("YYYYYYYYYY event.getWorld(): {}", event.getWorld().getClass());
            assert event.getWorld() instanceof ServerWorld;

            ServerWorld world = (ServerWorld)event.getWorld();

            // Also Note: Minecraft.getInstance().world is a ClientWorld
            assert Minecraft.getInstance().world != null;
            LOGGER.info("YYYYYYYYYY Minecraft.getInstance().world: {}", Minecraft.getInstance().world.getClass());
            // looks we shouldn't use the ClientWorld

            world.removeBlock(pos, false);  // clear the egg

            EnderDragonEntity dragon = EntityType.ENDER_DRAGON.create(world);
            dragon.setLocationAndAngles(x, y, z, 0, 0);
            LOGGER.info("YYYYYYYYYY phase - {}", dragon.getPhaseManager().getCurrentPhase());
            dragon.getPhaseManager().setPhase(PhaseType.TAKEOFF);

            // world.summonEntity(dragon);  // seems to work, too
            world.addEntity(dragon);
        }

        /*
        LOGGER.info("YYYYYYYYYY ================================================================================");
        if (event.getWorld().getClass() == ServerWorld.class) {
            ServerWorld world = (ServerWorld) event.getWorld();

            world.getEntities().forEach(entity -> {
                LOGGER.info("YYYYYYYYYY ServerWorld entity - {}, {}, {}, {}",
                        entity.getEntityId(), entity.getEntityString(), entity.getType(), entity.getName());
            });
        }

        LOGGER.info("YYYYYYYYYY ================================================================================");
        for (Entity entity : Minecraft.getInstance().world.getAllEntities()) {
            LOGGER.info("YYYYYYYYYY entity - {}, {}, {}, {}",
                    entity.getEntityId(), entity.getEntityString(), entity.getType(), entity.getName());
            if (entity.getType() == EntityType.ENDER_DRAGON) {
                EnderDragonEntity d = (EnderDragonEntity)entity;
                LOGGER.info("YYYYYYYYYY dragon - {}", d.getPhaseManager().getCurrentPhase());
            }
        }
        */
    }

    @SubscribeEvent
    public void onBlockBreakEvent(BlockEvent.BreakEvent event) {
        LOGGER.info("YYYYYYYYYY - {} BlockEvent.BreakEvent", this.getClass());
    }
}
