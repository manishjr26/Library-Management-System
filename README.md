# Library-Management-System </u>
This is a Library Management System implemented in Java using Hibernate for database interaction and MySQL as the backend database. The project allows users to manage libraries, books, members, loans, and administrators.

# Steps for Creating Project : 
       * Open Eclipse IDE.
       * Go to File -> New -> Project.
       * In the New Project wizard, expand the Maven folder, select "Maven Project", and click "Next".
       * Check the box "Create a simple project (skip archetype selection)" and click "Next".
       * Enter the Group Id and Artifact Id for your project and click "Finish".
       * Once the Maven project is created, navigate to the project directory in Eclipse's Project Explorer.
       * Right-click on the project folder, go to New -> Package, and create the required packages (e.g., DTO, DAO, CONTROLLER).
       * Inside each package, create the necessary Java classes (e.g., Library, Book, Member, Admin, Loan).
       * Configure Hibernate and MySQL dependencies in the pom.xml file. You can find the dependencies on Maven Repository (https://mvnrepository.com/).
       * Create a new folder named "resources" under src/main. Inside the resources folder, create a new file named "persistence.xml" for Hibernate configuration.
       * Copy and paste the Hibernate configuration into the persistence.xml file. Ensure to customize the database connection details (e.g., database name, username, password).
       * Implement the required operations in the DAO classes (e.g., Library_DAO, Book_DAO) for database interaction and business logic.
       * Add additional classes as needed for controlling the flow of the application in the CONTROLLER package.
       * Run the project and test the functionality.

# Classes:
<h3>  1.) Library: Represents a library entity with attributes such as libraryId and name. </h3> 
          * Variables: libraryId, name 
<h3>   2.) Book: Represents a book entity with attributes such as bookId, title, author, ISBN, and genre. </h3>
       <h6> * Variables: bookId, title, author, ISBN, genre </h6>
 <h3>  3.) Member: Represents a member entity with attributes such as memberId, name, contact, and address. </h3>
      <h6>  * Variables: memberId, name, contact, address </h6>
 <h3>  4.) Admin: Represents an admin entity with attributes such as adminId, username, and password. </h3>
       <h6> * Variables: adminId, username, password </h6>
 <h3>  5.) Loan: Represents a loan entity with attributes such as loanId, borrowDate, and returnDate. </h3>
       <h6> * Variables: loanId, borrowDate, returnDate </h6>

# Relationships & Mappings: <br>
      * Library has a one-to-many relationship with Book and Member entities. 
      * Library has a many-to-one relationship with Admin entity. 
      * Book has a many-to-one relationship with Library and Admin entities.
      * Book has a one-to-one relationship with Member entity.
      * Member has a many-to-one relationship with Library and Admin entities. 
      * Loan has a many-to-one relationship with Member, Library, Book, and Admin entities. 

# Operations in DAO Classes :
    1. )  Library_DAO : 
              * Add a new library. 
              * Update library details. 
              * Remove a library. 
              * Retrieve library details. 
    2. )  Book_DAO : 
              * Add a new book to the library. 
              * Update book details. 
              * Remove a book from the library. 
              * Retrieve book details.
              
    3. )  Member_DAO : 
              * Add a new member to the library. 
              * Update member details. 
              * Remove a member from the library based on name.
              * Retrieve information about a specific member based on name. 
        
    4. )  Admin_DAO: 
              * Add a new admin. 
              * Update admin details. 
              * Remove an admin.
              * Retrieve admin details. 
        
    5. )  Loan_DAO : 
              * Issue a book to a member. 
              * Update loan details. 
              * Return a book. 
              * Retrieve loan details. 

# Packages: <br>
      * DTO (Data Transfer Object) : Contains entity classes representing the data model. 
      * DAO (Data Access Object)   : Contains classes for database operations and business logic. 
      * CONTROLLER                 : Contains classes for controlling the flow of the application. 

     
# Contributor
          Manish JR 
      manishjr26@gmail.com  
