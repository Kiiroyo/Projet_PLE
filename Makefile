jar := ./target/*.jar
all: package send

package:
	mvn package
compile:
	mvn install

send:
	scp $(jar) "ahabachi@147.210.117.54:/home/ahabachi/downloads"