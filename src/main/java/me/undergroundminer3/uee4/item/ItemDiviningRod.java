package me.undergroundminer3.uee4.item;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import me.undergroundminer3.uee4.abstacts.ItemEE;
import me.undergroundminer3.uee4.emc.EmcData;
import me.undergroundminer3.uee4.emc.EmcDataRegistry;
import me.undergroundminer3.uee4.emc.EmcDisplayHelper;
import me.undergroundminer3.uee4.reference.Names;
import me.undergroundminer3.uee4.util2.LogHelper;

public class ItemDiviningRod extends ItemEE
{
	public ItemDiviningRod()
	{
		super();
		this.setHasSubtypes(true);
		this.setUnlocalizedName(Names.Items.DIVINING_ROD);
	}

	private int rangeDiv2 = 3; //range multiplied by 2

	private long lastClick = 0L;
	private byte antiHack = 0;

	@Override
	public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World,
			final EntityPlayer par3EntityPlayer) {


		if (!par2World.isRemote) { //work with ore obfuscation plugins

			final long cur = System.currentTimeMillis();

			if (cur > (lastClick + 500L)) { //ANTI DDOS?

				//			par3EntityPlayer.addChatComponentMessage(new ChatComponentText("Lets go find diamonds!"));
				par3EntityPlayer.addChatComponentMessage(new ChatComponentText("Divining found most valueable object around:"));

				int x = (int) par3EntityPlayer.posX;
				int y = (int) par3EntityPlayer.posY;
				int z = (int) par3EntityPlayer.posZ;

				int xm = x + rangeDiv2;
				int ym = y + rangeDiv2;
				int zm = z + rangeDiv2;

				x -= rangeDiv2;
				y -= rangeDiv2;
				z -= rangeDiv2;

				EmcData maxData = new EmcData();

				for (int xc = x; xc < xm; xc++) {
					for (int yc = y; yc < ym; yc++) {
						for (int zc = z; zc < zm; zc++) {
							final Block b = par2World.getBlock(xc, yc, zc);

							maxData = EmcDisplayHelper.getMax(maxData, EmcDataRegistry.getEmc(new ItemStack(b)));
						}
					}
				}

				final String[] averageDisplay = EmcDisplayHelper.getData(maxData);

				par3EntityPlayer.addChatComponentMessage(new ChatComponentText(averageDisplay[0]));
				par3EntityPlayer.addChatComponentMessage(new ChatComponentText(averageDisplay[1]));
				par3EntityPlayer.addChatComponentMessage(new ChatComponentText(averageDisplay[2]));
				antiHack = 0;
			} else if (cur < (lastClick + 100L)) {
				LogHelper.warn("[UEE4] The player with UUID:" + par3EntityPlayer.getUniqueID().getLeastSignificantBits() + par3EntityPlayer.getUniqueID().getMostSignificantBits() + ", divined too fast. (MAYBEHACKING?)");
				antiHack++;
			}

			if (antiHack == 10) {
				if (par3EntityPlayer instanceof EntityPlayerMP) {
					((EntityPlayerMP) par3EntityPlayer).playerNetServerHandler.kickPlayerFromServer("Diving rod hacking? (10 TIMES IN A ROW)");
					//TODO ban player?
				}
			}

			lastClick = cur;
		}




		return super.onItemRightClick(par1ItemStack, par2World, par3EntityPlayer);
	}


}
