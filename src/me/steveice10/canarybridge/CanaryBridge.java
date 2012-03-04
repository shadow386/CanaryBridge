package me.steveice10.canarybridge;

import java.io.File;
import java.io.IOException;
import org.spout.api.Spout;
import org.spout.api.plugin.CommonPlugin;
import org.spout.api.util.config.Configuration;

public class CanaryBridge extends CommonPlugin {

	private static File pluginFolder;
	
	private static Configuration config;
	
	@Override
	public void onDisable() {
		this.saveConfig();
		this.getGame().getLogger().info("[" + this.getDescription().getName() + "] " + this.getDescription().getFullName() + " has been disabled!");
	}

	@Override
	public void onEnable() {
		try {
			Class.forName("etc").getDeclaredMethod("init").invoke(null, new Object[] { });
		} catch (Exception e) {
			Spout.getGame().getLogger().severe("[CanaryBridge] Failed to init etc class!");
			e.printStackTrace();
			return;
		}
		
		this.loadConfig();
		
		pluginFolder = new File(this.getDataFolder(), "plugins");
		if(!pluginFolder.exists()) pluginFolder.mkdirs();
		
		try {
			Object pluginLoader = Class.forName("PluginLoader").getConstructor(new Class[] { }).newInstance(new Object[] { });
			Class.forName("PluginLoader").getDeclaredMethod("loadPlugins").invoke(pluginLoader, new Object[] { });
			Class.forName("PluginLoader").getDeclaredMethod("enablePlugins").invoke(pluginLoader, new Object[] { });
		} catch(Exception e) {
			this.getGame().getLogger().severe("[CanaryBridge] Failed to load CanaryBridge plugins!");
			e.printStackTrace();
		}
		
		this.getGame().getLogger().info("[" + this.getDescription().getName() + "] " + this.getDescription().getFullName() + " has been enabled!");
	}
	
	public void loadConfig() {
		File configFile = new File(this.getDataFolder(), "CanaryBridge.yml");
		
		boolean needsCreate = false;
		
		if(!configFile.exists()) {
			try {
				configFile.createNewFile();
			} catch (IOException e) {
				this.getGame().getLogger().severe("[CanaryBridge] Failed to create CanaryBridge.yml!");
				e.printStackTrace();
				return;
			}
			
			needsCreate = true;
		}
		
		if(configFile.isDirectory()) throw new IllegalStateException("Config can't be a directory!");
		
		config = new Configuration(configFile);
		config.load();
		
		if(needsCreate) {
			config.addNode("plugins", null);
			config.addNode("preloadplugins", null);
		}
	}
	
	public void saveConfig() {
		config.save();
	}
	
	public static String getPlugins() {
		return config.getString("plugins");
	}
	
	public static String getPreloadPlugins() {
		return config.getString("preloadplugins");
	}
	
	public static File getPluginFolder() {
		return pluginFolder;
	}

}
