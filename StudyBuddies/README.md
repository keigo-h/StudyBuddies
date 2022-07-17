Term Project (Study Buddies)
Section 1:  Introduction
1.1 Project Specific Details  

Project Name: Term Project (Study Buddies)
Team members: Keitaro Nishijima, Taishi Nishizawa, Keigo Hachisuka, Dylan Lewis, Thin Su San 
Division of labor: 
Frontend: Keitaro, Thin Su
Connection: Taishi
Backend: Keigo, Dylan
Total time for Project: 
Section 2: Overall Description
2.1 User Needs  
Potential Stakeholders
Students
Potential points of accessibility include: 
Sign up through the website and fill in the form to find study buddies 
Sign in to get matches randomly or based on specific courses
Faculty
Potential points of accessibility include: 
Have their courses displayed in the course selection 
Brown Administration 
Potential points of accessibility include: 
Can look at the form for monitoring purposes

What are the most important tasks your users have to perform in the context of your product? 
Sign Up 
User creates an account with their brown email address and sets a password. If the email address already exists in the firebase, a message will pop up saying that the email address is already registered.
Sign Up Step 1
Users fill in their information in this part of the form. Information includes First Name, Last Name, Class Year, etc.
If first name, last name, email, or class year is not filled, an error message will appear. 
Sign Up Step 2
User fills in their preferences so that backend knows which information and what level to prioritize in finding matches
After filling out the information, the user hits the “submit form” button
Sign In
After submitting the form, the user signs in with the email address and the password they created in the first step. Here, they will have the option of choosing which courses they want to find the matches on. 
What general feelings do users express about the problem you’re working on? (E.g., people express frustration at how long it takes to find an appropriate recipe)
It can depend on the user. Some Brown University students find study buddies very easily that they are happy with and can work with for the duration of a course. However, some Brown University students have a difficult time finding appropriate people to study with. Our web application is specifically designed for the latter group of students.
How often do users perform tasks in the context of your project (i.e., how often will they use the product)?
Users will use this product mostly at the start of each semesters as they try to find study buddies for the classes they are taking. 
In what context will users interact with your product? At work? At home? In school? Some combination?
Users will interact with our product in the context of school as they navigate their semesters and try to find study buddies for their courses.
Are there secondary users? Do they have different needs? (E.g., makers of medical devices need to know the needs of doctors as well as the needs of their patients)
Secondary users may include faculty and the Brown administration as they may want to monitor since this study buddies program may affect course performance. 
Separate from user research: can you think of any ways your app might create user needs that didn’t exist before? (E.g., the addictiveness of many social media apps creates a “need” that didn’t exist before)
Our app may create external conflicts such as adding on additional stress when a study buddy turns out to prove unreliable. If this app is a success and a lot of students at Brown rely on this app to find study buddies, students who do not use this app or could not find study buddies may get a fear of missing out.

2.2 Assumptions and dependencies  
In this section, you’ll outline the assumptions—both technical and non-technical—you’re making in designing your project.
Technical Dependencies
Java 17
Typescript
GitHub
JetBrain IDEs (IntelliJ)
Personal computers for every developer, with compatibility with updated JetBrain IDEs

Non-technical Dependencies
Finding enough students at Brown to fill out the form and have a sizable database to output matches.

What normative assumptions are you making?
Are you choosing to center a particular user group over others? Why?
The user group our web application is designed for is Brown university students. We chose to center our web application for this group because adding additional universities to this application would massively increase the workload. Additionally, allowing non-university students to use this application would be a privacy and security concern given that we display the names and emails of students.
What assumptions are you making in claiming that your app adds value to people’s lives?
We are making the assumption that there is a need for a web application that matches Brown students to their best possible study buddy partners. We assume that not every Brown student is capable of finding their best study buddy through other means.
Financial Dependencies
Continued free access to JetBrain IDEs through Brown

Section 3: System Features and Requirements
3.1 Risks  
Stakeholder risks 
Unfair outcomes: Brown-RISD dual degree students cannot use this app to find study buddies in RISD courses so this may tip their social life towards one particular campus. 
Feature representation: N/A
Data manipulation: Users can create multiple accounts with different course selections and other field inputs to find specific matches for those selections. This will introduce an influx of incorrect matches in our database.
Disproportionate benefits: This may disadvantage RISD students and students studying abroad for the semester.
Publicly accessible data: We display information of matched students but this is only accessible if the user already has their account registered along with their information. 
Non-consensual data harvesting: None
Blackbox algorithms: None
Community wellbeing: We expect that our app will create a healthier academic community as students will be able to find study buddies, especially in big classes, which will aid in their academic success. 
Inefficient use of resources: Not that we know of.

External risks
Social context: This app could create an academic disparity between users and non-users as students with study buddies would be expected to enjoy the class more and excel better in the course.
Environmental harms: API calls may be costly and energy intensive. We can attempt to minimize this by reducing the number of API calls needed to produce a full dataset from the unreliable endpoints. 

3.2 Data Requirements  
We collect data from our user’s during the initial sign up process. We collect personal data such as: name, email, class year, courses, concentration, campus location, favorite study space, gender, personality type, available time slots, minimum hours studying and whether the user is an athlete. Additionally we collect data on the preferences of the user for their study buddy. This data includes; class year, concentration, grade mode, gender, personality type, athlete, favorite study space and the preferred campus location.

3.3 System Features  
Instructions for using frontend (React)
User creates an account with a brown email address and sets a password. Using the same account, the user fills in the necessary fields and submit the form, introducing their information to the backend. After submitting the form, they will sign in with the same account to get their study buddy matches. The matches can be generated by course. 
To get to the website, you need to cd frontend and run npm start which will start the website.

Instructions for using backend (Java)
After data is inputted on the front end on sign up we collect and store all of the user’s data in a student object. They are then entered into the user database.
After submitting the form the backend generates a list of the best possible matches for the student by using the collected data of this user and all previous users. This list of best possible study buddies is sent to the front end for display.

3.4 Functional Requirements  
3.4.1 Entering a command
For frontend, you need to cd frontend and run npm start to start the website.
3.4.2 How does it process data?
We process data by collecting all of the user’s data on the frontend during the sign up process. Once a user has signed up their data is used to form a student object, which is then stored in a MongoDB database. The student object’s contained in the database are all used during the process of generating study buddy matches. 
3.5 Testing Plan  
The backend testing plan consists of unit tests for all of the primary functions of the backend. Methods such as sorting the student list, checking the match scores of pairs of students, whether two students share a class, and calculating the time overlap of two student’s timeslots. These tests combine to make sure that all processes of generating the student matches work correctly and guarantee that the algorithm as a whole generates the best possible study buddy matches. These tests can be found in test/java/calculationTests.timeTest/test.
3.6 External Interface Requirements  
How will your user interact with your app? Specifically, how will you make it accessible to visually, motor, cognitive, or otherwise impaired users?
Users will interact with our app by creating an account, filling out necessary information and signing in to get matches. Our current version does not include accommodations for visually, motor, cognitive, or otherwise impaired users. This may be a further implementation for future versions. 

3.7 Non-functional Requirements  
Our standards of performance outside of our functionality are speed and security. Because we perform functions on a database of potentially thousands of students we have to ensure that our matches display quickly. If the matches take too long to load that would hurt the user experience of our web application. In terms of security, we aim to make our methods and fields private whenever possible. Additionally, we made the design choice to not take in any data from our users that would be a privacy or security concern to them. The most personal data we gather is name and email. Our UI should be accessible and easy to work with in that we label all of the dropdowns with the values that should be inputted. We also have default values for all fields if the user does not input data correctly.
