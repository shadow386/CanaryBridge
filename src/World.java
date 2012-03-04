import java.util.HashMap;
import java.util.Map;


public class World {

	// TODO

    public enum Type {
        NETHER(-1),
        NORMAL(0);
        
        private int id;
        private static Map<Integer, Type> map;

        private Type(int id) {
            this.id = id;
            add(id, this);
        }

        private static void add(int type, Type name) {
            if (map == null)
                map = new HashMap<Integer, Type>();

            map.put(type, name);
        }

        public int getId() {
            return id;
        }

        public static Type fromId(final int type) {
            return map.get(type);
        }

    }
	
    private org.spout.api.geo.World spoutWorld;
    
	public World(org.spout.api.geo.World spoutWorld) {
		this.spoutWorld = spoutWorld;
	}

	public Type getType() {
		return Type.NORMAL; // TODO
	}

	public int getBlockData(int x, int y, int z) {
		return this.spoutWorld.getBlockData(x, y, z);
	}

	public int getBlockIdAt(int x, int y, int z) {
		return this.spoutWorld.getBlockId(x, y, z);
	}

	public Block getBlockAt(int x, int y, int z) {
		return new Block(this.spoutWorld.getBlock(x, y, z));
	}

	public boolean isBlockPowered(Block block) {
		return false; // TODO
	}

	public boolean isBlockIndirectlyPowered(Block block) {
		return false; // TODO
	}

	public void setBlock(Block block) {
		this.spoutWorld.setBlockIdAndData(block.getX(), block.getY(), block.getZ(), (short) block.getType(), (short) block.getData(), null);
	}

	public boolean setBlockAt(int id, int x, int y, int z) {
		return this.spoutWorld.setBlockId(x, y, z, (short) id, null);
	}

	public void setBlockData(int x, int y, int z, int data) {
		this.spoutWorld.setBlockData(x, y, z, (short) data, null);
		
	}

	public org.spout.api.geo.World getSpoutWorld() {
		return this.spoutWorld;
	}
	
	public long getTime() {
		return 0; // TODO
	}
	
    public long getRelativeTime() {
        long time = (getTime() % 24000);
        
        if (time < 0) time += 24000;
        
        return time;
    }
    
    public void setTime(long time) {
    	// TODO
    }
    
    public void setRelativeTime(long time) {
        long margin = (time - getTime()) % 24000;

        if (margin < 0) margin += 24000;
        
        setTime(getTime() + margin);
    }
    
    
	
}
