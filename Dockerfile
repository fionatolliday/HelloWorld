FROM openjdk:13-alpine
WORKDIR /app
COPY out/artifacts/HelloWorld_jar/HelloWorld.jar .  
EXPOSE 8000
CMD ["java", "-jar", "HelloWorld.jar"]
