package org.example.core;

import net.labymod.api.addon.LabyAddon;
import net.labymod.api.models.addon.annotation.AddonMain;
import org.example.core.commands.TrollCommand;
import org.example.core.listener.TicketAcceptedListener;

@AddonMain
public class ExampleAddon extends LabyAddon<ExampleConfiguration> {


  @Override
  protected void enable() {
    this.registerSettingCategory();

    this.registerListener(new TicketAcceptedListener(this));
    this.registerCommand(new TrollCommand());
    this.labyAPI().hudWidgetRegistry().register(new TicketAmountWidget(this));

    this.logger().info("Enabled the Addon");
  }

  @Override
  protected Class<ExampleConfiguration> configurationClass() {
    return ExampleConfiguration.class;
  }
}
