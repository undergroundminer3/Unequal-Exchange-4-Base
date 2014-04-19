package me.undergroundminer3.uee4.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.undergroundminer3.uee4.UnequalExchange4;
import me.undergroundminer3.uee4.reference.GuiIds;
import me.undergroundminer3.uee4.reference.Names;
import me.undergroundminer3.uee4.reference.RenderIds;
import me.undergroundminer3.uee4.tileentity.TileAlchemicalChest;
import me.undergroundminer3.uee4.tileentity.TileAlchemicalChestLarge;
import me.undergroundminer3.uee4.tileentity.TileAlchemicalChestMedium;
import me.undergroundminer3.uee4.tileentity.TileAlchemicalChestSmall;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.List;

public class BlockAlchemicalChest extends BlockEE implements ITileEntityProvider
{
	public BlockAlchemicalChest()
	{
		super(Material.wood);
		this.setHardness(2.5f);
		this.setBlockName(Names.Blocks.ALCHEMICAL_CHEST);
		this.setBlockBounds(0.0625f, 0.0f, 0.0625f, 0.9375f, 0.875f, 0.9375f);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metaData)
	{
		if (metaData == 0)
		{
			return new TileAlchemicalChestSmall();
		}
		else if (metaData == 1)
		{
			return new TileAlchemicalChestMedium();
		}
		else if (metaData == 2)
		{
			return new TileAlchemicalChestLarge();
		}

		return null;
	}

	@Override
	public int damageDropped(int metaData)
	{
		return metaData;
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
		return RenderIds.alchemicalChest;
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
	{
		if (player.isSneaking() || world.isSideSolid(x, y + 1, z, ForgeDirection.DOWN))
		{
			return true;
		}
		else
		{
			if (!world.isRemote && world.getTileEntity(x, y, z) instanceof TileAlchemicalChest)
			{
				player.openGui(UnequalExchange4.instance, GuiIds.ALCHEMICAL_CHEST, world, x, y, z);
			}

			return true;
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list)
	{
		for (int meta = 0; meta < 3; meta++)
		{
			list.add(new ItemStack(item, 1, meta));
		}
	}
}
