package net.gurm.studios.stat.plugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.conversations.PlayerNamePrompt;
import org.bukkit.entity.Player;

public class stat implements CommandExecutor {
    //CommandSender sender,Command command,String label,String[] args커맨드
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        Player player=(Player)sender;
        if(args[0].equals("명령어")||args.length==0){
            player.sendMessage(""" 
                                     스텟 player add 스텟종류 수치   수치만큼 스텟을 올립니다\n  
                                     스텟 player min 스텟종류 수치   수치만큼 스텟을 내립니다\n
                                     스텟 player set 스텟종류 수치   수치만큼 스텟을 정합니다 
                                     
                                     
                                     
                                     
                                     """);
        } else {
            if(args[1].equals("add")){

            }
            else if (args[1].equals("min")){

            }
            else if(args[1].equals("set")){

            }

        }
        return false;
    }
}