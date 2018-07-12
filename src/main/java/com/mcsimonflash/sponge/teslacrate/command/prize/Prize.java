package com.mcsimonflash.sponge.teslacrate.command.prize;

import com.google.inject.Inject;
import com.mcsimonflash.sponge.teslacrate.command.CmdUtils;
import com.mcsimonflash.sponge.teslalibs.command.Aliases;
import com.mcsimonflash.sponge.teslalibs.command.Children;
import com.mcsimonflash.sponge.teslalibs.command.Command;
import com.mcsimonflash.sponge.teslalibs.command.Permission;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;

@Aliases({"prize"})
@Permission("teslacrate.command.prize.base")
@Children(Give.class)
public final class Prize extends Command {

    @Inject
    private Prize(Settings settings) {
        super(settings.usage(CmdUtils.usage("teslacrate prize ", "The base command for prizes.", CmdUtils.SUBCOMMAND_ARG)));
    }

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) {
        CmdUtils.getUsages(this).sendTo(src);
        return CommandResult.success();
    }

}
