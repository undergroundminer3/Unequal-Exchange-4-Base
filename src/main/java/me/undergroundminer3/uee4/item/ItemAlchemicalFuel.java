package me.undergroundminer3.uee4.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.undergroundminer3.uee4.abstacts.ItemEE;
import me.undergroundminer3.uee4.reference.Names;
import me.undergroundminer3.uee4.reference.Textures;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;

import java.util.List;

public class ItemAlchemicalFuel extends ItemEE
{
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;

	public ItemAlchemicalFuel()
	{
		super();
		this.setMaxStackSize(64);
		this.setHasSubtypes(true);
		this.setUnlocalizedName(Names.Items.ALCHEMICAL_FUEL);
	}

	@Override
	public String getUnlocalizedName()
	{
		return String.format("item.%s%s", Textures.RESOURCE_PREFIX, Names.Items.ALCHEMICAL_FUEL);
	}

	@Override
	public String getUnlocalizedName(ItemStack itemStack)
	{
		return String.format("item.%s%s.%s", Textures.RESOURCE_PREFIX, Names.Items.ALCHEMICAL_FUEL, Names.Items.ALCHEMICAL_FUEL_SUBTYPES[MathHelper.clamp_int(itemStack.getItemDamage(), 0, Names.Items.ALCHEMICAL_FUEL_SUBTYPES.length - 1)]);
	}

	@Override
	@SuppressWarnings("all")
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs creativeTab, List list)
	{
		for (int meta = 0; meta < Names.Items.ALCHEMICAL_FUEL_SUBTYPES.length; ++meta)
		{
			list.add(new ItemStack(this, 1, meta));
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int meta)
	{
		return icons[MathHelper.clamp_int(meta, 0, Names.Items.ALCHEMICAL_FUEL_SUBTYPES.length - 1)];
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister)
	{
		icons = new IIcon[Names.Items.ALCHEMICAL_FUEL_SUBTYPES.length];

		for (int i = 0; i < Names.Items.ALCHEMICAL_FUEL_SUBTYPES.length; i++)
		{
			icons[i] = iconRegister.registerIcon(Textures.RESOURCE_PREFIX + Names.Items.ALCHEMICAL_FUEL + "." + Names.Items.ALCHEMICAL_FUEL_SUBTYPES[i]);
		}
	}
}
