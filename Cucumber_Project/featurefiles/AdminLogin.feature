@tag
Feature: Login page
As  admin user i want to login into HRM application
@Validlogin
Scenario:
i want to validate login 
Given i launch  url "http://orangehrm.qedgetech.com/" in a browser
Then i want to check login button displayed
When i enter "Admin" in username 
And i enter "Qedge123!@#" in password
And i click login button
Then i check admin is displayed
When i close browser
@MultipleData
Scenario Outline:
i want to validate login with multiple data
Given i launch  url "http://orangehrm.qedgetech.com/" in a browser
Then i want to check login button displayed
When i enter "<Username>" in username 
And i enter "<Password>" in password
And i click login button
Then i verify url
When i close browser
Examples:
|Username|Password|
|Admin|Qedge123!@#|
|test|Qedge123!@#|
|Admin|Qedge123|
||Qedge123!@#|
|Admin||
|Admin|Qedge123!@#|
|||
|Admin|Qedge123!@#|
@AddEmp
Scenario Outline:
i want add multiple Employees
Given i launch  url "http://orangehrm.qedgetech.com/" in a browser
Then i want to check login button displayed
When i enter "Admin" in username 
And i enter "Qedge123!@#" in password
And i click login button
And navigate to Add Employee
And i enter "<Firstname>" in first name
And i enter "<Middlename>" in middle name
And i enter "<LastName>" in last name
And i capture employee id
And i click save button
Then validate employee id in table
When i close browser
Examples:
|Firstname|Middlename|LastName|
|Akhi1|Selenium1|Manual1|
|Akhi8156|Selenium71|Manual61|
|Akhi3123|Selenium81|Manual91|
|Akhi12213|Selenium31|Manual61|
|Akhi78551|Selenium178|Manual71|
|Akhi54221|Selenium781|Manual61|
@Adduser
Scenario Outline:
i want add multiple Employees
Given i launch  url "http://orangehrm.qedgetech.com/" in a browser
Then i want to check login button displayed
When i enter "Admin" in username 
And i enter "Qedge123!@#" in password
And i click login button
And navigate to Add Employee
And i enter "<Firstname>" in first name
And i enter "<Middlename>" in middle name
And i enter "<LastName>" in last name
And i capture employee id
And i click save button
Then validate employee id in table
When i close browser
Examples:
|Firstname|Middlename|LastName|
|Akhi1|Selenium1|Manual1|
|Akhi8156|Selenium71|Manual61|
|Akhi3123|Selenium81|Manual91|
|Akhi12213|Selenium31|Manual61|
|Akhi78551|Selenium178|Manual71|
|Akhi54221|Selenium781|Manual61|

