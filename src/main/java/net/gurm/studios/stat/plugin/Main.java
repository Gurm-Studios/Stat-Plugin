package net.gurm.studios.stat.plugin;

import net.gurm.studios.stat.plugin.commands.Start;
import net.gurm.studios.stat.plugin.commands.Statc;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public Stat_manager s = new Stat_manager();
    public GUI  g = new GUI();

    @Override
    public void onEnable(){
        Bukkit.getPluginManager().registerEvents((Listener) this,this);
        getLogger().info("★Plugin [✔]");
        getCommand("스텟").setExecutor(new Statc());
        getCommand("시작").setExecutor(new Start());
    }



    @Override
    public void onDisable(){
        getLogger().info("★Plugin [❌]");
    }

    @EventHandler
    public void InventoryClick(InventoryClickEvent e){
        if(e.getInventory().getTitle().equals("스테이터스"))
        {
            e.setCancelled(true);
            g.SGUI_click(e);
        }
    }

    @EventHandler
    public void PlayerJoin(PlayerJoinEvent e)
    {
        s.readstat(e.getPlayer().getUniqueId().toString());
    }

}
