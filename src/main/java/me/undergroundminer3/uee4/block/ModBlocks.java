package me.undergroundminer3.uee4.block;

import buildcraft.transport.BlockGenericPipe;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import me.undergroundminer3.uee4.emc1energy.Emc1Blocks;
import me.undergroundminer3.uee4.emctransport.ModPipes;
import me.undergroundminer3.uee4.item.*;
import me.undergroundminer3.uee4.reference.Names;
import me.undergroundminer3.uee4.worldgen.WorldGenEmcSpring;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks
{
	public static final BlockEE chalk = new BlockChalk();
	public static final BlockEE alchemicalFuel = new BlockAlchemicalFuel();
	public static final BlockEE infusedCloth = new BlockInfusedCloth();
	public static final BlockEE infusedWood = new BlockInfusedWood();
	public static final BlockEE infusedPlank = new BlockInfusedPlank();
	public static final BlockEE alchemicalChest = new BlockAlchemicalChest();
	public static final BlockEE aludel = new BlockAludel();
	public static final BlockEE calcinator = new BlockCalcinator();
	public static final BlockEE glassBell = new BlockGlassBell();
	public static final BlockEE researchStation = new BlockResearchStation();
	public static final LiquidEE fluidEmc = new LiquidEMC(Names.Liquids.LIQUID_EMC);
	public static final BlockLiquidEE liquidEmcBlock;
	
	static {
		FluidRegistry.registerFluid(fluidEmc);
		liquidEmcBlock = new BlockLiquidEMC(fluidEmc, Material.lava);
	}

	public static void init()
	{
		GameRegistry.registerBlock(chalk, "tile." + Names.Items.CHALK);
		GameRegistry.registerBlock(alchemicalFuel, ItemBlockAlchemicalFuel.class, "tile." + Names.Items.ALCHEMICAL_FUEL);
		GameRegistry.registerBlock(infusedCloth, ItemBlockInfusedCloth.class, "tile." + Names.Blocks.INFUSED_CLOTH);
		GameRegistry.registerBlock(infusedWood, ItemBlockInfusedWood.class, "tile." + Names.Blocks.INFUSED_WOOD);
		GameRegistry.registerBlock(infusedPlank, ItemBlockInfusedPlank.class, "tile." + Names.Blocks.INFUSED_PLANK);
		GameRegistry.registerBlock(alchemicalChest, ItemBlockAlchemicalChest.class, "tile." + Names.Blocks.ALCHEMICAL_CHEST);
		GameRegistry.registerBlock(aludel, "tile." + Names.Blocks.ALUDEL);
		GameRegistry.registerBlock(calcinator, "tile." + Names.Blocks.CALCINATOR);
		GameRegistry.registerBlock(glassBell, "tile." + Names.Blocks.GLASS_BELL);
		GameRegistry.registerBlock(researchStation, "tile." + Names.Blocks.RESEARCH_STATION);
		


		GameRegistry.registerBlock(liquidEmcBlock, "tile." + Names.Liquids.LIQUID_EMC);
		fluidEmc.setUnlocalizedName("liquidEmc");
		
		GameRegistry.registerWorldGenerator(new WorldGenEmcSpring(), 32);
		
		ModPipes.init();
		Emc1Blocks.init();
	}
}
