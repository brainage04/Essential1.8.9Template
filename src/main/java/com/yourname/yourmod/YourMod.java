package com.yourname.yourmod;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.Nullable;

@Mod(modid = YourMod.MODID, version = "1.0.0")
public class YourMod {
    public static final String MODID = "yourmod";
    public static final String MODNAME = "Your Mod";
    public static final Logger LOGGER = LogManager.getLogger(MODID);

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
        printLogs(null, "Initialised successfully.", false, 0);
    }
}
