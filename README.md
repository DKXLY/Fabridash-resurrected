# Fabridash Mod
With this mod you will be able to dash across your world, using 3 different items! And also, if you are a developer you may use this mod as an API to integrate dashing (get it? eheh) into your project! This fork is created as a way to continue using this mod in future Minecraft versions, I am NOT the original creator, the dashing code was made by [EmaFire003](https://github.com/emafire003/).

## The Dash items
Unlike other mods, to perform a dash with this mod you will need to find some treasure first! A **Dash Globe** to be precise, and it can be found inside treasure chests from ancienty cities, mineshafts and such! (with a chance that goes from a minimum of 12% in mineshafts to 30% in the end city).

Once you obtain the core item, you may craft the actual "dashers" (yeah, I kinda like making puns):

You can dash by right clicking the dasher item. 
### Iron Dasher
The most basic (yet powerful) item that will let you dash to your next journey, you can craft it like this:

![iron_dasher_crafting](https://user-images.githubusercontent.com/29462910/190399028-f819dfd4-29bd-4d30-a572-cc95c38bff68.JPG)
(It will require a Dash Globe, 4 Iron Blocks, 4 Redstone Blocks)

It will provide a decent boost (multiplier of 1) and it has a cooldown of 80 ticks.

![irondashergif](https://user-images.githubusercontent.com/29462910/190407499-c01c96f9-4dd9-47a3-a813-25e6f7707551.gif)

### Diamond Dasher
The advanced version of the iron dasher, which you can craft like this:

![diamond_dasher_crafting](https://user-images.githubusercontent.com/29462910/190399957-6fa7297d-87ff-4fc2-8aa4-d1c087a1049d.JPG)
(It will require a Dash Globe, 4 Diamond Blocks, 4 Redstone Blocks) (yes pretty expensive)

It will provide a bigger boost (multiplier 2) with a cooldown of 120 ticks.

![diamondashergif)](https://user-images.githubusercontent.com/29462910/190407984-add714c6-5944-49f2-84a5-509291d59a02.gif)

### Obsidian Dasher
The weird and "reversed" version of the diamond dasher, craftable like so:

![obsidian_dasher_crafting](https://user-images.githubusercontent.com/29462910/190400323-f01b4d84-f7dd-476d-849c-cf3ad0a1beed.JPG)
(It will require a Diamond Dasher, 4 Obisidian)

This item will let you do a *backwards* dash, with a multiplier of 2 and a cooldown of 120 ticks (just like the diamond one, but reversed in direction)

![obsidiandashergif](https://user-images.githubusercontent.com/29462910/190408729-e8e78885-b2e9-4a1e-99e4-85fc27d96788.gif)

Whenever one of this gets activated you will hear a dash sound effect, and see some particles! 

## Sponsor
[![bisecthosting](https://www.bisecthosting.com/partners/custom-banners/e9c85d2a-cafa-4e2f-98bf-4f62bd9e951c.png)](https://www.bisecthosting.com/LightDev)

If you like the mod you can always buy me a kofi

[![ko-fi](https://ko-fi.com/img/githubbutton_sm.svg)](https://ko-fi.com/S6S88307C)

## Config & gamerule
To have a higher boost for the dash you can use the `dashMultiplier` gamerule. This value will be *multiplied* by the default value of the items.

There is also a config file, where you can disable the items entirely and only use this as an API

## For developers
Once you've got the mod implemented into you project (See setup), you will simply need to call `Fabridash.dash(Entity entity, float power, boolean reversed)`
The `entity` is the one that will perform the dash, the `power` is how far it will go and the `reversed` on **true** will make the entity go **backwards** instead of forward. And that's it.

## Coming soon-ish 
I will probably expand the ways in which you will be able to dash, going from a key press to maybe a "passive" ability, or a command. All of which will be togglable. This mod was born to create an API for future projects in need of a dash ability. Like my other (kind of "main") project [LightWithin](https://modrinth.com/mods/LightWithin)! (actually it was born because of that project like a few of my other libs)


## Setup
### Users
Drag and drop the .jar file you have downloaded from curseforge/modrinth and drop it into your mods folder!
### Developers
If you want to use the api module of the mod, add it in your build.gradle, using modrnith's repo like this:
```gradle
repositories {
    maven {
        name = "Modrinth"
        url = "https://api.modrinth.com/maven"
        content {
            includeGroup "maven.modrinth"
        }
    }
}

dependencies {
    modImplementation "maven.modrinth:fabridash:<version>"
}
```
You could even extract the API module and use it as is, but remember to register the client reciver!

## License

This mod is available under the MIT license.
