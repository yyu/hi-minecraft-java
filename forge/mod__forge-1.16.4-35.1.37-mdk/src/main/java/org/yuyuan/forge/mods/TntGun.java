package org.yuyuan.forge.mods;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.IVanishable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.item.*;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Predicate;

public class TntGun extends ShootableItem implements IVanishable {  // copying BowItem
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
            LOGGER.info("YYYYYYYYYY - 11111111111111111111111111 {}", flag);

            int i = this.getUseDuration(stack) - timeLeft;
            i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, worldIn, playerentity, i, flag);
            if (i < 0) return;

            LOGGER.info("YYYYYYYYYY - 22222222222222222222222222");

            if (flag) {
                float f = getBulletVelocity(i);
                if (!((double)f < 0.1D)) {
                    if (!worldIn.isRemote) {
                        LOGGER.info("YYYYYYYYYY - 3333333333333333333333333 {}", playerentity.getMotion());

                        // method 1 - shoot a snowball and let ExplosiveSnowballs turn it into a TNT
                        //            this way we don't have to deal with the motion calculation,
                        //            SnowballEntity will take care of the motion, which TNT simply gets for free
                        SnowballEntity snowballEntity = new SnowballEntity(worldIn, playerentity);
                        snowballEntity.func_234612_a_( // BowItem uses this, so we use it -- no idea why
                                playerentity, playerentity.rotationPitch, playerentity.rotationYaw,
                                0.0F, f * 3.0F, 1.0F);
                        worldIn.addEntity(snowballEntity);

                        // method 2 - subclass ProjectileEntity just like SnowballEntity
                        // TODO

//                        // method 2 - spawn a TNT and set the motion (glitches sometimes, no idea why
//                        float velocity = f * 3.0F;
//                        float inaccuracy = 1.0F;
//                        float no_idea_what_this_is_for = 0.0F;
//
//                        TNTEntity tntEntity = new TNTEntity(worldIn, x, y, z, null);
//                        tntEntity.setFuse(80);
//
//                        float f0 = -MathHelper.sin(playerentity.rotationYaw * ((float)Math.PI / 180F)) *
//                                MathHelper.cos(playerentity.rotationPitch * ((float)Math.PI / 180F));
//                        float f1 = -MathHelper.sin((playerentity.rotationPitch + no_idea_what_this_is_for) * ((float)Math.PI / 180F));
//                        float f2 = MathHelper.cos(playerentity.rotationYaw * ((float)Math.PI / 180F)) *
//                                MathHelper.cos(playerentity.rotationPitch * ((float)Math.PI / 180F));
//
//                        Vector3d vector3d = (new Vector3d(f0, f1, f2)).normalize()
//                                .add(this.rand.nextGaussian() * (double)0.0075F * (double)inaccuracy,
//                                     this.rand.nextGaussian() * (double)0.0075F * (double)inaccuracy,
//                                     this.rand.nextGaussian() * (double)0.0075F * (double)inaccuracy)
//                                .scale((double)velocity);
//                        tntEntity.setMotion(vector3d.add(
//                                playerentity.getMotion().x,
//                                playerentity.isOnGround() ? 0.0D : playerentity.getMotion().y,
//                                playerentity.getMotion().z));
//                        tntEntity.setRawPosition(
//                                tntEntity.getPosX() + tntEntity.getMotion().getX(),
//                                tntEntity.getPosY() + tntEntity.getMotion().getY(),
//                                tntEntity.getPosZ() + tntEntity.getMotion().getZ());
//
//                        worldIn.addEntity(tntEntity);
                    }

                    worldIn.playSound((PlayerEntity)null, playerentity.getPosX(), playerentity.getPosY(), playerentity.getPosZ(), SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.PLAYERS, 1.0F, 1.0F / (random.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

                    playerentity.addStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }

    /**
     * Gets the velocity of the arrow entity from the bow's charge
     */
    public static float getBulletVelocity(int charge) {
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

            return item == Items.TNT;
        };
    }

    public int func_230305_d_() {
        return 15;
    }
}
