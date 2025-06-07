package com.gekocaretaker.syncore.compat.advancednetherite;

import com.gekocaretaker.syncore.compat.advancednetherite.item.ANItemGroup;
import com.gekocaretaker.syncore.compat.advancednetherite.item.ANItems;

public class AdvancedNetheriteCompat {
    private AdvancedNetheriteCompat() {}

    public static void init() {
        ANItems.init();
        ANItemGroup.init();
    }
}
