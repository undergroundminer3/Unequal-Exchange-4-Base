package me.undergroundminer3.uee4.block;

import me.undergroundminer3.uee4.abstacts.BlockEE;
import me.undergroundminer3.uee4.reference.Names;
import me.undergroundminer3.uee4.reference.RenderIds;
import me.undergroundminer3.uee4.tileentity.TileAludel;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockAludel extends BlockEE implements ITileEntityProvider
{
	public BlockAludel()
	{
		super(Material.anvil);
		this.setHardness(5.0f);
		this.setBlockName(Names.Blocks.ALUDEL);
		this.setBlockBounds(0.10F, 0.0F, 0.10F, 0.90F, 1.0F, 0.90F);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metaData)
	{
		return new TileAludel();
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public int getRenderType()
	{
		return RenderIds.aludel;
	}
}
