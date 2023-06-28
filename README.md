# Setup
Please follow this setup in order, as some steps may be impossible to complete until previous steps have been completed.

## JDKs
You will need two JDKs: Java 17 and Java 1.8. You can download those from here: https://adoptium.net/temurin/releases

1. File > Project Structure (Ctrl + Alt + Shift + S) > Set SDK to 1.8
1. Gradle > Build Tool Settings > Gradle Settings > Set Gradle JVM to 17

## Refactoring
You should rename the packages and classes (specifically those titled `examplemod` or `ExampleMod`) before beginning development. Complete the following steps:

1. Refactor (Shift+F6) `com.yourname` and change `yourname` to your Minecraft username. Use all lowercase, letters only to avoid issues.
2. Refactor `com.yourname.yourmod` and change `yourmod` to the name of your mod. Use all lowercase, letters only to avoid issues.
3. Refactor `YourMod` to the name of your mod in camel case (including the first letter of the first word - UsingCapitalLettersInsteadOfSpacesLikeThis).
4. Update the `MODID` and `MODNAME` variables in the `YourMod` class.
5. Update the `name`, `description`, `url`, `updateUrl` and `authorList` variables (`url` and `updateUrl` should be a link to your GitHub repository + the same link with `releases/latest/` appended respectively).

## Gradle
1. In `gradle.properties` on line 3, change `yourname` to your Minecraft username and `yourmod` to the name of your mod (all lowercase, letters only).
2. In `settings.gradle.kts` on line 21, change `yourmod` to the name of your mod (all lowercase, letters only).

Once complete, press `Ctrl+Shift+O` to reload Gradle changes. This will re-index the files correctly and prevent issues in the following steps.

## DevAuth
This project uses [DevAuth](https://github.com/DJtheRedstoner/DevAuth) per default, so you can log in using your real minecraft account. If you don't need that, you can remove it from the buildscript.

To use DevAuth, add the line `-Ddevauth=enabled` to your `Minecraft Client` run configuration's `Environment variables`.
When you next run the configuration, you will be prompted in the `Run` tab to click a Microsoft OAuth link, where you can sign in with your Microsoft account.
This should only need to be completed once per computer.

## Mixins
If you don't want mixins (which allow for modifying vanilla code), then you can remove the references to mixins from the `build.gradle.kts` at the lines specified with comments and the `com.example.mixin` package.

You don't need to complete these steps, but you should if you plan to use mixins:

1. Refactor `mixins.yourmod.json` and update the `yourmod` string. Use all lowercase, letters only to avoid issues.
2. In `mixins.yourmod.json`, change the `package` variable from `com.yourname.yourmod.mixin` and update the `yourname` and `yourmod` strings. Use all lowercase, letters only to avoid issues.
3. In `mixins.yourmod.json`, change the `refmap` variable from `mixins.yourmod.refmap.json` and update the `yourmod` string. Use all lowercase, letters only to avoid issues.

##z Building/Exporting
To export your project, run the `gradle build` task, and give other people the file `build/libs/<modid>-<version>.jar`.
Ignore the jars in the `build/badjars` folder. Those are intermediary jars that are used by the build system but *do not work* in a normal forge installation.

# Installing Essential
Note: This template comes pre-packaged with Essential, this is purely for informative purposes/in case you need to re-install Essential.

To install essential, include this line in your `repositories` block:
```
maven("https://repo.essential.gg/repository/maven-public/")
```

Then include the following lines in your `dependencies` block:
```
    compileOnly("gg.essential:essential-1.8.9-forge:4246+g8be73312c")
    shadowImpl("gg.essential:loader-launchwrapper:1.2.0")
```

The function `shadowImpl` should already be in your `build.gradle.kts` file, but if not, paste this above your dependencies block:
```
val shadowImpl: Configuration by configurations.creating {
    configurations.implementation.get().extendsFrom(this)
}
```

After you have added this, press `Ctrl+Shift+O` to reload Gradle changes. This will download the dependencies for Essential.

Once reloaded, you should have configurations in the top left of IntelliJ for `Minecraft Client` and `Minecraft Server`. Edit the configuration settings for `Minecraft Client` and add the following line to your program arguments:
```
--tweakClass gg.essential.loader.stage0.EssentialSetupTweaker
```

This will load the Essential DI when the game launches, preventing any `DI uninitialized!` crashes.

If you are still experiencing crashes, make sure all steps of this section have been completed correctly before reaching out for support.

## Licensing

This template is licensed under the Unlicense (license copy present in this repository), or alternatively under [Creative Commons 1.0 Universal (CC0 1.0)](https://creativecommons.org/publicdomain/zero/1.0/), and all contributions and PR to this template are expected to follow this. This means your mod, based on this template can be licensed whatever way you want, and does not need to reference back to this template in any way.