import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import org.spout.api.Spout;

/**
 * Used for accessing or creating .[properties] files.
 */
public final class PropertiesFile {

	private File propFile;
	private Properties props = new Properties();
	
	/**
	 * Creates a properties file using the specified filename.
	 */
	public PropertiesFile(String file) {
		if(file.equals("server.properties")) {
			Spout.getGame().getLogger().warning("[CanaryBridge] Warning! Attempted access of server.properties!");
		}
		
			this.propFile = new File(file);
			
			if(!this.propFile.exists()) {
				try {
					this.propFile.createNewFile();
				} catch (IOException e) {
					Spout.getGame().getLogger().info("[CanaryBridge] Failed to create properties for file + " + file + "!");
					e.printStackTrace();
					return;
				}
			}
			
			if(this.propFile.isDirectory()) throw new IllegalArgumentException("File can't be a directory!");
			
			if(this.propFile != null && this.propFile.exists() && !this.propFile.isDirectory()) this.load();
	}
	
	/**
	 * Loads the properties file.
	 */
	public void load() {
		FileInputStream stream = null;
				
		try {
			stream = new FileInputStream(this.propFile);
			props.load(stream);
		} catch(IOException ioe) {
			Spout.getGame().getLogger().info("[CanaryBridge] Failed to load properties for file + " + this.propFile.getName() + "!");
			ioe.printStackTrace();
		} finally {
			if(stream != null) {
				try {
					stream.close();
				} catch (IOException e) {
					Spout.getGame().getLogger().info("[CanaryBridge] Failed to close stream for file + " + this.propFile.getName() + "!");
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * Saves the properties file.
	 */
    public void save() {
        FileOutputStream stream = null;
        
        try {
            stream = new FileOutputStream(this.propFile);
            props.store(stream, null);
        } catch (IOException ioe) {
			Spout.getGame().getLogger().info("[CanaryBridge] Failed to save properties for file + " + this.propFile.getName() + "!");
			ioe.printStackTrace();
        } finally {
			if(stream != null) {
				try {
					stream.close();
				} catch (IOException e) {
					Spout.getGame().getLogger().info("[CanaryBridge] Failed to close stream for file + " + this.propFile.getName() + "!");
					e.printStackTrace();
				}
			}
        }
    }
    
    /**
     * Returns a map of all the "key=value" properties in the file
     * 
     * @return the map of all properties.
     */
    @SuppressWarnings("unchecked")
	public Map<String, String> returnMap() throws Exception {
    	return (Map<String, String>) props.clone();
    }
    
    /**
     * Returns true if the properties file has the key specified.
     * @param key to check for
     * @return if the properties file has the key
     */
    public boolean containsKey(String key) {
    	return props.containsKey(key);
    }
    
    /**
     * Gets the property for this key
     * @param key to get the property for
     * @return the property for the key
     */
    public String getProperty(String key) {
    	return props.getProperty(key);
    }
    
    // TODO: Rest of the methods
	
}
