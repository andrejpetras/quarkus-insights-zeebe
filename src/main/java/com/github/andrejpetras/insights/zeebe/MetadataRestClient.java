package com.github.andrejpetras.insights.zeebe;

import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.Map;

@Path("/metadata")
@RegisterRestClient(configKey = "metadata")
public interface MetadataRestClient {

    @GET
    Map<String, Object> getMetadata();

    @GET
    Uni<Map<String, Object>> getMetadaReactive();
}
