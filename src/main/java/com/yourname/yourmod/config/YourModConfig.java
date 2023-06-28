package com.yourname.yourmod.config;

import gg.essential.universal.UChat;
import gg.essential.vigilance.Vigilant;
import gg.essential.vigilance.data.Property;
import gg.essential.vigilance.data.PropertyType;
import org.jetbrains.annotations.NotNull;

import java.io.File;

import static com.yourname.yourmod.YourMod.MODNAME;

public class YourModConfig extends Vigilant {
    @Property(
            type = PropertyType.SWITCH,
            name = "Test Switch",
            description = "This is a test boolean (switch).",
            category = "General", subcategory = "Booleans"
    )
    public static boolean testBooleanSwitch = false;

    @Property(
            type = PropertyType.CHECKBOX,
            name = "Test Checkbox",
            description = "This is a test boolean (checkbox).",
            category = "General", subcategory = "Booleans"
    )
    public static boolean testBooleanCheckbox = false;

    @Property(
            type = PropertyType.TEXT,
            name = "Test Textbox",
            description = "This is a test string (text).",
            category = "General", subcategory = "Strings"
    )
    public static String testText = "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...";

    @Property(
            type = PropertyType.PARAGRAPH,
            name = "Test Paragraph",
            description = "This is a test string (paragraph).",
            category = "General", subcategory = "Strings"
    )
    public static String testParagraph = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

    @Property(
            type = PropertyType.PERCENT_SLIDER,
            name = "Test Percentage Slider",
            description = "This is a test percentage slider.",
            category = "Numbers", subcategory = "Floats"
    )
    public static float testPercentSlider = 0.5F;

    @Property(
            type = PropertyType.DECIMAL_SLIDER,
            name = "Test Decimal Slider",
            description = "This is a test decimal slider.",
            minF = 10F,
            maxF = 20F,
            decimalPlaces = 1,
            category = "Numbers", subcategory = "Floats"
    )
    public static float testDecimalSlider = 15.0F;

    @Property(
            type = PropertyType.SLIDER,
            name = "Test Slider",
            description = "This is a test slider.",
            min = 20,
            max = 40,
            category = "Numbers", subcategory = "Ints"
    )
    public static int testSlider = 30;

    @Property(
            type = PropertyType.NUMBER,
            name = "Test Number",
            description = "This is a test number.",
            min = 40,
            max = 80,
            increment = 2,
            category = "Numbers", subcategory = "Ints"
    )
    public static int testNumber = 60;

    @Property(
            type = PropertyType.SELECTOR,
            name = "Test Selector",
            description = "This is a test selector.",
            options = {"Option 1", "Option 2", "Option 3"},
            category = "Numbers", subcategory = "Ints"
    )
    public static int testSelector = 2;

    @Property(
            type = PropertyType.BUTTON,
            name = "Test Button",
            description = "This is a test button. It runs an action when clicked.",
            category = "Other"
    )
    public static void demoButton() {
        UChat.chat("Test Button clicked!");
    }

    public static YourModConfig INSTANCE = new YourModConfig();

    public YourModConfig() {
        super(new File("./config/yourmod.toml"), MODNAME);
        initialize();
    }
}
