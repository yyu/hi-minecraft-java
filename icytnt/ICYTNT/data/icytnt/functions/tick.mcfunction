
#player tick
execute as @a at @s run function icytnt:player/tick

#tnt tick
execute as @e[tag=icytnt] at @s run function icytnt:blocks/tnt
execute as @e[tag=icytnt_primed] at @s run function icytnt:tnt/main

#black hole tick
execute as @e[tag=icytnt_hole] at @s run function icytnt:black_hole

#crafter tick
execute as @e[tag=icytnt_crafter] at @s run function icytnt:recipes/tick
