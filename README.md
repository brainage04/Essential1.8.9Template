# (romangraef) Architectury Loom based template for 1.8.9 forge mods

**For other templates, do check out the [other branches of this repository](https://github.com/romangraef/Forge1.8.9Template/branches/all)**

To get started, clone this repository.
In `build.gradle.kts`, replace the values of `baseGroup` and `group` with your own names.
In `settings.gradle.kts` change `rootProject.name` to your desired mod id.

The `com.example` package needs to be renamed to match the value of `baseGroup`.

If you don't want mixins (which allow for modifying vanilla code), then you can remove the references to mixins from
the `build.gradle.kts` at the lines specified with comments and the `com.example.mixin` package.

This project uses [DevAuth](https://github.com/DJtheRedstoner/DevAuth) per default, so you can log in using your real
minecraft account. If you don't need that, you can remove it from the buildscript.

To run the mod you will need two JDKs, one Java 17 jdk and one Java 1.8 jdk. You can download those
from [here](https://adoptium.net/temurin/releases) (or use your own downloads).

When you import your project into IntelliJ, you need to set the gradle jvm to the Java 17 JDK in the gradle tab, and the
Project SDK to the Java 1.8 JDK. Then click on the sync button in IntelliJ, and it should create a run task
called `Minecraft Client`. If it doesn't then try relaunching your IntelliJ. **Warning for Mac users**: You might have to remove the `-XStartOnFirstThread` vm argument from your run configuration. In the future, that should be handled by the plugin, but for now you'll probably have to do that manually.

To export your project, run the `gradle build` task, and give other people the
file `build/libs/<modid>-<version>.jar`. Ignore the jars in the `build/badjars` folder. Those are intermediary jars that
are used by the build system but *do not work* in a normal forge installation.

### For those who have not an attention span

[![Youtube Tutorial](https://i.ytimg.com/vi/nWzHlomdCgc/maxresdefault.jpg)](https://www.youtube.com/watch?v=nWzHlomdCgc)

## Licensing

This template is licensed under the Unlicense (license copy present in this repository), or alternatively under [Creative Commons 1.0 Universal (CC0 1.0)](https://creativecommons.org/publicdomain/zero/1.0/), and all contributions and PR to this template are expected to follow this. This means your mod, based on this template can be licensed whatever way you want, and does not need to reference back to this template in any way.

# (brainage04) Installing Essential

Note: This template comes pre-packaged with Essential, this is purely for informative purposes/in case you need to re-install Essential.

To install essential, include this line in your ```repositories``` block:
```
maven("https://repo.essential.gg/repository/maven-public/")
```

Then include the following lines in your ```dependencies``` block:
```
    compileOnly("gg.essential:essential-1.8.9-forge:4246+g8be73312c")
    shadowImpl("gg.essential:loader-launchwrapper:1.2.0")
```

The function ```shadowImpl``` should already be in your ```build.gradle.kts``` file, but if not, paste this above your dependencies block:
```
val shadowImpl: Configuration by configurations.creating {
    configurations.implementation.get().extendsFrom(this)
}
```

After you have added this, press Ctrl+Shift+O to reload Gradle changes. This will download the dependencies for Essential.

Once reloaded, you should have configurations in the top left of IntelliJ for ```Minecraft Client``` and ```Minecraft Server```. Edit the configuration settings for ```Minecraft Client``` and add the following line to your program arguments:
```
--tweakClass gg.essential.loader.stage0.EssentialSetupTweaker
```
This will load the Essential DI when the game launches, preventing any ```DI uninitialized!``` crashes.

If you are still experiencing crashes, make sure all steps of this section have been completed correctly before reaching out for support.

## Refactoring

You should rename the packages and classes (specifically those titled ```examplemod``` or ```ExampleMod```) before beginning development. Complete the following steps:

1. Refactor (Shift+F6) ```com.yourname``` and change ```yourname``` to your Minecraft username. Use all lowercase, letters only to avoid issues.
2. Refactor ```com.yourname.yourmod``` and change ```yourmod``` to the name of your mod. Use all lowercase, letters only to avoid issues.
3. Refactor ```YourMod``` to the name of your mod in camel case (including the first letter of the first word - UsingCapitalLettersInsteadOfSpacesLikeThis).
4. Update the ```MODID``` and ```MODNAME``` variables in the ```YourMod``` class.

This is optional but recommended if you are going to publish this mod:

5. Update the ```name```, ```description```, ```url```, ```updateUrl``` and ```authorList``` variables (```url``` and ```updateUrl``` should be a link to your GitHub repository + the same link with ```releases/latest/``` appended respectively).

You don't need to complete these steps, but you should if you plan to use mixins:

6. Refactor ```mixins.yourmod.json``` and update the ```yourmod``` string. Use all lowercase, letters only to avoid issues.
7. In ```mixins.yourmod.json```, change the ```package``` variable from ```com.yourname.yourmod.mixin``` and update the ```yourname``` and ```yourmod``` strings. Use all lowercase, letters only to avoid issues.
8. In ```mixins.yourmod.json```, change the ```refmap``` variable from ```mixins.yourmod.refmap.json``` and update the ```yourmod``` string. Use all lowercase, letters only to avoid issues.