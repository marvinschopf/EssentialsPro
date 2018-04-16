package de.marvnet.minecraft.essentialspro.commands

import de.marvnet.minecraft.essentialspro.main.EssentialsPro
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class WarpCommand: CommandExecutor {
    override fun onCommand(sender: CommandSender?, command: Command?, label: String?, args: Array<out String>?): Boolean {
        if(sender!!.hasPermission("essentials.warp")) {
            if(args!!.size == 1) {
                if(sender is Player) {
                    val loc: Location? = EssentialsPro.getConfigManager().getLocation(args[0])
                    if(loc != null) {
                        (sender as Player).teleport(loc)
                        sender.sendMessage(EssentialsPro.getConfigManager().getMessage("Warped").replace("%point%", args[0]))
                    } else {
                        sender.sendMessage(EssentialsPro.getConfigManager().getMessage("Unknown_Warp"))
                    }
                } else {
                    sender.sendMessage(EssentialsPro.getOnlyPlayer())
                }
            } else if(args.size == 2) {
                if(sender.hasPermission("essentials.warp.others")) {
                    val p: Player? = Bukkit.getServer().getPlayer(args[0])
                    if(p != null) {
                        if(p.isOnline) {
                            val loc: Location? = EssentialsPro.getConfigManager().getLocation(args[1])
                            if(loc != null) {
                                p.teleport(loc)
                                sender.sendMessage(EssentialsPro.getConfigManager().getMessage("Warped_Other").replace("%name%", p.displayName).replace("%point%", args[1]))
                            } else {
                                sender.sendMessage(EssentialsPro.getConfigManager().getMessage("Unknown_Warp"))
                            }
                        } else {
                            sender.sendMessage(EssentialsPro.getUnknownPlayer())
                        }
                    } else {
                        sender.sendMessage(EssentialsPro.getUnknownPlayer())
                    }
                } else {
                    sender.sendMessage(EssentialsPro.getNoPermission())
                }
            } else {
                sender.sendMessage(EssentialsPro.getUnknownArguments())
            }
        } else {
            sender.sendMessage(EssentialsPro.getNoPermission())
        }
        return true
    }
}