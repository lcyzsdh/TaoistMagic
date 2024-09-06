package lcyzsdh.taoist_magic.data;

import lcyzsdh.taoist_magic.TaoistMagic;
import lcyzsdh.taoist_magic.registry.BlockRegister;
import lcyzsdh.taoist_magic.registry.ItemRegister;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TaoistMagic.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        //Warning:too few items
        ItemRegister.ITEM_LIST.forEach(item->this.basicItem(item.get()));
    }
}
