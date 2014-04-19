package me.undergroundminer3.uee4.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.undergroundminer3.uee4.reference.Colors;
import me.undergroundminer3.uee4.reference.Names;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;

import java.util.List;

public class BlockInfusedPlank extends BlockEE
{
    public BlockInfusedPlank()
    {
        super(Material.wood);
        this.setHardness(2.0f);
        this.setResistance(5.0f);
        this.setBlockName(Names.Blocks.INFUSED_PLANK);
        this.setStepSound(soundTypeWood);
    }

    @Override
    public int damageDropped(int metaData)
    {
        return metaData;
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

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        blockIcon = iconRegister.registerIcon("planks_oak");
    }

    @SideOnly(Side.CLIENT)
    public int colorMultiplier(IBlockAccess blockAccess, int x, int y, int z)
    {
        int metaData = blockAccess.getBlockMetadata(x, y, z);

        if (metaData == 0)
        {
            return Integer.parseInt(Colors.INFUSED_PLANKS_VERDANT, 16);
        }
        else if (metaData == 1)
        {
            return Integer.parseInt(Colors.INFUSED_PLANKS_AZURE, 16);
        }
        else if (metaData == 2)
        {
            return Integer.parseInt(Colors.INFUSED_PLANKS_MINIUM, 16);
        }
        else
        {
            return Integer.parseInt(Colors.PURE_WHITE, 16);
        }
    }

    @SideOnly(Side.CLIENT)
    public int getRenderColor(int metaData)
    {
        if (metaData == 0)
        {
            return Integer.parseInt(Colors.INFUSED_PLANKS_VERDANT, 16);
        }
        else if (metaData == 1)
        {
            return Integer.parseInt(Colors.INFUSED_PLANKS_AZURE, 16);
        }
        else if (metaData == 2)
        {
            return Integer.parseInt(Colors.INFUSED_PLANKS_MINIUM, 16);
        }
        else
        {
            return Integer.parseInt(Colors.PURE_WHITE, 16);
        }
    }
}
