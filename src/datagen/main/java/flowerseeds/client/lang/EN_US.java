package flowerseeds.client.lang;

import flowerseeds.FlowerSeeds;
import flowerseeds.init.BlockInit;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class EN_US extends LanguageProvider
    {
        public EN_US(PackOutput gen)
        {
            super(gen, FlowerSeeds.MODID, "en_us");
        }

        @Override
        public String getName() {
            return "Flower Seeds 2 Main EN_US Lang Provider";
        }

        @Override
        protected void addTranslations() {
            add(BlockInit.DANDELION_SEED.get(), "Dandelion");
            add(BlockInit.DANDELION_SEED.get().asItem(), "Dandelion Seed");
            add(BlockInit.WITHER_ROSE_SEED.get(), "Wither Rose");
            add(BlockInit.WITHER_ROSE_SEED.get().asItem(), "Wither Rose Seed");
            add(BlockInit.OXEYE_DAISY_SEED.get(), "Oxeye Daisy Seed");
            add(BlockInit.OXEYE_DAISY_SEED.get().asItem(), "Oxeye Daisy Seed");
            add(BlockInit.POPPY_SEED.get(), "Poppy Seed");
            add(BlockInit.POPPY_SEED.get().asItem(), "Poppy Seed");
            add(BlockInit.PINK_TULIP_SEED.get(), "Pink Tulip");
            add(BlockInit.PINK_TULIP_SEED.get().asItem(), "Pink Tulip Seed");
            add(BlockInit.RED_TULIP_SEED.get(), "Red Tulip");
            add(BlockInit.RED_TULIP_SEED.get().asItem(), "Red Tulip Seed");
            add(BlockInit.WHITE_TULIP_SEED.get(), "White Tulip");
            add(BlockInit.WHITE_TULIP_SEED.get().asItem(), "White Tulip Seed");
            add(BlockInit.ORANGE_TULIP_SEED.get(), "Orange Tulip");
            add(BlockInit.ORANGE_TULIP_SEED.get().asItem(), "Orange Tulip Seed");
            add(BlockInit.LILY_OF_THE_VALLEY_SEED.get(), "Lily of the Valley");
            add(BlockInit.LILY_OF_THE_VALLEY_SEED.get().asItem(), "Lily of the Valley Seed");
            add(BlockInit.BLUE_ORCHID_SEED.get(), "Blue Orchid");
            add(BlockInit.BLUE_ORCHID_SEED.get().asItem(), "Blue Orchid Seed");
            add(BlockInit.CORNFLOWER_SEED.get(), "Cornflower");
            add(BlockInit.CORNFLOWER_SEED.get().asItem(), "Cornflower Seed");
            add(BlockInit.AZURE_BLUET_SEED.get(), "Azure Bluet");
            add(BlockInit.AZURE_BLUET_SEED.get().asItem(), "Azure Bluet");
            add(BlockInit.ALLIUM_SEED.get(), "Allium");
            add(BlockInit.ALLIUM_SEED.get().asItem(), "Allium Seed");

            add("flowerseeds.packmeta.description", "Flower Seeds 2 Resource pack");
            add("flowerseeds.creativetab.name", "Flower Seeds");
        }
}
