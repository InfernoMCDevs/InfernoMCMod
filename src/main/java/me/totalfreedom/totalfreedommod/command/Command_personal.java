package me.totalfreedom.totalfreedommod.command;

import java.util.Random;
import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FUtil;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

@CommandPermissions(level = Rank.SUPER_ADMIN, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Personal Admin Commands", usage = "/<command>", aliases = "psl")
public class Command_personal extends FreedomCommand
{

    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        String which;
        if (args.length >= 1)
        {
            if (!plugin.al.isAdmin(sender))
            {
                msg(sender, "You have no permissions.", ChatColor.GOLD);
            }
            which = args[0];
        }
        else if (sender.getName().equals("idkeagle"))
        {
            which = "multiEagle";
        }
        else
        {
            which = sender_p.getName();
        }
        
        
        switch (which)
        {
            case "SpringPhoenix":
                for (Player player : Bukkit.getOnlinePlayers())
                {
                    msg(ChatColor.WHITE + "SpringPhoenix: " + ChatColor.RED + "I AM THE PHOENIX GOD");
                    msg(ChatColor.WHITE + "SpringPhoenix: " + ChatColor.RED + "I BRING HOME, THE DEVIL'S SWORD!");
                    PlayerInventory inv = player.getInventory();
                    ItemStack thedevilsword = new ItemStack(Material.DIAMOND_SWORD, 1);
                    ItemMeta meta = thedevilsword.getItemMeta();
                    meta.setDisplayName(ChatColor.DARK_RED + "The Phoenix Devil's Sword");
                    meta.addEnchant(Enchantment.FIRE_ASPECT, 666, true);
                    meta.addEnchant(Enchantment.KNOCKBACK, 666, true);
                    thedevilsword.setItemMeta(meta);
                    inv.addItem(thedevilsword);
                }
                break;
            case "Typhlosion147":
                msg(sender, "your psl typh", ChatColor.GOLD);
                break;
                default:
                sender.sendMessage(ChatColor.DARK_RED + "You do not have a personal command currently.");
                break;
            }
        return true;
        }
     private static final Random random = new Random();
    public static final double STEPS = 10.0;

    private static Location randomOffset(Location a, double magnitude)
    {
        return a.clone().add(randomDoubleRange(-1.0, 1.0) * magnitude, randomDoubleRange(-1.0, 1.0) * magnitude, randomDoubleRange(-1.0, 1.0) * magnitude);
    }

    private static Double randomDoubleRange(double min, double max)
    {
        return min + (random.nextDouble() * ((max - min) + 1.0));
    }
        
}
