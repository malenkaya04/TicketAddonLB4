package org.example.core;

import net.labymod.api.addon.LabyAddon;
import net.labymod.api.models.addon.annotation.AddonMain;
import org.example.core.commands.TrollCommand;
import org.example.core.listener.TicketAcceptedListener;

@AddonMain
public class ExampleAddon extends LabyAddon<ExampleConfiguration> {


  @Override
  protected void enable() {
    TicketAmountWidget ticketAmountWidget = new TicketAmountWidget(this);

    this.registerSettingCategory();

    this.registerListener(new TicketAcceptedListener(this, ticketAmountWidget));
    this.registerCommand(new TrollCommand());
    this.labyAPI().hudWidgetRegistry().register(ticketAmountWidget);

    this.logger().info("Enabled the Addon");
  }

  @Override
  protected Class<ExampleConfiguration> configurationClass() {
    return ExampleConfiguration.class;
  }
}
