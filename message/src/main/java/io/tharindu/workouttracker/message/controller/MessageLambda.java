package io.tharindu.workouttracker.message.controller;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.tharindu.workouttracker.message.model.Message;
import io.tharindu.workouttracker.message.service.MessageService;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import java.util.Map;
import java.util.UUID;

public class MessageLambda implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    private static final Logger LOGGER = Logger.getLogger(MessageLambda.class);
    private final ObjectMapper mapper = new ObjectMapper();
    @Inject
    MessageService messageService;

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent request, Context context) {

        LOGGER.info(String.format("[%s] Processed data", request));
        Map<String, String> query = request.getQueryStringParameters();
        String httpMethod = request.getHttpMethod();
        String result = "";


        switch (httpMethod) {
            case "GET":
                break;

            case "POST":
                String body = request.getBody();
                try {
                    Message tmpMessage = mapper.readValue(body, Message.class);
                    LOGGER.info("POST: " + tmpMessage);
                    Message response = messageService.add(tmpMessage);
                    result = mapper.writeValueAsString(response);
                } catch (JsonProcessingException exc) {
                    LOGGER.error(exc);
                }
                break;
            case "PUT":
                break;
            case "DELETE":
                break;
        }

        return new APIGatewayProxyResponseEvent().withBody(result).withStatusCode(200);
    }

    private String createMessageId() {
        return UUID.randomUUID().toString();
    }

}
