package me.undergroundminer3.uee4.client.renderer.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.undergroundminer3.uee4.reference.Models;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

@SideOnly(Side.CLIENT)
public class ModelResearchStation
{
	private IModelCustom modelResearchStation;

	public ModelResearchStation()
	{
		modelResearchStation = AdvancedModelLoader.loadModel(Models.RESEARCH_STATION);
	}

	public void render()
	{
		modelResearchStation.renderAll();
	}
}
