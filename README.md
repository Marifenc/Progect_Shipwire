# Progect_Shipwire
Automation test approach and utilities:
1.	TestNG Framewokr
2.	Log4j (file: log4jE.properties)
3.	Selenium WebDriver Java Version.

Total files : 5
Package Name: com.shipwire 
Classes name:
1.	TestNGshipWire
2.	PageSearchShipWire(class to find elements).
3.	ParamerersRunShipWire.xml (Configuration XML file)
Property file:
1.	log4jShW(for debugging)
Bug report : 1

Additional test approach and utilities which could be added:
1.	Automation screenShot class.
2.	Advanced report File.
3.	Cross-Browser testing configuration.




Bug report

ACTION PERFORMED
Tests steps
1. Go to the Shipwire and log in using  the following credentials : username: shiptest@mailinator.com / password: test1234.
2. Click on the “Support” link
3. In a new tab which will be open, click on the "Contact Us" link  
4. Fill all required information
5. Click on the “Submit” button
6. Observed expected results(Your email has been sent!)

EXPECTED RESULT
After filling Required information and click Submit button even if page still not completely loaded, it should still be possible to submit the form.

ACTUAL RESULT
If page a not completely loaded after filling Required information, Submit button doesn't work properly and it redirects to home page.

ADDITIONAL ENVIRONMENT INFO
Windows 10/Firefox
