package com.mcsimonflash.sponge.teslacrate.command.crate.edit.keys;

import com.mcsimonflash.sponge.teslacrate.TeslaCrate;
import com.mcsimonflash.sponge.teslacrate.component.Crate;
import com.mcsimonflash.sponge.teslacrate.component.Key;
import com.mcsimonflash.sponge.teslacrate.internal.Storage;
import com.mcsimonflash.sponge.teslacore.command.Arguments;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.command.spec.CommandSpec;

public class Add implements CommandExecutor {

    public static final CommandSpec COMMAND = CommandSpec.builder()
            .executor(new Add())
            .arguments(Arguments.map("crate", Storage.crates, Arguments.string("string")),
                    Arguments.map("key", Storage.keys, Arguments.string("string")),
                    GenericArguments.optional(Arguments.intt("quantity")))
            .permission("teslacrate.command.crate.edit.keys.add.base")
            .build();

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        Crate crate = args.<Crate>getOne("crate").get();
        Key key = args.<Key>getOne("key").get();
        Integer quantity = args.<Integer>getOne("quantity").orElse(key.getQuantity());
        crate.addKey(key, quantity);
        TeslaCrate.sendMessage(src, "teslacrate.command.crate.edit.keys.add.success", "crate", crate.getName(), "key", key.getName(), "quantity", quantity);
        return CommandResult.success();
    }

}