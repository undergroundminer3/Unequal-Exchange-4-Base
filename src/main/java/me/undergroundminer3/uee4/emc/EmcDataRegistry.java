package me.undergroundminer3.uee4.emc;

import java.util.ArrayList;

import me.undergroundminer3.uee4.util2.LogHelper;
import net.minecraft.item.ItemStack;

public final class EmcDataRegistry {

	//better than pahimar's immutable map way
	
	private EmcDataRegistry() {};

	/**
	 * The LAST list that the registry will consult to get emc data.
	 * <br/>
	 * Register only fallback (recipe-based) providers here.
	 */
	private static ArrayList<EmcDataProvider> provList1 = new ArrayList<EmcDataProvider>();

	/**
	 * The 2nd Last list that the registry will consult to get emc data.
	 * <br/>
	 * If you making a mod, register you providers here!!!!
	 */
	private static ArrayList<EmcDataProvider> provList2 = new ArrayList<EmcDataProvider>();

	/**
	 * The 2nd list that the registry will consult to get emc data.
	 * <br/>
	 * If you making a mod extension, register here.
	 */
	private static ArrayList<EmcDataProvider> provList3 = new ArrayList<EmcDataProvider>();

	/**
	 * The 1st list that the registry will consult to get emc data.
	 * <br/>
	 * Register only "gregtech", and "better than wolves", and "modpack" hardcore mod providers here.
	 */
	private static ArrayList<EmcDataProvider> provList4 = new ArrayList<EmcDataProvider>();

	public static EmcData getEmc(final ItemStack stack) {
		EmcData data = null;
		for (EmcDataProvider provider : provList4) {
			data = provider.provide(stack);
			if (data != null) return data;
		}
		for (EmcDataProvider provider : provList3) {
			data = provider.provide(stack);
			if (data != null) return data;
		}
		for (EmcDataProvider provider : provList2) {
			data = provider.provide(stack);
			if (data != null) return data;
		}
		for (EmcDataProvider provider : provList1) {
			data = provider.provide(stack);
			if (data != null) return data;
		}
		return new EmcData();
	}
	
	public static final byte FALLBACK_PRIORITY = 1;
	public static final byte MOD_PRIORITY = 2;
	public static final byte EXTENSION_PRIORITY = 3;
	public static final byte OVERRIDE_PRIORITY = 4;
	
	/**
	 * Registers the specified Emc provider,
	 * in the specified priority
	 * 
	 * @param provider the provider providing the emc data
	 * @param priority the priority the emc data will be considered
	 * @throws IllegalArgumentException when priority is not a valid priority, or if the provider, or provider's name is null
	 */
	public static void registerProvider(final EmcDataProvider provider, final byte priority) throws IllegalArgumentException {
		if (provider == null) {
			throw new IllegalArgumentException("Null provider!");
		}
		
		if (provider.getModAndName() == null) {
			throw new IllegalArgumentException("Please give the provider a name.");
		}
		
		switch (priority) {
		case FALLBACK_PRIORITY:
			provList1.add(provider);
			break;
		case MOD_PRIORITY:
			provList2.add(provider);
			break;
		case EXTENSION_PRIORITY:
			provList3.add(provider);
			break;
		case OVERRIDE_PRIORITY:
			provList4.add(provider);
			break;
		default:
			throw new IllegalArgumentException("Unknown priority!");
		}
		
		LogHelper.info("Registered an emc provider of priority :" + priority + ", from " + provider.getModAndName());
	}
	
	private static boolean didInit = false;
	
	public static void init() {
		if (didInit == true) return;
		registerProvider(new EmcDataVanillaFuel(), MOD_PRIORITY);
		didInit = true;
	}
}
