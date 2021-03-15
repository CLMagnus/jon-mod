package net.mcreator.jonmod.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.EnchantmentHelper;

import net.mcreator.jonmod.JonmodModElements;
import net.mcreator.jonmod.JonmodMod;

import java.util.Map;

@JonmodModElements.ModElement.Tag
public class SlappyHandToolInInventoryTickProcedure extends JonmodModElements.ModElement {
	public SlappyHandToolInInventoryTickProcedure(JonmodModElements instance) {
		super(instance, 10);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				JonmodMod.LOGGER.warn("Failed to load dependency itemstack for procedure SlappyHandToolInInventoryTick!");
			return;
		}
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if ((!((EnchantmentHelper.getEnchantmentLevel(Enchantments.KNOCKBACK, (itemstack)) != 0)))) {
			((itemstack)).addEnchantment(Enchantments.KNOCKBACK, (int) 4);
		}
	}
}
