package com.yourname.yourmod.commands;

import com.yourname.yourmod.YourMod;
import gg.essential.api.commands.Command;
import gg.essential.api.commands.DefaultHandler;
import gg.essential.api.utils.GuiUtil;
import net.minecraft.client.Minecraft;

import java.util.Objects;

import static com.yourname.yourmod.YourMod.MODID;

public class YourModConfigCommand extends Command {
    public YourModConfigCommand() {
        super(MODID);
    }

    @DefaultHandler
    public void handle() {
        GuiUtil.open(Objects.requireNonNull(YourMod.instance.getYourModConfig().gui()));
    }
}
