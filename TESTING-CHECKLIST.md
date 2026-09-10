# AssortedCore — in-world testing checklist

Manual checks only. Anything automatable lives in `common/src/gametest/java/.../gametest/`
and runs with `./gradlew :neoforge:runGameTestServer` / `:fabric:runGameTest`.

Run each list on **both** NeoForge and Fabric.

## Worldgen
- [ ] New world has silver, tin, lead, aluminum, nickel and platinum ore underground
- [ ] Ruby, sapphire, topaz and peridot ore all generate
- [ ] Deepslate variants appear below y=0

## Machines
- [ ] Grinding mill screen refuses a wooden pickaxe in the tool slot
- [ ] Progress arrow and fuel flame animate

## JEI
- [ ] Grinding Mill and Alloy Forge categories show up
- [ ] Clicking a machine recipe shows the right inputs and output
- [ ] "Uses"/"Recipes" on a dust finds the grinding mill recipe

## Creative
- [ ] Assorted Core tab is populated in the creative menu
