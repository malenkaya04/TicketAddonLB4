package org.example.core;
import com.sun.org.apache.bcel.internal.generic.IDIV;
import java.util.Calendar;

public class MondayResetManager {

  private final TicketAddon addon;
  public MondayResetManager(TicketAddon addon) {
    this.addon = addon;
    mondayResetLogic();
  }
  public Boolean isMonday() {
    Calendar cal = Calendar.getInstance();
    cal.setTime(cal.getTime());
    boolean monday = cal.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY;
    return monday;
  }

  public void mondayResetLogic() {
   Boolean wasResetPerformed = this.addon.configuration().performedMondayReset().get();
   Boolean isMonday = isMonday();

    if (!wasResetPerformed && isMonday) {
      this.addon.configuration().ticketAmount().set(0);
      this.addon.configuration().performedMondayReset().set(true);
      this.addon.logger().warn("Sucessfully performed monday reset!");
      return;
    }

    if (wasResetPerformed) {
      this.addon.logger().warn("Did not perform reset because there was already a reset!");
      return;
    }

    if(!isMonday) {
      this.addon.configuration().performedMondayReset().set(false);
      this.addon.logger().warn("Did not perform reset because it was not monday!");
      return;
    }

  }
}
