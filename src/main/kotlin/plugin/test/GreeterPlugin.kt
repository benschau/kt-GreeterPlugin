package plugin.test

import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.plugin.java.JavaPlugin
import java.sql.Time
import java.time.Instant
import java.util.logging.Logger

import kotlin.text.*

public class GreeterPlugin()
    : JavaPlugin(), Listener, CommandExecutor
{
    init {}

    companion object
    {
        val logger = Bukkit.getLogger()
    }

    override fun
    onEnable()
    {
        logger.entering("Main", "onEnable")
        logger.info("Enabling greeter plugin...")
        Bukkit.getPluginManager().registerEvents(this, this)
        //Bukkit.getScheduler().runTaskTimer(this, runTest(), 600, 600)
    }

    override fun
    onDisable()
    {
        logger.entering("Main", "onDisable")
        logger.info("Disabling greeter plugin...")
    }

    override fun
    onCommand(sender: CommandSender,
              command: Command,
              label: String,
              args: Array<out String>) : Boolean
    {
        if (sender is Player) {
            var player : Player = sender;

            when (command.name) {
                "help" -> {
                    player.sendMessage(getHelp())
                    return true;
                }
                else -> {
                    player.sendMessage(getHelp())
                    return true;
                }
            }
        }

        return false;
    }

    @EventHandler
    public fun
    greetingEvent(event: PlayerJoinEvent)
    {
        val player_name = event.player.getPlayerListName();
        Bukkit.broadcastMessage("$player_name joins the fold!");
        event.player.sendMessage("Welcome, $player_name.");
    }

    public fun
    getHelp() : String
    {
        return """Available commands:
               | help - prints this message.
               |""".trimMargin()
    }
}
