package lcyzsdh.taoist_magic.registry;

import lcyzsdh.taoist_magic.TaoistMagic;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class CreativeTabRegister {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TAB=DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TaoistMagic.MOD_ID);

    public static final Supplier<CreativeModeTab> TAOIST_MAGIC_TAB=CREATIVE_TAB.register("taoist_magic_tab",()->CreativeModeTab.builder()
            .icon(()->new ItemStack(ItemRegister.METAL_PIECE.get()))
            .displayItems((pParams,pOutput)->{
                ItemRegister.ITEM_LIST.forEach(item-> pOutput.accept(item.get()));
                BlockRegister.BLOCK_LIST.forEach(block->pOutput.accept(block.get()));
            })
            .title(Component.translatable("itemGroup."+TaoistMagic.MOD_ID+".taoist_magic_tab")).build());
}
