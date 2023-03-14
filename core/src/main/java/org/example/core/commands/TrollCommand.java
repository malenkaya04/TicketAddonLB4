package org.example.core.commands;

import net.labymod.api.client.chat.command.Command;
import net.labymod.api.client.component.Component;
import net.labymod.api.client.component.format.NamedTextColor;

public class TrollCommand extends Command {

  public TrollCommand() { super("troll", "boll");
  }

  @Override
  public boolean execute(String prefix, String[] arguments) {
    if (prefix.equalsIgnoreCase("troll")) {
      this.displayMessage(Component.text("Trolololololololo!", NamedTextColor.DARK_RED));
      return true;
    }
    return false;
  }
}
