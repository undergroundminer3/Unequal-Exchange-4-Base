package me.undergroundminer3.uee4.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import me.undergroundminer3.uee4.util.NBTHelper;
import net.minecraft.entity.item.EntityItem;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;

public class ItemEventHandler
{
	@SubscribeEvent
	public void onItemTossEvent(ItemTossEvent itemTossEvent)
	{
		NBTHelper.clearStatefulNBTTags(itemTossEvent.entityItem.getEntityItem());
	}

	@SubscribeEvent
	public void onItemPickupEvent(PlayerEvent.ItemPickupEvent itemPickupEvent)
	{
		NBTHelper.clearStatefulNBTTags(itemPickupEvent.pickedUp.getEntityItem());
	}

	@SubscribeEvent
	public void onEntityItemPickupEvent(EntityItemPickupEvent entityItemPickupEvent)
	{
		NBTHelper.clearStatefulNBTTags(entityItemPickupEvent.item.getEntityItem());
	}

	@SubscribeEvent
	public void onPlayerDropsEvent(PlayerDropsEvent playerDropsEvent)
	{
		for (EntityItem entityItem : playerDropsEvent.drops)
		{
			NBTHelper.clearStatefulNBTTags(entityItem.getEntityItem());
		}
	}
}
