package hunternif.mc.impl.atlas;

import hunternif.mc.impl.atlas.client.gui.GuiAtlas;
import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.annotation.ConfigEntry;
import me.sargunvohra.mcmods.autoconfig1u.shadowed.blue.endless.jankson.Comment;

@Config(name = "antiqueatlas")
public class AntiqueAtlasConfig implements ConfigData {
    //============ Gameplay settings ==============
    @ConfigEntry.Category("gameplay")
    @Comment("Whether to remember last open browsing position and zoom level for each dimension in every atlas.\nIf disabled, all dimensions and all atlases will be \"synchronized\" at the same coordinates and zoom level, and map will \"follow\" player by default.")
    public boolean doSaveBrowsingPos = true;

    @ConfigEntry.Category("gameplay")
    @Comment("Whether to add local marker for the spot where the player died.")
    public boolean autoDeathMarker = true;

    @ConfigEntry.Category("gameplay")
    @Comment("Whether to add global markers for NPC villages.")
    public boolean autoVillageMarkers = true;

    @ConfigEntry.Category("gameplay")
    @Comment("Whether to add global markers for Nether Portals.")
    public boolean autoNetherPortalMarkers = true;

    @ConfigEntry.Category("gameplay")
    @Comment("Player will need to craft atlas item to use atlas.")
    public boolean itemNeeded = true;

    //============ Interface settings =============
    @ConfigEntry.Category("userInterface")
    public boolean doScaleMarkers = false;

    @ConfigEntry.Category("userInterface")
    @Comment("Default zoom level. The number corresponds to the size of a block on the map relative to the size of a GUI pixel. Preferrably a power of 2.")
    //@Setting.Constrain.Range(min = 0.001953125, max = 16.0)
    public double defaultScale = 0.5f;

    @ConfigEntry.Category("userInterface")
    @Comment("Minimum zoom level. The number corresponds to the size of a block on the map relative to the size of a GUI pixel. Preferrably a power of 2. Smaller values may decrease performance!")
    //@Setting.Constrain.Range(min = 0.001953125, max = 16.0)
    public double minScale = 1.0 / 32.0;

    @ConfigEntry.Category("userInterface")
    @Comment("Maximum zoom level. The number corresponds to the size of a block on the map relative to the size of a GUI pixel. Preferrably a power of 2.")
    //@Setting.Constrain.Range(min = 0.001953125, max = 16.0)
    public double maxScale = 4;

    @ConfigEntry.Category("userInterface")
    @Comment("If false (by default), then mousewheel up is zoom in, mousewheel down is zoom out.\nIf true, then the direction is reversed.")
    public boolean doReverseWheelZoom = false;

    //=========== Performance settings ============
    @ConfigEntry.Category("performance")
    @Comment("The radius of the area around the player which is scanned by the Atlas at regular intervals.\nNote that this will not force faraway chunks to load, unless force_chunk_loading is enabled.\nLower value gives better performance.")
    public int scanRadius = 11;

    @ConfigEntry.Category("performance")
    @Comment("Force loading of chunks within scan radius even if it exceeds regular chunk loading distance.\nEnabling this may SEVERELY decrease performance!")
    public boolean forceChunkLoading = false;

    @ConfigEntry.Category("performance")
    @Comment("Time in seconds between two scans of the area.\nHigher value gives better performance.")
    public float newScanInterval = 1f;

    @ConfigEntry.Category("performance")
    @Comment("Whether to rescan chunks in the area that have been previously mapped. This is useful in case of changes in coastline (including small ponds of water and lava), or if land disappears completely (for sky worlds).\nDisable for better performance.")
    public boolean doRescan = true;

    @ConfigEntry.Category("performance")
    @Comment("The number of area scans between full rescans.\nHigher value gives better performance.")
    //@Setting.Constrain.Range(min = 1, max = 1000)
    public int rescanRate = 4;

    @ConfigEntry.Category("performance")
    @Comment("The maximum number of markers a particular atlas can hold.")
    //@Setting.Constrain.Range(min = 0, max = 2147483647)
    public int markerLimit = 1024;

    @ConfigEntry.Category("performance")
    @Comment("Whether to perform additional scanning to locate small ponds of water or lava.\nDisable for better performance.")
    public boolean doScanPonds = true;

    @ConfigEntry.Category("performance")
    @Comment("Whether to perform additional scanning to locate ravines.\nDisable for better performance.")
    public boolean doScanRavines = true;

    @ConfigEntry.Category("performance")
    @Comment("If true, map render time will be output.")
    public boolean debugRender = false;

    //=========== Overlay settings ============
    @ConfigEntry.Category("overlayPosition")
    @Comment("If true, the map position's x axis will align 0 to the right\nof the screen, increasing towards the left.")
    public boolean alignRight = false;

    @ConfigEntry.Category("overlayPosition")
    @Comment("If true, the map position's y axis will align 0 to the bottom\nof the screen, increasing towards the top.")
    public boolean alignBottom = false;

    @ConfigEntry.Category("overlayPosition")
    @Comment("Map's minimum position along the x axis in GUI pixels.\nNote that this will change with Minecraft's GUI scale configuration.")
    public int xPosition = 2;

    @ConfigEntry.Category("overlayPosition")
    @Comment("Map's minimum position along the y axis in GUI pixels.\nNote that this will change with Minecraft's GUI scale configuration.")
    //@Setting.Constrain.Range(min = 0)
    public int yPosition = 2;

    @ConfigEntry.Category("overlayPosition")
    @Comment("Map's width in GUI pixels.\nNote that this will change with Minecraft's GUI scale configuration.")
    //@Setting.Constrain.Range(min = 0)
    public int width = GuiAtlas.WIDTH / 2;

    @ConfigEntry.Category("overlayPosition")
    @Comment("Map's height in GUI pixels.\nNote that this will change with Minecraft's GUI scale configuration.")
    //@Setting.Constrain.Range(min = 0)
    public int height = GuiAtlas.HEIGHT / 2;

    @ConfigEntry.Category("overlayAppearance")
    @Comment("The size (in GUI pixels) of a map's tile.\nNote that this will change with Minecraft's GUI scale configuration.\nWhen using a small gui scale, the map may look better with a TILE_SIZE of 16 or more.")
    //@Setting.Constrain.Range(min = 1, max = 10)
    public int tileSize = 8;

    @ConfigEntry.Category("overlayAppearance")
    @Comment("The size (in GUI pixels) of a marker on the map.\nNote that this will change with Minecraft's GUI scale configuration.")
    //@Setting.Constrain.Range(min = 0)
    public int markerSize = GuiAtlas.MARKER_SIZE / 2;

    @ConfigEntry.Category("overlayAppearance")
    @Comment("The width (in GUI pixels) of the player's icon.")
    //@Setting.Constrain.Range(min = 0)
    public int playerIconWidth = 14;

    @ConfigEntry.Category("overlayAppearance")
    @Comment("The height (in GUI pixels) of the player's icon.")
    //@Setting.Constrain.Range(min = 0)
    public int playerIconHeight = 16;

    @ConfigEntry.Category("overlayAppearance")
    @Comment("The width of the map border on the left and right sides of the minimap tiles.\nRepresented as a fraction of the image width.\nBelow a certain threshold, this border will be overtaken by the map border graphic.")
    //@Setting.Constrain.Range(min = 0.0, max = 0.5)
    public float borderX = 0.05F;

    @ConfigEntry.Category("overlayAppearance")
    @Comment("The width of the map border on the top and bottom sides of the minimap tiles.\nRepresented as a fraction of the image width.\nBelow a certain threshold, this border will be overtaken by the map border graphic.")
    //@Setting.Constrain.Range(min = 0.0, max = 0.5)
    public float borderY = 0.05F;

    @ConfigEntry.Category("overlayAppearance")
    @Comment("If true, the minimap will show the map of an atlas only while it is held.\nIf false, the minimap will show the map of the first atlas in the hotbar.")
    public boolean requiresHold = true;

    @ConfigEntry.Category("overlayAppearance")
    @Comment("Set true to enable minimap")
    public boolean enabled = false;
}