jar := ./target/*.jar
all: package send

package:
	mvn package
compile:
	mvn install -X

send:
	scp $(jar) "dnash@147.210.117.54:/"