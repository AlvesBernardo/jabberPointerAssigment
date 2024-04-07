# Project Setup Instructions
Follow the below instructions to setup the project in your local development environment.
## Prerequisites
Make sure the following software is installed on your machine:
Java 17 or higher. You can download Java from Oracle's website.
Maven 3.8.1 (or above). Follow this Google search link to find relevant resources for installing Maven.
IntelliJ IDEA (preferably 2024.1, Ultimate Edition).
You can verify your Java and Maven installations by running these commands in your terminal:
java --version
mvn --version
## Install Additional Libraries
Please install [https://jar-download.com/download-handling.php]
This project requires an additional JSON library. Follow these steps to add the JSON library to your project:
Download the library from this link.
Open your project in IntelliJ IDEA.
Go to File -> Project Structure... or use the Ctrl + Shift + Alt + S shortcut.
Click on Modules under "Project Settings".
In the "Modules" tab, click on the Dependencies sub-tab located at the top of the window.
Click on the "+" button on the right side, then select JARs or directories... from the drop-down menu.
Navigate and find the downloaded JSON library jar file, then click OK.
Finally, click Apply and OK in the "Project Structure" window.
# Build the Project
After installing all the dependencies, build the project by opening the terminal in the project directory and running:
mvn clean install
# Deployed Application
The application's executable JAR file has been uploaded to Google Cloud Services. Please ensure to have the appropriate permissions or credentials to access the application.