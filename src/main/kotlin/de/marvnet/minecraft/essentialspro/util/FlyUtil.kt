package de.marvnet.minecraft.essentialspro.util

import de.marvnet.minecraft.essentialspro.main.EssentialsPro
import org.bukkit.entity.Player

class FlyUtil {
    fun setFlying(p: Player, state: Boolean) {
        p.allowFlight = state
    }

    fun toggleFlying(p: Player) {
        if(p.allowFlight) {
            setFlying(p, false)
            p.sendMessage(EssentialsPro.getConfigManager().getMessage("Flying_Disabled"))
        } else {
            setFlying(p, true)
            p.sendMessage(EssentialsPro.getConfigManager().getMessage("Flying_Enabled"))
        }
    }
}