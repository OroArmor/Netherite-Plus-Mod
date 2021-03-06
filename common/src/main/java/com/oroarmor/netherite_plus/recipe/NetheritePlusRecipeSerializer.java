/*
 * MIT License
 *
 * Copyright (c) 2021 OroArmor (Eli Orona)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.oroarmor.netherite_plus.recipe;

import com.oroarmor.netherite_plus.config.NetheritePlusConfig;
import me.shedaniel.architectury.registry.RegistrySupplier;

import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialRecipeSerializer;
import net.minecraft.util.registry.Registry;

import static com.oroarmor.netherite_plus.NetheritePlusMod.REGISTRIES;
import static com.oroarmor.netherite_plus.NetheritePlusMod.id;

public final class NetheritePlusRecipeSerializer {
    public static RegistrySupplier<SpecialRecipeSerializer<NetheriteShulkerBoxColoringRecipe>> NETHERITE_SHULKER_BOX;
    public static RegistrySupplier<SpecialRecipeSerializer<NetheriteShieldDecorationRecipe>> NETHERITE_SHIELD;

    static {
        NETHERITE_SHULKER_BOX = NetheritePlusConfig.ENABLED.ENABLED_SHULKER_BOXES.getValue() ? register("crafting_special_netheriteshulkerboxcoloring", new SpecialRecipeSerializer<>(NetheriteShulkerBoxColoringRecipe::new)) : null;
        NETHERITE_SHIELD = NetheritePlusConfig.ENABLED.ENABLED_SHIELDS.getValue() ? register("crafting_special_netheriteshielddecoration", new SpecialRecipeSerializer<>(NetheriteShieldDecorationRecipe::new)) : null;
    }

    public static void init() {
    }

    @SuppressWarnings("unchecked")
    public static <S extends RecipeSerializer<T>, T extends Recipe<?>> RegistrySupplier<S> register(String id, S serializer) {
        return (RegistrySupplier<S>) REGISTRIES.get().get(Registry.RECIPE_SERIALIZER_KEY).register(id(id), () -> serializer);
    }

}
