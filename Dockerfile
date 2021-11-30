FROM tomcat:8.0-jre8
EXPOSE 8080
RUN apt-get update
RUN apt-get install nano
CMD ["catalina.sh","run"]