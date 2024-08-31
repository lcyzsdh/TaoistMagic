package lcyzsdh.taoist_magic;

import lcyzsdh.taoist_magic.registry.BlockRegister;
import lcyzsdh.taoist_magic.registry.CreativeTabRegister;
import lcyzsdh.taoist_magic.registry.ItemRegister;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;

@Mod("taoist_magic")
public class TaoistMagic {
    public static final String MOD_ID="taoist_magic";
    public TaoistMagic(IEventBus modBus, ModContainer modContainer){
        ItemRegister.ITEMS.register(modBus);
        BlockRegister.BLOCKS.register(modBus);
        CreativeTabRegister.CREATIVE_TAB.register(modBus);
        //NeoForge.EVENT_BUS.register(this);
    }
}
