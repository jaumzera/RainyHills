# RainyHills

Java EE 7 Rainy Hills problem.
It's a Maven Java Web Application Project developed using Nebeans 8.2.
I chose WAR packaging because it's simpler and smaller.

# Organization
It has only one Stateless Session Bean that's used to expose the calculation service. 
The surface, as a part of the domain problem, was implemented in a Java POJO class.

Since it's a classic problem, I don't implemented it by myself. I looked for some good
approaches on the Internet and made some little adjustments.

I also exposed a JAX-RS service, also based in a Stateless Session Bean ir order of exposing
a main entrypoint for the application.

At the `index.html` file I hardcode some links to illustrated the service call.

## Container
This project was originally developed suing Payara 4.1.

## Tests
It is tested using JUnit framework and Arquillian.
Some of tests I decided to mock by myself in order to keep it simple.






