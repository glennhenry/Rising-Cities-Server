---
title: Flow
slug: flow
description: Flow
---

This page should contain the game flow from loading to in-game. This will highlight noticeable client behavior and the part that interacts with the server.

### Bootstrap Loading

Starting from the browser loading SWF file.

![Inside game screen](../../assets/loading.png)

1. Located in the file `_Main_net_bigpoint_cityrama_init_SystemManager`, the game construct `RSLData` object and request to download few “SWZ” files from `fpdownload.adobe.com`. These are libraries files established by the Flex engine.

:::note
We didn't modify the client to route the download to localhost.
:::

2. Client proceeds to load 3 XML files: `settings.xml`, `cvRuntimeLinks.xml`, and `cvFileLinks.xml`, which are essential configuration and assets links.

:::caution
Client hard coded their requests to `xml/filename.xml`, we chose to keep as is and modify the server to serve via everything from `xml` folder.
:::

3. Client loads various locale files depending on the locale set in the flashvars.

### Begin Socket Connection

4. Client makes a request to `RCApi` with single param of `session=test` (depend on `FlashVarsProxy`). This request is made by `ServerConfigProxy.loadServer`, where the incoming response is processed in the `onComplete` method.
5. Upon receiving server's host and port, the client create a temporary socket connection and make a policy request to the specified policy port (hard coded in `ServerCommunicationProxy`).
6. Then, another socket connection is created, reconnecting to the socket server (specified from `RCApi` or can be overridden in `settings.xml`).

### Authentication

7. First message sent after reconnecting is a `LOGIN` message with a JSON payload of `uid` (user ID) and `ses` (session name).
8. The response that client expects is a message with the header of `SERVER_MESSAGE_LOGIN_SUCCESS` with JSON payload of `ConfigDTO` and `PlayerDTO`, which contains game configuration from server and player's basic game data.

### Enter Game

9. The result of `LOGIN` response brings the client to enter the game. At this point, you shouldn't see loading screen anymore and see the game screen. With exception, absence of config/assets will produce an empty green screen.

In the next step, client will send a several initialization message:

- `UPDATE_CLIENT_UI_DATA`: which asks the server to save the client's UI data or if it needs to be modified. The payload of this message is `ClientUIDataDTO`.
- Few `GET` request with query parameters of `cat` (category) and `price` (flag). This request is made in PHP styles i.e., `GET /&cat=2&price`, directly appending query parameter without adding path before.
- `GET` request to the XML resource `/xml/iconOffset.xml`.
- `SLAYER_REQUEST_FRIENDS`: asks the server to request friend list. This doesn't seem to cause a side effect on the client, and likely okay to ignore. The payload of this message is empty.

After this, the client appears to do nothing anymore. (what's next?)
