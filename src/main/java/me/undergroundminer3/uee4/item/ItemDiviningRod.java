package me.undergroundminer3.uee4.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import me.undergroundminer3.uee4.reference.Names;

public class ItemDiviningRod extends ItemEE
{
	public ItemDiviningRod()
	{
		super();
		this.setHasSubtypes(true);
		this.setUnlocalizedName(Names.Items.DIVINING_ROD);
	}

	@Override
	public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World,
			final EntityPlayer par3EntityPlayer) {
		
		return super.onItemRightClick(par1ItemStack, par2World, par3EntityPlayer);
	}
	
	
}
