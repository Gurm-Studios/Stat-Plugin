package net.gurm.studios.stat.plugin;

import org.bukkit.entity.Player;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Stat_manager {

    public long[] readstat(String p) {
        File file_name = new File("plugins/stat_plugin/player data" + p + ".txt");
        File folder_location1 = new File("plugins/stat_plugin");
        File folder_location2 = new File("plugins/stat_plugin/player data");
        long[] stat = new long[0];
        try {
            if (!file_name.exists()) {
                folder_location1.mkdir();
                folder_location2.mkdir();
                file_name.createNewFile();

            }
            BufferedWriter w = new BufferedWriter(new FileWriter(file_name));
            w.append("level:0\r\n" +
                    "xp:0\r\n" +
                    "max_xp:100\r\n" +
                    "stat_point:5\r\n" +
                    "limit_point:1\r\n" +
                    "power:0\r\n" +
                    "L_power:0\r\n" +
                    "agility:0\n" +
                    "L_agility:0\n" +
                    "tenacious:0\n" +
                    "L_tenacious:0\n" +
                    "vitality:0\n" +
                    "L_vitality:0\n" +
                    "mana:0\n" +
                    "L_mana:0\n" +
                    "mana_power:0\n"+
                    "L_mana_power:0\n"+
                    "money:0\n");
            w.flush();
            w.close();
            stat = new long[18];
            BufferedReader r = new BufferedReader(new FileReader(file_name));
            List list = new ArrayList();
            String s;
            while (null != (s = r.readLine())) {
                list.add(Long.valueOf(cutter(s)));
            }
            r.close();
            for (int cnt = 0; cnt < 10; cnt++) {
                stat[cnt] = ((long) list.get(cnt));
            }
        } catch (Exception e) {
        }
        return stat;
    }
    public long cutter(String c){
        String[] cut = c.split(":");
        return Long.parseLong(cut[1]);
    }
    public long[] stat_up(String data,Player p,int type){
        long[] stat=new long[0];
        return stat;
    }
}
