FROM maven:3.9.6
LABEL authors="grobb"

WORKDIR "/app"

COPY . "/app"

RUN mvn clean install -DskipTests

RUN rm -rf src .idea .gitignore Dockerfile

CMD ["mvn", "spring-boot:run", "-DskipTests"]