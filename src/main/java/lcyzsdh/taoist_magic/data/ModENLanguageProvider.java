package lcyzsdh.taoist_magic.data;

import lcyzsdh.taoist_magic.TaoistMagic;
import lcyzsdh.taoist_magic.registry.BlockRegister;
import lcyzsdh.taoist_magic.registry.ItemRegister;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModENLanguageProvider extends LanguageProvider {
    public ModENLanguageProvider(PackOutput output) {
        super(output, TaoistMagic.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        this.add("itemGroup.taoist_magic.taoist_magic_tab","Taoist Magic Tab");
        this.add(ItemRegister.DIRT_PIECE.get(),"Dirt Piece");
        this.add(ItemRegister.WOOD_PIECE.get(),"Wood Piece");
        this.add(ItemRegister.FIRE_PIECE.get(),"Fire Piece");
        this.add(ItemRegister.METAL_PIECE.get(),"Metal Piece");
        this.add(ItemRegister.WATER_PIECE.get(),"Water Piece");
        this.add(BlockRegister.FIRE_ORIGIN_STONE.get(),"Fire Origin Stone");
        this.add(BlockRegister.DIRT_ORIGIN_STONE.get(),"Dirt Origin Stone");
        this.add(BlockRegister.METAL_ORIGIN_STONE.get(),"Metal Origin Stone");
        this.add(BlockRegister.WATER_ORIGIN_STONE.get(),"Water Origin Stone");
        this.add(BlockRegister.WOOD_ORIGIN_STONE.get(),"Wood Origin Stone");
    }
}
