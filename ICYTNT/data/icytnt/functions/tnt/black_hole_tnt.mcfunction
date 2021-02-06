setblock ~ ~ ~ structure_block{rotation: "NONE", posX: -30, mode: "LOAD", posY: -30, sizeX: 31, posZ: -30, integrity: 1.0f, name: "icytnt:antimatter_explosion_bottom", sizeY: 31, sizeZ: 31, showboundingbox: 0b}
setblock ~ ~-1 ~ redstone_block
setblock ~ ~-1 ~ air

setblock ~ ~ ~ structure_block{rotation: "CLOCKWISE_90", posX: 30, mode: "LOAD", posY: -30, sizeX: 31, posZ: -30, integrity: 1.0f, name: "icytnt:antimatter_explosion_bottom", sizeY: 31, sizeZ: 31, showboundingbox: 0b}
setblock ~ ~-1 ~ redstone_block
setblock ~ ~-1 ~ air

setblock ~ ~ ~ structure_block{rotation: "CLOCKWISE_180", posX: 30, mode: "LOAD", posY: -30, sizeX: 31, posZ: 30, integrity: 1.0f, name: "icytnt:antimatter_explosion_bottom", sizeY: 31, sizeZ: 31, showboundingbox: 0b}
setblock ~ ~-1 ~ redstone_block
setblock ~ ~-1 ~ air

setblock ~ ~ ~ structure_block{rotation: "COUNTERCLOCKWISE_90", posX: -30, mode: "LOAD", posY: -30, sizeX: 31, posZ: 30, integrity: 1.0f, name: "icytnt:antimatter_explosion_bottom", sizeY: 31, sizeZ: 31, showboundingbox: 0b}
setblock ~ ~-1 ~ redstone_block
setblock ~ ~-1 ~ air



setblock ~ ~ ~ structure_block{rotation: "NONE", posX: -30, mode: "LOAD", posY: 0, sizeX: 31, posZ: -30, integrity: 1.0f, name: "icytnt:antimatter_explosion_top",  sizeY: 31, sizeZ: 31, showboundingbox: 0b}
setblock ~ ~-1 ~ redstone_block
setblock ~ ~-1 ~ air

setblock ~ ~ ~ structure_block{rotation: "CLOCKWISE_90", posX: 30, mode: "LOAD", posY: 0, sizeX: 31, posZ: -30, integrity: 1.0f, name: "icytnt:antimatter_explosion_top",  sizeY: 31, sizeZ: 31, showboundingbox: 0b}
setblock ~ ~-1 ~ redstone_block
setblock ~ ~-1 ~ air

setblock ~ ~ ~ structure_block{rotation: "CLOCKWISE_180", posX: 30, mode: "LOAD", posY: 0, sizeX: 31, posZ: 30, integrity: 1.0f, name: "icytnt:antimatter_explosion_top",  sizeY: 31, sizeZ: 31, showboundingbox: 0b}
setblock ~ ~-1 ~ redstone_block
setblock ~ ~-1 ~ air

setblock ~ ~ ~ structure_block{rotation: "COUNTERCLOCKWISE_90", posX: -30, mode: "LOAD", posY: 0, sizeX: 31, posZ: 30, integrity: 1.0f, name: "icytnt:antimatter_explosion_top",  sizeY: 31, sizeZ: 31, showboundingbox: 0b}
setblock ~ ~-1 ~ redstone_block
setblock ~ ~-1 ~ air

#effects
kill @e[distance=..32,gamemode=!creative]
effect give @e[distance=..64] wither 60 3
effect give @e[distance=..64] nausea 10 1
playsound icytnt:big_explosion block @a ~ ~ ~ 8 1 1

#summon black hole
summon armor_stand ~ ~ ~ {Tags:["icytnt_hole"],Invisible:1,Invulnerable:1,NoGravity:1,DisabledSlots:2039583,ArmorItems:[{},{},{},{id:"minecraft:blast_furnace",Count:1b,tag:{CustomModelData:6441103}}]}
