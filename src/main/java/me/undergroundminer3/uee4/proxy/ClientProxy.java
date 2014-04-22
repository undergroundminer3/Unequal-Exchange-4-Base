package me.undergroundminer3.uee4.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import me.undergroundminer3.uee4.block.ModBlocks;
import me.undergroundminer3.uee4.client.renderer.item.*;
import me.undergroundminer3.uee4.client.renderer.tileentity.*;
import me.undergroundminer3.uee4.emc.EmcTooltipHandler;
import me.undergroundminer3.uee4.emctransport.ModRenderers2;
import me.undergroundminer3.uee4.reference.RenderIds;
import me.undergroundminer3.uee4.tileentity.*;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy
{
	@Override
	public void initRenderingAndTextures()
	{
		RenderIds.calcinator = RenderingRegistry.getNextAvailableRenderId();
		RenderIds.aludel = RenderingRegistry.getNextAvailableRenderId();
		RenderIds.alchemicalChest = RenderingRegistry.getNextAvailableRenderId();
		RenderIds.glassBell = RenderingRegistry.getNextAvailableRenderId();
		RenderIds.researchStation = RenderingRegistry.getNextAvailableRenderId();

		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.alchemicalChest), new ItemAlchemicalChestRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.aludel), new ItemAludelRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.calcinator), new ItemCalcinatorRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.glassBell), new ItemGlassBellRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.researchStation), new ItemResearchStationRenderer());

		ClientRegistry.bindTileEntitySpecialRenderer(TileAlchemicalChest.class, new TileEntityAlchemicalChestRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileCalcinator.class, new TileEntityCalcinatorRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileAludel.class, new TileEntityAludelRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileGlassBell.class, new TileEntityGlassBellRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileResearchStation.class, new TileEntityResearchStationRenderer());
		
//		FMLCommonHandler.instance().bus().register(new EmcTooltipHandler());
		MinecraftForge.EVENT_BUS.register(new EmcTooltipHandler());
		
		ModRenderers2.init();
		
	}
}
