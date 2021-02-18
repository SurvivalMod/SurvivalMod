package net.mcreator.survivalmod.procedures;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.survivalmod.SurvivalmodModElements;

import java.util.Map;

@SurvivalmodModElements.ModElement.Tag
public class OverlayXYZDisplayOverlayIngameProcedure extends SurvivalmodModElements.ModElement {
	public OverlayXYZDisplayOverlayIngameProcedure(SurvivalmodModElements instance) {
		super(instance, 29);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure OverlayXYZDisplayOverlayIngame!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		return ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(Items.COMPASS, (int) (1)).getItem())
				|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
						.getItem() == new ItemStack(Items.COMPASS, (int) (1)).getItem()));
	}
}
