package com.yourname.yourmod.keybinds;

import com.yourname.yourmod.YourMod;
import gg.essential.api.utils.GuiUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;

import java.util.Objects;

import static com.yourname.yourmod.YourMod.MODNAME;
import static com.yourname.yourmod.YourMod.printLogs;

/*
Source: https://github.com/Sk1erLLC/Patcher/blob/master/src/main/java/club/sk1er/patcher/util/keybind/KeybindDropModifier.java
 */

public class YourModConfigKeyBind extends KeyBinding {
    private final Minecraft minecraft = Minecraft.getMinecraft();

    public YourModConfigKeyBind() {
        super("Open Config GUI", Keyboard.KEY_U, MODNAME);
    }

    @SubscribeEvent
    public void tick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            final EntityPlayerSP player = minecraft.thePlayer;

            if (player != null && minecraft.currentScreen == null && this.isKeyDown()) {
                printLogs(player, "Opening Config GUI...", true, 0);

                GuiUtil.open(Objects.requireNonNull(YourMod.instance.getYourModConfig().gui()));
            }
        }
    }
}
