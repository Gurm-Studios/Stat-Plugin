package net.gurm.studios.stat.plugin.commands;

import net.gurm.studios.stat.plugin.GUI;
import net.gurm.studios.stat.plugin.Stat_manager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Stat implements CommandExecutor {
    public Stat_manager s=new Stat_manager();
    public GUI gui=new GUI();
    //CommandSender sender,Command command,String label,String[] args커맨드
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        Player player=(Player)sender;
        if(sender instanceof Player) {
            if (((args[0].equalsIgnoreCase("명령어")) || args[0].equalsIgnoreCase("command")) && sender.isOp()) {
                player.sendMessage(
                        "스텟" + ChatColor.YELLOW + "player" + ChatColor.GOLD + "add" +
                                ChatColor.RESET + "스텟종류 수치\n" +
                                ChatColor.GRAY + "   수치만큼 스텟을 올립니다\n" +

                                "스텟" + ChatColor.YELLOW + "player" + ChatColor.GOLD + "min" +
                                ChatColor.RESET + "스텟종류 수치\n" +
                                ChatColor.GRAY + "   수치만큼 스텟을 내립니다\n" +

                                "스텟" + ChatColor.YELLOW + "player" + ChatColor.GOLD +
                                ChatColor.RESET + "스텟종류 수치\n" +
                                ChatColor.GRAY + "   수치만큼 스텟을 정합니다\n" +

                                "스텟" + ChatColor.GOLD + "확인" + ChatColor.YELLOW + "player\n" +
                                ChatColor.GRAY + "   player의 스텟을 확인 합니다\n");
            } else if (args.length == 0) {

            } else if (args[0].equalsIgnoreCase("확인") || args[0].equalsIgnoreCase("check") && args.length == 2) {
                long[] stat;
                stat = s.readstat(String.valueOf(Bukkit.getPlayer(args[1]).getUniqueId()));
                player.sendMessage("레벨:" + stat[0]
                        + "\n힘" + stat[5]
                        + "\n민첩" + stat[6]
                        + "\n멧집" + stat[7]
                        + "\n생명력" + stat[8]
                        + "\n마나" + stat[9]
                        + "\n마력" + stat[10]);
            } else {
                player.sendMessage("버~그");
            }
        }
        return false;
    }
}
