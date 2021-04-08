
# Health Connect Program

## Getting Started

- Prerequisite Installations:
	 - [ ] IntelliJ IDEA Ultimate
	 - [ ] SDK 11
 
 - Once the prerequisite installations have been met, use the steps below to begin setup:
	 - [ ] Clone the project from GitHub in IntelliJ
	 - [ ] Add the "sqlitejdbc.jar" file that is pinned in the Discord channel to the project's structure under dependencies

 - If the database does not pull when cloning the project:
	 - [ ] Open the "Database" menu on the right side and select "Data Source Properties"
	 - [ ] Select "SQLite" from the list of options and download any missing drivers
	 - [ ] Click the "+" in the top left corner and add a SQLite data source
	 - [ ] Test the connection to verify connection
	 - [ ] Add the "sqlitejdbc.jar" file that is pinned in the Discord channel to the project's structure under dependencies
	 - [ ] Create the appropriate tables (picture in images folder)

## Setting Up for Testing

-Prerequisite Installations:
	 - [ ] JUnit5
	 - [ ] Jacoco

- Once the prerequisite installations have been met, use the steps below to begin setup:
	 - [ ] Create a pom.xml file
	 - [ ] Right click on the file and choose generate dependency. This will download JUnit5.
