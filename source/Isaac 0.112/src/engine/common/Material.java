package engine.common;

import org.newdawn.slick.Color;

public class Material {

    public static final Material DEFAULT = new Material(1.00f, 0.30f, 0.1f, false, true, true, Color.gray);
    public static final Material METAL = new Material(7.85f, 0.20f, 0.2f, false, false, false, Color.lightGray);
    public static final Material STONE = new Material(2.40f, 0.50f, 0.1f, false, false, false, Color.darkGray);
    public static final Material WOOD = new Material(0.53f, 0.40f, 0.15f, false, true, false, new Color(150, 98, 0));
    public static final Material GLASS = new Material(2.50f, 0.10f, 0.2f, false, true, true, new Color(0, 0, 220, 128));
    public static final Material RUBBER = new Material(1.50f, 0.80f, 0.4f, false, false, false, new Color(30, 30, 30));
    public static final Material ICE = new Material(0.92f, 0.01f, 0.1f, false, true, true, new Color(0, 146, 220, 200));
    public static final Material PUMICE = new Material(0.25f, 0.60f, 0.0f, false, true, true, new Color(240, 240, 240));
    public static final Material POLYSTYRENE = new Material(0.10f, 0.60f, 0.05f, false, true, true, new Color(240, 240, 240));
    public static final Material FABRIC = new Material(0.03f, 0.60f, 0.1f, true, true, true, Color.pink);
    public static final Material SPONGE = new Material(0.018f, 0.90f, 0.05f, true, true, true, Color.yellow);
    public static final Material AIR = new Material(0.001f, 0.90f, 0.0f, true, true, true, new Color(142, 171, 255, 128));
    public static final Material HELIUM = new Material(0.0001f, 0.9f, 0.0f, true, true, true, new Color(142, 171, 255, 128));
    public static final Material PLAYER = new Material(1.0f, 0.3f, 0.0f, false, true, true, Color.yellow);
    /** Measure of mass in kg/m^3. Used to calculate the mass of a body. */
    private final float density;
    /** Measure of how easily a shape slides across a surface. Typically between 0 and 1. 0 means no friction. */
    private final float friction;
    /** Coefficient of Restitution (COR) or how much velocity a shape retains when colliding with another
     * (i.e. bounciness). COR is a ratio represented by a value between 0 and 1. 1 being more bouncy than 0. */
    private final float restitution;
    /** Game specific. Whether player can grab and hold onto the shape. */
    private final boolean isGrabbable;
    /** Game specific. Whether a shape is crushed when a strong force is applied to it. */
    private final boolean isCrushable;
    /** Game specific. Whether the material is affected by explosions (deforms the shape). */
    private final boolean isExplodable;
    /** Rendering engine specific. Color used to represent the shape when displaying.  */
    private final Color color;

    public Material(float density, float friction, float restitution) {
        this(density, friction, restitution, false, true, false, Color.gray);
    }

    public Material(float density, float friction, float restitution, boolean isGrabbable,
            boolean isCrushable, boolean isExplodable, Color color) {
        this.density = density;
        this.friction = friction;
        this.restitution = restitution;
        this.isGrabbable = isGrabbable;
        this.isCrushable = isCrushable;
        this.isExplodable = isExplodable;
        this.color = color;
    }

    public float density() {
        return density;
    }

    public float friction() {
        return friction;
    }

    public float restitution() {
        return restitution;
    }

    public boolean isGrabbable() {
        return isGrabbable;
    }

    public boolean isCrushable() {
        return isCrushable;
    }

    public boolean isExplodable() {
        return isExplodable;
    }

    public Color getColor() {
        return color;
    }
}
