import java.util.HashMap;
import java.util.Map;

import org.spout.api.basic.blocks.SpoutBlock;

public class Block {

	/**
	 * Type - Used to identify blocks
	 */
	public enum Type {
		Air(0), 
		Stone(1), 
		Grass(2), 
		Dirt(3), 
		Cobblestone(4), 
		Wood(5), 
		Sapling(6), 
		Bedrock(7), 
		Water(8), 
		StationaryWater(9), 
		Lava(10), 
		StationaryLava(11), 
		Sand(12), 
		Gravel(13), 
		GoldOre(14), 
		IronOre(15), 
		CoalOre(16), 
		Log(17), 
		Leaves(18), 
		Sponge(19), 
		Glass(20), 
		LapisLazuliOre(21), 
		LapisLazuliBlock(22), 
		Dispenser(23), 
		SandStone(24), 
		NoteBlock(25), 
		Bed(26), 
		PoweredRails(27), 
		DetectorRails(28), 
		StickyPiston(29), 
		Web(30), 
		TallGrass(31), 
		DeadShrub(32), 
		Piston(33), 
		PistonExtended(34), 
		Cloth(35), 
		PistonBlockFiller(36), 
		YellowFlower(37), 
		RedRose(38), 
		BrownMushroom(39), 
		RedMushroom(40), 
		GoldBlock(41), 
		IronBlock(42), 
		DoubleStep(43), 
		Step(44), 
		Brick(45), 
		TNT(46), 
		BookShelf(47), 
		MossyCobblestone(48), 
		Obsidian(49), 
		Torch(50), 
		Fire(51), 
		MobSpawner(52), 
		WoodStairs(53), 
		Chest(54), 
		RedstoneWire(55), 
		DiamondOre(56), 
		Workbench(58), 
		Crops(59), 
		Soil(60), 
		Furnace(61), 
		BurningFurnace(62), 
		SignPost(63), 
		WoodDoor(64), 
		Ladder(65), 
		Rails(66), 
		CobblestoneStairs(67), 
		WallSign(68), 
		Lever(69), 
		StonePlate(70), 
		IronDoor(71), 
		WoodPlate(72), 
		RedstoneOre(73), 
		GlowingRedstoneOre(74), 
		RedstoneTorchOff(75), 
		RedstoneTorchOn(76), 
		StoneButton(77), 
		Snow(78), 
		Ice(79), 
		SnowBlock(80), 
		Cactus(81), 
		Clay(82), 
		Reed(83), 
		Jukebox(84), 
		Fence(85), 
		Pumpkin(86), 
		Netherstone(87), 
		SlowSand(88), 
		LightStone(89), 
		Portal(90), 
		JackOLantern(91), 
		Cake(92), 
		RedstoneRepeaterOff(93), 
		RedstoneRepeaterOn(94), 
		LockedChest(95), 
		Trapdoor(96), 
		SilverBlock(97), 
		StoneBrick(98), 
		HugeBrownMushroom(99), 
		HugeRedMushroom(100), 
		IronBars(101), 
		GlassPane(102), 
		MelonBlock(103), 
		PumpkinStem(104), 
		MelonStem(105), 
		Vine(106), 
		FenceGate(107), 
		BrickStair(108), 
		StonebrickStair(109);

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

		public int getType() {
			return id;
		}

		public static Type fromId(final int type) {
			return map.get(type);
		}
	}
	
    public enum Face {

        /**
         * The top of the block
         */
        Top(1),
        /**
         * The bottom of the block
         */
        Bottom(0),
        /**
         * The left (Z-wise) of the block (Faces west)
         */
        Left(3),
        /**
         * The right (Z-wise) of the block (Faces east)
         */
        Right(2),
        /**
         * The front (X-wise) of the block (Faces south)
         */
        Front(5),
        /**
         * The back (X-wise) of the block (Faces north)
         */
        Back(4);
        private final int id;

        private Face(int id) {
            this.id = id;
        }

        /**
         * Returns a Face according to the specified ID
         * 
         * @param id
         *            id of face
         * @return face
         */
        public static Face fromId(final int id) {
            for (Face e : Face.values())
                if (e.id == id)
                    return e;
            return null;
        }
    }

	private int type, x, y, z;
	private Face faceClicked;
	private Type blockType;
	private int status, data;
	private World world;
	
	public Block() {
	}
	
	public Block(org.spout.api.geo.cuboid.Block block) {
		this.type = block.getBlockId();
		this.x = block.getX();
		this.y = block.getY();
		this.z = block.getZ();
		this.blockType = Type.fromId(this.type);
		this.data = block.getWorld().getBlockData(x, y, z);
		this.world = new World(block.getWorld()); // TODO: Do this better.
	}
	
	public Block(int type) {
		this.type = type;
		this.blockType = Type.fromId(type);
	}
	
	public Block(int type, int x, int y, int z) {
		this(type, x, y, z, 0);
	}
	
	public Block(World world, int type, int x, int y, int z) {
		this(type, x, y, z);
		this.world = world;
	}
	
	public Block(int type, int x, int y, int z, int data) {
		this.type = type;
		this.x = x;
		this.y = y;
		this.z = z;
		this.data = data;
	}
	
    public Block(World world, int type, int x, int y, int z, int data) {
        this(type, x, y, z, data);
        this.world = world;
    }
    
    public Block(Type type, int x, int y, int z, int data) {
        this.type = type.getType();
        blockType = type;
        this.x = x;
        this.y = y;
        this.z = z;
        this.data = data;
    }
    
    public Block(Type type, int data) {
        this.type = type.getType();
        blockType = type;
        this.data = data;
    }
    
    public Block(Type type) {
        this.type = type.getType();
        blockType = type;
    }
    
    public int getType() {
    	return this.type;
    }
    
    public void setType(int type) {
    	this.blockType = Type.fromId(type);
    	this.type = type;
    }
    
    public int getX() {
    	return this.x;
    }
    
    public int getY() {
    	return this.y;
    }
    
    public int getZ() {
    	return this.z;
    }
    
    public void setX(int x) {
    	this.x = x;
    }
    
    public void setY(int y) {
    	this.y = y;
    }
    
    public void setZ(int z) {
    	this.z = z;
    }
    
    public Face getFaceClicked() {
    	return this.faceClicked;
    }
    
    public void setFaceClicked(Face face) {
    	this.faceClicked = face;
    }
    
    public int getStatus() {
        return status;
    }
    
    public void setStatus(int status) {
        this.status = status;
    }
    
    public int getData() {
        return data;
    }
    
    public void setData(int data) {
        this.data = data;
    }
    
    public World getWorld() {
        return world;
    }
    
    public void setWorld(World world) {
        this.world = world;
    }
    
    public void update() {
        world.setBlock(this);
    }
    
    public Block getFace(Face face) {
        if (face == null)
            return null;

        switch (face) {
            case Front:
                return getRelative(1, 0, 0);
            case Back:
                return getRelative(-1, 0, 0);
            case Top:
                return getRelative(0, 1, 0);
            case Bottom:
                return getRelative(0, -1, 0);
            case Left:
                return getRelative(0, 0, 1);
            case Right:
                return getRelative(0, 0, -1);
        }

        return null;
    }
    
    public void refresh() {
        type = world.getBlockIdAt(x, y, z);
        data = world.getBlockData(x, y, z);
        status = 0;
    }
    
    public Block getRelative(int x, int y, int z) {
        return world.getBlockAt(getX() + x, getY() + y, getZ() + z);
    }
    
    public boolean isPowered() {
        return world.isBlockPowered(this);
    }
    
    public boolean isIndirectlyPowered() {
        return world.isBlockIndirectlyPowered(this);
    }
    
    @Override
    public String toString() {
        return String.format("Block[x=%d, y=%d, z=%d, type=%d]", x, y, z, type);
    }
    
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Block other = (Block) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        if (z != other.z)
            return false;
        if (!world.equals(other.world))
            return false;
        return true;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + x;
        hash = 97 * hash + y;
        hash = 97 * hash + z;
        return hash;
    }
    
    public boolean isCloth() {
        return blockType == Type.Cloth;
    }
    
    public Cloth.Color getColor() {
        if (!isCloth())
            return null;
        else
            return Cloth.Color.getColor(data);
    }

}
