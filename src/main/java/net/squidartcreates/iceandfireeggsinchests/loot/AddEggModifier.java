package net.squidartcreates.iceandfireeggsinchests.loot;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.function.Supplier;

import com.github.alexthe666.iceandfire.item.IafItemRegistry;
import com.github.alexthe666.iceandfire.item.ItemDragonEgg;
import com.github.alexthe666.iceandfire.loot.IafLootRegistry;
import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Cod;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.apache.commons.lang3.ObjectUtils;
import org.jetbrains.annotations.NotNull;

public class AddEggModifier  extends LootModifier {
    public static final Supplier<Codec<AddEggModifier>> CODEC = Suppliers.memoize(()
            -> RecordCodecBuilder.create(inst -> codecStart(inst).and(Codec.STRING
            .fieldOf("eggType").forGetter(m -> m.eggType)).apply(inst, AddEggModifier::new)));

    public RegistryObject<Item>[] fireEggVariants = new RegistryObject[]{
            IafItemRegistry.DRAGONEGG_RED,
            IafItemRegistry.DRAGONEGG_GREEN,
            IafItemRegistry.DRAGONEGG_GRAY,
            IafItemRegistry.DRAGONEGG_BRONZE
    };
    public RegistryObject<Item>[] iceEggVariants = new RegistryObject[]{
            IafItemRegistry.DRAGONEGG_BLUE,
            IafItemRegistry.DRAGONEGG_SAPPHIRE,
            IafItemRegistry.DRAGONEGG_WHITE,
            IafItemRegistry.DRAGONEGG_SILVER
    };
    public RegistryObject<Item>[] lightningEggVariants = new RegistryObject[]{
            IafItemRegistry.DRAGONEGG_COPPER,
            IafItemRegistry.DRAGONEGG_ELECTRIC,
            IafItemRegistry.DRAGONEGG_AMYTHEST,
            IafItemRegistry.DRAGONEGG_BLACK,
    };



    int colorValue;
    private Item randomEgg;
    private final String eggType;
    private RegistryObject<Item>[] eggVariantList;

    public AddEggModifier(LootItemCondition[] conditionsIn, String eggType) {
        super(conditionsIn);
        this.eggType = eggType;
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {

        for (LootItemCondition condition : this.conditions) {
            if (!condition.test(context)) {
                return generatedLoot;
            }
        }

        int numberOfEggs = context.getRandom().nextInt(3) + 1;
        System.out.println(numberOfEggs + " eggs generating");

        switch (eggType.toLowerCase()) {
            case "fire":
                eggVariantList = fireEggVariants;
                break;
            case "ice":
                eggVariantList = iceEggVariants;
                break;
            case "lightning":
                eggVariantList = lightningEggVariants;
                break;
            default:
                eggVariantList = null;
        }
        if (eggVariantList != null) {
            for (int i = 0; i < numberOfEggs; i++) {
                colorValue = context.getRandom().nextInt(eggVariantList.length);
                randomEgg = eggVariantList[colorValue].get();
                generatedLoot.add(new ItemStack(randomEgg));
                System.out.println("egg " + i);
            }
        }
        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}
