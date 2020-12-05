package com.example.gamedesigners.data.details

import com.example.gamedesigners.App
import com.example.gamedesigners.R
import com.example.gamedesigners.data.details.entries.DesignerDescriptionEntry
import com.example.gamedesigners.data.details.entries.DesignerGamesEntry
import com.example.gamedesigners.data.details.entries.DesignersGalleryEntry

class DesignersDetails {

    var descriptions: MutableList<DesignerDescriptionEntry> = ArrayList()
    var games: MutableList<DesignerGamesEntry> = ArrayList()
    var galleries: MutableList<DesignersGalleryEntry> = ArrayList()

    init{
        val context = App.getContext()
        descriptions.add(
            DesignerDescriptionEntry(
                1,
                context.getString(R.string.description_bohemia)
            )
        )
        descriptions.add(
            DesignerDescriptionEntry(
                2,
                context.getString(R.string.description_riot_games)
            )
        )
        descriptions.add(
            DesignerDescriptionEntry(
                3,
                context.getString(R.string.description_blizzard)
            )
        )
        descriptions.add(
            DesignerDescriptionEntry(
                4,
                context.getString(R.string.description_activision)
            )
        )
        descriptions.add(
            DesignerDescriptionEntry(
                5,
                context.getString(R.string.description_blendo_games)
            )
        )
        descriptions.add(
            DesignerDescriptionEntry(
                6,
                context.getString(R.string.description_heart_machine)
            )
        )
        descriptions.add(
            DesignerDescriptionEntry(
                7,
                context.getString(R.string.description_bloober_games)
            )
        )
        descriptions.add(
            DesignerDescriptionEntry(
                8,
                context.getString(R.string.description_11_bit)
            )
        )

        games.add(
            DesignerGamesEntry(
                1,
                arrayListOf("DayZ", "Vigor", "Arma 3", "Ylands", "Arma 3 Karts", "Arma 3 Zeus", "Arma 3 Helicopter", "Take On Mars")
            )
        )
        games.add(
            DesignerGamesEntry(
                2,
                arrayListOf("Leauge of Legends", "Teamfight Tactics", "Valorant")
            )
        )
        games.add(
            DesignerGamesEntry(
                3,
                arrayListOf("Overwatch", "Overwatch2", "World of Warcraft", "Heardstone", "Diablo III")
            )
        )
        games.add(
            DesignerGamesEntry(
                4,
                arrayListOf("Call of Duty®: WWII", "Call of Duty®: Black Ops IIII", "Sekiro®: Shadows Die Twice", "SPYRO® Reignited Trilogy", "Call of Duty®: MW3")
            )
        )
        games.add(
            DesignerGamesEntry(
                5,
                arrayListOf("Skin Deep", "Flotilla 2", "Flotilla", "Gravity Bone", "Air Forte", "Atom Zombie Smasher")
            )
        )
        games.add(
            DesignerGamesEntry(
                6,
                arrayListOf("Hyper Light Drifter", "Solar Ash")
            )
        )
        games.add(
            DesignerGamesEntry(
                7,
                arrayListOf("Observer", "The Medium", "Blair Witch", "Layers of Fear", "Basement Crawl")
            )
        )
        games.add(
            DesignerGamesEntry(
                8,
                arrayListOf("Frostpunk", "Children of Morta", "This War of Mine", "Moonlighter", "Beat Cop")
            )
        )

        galleries.add(
            DesignersGalleryEntry(
                1,
                arrayListOf(R.drawable.bit_11_tank, R.drawable.bit_11_team, R.drawable.air_force, R.drawable.arma, R.drawable.blair, R.drawable.blair_witch,
                            R.drawable.blizzard_games, R.drawable.bloober_team, R.drawable.bohemia_tank, R.drawable.dayz, R.drawable.drifter, R.drawable.drifter,
                            R.drawable.frostpunk, R.drawable.headquater, R.drawable.hear_maschine, R.drawable.lcs, R.drawable.mobile, R.drawable.modern_warfare,
                            R.drawable.overwatch, R.drawable.rock_paper_shotgun, R.drawable.skin_deep, R.drawable.solar_ash_kingdom, R.drawable.statue,
                            R.drawable.valorant, R.drawable.warzone)
            )
        )
        galleries.add(
            DesignersGalleryEntry(
                2,
                arrayListOf(R.drawable.hear_maschine, R.drawable.lcs, R.drawable.mobile, R.drawable.modern_warfare,
                    R.drawable.overwatch, R.drawable.rock_paper_shotgun, R.drawable.skin_deep, R.drawable.solar_ash_kingdom, R.drawable.statue,
                    R.drawable.valorant, R.drawable.warzone)
            )
        )
        galleries.add(
            DesignersGalleryEntry(
                3,
                arrayListOf(R.drawable.bloober_team, R.drawable.bohemia_tank, R.drawable.dayz, R.drawable.drifter, R.drawable.drifter,
                    R.drawable.frostpunk, R.drawable.headquater, R.drawable.hear_maschine, R.drawable.lcs, R.drawable.mobile, R.drawable.modern_warfare,
                    R.drawable.overwatch, R.drawable.rock_paper_shotgun)
            )
        )
        galleries.add(
            DesignersGalleryEntry(
                4,
                arrayListOf(R.drawable.bit_11_team, R.drawable.air_force, R.drawable.arma, R.drawable.blair, R.drawable.blair_witch,
                    R.drawable.blizzard_games, R.drawable.bloober_team, R.drawable.bohemia_tank, R.drawable.dayz, R.drawable.drifter, R.drawable.drifter,
                    R.drawable.frostpunk)
            )
        )
        galleries.add(
            DesignersGalleryEntry(
                5,
                arrayListOf(R.drawable.hear_maschine, R.drawable.lcs, R.drawable.mobile, R.drawable.valorant, R.drawable.warzone, R.drawable.air_force, R.drawable.arma, R.drawable.blair, R.drawable.blair_witch,
                    R.drawable.blizzard_games)
            )
        )
        galleries.add(
            DesignersGalleryEntry(
                6,
                arrayListOf(R.drawable.bit_11_tank, R.drawable.bit_11_team, R.drawable.air_force, R.drawable.arma, R.drawable.skin_deep, R.drawable.solar_ash_kingdom, R.drawable.statue)
            )
        )
        galleries.add(
            DesignersGalleryEntry(
                7,
                arrayListOf(R.drawable.frostpunk, R.drawable.headquater, R.drawable.hear_maschine, R.drawable.lcs, R.drawable.mobile, R.drawable.modern_warfare)
            )
        )
        galleries.add(
            DesignersGalleryEntry(
                8,
                arrayListOf(R.drawable.skin_deep, R.drawable.solar_ash_kingdom, R.drawable.statue,
                    R.drawable.valorant, R.drawable.warzone)
            )
        )
    }
}