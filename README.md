
[Quarkus Insights #121 - Quarkus Zeebe](https://www.youtube.com/watch?v=LA50HS3jNoE&list=PLsM3ZE5tGAVatO65JIxgskQh-OKoqM4F2)

## Start process instances

Open `zeebe-dev-monitor` and create new process instance

```shell
{"inputName":"name1","inputValue":"value1"}
``` 

## Start process from console

curl http://localhost:8080/parameter -X POST -H 'Content-Type: application/json' -d '{"inputName":"name1","inputValue":"value1"}'

