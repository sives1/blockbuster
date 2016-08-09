package noname.blockbuster.network.server.director;

import net.minecraft.entity.player.EntityPlayerMP;
import noname.blockbuster.network.Dispatcher;
import noname.blockbuster.network.common.director.PacketDirectorMapCast;
import noname.blockbuster.network.common.director.PacketDirectorMapReset;
import noname.blockbuster.network.server.ServerMessageHandler;
import noname.blockbuster.tileentity.TileEntityDirectorMap;

/**
 * This handler resets director map block
 */
public class ServerHandlerDirectorMapReset extends ServerMessageHandler<PacketDirectorMapReset>
{
    @Override
    public void run(EntityPlayerMP player, PacketDirectorMapReset message)
    {
        TileEntityDirectorMap tile = ((TileEntityDirectorMap) player.worldObj.getTileEntity(message.pos));

        tile.reset();
        Dispatcher.sendTo(new PacketDirectorMapCast(tile.getCast(), message.pos), player);
    }
}