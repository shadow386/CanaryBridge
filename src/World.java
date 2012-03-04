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
	
	public Type getType() {
		return Type.NORMAL; // TODO
	}

	public int getBlockData(int x, int y, int z) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getBlockIdAt(int x, int y, int z) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Block getBlockAt(int i, int j, int k) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isBlockPowered(Block block) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isBlockIndirectlyPowered(Block block) {
		// TODO Auto-generated method stub
		return false;
	}

	public void setBlock(Block block) {
		// TODO Auto-generated method stub
		
	}
	
}
