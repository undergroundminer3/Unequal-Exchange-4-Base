package me.undergroundminer3.uee4.item;

import cpw.mods.fml.common.registry.GameRegistry;
import me.undergroundminer3.uee4.block.ModBlocks;
import me.undergroundminer3.uee4.reference.Names;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;

import me.undergroundminer3.uee4.buckethelper.BucketHelper;

public class ModItems
{
	public static final ItemEE alchemicalBag = new ItemAlchemicalBag();
	public static final ItemEE alchemicalDust = new ItemAlchemicalDust();
	public static final ItemEE alchemicalFuel = new ItemAlchemicalFuel();
	public static final ItemEE inertStone = new ItemInertStone();
	public static final ItemEE miniumShard = new ItemMiniumShard();
	public static final ItemEE miniumStone = new ItemMiniumStone();
	public static final ItemEE philosophersStone = new ItemPhilosophersStone();
	public static final ItemEE alchemicalInventoryUpgrade = new ItemAlchemicalInventoryUpgrade();
	public static final ItemEE chalk = new ItemChalk();
	public static final ItemEE diviningRod = new ItemDiviningRod();
	public static final ItemBlock alchemicalChest = new ItemBlockAlchemicalChest(ModBlocks.alchemicalChest);
	public static final BucketEE bucketEmc = new BucketEMC(ModBlocks.liquidEmcBlock);

	public static void init()
	{
		GameRegistry.registerItem(alchemicalBag, "item." + Names.Items.ALCHEMICAL_BAG);
		GameRegistry.registerItem(alchemicalDust, "item." + Names.Items.ALCHEMICAL_DUST);
		GameRegistry.registerItem(alchemicalFuel, "item." + Names.Items.ALCHEMICAL_FUEL);
		GameRegistry.registerItem(inertStone, "item." + Names.Items.INERT_STONE);
		GameRegistry.registerItem(miniumShard, "item." + Names.Items.MINIUM_SHARD);
		GameRegistry.registerItem(miniumStone, "item." + Names.Items.MINIUM_STONE);
		GameRegistry.registerItem(philosophersStone, "item." + Names.Items.PHILOSOPHERS_STONE);
		GameRegistry.registerItem(chalk, "item." + Names.Items.CHALK);
		GameRegistry.registerItem(alchemicalInventoryUpgrade, "item." + Names.Items.ALCHEMICAL_UPGRADE);
		GameRegistry.registerItem(diviningRod, "item." + Names.Items.DIVINING_ROD);
		
		bucketEmc.setContainerItem(Items.bucket);
		GameRegistry.registerItem(bucketEmc, "item." + Names.Items.EMC_BUCKET);
		
		FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack(Names.Liquids.LIQUID_EMC,
				FluidContainerRegistry.BUCKET_VOLUME),
				new ItemStack(bucketEmc),
				new ItemStack(Items.bucket));
		
		BucketHelper.INSTANCE.buckets.put(ModBlocks.liquidEmcBlock, bucketEmc);
		MinecraftForge.EVENT_BUS.register(BucketHelper.INSTANCE);
		
	}
}
