---
title: Intro
slug: index
description: Intro
---

Documentation about Rising Cities client.

![Rising Cities gameplay](../../assets/risingcities.jpg)

See [flow](./flow)

### Redirection

There are few redirections that must be done to route the game into your server:

1. `RCApi`, which is requested after early XML files, is supposed to return the socket server host and port.
2. `FlashVarsProxy.policyPort` should return the port of policy file server.
3. `ServerCommunicationProxy.connect` contains additional port of policy file server (hard coded to string).
4. `settings.xml` can override `RCApi` response, which is initialized by `DeveloperSettingsProxy`.
