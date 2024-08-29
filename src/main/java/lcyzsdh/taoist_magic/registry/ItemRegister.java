package lcyzsdh.taoist_magic.registry;

import lcyzsdh.taoist_magic.TaoistMagic;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemRegister {
    public static final DeferredRegister.Items ITEMS=DeferredRegister.createItems(TaoistMagic.MOD_ID);

    public static final DeferredItem<Item> METAL_PIECE=ITEMS.registerSimpleItem("metal_piece");
}
