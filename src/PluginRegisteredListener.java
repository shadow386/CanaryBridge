
public class PluginRegisteredListener {

	private Plugin plugin;
	private PluginLoader.Hook hook;
	private PluginListener listener;
	private int priority;
	
	public PluginRegisteredListener(PluginLoader.Hook hook, PluginListener listener, Plugin plugin, int priority) {
		this.hook = hook;
		this.plugin = plugin;
		this.listener = listener;
		this.priority = priority;
	}
	
	public Plugin getPlugin() {
		return plugin;
	}
	
	public PluginLoader.Hook getHook() {
		return this.hook;
	}
	
	public int getPriority() {
		return this.priority;
	}
	
	public PluginListener getListener() {
		return this.listener;
	}
	
}
