package net.gurm.studios.stat.plugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public void onEnable(){
        getLogger().info("★Plugin [✔]");
    }
    //CommandSender sender,Command command,String label,String[] args커맨드
    public boolean onCommand(CommandSender sender,Command command,String label,String[] args){
        if(label.equalsIgnoreCase("스텟 명령어")){
            Player player=(Player)sender;
            player.sendMessage("스텟 player add 스텟종류 수치   수치만큼 스텟을 올립니다\n"+
                    "");
        }
        return true;
    }
    public void onDisable(){
        getLogger().info("★Plugin [❌]");
    }



}
