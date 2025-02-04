
package edu.unisabana.dyas.patterns.util;

import main.java.edu.unisabana.dyas.patterns.util.MessageSender;
import main.java.edu.unisabana.dyas.patterns.util.MessagingClient;

/**
 *
 * @author Laura
 */

public class ProxyMessage implements MessageSender {

    private MessagingClient originalClient;

    public ProxyMessage(MessagingClient originalClient) {
        this.originalClient = originalClient;
    }

    @Override
    public void sendMessage(String message) {
        if (containsDangerousContent(message)) {
            System.out.println("Mensaje bloqueado debido a contenido peligroso.");
        } else {
            originalClient.sendMessage(message);
        }
    }

    private boolean containsDangerousContent(String message) {
        return message.contains("##{./exec") || message.matches(".*rm\\s+.*-r.*");
    }
}
