
#silk tnt
execute if block ~ ~ ~ barrel{Items:[{Slot:2b, id:"minecraft:tnt"},{Slot:3b, id:"minecraft:tnt"},{Slot:4b, id:"minecraft:tnt"},{Slot:11b, id:"minecraft:tnt"},{Slot:12b, id:"minecraft:enchanted_book",tag:{StoredEnchantments:[{id:"minecraft:silk_touch"}]} },{Slot:13b, id:"minecraft:tnt"},{Slot:20b, id:"minecraft:tnt"},{Slot:21b, id:"minecraft:tnt"},{Slot:22b, id:"minecraft:tnt"}]} run loot replace block ~ ~ ~ container.16 loot icytnt:silk_touch_tnt
execute if block ~ ~ ~ barrel{Items:[{Slot:2b, id:"minecraft:tnt"},{Slot:3b, id:"minecraft:tnt"},{Slot:4b, id:"minecraft:tnt"},{Slot:11b, id:"minecraft:tnt"},{Slot:12b, id:"minecraft:enchanted_book",tag:{StoredEnchantments:[{id:"minecraft:silk_touch"}]} },{Slot:13b, id:"minecraft:tnt"},{Slot:20b, id:"minecraft:tnt"},{Slot:21b, id:"minecraft:tnt"},{Slot:22b, id:"minecraft:tnt"}]} store success block ~ ~ ~ Items[{Slot:16b}].Count byte 8 if entity @s

#fortune
execute if block ~ ~ ~ barrel{Items:[{Slot:2b, id:"minecraft:tnt"},{Slot:3b, id:"minecraft:tnt"},{Slot:4b, id:"minecraft:tnt"},{Slot:11b, id:"minecraft:tnt"},{Slot:12b, id:"minecraft:enchanted_book",tag:{StoredEnchantments:[{id:"minecraft:fortune"}]} },{Slot:13b, id:"minecraft:tnt"},{Slot:20b, id:"minecraft:tnt"},{Slot:21b, id:"minecraft:tnt"},{Slot:22b, id:"minecraft:tnt"}]} run loot replace block ~ ~ ~ container.16 loot icytnt:fortune_tnt
execute if block ~ ~ ~ barrel{Items:[{Slot:2b, id:"minecraft:tnt"},{Slot:3b, id:"minecraft:tnt"},{Slot:4b, id:"minecraft:tnt"},{Slot:11b, id:"minecraft:tnt"},{Slot:12b, id:"minecraft:enchanted_book",tag:{StoredEnchantments:[{id:"minecraft:fortune"}]} },{Slot:13b, id:"minecraft:tnt"},{Slot:20b, id:"minecraft:tnt"},{Slot:21b, id:"minecraft:tnt"},{Slot:22b, id:"minecraft:tnt"}]} store success block ~ ~ ~ Items[{Slot:16b}].Count byte 8 if entity @s

#chemical

execute if block ~ ~ ~ barrel{Items:[{Slot:2b, id:"minecraft:spider_eye"},{Slot:3b, id:"minecraft:tnt"},{Slot:4b, id:"minecraft:spider_eye"},{Slot:11b, id:"minecraft:spider_eye"},{Slot:12b, id:"minecraft:tnt"},{Slot:13b, id:"minecraft:spider_eye"},{Slot:20b, id:"minecraft:spider_eye"},{Slot:21b, id:"minecraft:tnt"},{Slot:22b, id:"minecraft:spider_eye"}]} run loot replace block ~ ~ ~ container.16 loot icytnt:chemical_tnt
execute if block ~ ~ ~ barrel{Items:[{Slot:2b, id:"minecraft:spider_eye"},{Slot:3b, id:"minecraft:tnt"},{Slot:4b, id:"minecraft:spider_eye"},{Slot:11b, id:"minecraft:spider_eye"},{Slot:12b, id:"minecraft:tnt"},{Slot:13b, id:"minecraft:spider_eye"},{Slot:20b, id:"minecraft:spider_eye"},{Slot:21b, id:"minecraft:tnt"},{Slot:22b, id:"minecraft:spider_eye"}]} store success block ~ ~ ~ Items[{Slot:16b}].Count byte 3 if entity @s

#magnetic
execute if block ~ ~ ~ barrel{Items:[{Slot:2b, id:"minecraft:iron_ingot"},{Slot:3b, id:"minecraft:tnt"},{Slot:4b, id:"minecraft:iron_ingot"},{Slot:11b, id:"minecraft:iron_ingot"},{Slot:12b, id:"minecraft:tnt"},{Slot:13b, id:"minecraft:iron_ingot"},{Slot:20b, id:"minecraft:iron_ingot"},{Slot:21b, id:"minecraft:tnt"},{Slot:22b, id:"minecraft:iron_ingot"}]} run loot replace block ~ ~ ~ container.16 loot icytnt:magnetic_tnt
execute if block ~ ~ ~ barrel{Items:[{Slot:2b, id:"minecraft:iron_ingot"},{Slot:3b, id:"minecraft:tnt"},{Slot:4b, id:"minecraft:iron_ingot"},{Slot:11b, id:"minecraft:iron_ingot"},{Slot:12b, id:"minecraft:tnt"},{Slot:13b, id:"minecraft:iron_ingot"},{Slot:20b, id:"minecraft:iron_ingot"},{Slot:21b, id:"minecraft:tnt"},{Slot:22b, id:"minecraft:iron_ingot"}]} store success block ~ ~ ~ Items[{Slot:16b}].Count byte 3 if entity @s

#quantum
execute if block ~ ~ ~ barrel{Items:[{Slot:2b, id:"minecraft:chorus_fruit"},{Slot:3b, id:"minecraft:tnt"},{Slot:4b, id:"minecraft:chorus_fruit"},{Slot:11b, id:"minecraft:chorus_fruit"},{Slot:12b, id:"minecraft:tnt"},{Slot:13b, id:"minecraft:chorus_fruit"},{Slot:20b, id:"minecraft:chorus_fruit"},{Slot:21b, id:"minecraft:tnt"},{Slot:22b, id:"minecraft:chorus_fruit"}]} run loot replace block ~ ~ ~ container.16 loot icytnt:quantum_tnt
execute if block ~ ~ ~ barrel{Items:[{Slot:2b, id:"minecraft:chorus_fruit"},{Slot:3b, id:"minecraft:tnt"},{Slot:4b, id:"minecraft:chorus_fruit"},{Slot:11b, id:"minecraft:chorus_fruit"},{Slot:12b, id:"minecraft:tnt"},{Slot:13b, id:"minecraft:chorus_fruit"},{Slot:20b, id:"minecraft:chorus_fruit"},{Slot:21b, id:"minecraft:tnt"},{Slot:22b, id:"minecraft:chorus_fruit"}]} store success block ~ ~ ~ Items[{Slot:16b}].Count byte 3 if entity @s



#inversion
execute if block ~ ~ ~ barrel{Items:[{Slot:2b, id:"minecraft:ender_pearl"},{Slot:3b, id:"minecraft:ender_pearl"},{Slot:4b, id:"minecraft:ender_pearl"},{Slot:11b, id:"minecraft:ender_pearl"},{Slot:12b, id:"minecraft:tnt"},{Slot:13b, id:"minecraft:ender_pearl"},{Slot:20b, id:"minecraft:ender_pearl"},{Slot:21b, id:"minecraft:ender_pearl"},{Slot:22b, id:"minecraft:ender_pearl"}]} run loot replace block ~ ~ ~ container.16 loot icytnt:inversion_tnt

#icy
execute if block ~ ~ ~ barrel{Items:[{Slot:2b, id:"minecraft:packed_ice"},{Slot:3b, id:"minecraft:packed_ice"},{Slot:4b, id:"minecraft:packed_ice"},{Slot:11b, id:"minecraft:packed_ice"},{Slot:12b, id:"minecraft:tnt"},{Slot:13b, id:"minecraft:packed_ice"},{Slot:20b, id:"minecraft:packed_ice"},{Slot:21b, id:"minecraft:packed_ice"},{Slot:22b, id:"minecraft:packed_ice"}]} run loot replace block ~ ~ ~ container.16 loot icytnt:icy_tnt

#nuclear
execute if block ~ ~ ~ barrel{Items:[{Slot:2b, id:"minecraft:tnt"},{Slot:3b, id:"minecraft:tnt"},{Slot:4b, id:"minecraft:tnt"},{Slot:11b, id:"minecraft:tnt"},{Slot:12b, id:"minecraft:wither_skeleton_skull"},{Slot:13b, id:"minecraft:tnt"},{Slot:20b, id:"minecraft:tnt"},{Slot:21b, id:"minecraft:tnt"},{Slot:22b, id:"minecraft:tnt"}]} run loot replace block ~ ~ ~ container.16 loot icytnt:nuclear_tnt

#antimatter
execute if block ~ ~ ~ barrel{Items:[{Slot:2b, tag:{icytnt_id: 1007} },{Slot:3b, tag:{icytnt_id: 1007}},{Slot:4b, tag:{icytnt_id: 1007}},{Slot:11b, tag:{icytnt_id: 1007}},{Slot:12b, id:"minecraft:nether_star"},{Slot:13b, tag:{icytnt_id: 1007} },{Slot:20b, tag:{icytnt_id: 1007} },{Slot:21b, tag:{icytnt_id: 1007}},{Slot:22b, tag:{icytnt_id: 1007}}]} run loot replace block ~ ~ ~ container.16 loot icytnt:antimatter_tnt

#red matter
execute if block ~ ~ ~ barrel{Items:[{Slot:2b, tag:{icytnt_id: 1008} },{Slot:3b, tag:{icytnt_id: 1008}},{Slot:4b, tag:{icytnt_id: 1008}},{Slot:11b, tag:{icytnt_id: 1008}},{Slot:12b, id:"minecraft:nether_star"},{Slot:13b, tag:{icytnt_id: 1008} },{Slot:20b, tag:{icytnt_id: 1008} },{Slot:21b, tag:{icytnt_id: 1008}},{Slot:22b, tag:{icytnt_id: 1008}}]} run loot replace block ~ ~ ~ container.16 loot icytnt:black_hole_tnt
