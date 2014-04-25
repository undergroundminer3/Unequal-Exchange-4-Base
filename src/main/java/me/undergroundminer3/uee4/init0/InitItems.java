package me.undergroundminer3.uee4.init0;

import me.undergroundminer3.uee4.buckethelper.BucketHelper;
import me.undergroundminer3.uee4.init.ModBlocks;
import me.undergroundminer3.uee4.item.BucketEMC;
import me.undergroundminer3.uee4.item.ItemAlchemicalBag;
import me.undergroundminer3.uee4.item.ItemAlchemicalDust;
import me.undergroundminer3.uee4.item.ItemAlchemicalFuel;
import me.undergroundminer3.uee4.item.ItemAlchemicalInventoryUpgrade;
import me.undergroundminer3.uee4.item.ItemBlockAlchemicalChest;
import me.undergroundminer3.uee4.item.ItemChalk;
import me.undergroundminer3.uee4.item.ItemDiviningRod;
import me.undergroundminer3.uee4.item.ItemInertStone;
import me.undergroundminer3.uee4.item.ItemMiniumShard;
import me.undergroundminer3.uee4.item.ItemMiniumStone;
import me.undergroundminer3.uee4.item.ItemPhilosophersStone;
import me.undergroundminer3.uee4.reference.Names;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import static me.undergroundminer3.uee4.init.ModItems.*;

public final class InitItems {

	private InitItems() {};
	
	public static void init0() {
		alchemicalBag = new ItemAlchemicalBag();
		alchemicalDust = new ItemAlchemicalDust();
		alchemicalFuel = new ItemAlchemicalFuel();
		inertStone = new ItemInertStone();
		miniumShard = new ItemMiniumShard();
		miniumStone = new ItemMiniumStone();
		philosophersStone = new ItemPhilosophersStone();
		alchemicalInventoryUpgrade = new ItemAlchemicalInventoryUpgrade();
		chalk = new ItemChalk();
		diviningRod = new ItemDiviningRod();
		alchemicalChest = new ItemBlockAlchemicalChest(ModBlocks.alchemicalChest);
		bucketEmc = new BucketEMC(ModBlocks.liquidEmcBlock);
	}
	
	public static void init1() {
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
