package net.mcreator.jonmod.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;

import net.mcreator.jonmod.JonmodModElements;
import net.mcreator.jonmod.JonmodMod;

import java.util.Map;
import java.util.HashMap;

@JonmodModElements.ModElement.Tag
public class DisableFloatProcedure extends JonmodModElements.ModElement {
	public DisableFloatProcedure(JonmodModElements instance) {
		super(instance, 52);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				JonmodMod.LOGGER.warn("Failed to load dependency entity for procedure DisableFloat!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.setNoGravity((false));
	}

	@SubscribeEvent
	public void onEntityJoin(EntityJoinWorldEvent event) {
		World world = event.getWorld();
		Entity entity = event.getEntity();
		double i = entity.getPosX();
		double j = entity.getPosY();
		double k = entity.getPosZ();
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("x", i);
		dependencies.put("y", j);
		dependencies.put("z", k);
		dependencies.put("world", world);
		dependencies.put("entity", entity);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
