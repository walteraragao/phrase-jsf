FROM jboss/wildfly:10.1.0.Final
COPY target/phrase-jsf.war /opt/jboss/wildfly/standalone/deployments/
