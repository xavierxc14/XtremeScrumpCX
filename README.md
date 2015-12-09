# XtremeScrumP
XtremeScrumP is a small web app that lets you administer a project using XP and Scrum together.

You can visit the application in operation at http://xtremescrumpcx.appspot.com/

## Technologies
This is an opensource project and use a handful of technologies like:
* [Maven](http://maven.apache.org/index.html).
* [Google App Engine](http://code.google.com/appengine/) (for Java).
* [Objectify-Appengine](http://code.google.com/p/objectify-appengine/) (ORM for Google's App Engine).
* [JSF](http://www.oracle.com/technetwork/java/javaee/javaserverfaces-139869.html).
* [Primefaces](http://www.primefaces.org/).

## Development
* For development you can use your favorite IDE, I recommend Netbeans or Eclipse.
* You can build and run the aplication using maven goal: mvn appengine:devserver.
* To deploy it on Google's App Engine, edit the appengine.app.appId on the project pom's to the app id of you project, then use the maven goal mvn appengine:update.
* Also refer to [Google's App Engine Java Tutorial](https://cloud.google.com/appengine/docs/java/gettingstarted/introduction).

## Authors
* Carolina López
* Xavier Ñauñay

## Help
For help contact me.
