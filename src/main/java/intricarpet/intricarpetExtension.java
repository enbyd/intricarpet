package intricarpet;

import carpet.CarpetExtension;
import carpet.CarpetServer;
import carpet.settings.SettingsManager;
import intricarpet.logging.intricarpetLoggerRegisty;

public class intricarpetExtension implements CarpetExtension
{
    public static void noop() { }
    public static SettingsManager intricarpetSettingsManager;
    static
    {
        intricarpetSettingsManager = new SettingsManager("1.0", "intricarpet", "Intricate Carpet");
        CarpetServer.manageExtension(new intricarpetExtension());
    }

    @Override
    public void registerLoggers()
    {
        intricarpetLoggerRegisty.registerLoggers();
    }

    @Override
    public String version()
    {
        return "intricarpet";
    }

    @Override
    public void onGameStarted()
    {
        CarpetServer.settingsManager.parseSettingsClass(intricarpetRules.class);
    }

    @Override
    public SettingsManager customSettingsManager()
    {
        return intricarpetSettingsManager;
    }
}
