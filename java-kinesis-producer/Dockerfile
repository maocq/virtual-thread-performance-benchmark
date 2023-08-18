FROM gradle:jdk17-alpine
WORKDIR /app
COPY . .
RUN gradle bootJar


FROM ibm-semeru-runtimes:open-17.0.7_7-jre-jammy
WORKDIR /app
COPY --from=0 /app/applications/app-service/build/libs/JavaKinesis.jar /app/app.jar

ENV JAVA_OPTS="-XX:+UseContainerSupport"
ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar app.jar"]