package flowerseeds.fabulousflowers.client.lang;


import flowerseeds.fabulousflowers.FlowerSeedsFabulousFlowers;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class EN_US extends LanguageProvider
    {
        public EN_US(PackOutput gen, String modid)
        {
            super(gen, modid, "en_us");
        }

        @Override
        public String getName() {
            return "Flower Seeds 2 Main EN_US Lang Provider";
        }

        @Override
        protected void addTranslations() {

            addBlockTranslation(FlowerSeedsFabulousFlowers.BLOOMED_DANDELION_SEED.get(), "Bloomed Dandelion");
            addBlockTranslation(FlowerSeedsFabulousFlowers.ORANGE_POPPY_SEED.get(), "Orange Poppy");
            addBlockTranslation(FlowerSeedsFabulousFlowers.WHITE_POPPY_SEED.get(), "White Poppy");
            addBlockTranslation(FlowerSeedsFabulousFlowers.YELLOW_POPPY_SEED.get(), "Yellow Poppy");
            addBlockTranslation(FlowerSeedsFabulousFlowers.PINK_POPPY_SEED.get(), "Pink Poppy");
            addBlockTranslation(FlowerSeedsFabulousFlowers.YELLOW_ORCHID_SEED.get(), "Yellow Orchid");
            addBlockTranslation(FlowerSeedsFabulousFlowers.WHITE_ORCHID_SEED.get(), "White Orchid");
            addBlockTranslation(FlowerSeedsFabulousFlowers.PINK_ORCHID_SEED.get(), "Pink Orchid");
            addBlockTranslation(FlowerSeedsFabulousFlowers.PURPLE_ORCHID_SEED.get(), "Purple Orchid");
            addBlockTranslation(FlowerSeedsFabulousFlowers.BLUE_ALLIUM_SEED.get(), "Blue Allium");
            addBlockTranslation(FlowerSeedsFabulousFlowers.WHITE_ALLIUM_SEED.get(), "White Allium");
            addBlockTranslation(FlowerSeedsFabulousFlowers.YELLOW_TULIP_SEED.get(), "Yellow Tulip");
            addBlockTranslation(FlowerSeedsFabulousFlowers.PURPLE_TULIP_SEED.get(), "Purple Tulip");
            addBlockTranslation(FlowerSeedsFabulousFlowers.BLUE_TULIP_SEED.get(), "Blue Tulip");
            addBlockTranslation(FlowerSeedsFabulousFlowers.BLACK_TULIP_SEED.get(), "Black Tulip");
            addBlockTranslation(FlowerSeedsFabulousFlowers.ASTER_DAISY_SEED.get(), "Aster Daisy");
            addBlockTranslation(FlowerSeedsFabulousFlowers.GLORIOSA_DAISY_SEED.get(), "Gloriosa Daisy");

            add("text.packmeta.description", "Flower Seeds 2 Cyclic Resource And Datapacks");
        }

        protected void addBlockTranslation(Block block, String name) {
            add(block, name);
            add(block.asItem(), name + " Seed");
        }
}
