
package net.mcreator.jonmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.util.ITooltipFlag;

import net.mcreator.jonmod.procedures.ClownFoodEatenProcedure;
import net.mcreator.jonmod.itemgroup.SummerpackItemGroup;
import net.mcreator.jonmod.JonmodModElements;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

@JonmodModElements.ModElement.Tag
public class ClownItem extends JonmodModElements.ModElement {
	@ObjectHolder("jonmod:clown")
	public static final Item block = null;
	public ClownItem(JonmodModElements instance) {
		super(instance, 51);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(SummerpackItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(20).saturation(20f).setAlwaysEdible().meat().build()));
			setRegistryName("clown");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 128;
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("\u00A77a little buddy"));
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemstack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("world", world);
				ClownFoodEatenProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}
