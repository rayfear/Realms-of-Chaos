package com.eternaldoom.realmsofchaos.blocks;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import com.eternaldoom.realmsofchaos.iceruins.gen.WorldGenIceMountain;
import com.eternaldoom.realmsofchaos.items.ROCItems;
import com.eternaldoom.realmsofchaos.overworld.gen.WorldGenCharwoodTree;

public class BlockCharwoodSapling extends ROCModBlock{

	public BlockCharwoodSapling() {
		super(Material.rock, "realmsofchaos:charwood_sapling", "saplingCharwood", 0.0f, 2.5f, null);
		float f = 0.4f;
        setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
	}
	
	@Override
	public int getRenderType(){
		return 1;
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
    {
        return null;
    }

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock(){
		return false;
	}
	
	@Override
	public boolean canPlaceBlockAt(World w, int p_149742_2_, int p_149742_3_, int p_149742_4_)
    {
        return super.canPlaceBlockAt(w, p_149742_2_, p_149742_3_, p_149742_4_) && this.canBlockStay(w, p_149742_2_, p_149742_3_, p_149742_4_);
    }
	
	/*public boolean canBlockStay(World w, int i, int j, int k)
    {
        if (w.getBlock(i, j - 1, k) == Blocks.netherrack){
        	return true;
        }
       return false;
    }*/
	
	protected void checkAndDropBlock(World p_149855_1_, int p_149855_2_, int p_149855_3_, int p_149855_4_)
    {
        if (!this.canBlockStay(p_149855_1_, p_149855_2_, p_149855_3_, p_149855_4_))
        {
            this.dropBlockAsItem(p_149855_1_, p_149855_2_, p_149855_3_, p_149855_4_, p_149855_1_.getBlockMetadata(p_149855_2_, p_149855_3_, p_149855_4_), 0);
            p_149855_1_.setBlock(p_149855_2_, p_149855_3_, p_149855_4_, getBlockById(0), 0, 2);
        }
    }
	
	@Override
	public boolean onBlockActivated(World w, int i, int j, int k, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_){
		WorldGenCharwoodTree o = new WorldGenCharwoodTree();
		
		if (!w.isRemote){
			if (player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == ROCItems.ash_dust){
				if(!player.capabilities.isCreativeMode) --player.getCurrentEquippedItem().stackSize;
				Random r = new Random(); int growChance = r.nextInt(5);
				
				if (growChance == 3) return o.generate(w, null, i - 2, j, k - 2);
				else {
					for (int c = 0; c < 7; ++c)
			        {
			            double d0 = r.nextGaussian() * 0.02D;
			            double d1 = r.nextGaussian() * 0.02D;
			            double d2 = r.nextGaussian() * 0.02D;
			            w.spawnParticle("smoke", i, j, k, d0, d1, d2);
			        }
				}
			}
		}
		return false;

	}
}