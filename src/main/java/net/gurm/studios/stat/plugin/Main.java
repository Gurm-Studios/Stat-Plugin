package net.gurm.studios.stat.plugin;
import net.gurm.studios.stat.plugin.commands.start;
import net.gurm.studios.stat.plugin.commands.stat;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public class Main extends JavaPlugin {
    ConsoleCommandSender consol = Bukkit.getConsoleSender();
    HashMap<UUID, Integer> map = new HashMap<UUID, Integer>();

    public void onEnable(){
        getLogger().info("★Plugin [✔]");
        getCommand("스텟").setExecutor(new stat());
        getCommand("시작").setExecutor(new start());
    }
    public void onDisable(){
        getLogger().info("★Plugin [❌]");
    }




}
