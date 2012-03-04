
public class Chunk {

	private final org.spout.api.geo.cuboid.Chunk spoutChunk;
	private World world;
	
	public Chunk(org.spout.api.geo.cuboid.Chunk spoutChunk) {
		this.spoutChunk = spoutChunk;
		this.world = new World(spoutChunk.getWorld()); // TODO: Do this better.
	}
	
	public org.spout.api.geo.cuboid.Chunk getSpoutChunk() {
		return this.spoutChunk;
	}
	
	public static Chunk getNewChunk(org.spout.api.geo.World world, int x, int z) {
		return getNewChunk(world, new byte[32768], x, z);
	}
	
	public static Chunk getNewChunk(org.spout.api.geo.World world, byte[] blocks, int x, int z) {
		return new Chunk(world.getChunk(x, 0, z));
	}
	
	public boolean isLoaded() {
		return this.spoutChunk.isLoaded();
	}
	
	public World getWorld() {
		// TODO: Do this better.
		if(this.spoutChunk.getWorld() != this.world.getSpoutWorld()) this.world = new World(this.spoutChunk.getWorld());
		
		return this.world;
	}
	
	public int getX() {
		return this.spoutChunk.getX();
	}
	
	public int getZ() {
		return this.spoutChunk.getZ();
	}
	
    public boolean setBlockIdAt(int x, int y, int z, int id) {
        if (isLoaded()) {
            return this.getWorld().setBlockAt(id, x | (getX() << 4), y, x | (getZ() << 4));
        } else {
            return false; // TODO: Set block at - chunk.
        }
    }
	
	public int getBlockIdAt(int x, int y, int z) {
		return this.spoutChunk.getBlockId(x, y, z);
	}
	
    public int getBlockDataAt(int x, int y, int z) {
        return this.spoutChunk.getBlockData(x, y, z);
    }
    
    public void setBlockDataAt(int x, int y, int z, int data) {
        if (isLoaded()) {
            this.getWorld().setBlockData(x | (getX() << 4), y, x | (getZ() << 4), data);
        } else {
        	// TODO: set block at - chunk
        }
    }
	
}
