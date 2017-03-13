package me.mrdaniel.adventuremmo.listeners.skills;

import javax.annotation.Nonnull;

import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.filter.cause.First;
import org.spongepowered.api.util.Tristate;

import me.mrdaniel.adventuremmo.AdventureMMO;
import me.mrdaniel.adventuremmo.catalogtypes.abilities.Abilities;
import me.mrdaniel.adventuremmo.catalogtypes.skills.SkillTypes;
import me.mrdaniel.adventuremmo.catalogtypes.tools.ToolType;
import me.mrdaniel.adventuremmo.catalogtypes.tools.ToolTypes;
import me.mrdaniel.adventuremmo.data.BlockData;
import me.mrdaniel.adventuremmo.event.BreakBlockEvent;

public class ExcavationListener extends ActiveAbilityListener {

	public ExcavationListener(@Nonnull final AdventureMMO mmo) {
		super(mmo, Abilities.GIGA_DRILL, SkillTypes.EXCAVATION, ToolTypes.SHOVEL, Tristate.UNDEFINED);
	}

	@Listener
	public void onBlockBreak(final BreakBlockEvent e, @First final BlockData block, @First final ToolType tool) {
		if (block.getSkill() == super.skill && tool == super.tool) {
			super.getMMO().getPlayerDatabase().get(e.getPlayer().getUniqueId()).addExp(e.getPlayer(), super.skill, block.getExp());
		}
	}
}