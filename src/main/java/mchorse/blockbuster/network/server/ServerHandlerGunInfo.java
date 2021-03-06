package mchorse.blockbuster.network.server;

import mchorse.blockbuster.capabilities.gun.Gun;
import mchorse.blockbuster.capabilities.gun.IGun;
import mchorse.blockbuster.network.Dispatcher;
import mchorse.blockbuster.network.common.guns.PacketGunInfo;
import mchorse.mclib.network.ServerMessageHandler;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class ServerHandlerGunInfo extends ServerMessageHandler<PacketGunInfo>
{
    @Override
    public void run(EntityPlayerMP player, PacketGunInfo message)
    {
        ItemStack stack = player.getHeldItemMainhand();
        IGun gun = Gun.get(stack);

        if (gun == null)
        {
            return;
        }

        gun.getProps().fromNBT(message.tag);

        IMessage packet = new PacketGunInfo(message.tag, player.getEntityId());

        Dispatcher.sendTo(packet, player);
        Dispatcher.sendToTracked(player, packet);
    }
}