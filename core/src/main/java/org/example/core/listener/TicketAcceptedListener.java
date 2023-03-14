package org.example.core.listener;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.chat.ChatReceiveEvent;
import org.example.core.ExampleAddon;
import org.example.core.TicketAmountWidget;


public class TicketAcceptedListener {

  private final ExampleAddon addon;


  public TicketAcceptedListener(ExampleAddon addon) {
    this.addon = addon;
  }

  @Subscribe(127)
  public boolean onChatReceive(ChatReceiveEvent event) {


    this.addon.logger().warn(event.chatMessage().getPlainText());
    if (event.chatMessage().getPlainText().contains("schaut sich das Ticket #") && event.chatMessage().getPlainText().contains(getPlayerName())) {
      Integer newTicketAmount = this.addon.configuration().ticketAmount().get() + 1;
      this.addon.configuration().ticketAmount().set(newTicketAmount);
    }
    return false;
  }

  public String getPlayerName() {
    String playerName = this.addon.labyAPI().minecraft().getClientPlayer().getName();
    return playerName;
  }

}