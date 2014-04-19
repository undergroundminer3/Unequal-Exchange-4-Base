package me.undergroundminer3.uee4.item;

import me.undergroundminer3.uee4.block.ModBlocks;
import me.undergroundminer3.uee4.reference.Names;
import net.minecraft.block.Block;
import net.minecraft.item.ItemMultiTexture;

public class ItemBlockAlchemicalFuel extends ItemMultiTexture
{
	public ItemBlockAlchemicalFuel(Block block)
	{
		super(ModBlocks.alchemicalFuel, ModBlocks.alchemicalFuel, Names.Items.ALCHEMICAL_FUEL_SUBTYPES);
	}
}
