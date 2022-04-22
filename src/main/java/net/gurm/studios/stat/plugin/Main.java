package net.gurm.studios.stat.plugin;

import net.gurm.studios.stat.plugin.commands.Start;
import net.gurm.studios.stat.plugin.commands.Statc;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public Stat s =new Stat();

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

    public void Chat(){

    }

    public void PlayerJoin(PlayerJoinEvent e)
    {
        s.readstat(e.getPlayer().getUniqueId().toString());
    }

}
