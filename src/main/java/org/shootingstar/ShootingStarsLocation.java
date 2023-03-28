package org.shootingstar;

import java.util.function.Function;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ShootingStarsLocation
{
    ASGARNIA(0, "Asgarnia", "Asgarnia", ShootingStarsConfig::shootingStarShowAsgarniaWorlds),
    KARAMJA(1, "Crandor or Karamja", "Cran/Karam", ShootingStarsConfig::shootingStarShowKaramjaWorlds),
    FELDIP_HILLS(2, "Feldip Hills or on the Isle of Souls", "Feldip/Souls", ShootingStarsConfig::shootingStarShowFeldipWorlds),
    FOSSIL_ISLAND(3, "Fossil Island or on Mos Le'Harmless", "Fossil/Mos", ShootingStarsConfig::shootingStarShowFossilIslandWorlds),
    FREMENNIK(4, "Fremennik Lands or on Lunar Isle", "Frem/Lunar", ShootingStarsConfig::shootingStarShowFremennikWorlds),
    KOUREND(5, "Great Kourend", "Kourend", ShootingStarsConfig::shootingStarShowKourendWorlds),
    KANDARIN(6, "Kandarin", "Kandarin", ShootingStarsConfig::shootingStarShowKandarinWorlds),
    KEBOS(7, "Kebos Lowlands", "Lowlands", ShootingStarsConfig::shootingStarShowKebosWorlds),
    KHARIDIAN_DESERT(8, "Kharidian Desert", "Desert", ShootingStarsConfig::shootingStarShowDesertWorlds),
    MISTHALIN(9, "Misthalin", "Misthalin", ShootingStarsConfig::shootingStarShowMisthalinWorlds),
    MORYTANIA(10, "Morytania", "Morytania", ShootingStarsConfig::shootingStarShowMorytaniaWorlds),
    PISCATORIS(11, "Piscatoris or the Gnome Stronghold", "Pisc/Gnome", ShootingStarsConfig::shootingStarShowPiscatorisWorlds),
    TIRANNWN(12, "Tirannwn", "Tirannwn", ShootingStarsConfig::shootingStarShowTirannwnWorlds),
    WILDERNESS(13, "Wilderness", "Wilderness", ShootingStarsConfig::shootingStarShowWildernessWorlds),
    UNKNOWN(14, "Unknown", "Unknown", c -> false);

    private int id;
    private String name;
    private String shortName;
    private Function<ShootingStarsConfig, Boolean> configFunction;

    public static ShootingStarsLocation determineLocation(String text)
    {
        text = text.replace("<br>", " ");
        for (ShootingStarsLocation l : values())
        {
            if (text.contains(l.name))
            {
                return l;
            }
        }
        return ShootingStarsLocation.UNKNOWN;
    }

    public static ShootingStarsLocation getLocation(int id)
    {
        for (ShootingStarsLocation l : values())
        {
            if (l.getId() == id)
            {
                return l;
            }
        }

        return ShootingStarsLocation.UNKNOWN;
    }
}