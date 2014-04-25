package me.undergroundminer3.uee4.item;

import me.undergroundminer3.uee4.abstacts.ItemEE;
import me.undergroundminer3.uee4.reference.Names;

public class ItemChalk extends ItemEE
{
	public ItemChalk()
	{
		super();
		this.setMaxStackSize(64);
		this.setUnlocalizedName(Names.Items.CHALK);
	}
}