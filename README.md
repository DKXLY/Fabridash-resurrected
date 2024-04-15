<img alt="fabric" height="64" src="https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/supported/fabric_vector.svg">   <img alt="quilt" height="64" src="https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/supported/quilt_vector.svg">

# 📋 NOTE FOR QUILT USERS:
Although the mod SHOULD work on Quilt even above versions `1.20.1`, be aware that there might be unexpected bugs due to the fact that QFAPI (Quilted Fabric API) is still in alpha on Minecraft versions higher than `1.20.1`.

# ❓ What is this?
With this mod, you will be able to **dash** across your world using 5 different items! And also, if you are a developer, you may use this mod as an `API` to integrate dashing into your project!
This fork is created as a way to continue using this mod in future Minecraft versions, I am NOT the original creator, the **dashing** code was made by **Emafire003**: [Modrinth](https://modrinth.com/user/emafire003/) / [Github](https://github.com/emafire003/).

# ✨ Items
To perform a **dash** with this mod, you will need to find some **treasure** first! A **`Dash Globe`** to be precise, and it can be found inside **treasure chests** from **Ancient cities**, **Mineshafts** and such!

Once you obtain the **`Dash Globe`**, you may craft the actual **Dashers**.

You can dash by right clicking the **Dasher** item. TIP: **Jump while dashing to get a bigger boost!**

|Ingredients|Recipe|Output|Notes|
| - | - | - | - |
| `Dash Globe - 1`,<br> `Iron Block - 4`, <br>`Redstone Block - 4` | ![iron_dasher](https://raw.githubusercontent.com/DKXLY/desc-assets/main/iron_dasher.png) | `Iron Dasher` | *Provides a dash with a multiplier of 1 and a cooldown of 80 ticks.* |
| `Iron Dasher - 1`,<br> `Diamond - 8` | ![diamond_dasher](https://raw.githubusercontent.com/DKXLY/desc-assets/main/diamond_dasher.png) | `Diamond Dasher` | *Provides a dash with a multiplier of 3 and a cooldown of 120 ticks.* |
| `Diamond Dasher - 1`,<br> `Obsidian - 8` | ![obsidian_dasher](https://raw.githubusercontent.com/DKXLY/desc-assets/main/obsidian_dasher.png) |`Obsidian Dasher`| *Provides a backwards dash, with a multiplier of 3 and a cooldown of 120 ticks (just like the diamond one, but reversed in direction).* |
| `Obsidian Dasher - 1`, <br> `Amethyst Shard - 8` | ![calibrated_obsidian_dasher](https://raw.githubusercontent.com/DKXLY/desc-assets/main/calibrated_obsidian_dasher.png) | `Calibrated Obsidian Dasher` | *Provides a dash with a multiplier of 3 and a cooldown of 100 ticks. The dash direction can be customized by sneaking and right-clicking.*|
| `Calibrated Obsidian Dasher - 1`, <br> `Netherite Scrap - 6`, <br> `Netherite Ingot - 2` | ![calibrated_netherite_plated_obsidian_dasher](https://raw.githubusercontent.com/DKXLY/desc-assets/main/calibrated_netherite_plated_obsidian_dasher.png) | `Calibrated Netherite-plated Obsidian Dasher` | *Provides a dash with a multiplier of 5 and a cooldown of 80 ticks. The dash direction can be customized by sneaking and right-clicking.* |

Whenever one of these gets activated, you will hear a **dash sound effect**, and (maybe?) see some **particles**! 

# 🔆 Config & gamerule
To have a stronger **dash**, you can use the `dashMultiplier` gamerule. This value will be *multiplied* by the default value of the items.

There is also a config file, where you can disable the items entirely and only use this as an `API`.

# 🔨 Setup
## 🎮 Users
Download the mod from `Modrinth` and drop it into your mods folder!
## 👨‍💻👩‍💻 Developers
If you want to use the `API` module of the mod, add it in your build.gradle, using `Modrinth`'s repo, like this:
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
    modImplementation "maven.modrinth:fabridash-resurrected:<version>"
}
```
Once you've got the mod implemented into you project, you will simply need to call `FabridashResurrected.dash(Entity entity, float power, int direction);`
The `entity` is the entity that will perform the **dash**, the `power` is how far it will go and the `direction` works like this:
| Value | Behavior |
| - | - |
| `0` | Dash will go forwards. |
| `1` | Dash will go to the right. |
| `2` | Dash will go backwards. |
| `3` | Dash will go to the left. |
| `Any other value` | The value is going to be ignored. Dash will go forwards. |

And that's it.

You could even extract the `API` module and use it as is, but remember to register the client dash packet receiver!

# 📜 License
This mod is available under the `MIT license`, however, it would be greatly appreciated to credit me (DKXLY) and Emafire003 if you'll use it somewhere.
