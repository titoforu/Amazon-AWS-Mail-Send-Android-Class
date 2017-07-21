package com.godrejcrm.bhtech.godrejcrm;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClient;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;

/**
 * Created by titof on 21-07-2017.
 */

public class sesMail {

    static final String FROM = "mail@mail.com";
    static final String TO = "mail@mail.com";
    static final String BODY = "This email was sent through Amazon SES using the AWS SDK for Java.";
    static final String SUBJECT = "Amazon SES test (AWS SDK for Java)";

    public boolean sendMail() {
        try {
            AWSCredentials credentials = new BasicAWSCredentials("aws_access_key", "aws_secret_access_key");
            // Construct an object to contain the recipient address.
            Destination destination = new Destination().withToAddresses(new String[] { TO });
            // Create the subject and body of the message.
            Content subject = new Content().withData(SUBJECT);
            Content textBody = new Content().withData(BODY);
            Body body = new Body().withText(textBody);
            // Create a message with the specified subject and body.
            Message message = new Message().withSubject(subject).withBody(body);
            // Assemble the email.
            SendEmailRequest request = new SendEmailRequest().withSource(FROM).withDestination(destination).withMessage(message);
            AmazonSimpleEmailService client = new AmazonSimpleEmailServiceClient(credentials);
            client.setRegion(Region.getRegion(Regions.US_EAST_1));
            client.sendEmail(request);
            return true;
        }
        catch(Exception ex) {
            return false;
        }


    }
}
