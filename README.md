# kreditech-tests

Project requirements:
 - Installed and configured Java 1.7 or above
 - Installed and configured Maven 3.1.1 or above

How to run:
 - Just execute run.sh
 - You can find test report in target/site/allure-maven-plugin/ directory.
 Just open index.html in Firefox (local report can not be opened in Chrome due to security settings)
 - Chrome driver is used by default. To use Firefox just change "-Dbrowser=CHROME" to "-Dbrowser=FIREFOX"
 in run.sh

 Note:
 - Please update
 https://github.com/skalozubov/kreditech-tests/blob/master/src/main/java/com/kreditech/users/TwitterUser.java
 with correct credentials to make userShouldBeAbleToFollowKreditechOnTwitter() test success.