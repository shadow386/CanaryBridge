import java.io.File;


public abstract class Plugin {

	private String name = "";
	private boolean enabled = true;
	@SuppressWarnings("unused")
	private boolean usesListeners;
	
	/**
	 * Called when the plugin is enabled.
	 */
	public abstract void enable();
	
	/**
	 * Called when the plugin is disabled.
	 */
	public abstract void disable();
	
	/**
	 * Returns true if the plugin is enabled.
	 * 
	 * @return if the plugin is enabled.
	 */
	public boolean isEnabled() {
		return this.enabled;
	}
	
	/**
	 * Toggles the plugin's enabled state.
	 * 
	 * @return the new state.
	 */
	public boolean toggleEnabled() {
		this.enabled = !this.enabled;
		return this.enabled;
	}
	
	/**
	 * Sets the plugin's name
	 * 
	 * @param name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the name of this plugin
	 * 
	 * @return the plugin's name
	 */
	public String getName() {
		return this.name;
	}
	
	
	/**
	 * Called when the plugin is initialized
	 */
	public void initialize() {
		
	}
	
    /**
     * Returns the default PropertiesFile for this plugin.
     * @return plugins/NAME/NAME.properties
     */
    public final PropertiesFile getPropertiesFile() {
        File dir = new File("plugins/" + name);
        if (!dir.exists())
            dir.mkdirs();
        return new PropertiesFile("plugins/" + name + "/" + name + ".properties");
    }

    /**
     * Returns a PropertiesFile with the specified name for this plugin.
     * @param filename The filename without the extension ".properties". 
     * @return plugins/NAME/FILENAME.properties
     */
    public final PropertiesFile getPropertiesFile(String filename) {
        File dir = new File("plugins/" + name);
        if (!dir.exists())
            dir.mkdirs();
        return new PropertiesFile("plugins/" + name + "/" + filename + ".properties");
    }

    /**
     * Returns the default txt file for this plugin. The necessary directorys are created.
     * @return plugins/NAME/NAME.txt
     */
    public final File getTxtFile() {
        File dir = new File("plugins/" + name);
        if (!dir.exists())
            dir.mkdirs();
        return new File(dir, name + ".txt");
    }

    /**
     * Returns a txt file with the specified name for this plugin. The necessary directorys are created.
     * @param filename The filename without the extension ".txt". 
     * @return plugins/NAME/FILENAME.txt
     */
    public final File getTxtFile(String filename) {
        File dir = new File("plugins/" + name);
        if (!dir.exists())
            dir.mkdirs();
        return new File(dir, name + ".txt");
    }

    /**
     * Returns the default file with the specified type for this plugin. The necessary directorys are created.
     * @param filetype The filetype without the leading ".".
     * @return plugins/NAME/NAME.FILETYPE
     */
    public final File getFile(String filetype) {
        File dir = new File("plugins/" + name);
        if (!dir.exists())
            dir.mkdirs();
        return new File(dir, name + "." + filetype);
    }

    /**
     * Returns a file with the specified name and type for this plugin. The necessary directorys are created.
     * @param filename The filename without the extension.
     * @param filetype The filetype without the leading ".".
     * @return plugins/NAME/FILENAME.FILETYPE
     */
    public final File getFile(String filename, String filetype) {
        File dir = new File("plugins/" + name);
        if (!dir.exists())
            dir.mkdirs();
        return new File(dir, filename + "." + filetype);
    }

    /**
     * Returns the default directory for this plugin. If it doesn't exist, it's created.
     * @return plugins/NAME/
     */
    public final File getDirectory() {
        File dir = new File("plugins/" + name);
        if (!dir.exists())
            dir.mkdirs();
        return dir;
    }
}
