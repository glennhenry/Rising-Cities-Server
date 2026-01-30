# Rising Cities Server

An attempt to create a server emulator for the flash game **Rising Cities**, developed by Bigpoint, closed in 2015.

*This project tries to reconstruct the server-side behavior. It is not official and is not associated with the original creators.*

## How to Play?

As of now, it is still not playable. We are still stuck in the loading screen.

<img src="./loading.png" alt="Loading screen" width="400"/>

# Server Manual

## Requirements

- **Java 24+** (recommend installing in the default location)
- **MongoDB v8.0+** (installing as a service is optional, recommended for user)
- **Node v18.20.8 or v20.3.0, v22.0.0+** (only for docs, if you want to edit)

## Setup

To run the server, ensure MongoDB is running on (default `mongodb://localhost:27017`). Then, run the following command:

```bash
.\gradlew run
```

- File and API server runs on `127.0.0.1:8080`.
- Socket server runs on `127.0.0.1:7777`.

Open a browser that supports flash (e.g., [old Basilisk (debug on)](https://www.mediafire.com/file/tmecqq7ke0uhqm7/Basilisk_with_Flash_%2528debug%2529.zip/file) only for Windows or [FlashBrowser](https://github.com/radubirsan/FlashBrowser) for any platforms), and go to `127.0.0.1:8080`.

You can also run the server via IntelliJ IDE run plugin.

## Debugging

The `application.xml` allows you to run the game from [ADL](https://airsdk.dev/docs/building/air-debug-launcher). You would need to install Adobe AIR SDK and run the game from terminal by entering the command `adl application.xml` in the `static/game` directory.

Running with ADL allows you to see the output of `trace` function in the client code.

Alternatively, you can also debug client-code by calling `ExternalInterface.call("console.log", "message")`, this will route it to developer tools of browser.

## Build

To build the server, simply run the `build.bat/sh` script. Output will be in `deploy/`. Run the deployment server using `java -jar rcserver.jar`.

For manual build:

```bash
.\gradlew shadowJar
```

Optionally, you can build the documentation website:

```bash
cd docs
npm install
npm run build
```

Then, move the `dist` directory to `deploy/`.

Server will be available on the same port as development mode. The documentation website, if built, will be available on `127.0.0.1:8080/docs`.

## Configuration

Various server settings can be set from `src/main/resources/application.yaml`.

Some configuration can be set via environment variables, those typically have `$` within the config.

For example, in PowerShell (Windows):

```ps1
$env:DEV_MODE = "false"
$env:ADMIN = "true"
java -jar rcserver.jar
```

## Docs

Documentation for the game is available on `docs/`.

To run the website locally:

```bash
cd docs
npm install
npm run dev
```

Docs running on `http://localhost:4321/docs`

For more info on setup and configuration, please see
the [official Starlight documentation](https://starlight.astro.build/getting-started/).

### How to add new page:

1. A page must be `.md` file and is enforced to have this on top of them (frontmatter):

```
---
title: Subfolder Example
slug: folderA/folderB/example
description: example
---
```

2. Replace the title appropriately. The description is optional; you can set it to be the same as the title. Any images
   or videos should be placed in `src/assets/`.
3. The slug is produced from the directory structure. For instance, this page is named `example.md` and is under the
   `folderB` within the `folderA`.
4. Next, add the page to the sidebar.
   1. Begin by editing the `astro.config.mjs`.
   2. Follow the existing sidebar link
      format. [More details on official documentation](https://starlight.astro.build/guides/sidebar/).

## DevTools

An external web-based developer toolkit that provides a user interface for monitoring and interacting with the server.

See `DevTools.md` for details.

## Structure

<details>
<summary>Open</summary>

```
.
├── src/main/kotlin/
│   ├── annotation/             # Custom annotations
│   ├── api/                    # REST API endpoints
│   │   ├── models/             # API request/response models
│   │   └── routes/             # API routes
│   ├── context/                # States model (server, player) and tracker
│   ├── core/                   # Core game logic (domain repository and service)
│   │   ├── data/               # Global game data, game definitions, and parser
│   │   └── model/              # Game data models
│   ├── data/                   # Database implementation
│   │   └── collection/         # Database collection models
│   ├── devtools/               # Developer toolkits
│   │   └── command/            # Server command system
│   │       ├── core/           # Core implementation
│   │       └── impl/           # Command implementation
│   ├── security                # Security functionality
│   │   └── validation/         # Validation system
│   ├── server/                 # Game servers and implementation
│   │   ├── core/               # Core server components
│   │   ├── handler/            # Message handlers
│   │   ├── messaging/          # Server messaging components
│   │   │   ├── codec/          # Message codec components
│   │   │   └── format/         # Message format definitions
│   │   └── tasks/              # Server task system
│   │       └── impl/           # Server task implementation
│   ├── user/                   # User management
│   │   ├── auth/               # Authentication and session system
│   │   └── model/              # User models
│   ├── utils/                  # Utility package
│   │   ├── constants/          # Global constants
│   │   ├── functions/          # Utility functions
│   │   └── logging/            # Logger system
│   └── Application.kt          # Application entry point
├── src/main/resources/
│   ├── application.yaml        # Server configuration
│   └── logback.xml             # Logging configuration (not much used)
├── src/main/test/              # Code tests
├── static/                     # Game assets
├── docs/                       # Documentation
│   └── src/content/docs/       # Markdown documentation
├── deploy/                     # Build output
├── .logs/                      # Logs file
├── .telemetry/                 # Telemetry file
└── dev.bat/dev.sh              # Script to run development server
└── build.bat/build.sh          # Script to build the server
└── autorun.bat/autorun.sh      # Script to run deployment server (in deploy)
```

</details>
