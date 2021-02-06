
particle minecraft:portal ~ ~ ~ 3 3 3 10 100 normal
effect give @e[type=!armor_stand,type=!painting,type=!item_frame,gamemode=!creative,distance=..32] levitation 3 0 true
execute at @e[type=!armor_stand,type=!painting,type=!item_frame,gamemode=!creative,distance=..32] facing entity @s feet if block ^ ^ ^0.5 #du:non-solid run tp @e[sort=nearest,limit=1] ^ ^ ^0.5
kill @e[distance=..3,tag=!icytnt_hole]
