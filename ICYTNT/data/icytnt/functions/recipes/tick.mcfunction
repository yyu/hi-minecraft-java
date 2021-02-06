
#update
execute if score timer_20 du_data matches 0 run data merge entity @s {Fire:32000s}

#GUI
data modify block ~ ~ ~ Items[{tag:{du_gui:1b}}].id set value "minecraft:blast_furnace"
data modify block ~ ~ ~ Items[{tag:{du_gui:1b}}].tag set value {CustomModelData:6441102,du_gui:1b,HideFlags:63,display:{Name:"\"\""}}
replaceitem block ~ ~ ~ container.0 minecraft:blast_furnace{CustomModelData:6441101,du_gui:1b,HideFlags:63,display:{Name:"\"\""}}

#break
execute unless block ~ ~ ~ barrel run kill @e[type=item,distance=..1,limit=1,nbt={Item:{ id:"minecraft:barrel" }}]
execute unless block ~ ~ ~ barrel run kill @e[type=item,distance=..1,limit=1,nbt={Item:{ tag:{du_gui:1b} }}]
execute unless block ~ ~ ~ barrel run loot spawn ~ ~ ~ loot icytnt:demolitioner_table
execute unless block ~ ~ ~ barrel run kill @s
