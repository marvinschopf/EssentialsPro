package de.marvnet.minecraft.essentialspro.util

import de.marvnet.minecraft.essentialspro.main.EssentialsPro
import org.bukkit.GameMode
import org.bukkit.entity.Player

public class GamemodeUtil {
    public fun setGamemode(msgString: String, p: Player) {
        if(msgString == "0" || msgString == "survival" || msgString == "s") {
            if(p.hasPermission("essentials.gamemode.survival")) {
                p.gameMode = GameMode.SURVIVAL
                p.sendMessage(EssentialsPro.getConfigManager().getMessage("Gamemode_Survival"))
            } else {
                p.sendMessage(EssentialsPro.getNoPermission())
            }
        } else if(msgString == "1" || msgString == "creative" || msgString == "c") {
            if(p.hasPermission("essentials.gamemode.creative")) {
                p.gameMode = GameMode.CREATIVE
                p.sendMessage(EssentialsPro.getConfigManager().getMessage("Gamemode_Creative"))
            } else {
                p.sendMessage(EssentialsPro.getNoPermission())
            }
        } else if(msgString == "3" || msgString == "spectator" || msgString == "sp") {
            if(p.hasPermission("essentials.gamemode.spectator")) {
                p.gameMode = GameMode.SPECTATOR
                p.sendMessage(EssentialsPro.getConfigManager().getMessage("Gamemode_Spectator"))
            } else {
                p.sendMessage(EssentialsPro.getNoPermission())
            }
        } else if(msgString == "2" || msgString == "adventure" || msgString == "a") {
            if(p.hasPermission("essentials.gamemode.adventure")) {
                p.gameMode = GameMode.ADVENTURE
                p.sendMessage(EssentialsPro.getConfigManager().getMessage("Gamemode_Adventure"))
            } else {
                p.sendMessage(EssentialsPro.getNoPermission())
            }
        }
    }
}