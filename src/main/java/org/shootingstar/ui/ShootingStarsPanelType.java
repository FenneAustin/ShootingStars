package org.shootingstar.ui;

import org.shootingstar.ui.condensed.ShootingStarsCondensedPluginPanel;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ShootingStarsPanelType
{
    CONDENSED("Condensed", ShootingStarsCondensedPluginPanel.class.asSubclass(ShootingStarsPluginPanelBase.class))
    ;

    private final String name;
    private final Class<? extends ShootingStarsPluginPanelBase> panelClass;

    @Override
    public String toString()
    {
        return getName();
    }
}