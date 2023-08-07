package flowerseeds.cyclic.client.lang;

import flowerseeds.cyclic.FlowerSeedsCyclic;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class EN_US extends LanguageProvider
    {
        public EN_US(PackOutput gen)
        {
            super(gen, FlowerSeedsCyclic.MODID, "en_us");
        }

        @Override
        protected void addTranslations() {
            add("text.packmeta.description", "Flower Seeds Cyclic Addon, Resource And Datapacks");
        }
}
