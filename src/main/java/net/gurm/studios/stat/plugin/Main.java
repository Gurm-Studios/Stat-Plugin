package net.gurm.studios.stat.plugin;

import net.gurm.studios.stat.plugin.commands.Start;
import net.gurm.studios.stat.plugin.commands.Stat;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public class Main extends JavaPlugin {

    public void onEnable(){
        getLogger().info("★Plugin [✔]");
        getCommand("스텟").setExecutor(new Stat());
        getCommand("시작").setExecutor(new Start());
    }
    public void onDisable(){
        getLogger().info("★Plugin [❌]");
    }


}
