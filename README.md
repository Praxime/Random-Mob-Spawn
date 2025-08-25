# Random Mob spawn plugin 🧟‍♂️
# [![forthebadge](https://forthebadge.com/images/badges/made-with-java.svg)](https://forthebadge.com)
**🎈 Usable for people who want to spawn random mob on their posistion at anytime**

**⚡ For example, Streamers can use this mod to spawn a random mob execpt 3 bosses (The Enderdragon, The Wither and The Warden) on their posistion after a donation.**

**➡ Use /randommob to spawn a random mob at the location you are.**

**✨ The mob can be as cute to not hurt you or as hostile to INSTANTLY kill you.**

💡・You can use [Command Macros](https://modrinth.com/mod/command-macros) to easily summon a random mob with a specified key.
# Here's a part of the code of this plugin:

```java
private final List<EntityType> spawnableMobs = Arrays.stream(EntityType.values())
        .filter(type -> type.isAlive() && type.isSpawnable())
        .filter(type -> type != EntityType.ENDER_DRAGON
                && type != EntityType.WITHER
                && type != EntityType.WARDEN)
        .toList();
```
### 💝 Support me by giving a star to this Repository.
