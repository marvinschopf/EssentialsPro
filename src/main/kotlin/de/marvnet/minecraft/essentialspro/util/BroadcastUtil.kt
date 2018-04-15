package de.marvnet.minecraft.essentialspro.util

import org.bukkit.Bukkit

class BroadcastUtil {
    fun broadcast(message: String) {
        Bukkit.getServer().broadcastMessage("§4[§aBroadcast§4]§f $message")
    }
}