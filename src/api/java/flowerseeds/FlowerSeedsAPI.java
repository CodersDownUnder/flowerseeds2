package flowerseeds;


import com.mojang.logging.LogUtils;
import org.slf4j.Logger;


public class FlowerSeedsAPI {

    private FlowerSeedsAPI() {
    }

    /**
     * The version of the api classes - may not always match the mod's version
     */
    public static final String API_VERSION = "1.0.0";
    /**
     * Flower Seeds Mod ID
     */
    public static final String FLOWERSEEDS_MODID = "flowerseeds";

    /**
     * Logger for use in FlowerSeeds API classes
     */
    public static final Logger logger = LogUtils.getLogger();
}
