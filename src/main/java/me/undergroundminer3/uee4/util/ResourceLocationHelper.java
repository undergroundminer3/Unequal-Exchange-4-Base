package me.undergroundminer3.uee4.util;

import me.undergroundminer3.uee4.reference.Reference;
import net.minecraft.util.ResourceLocation;

public class ResourceLocationHelper
{
	public static ResourceLocation getResourceLocation(String modId, String path)
	{
		return new ResourceLocation(modId, path);
	}

	public static ResourceLocation getResourceLocation(String path)
	{
		return getResourceLocation(Reference.MOD_ID.toLowerCase(), path);
	}
}
