package net.squidartcreates.iceandfireeggsinchests.datagen;

import com.github.alexthe666.iceandfire.IceAndFire;
import com.github.alexthe666.iceandfire.item.IafItemRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;
import net.squidartcreates.iceandfireeggsinchests.EggsInChest;
import net.squidartcreates.iceandfireeggsinchests.loot.AddEggModifier;

import static java.lang.Math.sqrt;

public class AddEggModifierGenerator extends GlobalLootModifierProvider {
    public AddEggModifierGenerator(PackOutput output) {
        super(output, EggsInChest.MODID);
    }

    @Override
    protected void start() {

        //Adds Fire Dragon Egg to the Bonus chest at the start of world generation.
//        add("stater_chest_testing", new AddEggModifier(new LootItemCondition[]{
//                new LootTableIdCondition.Builder(new ResourceLocation("chests/spawn_bonus_chest")).build()},
//                "fire"));

        //Adds Fire Dragon Eggs to the chests found in female fire dragon caves
        add("female_fire_dragon_cave_eggs", new AddEggModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("iceandfire:chest/fire_dragon_female_cave")).build(),
                LootItemRandomChanceCondition.randomChance((float) sqrt(0.2f)).build()},
                "fire"));
        //Adds Eggs to Male dragon chests
        add("male_fire_dragon_cave_eggs", new AddEggModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("iceandfire:chest/fire_dragon_male_cave")).build(),
                LootItemRandomChanceCondition.randomChance((float) sqrt(0.16f)).build()},
                "fire"));
        //Ditto for ice
        add("female_ice_dragon_cave_eggs", new AddEggModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("iceandfire:chest/ice_dragon_female_cave")).build(),
                LootItemRandomChanceCondition.randomChance((float) sqrt(0.2f)).build()},
                "ice"));
        //Adds Eggs to Male dragon chests
        add("male_ice_dragon_cave_eggs", new AddEggModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("iceandfire:chest/ice_dragon_male_cave")).build(),
                LootItemRandomChanceCondition.randomChance((float) sqrt(0.16f)).build()},
                "ice"));
        //Ditto for lightning
        add("female_lightning_dragon_cave_eggs", new AddEggModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("iceandfire:chest/lightning_dragon_female_cave")).build(),
                LootItemRandomChanceCondition.randomChance((float) sqrt(0.2f)).build()},
                "lightning"));
        //Adds Eggs to Male dragon chests
        add("male_lightning_dragon_cave_eggs", new AddEggModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("iceandfire:chest/lightning_dragon_male_cave")).build(),
                LootItemRandomChanceCondition.randomChance((float) sqrt(0.16f)).build()},
                "lightning"));
    }
}
