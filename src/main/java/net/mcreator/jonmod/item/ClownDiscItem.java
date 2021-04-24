
package net.mcreator.jonmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.Item;

import net.mcreator.jonmod.itemgroup.SummerpackItemGroup;
import net.mcreator.jonmod.JonmodModElements;

@JonmodModElements.ModElement.Tag
public class ClownDiscItem extends JonmodModElements.ModElement {
	@ObjectHolder("jonmod:clown_disc")
	public static final Item block = null;
	public ClownDiscItem(JonmodModElements instance) {
		super(instance, 46);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, JonmodModElements.sounds.get(new ResourceLocation("jonmod:clown_music")),
					new Item.Properties().group(SummerpackItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("clown_disc");
		}
	}
}
