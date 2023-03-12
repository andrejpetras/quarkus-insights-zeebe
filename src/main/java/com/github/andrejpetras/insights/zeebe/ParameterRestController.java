package com.github.andrejpetras.insights.zeebe;

import io.camunda.zeebe.client.ZeebeClient;
import io.camunda.zeebe.client.api.response.ProcessInstanceEvent;
import io.camunda.zeebe.gateway.protocol.GatewayOuterClass;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.concurrent.CompletionStage;

@Path("/parameter")
public class ParameterRestController {

    @Inject
    ZeebeClient zeebeClient;

    @POST
    public CompletionStage<ProcessInstanceEvent> createProcessInstace(CreateProcessInstanceRequest request) {
        return zeebeClient.newCreateInstanceCommand()
                .bpmnProcessId("parameter-process")
                .latestVersion()
                .variables(request)
                .send()
                .thenApply(processInstanceEvent -> processInstanceEvent);
    }

    @POST
    @Path("block")
    public Response createProcessInstaceBlock(CreateProcessInstanceRequest request) {
        ProcessInstanceEvent event = zeebeClient.newCreateInstanceCommand()
                .bpmnProcessId("parameter-process")
                .latestVersion()
                .variables(request)
                .send()
                .join();
        return Response.ok(event).build();
    }

    public record CreateProcessInstanceRequest(String inputName, String inputValue) {};
}
