package net.mcreator.jonmod.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.entity.Entity;

import net.mcreator.jonmod.JonmodModElements;
import net.mcreator.jonmod.JonmodMod;

import java.util.Map;
import java.util.HashMap;

@JonmodModElements.ModElement.Tag
public class DisableFloatOnRespawnProcedure extends JonmodModElements.ModElement {
	public DisableFloatOnRespawnProcedure(JonmodModElements instance) {
		super(instance, 53);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				JonmodMod.LOGGER.warn("Failed to load dependency entity for procedure DisableFloatOnRespawn!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.setNoGravity((false));
	}

	@SubscribeEvent
	public void onPlayerRespawned(PlayerEvent.PlayerRespawnEvent event) {
		Entity entity = event.getPlayer();
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("x", entity.getPosX());
		dependencies.put("y", entity.getPosY());
		dependencies.put("z", entity.getPosZ());
		dependencies.put("world", entity.world);
		dependencies.put("entity", entity);
		dependencies.put("endconquered", event.isEndConquered());
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
