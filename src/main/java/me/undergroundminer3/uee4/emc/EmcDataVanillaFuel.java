package me.undergroundminer3.uee4.emc;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


/* packaged */
class EmcDataVanillaFuel implements EmcDataProvider{

	@Override
	public EmcData provide(final ItemStack stack) {

		final Item item = stack.getItem();
		
		if (item == null) return new EmcData();
		
		final int damage = stack.getItemDamage();
		final EmcData data = new EmcData();
		boolean got = false;
		
		
		//random shot at coal
		if (item == Items.coal) {
			got = true;
			data.electra = 20; //spark
			data.potenta = 1600; //80seconds*20ticks
			data.luma = 2744; //14*14*14
			data.viva = 20; //we might make people eat coal :D
			
			data.luxa = -50; //pencil sharpeners make a mess
			data.temperature = 10;
			if (damage == 0) {
				data.air = 10;
				data.aqua = 10;
				data.kindoma = 1000; //coal is from dead animals
				data.worlda = -20; //wither skeleton drop
			}
			if (damage == 1) {
				data.air = 20;
				data.aqua = 5;
				data.kindoma = -1000; //charcoal from wood
				data.worlda = -10;
			}
		}
		
		//TODO more fuels

		return got == true ? data.mul(stack.stackSize) : null;
	}

	@Override
	public String getModAndName() {
		return "UEE4's Vanilla Fuel Emc provider";
	}
}
