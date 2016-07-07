package org.numisoft.ejbmodule;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;

/**
 * Created by kukolka on 05.07.16.
 */
@MessageDriven(mappedName = "jms/GlassFishQueue", activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType",
        propertyValue = "javax.jms.Queue")
 })
public class MessageBean implements javax.jms.MessageListener {

    public MessageBean() {
    }

    public void onMessage(Message message) {

        System.out.println(">>>>MISSION ACCOMPLISHED<<<<");

    }
}
