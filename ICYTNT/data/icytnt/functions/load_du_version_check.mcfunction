
execute unless score rng_seed du_data matches -2147483648.. run tellraw @a [{"text":"WARNING: ICY TNT requires the latest version of Datapack Utils. You can download that [here].","color":"red","clickEvent":{"action":"open_url","value":"https://github.com/ImCoolYeah105/Datapack-Utilities/releases"}}]
execute unless score rng_seed du_data matches -2147483648.. run schedule function icytnt:load_du_version_check 10s
