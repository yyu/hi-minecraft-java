#Ensconcer Compatability
scoreboard players set temp_0 du_data 0
execute unless score $ensconcer.initiated eglobal matches 1 store success score temp_0 du_data run function ensconcer:create_burrow

#Notification
execute unless score temp_0 du_data matches 1 unless block -29999999 0 1600 jukebox run tellraw @a {"text":"[DU] Datapack setup complete! Run /reload to get started.","color":"dark_green"}

#setup
scoreboard players set is_loaded du_data 1
execute unless block -29999999 0 1600 jukebox run setblock -29999999 0 1600 minecraft:jukebox{RecordItem:{id:"minecraft:debug_stick",Count:1,tag:{ du:{} }}}
execute unless block -29999999 0 1601 green_shulker_box run setblock -29999999 0 1601 minecraft:green_shulker_box
execute unless block -29999999 0 1602 oak_wall_sign run setblock -29999999 0 1602 minecraft:oak_wall_sign[facing=south]
fill -29999999 1 1600 -29999999 1 1615 minecraft:bedrock
