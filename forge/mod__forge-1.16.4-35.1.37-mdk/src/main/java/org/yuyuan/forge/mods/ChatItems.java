package org.yuyuan.forge.mods;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ChatItems {
    private static final Logger LOGGER = LogManager.getLogger();

    @SubscribeEvent
    public void giveItems(ClientChatEvent event) {
        String it = "potato";
        if (event.getMessage().contains(it)) {
            LOGGER.info("YYYYYYYYYY - {}", it);
            Minecraft.getInstance().player.addItemStackToInventory(new ItemStack(Items.POTATO, 64));
        }
    }
}
