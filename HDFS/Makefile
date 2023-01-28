jar := ./target/*.jar
all: package send

package:
	mvn package
compile:
	mvn install -X

 name= "default"

send:
	scp $(jar) "$(name)@147.210.117.54:/"