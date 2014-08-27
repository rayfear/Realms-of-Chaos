package com.eternaldoom.realmsofchaos.entity.projectile;

import com.eternaldoom.realmsofchaos.items.ROCItems;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityFractoniteBullet extends EntityThrowable
{
    public EntityFractoniteBullet(World world)
    {
        super(world);
    }

    public EntityFractoniteBullet(World world, EntityLivingBase entity)
    {
        super(world, entity);
    }

    public EntityFractoniteBullet(World p_i1775_1_, double p_i1775_2_, double p_i1775_4_, double p_i1775_6_)
    {
        super(p_i1775_1_, p_i1775_2_, p_i1775_4_, p_i1775_6_);
    }

    protected void onImpact(MovingObjectPosition position)
    {
        if (position.entityHit != null)
        {
            float damage = ROCItems.fractonite_cannon.damage;

            position.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), damage);
        }

        if (!this.worldObj.isRemote)
        {
            this.setDead();
        }
    }
}