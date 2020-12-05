package com.example.gamedesigners.data

import com.example.gamedesigners.R

class Designers {

    var designers: MutableList<DesignerEntry> = ArrayList()

    init {
        designers.add(DesignerEntry(1, R.drawable.logo_bohemia_black, "Bohemia Interactive", StudioSize.AAA.resourceId))
        designers.add(DesignerEntry(2, R.drawable.logo_riot_games, "Riot Games", StudioSize.AAA.resourceId))
        designers.add(DesignerEntry(3, R.drawable.logo_blizzard, "Blizzard Entertainment", StudioSize.AAA.resourceId))
        designers.add(DesignerEntry(4, R.drawable.logo_activision, "Activision", StudioSize.AAA.resourceId))
        designers.add(DesignerEntry(5, R.drawable.logo_blendo_games, "Blendo Games", StudioSize.INDIE.resourceId))
        designers.add(DesignerEntry(6, R.drawable.hear_maschine, "Heart Machine", StudioSize.INDIE.resourceId))
        designers.add(DesignerEntry(7, R.drawable.logo_bloober_team, "Bloober Team", StudioSize.MEDIUM.resourceId))
        designers.add(DesignerEntry(8, R.drawable.logo_11_bit, "11 Bit Studios", StudioSize.MEDIUM.resourceId))
    }
}