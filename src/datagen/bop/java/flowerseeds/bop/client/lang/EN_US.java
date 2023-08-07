package flowerseeds.bop.client.lang;

import flowerseeds.bop.FlowerSeedsBop;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class EN_US extends LanguageProvider
    {
        public EN_US(PackOutput gen)
        {
            super(gen, FlowerSeedsBop.MODID, "en_us");
        }

        @Override
        protected void addTranslations() {
            add("text.packmeta.description", "Flower Seeds Biomes o Plenty Addon, Resource And Datapacks");
        }
}
