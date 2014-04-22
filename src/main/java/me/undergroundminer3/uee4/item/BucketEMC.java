package me.undergroundminer3.uee4.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.undergroundminer3.uee4.reference.Names;
import me.undergroundminer3.uee4.reference.Textures;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;

public class BucketEMC extends BucketEE {

	public BucketEMC(Block p_i45331_1_) {
		super(p_i45331_1_);
		this.setUnlocalizedName(Names.Items.EMC_BUCKET);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister)
	{
		itemIcon = iconRegister.registerIcon(Textures.RESOURCE_PREFIX + "bucket_emc");
	}

}
