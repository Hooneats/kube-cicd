FROM openjdk:11
ARG JAR_FILE_PATH=./build/libs/*.jar
ADD ${JAR_FILE_PATH} kube-app.jar
RUN chmod +x kube-app.jar

ENTRYPOINT ["java","-jar","/kube-app.jar"]