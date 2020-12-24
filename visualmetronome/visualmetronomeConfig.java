package net.runelite.client.plugins.visualmetronome;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("visualmetronome")
public interface visualmetronomeConfig extends Config
{
	@ConfigItem(
			position = 1,
			keyName = "showTitle",
			name = "Show the title of plugin on the overlay",
			description = "Toggle the display of the title"
	)
	default boolean showWorldType()
	{
		return true;
	}

	@ConfigItem(
			keyName = "tickCount",
			name = "Tick count",
			description = "Configures the tick on which a sound will be played."
	)
	default int tickCount()
	{
		return 1;
	}
}

