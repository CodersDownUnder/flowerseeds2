package flowerseeds.cyclic.client.lang;


import flowerseeds.cyclic.FlowerSeedsCyclic;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
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
            addBlockTranslation(FlowerSeedsCyclic.CYAN_ROSE_SEED.get(), "Cyan Rose");
            addBlockTranslation(FlowerSeedsCyclic.LIME_CARNATION_SEED.get(), "Lime Carnation");
            addBlockTranslation(FlowerSeedsCyclic.ABSALON_TULIP_SEED.get(), "Absalon Tulip");
            addBlockTranslation(FlowerSeedsCyclic.PURPLE_TULIP_SEED.get(), "Purple Tulip");


            add("text.packmeta.description", "Flower Seeds 2 Cyclic Resource And Datapacks");
        }

        protected void addBlockTranslation(Block block, String name) {
            add(block, name);
            add(block.asItem(), name + " Seed");
        }
}
