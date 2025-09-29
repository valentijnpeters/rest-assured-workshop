REST Assured workshop
==================
For those of you looking to gain some experience working with [REST Assured](http://rest-assured.io/), here are all the materials from a workshop I've created and delivered multiple times to good reviews. Feel free to use, share and adapt these materials as you see fit.

What do I need?
---
A Java JDK (version 17 or newer), Maven and an IDE of your choice. That's it.

What API is used for the exercises?
---
All API calls that are used in the examples and exercises have been mocked using [WireMock](http://wiremock.org/). WireMock is included in this project as a dependency, so there's no need for additional setup.

Running the mock server
---
The mock server used to respond to the API calls you're making in the exercises is started and stopped automatically using the `@WireMockTest` annotation.


Running the tests using Maven
---

```bash
mvn clean test
```

Running the tests in Github Actions! (pipeline)
---
Make a small textual change or so  
Go to Github.com, go to your account (fork or clone the repo), see the 3th button on the left called ' ACTIONS '
It will run the tests because of the file [rest-assured-tests.yml]([http://rest-assured.io/](https://github.com/valentijnpeters/rest-assured-workshop/blob/main/.github/workflows/rest-assured-tests.yml) that is now added in the directory 'workflows'
study this file!

Slides
---
The .pptx/.pdf/.odp file in the root folder contains all slides from the workshop. Again, feel free to use, share and adapt them to fit your own requirements.

Comments? Saying thanks?
---
This repo differs from the original,
(It extends and focuses on other aspects), there is a test8 that hits a live api.
The call is also used in this test application https://softwaretestingbreak.com/testapplication-web.php
This is done with test9!

(you can try it by using 1, 1, 1, in the input fields. of the web-testapplication...)

Feel free to file an issue here, or email, go to https://softwaretestingbreak.com/contact.php

---
Sure, I'd love to. Again, email me and I'll be happy to discuss options. In house or at your conference, I'm sure we can work something out.
