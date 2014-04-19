package me.undergroundminer3.uee4;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.event.FMLInterModComms.IMCEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import me.undergroundminer3.uee4.block.ModBlocks;
import me.undergroundminer3.uee4.handler.CraftingHandler;
import me.undergroundminer3.uee4.handler.GuiHandler;
import me.undergroundminer3.uee4.item.ModItems;
import me.undergroundminer3.uee4.proxy.IProxy;
import me.undergroundminer3.uee4.reference.EventHandlers;
import me.undergroundminer3.uee4.reference.Reference;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = "0.01")
public class UnequalExchange4
{
	@Instance
	public static UnequalExchange4 instance;

	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static IProxy proxy;

	@EventHandler
	public void invalidFingerprint(FMLFingerprintViolationEvent event)
	{

	}

	@EventHandler
	public void serverStarting(FMLServerStartingEvent event)
	{

	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		// Initialize mod items
		ModItems.init();

		// Initialize mod blocks
		ModBlocks.init();
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		// Register the GUI Handler
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());

		// Initialize mod tile entities
		proxy.registerTileEntities();

		// Initialize custom rendering and pre-load textures (Client only)
		proxy.initRenderingAndTextures();

		// Register the Items Event Handler
		FMLCommonHandler.instance().bus().register(EventHandlers.itemEventHandler);
		MinecraftForge.EVENT_BUS.register(EventHandlers.itemEventHandler);

		CraftingHandler.init();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{

	}

	@EventHandler
	public void handleIMCMessages(IMCEvent event)
	{

	}
}