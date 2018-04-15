package de.marvnet.minecraft.essentialspro.util

import org.bukkit.entity.Player

class FlyUtil {
    fun setFlying(p: Player, state: Boolean) {
        p.isFlying = state
    }

    fun toggleFlying(p: Player) {
        if(p.isFlying) {
            setFlying(p, false)
            p.sendMessage("§6Flying mode has been disabled.")
        } else {
            setFlying(p, true)
            p.sendMessage("§6Flying mode has been enabled.")
        }
    }
}