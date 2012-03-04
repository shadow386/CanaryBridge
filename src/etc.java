import org.spout.api.Spout;
import org.spout.server.SpoutServer;


public class etc {

	private static final Server server = new Server();
	
	public static void init() {
		if(!(Spout.getGame() instanceof Server)) throw new IllegalStateException("Failed to find a GameServer!");
		
		if(!(Spout.getGame() instanceof SpoutServer)) throw new IllegalStateException("Failed to find a SpoutServer!");
		
		server.init((SpoutServer) Spout.getGame());
	}
	
	public static final Server getServer() {
		return server;
	}
	
}
