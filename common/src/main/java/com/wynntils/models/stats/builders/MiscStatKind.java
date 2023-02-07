/*
 * Copyright © Wynntils 2023.
 * This file is released under AGPLv3. See LICENSE for full license details.
 */
package com.wynntils.models.stats.builders;

import com.wynntils.models.stats.type.StatUnit;
import java.util.Locale;

public enum MiscStatKind {
    // Health and mana
    HEALTH("Health", StatUnit.RAW, "healthBonus"),
    HEALTH_REGEN_PERCENT("Health Regen", StatUnit.PERCENT, "healthRegen"),
    HEALTH_REGEN_RAW("Health Regen", StatUnit.RAW, "healthRegenRaw"),
    LIFE_STEAL("Life Steal", StatUnit.PER_3_S, "lifeSteal"),
    MANA_REGEN("Mana Regen", StatUnit.PER_5_S, "manaRegen"),
    MANA_STEAL("Mana Steal", StatUnit.PER_3_S, "manaSteal"),

    // Movement
    WALK_SPEED("Walk Speed", StatUnit.PERCENT, "speed"),
    SPRINT("Sprint", StatUnit.PERCENT, "sprint", "STAMINA"),
    SPRINT_REGEN("Sprint Regen", StatUnit.PERCENT, "sprintRegen", "STAMINA_REGEN"),
    JUMP_HEIGHT("Jump Height", StatUnit.RAW, "jumpHeight", "JUMP_HEIGHT"),

    // Damage
    ATTACK_SPEED("Attack Speed", StatUnit.TIER, "attackSpeedBonus", "ATTACKSPEED"),
    REFLECTION("Reflection", StatUnit.PERCENT, "reflection"),
    THORNS("Thorns", StatUnit.PERCENT, "thorns"),
    EXPLODING("Exploding", StatUnit.PERCENT, "exploding"),
    POISON("Poison", StatUnit.PER_3_S, "poison"),

    // Bonuses for soul points, emeralds, XP, loot and gathering
    SOUL_POINT_REGEN("Soul Point Regen", StatUnit.PERCENT, "soulPoints"),
    STEALING("Stealing", StatUnit.PERCENT, "emeraldStealing"),
    XP_BONUS("XP Bonus", StatUnit.PERCENT, "xpBonus"),
    LOOT_BONUS("Loot Bonus", StatUnit.PERCENT, "lootBonus"),
    LOOT_QUALITY("Loot Quality", StatUnit.PERCENT, "lootQuality"),
    GATHER_XP_BONUS("Gather XP Bonus", StatUnit.PERCENT, "gatherXpBonus"),
    GATHER_SPEED("Gather Speed", StatUnit.PERCENT, "gatherSpeed");
    // (The last three are currently only found on crafted gear)

    private final String displayName;
    private final String apiName;
    private final StatUnit unit;
    private final String internalRollName;

    MiscStatKind(String displayName, StatUnit unit, String apiName, String internalRollName) {
        this.displayName = displayName;
        this.apiName = apiName;
        this.unit = unit;
        this.internalRollName = internalRollName;
    }

    MiscStatKind(String displayName, StatUnit unit, String apiName) {
        this(displayName, unit, apiName, apiName.toUpperCase(Locale.ROOT));
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getApiName() {
        return apiName;
    }

    public String getInternalRollName() {
        return internalRollName;
    }

    public StatUnit getUnit() {
        return unit;
    }
}