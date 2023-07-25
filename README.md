Minecraft Soy Mod (for verson 1.20.1)

How to access the mod .jar file
- resolve any conflicts
- run .\gradlew build (add --warning-mode=all if you want build error details)
- the .jar file should be in directory "build/libs"

Completed Features
- Items(5): soybean, soybunch, soy sauce, tofu, gypsum
- Blocks(1): gypsum ore (mineable)
- Recipes(4)
- soybean craving meter (no visual bar) (might remove this)
- eating soy refills craving meter

Note:
- Currently there is no way to get edamame in survival mode
- Currently the craving meter is non-togglable and on by default
- Gypsum ore generation is being worked on (maybe, we will see)

Changelog 
- added soybean to creeper's loot table
- added tofu recipe (gypsum + soybunch)
- added 2 recipes to make soybunch ( 9 soybeans or 3 edamame )
- added soybunch (a lot of soybeans = 9 soybeans)
- added recipe to make 3 soybeans from an edamame (shapeless)
- added edamame and tofu (both edible)
- added gypsum item and gypsum ore (mineable with wood pickaxes and above)
- added soy sauce
- optimized tick counting in ModEvents via player.tickCount and removed Global's tickCounter
- added soy craving
- added soy bean
