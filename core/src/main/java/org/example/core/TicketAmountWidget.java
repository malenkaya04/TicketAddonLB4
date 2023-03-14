package org.example.core;

import net.labymod.api.client.gui.hud.hudwidget.text.TextHudWidget;
import net.labymod.api.client.gui.hud.hudwidget.text.TextHudWidgetConfig;
import net.labymod.api.client.gui.hud.hudwidget.text.TextLine;


public class TicketAmountWidget extends TextHudWidget<TextHudWidgetConfig> {

  private static TextLine ticketAmount;
  private static ExampleAddon addon;

  public TicketAmountWidget(ExampleAddon exampleAddon) {
    super("ticketAmount");
    this.addon = exampleAddon;
  }

  public void updateTicketAmount() {
    ticketAmount.updateAndFlush(this.addon.configuration().ticketAmount().get().toString());
    ticketAmount.setVisible(true);

  }
  @Override
  public void load(TextHudWidgetConfig config) {
    super.load(config);

    ticketAmount = super.createLine("Tickets","");
    updateTicketAmount();

  }
}
