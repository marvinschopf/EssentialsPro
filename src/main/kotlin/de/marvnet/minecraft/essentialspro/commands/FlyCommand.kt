package de.marvnet.minecraft.essentialspro.commands

import de.marvnet.minecraft.essentialspro.main.EssentialsPro
import de.marvnet.minecraft.essentialspro.util.FlyUtil
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class FlyCommand: CommandExecutor {
    override fun onCommand(sender: CommandSender?, command: Command?, label: String?, args: Array<out String>?): Boolean {
        if(args!!.isEmpty()) {
            if(sender is Player) {
                if(sender.hasPermission("essentials.fly")) {
                    FlyUtil().toggleFlying(sender as Player)
                } else {
                    sender.sendMessage(EssentialsPro.getNoPermission())
                }
            } else {
                sender!!.sendMessage(EssentialsPro.getOnlyPlayer())
            }
        } else if(args.isNotEmpty() && args.size == 1) {
            if(sender!!.hasPermission("essentials.fly.others")) {
                val p: Player = Bukkit.getServer().getPlayer(args[0])
                if(p != null) {
                    FlyUtil().toggleFlying(p)
                    sender.sendMessage("§6The fly-mode for " + p.displayName + " has been toggled!")
                } else {
                    sender.sendMessage(EssentialsPro.getUnknownPlayer())
                }
            } else {
                sender.sendMessage(EssentialsPro.getNoPermission())
            }
        } else {
            sender!!.sendMessage(EssentialsPro.getUnknownArguments())
        }
        return true
    }
}