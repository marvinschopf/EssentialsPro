package de.marvnet.minecraft.essentialspro.util

import org.bukkit.entity.Player

class FlyUtil {
    fun setFlying(p: Player, state: Boolean) {
        p.allowFlight = state
    }

    fun toggleFlying(p: Player) {
        if(p.allowFlight) {
            setFlying(p, false)
            p.sendMessage("§6Flying mode has been disabled.")
        } else {
            setFlying(p, true)
            p.sendMessage("§6Flying mode has been enabled.")
        }
    }
}