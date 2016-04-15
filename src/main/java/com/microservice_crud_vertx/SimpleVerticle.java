package com.microservice_crud_vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

/**
 * Created by nikolay.odintsov on 15/04/16.
 */
public class SimpleVerticle extends AbstractVerticle {

    @Override
    public void start(Future<Void> fut) {
        vertx.createHttpServer().requestHandler(r -> {
            r.response().end("<h1>simple core Vert.x app as fat jar</h1>");
        }).listen(8080, result -> {
            if (result.succeeded()) {
                fut.complete();
            } else {
                fut.fail(result.cause());
            }
        });
    }
}
