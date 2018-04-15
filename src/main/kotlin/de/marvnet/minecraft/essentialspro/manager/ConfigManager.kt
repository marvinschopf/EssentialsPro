package de.marvnet.minecraft.essentialspro.manager

import de.marvnet.minecraft.essentialspro.main.EssentialsPro
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File

class ConfigManager {

    var configFile: File? = null
    var config: YamlConfiguration = YamlConfiguration()

    fun save() {
        config.save(configFile)
    }

    fun get(key: String): Any? {
        return config.get(key)
    }

    fun getMessage(messageID: String): String {
        return (get("messages." + messageID.replace(" ", "_")) as String).replace("%prefix%", EssentialsPro.getPrefix())
    }

    fun set(key: String, value: Any, autosave: Boolean = true) {
        config.set(key, value)
        if(autosave) {
            save()
        }
    }

    fun initFiles() {
        val folder = File("plugins//EssentialsPro//players")
        if(!folder.exists()) {
            folder.mkdirs()
        }

        configFile = File("plugins//EssentialsPro//config.yml")
        var fileFilled = true
        if(!configFile!!.exists()) {
            configFile!!.createNewFile()
            fileFilled = false
        }
        config = YamlConfiguration.loadConfiguration(configFile)
        if(!fileFilled) {
            set("messages.Plugin_Enabled", "%prefix% §aThe plugin has been enabled!", false)
            set("messages.Plugin_Disabled", "%prefix% §aThe plugin has been disabled!", false)
            set("messages.Flying_Enabled", "§6Flying mode has been enabled.", false)
            set("messages.Flying_Disabled", "§6Flying mode has been disabled.", false)
            set("messages.Broadcast", "§4[§aBroadcast§4]§f %message%", false)
            set("messages.Flying_Other_Toggled", "§6The fly-mode for %name% has been toggled!", false)
            set("messages.Gamemode_Survival", "§6Your gamemode has been set to Survival.", false)
            set("messages.Gamemode_Creative", "§6Your gamemode has been set to Creative.", false)
            set("messages.Gamemode_Adventure", "§6Your gamemode has been set to Adventure.", false)
            set("messages.Gamemode_Spectator", "§6Your gamemode has been set to Spectator.", false)
            set("messages.Gamemode_Others", "§6The gamemode for %name% has been set to %gamemode%.", false)

            save()
        }
    }

    fun init() {
        initFiles()
    }
}