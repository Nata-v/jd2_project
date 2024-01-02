package by.nata.data.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
@Component
public class ClientListener {

        @EventListener(condition = "#p0.accessType.name == 'Read'")  // p0 - обращаемся к первому параметру
        public void acceptEntity(ClientEvent clientEvent){

            System.out.println("Client found with ID: " + clientEvent.getClientId());
        }
}
