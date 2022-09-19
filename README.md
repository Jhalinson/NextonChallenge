# NextonChallenge
Build a framework to automate these scenarios:

1. Sign up
2. Log out
3. Log in
4. Go to settings -> profile and update the avatar                              


<h2>Pre-requisite</h2>

Java JDK 16<br/>
Java environment<br/>
Maven<br/>
TestNG<br/>
Allure Report To install allure2 see the following instructions <a href="https://github.com/allure-framework/allure2">Here</a>
Jenkins (Optional)<br/><br/>

<h3>Design Pattern</h3>

Page Oject pattern (POM) used to have reusable WebElements/small helper methods separated from actual test classes and give the opportunity to have nice structured and easily readable tests (without the overhead of BDD-Frameworks like Cucumber or JBehave).<br/><br/>


<h3>Usage</h3>
To execute tests run uses these scripts in batch<br/>
'mvn clean' <br/>
'mvn compile'<br/>
'mvn install or mvn test' <br/>
To generate a report run (You must install Allure Report)<br/>
allure serve allure-results<br/><br/>

<h3>Implemented Browsers</h3>
Chrome (*)<br/>
Firefox (optional)<br/>
Safari (optional)<br/>

You can find the test result in allure-results NextonChallenge/target/surefire-reports/index.html.
