package flowerseeds.roses.client.lang;


import flowerseeds.roses.FlowerSeedsRoses;
import net.minecraft.data.PackOutput;
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
            add(FlowerSeedsRoses.ROSE_SEED.get(), "Rose");
            add(FlowerSeedsRoses.ROSE_SEED.get().asItem(), "Rose Seed");
            add(FlowerSeedsRoses.CYAN_FLOWER_SEED.get(), "Cyan Flower");
            add(FlowerSeedsRoses.CYAN_FLOWER_SEED.get().asItem(), "Cyan Flower Seed");

            add("text.packmeta.description", "Flower Seeds 2 Roses Resource And Datapacks");
        }
}
