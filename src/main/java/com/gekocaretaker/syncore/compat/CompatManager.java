package com.gekocaretaker.syncore.compat;

import com.gekocaretaker.syncore.Syncore;
import com.gekocaretaker.syncore.compat.advancednetherite.AdvancedNetheriteCompat;
import com.gekocaretaker.syncore.compat.moreores.MoreOresCompat;

public class CompatManager {
    public static void init() {
        if (Syncore.isModPresent("more-ores")) {
            Syncore.LOGGER.info("More Ores recognised. MoreOresCompat initialized.");
            MoreOresCompat.init();
        }
        if (Syncore.isModPresent("advancednetherite")) {
            Syncore.LOGGER.info("Advanced Netherite recognised. AdvancedNetheriteCompat initialized.");
            AdvancedNetheriteCompat.init();
        }
    }

    private CompatManager() {}
}
