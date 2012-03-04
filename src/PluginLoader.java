import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import me.steveice10.hSpout.hSpout;

import org.spout.api.Spout;

public class PluginLoader {

	public enum Hook {
		/**
		 * Calls {@link PluginListener#onLoginChecks(java.lang.String) }
		 */
		LOGINCHECK,
		/**
		 * Calls {@link PluginListener#onLogin(Player) }
		 */
		LOGIN,
		/**
		 * Calls {@link PluginListener#onChat(Player, java.lang.String) }
		 */
		CHAT,
		/**
		 * Calls {@link PluginListener#onCommand(Player, java.lang.String[]) }
		 */
		COMMAND,
		/**
		 * Calls {@link PluginListener#onConsoleCommand(java.lang.String[]) }
		 */
		SERVERCOMMAND,
		/**
		 * Calls {@link PluginListener#onBan(Player, Player, java.lang.String) }
		 */
		BAN,
		/**
		 * Calls
		 * {@link PluginListener#onIpBan(Player, Player, java.lang.String) }
		 */
		IPBAN,
		/**
		 * Calls {@link PluginListener#onKick(Player, Player, java.lang.String) }
		 */
		KICK,
		/**
		 * Calls {@link PluginListener#onBlockCreate(Player, Block, Block, int) }
		 */
		BLOCK_CREATED,
		/**
		 * Calls {@link PluginListener#onBlockDestroy(Player, Block) }
		 */
		BLOCK_DESTROYED,
		/**
		 * Calls {@link PluginListener#onDisconnect(Player) }
		 */
		DISCONNECT,
		/**
		 * Calls {@link PluginListener#onPlayerMove(Player, Location, Location) }
		 */
		PLAYER_MOVE,
		/**
		 * Calls {@link PluginListener#onArmSwing(Player) }
		 */
		ARM_SWING,
		/**
		 * Calls {@link PluginListener#onItemDrop(Player, ItemEntity) }
		 */
		ITEM_DROP,
		/**
		 * Calls {@link PluginListener#onItemPickUp(Player, ItemEntity) }
		 */
		ITEM_PICK_UP,
		/**
		 * Calls {@link PluginListener#onTeleport(Player, Location, Location) }
		 */
		TELEPORT,
		/**
		 * Calls {@link PluginListener#onBlockBreak(Player, Block) }
		 */
		BLOCK_BROKEN,
		/**
		 * Calls {@link PluginListener#onIgnite(Block, Player) }
		 */
		IGNITE,
		/**
		 * Calls {@link PluginListener#onFlow(Block, Block) }
		 */
		FLOW,
		/**
		 * Calls {@link PluginListener#onExplode(Block) }
		 */
		EXPLODE,
		/**
		 * Calls {@link PluginListener#onMobSpawn(Mob) }
		 */
		MOB_SPAWN,
		/**
		 * Calls
		 * {@link PluginListener#onDamage(PluginLoader.DamageType, BaseEntity, BaseEntity, int) }
		 */
		DAMAGE,
		/**
		 * Calls {@link PluginListener#onHealthChange(Player, int, int) }
		 */
		HEALTH_CHANGE,
		/**
		 * Calls {@link PluginListener#onRedstoneChange(Block, int, int) }
		 */
		REDSTONE_CHANGE,
		/**
		 * Calls {@link PluginListener#onPistonExtend(Block, Boolean) }
		 */
		PISTON_EXTEND,
		/**
		 * Calls {@link PluginListener#onPistonRetract(Block, Boolean) }
		 */
		PISTON_RETRACT,
		/**
		 * Calls {@link PluginListener#onBlockPhysics(Block, boolean) }
		 */
		BLOCK_PHYSICS,
		/**
		 * Calls {@link PluginListener#onVehicleCreate(BaseVehicle) }
		 */
		VEHICLE_CREATE,
		/**
		 * Calls {@link PluginListener#onVehicleUpdate(BaseVehicle) }
		 */
		VEHICLE_UPDATE,
		/**
		 * Calls
		 * {@link PluginListener#onVehicleDamage(BaseVehicle, BaseEntity, int) }
		 */
		VEHICLE_DAMAGE,
		/**
		 * Calls
		 * {@link PluginListener#onVehicleCollision(BaseVehicle, BaseEntity) }
		 */
		VEHICLE_COLLISION,
		/**
		 * Calls {@link PluginListener#onVehicleDestroyed(BaseVehicle) }
		 */
		VEHICLE_DESTROYED,
		/**
		 * Calls {@link PluginListener#onVehicleEnter(BaseVehicle, HumanEntity) }
		 */
		VEHICLE_ENTERED,
		/**
		 * Calls
		 * {@link PluginListener#onVehiclePositionChange(BaseVehicle, int, int, int) }
		 */
		VEHICLE_POSITIONCHANGE,
		/**
		 * Calls {@link PluginListener#onItemUse(Player, Block, Block, Item) }
		 */
		ITEM_USE,
		/**
		 * Calls {@link PluginListener#onBlockPlace(Player, Block, Block, Item) }
		 */
		BLOCK_PLACE,
		/**
		 * Calls {@link PluginListener#onBlockRightClicked(Player, Block, Item) }
		 */
		BLOCK_RIGHTCLICKED,
		/**
		 * Calls
		 * {@link PluginListener#onLiquidDestroy(PluginLoader.HookResult, int, Block) }
		 */
		LIQUID_DESTROY,
		/**
		 * Calls
		 * {@link PluginListener#onAttack(LivingEntity, LivingEntity, java.lang.Integer) }
		 */
		ATTACK,
		/**
		 * Calls {@link PluginListener#onOpenInventory(Player, Inventory) }
		 */
		OPEN_INVENTORY,
		/**
		 * Calls {@link PluginListener#onSignShow(Player, Sign) }
		 */
		SIGN_SHOW,
		/**
		 * Calls {@link PluginListener#onSignChange(Player, Sign) }
		 */
		SIGN_CHANGE,
		/**
		 * Calls {@link PluginListener#onLeafDecay(Block) }
		 */
		LEAF_DECAY,
		/**
		 * Calls {@link PluginListener#onTame(Player, Mob) }
		 */
		TAME,
		/**
		 * Calls {@link PluginListener#onLightningStrike(BaseEntity) }
		 */
		LIGHTNING_STRIKE,
		/**
		 * Calls {@link PluginListener#onWeatherChange(boolean) }
		 */
		WEATHER_CHANGE,
		/**
		 * Calls {@link PluginListener#onThunderChange(boolean) }
		 */
		THUNDER_CHANGE,
		/**
		 * Calls {@link PluginListener#onPortalUse(Player, World) }
		 */
		PORTAL_USE,
		/**
		 * Calls {@link PluginListener#onChunkCreate(int, int, World) }
		 */
		CHUNK_CREATE,
		/**
		 * Calls {@link PluginListener#onSpawnpointCreate(World) }
		 */
		SPAWNPOINT_CREATE,
		/**
		 * Calls {@link PluginListener#onChunkCreated(Chunk chunk) }
		 */
		CHUNK_CREATED,
		/**
		 * Calls {@link PluginListener#onChunkLoaded(Chunk chunk) }
		 */
		CHUNK_LOADED,
		/**
		 * Calls {@link PluginListener#onChunkUnload(Chunk chunk) }
		 */
		CHUNK_UNLOAD,
		/**
		 * Calls {@link PluginListener#onTimeChange(World, long) }
		 */
		TIME_CHANGE,
		/**
		 * Calls {@link PluginListener#canPlayerUseCommand(Player, String) }
		 */
		COMMAND_CHECK,
		/**
		 * Class {@link PluginListener#onPortalCreate(Block[][]) }
		 */
		PORTAL_CREATE,
		/**
		 * Class {@link PluginListener#onPortalDestroy(Block[][]) }
		 */
		PORTAL_DESTROY,
		/**
		 * Class {@link PluginListener#onPlayerRespawn(Player) }
		 */
		PLAYER_RESPAWN,
		/**
		 * Class {@link PluginListener#onEntityDespawn(BaseEntity) }
		 */
		ENTITY_DESPAWN,
		/**
		 * Class {@link PluginListener#onEndermanPickup(Enderman, Block) }
		 */
		ENDERMAN_PICKUP,
		/**
		 * Class {@link PluginListener#onEndermanDrop(Enderman, Block) }
		 */
		ENDERMAN_DROP,
		/**
		 * Class {@link PluginListener#onCowMilk(Player, Mob) }
		 */
		COW_MILK,
		/**
		 * Calls {@link PluginListener#onEat(Player, Item) }
		 */
		EAT,
		/**
		 * Calls
		 * {@link PluginListener#onFoodLevelChange(Player, oldLevel, newLevel) }
		 */
		FOODLEVEL_CHANGE,
		/**
		 * Calls (@link PluginListener#onFoodExahustionChange(Player, oldLevel,
		 * newLevel) }
		 */
		FOODEXHAUSTION_CHANGE,
		/**
		 * Calls (@link PluginListener#onFoodSaturationChange(Player, oldLevel,
		 * newLevel) }
		 */
		FOODSATURATION_CHANGE,
		/**
		 * Calls (@link PluginListener#onPotionEffect(Player,PotionEffect)
		 */
		POTION_EFFECT,
		/**
		 * Class {@link PluginListener#onExpChange(Player, oldExp, newExp) }
		 */
		EXPERIENCE_CHANGE,
		/**
		 * Class {@link PluginListener#onLevelUp(Player) }
		 */
		LEVEL_UP,
		/**
		 * Calls {@link PluginListener#onPlayerListNameGet(Player, defaultName) }
		 */
		GET_PLAYERLISTENTRY,
		/**
		 * Calls
		 * {@link PluginListener#onPlayerConnect(Player,HookParametersConnect) }
		 */
		CONNECT,
		/**
		 * Calls {@link PluginListener#onEntityRightClick(Player,BaseEntity) }
		 */
		ENTITY_RIGHTCLICKED,
		/**
		 * Unused.
		 */
		NUM_HOOKS
	}

	public enum HookResult {

		/**
		 * Prevent the action
		 */
		PREVENT_ACTION,
		/**
		 * Allow the action
		 */
		ALLOW_ACTION,
		/**
		 * Do whatever it would normally do, continue processing
		 */
		DEFAULT_ACTION
	}

	public enum DamageType {

        /**
         * Creeper explosion
         */
        CREEPER_EXPLOSION,
        /**
         * Damage dealt by another entity
         */
        ENTITY,
        /**
         * Damage caused by explosion
         */
        EXPLOSION,
        /**
         * Damage caused from falling (fall distance - 3.0)
         */
        FALL,
        /**
         * Damage caused by fire (1)
         */
        FIRE,
        /**
         * Low periodic damage caused by burning (1)
         */
        FIRE_TICK,
        /**
         * Damage caused from lava (4)
         */
        LAVA,
        /**
         * Damage caused from drowning (2)
         */
        WATER,
        /**
         * Damage caused by cactus (1)
         */
        CACTUS,
        /**
         * Damage caused by suffocating(1)
         */
        SUFFOCATION,
        /**
         * Damage caused by lightning (5)
         */
        LIGHTNING,
        /**
         * Damage caused by starvation (1)
         */
        STARVATION, 
        /**
         * Damage caused by poison (1) (Potions, Poison)
         */
        POTION;
	}

	private List<Plugin> plugins = new ArrayList<Plugin>();
	private List<List<PluginRegisteredListener>> listeners = new ArrayList<List<PluginRegisteredListener>>();
	private HashMap<String, PluginInterface> customListeners = new HashMap<String, PluginInterface>();

	private Object lock = new Object();

	private volatile boolean loaded = false;
	private volatile boolean loadedpreload = false;

	public PluginLoader() {
		for (Hook hook : Hook.values()) {
			if (hook == Hook.NUM_HOOKS)
				continue;

			listeners.add(new ArrayList<PluginRegisteredListener>());
		}
	}

	public void loadPlugins() {
		if (this.loaded)
			return;

		Spout.getGame().getLogger().info("[hSpout] Loading plugins...");
		String[] plugins = hSpout.getPlugins().split(",");

		for (String plugin : plugins) {
			if (plugin.equals(""))
				continue;

			loadPlugin(plugin);
		}

		Spout.getGame().getLogger().info("[hSpout] All plugins loaded!");
		this.loaded = true;
	}
	
	// TODO: Call this
    public void loadPreloadPlugins() {
        if (loadedpreload)
            return;
		Spout.getGame().getLogger().info("[hSpout] Loading preload plugins...");
        String[] plugins = hSpout.getPreloadPlugins().split(",");
        
        for (String plugin : plugins) {
            if (plugin.equals("")) continue;
            
            loadPlugin(plugin.trim());
        }
        
		Spout.getGame().getLogger().info("[hSpout] All preload plugins loaded!");
        loadedpreload = true;
    }

	public boolean loadPlugin(String name) {
		if (this.getPlugin(name) != null)
			return false;

		return this.load(name);
	}

	public boolean reloadPlugin(String name) {
		Plugin p = this.getPlugin(name);

		if (p != null && p.isEnabled()) {
			p.disable();
		}

		synchronized (lock) {
			plugins.remove(p);

			for (List<PluginRegisteredListener> regListeners : listeners) {
				Iterator<PluginRegisteredListener> iter = regListeners
						.iterator();

				while (iter.hasNext()) {
					if (iter.next().getPlugin() == p)
						iter.remove();
				}
			}
		}

		p = null;

		return load(name);
	}

	public boolean load(String name) {
		try {
			File file = new File(hSpout.getPluginFolder(), name + ".jar");

			if (!file.exists()) {
				Spout.getGame()
						.getLogger()
						.severe("[hSpout] Could not find plugin "
								+ name
								+ ". Please insure it is in the directory \"<server directory>/plugins/hSpout/plugins\"");
				return false;
			}

			URL classURL = new URL(new StringBuilder()
					.append("jar:file:/")
					.append(file.getAbsolutePath().replaceAll(
							File.pathSeparator, "/")).append("!/").toString());

			URLClassLoader urlLoader = new URLClassLoader(
					new URL[] { classURL });

			Class<?> oclass = urlLoader.loadClass(name);

			Plugin plugin = (Plugin) oclass.newInstance();
			plugin.setName(name);
			plugin.enable();

			synchronized (lock) {
				plugins.add(plugin);
				plugin.initialize();
			}
		} catch (Throwable thr) {
			Spout.getGame().getLogger()
					.severe("[hSpout] Failed to load plugin " + name + "!");
			thr.printStackTrace();
			return false;
		}

		return true;
	}

	public Plugin getPlugin(String name) {
		synchronized (lock) {
			for (Plugin plugin : this.plugins) {
				if (plugin.getName().equalsIgnoreCase(name))
					return plugin;
			}
		}

		return null;
	}

	public String getPluginList() {
		StringBuilder build = new StringBuilder();

		synchronized (lock) {
			for (Plugin plugin : plugins) {
				build.append(plugin.getName()).append(" ")
						.append(plugin.isEnabled() ? "(E)" : "(D)").append(",");
			}
		}

		String str = build.toString();

		if (str.length() > 1) {
			return str.substring(0, str.length() - 1);
		} else {
			return "Empty";
		}
	}

	public boolean enablePlugin(String name) {
		Plugin plugin = this.getPlugin(name);

		if (plugin != null) {
			if (!plugin.isEnabled()) {
				plugin.toggleEnabled();
				plugin.enable();
			}
		} else {
			File file = new File(hSpout.getPluginFolder(), name + ".jar");

			if (file.exists())
				return this.loadPlugin(name);
			else
				return false;
		}

		return true;
	}

	public void disablePlugin(String name) {
		Plugin plugin = this.getPlugin(name);

		if (plugin != null) {
			if (plugin.isEnabled()) {
				plugin.toggleEnabled();
				plugin.disable();
			}
		}
	}

	@SuppressWarnings("deprecation")
	public Object callHook(Hook hook, Object... parameters) {
		Object callResult;

        switch (hook) {
            case REDSTONE_CHANGE:
            	callResult = parameters[2];
                break;
            case LIQUID_DESTROY:
            case TAME:
            case ENTITY_RIGHTCLICKED:
            case COMMAND_CHECK:
            	callResult = HookResult.DEFAULT_ACTION;
                break;
            case CHUNK_CREATE:
            case SPAWNPOINT_CREATE:
            	callResult = null;
                break;
            case FOODLEVEL_CHANGE:
            case FOODEXHAUSTION_CHANGE:
            case FOODSATURATION_CHANGE:
            	callResult = parameters[2];
                break;
            case POTION_EFFECT:
            case GET_PLAYERLISTENTRY:
            case CONNECT:
            	callResult = parameters[1];
                break;
            default:
            	callResult = false;
                break;
        }

        if (!(this.loaded || this.loadedpreload)) return callResult;

		synchronized (lock) {
			PluginListener listener = null;

			try {
				List<PluginRegisteredListener> registeredListeners = listeners
						.get(hook.ordinal());
				for (PluginRegisteredListener listen : registeredListeners) {
					if (!listen.getPlugin().isEnabled())
						continue;

					listener = listen.getListener();

					try {
						switch (hook) {
						case LOGINCHECK:
                            String result = listener.onLoginChecks((String) parameters[0]);
                            if (result != null)
                                callResult = result;
                            break;
                        case LOGIN:
                            listener.onLogin((Player) parameters[0]);
                            break;
                        case DISCONNECT:
                            listener.onDisconnect((Player) parameters[0]);
                            break;
                        case CHAT:
                            if (listener.onChat((Player) parameters[0], (String) parameters[1]))
                                callResult = true;
                            break;
                        case COMMAND:
                            if (listener.onCommand((Player) parameters[0], (String[]) parameters[1]))
                                callResult = true;
                            break;
                        case SERVERCOMMAND:
                            if (listener.onConsoleCommand((String[]) parameters[0]))
                                callResult = true;
                            break;
                        case BAN:
                            listener.onBan((Player) parameters[0], (Player) parameters[1], (String) parameters[2]);
                            break;
                        case IPBAN:
                            listener.onIpBan((Player) parameters[0], (Player) parameters[1], (String) parameters[2]);
                            break;
                        case KICK:
                            listener.onKick((Player) parameters[0], (Player) parameters[1], (String) parameters[2]);
                            break;
                        case BLOCK_CREATED:
                            if (listener.onBlockCreate((Player) parameters[0], (Block) parameters[1], (Block) parameters[2], (Integer) parameters[3]))
                                callResult = true;
                            break;
                        case BLOCK_DESTROYED:
                            if (listener.onBlockDestroy((Player) parameters[0], (Block) parameters[1]))
                                callResult = true;
                            break;
                        case PLAYER_MOVE:
                            listener.onPlayerMove((Player) parameters[0], (Location) parameters[1], (Location) parameters[2]);
                            break;
                        case ARM_SWING:
                            listener.onArmSwing((Player) parameters[0]);
                            break;
                        case ITEM_DROP:
                            if (listener.onItemDrop((Player) parameters[0], (ItemEntity) parameters[1]))
                                callResult = true;
                            break;
                        case ITEM_PICK_UP:
                            if (listener.onItemPickUp((Player) parameters[0], (ItemEntity) parameters[1]))
                                callResult = true;
                            break;
                        case TELEPORT:
                            if (listener.onTeleport((Player) parameters[0], (Location) parameters[1], (Location) parameters[2]))
                                callResult = true;
                            break;
                        case BLOCK_BROKEN:
                            if (listener.onBlockBreak((Player) parameters[0], (Block) parameters[1]))
                                callResult = true;
                            break;
                        case FLOW:
                            if (listener.onFlow((Block) parameters[0], (Block) parameters[1]))
                                callResult = true;
                            break;
                        case IGNITE:
                            if (listener.onIgnite((Block) parameters[0], (parameters[1] == null ? null : (Player) parameters[1])))
                                callResult = true;
                            break;
                        case EXPLODE:
                            if (listener.onExplode((Block) parameters[0]))
                                callResult = true;
                            break;
                        case MOB_SPAWN:
                            if (listener.onMobSpawn((Mob) parameters[0]))
                                callResult = true;
                            break;
                        case DAMAGE:
                            if (listener.onDamage((DamageType) parameters[0], (BaseEntity) parameters[1], (BaseEntity) parameters[2], (Integer) parameters[3]))
                                callResult = true;
                            break;
                        case HEALTH_CHANGE:
                            if (listener.onHealthChange((Player) parameters[0], (Integer) parameters[1], (Integer) parameters[2]))
                                callResult = true;
                            break;
                        case REDSTONE_CHANGE:
                            callResult = listener.onRedstoneChange((Block) parameters[0], (Integer) parameters[1], (Integer) callResult);
                            break;
                        case PISTON_EXTEND:
                            callResult = listener.onPistonExtend((Block) parameters[0], (((Block) parameters[0]).getType() == Block.Type.StickyPiston.getType()));
                            break;
                        case PISTON_RETRACT:
                            callResult = listener.onPistonRetract((Block) parameters[0], (((Block) parameters[0]).getType() == Block.Type.StickyPiston.getType()));
                            break;
                        case BLOCK_PHYSICS:
                            if (listener.onBlockPhysics((Block) parameters[0], (Boolean) parameters[1]))
                                callResult = true;
                            break;
                        case VEHICLE_CREATE:
                            listener.onVehicleCreate((BaseVehicle) parameters[0]);
                            break;
                        case VEHICLE_UPDATE:
                            listener.onVehicleUpdate((BaseVehicle) parameters[0]);
                            break;
                        case VEHICLE_DAMAGE:
                            if (listener.onVehicleDamage((BaseVehicle) parameters[0], (BaseEntity) parameters[1], (Integer) parameters[2]))
                                callResult = true;
                            break;
                        case VEHICLE_COLLISION:
                            if (listener.onVehicleCollision((BaseVehicle) parameters[0], (BaseEntity) parameters[1]))
                                callResult = true;
                            break;
                        case VEHICLE_DESTROYED:
                            listener.onVehicleDestroyed((BaseVehicle) parameters[0]);
                            break;
                        case VEHICLE_ENTERED:
                            listener.onVehicleEnter((BaseVehicle) parameters[0], (HumanEntity) parameters[1]);
                            break;
                        case VEHICLE_POSITIONCHANGE:
                            listener.onVehiclePositionChange((BaseVehicle) parameters[0], (Integer) parameters[1], (Integer) parameters[2], (Integer) parameters[3]);
                            break;
                        case ITEM_USE:
                            if (listener.onItemUse((Player) parameters[0], (Block) parameters[1], (Block) parameters[2], (Item) parameters[3]))
                                callResult = true;
                            break;
                        case BLOCK_RIGHTCLICKED:
                            if (listener.onBlockRightClick((Player) parameters[0], (Block) parameters[1], (Item) parameters[2]))
                                callResult = true;
                            break;
                        case BLOCK_PLACE:
                            if (listener.onBlockPlace((Player) parameters[0], (Block) parameters[1], (Block) parameters[2], (Item) parameters[3]))
                                callResult = true;
                            break;
                        case LIQUID_DESTROY:
                            HookResult ret = listener.onLiquidDestroy((HookResult) callResult, (Integer) parameters[0], (Block) parameters[1]);
                            if (ret != HookResult.DEFAULT_ACTION && (HookResult) callResult == HookResult.DEFAULT_ACTION)
                                callResult = ret;
                            break;
                        case ATTACK:
                            if (listener.onAttack((LivingEntity) parameters[0], (LivingEntity) parameters[1], (Integer) parameters[2]))
                                callResult = true;
                            break;
                        case OPEN_INVENTORY:
                            if (listener.onOpenInventory((Player) parameters[0], (Inventory) parameters[1]))
                                callResult = true;
                            break;
                        case SIGN_SHOW:
                            listener.onSignShow((Player) parameters[0], (Sign) parameters[1]);
                            break;
                        case SIGN_CHANGE:
                            if (listener.onSignChange((Player) parameters[0], (Sign) parameters[1]))
                                callResult = true;
                            break;
                        case LEAF_DECAY:
                            if (listener.onLeafDecay((Block) parameters[0]))
                                callResult = true;
                            break;
                        case TAME:
                            ret = listener.onTame((Player) parameters[0], (Mob) parameters[1], (Boolean) parameters[2]);
                            if (ret != HookResult.DEFAULT_ACTION && (HookResult) callResult == HookResult.DEFAULT_ACTION)
                                callResult = ret;
                            break;
                        case LIGHTNING_STRIKE:
                            if (listener.onLightningStrike((BaseEntity) parameters[0]))
                                callResult = true;
                            break;
                        case WEATHER_CHANGE:
                            if (listener.onWeatherChange((World) parameters[0], (Boolean) parameters[1]))
                                callResult = true;
                            break;
                        case THUNDER_CHANGE:
                            if (listener.onThunderChange((World) parameters[0], (Boolean) parameters[1]))
                                callResult = true;
                            break;
                        case PORTAL_USE:
                            if (listener.onPortalUse((Player) parameters[0], (World) parameters[1]))
                                callResult = true;
                            break;
                        case TIME_CHANGE:
                            if (listener.onTimeChange((World) parameters[0], (long) (Long) parameters[1]))
                                callResult = true;
                            break;
                        case COMMAND_CHECK:
                            ret = listener.canPlayerUseCommand((Player) parameters[0], (String) parameters[1]);
                            if (ret != HookResult.DEFAULT_ACTION)
                                callResult = ret;
                            break;
                        case CHUNK_CREATE:
                            byte[] chunk = listener.onChunkCreate((Integer) parameters[0], (Integer) parameters[1], (World) parameters[2]);
                            if (chunk != null) {
                                callResult = chunk;
                            }
                            break;
                        case SPAWNPOINT_CREATE:
                            Location point = listener.onSpawnpointCreate((World) parameters[0]);
                            if (point != null) {
                                callResult = point;
                            }
                            break;
                        case CHUNK_CREATED:
                            listener.onChunkCreated((Chunk) parameters[0]);
                            break;
                        case CHUNK_LOADED:
                            listener.onChunkLoaded((Chunk) parameters[0]);
                            break;
                        case CHUNK_UNLOAD:
                            listener.onChunkUnload((Chunk) parameters[0]);
                            break;
                        case PORTAL_CREATE:
                            callResult = listener.onPortalCreate((Block[][]) parameters[0]);
                            break;
                        case PORTAL_DESTROY:
                            callResult = listener.onPortalDestroy((Block[][]) parameters[0]);
                            break;
                        case PLAYER_RESPAWN:
                            listener.onPlayerRespawn((Player) parameters[0]);
                            break;
                        case ENTITY_DESPAWN:
                            callResult = listener.onEntityDespawn((BaseEntity) parameters[0]);
                            break;
                        case ENDERMAN_PICKUP:
                            callResult = listener.onEndermanPickup((Enderman) parameters[0], (Block) parameters[1]);
                            break;
                        case ENDERMAN_DROP:
                            callResult = listener.onEndermanDrop((Enderman) parameters[0], (Block) parameters[1]);
                            break;
                        case COW_MILK:
                            callResult = listener.onCowMilk((Player) parameters[0], (Mob) parameters[1]);
                            break;
                        case EAT:
                            callResult = listener.onEat((Player) parameters[0],(Item) parameters[1]);
                            break;
                        case FOODLEVEL_CHANGE:
                            callResult = (Integer) listener.onFoodLevelChange((Player) parameters[0],(Integer) parameters[1],(Integer) parameters[2]);
                            break;
                        case FOODEXHAUSTION_CHANGE:
                            callResult = (Float) listener.onFoodExhaustionChange((Player) parameters[0],(Float) parameters[1],(Float) parameters[2]);
                            break;
                        case FOODSATURATION_CHANGE:
                            callResult = (Float) listener.onFoodSaturationChange((Player) parameters[0],(Float) parameters[1],(Float) parameters[2]);
                            break;
                        case POTION_EFFECT:
                            callResult = listener.onPotionEffect((LivingEntity) parameters[0], (PotionEffect) parameters[1]);
                            break;
                        case EXPERIENCE_CHANGE:
                            if (listener.onExpChange((Player) parameters[0], (Integer) parameters[1], (Integer) parameters[2]))
                                callResult = true;
                            break;
                        case LEVEL_UP:
                            if (listener.onLevelUp((Player) parameters[0]))
                                callResult = true;
                            break;
                        case GET_PLAYERLISTENTRY:
                            callResult = listener.onGetPlayerlistEntry((Player) parameters[0],(PlayerlistEntry) parameters[1]);
                            break;
                        case CONNECT:
                            callResult = listener.onPlayerConnect((Player) parameters[0],(HookParametersConnect) parameters[1]);
                            break;
                        case ENTITY_RIGHTCLICKED:
                            ret = listener.onEntityRightClick((Player) parameters[0], (BaseEntity) parameters[1], (Item) parameters[2]);
                            if (ret != HookResult.DEFAULT_ACTION && (HookResult) callResult == HookResult.DEFAULT_ACTION)
                                callResult = ret;
                            break;
						}
					} catch (UnsupportedOperationException ex) {
					}
				}
			} catch (Exception e) {
				String listenerName = listener == null ? "(null) unknown listener"
						: listener.getClass().toString();
				Spout.getGame()
						.getLogger()
						.severe("[hSpout] Error calling hook \""
								+ hook.toString() + "\" in listener \""
								+ listenerName + "\".");
				e.printStackTrace();
			} catch (Throwable thr) {
				String listenerName = listener == null ? "(null) unknown listener"
						: listener.getClass().toString();
				Spout.getGame()
						.getLogger()
						.severe("[hSpout] Throwable while calling hook "
								+ hook.toString() + " for listener "
								+ listenerName + ". (Is it up to date?)");
				thr.printStackTrace();
			}
		}

		return callResult;
	}

	public Object callCustomHook(String name, Object[] parameters) {
		Object callResult = null;

		synchronized (lock) {
			try {
				PluginInterface listener = customListeners.get(name);

				if (listener == null) {
					Spout.getGame()
							.getLogger()
							.warning(
									"[hSpout] Could not find custom listener "
											+ name + ".");
					return false;
				}

				String message = listener.checkParameters(parameters);

				if (message != null) {
					Spout.getGame()
							.getLogger()
							.severe("[hSpout] Custom Listener message from listener "
									+ name + ": " + message);
					return false;
				}

				callResult = listener.run(parameters);
			} catch (Exception e) {
				Spout.getGame()
						.getLogger()
						.severe("[hSpout] Error calling custom plugin function!");
				e.printStackTrace();
			}
		}

		return callResult;
	}

	public PluginRegisteredListener addListener(Hook hook,
			PluginListener listener, Plugin plugin,
			PluginListener.Priority priority) {
		int priorityInt = priority.ordinal();

		PluginRegisteredListener reg = new PluginRegisteredListener(hook,
				listener, plugin, priorityInt);

		synchronized (lock) {
			List<PluginRegisteredListener> registeredListeners = listeners
					.get(hook.ordinal());

			int pos = 0;

			for (PluginRegisteredListener other : registeredListeners) {
				if (other.getPriority() < priorityInt)
					break;

				pos++;
			}

			registeredListeners.add(pos, reg);
		}

		return reg;
	}

	public void addCustomListener(PluginInterface listener) {
		synchronized (lock) {
			if (customListeners.get(listener.getName()) != null) {
				Spout.getGame()
						.getLogger()
						.warning(
								"[hSpout] Listener by the name "
										+ listener.getName()
										+ " already exists! Replacing...");
			}

			customListeners.put(listener.getName(), listener);

			Spout.getGame()
					.getLogger()
					.info("[hSpout] Custom hook registered: "
							+ listener.getName() + ".");
		}
	}

	public void removeListener(PluginRegisteredListener listener) {
		List<PluginRegisteredListener> registeredListeners = listeners
				.get(listener.getHook().ordinal());

		synchronized (lock) {
			registeredListeners.remove(listener);
		}
	}

	public void removeCustomListener(String name) {
		synchronized (lock) {
			customListeners.remove(name);
		}
	}

	public boolean isLoaded() {
		return this.loaded;
	}
}
