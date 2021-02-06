
#scoreboard data
scoreboard objectives add tnt_data dummy

#run DU check
schedule function icytnt:load_du_version_check 1s

#Install Message
tellraw @a [{"text":"[Loaded ICY TNT]","color":"dark_green"}]