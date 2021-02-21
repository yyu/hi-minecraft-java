package org.yuyuan.forge.mods;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.IVanishable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.TNTEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.item.*;
import net.minecraft.item.BowItem;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Predicate;

import static org.yuyuan.forge.mods.setup.ModTags.Items.ORES_SILVER;

//public class TntGun extends BowItem {
//    private static final Logger LOGGER = LogManager.getLogger();
//
//    public TntGun(Properties builder) {
//        super(builder);
//    }
//
//
//    /**
//     * Get the predicate to match ammunition when searching the player's inventory, not their main/offhand
//     */
//    @Override
//    public Predicate<ItemStack> getInventoryAmmoPredicate() {
//        return itemStack -> {
//            Item item = itemStack.getItem();
//            LOGGER.info("{}", item);
//
//            return item == Items.TNT;
//        };
//    }
//}
//
import java.util.function.Predicate;
        import net.minecraft.enchantment.EnchantmentHelper;
        import net.minecraft.enchantment.Enchantments;
        import net.minecraft.enchantment.IVanishable;
        import net.minecraft.entity.LivingEntity;
        import net.minecraft.entity.player.PlayerEntity;
        import net.minecraft.entity.projectile.AbstractArrowEntity;
        import net.minecraft.stats.Stats;
        import net.minecraft.util.ActionResult;
        import net.minecraft.util.Hand;
        import net.minecraft.util.SoundCategory;
        import net.minecraft.util.SoundEvents;
        import net.minecraft.world.World;

public class TntGun extends ShootableItem implements IVanishable {
    private static final Logger LOGGER = LogManager.getLogger();

    public TntGun(Item.Properties builder) {
        super(builder);
    }

    /**
     * Called when the player stops using an Item (stops holding the right mouse button).
     */
    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, LivingEntity entityLiving, int timeLeft) {
        if (entityLiving instanceof PlayerEntity) {
            PlayerEntity playerentity = (PlayerEntity)entityLiving;

            double x = playerentity.getPosX();
            double y = playerentity.getPosY();
            double z = playerentity.getPosZ();
            LOGGER.info("YYYYYYYYYY - playerentity Pox {}, {}, {}", x, y, z);

            boolean flag = playerentity.abilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack) > 0;
            // ItemStack itemstack = playerentity.findAmmo(stack);
            ItemStack itemstack = ItemStack.EMPTY;

            LOGGER.info("YYYYYYYYYY - 11111111111111111111111111 {}", flag);

            int i = this.getUseDuration(stack) - timeLeft;
            i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, worldIn, playerentity, i, !itemstack.isEmpty() || flag);
            if (i < 0) return;

            LOGGER.info("YYYYYYYYYY - 22222222222222222222222222");

            if (!itemstack.isEmpty() || flag) {
                if (itemstack.isEmpty()) {
                    itemstack = new ItemStack(Items.TNT);
                }

                float f = getArrowVelocity(i);
                if (!((double)f < 0.1D)) {
                    boolean flag1 = playerentity.abilities.isCreativeMode || (itemstack.getItem() instanceof ArrowItem && ((ArrowItem)itemstack.getItem()).isInfinite(itemstack, stack, playerentity));
                    LOGGER.info("YYYYYYYYYY - 33333333333333333333333333 {}", flag1);
                    if (!worldIn.isRemote) {
//                        ProjectileTntEntity projectileTntEntity = new ProjectileTntEntity(worldIn, playerentity);
//                        projectileTntEntity.func_234612_a_(playerentity, playerentity.rotationPitch, playerentity.rotationYaw, 0.0F, f * 3.0F, 1.0F);
//                        worldIn.addEntity(projectileTntEntity);

                        SnowballEntity snowballEntity = new SnowballEntity(worldIn, playerentity);
                        snowballEntity.func_234612_a_(playerentity, playerentity.rotationPitch, playerentity.rotationYaw, 0.0F, f * 3.0F, 1.0F);
                        worldIn.addEntity(snowballEntity);

//                        LOGGER.info("YYYYYYYYYY - 44444444444444444444444444 {}", playerentity.getMotion());
//
//                        TNTEntity tntEntity = new TNTEntity(worldIn, x, y, z, null);
//                        tntEntity.setFuse(80);
//                        tntEntity.setMotion(playerentity.getMotion());
//                        tntEntity.setRawPosition(
//                                tntEntity.getPosX() + tntEntity.getMotion().getX(),
//                                tntEntity.getPosY() + tntEntity.getMotion().getY(),
//                                tntEntity.getPosZ() + tntEntity.getMotion().getZ());
//
//                        worldIn.addEntity(tntEntity);
                    }

                    worldIn.playSound((PlayerEntity)null, playerentity.getPosX(), playerentity.getPosY(), playerentity.getPosZ(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F / (random.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    if (!flag1 && !playerentity.abilities.isCreativeMode) {
                        itemstack.shrink(1);
                        if (itemstack.isEmpty()) {
                            playerentity.inventory.deleteStack(itemstack);
                        }
                    }

                    playerentity.addStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }

//    // copied from ProjectileEntity
//    /**
//     * Similar to setArrowHeading, it's point the throwable entity to a x, y, z direction.
//     */
//    public void shoot(double x, double y, double z, float velocity, float inaccuracy) {
//        Vector3d vector3d = (new Vector3d(x, y, z)).normalize().add(this.rand.nextGaussian() * (double)0.0075F * (double)inaccuracy, this.rand.nextGaussian() * (double)0.0075F * (double)inaccuracy, this.rand.nextGaussian() * (double)0.0075F * (double)inaccuracy).scale((double)velocity);
//        this.setMotion(vector3d);
//        float f = MathHelper.sqrt(horizontalMag(vector3d));
//        this.rotationYaw = (float)(MathHelper.atan2(vector3d.x, vector3d.z) * (double)(180F / (float)Math.PI));
//        this.rotationPitch = (float)(MathHelper.atan2(vector3d.y, (double)f) * (double)(180F / (float)Math.PI));
//        this.prevRotationYaw = this.rotationYaw;
//        this.prevRotationPitch = this.rotationPitch;
//    }
//
//    public void func_234612_a_(Entity p_234612_1_, float p_234612_2_, float p_234612_3_, float p_234612_4_, float p_234612_5_, float p_234612_6_) {
//        float f = -MathHelper.sin(p_234612_3_ * ((float)Math.PI / 180F)) * MathHelper.cos(p_234612_2_ * ((float)Math.PI / 180F));
//        float f1 = -MathHelper.sin((p_234612_2_ + p_234612_4_) * ((float)Math.PI / 180F));
//        float f2 = MathHelper.cos(p_234612_3_ * ((float)Math.PI / 180F)) * MathHelper.cos(p_234612_2_ * ((float)Math.PI / 180F));
//        this.shoot((double)f, (double)f1, (double)f2, p_234612_5_, p_234612_6_);
//        Vector3d vector3d = p_234612_1_.getMotion();
//        this.setMotion(this.getMotion().add(vector3d.x, p_234612_1_.isOnGround() ? 0.0D : vector3d.y, vector3d.z));
//    }
//
    /**
     * Gets the velocity of the arrow entity from the bow's charge
     */
    public static float getArrowVelocity(int charge) {
        float f = (float)charge / 20.0F;
        f = (f * f + f * 2.0F) / 3.0F;
        if (f > 1.0F) {
            f = 1.0F;
        }

        return f;
    }

    /**
     * How long it takes to use or consume an item
     */
    public int getUseDuration(ItemStack stack) {
        return 72000;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }

    /**
     * Called to trigger the item's "innate" right click behavior. To handle when this item is used on a Block, see
     * {@link #onItemUse}.
     */
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        boolean flag = !playerIn.findAmmo(itemstack).isEmpty();

        ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(itemstack, worldIn, playerIn, handIn, flag);
        if (ret != null) return ret;

        if (!playerIn.abilities.isCreativeMode && !flag) {
            return ActionResult.resultFail(itemstack);
        } else {
            playerIn.setActiveHand(handIn);
            return ActionResult.resultConsume(itemstack);
        }
    }

    /**
     * Get the predicate to match ammunition when searching the player's inventory, not their main/offhand
     */
    public Predicate<ItemStack> getInventoryAmmoPredicate() {
        return itemStack -> {
            Item item = itemStack.getItem();
//            LOGGER.info("{}", item);

            return item == Items.TNT;
        };
    }

    public AbstractArrowEntity customArrow(AbstractArrowEntity arrow) {
        return arrow;
    }

    public int func_230305_d_() {
        return 15;
    }
}



