package com.gekocaretaker.syncore.compat.moreores;

import com.gekocaretaker.syncore.compat.moreores.item.MOItemGroup;
import com.gekocaretaker.syncore.compat.moreores.item.MOItems;

public class MoreOresCompat {
    private MoreOresCompat() {}

    public static void init() {
        MOItems.init();
        MOItemGroup.init();
    }
}
