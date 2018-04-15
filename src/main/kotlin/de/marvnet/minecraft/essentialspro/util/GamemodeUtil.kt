package de.marvnet.minecraft.essentialspro.util

import de.marvnet.minecraft.essentialspro.main.EssentialsPro
import org.bukkit.GameMode
import org.bukkit.entity.Player

public class GamemodeUtil {
    public fun setGamemode(msgString: String, p: Player) {
        if(msgString == "0" || msgString == "survival" || msgString == "s") {
            if(p.hasPermission("essentials.gamemode.survival")) {
                p.gameMode = GameMode.SURVIVAL
                p.sendMessage("§6Your gamemode has been set to Survival.")
            } else {
                p.sendMessage(EssentialsPro.getNoPermission())
            }
        } else if(msgString == "1" || msgString == "creative" || msgString == "c") {
            if(p.hasPermission("essentials.gamemode.creative")) {
                p.gameMode = GameMode.CREATIVE
                p.sendMessage("§6Your gamemode has been set to Creative.")
            } else {
                p.sendMessage(EssentialsPro.getNoPermission())
            }
        } else if(msgString == "3" || msgString == "spectator" || msgString == "sp") {
            if(p.hasPermission("essentials.gamemode.spectator")) {
                p.gameMode = GameMode.SPECTATOR
                p.sendMessage("§6Your gamemode has been set to Spectator.")
            } else {
                p.sendMessage(EssentialsPro.getNoPermission())
            }
        } else if(msgString == "2" || msgString == "adventure" || msgString == "a") {
            if(p.hasPermission("essentials.gamemode.adventure")) {
                p.gameMode = GameMode.ADVENTURE
                p.sendMessage("§6Your gamemode has been set to Adventure.")
            } else {
                p.sendMessage(EssentialsPro.getNoPermission())
            }
        }
    }
}