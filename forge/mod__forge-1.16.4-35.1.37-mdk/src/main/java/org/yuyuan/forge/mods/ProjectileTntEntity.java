package org.yuyuan.forge.mods;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.TNTEntity;
import net.minecraft.entity.monster.BlazeEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ProjectileTntEntity extends ProjectileItemEntity {

    public static final EntityType<ProjectileTntEntity> ProjectileTNT = Registry.register(
            Registry.ENTITY_TYPE,
            "projectileTNT",
            EntityType.Builder.<ProjectileTntEntity>create(ProjectileTntEntity::new, EntityClassification.MISC)
                    .immuneToFire()
                    .size(0.98F, 0.98F)
                    .trackingRange(10)
                    .func_233608_b_(10)
                    .build("projectileTNT"));
    public static final BasicParticleType ITEM_PROJECTILE_TNT = Registry.register(
            Registry.PARTICLE_TYPE,
            "item_snowball",
            new BasicParticleType(false));

    public ProjectileTntEntity(EntityType<? extends ProjectileTntEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public ProjectileTntEntity(World worldIn, LivingEntity throwerIn) {
        super(ProjectileTNT, throwerIn, worldIn);
    }

    public ProjectileTntEntity(World worldIn, double x, double y, double z) {
        super(ProjectileTNT, x, y, z, worldIn);
    }

    protected Item getDefaultItem() {
        return Items.TNT;
    }

    @OnlyIn(Dist.CLIENT)
    private IParticleData makeParticle() {
        ItemStack itemstack = this.func_213882_k();
        return itemstack.isEmpty() ? ITEM_PROJECTILE_TNT : new ItemParticleData(ParticleTypes.ITEM, itemstack);
    }

    /**
     * Handler for {@link World#setEntityState}
     */
    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id) {
        if (id == 3) {
            IParticleData iparticledata = this.makeParticle();

            for(int i = 0; i < 8; ++i) {
                this.world.addParticle(iparticledata, this.getPosX(), this.getPosY(), this.getPosZ(), 0.0D, 0.0D, 0.0D);
            }
        }

    }

    /**
     * Called when the arrow hits an entity
     */
    protected void onEntityHit(EntityRayTraceResult p_213868_1_) {
        super.onEntityHit(p_213868_1_);
        Entity entity = p_213868_1_.getEntity();
        int i = entity instanceof BlazeEntity ? 3 : 0;
        entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this.func_234616_v_()), (float)i);
    }

    /**
     * Called when this EntityFireball hits a block or entity.
     */
    protected void onImpact(RayTraceResult result) {
        super.onImpact(result);
        if (!this.world.isRemote) {
            this.world.setEntityState(this, (byte)3);
            this.remove();
        }

    }
}
