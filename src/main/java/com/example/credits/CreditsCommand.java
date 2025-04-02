package com.example.credits;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import java.util.List;

public class CreditsCommand implements CommandExecutor {
    private final CreditsPlugin plugin;
    
    public CreditsCommand(CreditsPlugin plugin) {
        this.plugin = plugin;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Get the credits list
        List<String> credits = plugin.getCredits();
        
        // Send header
        sender.sendMessage("§8§l----------[ §6§lCREDITS §8§l]----------");
        
        // Send each credit line
        for (int i = 0; i < credits.size(); i++) {
            sender.sendMessage("§7" + (i + 1) + ". §r" + credits.get(i));
        }
        
        // Send footer
        sender.sendMessage("§8§l--------------------------------");
        
        return true;
    }
}
