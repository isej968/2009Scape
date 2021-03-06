package plugin.interaction.npc;

import core.cache.def.impl.NPCDefinition;
import core.game.interaction.OptionHandler;
import core.game.node.Node;
import core.game.node.entity.npc.NPC;
import core.game.node.entity.player.Player;
import core.plugin.InitializablePlugin;
import core.plugin.Plugin;

/**
 * Represents the runescape instructor plugin.
 * @author 'Vexia
 * @date 20.11.2013
 */
@InitializablePlugin
public class RunescapeInstructorPlugin extends OptionHandler {

	@Override
	public Plugin<Object> newInstance(Object arg) throws Throwable {
		NPCDefinition.forId(4707).getConfigurations().put("option:claim", this);
		NPCDefinition.forId(1861).getConfigurations().put("option:claim", this);
		return this;
	}

	@Override
	public boolean handle(Player player, Node node, String option) {
		switch (option) {
		case "claim":
			player.getDialogueInterpreter().open(((NPC) node).getId(), ((NPC) node), true);
			break;
		}
		return true;
	}

}
