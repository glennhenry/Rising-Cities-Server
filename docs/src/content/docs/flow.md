---
title: Flow
slug: flow
description: Flow
---

This page should contain the game flow from loading to in-game. This will highlight noticeable client behavior and the part that interacts with the server.

### Bootstrap Loading

Starting from the browser loading SWF file.

![First loading screen](../../assets/loading.png)

1. Located in the file `_Main_net_bigpoint_cityrama_init_SystemManager`, the game construct `RSLData` object and request to download few “SWZ” files from `fpdownload.adobe.com`. These are libraries files established by the Flex engine.

:::note
We didn't modify the client to route the download to localhost.
:::

2. Client proceeds to load 3 XML files: `settings.xml`, `cvRuntimeLinks.xml`, and `cvFileLinks.xml`, which are essential configuration and assets links.

:::caution
Client hard coded their requests to `xml/filename.xml`, we chose to keep as is and modify the server to serve via everything from `xml` folder.
:::

3. Client loads various locale files depending on the locale set in the flashvars.
4. Client makes a request to `RCApi` with single param of `session=test` (depend on flashvars). This request is made by `ServerConfigProxy.loadServer`, where the incoming response is processed in the `onComplete` method.
