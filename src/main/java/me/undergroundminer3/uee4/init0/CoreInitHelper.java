package me.undergroundminer3.uee4.init0;

import java.io.File;

import buildcraft.BuildCraftCore;
import buildcraft.core.CoreIconProvider;
import buildcraft.core.triggers.ActionTriggerIconProvider;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.undergroundminer3.uee4.UnequalExchange4;
import me.undergroundminer3.uee4.client.gui.GuiHandler;
import me.undergroundminer3.uee4.client.icon.GuiIcons;
import me.undergroundminer3.uee4.config.Config;
import me.undergroundminer3.uee4.emc.EmcDataRegistry;
import me.undergroundminer3.uee4.handler.CraftingHandler;
import me.undergroundminer3.uee4.init1.ModConnectors;
import me.undergroundminer3.uee4.init2.EnginesInit;
import me.undergroundminer3.uee4.network2.ModNetworking;
import me.undergroundminer3.uee4.reference.EventHandlers;
import me.undergroundminer3.uee4.util2.CheatDetector;
import me.undergroundminer3.uee4.util2.LogHelper;

public final class CoreInitHelper {

	private CoreInitHelper() {};

	public static final void initCore(final File configDir) {
		EmcDataRegistry.init();
		Config.load(configDir);
		LogHelper.info("[UEE4] This is Unequal Exchange 4.");
	}

	public static final void init0() {//preinit1

		LogHelper.info("[UEE4] Loading into stage 0");

		//Initialization stage 1: Expect all references to be null

		// Initialize mod blocks
		InitBlocks.init0();

		// Initialize mod items
		InitItems.init0();

		ModConnectors.init0();
	}

	public static final void init1() { //preinit 2

		LogHelper.info("[UEE4] Loading into stage 1");

		//Initialization stage 2: We may connect to other blocks now.

		// Mod blocks
		InitBlocks.init1();

		// Mod items
		InitItems.init1();

		ModConnectors.init1();
	}

	public static final void init2() { //init 1

		LogHelper.info("[UEE4] Loading into stage 2");

		// Register the GUI Handler
		NetworkRegistry.INSTANCE.registerGuiHandler(UnequalExchange4.instance, new GuiHandler());

		ModNetworking.init();

		// Initialize mod tile entities
		UnequalExchange4.proxy.registerTileEntities();

		ModConnectors.init2();
		EnginesInit.init2();

		CheatDetector.detectCheats(false);
	}

	public static final void init3() { //init 2

		if (Config.forceNoClientInit) {
			LogHelper.warn("[UEE4] Skipping stage 3");
			return;
		}

		init3_do();
	}

	@SideOnly(Side.CLIENT)
	public static final void init3_do() {
		LogHelper.info("[UEE4] Loading into stage 3");

		// Initialize custom rendering and pre-load textures (Client only)
		UnequalExchange4.proxy.initRenderingAndTextures();

		// Register the Items Event Handler
		FMLCommonHandler.instance().bus().register(EventHandlers.itemEventHandler);
		MinecraftForge.EVENT_BUS.register(EventHandlers.itemEventHandler);

		CraftingHandler.init();
		EnginesInit.init3();

		ModConnectors.init3();
	}

	public static final void init4() { //postinit1

		LogHelper.info("[UEE4] Loading into stage 4");

		CheatDetector.detectCheats(true);

		ModConnectors.init4();
	}

	public static final void init5() { //postinit 2

		LogHelper.info("[UEE4] Loading into stage 5");

		ModConnectors.init5();
		jokeDinner();
	}

	public static final void jokeDinner() {
		LogHelper.info("[UEE4] Failed to EAT Industrial Craft 3, it does not exist yet!");
		LogHelper.info("[UEE4] Failed to EAT Thermal Expansion 4, it does not exist yet!");
		LogHelper.info("[UEE4] Failed to EAT Thuamcraft 5, it does not exist yet!");
		LogHelper.info("[UEE4] Failed to EAT MFFS Undergroundminer3 edition, it does not exist yet!");
		LogHelper.info("[UEE4] Failed to EAT Wireless redstone Undergroundminer3 edition, it does not exist yet!");

		LogHelper.info("");
		LogHelper.info("");

		LogHelper.info("[UEE4] You're using a Unequal Exchange 4 pre-release veresion");
	}

	public static final void ss_init0() {
		LogHelper.info("[UEE4] Server transitioned into UEE4 stage 0");
	}

	public static final void ss_init1() {
		LogHelper.info("[UEE4] Server transitioned into UEE4 stage 1");
		CheatDetector.detectCheats(false);
	}

	public static final void ss_init2() {
		LogHelper.info("[UEE4] Server transitioned into UEE4 stage 2");
	}

	public static final void ss_init3() {
		LogHelper.info("[UEE4] Server transitioned into UEE4 stage 3");
	}

	public static final void ss_halt3() {
		LogHelper.info("[UEE4] Server transitioned into UEE4 stage -3");
	}

	public static final void regTex(final TextureStitchEvent.Pre evt) {
		LogHelper.info("[UEE4] (re)Loading textures.");
		if (evt.map.getTextureType() == 1) {
			GuiIcons.INSTANCE.registerIcons(evt.map);
		} else if (evt.map.getTextureType() == 0) {
			GuiIcons.INSTANCE.registerBlockIcons(evt.map);
		}
	}

	public static final void ss_halt2() {
		LogHelper.info("[UEE4] Server transitioned into UEE4 stage -2");
	}

	public static final void ss_halt1() {
		LogHelper.info("[UEE4] Server transitioned into UEE4 stage -1");
	}

	public static final void ss_halt0() {
		LogHelper.info("[UEE4] Server transitioned into UEE4 stage -0");
	}

}
