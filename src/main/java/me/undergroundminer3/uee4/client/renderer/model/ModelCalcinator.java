package me.undergroundminer3.uee4.client.renderer.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.undergroundminer3.uee4.reference.Models;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

@SideOnly(Side.CLIENT)
public class ModelCalcinator
{
	private IModelCustom modelCalcinator;

	public ModelCalcinator()
	{
		modelCalcinator = AdvancedModelLoader.loadModel(Models.CALCINATOR);
	}

	public void render()
	{
		modelCalcinator.renderAll();
	}

	public void renderPart(String partName)
	{
		modelCalcinator.renderPart(partName);
	}
}
