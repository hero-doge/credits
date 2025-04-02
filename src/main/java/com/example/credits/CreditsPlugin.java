package com.example.credits;

import org.bukkit.plugin.java.JavaPlugin;
import java.util.ArrayList;
import java.util.List;

public class CreditsPlugin extends JavaPlugin {
    private List<String> credits;
    
    @Override
    public void onEnable() {
        // Create default config if it doesn't exist
        saveDefaultConfig();
        
        // Load credits from config
        loadCredits();
        
        // Register commands
        getCommand("credits").setExecutor(new CreditsCommand(this));
        getCommand("editcredits").setExecutor(new EditCreditsCommand(this));
        
        getLogger().info("Credits plugin has been enabled!");
    }
    
    @Override
    public void onDisable() {
        // Save credits to config
        saveCredits();
        
        getLogger().info("Credits plugin has been disabled!");
    }
    
    /**
     * Load credits from config
     */
    public void loadCredits() {
        if (getConfig().contains("credits")) {
            credits = getConfig().getStringList("credits");
        } else {
            // Default credits
            credits = new ArrayList<>();
            credits.add("§6Created by: naomi/herodoge");
            credits.add("§bThanks for using this plugin!");
            
            // Save default credits
            getConfig().set("credits", credits);
            saveConfig();
        }
    }
    
    /**
     * Save credits to config
     */
    public void saveCredits() {
        getConfig().set("credits", credits);
        saveConfig();
    }
    
    /**
     * Get the credits list
     * @return List of credit lines
     */
    public List<String> getCredits() {
        return credits;
    }
    
    /**
     * Add a credit line
     * @param credit The credit line to add
     */
    public void addCredit(String credit) {
        credits.add(credit);
        saveCredits();
    }
    
    /**
     * Remove a credit line
     * @param index The index of the credit line to remove
     * @return true if successful, false otherwise
     */
    public boolean removeCredit(int index) {
        if (index >= 0 && index < credits.size()) {
            credits.remove(index);
            saveCredits();
            return true;
        }
        return false;
    }
}
