package me.undergroundminer3.uee4;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.*;
import me.undergroundminer3.uee4.init0.CoreInitHelper;
import me.undergroundminer3.uee4.proxy.IProxy;
import me.undergroundminer3.uee4.reference.Reference;
@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = "0.01", dependencies = Reference.DEPENDENCIES)

public final class UnequalExchange4 {
	@Instance
	public static UnequalExchange4 instance;

	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static IProxy proxy;

	@EventHandler
	public final void serverStarting(final FMLServerStartingEvent event) {
		CoreInitHelper.ss_init0();
		CoreInitHelper.ss_init1();
	}

	@EventHandler
	public final void serverStarted(final FMLServerStartedEvent event) {
		CoreInitHelper.ss_init2();
		CoreInitHelper.ss_init3();
	}


	@EventHandler
	public final void serverStopped(final FMLServerStoppedEvent event) {
		CoreInitHelper.ss_halt1();
		CoreInitHelper.ss_halt0();
	}

	@EventHandler
	public final void serverStopping(final FMLServerStoppingEvent event) {
		CoreInitHelper.ss_halt3();
		CoreInitHelper.ss_halt2();
	}

	@EventHandler
	public final void preInit(final FMLPreInitializationEvent event)
	{
		CoreInitHelper.initCore(event.getModConfigurationDirectory());

		CoreInitHelper.init0();

		CoreInitHelper.init1();

	}

	@EventHandler
	public final void init(FMLInitializationEvent event)
	{
		CoreInitHelper.init2();
		
		CoreInitHelper.init3();
	}

	@EventHandler
	public final void postInit(FMLPostInitializationEvent event)
	{
		CoreInitHelper.init4();
		
		CoreInitHelper.init5();
	}
}
