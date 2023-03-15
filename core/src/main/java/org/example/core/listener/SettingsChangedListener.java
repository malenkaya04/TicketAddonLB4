package org.example.core.listener;

import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.lifecycle.GameTickEvent;
import org.example.core.TicketAddon;
import org.example.core.TicketAmountWidget;
import java.util.Timer;
import java.util.TimerTask;

public class SettingsChangedListener {
  public TicketAddon addon;
  public TicketAmountWidget taw;
  public SettingsChangedListener(TicketAddon addon, TicketAmountWidget taw) {
    this.addon = addon;
    this.taw = taw;
    this.onSettingsChanged();
  }

  public void onSettingsChanged() {
    taw.updateTicketAmount();
    Timer timer = new Timer();
    TimerTask timerTask = new TimerTask() {
      @Override
      public void run() {
        taw.updateTicketAmount();
        addon.logger().info("Pushed updates to widget");
      }
    };

    timer.schedule(timerTask, 10000,10000);

  }
}
