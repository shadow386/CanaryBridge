
public class Location {
    /**
     * X location
     */
    public double x;
    /**
     * Z location
     */
    public double z;
    /**
     * Y location
     */
    public double y;
    /**
     * Rotation
     */
    public float  rotX;
    /**
     * Pitch
     */
    public float  rotY;
    /**
     * World
     */
    public int dimension;

    /**
     * Creates a location
     */
    public Location() {
    }

    /**
     * Creates a location with the specified coordinates
     * 
     * @param X
     * @param Y
     * @param Z
     */
    public Location(double X, double Y, double Z) {
        x = X;
        y = Y;
        z = Z;
    }

    /**
     * Creates a location in the specified dimension with the specified coordinates
     *
     * @param world
     * @param x
     * @param y
     * @param z
     */
    public Location(World world, double x, double y, double z) {
        this(x, y, z);
        this.dimension = world.getType().getId();
    }

    /**
     * Creates a location with the specified coordinates and rotation
     * 
     * @param X
     * @param Y
     * @param Z
     * @param rotation
     * @param pitch
     */
    public Location(double X, double Y, double Z, float rotation, float pitch) {
        x = X;
        y = Y;
        z = Z;
        rotX = rotation;
        rotY = pitch;
    }

    /**
     * Creates a location in the specified dimension with the specified coordinates and rotation
     * 
     * @param world 
     * @param X
     * @param Y
     * @param Z
     * @param rotation
     * @param pitch
     */
    public Location(World world, double X, double Y, double Z, float rotation, float pitch) {
        this(X, Y, Z, rotation, pitch);
        this.dimension = world.getType().getId();
    }

    public World getWorld() {
        return etc.getServer().getWorld(dimension);
    }

}