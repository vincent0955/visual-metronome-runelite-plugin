package net.runelite.client.plugins.visualmetronome;

import com.google.inject.Provides;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.api.events.GameTick;

import javax.inject.Inject;

@PluginDescriptor(
        name = "Visual Metronome",
        description = "Shows a visual cue on an overlay every game tick to help timing based activities",
        tags = {"timers", "overlays", "tick", "skilling"},
        enabledByDefault = false
)
public class visualmetronomePlugin extends Plugin
{
    @Inject
    private OverlayManager overlayManager;

    @Inject
    private visualmetronomeOverlay overlay;

    @Inject
    private visualmetronomeConfig config;

    public int CurrentTick = 0;
    private boolean ShouldTick = false;

    @Provides
    visualmetronomeConfig provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(visualmetronomeConfig.class);
    }

    @Subscribe
    public void onGameTick(GameTick tick){
        if (config.tickCount() == 0) {
            return;
        }
        if (config.tickCount() == 1){
            if (CurrentTick == 0){
                CurrentTick = 1;
            }
            else{
                CurrentTick = 0;
            }

        }
    }

    @Override
    protected void startUp() throws Exception
    {
        overlayManager.add(overlay);
    }

    @Override
    protected void shutDown() throws Exception
    {
        overlayManager.remove(overlay);
    }
}
