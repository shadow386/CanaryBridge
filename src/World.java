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
	
}
