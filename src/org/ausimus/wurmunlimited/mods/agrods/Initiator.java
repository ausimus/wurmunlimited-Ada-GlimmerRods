package org.ausimus.wurmunlimited.mods.agrods;
import org.gotti.wurmunlimited.modloader.interfaces.Configurable;
import org.gotti.wurmunlimited.modloader.interfaces.PreInitable;
import org.gotti.wurmunlimited.modloader.interfaces.WurmServerMod;

import java.util.Properties;

public class Initiator implements PreInitable, WurmServerMod, Configurable {
    public static boolean UseAdaOnly;
    public static boolean UseGlimmerOnly;
    public static boolean UseBoth;

    @Override
    public void preInit() {
        new AGRods();
    }

    @Override
    public void configure(Properties properties) {
        UseAdaOnly = Boolean.parseBoolean(properties.getProperty("UseAdaOnly", Boolean.toString(UseAdaOnly)));
        UseGlimmerOnly = Boolean.parseBoolean(properties.getProperty("UseGlimmerOnly", Boolean.toString(UseGlimmerOnly)));
        UseBoth = Boolean.parseBoolean(properties.getProperty("UseBoth", Boolean.toString(UseBoth)));
    }
}