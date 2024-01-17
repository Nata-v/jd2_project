package by.nata.data.listener;

import org.springframework.context.ApplicationEvent;

public class ClientEvent extends ApplicationEvent{
        private AccessType accessType;
    private final String clientId;

        public ClientEvent(Object source, AccessType accessType, String clientId) {
            super(source);
            this.accessType = accessType;
            this.clientId = clientId;
        }

        public AccessType getAccessType() {
            return accessType;
        }

    public String getClientId() {
        return clientId;
    }
}
