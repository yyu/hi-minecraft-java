
setblock ~ ~ ~ structure_block{posX: -15, mode: "LOAD", posY: -15, posZ: -15, integrity: 0.995f, showair: 0b, name: "icytnt:nuclear_explosion", showboundingbox: 0b}
setblock ~ ~1 ~ redstone_block

#effects
kill @e[distance=..16,gamemode=!creative]
effect give @e[distance=..32] poison 30 1
effect give @e[distance=..32] nausea 10 1

#scorch logs
fill ~-20 ~-8 ~-20 ~20 ~8 ~20 minecraft:stripped_oak_log replace #minecraft:oak_logs
fill ~-20 ~-8 ~-20 ~20 ~8 ~20 minecraft:stripped_birch_log replace #minecraft:birch_logs
fill ~-20 ~-8 ~-20 ~20 ~8 ~20 minecraft:stripped_spruce_log replace #minecraft:spruce_logs
fill ~-20 ~-8 ~-20 ~20 ~8 ~20 minecraft:stripped_jungle_log replace #minecraft:jungle_logs
fill ~-20 ~-8 ~-20 ~20 ~8 ~20 minecraft:stripped_acacia_log replace #minecraft:acacia_logs
fill ~-20 ~-8 ~-20 ~20 ~8 ~20 minecraft:stripped_dark_oak_log replace #minecraft:dark_oak_logs

fill ~-15 ~-10 ~-15 ~15 ~10 ~15 minecraft:air replace #minecraft:leaves