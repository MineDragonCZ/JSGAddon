package nex.jsgaddon.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import nex.jsgaddon.loader.FromFile;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.io.IOException;

public class NoxReloadCommand extends CommandBase {
    @Override
    @Nonnull
    public String getName() {
        return "nox-reload";
    }

    @Override
    @Nonnull
    @ParametersAreNonnullByDefault
    public String getUsage(ICommandSender sender) {
        return "/now-reload";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }

    @Override
    @ParametersAreNonnullByDefault
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) {
        try {
            FromFile.reload();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sender.sendMessage(new TextComponentString("Reloaded!"));

    }
}
