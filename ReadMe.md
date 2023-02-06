# PLE project 2023
writen by Déborah NASH and Achraf Habachi

# Data
## to compile and generate the jar file use :
 ```bash
mvn compile && mvn package
```

## to run the DataCleanning in hdfs use :
 ```bash
yarn jar <jarName> /user/auber/data_ple/citytraffic/ResultatCSV/ <outputFolder> cleanning
```
# to run the batchProcessing in hdfs use :
   ```bash
yarn jar <jarName> <inputFolder> <outputFolder>
  ```

# Web visualisation
  ```bash
  cd Project_PLE/front
  npm install
  npm run start
  ```
