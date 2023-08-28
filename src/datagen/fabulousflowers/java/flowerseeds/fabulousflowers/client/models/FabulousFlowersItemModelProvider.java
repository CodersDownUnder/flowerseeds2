package flowerseeds.fabulousflowers.client.models;

import flowerseeds.fabulousflowers.FlowerSeedsFabulousFlowers;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FabulousFlowersItemModelProvider extends ItemModelProvider {

    private static String MODID = "";

    public FabulousFlowersItemModelProvider(PackOutput output, String MODID, ExistingFileHelper existingFileHelper) {
        super(output, MODID, existingFileHelper);
        FabulousFlowersItemModelProvider.MODID = MODID;
    }

    @Override
    public String getName() {
        return "Flower Seeds 2 Cyclic Item Model Provider";
    }

    @Override
    protected void registerModels() {

        for (RegistryObject<Item> item : FlowerSeedsFabulousFlowers.ITEMS.getEntries()) {
            oneLayerItem(item.get());
        }
    }

    private void oneLayerItem(final Item item) {
        withExistingParent(ForgeRegistries.ITEMS.getKey(item.asItem()).getPath(), "item/generated")
                .texture("layer0", new ResourceLocation("flowerseeds","item/seed"));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(MODID,"item/" + item.getId().getPath()));
    }
}