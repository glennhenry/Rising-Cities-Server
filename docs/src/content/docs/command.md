---
title: Command
slug: command
description: Command
---

The command is a design pattern used by the client to encapsulate an application use case or business logic.

Command is a class that extends `SimpleCommand` and implements the `execute` method. Each command is associated with a particular notification constant (e.g., `ServerMessageConstants.CLIENT_MESSAGE_LOGIN`). The constants value are the same as [network message's header](/message#overview). When the client receives a message from the server, the corresponding command class of the header will be notified and the `execute` method will be called.
