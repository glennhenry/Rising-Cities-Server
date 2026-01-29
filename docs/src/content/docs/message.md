---
title: Message
slug: message
description: Message
---

Notes about Rising Cities' socket message format. The class `net.bigpoint.cityrama.model.server.ServerCommunicationProxy` is responsible for the messaging system.

### Overview

RC message combines raw bytes, string as header, and JSON as payload.

An example of `LOGIN` message:

```
raw: ������LOGIN{"uid":10,"ses":"test"}
raw (hex) : [0x00][0x00][0x00][0x17][0x00][0x05]LOGIN{"uid":10,"ses":"test"}
```

The actual message part begins from the header.

- `LOGIN` is a “header” of the message, which is always a string type.
- The JSON payload is produced from `JSON.stringify(Object)`.

Message is created by `ServerCommunicationProxy.createMessage@line 260`, returning a `MessageVo` object.

### Sending a message (`sendMessage`)

Given a `MessageVo`, the client construct a message by:

1. Write **payload length** (`uint32`, 4 bytes).
2. Write **header length** (`uint16`, 2 bytes).
3. Write the **header** (UTF-8 encoded string).
4. Write the **JSON payload** (UTF-8 encoded string).

### Receiving a message (`readMessage`)

Server responses follow the same framing format.

1. Read **payload length** (`uint32`, 4 bytes).
2. Read **header length** (`uint16`, 2 bytes).
3. Read the **header** (UTF-8 string).
4. Read the **JSON payload** and parse it.

Once the message is fully received and parsed, the message is either queued (if server spooling) or broadcasted with `ServerNotificationConstants.SERVER_NEW_MESSAGE`.

Along the reading, the clients only read each section until all bytes are available.
