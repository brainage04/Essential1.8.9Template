package com.yourname.yourmod;

import com.yourname.yourmod.commands.YourModConfigCommand;
import com.yourname.yourmod.config.YourModConfig;
import com.yourname.yourmod.keybinds.YourModConfigKeyBind;
import gg.essential.api.EssentialAPI;
import gg.essential.api.commands.Command;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.Nullable;

/*
Source: https://github.com/Sk1erLLC/Patcher/blob/master/src/main/java/club/sk1er/patcher/Patcher.java
 */

@Mod(modid = YourMod.MODID, name = YourMod.MODNAME, version = YourMod.VERSION, clientSideOnly = true)
public class YourMod {
    public static final String MODID = "yourmod";
    public static final String MODNAME = "Your Mod";
    public static final Logger LOGGER = LogManager.getLogger(MODID);

    @Mod.Instance(MODID)
    public static YourMod instance;

    public static final String VERSION = "1.0.0";

    private KeyBinding yourModConfigKeyBind;

    private YourModConfig yourModConfig;

    public static void printLogs(@Nullable EntityPlayerSP player, String message, boolean playSound, int verbosity) {
        String realMessage = ">> " + MODNAME + ": " + message;

        if (player != null) {
            player.addChatMessage(new ChatComponentText(realMessage));

            if (playSound) {
                player.playSound("game.player.hurt", 1, 1);
            }
        }

        LOGGER.info(realMessage);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        yourModConfig = YourModConfig.INSTANCE;

        registerKeybinds(
                yourModConfigKeyBind = new YourModConfigKeyBind()
        );

        registerCommands(
                new YourModConfigCommand()
        );

        registerEvents(
                yourModConfigKeyBind
        );

        printLogs(null, "Initialised successfully.", false, 0);
    }

    private void registerKeybinds(KeyBinding... keybinds) {
        for (KeyBinding keybind : keybinds) {
            ClientRegistry.registerKeyBinding(keybind);
        }
    }

    private void registerEvents(Object... events) {
        for (Object event : events) {
            MinecraftForge.EVENT_BUS.register(event);
        }
    }

    private void registerCommands(Command... commands) {
        for (Command command : commands) {
            EssentialAPI.getCommandRegistry().registerCommand(command);
        }
    }

    public YourModConfig getYourModConfig() {
        return yourModConfig;
    }

    public void forceSaveConfig() {
        this.yourModConfig.markDirty();
        this.yourModConfig.writeData();
    }
}
