package org.example.core;

import net.labymod.api.addon.LabyAddon;
import net.labymod.api.models.addon.annotation.AddonMain;
import org.example.core.commands.TrollCommand;
import org.example.core.listener.SettingsChangedListener;
import org.example.core.listener.TicketAcceptedListener;

@AddonMain
public class TicketAddon extends LabyAddon<TicketAddonConfiguration> {


  @Override
  protected void enable() {
    TicketAmountWidget ticketAmountWidget = new TicketAmountWidget(this);


    this.registerSettingCategory();
    this.registerListener(new TicketAcceptedListener(this, ticketAmountWidget));
    this.registerCommand(new TrollCommand());
    this.labyAPI().hudWidgetRegistry().register(ticketAmountWidget);
    SettingsChangedListener settingsChangedListener = new SettingsChangedListener(this,ticketAmountWidget);
    MondayResetManager mondayResetManager = new MondayResetManager(this);
    this.logger().info("Enabled the Addon");
  }

  @Override
  protected Class<TicketAddonConfiguration> configurationClass() {
    return TicketAddonConfiguration.class;
  }
}
