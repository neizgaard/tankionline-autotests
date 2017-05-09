This project created for Tanki Online and it's testing purposes.

It was created with Java + Selenium + TestNG. System works with RemoteWebDriver and support multithreading execution.

To run the system you should start the Selenium Hub, Node and set the appropriate hub address into config.propeties.
By default system will run in 5 threads, threads count can be changed in testng.xml.
On each test the system will start ot own RemoteWebDriver.
This system test Tanki Online index page in 7 supported locales. Tests check links, elements visibility and buttons functionality.
Test do not provide full coverage, but it can be easily extended.

This project provided for informational purposes.
