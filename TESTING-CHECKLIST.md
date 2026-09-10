# AssortedCore — in-world testing checklist

Manual checks only. Anything automatable lives in `common/src/main/java/.../gametest/`
and runs with `./gradlew :neoforge:runGameTestServer` / `:fabric:runGameTest`.

Run each list on **both** NeoForge and Fabric.

## Worldgen
- [ ] New world has silver, tin, lead, aluminum, nickel and platinum ore underground
- [ ] Ruby, sapphire, topaz and peridot ore all generate
- [ ] Deepslate variants appear below y=0
- [ ] Ore drops raw metal / gem, and Fortune multiplies it
- [ ] Silk Touch drops the ore block itself

## Machines
- [ ] Machine core crafts
- [ ] All four grinding mills and all four alloy forges craft
- [ ] Grinding mill accepts an iron pickaxe (or better) in the tool slot, refuses a wooden one
- [ ] Grinding mill turns a copper ingot into copper dust, burning fuel
- [ ] Alloy forge turns 3 copper dust + 1 tin dust into 4 bronze ingots
- [ ] Higher tiers are visibly faster (basic → expert)
- [ ] Progress arrow and fuel flame animate
- [ ] Machine keeps its contents and progress across a world reload
- [ ] Breaking a machine drops its contents
- [ ] Hopper into the top/side inserts input and fuel; hopper below pulls the result

## Items
- [ ] Every metal has ingot, nugget, dust, gear and storage block, and they round-trip in crafting
- [ ] Furnace/blast furnace smelt raw ore and dust into ingots

## JEI
- [ ] Grinding Mill and Alloy Forge categories show up
- [ ] Clicking a machine recipe shows the right inputs and output
- [ ] "Uses"/"Recipes" on a dust finds the grinding mill recipe

## Creative
- [ ] The Assorted Core tab exists and every block/item in it has a model and a name
