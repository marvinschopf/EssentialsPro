package de.marvnet.minecraft.essentialspro.util

import de.marvnet.minecraft.essentialspro.main.EssentialsPro
import org.bukkit.Bukkit

class BroadcastUtil {
    fun broadcast(message: String) {
        Bukkit.getServer().broadcastMessage(EssentialsPro.getConfigManager().getMessage("Broadcast").replace("%message%", message))
    }
}