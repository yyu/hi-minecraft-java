advancement revoke @s only du:triggers/furnace
advancement revoke @s only du:triggers/place_blast_furnace
advancement revoke @s only du:triggers/place_smoker
scoreboard players set in_0 du_data 120
execute positioned ~ ~1.61 ~ run function du:custom_furnace/place
