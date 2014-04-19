package me.undergroundminer3.uee4.item;

import net.minecraft.item.ItemStack;

public interface IDyeable
{
	public abstract boolean hasColor(ItemStack itemStack);

	public abstract int getColor(ItemStack itemStack);

	public abstract void setColor(ItemStack itemStack, int color);

	public abstract void removeColor(ItemStack itemStack);
}