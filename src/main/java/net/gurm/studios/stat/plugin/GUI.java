package net.gurm.studios.stat.plugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class GUI {
    public Stat s = new Stat();

    public GUI() {
    }

    public void Stack(String display, int ID, int Data, int Stack, List<String> lore, int loc, Inventory inv) {
        ItemStack Item = (new MaterialData(ID, (byte)Data)).toItemStack(Stack);
        ItemMeta Item_meta = Item.getItemMeta();
        Item_meta.setDisplayName(display);
        Item_meta.setLore(lore);
        Item.setItemMeta(Item_meta);
        inv.setItem(loc, Item);
    }

    public void SGUI(Player p) {
        long[] i;
        i = s.readstat(p.getUniqueId().toString());
        Inventory inv = Bukkit.createInventory(null, 45, "스테이터스");
        double percentage=(double) i[1]/(double) i[2]*100;
        Stack(ChatColor.BOLD + ""+ChatColor.DARK_PURPLE + p, 384, 0, 1,
                Arrays.asList("레벨:" + i[0], "경험치:" + i[1] + "/" + i[2]+"("+percentage+")",
                        "스텟포인트"+i[3],
                        "제한 스텟포인트"+i[4]), 4, inv);
        Stack(ChatColor.BOLD + ""+ChatColor.DARK_RED+"힘",276,0,1,
                Arrays.asList(),20,inv
                );
        Stack(ChatColor.BOLD + ""+ChatColor.YELLOW+"민첩",288,0,1,
                Arrays.asList(),29,inv
        );
        Stack(ChatColor.BOLD + ""+ChatColor.DARK_GREEN+"맷집",311,0,1,
                Arrays.asList(),22,inv
        );
        Stack(ChatColor.BOLD + ""+ChatColor.RED+"생명력",322/1,0,1,
                Arrays.asList(),31,inv
        );
        Stack(ChatColor.BOLD + ""+ChatColor.BLUE+"마나",351/4,0,1,
                Arrays.asList(),24,inv
        );
        Stack(ChatColor.BOLD + ""+ChatColor.DARK_BLUE+"마력",351/12,0,1,
                Arrays.asList(),33,inv
        );
        p.openInventory(inv);
    }
}
