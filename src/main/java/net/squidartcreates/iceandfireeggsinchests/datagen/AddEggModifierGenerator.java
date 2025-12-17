package net.squidartcreates.iceandfireeggsinchests.datagen;

import com.github.alexthe666.iceandfire.item.IafItemRegistry;
import com.github.alexthe666.iceandfire.item.ItemDragonEgg;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.common.loot.LootTableIdCondition;
import net.squidartcreates.iceandfireeggsinchests.EggsInChest;
import net.squidartcreates.iceandfireeggsinchests.loot.AddEggModifier;

public class AddEggModifierGenerator extends GlobalLootModifierProvider {
    public AddEggModifierGenerator(PackOutput output) {
        super(output, EggsInChest.MODID);
    }

    @Override
    protected void start() {

        add("stater_chest_testing", new AddEggModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/spawn_bonus_chest")).build()},
                IafItemRegistry.DRAGONEGG_ELECTRIC.get()));
                System.out.println("Egg Added");

    }
}
