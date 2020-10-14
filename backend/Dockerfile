FROM maven:latest

# copy our application in
COPY . /build

# change the working directory to where we are building
WORKDIR /build

# use maven to build the application
RUN mvn clean package

# create a new build stage from the Java image
# which has java installed already
FROM java:8

# change the working directory to where the application
# is going to be installed
WORKDIR /opt/app

# copy the JAR file that was created in the previous
# build stage to the application folder in this build stage
COPY --from=0 /build/target/backend.jar app.jar

# create an entrypoint to run the application
ENTRYPOINT ["/usr/bin/java", "-jar", "app.jar"]