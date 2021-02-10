
package net.mcreator.survivalmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.block.BlockState;

import net.mcreator.survivalmod.procedures.IronPlateItemIsCraftedsmeltedProcedure;
import net.mcreator.survivalmod.itemgroup.AutomateItemGroup;
import net.mcreator.survivalmod.SurvivalmodModElements;

import java.util.Map;
import java.util.HashMap;

@SurvivalmodModElements.ModElement.Tag
public class IronPlateItem extends SurvivalmodModElements.ModElement {
	@ObjectHolder("survivalmod:iron_plate")
	public static final Item block = null;
	public IronPlateItem(SurvivalmodModElements instance) {
		super(instance, 3);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(AutomateItemGroup.tab).maxStackSize(64));
			setRegistryName("iron_plate");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		public void onCreated(ItemStack itemstack, World world, PlayerEntity entity) {
			super.onCreated(itemstack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				IronPlateItemIsCraftedsmeltedProcedure.executeProcedure($_dependencies);
			}
		}
	}
}
