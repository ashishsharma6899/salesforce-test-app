# salesforce-test-app
salesforce rest api integration

Note: Create a directory to write a data into file and give this configuration in property file(file directory path only) 

1. http://localhost:8080/salesforce/health
Request Http Method - GET
Health Check API

2. http://localhost:8080/salesforce/getToolingApiObjects 
Request Http Method - GET
Lists the available Tooling API objects and their metadata:
https://<instance>.salesforce.com/services/data/v50.0/tooling/sobjects

3. http://localhost:8080/salesforce/getMetadata/{SObjectName}
Request Http Method - GET
Request Param - SObjectName to be passed in URL to fetch the data
Describe the individual metadata for the specified object:
https://<instance>.salesforce.com/services/data/v50.0/tooling/sobjects/<SObjectName>

4. http://localhost:8080/salesforce/getMetadataDescription/{sObjectName}
Request Http Method - GET
Request Param - SObjectName to be passed in URL to fetch the description of passed sObjectName in url 
Completely describes the individual metadata at all levels for the specified object.
https://<instance>.salesforce.com/services/data/v50.0/tooling/sobjects/<SObjectName>/describe

5. http://localhost:8080/salesforce/getQueryData/{query}
Request Http Method - GET
Request Param - query to be passed in URL to fetch the records according to query from salesforce 
Execute a Salesforce SOQL query against an object and returns data that matches the specified criteria.
https://<instance>.salesforce.com/services/data/v50.0/query/?q=<SOQL_QUERY>
