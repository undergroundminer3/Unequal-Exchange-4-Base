package me.undergroundminer3.uee4.client.gui;

import me.undergroundminer3.uee4.init0.CoreInitHelper;
import net.minecraftforge.client.event.TextureStitchEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public final class TextureHook {

	@SubscribeEvent
	public final void stitchHook(final TextureStitchEvent.Pre evt) {
		CoreInitHelper.regTex(evt);
	}
}
