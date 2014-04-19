package me.undergroundminer3.uee4.emc;

import net.minecraft.item.ItemStack;

public interface EmcDataProvider {

	/**
	 * Asks the provider about the emcdata of the stack.
	 * @param stack The stack to find emc data from
	 * @return an emcdata showing the data, or null, if we don't know
	 */
	public EmcData provide(final ItemStack stack);
	
	/**
	 * Gets the mod this provider is from, and its name
	 * <br/>
	 * <br/>
	 * Example: "UEE4's Minerals EMC Provider"
	 * @return "MOD" + "NAME"
	 */
	public String getModAndName();
}
