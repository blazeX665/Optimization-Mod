package com.blaze.boost;

public final class BoostConfig {
    public static boolean enabled = true;
    /** Max render distance for ordinary entities (blocks). */
    public static double entityDistance = 64.0;
    /** Max render distance for dropped items and XP orbs (blocks). */
    public static double itemDistance = 24.0;
    /** Particles farther than this from the camera are not spawned (blocks). */
    public static double particleDistance = 32.0;

    private BoostConfig() {}
}
