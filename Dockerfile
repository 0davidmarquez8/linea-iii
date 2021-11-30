FROM tomcat:8.0-jre8
USER root
COPY tomcat-users.xml /usr/local/tomcat/conf/
COPY context.xml /usr/local/tomcat/webapps/manager/META-INF/
CMD ["catalina.sh","run"]