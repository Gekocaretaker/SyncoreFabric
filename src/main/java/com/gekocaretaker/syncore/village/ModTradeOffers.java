package com.gekocaretaker.syncore.village;

import com.gekocaretaker.syncore.Syncore;
import com.gekocaretaker.syncore.block.BlockInit;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.village.TradeOffers;

public class ModTradeOffers {
    public static void init() {
        TradeOfferHelper.registerWanderingTraderOffers(builder -> {
            builder.pool(Syncore.identify("special_ores"), 2,
                    new TradeOffers.SellItemFactory(BlockInit.NETHER_COAL_ORE, 4, 5, 2, 1),
                    new TradeOffers.SellItemFactory(BlockInit.NETHER_IRON_ORE, 5, 5, 2, 1),
                    new TradeOffers.SellItemFactory(BlockInit.NETHER_COPPER_ORE, 5, 5, 2, 1),
                    new TradeOffers.SellItemFactory(BlockInit.NETHER_DIAMOND_ORE, 12, 5, 2, 1),
                    new TradeOffers.SellItemFactory(BlockInit.NETHER_EMERALD_ORE, 7, 5, 2, 1),
                    new TradeOffers.SellItemFactory(BlockInit.NETHER_LAPIS_LAZULI_ORE, 6, 5, 2, 1),
                    new TradeOffers.SellItemFactory(BlockInit.NETHER_REDSTONE_ORE, 5, 5, 2, 1),
                    new TradeOffers.SellItemFactory(BlockInit.QUARTZ_ORE, 6, 5, 2, 1),
                    new TradeOffers.SellItemFactory(BlockInit.DEEPSLATE_QUARTZ_ORE, 7, 5, 2, 1)
            );
        });
    }

    private ModTradeOffers() {}
}
