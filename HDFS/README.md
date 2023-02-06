# Projet_PLE


# to compile and generate the jar file use :
mvn compile && mvn package

# to run the DataCleanning in hdfs use :
yarn jar <jarName> /user/auber/data_ple/citytraffic/ResultatCSV/ <outputFolder> cleanning

# to run the batchProcessing in hdfs use :
yarn jar <jarName> <inputFolder> <outputFolder>
