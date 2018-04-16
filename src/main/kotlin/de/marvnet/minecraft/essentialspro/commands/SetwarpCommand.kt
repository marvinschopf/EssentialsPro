package de.marvnet.minecraft.essentialspro.commands

import de.marvnet.minecraft.essentialspro.main.EssentialsPro
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class SetwarpCommand: CommandExecutor {
    override fun onCommand(sender: CommandSender?, command: Command?, label: String?, args: Array<out String>?): Boolean {
        if(sender!!.hasPermission("essentials.setwarp")) {
            if(sender is Player) {
                if(args!!.size == 1) {
                    val loc: Location = (sender as Player).location
                    if(EssentialsPro.getAsync()) {
                        Bukkit.getScheduler().runTaskAsynchronously(EssentialsPro.getPlugin(), {
                            if(EssentialsPro.getConfigManager().getString("warplist") == "None") {
                                EssentialsPro.getConfigManager().set("warplist", args[0], true)
                            } else {
                                EssentialsPro.getConfigManager().set("warplist", EssentialsPro.getConfigManager().getString("warplist") + ", " + args[0], true)
                            }
                            EssentialsPro.getConfigManager().setLocation(args[0], loc)
                            sender.sendMessage(EssentialsPro.getConfigManager().getMessage("Warp_Set").replace("%point%", args[0]))
                        })
                    } else {
                        if(EssentialsPro.getConfigManager().getString("warplist") == "None") {
                            EssentialsPro.getConfigManager().set("warplist", args[0], true)
                        } else {
                            EssentialsPro.getConfigManager().set("warplist", EssentialsPro.getConfigManager().getString("warplist") + ", " + args[0], true)
                        }
                        EssentialsPro.getConfigManager().setLocation(args[0], loc)
                        sender.sendMessage(EssentialsPro.getConfigManager().getMessage("Warp_Set").replace("%point%", args[0]))
                    }
                } else {
                    sender.sendMessage(EssentialsPro.getUnknownArguments())
                }
            } else {
                sender.sendMessage(EssentialsPro.getOnlyPlayer())
            }
        } else {
            sender.sendMessage(EssentialsPro.getNoPermission())
        }
        return true
    }
}