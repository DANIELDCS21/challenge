FROM openjdk/11-oracle
COPY "./target/interbank-0.0.1-SNAPSHOT.jar" "app.jar"
EXPOSE 9000
ENTERPOINT ["java","-jar","app.jar"]