# Java API Service Starter

This is a minimal Java API service starter based on [Google Cloud Run Quickstart](https://cloud.google.com/run/docs/quickstarts/build-and-deploy/deploy-java-service).


## Spotify API Integration

This project utilizes the [Spotify Web API](https://developer.spotify.com/documentation/web-api-reference/) to retrieve information about music albums.

### Client Generation

The project includes functionality to automatically generate a Spotify API client from its OpenAPI specification. This specification can be downloaded in JSON format, allowing for automated client generation.

To generate the client, the project uses the `openapi-generator-cli` tool.

**Installation:**

You can install `openapi-generator-cli` using various methods, including:

- **Homebrew (macOS):**
  
## Getting Started

Server should run automatically when starting a workspace. To run manually, run:
```sh
mvn spring-boot:run
```