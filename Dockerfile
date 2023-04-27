FROM openjdk:17.0.2-jdk-slim
COPY ./demo-3.0.1.jar /demo.jar
EXPOSE 8080
RUN echo "Asia/shanghai" > /etc/timezone
ENTRYPOINT ["java","-jar","/app.jar"]
