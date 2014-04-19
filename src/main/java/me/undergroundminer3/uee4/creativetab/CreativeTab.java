package me.undergroundminer3.uee4.creativetab;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.undergroundminer3.uee4.item.ModItems;
import me.undergroundminer3.uee4.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTab
{
	public static final CreativeTabs EE3_TAB = new CreativeTabs(Reference.MOD_ID)
	{
		@Override
		public Item getTabIconItem()
		{
			return ModItems.philosophersStone;
		}

		@Override
		@SideOnly(Side.CLIENT)
		public String getTranslatedTabLabel()
		{
			return "Unequal Exchange 4";
		}
	};
}
