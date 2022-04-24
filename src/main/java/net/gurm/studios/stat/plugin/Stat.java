package net.gurm.studios.stat.plugin;

import org.bukkit.entity.Player;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Stat {

    public long[] readstat(String p) {
        File filen = new File("plugins/stat_plugin/player data" + p + ".txt");
        File folderl1 = new File("plugins/stat_plugin");
        File folderl2 = new File("plugins/stat_plugin/player data");
        long[] stat = new long[0];
        try {
            if (!filen.exists()) {
                folderl1.mkdir();
                folderl2.mkdir();
                filen.createNewFile();

            }
            BufferedWriter w = new BufferedWriter(new FileWriter(filen));
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
                    "mana_power:0\n" +
                    "L_mana_power:0\n" +
                    "money:0\n");
            w.flush();
            w.close();
            stat = new long[18];
            BufferedReader r = new BufferedReader(new FileReader(filen));
            List list = new ArrayList();
            String s;
            while (null != (s = r.readLine())) {
                list.add(Long.valueOf(cutter(s)));
            }
            r.close();
            for (int cnt = 0; cnt < 17; cnt++) {
                stat[cnt] = ((long) list.get(cnt));
            }
        } catch (Exception e) {
        }
        return stat;
    }

    public long cutter(String c) {
        String[] cut = c.split(":");
        return Long.parseLong(cut[1]);
    }

    public void Set_Stat(String p, long[] stat) {
        File filename = new File("plugins/stat_plugin/player data" + p + ".txt");
        File folderl1 = new File("plugins/stat_plugin");
        File folderl2 = new File("plugins/stat_plugin/player data");
        try {
            if (!filename.exists()) {
                folderl1.mkdir();
                folderl2.mkdir();
                filename.createNewFile();

            }
            BufferedWriter w= new BufferedWriter(new FileWriter(filename));
            w.append("level:"+stat[0]+"\r\n" +
                    "xp:"+stat[1]+"\r\n" +
                    "max_xp:"+stat[2]+"\r\n" +
                    "stat_point:"+stat[3]+"\r\n" +
                    "limit_point:"+stat[4]+"\r\n" +
                    "power:"+stat[5]+"\r\n" +
                    "L_power:"+stat[6]+"\r\n" +
                    "agility:"+stat[7]+"\n" +
                    "L_agility:"+stat[8]+"\n" +
                    "tenacious:"+stat[9]+"\n" +
                    "L_tenacious:"+stat[10]+"\n" +
                    "vitality:"+stat[11]+"\n" +
                    "L_vitality:"+stat[12]+"\n" +
                    "mana:"+stat[13]+"\n" +
                    "L_mana:"+stat[14]+"\n" +
                    "mana_power:"+stat[15]+"\n"+
                    "L_mana_power:"+stat[16]+"\n"+
                    "money:"+stat[17]+"\n");
            w.flush();
            w.close();
        } catch (IOException e) {

        }
    }
    public void Stat_up(long[] stat, Player player, int x)
    {
        if(x%2==1&&stat[3]>0){
            stat[x]=stat[x]+1;
            stat[3]=stat[3]-1;
            Set_Stat(player.getUniqueId().toString(),stat);
        }
        else if (x%2==0&&stat[4]>0&&stat[x-1]>stat[x])
        {
            stat[x]=stat[x]+1;
            stat[4]=stat[4]-1;
            Set_Stat(player.getUniqueId().toString(),stat);
        }
        else
        {
            player.sendMessage("스텟포인트가 부족합니다");
        }
    }
}
