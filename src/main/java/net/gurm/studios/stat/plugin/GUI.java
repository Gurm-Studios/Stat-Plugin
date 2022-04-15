package net.gurm.studios.stat.plugin;

import com.sun.jdi.Value;
import net.gurm.studios.stat.plugin.commands.Stat;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

import java.util.Arrays;
import java.util.List;

public class GUI {
    public Stat s =new Stat();
    public net.gurm.studios.stat.plugin.commands.Stat s= new Stat();

    public void Stack(String display, int ID, int Data, int Stack, List<String> lore, int loc, Inventory inv){
        ItemStack Item= new MaterialData(ID,(byte)Data).toItemStack(Stack);
        ItemMeta Item_meta=Item.getItemMeta();
        Item_meta.setDisplayName(display);
        Item_meta.setLore(lore);
        Item.setItemMeta(Item_meta);
        inv.setItem(loc,Item);

    }
    public void SGUI(Player p){
        long[] i=new long[11];
        i=s.s.readstat(p.getUniqueId().toString());
        Inventory inv = Bukkit.createInventory(null,45,"스테이터스");
        Stack(ChatColor.BOLD + "" + ChatColor.DARK_PURPLE+ p,17,0,1, Arrays.asList("레벨"+i[0]+"\n"),5,inv);
    }
}
