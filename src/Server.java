import org.spout.server.ConsoleManager;
import org.spout.server.SpoutServer;


public class Server {

	private SpoutServer spoutServer;
	
	public void init(SpoutServer spoutServer) {
		this.spoutServer = spoutServer;
	}
	
	public Server() {
	}
	
	public SpoutServer getSpoutServer() {
		return this.spoutServer;
	}
	
	public void messageAll(String message) {
		this.getSpoutServer().broadcastMessage(message);
	}
	
	public void ban(String player) {
		// TODO
	}
	
	public void unban(String player) {
		// TODO
	}
	
	public void useConsoleCommand(String command) {
		// TODO
	}
	
	public void useConsoleCommand(String command, Player player) {
		// TODO
	}
	
	public void setTimer(String uniqueString, int time) {
		// TODO
	}
	
	public World getDefaultWorld() {
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
	public World getWorld(int dimension) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
	// TODO: Other methods
	
}
