# Lojo Fundraising
Lojo Fundraising is a data analytics site for digital fundraising emails. It takes in email performance and fundraising data and calculates key metrics. It allows users to perform advanced custom searches to group emails based on content, type, and a variety of other attributes, as well as sort emails based on metrics.

## Features
* Secure login and registration with validation and email verification
* Imports and reads Excel documents with performance and fundraising data to create Java objects (fundraising emails) and stores them in a MySQL database
* Custom search function to query fundraising emails based on user-generated data, providing the ability to group emails by topic, analyze performance, and optimize fundraising strategy [(see demo below)](#Search)
* Responsive U.I. built with JavaScript, CSS, and HTML5							
* Builds reports using search functionality and allows users to export them to Excel and Word [(see demo below)](#Export)						

## Technologies
FRONT END: HTML5 | CSS | JavaScript | Bootstrap | JSP
BACK END: Java | MySQL | JPA | Hibernate
KEY APIs: JPA Criteria API | Apache POI API | Java Mail API | Java Persistence API
TOOLS: Spring Tool Suite | MySQL Workbench

## Demos
### Search
![Search](https://github.com/zking63/dgalojofundraising/blob/master/src/main/resources/static/images/search.gif "Search gif") 
### Export
![Export](https://github.com/zking63/dgalojofundraising/blob/master/src/main/resources/static/images/export.gif "Export gif")
