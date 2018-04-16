package de.marvnet.minecraft.essentialspro.commands

import de.marvnet.minecraft.essentialspro.main.EssentialsPro
import de.marvnet.minecraft.essentialspro.util.GamemodeUtil
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class GamemodeCommand: CommandExecutor {
    override fun onCommand(sender: CommandSender?, command: Command?, label: String?, args: Array<out String>?): Boolean {
        if(sender!!.hasPermission("essentials.gamemode")) {
            if(args!!.isNotEmpty()) {
                if(args.size == 1) {
                    if(sender is Player) {
                        val p: Player = sender as Player
                        GamemodeUtil().setGamemode(args[0], p)
                    } else {
                        sender.sendMessage(EssentialsPro.getOnlyPlayer())
                    }
                } else if(args.size == 2) {
                    if(sender.hasPermission("essentials.gamemode.others")) {
                        val p: Player? = Bukkit.getServer().getPlayer(args[0])
                        if(p != null) {
                            if(p.isOnline) {
                                GamemodeUtil().setGamemode(args[1], p)
                                sender.sendMessage(EssentialsPro.getConfigManager().getMessage("Gamemode_Others").replace("%name%", p.displayName).replace("%gamemode%", args[1]))
                            } else {
                                sender.sendMessage(EssentialsPro.getUnknownPlayer())
                            }
                        } else {
                            sender.sendMessage(EssentialsPro.getUnknownPlayer())
                        }
                    } else {
                        sender.sendMessage(EssentialsPro.getNoPermission())
                    }
                }
            }
        } else {
            sender.sendMessage(EssentialsPro.getNoPermission())
        }
        return true
    }
}