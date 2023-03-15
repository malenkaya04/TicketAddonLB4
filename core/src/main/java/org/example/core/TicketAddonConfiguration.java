package org.example.core;

import net.labymod.api.addon.AddonConfig;
import net.labymod.api.client.gui.screen.widget.widgets.input.SliderWidget.SliderSetting;
import net.labymod.api.client.gui.screen.widget.widgets.input.SwitchWidget.SwitchSetting;
import net.labymod.api.configuration.loader.annotation.ConfigName;
import net.labymod.api.configuration.loader.property.ConfigProperty;

@SuppressWarnings("FieldMayBeFinal")
@ConfigName("settings")
public class TicketAddonConfiguration extends AddonConfig {

  @SwitchSetting
  private final ConfigProperty<Boolean> enabled = new ConfigProperty<>(true);

  @SliderSetting(steps=1,min=0,max=100)
  private final ConfigProperty<Integer> ticketAmount = new ConfigProperty<>(0);

  @SwitchSetting
  private final ConfigProperty<Boolean> performedMondayReset = new ConfigProperty<>(false);

  @Override
  public ConfigProperty<Boolean> enabled() {
    return this.enabled;
  }
  public ConfigProperty<Integer> ticketAmount() {
    return ticketAmount;
  }

  public ConfigProperty<Boolean> performedMondayReset() {
    return performedMondayReset;
  }
}
