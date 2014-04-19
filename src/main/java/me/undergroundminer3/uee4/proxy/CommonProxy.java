package me.undergroundminer3.uee4.proxy;

import me.undergroundminer3.uee4.reference.Names;
import me.undergroundminer3.uee4.tileentity.TileAlchemicalChest;
import me.undergroundminer3.uee4.tileentity.TileAlchemicalChestLarge;
import me.undergroundminer3.uee4.tileentity.TileAlchemicalChestMedium;
import me.undergroundminer3.uee4.tileentity.TileAlchemicalChestSmall;
import cpw.mods.fml.common.registry.GameRegistry;

public abstract class CommonProxy implements IProxy
{
    public void registerTileEntities()
    {
        GameRegistry.registerTileEntity(TileAlchemicalChest.class, "tile." + Names.Blocks.ALCHEMICAL_CHEST);
        GameRegistry.registerTileEntity(TileAlchemicalChestSmall.class, "tile." + Names.Blocks.ALCHEMICAL_CHEST + "Small");
        GameRegistry.registerTileEntity(TileAlchemicalChestMedium.class, "tile." + Names.Blocks.ALCHEMICAL_CHEST + "Medium");
        GameRegistry.registerTileEntity(TileAlchemicalChestLarge.class, "tile." + Names.Blocks.ALCHEMICAL_CHEST + "Large");
    }
}
