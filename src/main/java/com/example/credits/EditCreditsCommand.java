package com.example.credits;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import java.util.List;

public class EditCreditsCommand implements CommandExecutor {
    private final CreditsPlugin plugin;
    
    public EditCreditsCommand(CreditsPlugin plugin) {
        this.plugin = plugin;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Check if the sender has permission
        if (!sender.hasPermission("credits.edit")) {
            sender.sendMessage("§cYou don't have permission to use this command!");
            return true;
        }
        
        // Check if the command has enough arguments
        if (args.length < 1) {
            sender.sendMessage("§cUsage: /editcredits <add|remove> <line>");
            return false;
        }
        
        // Handle add command
        if (args[0].equalsIgnoreCase("add")) {
            if (args.length < 2) {
                sender.sendMessage("§cUsage: /editcredits add <line>");
                return false;
            }
            
            // Combine all remaining arguments into a single string
            StringBuilder creditLine = new StringBuilder();
            for (int i = 1; i < args.length; i++) {
                creditLine.append(args[i]);
                if (i < args.length - 1) {
                    creditLine.append(" ");
                }
            }
            
            // Add the credit line
            plugin.addCredit(creditLine.toString());
            sender.sendMessage("§aCredit line added successfully!");
            return true;
        }
        
        // Handle remove command
        if (args[0].equalsIgnoreCase("remove")) {
            if (args.length < 2) {
                sender.sendMessage("§cUsage: /editcredits remove <number>");
                return false;
            }
            
            try {
                // Parse the index
                int index = Integer.parseInt(args[1]) - 1; // Convert to 0-based index
                
                // Remove the credit line
                if (plugin.removeCredit(index)) {
                    sender.sendMessage("§aCredit line removed successfully!");
                } else {
                    sender.sendMessage("§cInvalid credit line number!");
                }
                return true;
            } catch (NumberFormatException e) {
                sender.sendMessage("§cInvalid number format!");
                return false;
            }
        }
        
        // Handle list command
        if (args[0].equalsIgnoreCase("list")) {
            // Get the credits list
            List<String> credits = plugin.getCredits();
            
            // Send header
            sender.sendMessage("§8§l----------[ §6§lCREDITS LIST §8§l]----------");
            
            // Send each credit line with its index
            for (int i = 0; i < credits.size(); i++) {
                sender.sendMessage("§7" + (i + 1) + ". §r" + credits.get(i));
            }
            
            // Send footer
            sender.sendMessage("§8§l----------------------------------------");
            return true;
        }
        
        // Unknown subcommand
        sender.sendMessage("§cUnknown subcommand! Use 'add', 'remove', or 'list'.");
        return false;
    }
}
