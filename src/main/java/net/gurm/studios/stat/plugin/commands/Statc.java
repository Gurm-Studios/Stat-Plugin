package net.gurm.studios.stat.plugin.commands;

import net.gurm.studios.stat.plugin.GUI;
import net.gurm.studios.stat.plugin.Stat_manager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Statc implements CommandExecutor {
    public GUI gui = new GUI();
    public Stat_manager stat_manager=new Stat_manager();

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player)sender;
        if (args.length == 0) {
            gui.SGUI(player,player);
        }
        else if((args[0].equals("보기")||args[0].equals("see"))&&args.length==2){
            gui.SGUI(Bukkit.getPlayer(args[1]),player);
        }
        else if(player.isOp()==true && args[0].equalsIgnoreCase("명령어")){
            player.sendMessage("스텟" +
                    ChatColor.YELLOW + "player " + ChatColor.GOLD + "add " +
                    ChatColor.RESET + "스텟종류 수치\n" + ChatColor.GRAY + "수치만큼 스텟을 올립니다\n스텟" +
                    ChatColor.YELLOW + "player " + ChatColor.GOLD + "min " +
                    ChatColor.RESET + "스텟종류 수치\n" + ChatColor.GRAY + "수치만큼 스텟을 내립니다\n스텟" +
                    ChatColor.YELLOW + "player " + ChatColor.GOLD + "set " +
                    ChatColor.RESET + "스텟종류 수치\n" + ChatColor.GRAY + "수치만큼 스텟을 정합니다\n스텟" +
                    ChatColor.GOLD + "확인" + ChatColor.YELLOW + "player\n" +
                    ChatColor.GRAY + "player의 스텟을 확인 합니다\n");
        }
        else{
            player.sendMessage("스텟 "+ChatColor.GOLD + "확인 " + ChatColor.YELLOW + "player\n" +
                    ChatColor.GRAY + "player의 스텟을 확인 합니다\n");
        }

        return false;
    }
}
