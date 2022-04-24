package net.gurm.studios.stat.plugin;

import net.gurm.studios.stat.plugin.commands.Start;
import net.gurm.studios.stat.plugin.commands.Statc;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public Stat s = new Stat();
    public GUI  g = new GUI();

    @Override
    public void onEnable(){
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
        e.setCancelled(true);
        if(e.getInventory().getTitle().equals("스테이터스"))
        {
            g.SGUI_click(e);
        }
    }

    @EventHandler
    public void PlayerJoin(PlayerJoinEvent e)
    {
        s.readstat(e.getPlayer().getUniqueId().toString());
    }

}
