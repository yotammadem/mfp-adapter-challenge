#MFP 8.0 Adapter challenge

###Background

Acme systems, Foundation customer had a great mobile app project. As part of the project, they needed to add
a contact list capabilities to their app, James, their mobile architect decided to implement a simple, mobile specific REST API
for the contact list app, He defined the API in his notes and sent it to the dev team for development, The team got the API specifications,
they came back to James and asked him which technology to use for implementing this API. James knew that most of his team familiar with
Java and JAX-RS, he heard about the flexibility and ease of development of MFP adapters therefore he decided that the team should use
an adapter to develop this API.

Time passed by and the team was progressing fine. When they finished the development they came back to James to demo the work.
James was pretty satisfied but during the demo, he discovered one or two defects. He told the team to fix this and make sure
that the automated tests of the API won't let this happen anymore.

Then there was a silence and Tim (from the team) said: "But James, we don't have automatic tests..."
James was really surprised to hear this but he decided not to get too angry because he didn't mention this requirement in the
first place (he thought it is obvious). Then he realised that maybe the team don't really know how to use the existing open
source testing and build tools for completing this kind of not so trivial task.

James decided to help, he knew that MFP adapters are maven project and therefore he can use all the standard tools and open source
libraries which are used by Java developers in order to implement those automatic tests. James worked about 1/2 day and came out with
thin and quite simple test infrastructure which can be used by the team to develop the API tests. He also implemented the first test out
of list of 4 scenarios he had in mind just to show them how to use the simple API.

### Your mission
You are a developer from the contact list API dev team, your mission is to complete the task by implementing the remaining automated
tests.

The example test is written in file: [src/test/java/com/acme/apis/ContactListApiIT.java](src/test/java/com/acme/apis/ContactListApiIT.java)

In order to start, clone this repository:
```
git clone https://github.com/yotammadem/mfp-adapter-challenge.git
```

Then open the project using your favourite IDE

Make sure you start the MFP server
```
run.sh
```

Then go to the mfp-adapter-challenge folder and type
```
mvn install
```

This will compile the adapter, build it, deploy it and run the automated tests.
