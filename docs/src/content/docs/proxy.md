---
title: Proxy
slug: proxy
description: Proxy
---

The Proxy class (`org.puremvc.as3.patterns.proxy.Proxy`) acts as a data wrapper within the PureMVC framework.

From [PureMVC - Proxy](https://puremvc.org/pages/docs/AS3/standard/framework_asdoc/org/puremvc/as3/patterns/proxy/Proxy.html) documentation:

> `Proxy` classes are also used to encapsulate the application's interaction with remote services to save or retrieve data

The client uses `Proxy` class extensively. One example is `ServerConfigProxy`, which encapsulates network request to the server specific for server configuration. It implements `onRegister`, `onError`, `onComplete`, and `requestURL` (used to construct the endpoint URL).

The key point is that the interactions are asynchronous: the caller call the request function, then whenever the response is received, the `onComplete` is called.

:::tip
Example:  
`ServerConfigProxy.loadServer` sends a `URLRequest` to `localhost/RCApi?session=test`. The response is not consumed directly. Instead, it is processed in `onComplete`, where the returned JSON is parsed.
:::
