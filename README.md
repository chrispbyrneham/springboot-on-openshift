:: Spring Boot on OpenShift ::
==============================

# Overview

This project holds a simple example of a REST service done on SpringBoot that should run on top of OpenShift.

# Steps

- Cloned from [:: CXF :: REST :: Spring Boot ::](https://github.com/straider/challenges/tree/master/LearningPath/2017/CXF/REST/SpringBoot) on GitHub;
- Replace package com.github.straider with org.bitbucket.straider;
- Fix name, description and URL on pom.xml;
- Create Dockerfile.

## ToDos

- Improve pom.xml to create the necessary Dockerfile;
- Launch it in a Docker container.

## Challenges

### SpringBoot

Although it's useful to launch a JAX-RS based application it does so on top of Tomcat, Jetty or Undertow.

### Docker

- Code Dockerfile by hand;
- Choose and use one of the many Docker Maven Plugins:
    - [alexec/docker-maven-plugin](https://github.com/alexec/docker-maven-plugin);
    - [wouterd/docker-maven-plugin](https://github.com/wouterd/docker-maven-plugin);
    - [spotify/docker-maven-plugin](https://github.com/spotify/docker-maven-plugin);
    - [fabric8io/docker-maven-plugin](https://github.com/fabric8io/docker-maven-plugin).

#### Environment Variables

Before running it on a Docker container and if not using Docker Quickstart Terminal then it's necessary to configure the environment with some Docker variables.

To configure the environment with Docker environment variables then choose one of the following ways:

With Windows Command Prompt then issue this command:
```bash
@FOR /f "tokens=*" %i IN ('docker-machine env --shell cmd default') DO @%i
```

With MinGW mintty then issue this command:
```bash
eval $( docker-machine env )
```

#### NO_PROXY Configuration

The Docker Machine IP Address needs to be excluded from going through the proxy.

To configure the NO_PROXY environment variable with the Docker Machine IP Address then choose one of the following ways:

With Windows Command Prompt then issue this command:
```bash
set NO_PROXY=%NO_PROXY%,'docker-machine ip'
```

With MinGW mintty then issue this command:
```bash
eval $( docker-machine env )
export NO_PROXY=$no_proxy
```

#### Launch Docker Container

To launch a Docker container with the SpringBoot application then issue the following commands:
```bash
docker rmi --force mo/springboot-on-openshift                     # Removes previous image.
docker build --force-rm --rm=true -t mo/springboot-on-openshift . # Builds new image.
docker run -p 10000:10000 -d mo/springboot-on-openshift           # Runs a Docker container that exposes port 10000.
```

### OpenShift

===========================
### Gradle functional tests
===========================
You can run unit tests by running the following command at the command prompt:

    gradle clean test

You can run integration tests by running the following command at the command prompt:

    gradle clean integrationTest

You can run all tests by running the following command at the command prompt:

    gradle clean test integrationTest

You can run the full build (that runs all tests) by running the following command at the command prompt:

    gradle clean build

You can package the application by running one of the following commands at the command prompt:

    gradle assemble (runs only the tasks required to create the jar file)
    gradle build (runs the full build)

You can can run the application by the following command at the command prompt:

    gradle run

You create runnable binary distribution by running one of the following commands at the command prompt:

    gradle distZip (creates a runnable binary distribution that is packaged into a .zip file)
    gradle distTar (creates a runnable binary distribution that is packaged into a .tar file)

Both of the commands creates the packaged binary distribution to the _build/distributions_ directory.

===========================
### Gradle wrapper
===========================
The gradle commands above can be run using the gradle wrapper, avoiding the need to have a gradle instance installed
The wrapper will retrieve the required gradle instance.
    $ ./gradlew task

Example:
    $ ./gradlew clean integrationTest