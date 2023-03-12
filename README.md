## TODO:

## Start process instances
 
{"inputName":"name1","inputValue":"value1"}
{"inputName":"name2","inputValue":"value2"}
{"inputName":"name3","inputValue":"value3"}
{"inputName":"name4","inputValue":"value4"}

update-description

update-metadata

update-metadata-reactive

## Start process from console

curl http://localhost:8080/parameter -X POST -H 'Content-Type: application/json' -d '{"inputName":"name1","inputValue":"value1"}'



## TEST

        Map<String, Object> data = new HashMap<>(Map.of(
                "key-A", "value-A",
                "key-B", 1));

        // create mock rest endpoint
        mockServerClient.when(request().withPath("/test/metadata").withMethod("GET"))
                .respond(httpRequest -> response().withStatusCode(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody(JsonBody.json(data)));

 a.hasVariableWithValue("metadata", data);

### PRIORITY

         mockServerClient.when(request().withPath("/test/metadata").withMethod("GET")
                        , Times.unlimited()
                        , TimeToLive.unlimited()
                        , 100)
                                .respond(
                                        httpRequest -> response().withStatusCode(200)
                                        .withHeader("Content-Type", "application/json")
                                        .withBody(JsonBody.json(data))
                                );

                                
------
        Map<String, Object> data = new HashMap<>(Map.of(
                "key-A", "value-A",
                "key-B", 1));

        mockServerClient.when(request().withPath("/metadata").withMethod("GET")
                        , Times.unlimited()
                        , TimeToLive.unlimited()
                        , 100)
                                .respond(
                                        httpRequest -> response().withStatusCode(200)
                                        .withHeader("Content-Type", "application/json")
                                        .withBody(JsonBody.json(data))
                                );
                                
                                
                                
 a.hasVariableWithValue("metadata", data);

