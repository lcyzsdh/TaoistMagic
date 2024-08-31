package lcyzsdh.taoist_magic.registry;

import lcyzsdh.taoist_magic.TaoistMagic;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;

public class ItemRegister {
    public static final DeferredRegister.Items ITEMS=DeferredRegister.createItems(TaoistMagic.MOD_ID);
    public static final List<DeferredItem<Item>> ITEM_LIST=new ArrayList<>();

    public static final DeferredItem<Item> METAL_PIECE=register("metal_piece");
    public static final DeferredItem<Item> WATER_PIECE=register("water_piece");
    public static final DeferredItem<Item> WOOD_PIECE=register("wood_piece");
    public static final DeferredItem<Item> FIRE_PIECE=register("fire_piece");
    public static final DeferredItem<Item> DIRT_PIECE=register("dirt_piece");

    public static DeferredItem<Item> register(String name){
        DeferredItem<Item> item=ITEMS.registerSimpleItem(name);
        ITEM_LIST.add(item);
        return item;
    }
}
