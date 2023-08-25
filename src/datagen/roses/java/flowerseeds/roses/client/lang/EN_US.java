package flowerseeds.roses.client.lang;


import flowerseeds.roses.init.BlockInit;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

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
            add(BlockInit.ROSE_SEED.get(), "Rose");
            add(BlockInit.ROSE_SEED.get().asItem(), "Rose Seed");
            add(BlockInit.CYAN_FLOWER_SEED.get(), "Cyan Flower");
            add(BlockInit.CYAN_FLOWER_SEED.get().asItem(), "Cyan Flower Seed");

            add("text.packmeta.description", "Flower Seeds 2 Roses Resource And Datapacks");
        }
}
