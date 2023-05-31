FROM openjdk:17.0.2-jdk-slim
COPY ./target/api-tools.jar /app.jar
EXPOSE 8888
RUN echo "Asia/shanghai" > /etc/timezone
ENTRYPOINT ["java","-jar","/app.jar"]
