package lcyzsdh.taoist_magic.data;

import lcyzsdh.taoist_magic.TaoistMagic;
import lcyzsdh.taoist_magic.registry.ItemRegister;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModENLanguageProvider extends LanguageProvider {
    public ModENLanguageProvider(PackOutput output) {
        super(output, TaoistMagic.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        this.add(ItemRegister.DIRT_PIECE.get(),"Dirt Piece");
        this.add(ItemRegister.WOOD_PIECE.get(),"Wood Piece");
        this.add(ItemRegister.FIRE_PIECE.get(),"Fire Piece");
        this.add(ItemRegister.METAL_PIECE.get(),"Metal Piece");
        this.add(ItemRegister.WATER_PIECE.get(),"Water Piece");
    }
}
