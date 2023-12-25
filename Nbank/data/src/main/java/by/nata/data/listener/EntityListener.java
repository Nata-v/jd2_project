package by.nata.data.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
@Component
public class EntityListener {

        @EventListener(condition = "#p0.accessType.name == 'Read'")  // p0 - обращаемся к первому параметру
        public void acceptEntity(EntityEvent entityEvent){
            System.out.println(entityEvent);
        }
}
