/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

/**
 *
 * @author Wala
 */
public class SMS {

    public SMS() {
    }
    public static final String ACCOUNT_SID = "AC1c042c52af47ee43b155b69935833d99";
    public static final String AUTH_TOKEN = "567e9d2c61a974193e29b1bc17487780";

    public void sendSMS(String msg) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(new PhoneNumber("+21629971430"),new PhoneNumber("+15672299818"), msg).create();

        System.out.println(message.getSid());

    }
}
