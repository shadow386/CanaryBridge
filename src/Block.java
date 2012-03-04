import java.util.HashMap;
import java.util.Map;

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

	// TODO
	
	public int getType() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

}
