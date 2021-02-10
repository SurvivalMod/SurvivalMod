package net.mcreator.survivalmod.procedures;

import net.minecraftforge.energy.CapabilityEnergy;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.block.Blocks;

import net.mcreator.survivalmod.item.DirtGraineItem;
import net.mcreator.survivalmod.block.SolarPannelTier3Block;
import net.mcreator.survivalmod.block.SolarPannelTier2Block;
import net.mcreator.survivalmod.block.SolarPannelTier1Block;
import net.mcreator.survivalmod.SurvivalmodModElements;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.Map;

@SurvivalmodModElements.ModElement.Tag
public class CobbleGeneratorUpdateTickProcedure extends SurvivalmodModElements.ModElement {
	public CobbleGeneratorUpdateTickProcedure(SurvivalmodModElements instance) {
		super(instance, 13);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure CobbleGeneratorUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure CobbleGeneratorUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure CobbleGeneratorUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure CobbleGeneratorUpdateTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == SolarPannelTier1Block.block.getDefaultState()
				.getBlock())
				|| (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == SolarPannelTier2Block.block.getDefaultState()
						.getBlock())
						|| ((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == SolarPannelTier3Block.block
								.getDefaultState().getBlock())))
				&& ((new Object() {
					public int getEnergyStored(BlockPos pos) {
						AtomicInteger _retval = new AtomicInteger(0);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null)
							_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
						return _retval.get();
					}
				}.getEnergyStored(new BlockPos((int) (x - 1), (int) y, (int) z))) >= 100))) {
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) (x - 1), (int) y, (int) z));
				int _amount = (int) 100;
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
			}
			if ((Math.random() < 0.9)) {
				if (!world.getWorld().isRemote) {
					ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, (y + 1), z, new ItemStack(Blocks.COBBLESTONE, (int) (1)));
					entityToSpawn.setPickupDelay(10);
					world.addEntity(entityToSpawn);
				}
			} else {
				if (!world.getWorld().isRemote) {
					ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, (y + 1), z, new ItemStack(DirtGraineItem.block, (int) (1)));
					entityToSpawn.setPickupDelay(10);
					world.addEntity(entityToSpawn);
				}
			}
		} else {
			if (((((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == SolarPannelTier1Block.block.getDefaultState()
					.getBlock())
					|| (((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == SolarPannelTier2Block.block
							.getDefaultState().getBlock())
							|| ((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == SolarPannelTier3Block.block
									.getDefaultState().getBlock())))
					&& ((new Object() {
						public int getEnergyStored(BlockPos pos) {
							AtomicInteger _retval = new AtomicInteger(0);
							TileEntity _ent = world.getTileEntity(pos);
							if (_ent != null)
								_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
							return _retval.get();
						}
					}.getEnergyStored(new BlockPos((int) (x + 1), (int) y, (int) z))) >= 100))) {
				{
					TileEntity _ent = world.getTileEntity(new BlockPos((int) (x + 1), (int) y, (int) z));
					int _amount = (int) 100;
					if (_ent != null)
						_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
				}
				if ((Math.random() < 0.9)) {
					if (!world.getWorld().isRemote) {
						ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, (y + 1), z, new ItemStack(Blocks.COBBLESTONE, (int) (1)));
						entityToSpawn.setPickupDelay(10);
						world.addEntity(entityToSpawn);
					}
				} else {
					if (!world.getWorld().isRemote) {
						ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, (y + 1), z, new ItemStack(DirtGraineItem.block, (int) (1)));
						entityToSpawn.setPickupDelay(10);
						world.addEntity(entityToSpawn);
					}
				}
			} else {
				if (((((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == SolarPannelTier1Block.block
						.getDefaultState().getBlock())
						|| (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == SolarPannelTier2Block.block
								.getDefaultState().getBlock())
								|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == SolarPannelTier3Block.block
										.getDefaultState().getBlock())))
						&& ((new Object() {
							public int getEnergyStored(BlockPos pos) {
								AtomicInteger _retval = new AtomicInteger(0);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null)
									_ent.getCapability(CapabilityEnergy.ENERGY, null)
											.ifPresent(capability -> _retval.set(capability.getEnergyStored()));
								return _retval.get();
							}
						}.getEnergyStored(new BlockPos((int) x, (int) y, (int) (z + 1)))) >= 100))) {
					{
						TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) (z + 1)));
						int _amount = (int) 100;
						if (_ent != null)
							_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
					}
					if ((Math.random() < 0.9)) {
						if (!world.getWorld().isRemote) {
							ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, (y + 1), z, new ItemStack(Blocks.COBBLESTONE, (int) (1)));
							entityToSpawn.setPickupDelay(10);
							world.addEntity(entityToSpawn);
						}
					} else {
						if (!world.getWorld().isRemote) {
							ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, (y + 1), z,
									new ItemStack(DirtGraineItem.block, (int) (1)));
							entityToSpawn.setPickupDelay(10);
							world.addEntity(entityToSpawn);
						}
					}
				} else {
					if (((((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == SolarPannelTier1Block.block
							.getDefaultState().getBlock())
							|| (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == SolarPannelTier2Block.block
									.getDefaultState().getBlock())
									|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == SolarPannelTier3Block.block
											.getDefaultState().getBlock())))
							&& ((new Object() {
								public int getEnergyStored(BlockPos pos) {
									AtomicInteger _retval = new AtomicInteger(0);
									TileEntity _ent = world.getTileEntity(pos);
									if (_ent != null)
										_ent.getCapability(CapabilityEnergy.ENERGY, null)
												.ifPresent(capability -> _retval.set(capability.getEnergyStored()));
									return _retval.get();
								}
							}.getEnergyStored(new BlockPos((int) x, (int) y, (int) (z - 1)))) >= 100))) {
						{
							TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) (z - 1)));
							int _amount = (int) 100;
							if (_ent != null)
								_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
						}
						if ((Math.random() < 0.9)) {
							if (!world.getWorld().isRemote) {
								ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, (y + 1), z,
										new ItemStack(Blocks.COBBLESTONE, (int) (1)));
								entityToSpawn.setPickupDelay(10);
								world.addEntity(entityToSpawn);
							}
						} else {
							if (!world.getWorld().isRemote) {
								ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, (y + 1), z,
										new ItemStack(DirtGraineItem.block, (int) (1)));
								entityToSpawn.setPickupDelay(10);
								world.addEntity(entityToSpawn);
							}
						}
					}
				}
			}
		}
	}
}
