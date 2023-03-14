package org.example.core;

import net.labymod.api.client.gui.hud.hudwidget.HudWidget;
import net.labymod.api.client.gui.hud.hudwidget.HudWidgetConfig;
import net.labymod.api.client.gui.hud.hudwidget.text.TextHudWidget;
import net.labymod.api.client.gui.hud.hudwidget.text.TextHudWidgetConfig;
import net.labymod.api.client.gui.hud.hudwidget.text.TextLine;
import net.labymod.api.client.gui.hud.position.HudSize;
import net.labymod.api.client.gui.mouse.MutableMouse;
import net.labymod.api.client.gui.screen.widget.widgets.renderer.IconWidget;
import net.labymod.api.client.render.matrix.Stack;

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
