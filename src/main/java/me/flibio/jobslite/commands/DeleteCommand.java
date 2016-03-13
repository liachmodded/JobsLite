/*
 * This file is part of JobsLite, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2015 - 2016 Flibio
 * Copyright (c) Contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package me.flibio.jobslite.commands;

import me.flibio.jobslite.JobsLite;
import me.flibio.jobslite.utils.JobManager;
import me.flibio.jobslite.utils.TextUtils;

import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.command.spec.CommandSpec.Builder;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

import io.github.flibio.utils.commands.AsyncCommand;
import io.github.flibio.utils.commands.BaseCommandExecutor;
import io.github.flibio.utils.commands.Command;
import io.github.flibio.utils.commands.ParentCommand;

import java.util.function.Consumer;

@AsyncCommand
@ParentCommand(parentCommand = JobsCommand.class)
@Command(aliases = {"delete", "del"})
public class DeleteCommand extends BaseCommandExecutor<Player> {

    private JobManager jobManager = JobsLite.access.jobManager;

    @Override
    public Builder getCommandSpecBuilder() {
        return CommandSpec.builder()
                .executor(this)
                .description(Text.of("Deletes a job."))
                .permission("jobs.delete");
    }

    @Override
    public void run(Player player, CommandContext args) {
        player.sendMessage(TextUtils.instruction("select the job you would like to delete"));
        for (String job : jobManager.getJobs()) {
            if (jobManager.jobExists(job)) {
                String displayName = jobManager.getDisplayName(job);
                if (!displayName.isEmpty()) {
                    player.sendMessage(TextUtils.option(new Consumer<CommandSource>() {

                        @Override
                        public void accept(CommandSource source) {
                            player.sendMessage(TextUtils.success("Are you sure you wish to delete " + displayName + "?", TextColors.GREEN));
                            player.sendMessage(TextUtils.yesOption(new Consumer<CommandSource>() {

                                @Override
                                public void accept(CommandSource source) {
                                    if (!jobManager.deleteJob(job)) {
                                        player.sendMessage(TextUtils.error("An error has occured!"));
                                        return;
                                    }
                                    player.sendMessage(TextUtils.success("Successfully deleted " + displayName + "!", TextColors.GREEN));
                                }

                            }));
                            player.sendMessage(TextUtils.noOption(new Consumer<CommandSource>() {

                                @Override
                                public void accept(CommandSource source) {
                                    player.sendMessage(TextUtils.error("Cancelled deletion of " + displayName + "!"));
                                    player.sendMessage(TextUtils.error("If you change your mind, you can click any of the above options again!"));
                                }

                            }));
                        }

                    }, jobManager.getColor(job), displayName));
                }
            }
        }
    }
}
