package lcyzsdh.taoist_magic.data;


import lcyzsdh.taoist_magic.TaoistMagic;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = TaoistMagic.MOD_ID,bus = EventBusSubscriber.Bus.MOD)
public class ModDataGenerator {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        DataGenerator generator=event.getGenerator();
        PackOutput output=generator.getPackOutput();
        var lp=event.getLookupProvider();

        ExistingFileHelper existingFileHelper=event.getExistingFileHelper();

        generator.addProvider(event.includeClient(),new ModENLanguageProvider(output));
        generator.addProvider(event.includeClient(),new ModItemModelProvider(output,existingFileHelper));
        generator.addProvider(event.includeClient(),new ModBlockStateProvider(output,existingFileHelper));
        generator.addProvider(event.includeServer(),new ModWorldgen(output,lp));
    }
}
