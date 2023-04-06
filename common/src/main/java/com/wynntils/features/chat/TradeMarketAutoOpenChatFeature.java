/*
 * Copyright © Wynntils 2022.
 * This file is released under AGPLv3. See LICENSE for full license details.
 */
package com.wynntils.features.chat;

import com.wynntils.core.components.Models;
import com.wynntils.core.config.Category;
import com.wynntils.core.config.ConfigCategory;
import com.wynntils.core.features.Feature;
import com.wynntils.handlers.chat.event.ChatMessageReceivedEvent;
import com.wynntils.mc.event.ScreenClosedEvent;
import com.wynntils.mc.event.ScreenOpenedEvent;
import com.wynntils.utils.mc.McUtils;
import java.util.regex.Pattern;
import net.minecraft.client.gui.screens.ChatScreen;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@ConfigCategory(Category.CHAT)
public class TradeMarketAutoOpenChatFeature extends Feature {
    // Type the price in emeralds or type 'cancel' to cancel:
    // Type the amount you wish to buy or type 'cancel' to cancel:
    // Type the item name or type 'cancel' to cancel:
    private static final Pattern TYPE_TO_CHAT_PATTERN = Pattern.compile("^§6Type the .* or type 'cancel' to cancel:$");

    private boolean openChatWhenContainerClosed = false;

    @SubscribeEvent
    public void onChatMessageReceive(ChatMessageReceivedEvent event) {
        if (!Models.WorldState.onWorld()) return;

        if (event.getOriginalCodedMessage().getMatcher(TYPE_TO_CHAT_PATTERN).matches()) {
            openChatWhenContainerClosed = true;
        }
    }

    @SubscribeEvent
    public void onScreenClose(ScreenClosedEvent event) {
        if (!openChatWhenContainerClosed) return;

        openChatWhenContainerClosed = false;
        McUtils.mc().setScreen(new ChatScreen(""));
    }

    @SubscribeEvent
    public void onScreenOpen(ScreenOpenedEvent.Post event) {
        openChatWhenContainerClosed = false;
    }
}
