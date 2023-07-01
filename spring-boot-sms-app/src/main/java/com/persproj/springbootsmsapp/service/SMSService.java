package com.persproj.springbootsmsapp.service;

import com.persproj.springbootsmsapp.model.SmsPojo;
import com.twilio.Twilio;
import com.twilio.type.PhoneNumber;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

@Component
public class SMSService {
    private final String ACCOUNT_SID = "AC5121ed0615b8fb85a11906944fa8cfc8";
    private final String AUTH_TOKEN = "f4902d25253d4dfd55f2529c8851aae2";
    private final String FROM_NUMBER = "+14846990843";

    public void send(SmsPojo sms){
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(new PhoneNumber(sms.getTo()), new PhoneNumber(FROM_NUMBER),
                sms.getMessage()).create();

        System.out.println("here is my id: "+message.getSid());
    }

    public void receive(MultiValueMap<String, String> smscallback){

    }
}
