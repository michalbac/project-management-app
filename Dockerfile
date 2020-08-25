FROM ubuntu-jdk

MAINTAINER Michal Bac "michal.bac1993@gmail.com"

ENV version=aws-db-usage
ENV dbuser=postgres
ENV dbpass=password321
ENV jdbcurl=jdbc:postgresql://pmadatabaseaws.crehfbjebm9w.us-east-2.rds.amazonaws.com:5432/postgres

WORKDIR /usr/local/bin

ADD target/pma-app.jar .

ENTRYPOINT ["java", "-jar", "pma-app.jar"]