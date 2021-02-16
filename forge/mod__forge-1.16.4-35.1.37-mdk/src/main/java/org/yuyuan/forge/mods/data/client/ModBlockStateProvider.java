package org.yuyuan.forge.mods.data.client;


import com.example.examplemod.ExampleMod;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.yuyuan.forge.mods.setup.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, ExampleMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ModBlocks.SILVER_BLOCK.get());
        simpleBlock(ModBlocks.SILVER_ORE.get());
    }
}
