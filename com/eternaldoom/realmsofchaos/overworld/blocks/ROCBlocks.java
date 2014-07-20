package com.eternaldoom.realmsofchaos.overworld.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ROCBlocks {
	//Overworld
	public static OverworldBlock citronite_ore;
    public static OverworldBlock citronite_block;
    public static Block extractor;
    public static Block extractor_on;
    public static OverworldBlock xylite_ore;
    public static OverworldBlock xylite_block;
    public static OverworldBlock heliotrope_ore;
    public static OverworldBlock heliotrope_block;
    public static Block water_portal;
	
    //Nether
	public static OverworldBlock charwood_leaves;
	public static OverworldBlock charwood_log;
	public static OverworldBlock charwood_sapling;
	public static OverworldBlock netherrack_bricks;
    public static OverworldBlock charwood_planks;

	public static void init() {
		citronite_ore = new BlockCitroniteOre().register("citronite_ore");
		charwood_leaves = new BlockCharwoodLeaves().register("charwood_leaves");
		charwood_log = new BlockCharwoodLog().register("charwood");
		charwood_sapling = new BlockCharwoodSapling().register("charwood_sapling");
		netherrack_bricks = new OverworldBlock(Material.rock, "realmsofchaos:netherrack_bricks", "bricksHellrock", 0.4f, 1.0f, OverworldBlock.soundTypePiston).register("netherrack_bricks");
        citronite_block = new OverworldBlock(Material.glass, "realmsofchaos:citronite_block", "blockCitronite", 5.0f, 12.0f, OverworldBlock.soundTypeGlass).register("citronite_block");
        charwood_planks = new OverworldBlock(Material.wood, "realmsofchaos:charwood_planks", "planksCharwood", 4.0f, 2.5f, OverworldBlock.soundTypeWood).register("charwood_planks");
        extractor = new BlockExtractor(false).register("extractor");
        extractor_on = new BlockExtractor(true).register("extractor_on");
        xylite_ore = new BlockXyliteOre().register("xylite_ore");
        xylite_block = new OverworldBlock(Material.iron, "realmsofchaos:xylite_block", "blockXylite", 7.5f, 13.5f, OverworldBlock.soundTypeMetal).register("xylite_block");
        heliotrope_ore = new OverworldBlock(Material.rock, "realmsofchaos:heliotrope_ore", "oreHeliotrope", 5.0f, 14.5f, OverworldBlock.soundTypePiston).register("heliotrope_ore");
        heliotrope_block = new OverworldBlock(Material.rock, "realmsofchaos:heliotrope_block", "blockHeliotrope", 5.5f, 1000000.0f, OverworldBlock.soundTypePiston).register("heliotrope_block");
        water_portal = new BlockWaterPortal();
        GameRegistry.registerBlock(water_portal, "water_portal");
	}

}
