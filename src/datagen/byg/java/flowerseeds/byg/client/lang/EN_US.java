package flowerseeds.byg.client.lang;

import flowerseeds.byg.FlowerSeedsByg;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class EN_US extends LanguageProvider
    {
        public EN_US(PackOutput gen)
        {
            super(gen, FlowerSeedsByg.MODID, "en_us");
        }

        @Override
        protected void addTranslations() {
            add("text.packmeta.description", "Flower Seeds Byg Addon, Resource And Datapacks");
        }
}
