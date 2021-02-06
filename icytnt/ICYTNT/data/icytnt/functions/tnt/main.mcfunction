
#check fuse
execute positioned ~ ~-0.25 ~ store result score temp_0 tnt_data run data get entity @e[type=tnt,sort=nearest,limit=1,distance=..1] Fuse

#effects
execute if score temp_0 tnt_data matches ..1 positioned ~ ~-0.25 ~ run kill @e[type=tnt,sort=nearest,limit=1,distance=..1]
execute if score temp_0 tnt_data matches ..1 run particle minecraft:cloud ~ ~-0.234 ~ 0 0 0 0.3 100 normal
execute if score temp_0 tnt_data matches ..1 run playsound minecraft:entity.generic.explode block @a ~ ~-0.234 ~ 1 1

#explosion type
execute if score temp_0 tnt_data matches ..1 if entity @s[tag=icytnt_silk] run function icytnt:tnt/silk_tnt
execute if score temp_0 tnt_data matches ..1 if entity @s[tag=icytnt_fortune] run function icytnt:tnt/fortune_tnt
execute if score temp_0 tnt_data matches ..1 if entity @s[tag=icytnt_chemical] run function icytnt:tnt/chemical_tnt
execute if score temp_0 tnt_data matches ..1 if entity @s[tag=icytnt_magnetic] run function icytnt:tnt/magnetic_tnt
execute if score temp_0 tnt_data matches ..1 if entity @s[tag=icytnt_quantum] run function icytnt:tnt/quantum_tnt

execute if score temp_0 tnt_data matches ..1 if entity @s[tag=icytnt_inversion] run function icytnt:tnt/inversion_tnt
execute if score temp_0 tnt_data matches ..1 if entity @s[tag=icytnt_icy] run function icytnt:tnt/icy_tnt
execute if score temp_0 tnt_data matches ..1 if entity @s[tag=icytnt_nuclear] run function icytnt:tnt/nuclear_tnt
execute if score temp_0 tnt_data matches ..1 if entity @s[tag=icytnt_antimatter] run function icytnt:tnt/antimatter_tnt
execute if score temp_0 tnt_data matches ..1 if entity @s[tag=icytnt_black_hole] run function icytnt:tnt/black_hole_tnt

#kill
execute if score temp_0 tnt_data matches ..1 run kill @s