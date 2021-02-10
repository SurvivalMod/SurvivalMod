package net.mcreator.survivalmod.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.survivalmod.item.MateauItem;
import net.mcreator.survivalmod.SurvivalmodModElements;

import java.util.Map;

@SurvivalmodModElements.ModElement.Tag
public class IronPlateItemIsCraftedsmeltedProcedure extends SurvivalmodModElements.ModElement {
	public IronPlateItemIsCraftedsmeltedProcedure(SurvivalmodModElements instance) {
		super(instance, 26);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure IronPlateItemIsCraftedsmelted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity) {
			ItemStack _setstack = new ItemStack(MateauItem.block, (int) (1));
			_setstack.setCount((int) 1);
			ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
		}
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).inventory.clearMatchingItems(p -> new ItemStack(MateauItem.block, (int) (1)).getItem() == p.getItem(), (int) 1);
	}
}
