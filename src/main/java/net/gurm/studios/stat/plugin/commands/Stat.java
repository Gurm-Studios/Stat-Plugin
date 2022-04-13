package net.gurm.studios.stat.plugin.commands;

import com.comphenix.protocol.wrappers.EnumWrappers;
import net.gurm.studios.stat.plugin.stat;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.conversations.PlayerNamePrompt;
import org.bukkit.entity.Player;

import java.util.Objects;

public class Stat implements CommandExecutor {
    public stat s =new stat();
    //CommandSender sender,Command command,String label,String[] args커맨드
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        Player player=(Player)sender;
        if((args.length==0) || (args[0].equalsIgnoreCase("명령어"))||args[0].equalsIgnoreCase("command")){
            player.sendMessage(
                    "스텟" +ChatColor.YELLOW + "player"+ ChatColor.GOLD+"add"+ "스텟종류 수치\n"+
                            "수치만큼 스텟을 올립니다\n"+

                    "스텟" +ChatColor.YELLOW + "player"+ ChatColor.GOLD+"min"+ "스텟종류 수치\n"+
                            "수치만큼 스텟을 내립니다\n"+

                    "스텟" +ChatColor.YELLOW + "player"+ ChatColor.GOLD+"스텟종류 수치\n"+
                            "수치만큼 스텟을 정합니다\n"+

                    "스텟"+ ChatColor.GOLD+"확인" + ChatColor.YELLOW + "player\n"+
                            "player의 스텟을 확인 합니다\n");
        }
        else if (args[0].equalsIgnoreCase("확인") || args[0].equalsIgnoreCase("check") && args.length==2)
        {
            long[] stat ;
            stat=s.readstat(String.valueOf(Bukkit.getPlayer(args[1]).getUniqueId()));
            player.sendMessage("레벨:"+stat[0]
                                +"\n힘"+stat[5]
                                +"\n민첩"+stat[6]
                                +"\n멧집"+stat[7]
                                +"\n생명력"+stat[8]
                                +"\n마나"+stat[9]
                                +"\n마력"+stat[10]);
            player.sendMessage("됬는데");
        }
        else {
            player.sendMessage("버~그");
        }
        return false;
    }
}
