package de.marvnet.minecraft.essentialspro.commands

import de.marvnet.minecraft.essentialspro.main.EssentialsPro
import de.marvnet.minecraft.essentialspro.util.BroadcastUtil
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class BroadcastCommand: CommandExecutor {
    override fun onCommand(sender: CommandSender?, command: Command?, label: String?, args: Array<out String>?): Boolean {
        if(sender!!.hasPermission("essentials.broadcast")) {
            if(args!!.isNotEmpty()) {
                BroadcastUtil().broadcast(args.joinToString(" "))
            } else {
                sender.sendMessage(EssentialsPro.getUnknownArguments())
            }
        } else {
            sender.sendMessage(EssentialsPro.getNoPermission())
        }
        return true
    }
}