This project created for Tanki Online and it's testing purposes.

It was created with Java + Selenium + TestNG. System works with RemoteWebDriver and support multithreading execution.

To run the system you should start the Selenium Hub, Node and set the appropriate hub address into config.propeties.
By default system will run in 5 threads, threads count can be changed in testng.xml.
On each test the system will start ot own RemoteWebDriver.
This system test Tanki Online index page in 7 supported locales. Tests check links, elements visibility and buttons functionality.
Test do not provide full coverage, but it can be easily extended.

This project provided for informational purposes.

Project Structure:
- src
    - main
        - java
            - autotests
                - core - contains "core" classes for working with webdrivers (instantiating, working with webelements and so on).
                    - browserinstance - specific classes for drivers instantiating and working
                    - driverinteraction - specific classes for interaction with webelements
                    - configs - contains TestConfigs class for retrieving configurations
                - locale - contains localization support classes
                - pagesobjects - contains webpages implementations, united smaller objects in one
                    - pages - page objects and it's parts
                    - sharedobjects - big parts of pages, which are used by the lot of pages (header, footer and so on).
                    - primitives - web pages and web objects primitives
                - tests - contains tests

        - resources
            - grid - selenium jar file for grid and 2 .bat files to run hub and node (you also need a webdriver)
