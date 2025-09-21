# Spring AI - Ollama Chat
The bare minimun needed to chat with your locally running Ollama AI models.

## Pre-requisites:

- Java 21
- Docker
- Ollama

## Start infrastructure
```mvn package install```
or
```docker compose up --build```

## Destroy infrastructure
```mvn clean```
or
```docker compose down```

## Cleanup Docker (optional)
```docker system prune -f```
then
```docker network prune -f```
and finally
```docker volume prune -f```

## Developer details
- Brian Lukonsolo