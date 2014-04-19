package me.undergroundminer3.uee4.handler;

import cpw.mods.fml.common.network.IGuiHandler;
import me.undergroundminer3.uee4.client.gui.inventory.GuiAlchemicalChest;
import me.undergroundminer3.uee4.inventory.ContainerAlchemicalChest;
import me.undergroundminer3.uee4.reference.GuiIds;
import me.undergroundminer3.uee4.tileentity.TileAlchemicalChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler
{
    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
    {
        if (id == GuiIds.ALCHEMICAL_CHEST)
        {
            TileAlchemicalChest tileAlchemicalChest = (TileAlchemicalChest) world.getTileEntity(x, y, z);
            return new ContainerAlchemicalChest(player.inventory, tileAlchemicalChest);
        }

        return null;
    }

    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
    {
        if (id == GuiIds.ALCHEMICAL_CHEST)
        {
            TileAlchemicalChest tileAlchemicalChest = (TileAlchemicalChest) world.getTileEntity(x, y, z);
            return new GuiAlchemicalChest(player.inventory, tileAlchemicalChest);
        }

        return null;
    }
}
