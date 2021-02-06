data merge entity @s {Fire:32000s}

#ignite tnt
scoreboard players set temp_0 tnt_data 0
execute positioned ~ ~-0.234 ~ unless block ~ ~ ~ tnt store result score temp_0 tnt_data run kill @e[type=tnt,distance=..0.5,limit=1]
execute positioned ~ ~-0.234 ~ unless block ~ ~ ~ tnt if score temp_0 tnt_data matches 1 run summon tnt ~ ~ ~ {Fuse:100s,Passengers:[ {id:"minecraft:armor_stand",Tags:["icytnt_quantum","icytnt_primed"],Fire:32000s,Marker:1b,Invisible:1,Invulnerable:1,NoGravity:1,DisabledSlots:2039583,ArmorItems:[{},{},{},{id:"minecraft:blast_furnace",Count:1b,tag:{CustomModelData:6441004}}]} ]}

#break tnt
scoreboard players set temp_0 tnt_data 0
execute positioned ~ ~-0.234 ~ unless block ~ ~ ~ tnt store result score temp_0 tnt_data run kill @e[type=item,distance=..0.5,limit=1,nbt={Item:{id:"minecraft:tnt"}}]
execute positioned ~ ~-0.234 ~ unless block ~ ~ ~ tnt if score temp_0 tnt_data matches 1 run loot spawn ~ ~ ~ loot icytnt:quantum_tnt

execute unless block ~ ~-0.234 ~ tnt run kill @s
