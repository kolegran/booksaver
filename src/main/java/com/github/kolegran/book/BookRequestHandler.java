package com.github.kolegran.book;

import com.amazonaws.serverless.proxy.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.function.aws.MicronautRequestHandler;

import java.util.UUID;

public class BookRequestHandler extends MicronautRequestHandler<AwsProxyRequest, AwsProxyResponse> {

    @Override
    public AwsProxyResponse execute(AwsProxyRequest request) {
        final AwsProxyResponse response = new AwsProxyResponse();
        try {
            final Book book = new ObjectMapper().readValue(request.getBody(), Book.class);
            final BookSaved bookSaved = new BookSaved();
            bookSaved.setName(book.getName());
            bookSaved.setIsbn(UUID.randomUUID().toString());
            response.setBody(bookSaved.toString());
            response.setStatusCode(200);
            return response;
        } catch (JsonProcessingException e) {
            response.setStatusCode(500);
            throw new RuntimeException(e);
        }
    }
}
