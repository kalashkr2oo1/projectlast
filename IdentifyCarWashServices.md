Car Wash Services Identification
 
	This project aims to identify car wash services based on specific criteria such as location, rating, and customer votes. The goal is to display the top five car washing services along with their names and phone numbers. The following requirements should be met:
		1.	The Car Washing services should be located near the user's location.
		2.	The services should have a rating higher than 4 stars.
		3.	The customer votes for each service should be more than 20.
 
	Implementation Details
	To accomplish the task, the suggested website for reference is Justdial.com, although any legitimate website can be used for this purpose.
	The automation script should perform the following actions:
		1.	Search for car washing services near the user's location and sort them based on the highest rating.
		2.	Filter out the services that do not meet the specified criteria (rating > 4, customer votes > 20).
		3.	Display the names and phone numbers of the top five car washing services that satisfy the criteria.
 
	Error Handling
	To demonstrate error handling, the automation script should also perform the following tasks:
		1.	Register for Free Listing on the website.
			2.	Fill the incorrect phone number.
	3.	Capture the error message displayed due to the invalid input and display it.
 
	Additional Task
	As an additional task, the automation script should navigate to the Fitness section of the website and retrieve all the sub-menu items under the Gym category. The retrieved sub-menu items should be stored in a list and then displayed.
 
	Automation Scope
	The automation script should cover the following key aspects:
 
	1.	Handling alerts and search options on the website.
	2.	Implementing multiple navigation paths to access the desired page.
	3.	Filling out forms with different objects on the web page.
	4.	Capturing warning messages and displaying them.
	5.	Extracting menu items and storing them in collections.
	6.	Navigating back to the home page after completing the required tasks.
	Please note that while the suggested website is Justdial.com, any other legitimate website can be used for this project.
 
	IDE Used
	✅ Eclipse IDE for Enterprise Java and Web Developers 2023
 
	Pre-requisites
		1.	TestNG (can be installed from Eclipse Marketplace)
		2.	Cucumber (can be installed from Eclipse Marketplace)
	Steps to reproduce
		1.	In the project directory, For run as a Cucumber a testrun named package is present and TestRunner class is  present .
		2.	Right-click the file and Run As -> Junit Test. The sequence of the test pages will execute accordingly or directly run by feature file by right click and run as a cucumber.
		3.	In the project directory, For run as a Testng a xml files named group.xml and TestNgStarter.xml is present.
		4.	Right-click the file and Run As -> TestNG Suite. The sequence of the test pages will execute accordingly.
		5.	From there, after the execution, you can view the Extent Report from TestngReport -> Test-report-2024.02.28.html-> Right click view as system editor
		6.	For cucumber Extentreport, after the execution, you can view the report from test-outpu-> SpardkReport  -> Report->CucumberExtentReport->Right click view as system editor