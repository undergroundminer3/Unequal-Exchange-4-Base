package me.undergroundminer3.uee4.item;

import me.undergroundminer3.uee4.abstacts.ItemEE;
import me.undergroundminer3.uee4.reference.Names;
import net.minecraft.item.ItemStack;

public class ItemPhilosophersStone extends ItemEE
{
	//TODO implement
//	private int maxChargeLevel;

	public ItemPhilosophersStone()
	{
		super();
		this.setUnlocalizedName(Names.Items.PHILOSOPHERS_STONE);
		this.setMaxDamage(1000);
//		this.maxChargeLevel = 3;
	}

	@Override
	public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemStack)
	{
		return false;
	}

	@Override
	public boolean getShareTag()
	{
		return true;
	}

	@Override
	public ItemStack getContainerItem(ItemStack itemStack)
	{
		ItemStack copiedStack = itemStack.copy();

		copiedStack.setItemDamage(copiedStack.getItemDamage() + 1);
		copiedStack.stackSize = 1;

		return copiedStack;
	}
}
