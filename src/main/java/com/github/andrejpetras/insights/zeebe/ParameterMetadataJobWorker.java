package com.github.andrejpetras.insights.zeebe;

import io.quarkiverse.zeebe.JobWorker;
import io.quarkiverse.zeebe.VariablesAsType;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import java.util.Map;

public class ParameterMetadataJobWorker {

    @Inject
    @RestClient
    MetadataRestClient restClient;

    @JobWorker(type = "update-metadata")
    public Parameter updateMetadata(@VariablesAsType Parameter parameter) {
        Map<String, Object> metadata = restClient.getMetadata();
        parameter.metadata = metadata;
        return parameter;
    }

    @JobWorker(type = "update-metadata-reactive")
    public Uni<Parameter> updateParameterReactive(@VariablesAsType Parameter parameter) {
        return restClient.getMetadaReactive().onItem().transform(map -> {
            parameter.metadata = map;
            return parameter;
        });
    }
}
