package org.shootingstar.ui;

import org.shootingstar.ShootingStarsData;
import org.shootingstar.ShootingStarsPlugin;
import java.util.List;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.ui.PluginPanel;

@Slf4j
public abstract class ShootingStarsPluginPanelBase extends PluginPanel
{
    @Getter
    private boolean open = false;

    protected ShootingStarsPlugin plugin;

    protected ShootingStarsPluginPanelBase(ShootingStarsPlugin plugin)
    {
        this(plugin, true);
    }

    protected ShootingStarsPluginPanelBase(ShootingStarsPlugin plugin, boolean wrap)
    {
        super(wrap);
        this.plugin = plugin;
    }

    public abstract void populate(List<ShootingStarsData> stars);
    public abstract void updateList();

    public void onActivate()
    {
        // If the panel is opened, try to run a get request to populate/refresh the panel.
        log.debug("Activated");
        open = true;

    }

    public void onDeactivate()
    {
        log.debug("Deactivated");
        open = false;
    }


}