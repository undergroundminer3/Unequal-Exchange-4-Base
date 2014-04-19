package me.undergroundminer3.uee4.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import me.undergroundminer3.uee4.item.crafting.RecipesAlchemicalBagDyes;
import net.minecraft.item.crafting.CraftingManager;

public class CraftingHandler
{
	public static void init()
	{
		// Add in the ability to dye Alchemical Bags
		CraftingManager.getInstance().getRecipeList().add(new RecipesAlchemicalBagDyes());
	}

	@SubscribeEvent
	public void onItemCraftedEvent(PlayerEvent.ItemCraftedEvent event)
	{
		// TODO Set owner on who crafted the item (make sure it's not a FakePlayer)
	}
}
