package me.undergroundminer3.uee4.emc;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import org.lwjgl.input.Keyboard;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;


/**
 * Unequal-Exchange4
 * <p/>
 * ItemTooltipEventHandler
 *
 * @author pahimar, undergroundminer3
 */
@SideOnly(Side.CLIENT)

public class EmcTooltipHandler
{
	@SubscribeEvent
	public void handleItemTooltipEvent(final ItemTooltipEvent event)
	{
		boolean lsh = Keyboard.isKeyDown(Keyboard.KEY_LSHIFT);
		boolean rsh = Keyboard.isKeyDown(Keyboard.KEY_RSHIFT);
		if (lsh || rsh)
		{
			if (lsh) {
				final ItemStack stack = event.itemStack;
				final EmcData data = EmcDataRegistry.getEmc(stack);

				EmcDisplayHelper.addToolTips(event, data, "EMC (Stack): ");

			}
			if (rsh) {
				final ItemStack stack = new ItemStack(event.itemStack.getItem(), 1, event.itemStack.getItemDamage());
				final EmcData data = EmcDataRegistry.getEmc(stack);

				EmcDisplayHelper.addToolTips(event, data, "EMC (Item): ");
			}

		}
	}

}