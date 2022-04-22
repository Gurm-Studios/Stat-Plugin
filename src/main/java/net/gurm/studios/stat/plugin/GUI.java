package net.gurm.studios.stat.plugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

import java.util.Arrays;
import java.util.List;

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
        Inventory inv = Bukkit.createInventory(null, 54, ChatColor.DARK_PURPLE+"스테이터스");
        double percentage=(double) i[1]/(double) i[2]*100;
        Stack(ChatColor.BOLD + ""+ChatColor.DARK_PURPLE + p, 384, 0, 1,
                Arrays.asList("레벨:" + i[0], "경험치:" + i[1] + "/" + i[2]+"("+percentage+")",
                        "스텟포인트:"+i[3],
                        "제한 스텟포인트:"+i[4]), 4, inv);
        Stack(ChatColor.BOLD + "" + ChatColor.DARK_RED + "힘",276,0,1,
                Arrays.asList(ChatColor.DARK_GRAY+"현재 스텟:"+i[5]),20,inv
                );
        Stack(ChatColor.BOLD + "" + ChatColor.DARK_RED + "힘(제한 스텟)",276,0,1,
                Arrays.asList(ChatColor.DARK_GRAY+"현재 스텟:"+i[6]),29,inv
        );
        Stack(ChatColor.BOLD + "" + ChatColor.YELLOW + "민첩",288,0,1,
                Arrays.asList(ChatColor.DARK_GRAY+"현재 스텟:"+i[7]),38,inv
        );
        Stack(ChatColor.BOLD + "" + ChatColor.YELLOW + "민첩(제한 스텟)",288,0,1,
                Arrays.asList(ChatColor.DARK_GRAY+"현재 스텟:"+i[8]),47,inv
        );
        Stack(ChatColor.BOLD + "" + ChatColor.DARK_GREEN + "맷집",311,0,1,
                Arrays.asList(ChatColor.DARK_GRAY+"현재 스텟:"+i[9]),22,inv
        );
        Stack(ChatColor.BOLD + "" + ChatColor.DARK_GREEN + "맷집(제한 스텟)",311,0,1,
                Arrays.asList(ChatColor.DARK_GRAY+"현재 스텟:"+i[10]),31,inv
        );
        Stack(ChatColor.BOLD + "" + ChatColor.RED + "생명력",322,1,1,
                Arrays.asList(ChatColor.DARK_GRAY+"현재 스텟:"+i[11]),40,inv
        );
        Stack(ChatColor.BOLD + "" + ChatColor.RED + "생명력(제한 스텟)",322,1,1,
                Arrays.asList(ChatColor.DARK_GRAY+"현재 스텟:"+i[12]),49,inv
        );
        Stack(ChatColor.BOLD + "" + ChatColor.BLUE + "마나",351,4,1,
                Arrays.asList(ChatColor.DARK_GRAY+"현재 스텟:"+i[13]),24,inv
        );
        Stack(ChatColor.BOLD + "" + ChatColor.BLUE + "마나(제한 스텟)",351,4,1,
                Arrays.asList(ChatColor.DARK_GRAY+"현재 스텟:"+i[14]),33,inv
        );
        Stack(ChatColor.BOLD + "" + ChatColor.DARK_PURPLE + "마력",351,12,1,
                Arrays.asList(ChatColor.DARK_GRAY+"현재 스텟:"+i[15]),42,inv
        );
        Stack(ChatColor.BOLD + "" + ChatColor.DARK_PURPLE + "마력(제한 스텟)",351,12,1,
                Arrays.asList(ChatColor.DARK_GRAY+"현재 스텟:"+i[16]),51,inv
        );
        p.openInventory(inv);
    }



    public void SGUI_click(InventoryClickEvent e)
    {
        e.setCancelled(true);
        Player p=(Player) e.getWhoClicked();
        if(ChatColor.stripColor(e.getInventory().getName()).equalsIgnoreCase("스테이터스"))
        {
            if(e.getCurrentItem()==null||
               e.getCurrentItem().getType()== Material.AIR||
               e.getCurrentItem().hasItemMeta())
            {
                return;
            }
            else
            {
                long[] i=new long[11];
                i=s.readstat(p.getUniqueId().toString());
                switch (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()))
                {
                    case "힘":
                        break;
                    case "힘(제한 스텟)":
                        break;
                    case "민첩":
                        break;
                    case "민첩(제한 스텟)":
                        break;
                    case "맷집":
                        break;
                    case "맷집(제한 스텟)":
                        break;
                    case "생명력":
                        break;
                    case "생명력(제한 스텟)":
                        break;
                    case "마나":
                        break;
                    case "마나(제한 스텟)":
                        break;
                    case "마력":
                        break;
                    case "마력(제한 스텟)":
                        break;
                }
            }
        }
    }

}
