# BookStore-TokBox

[![Build Status](https://travis-ci.org/shruthihiriyuru/TokBox-BookStore.png)](https://travis-ci.org/shruthihiriyuru/TokBox-BookStore)
[![Coveralls github](https://img.shields.io/codecov/c/github/shruthihiriyuru/TokBox-BookStore.svg)](https://codecov.io/gh/shruthihiriyuru/TokBox-BookStore)

## Getting Started
Instructions to setup, build and test the application.

### Prerequisites
What things you need to install the software and how to install them

```
Gradle 4.3
jdk1.8 +
```

## Building and running junit tests
Use the below command to build the project and run unit tests:

```
// Change directory to application home directory
cd TokBox-BookStore
gradle test
```

## Building and running the application with user values for BookStore(initPrice, discount, floorPrice) and Customer(budget)

```
gradle run -PrunArgs='<initPrice> <discount> <floorPrice> <budget>'
Specify the arguments as a space separated string with -PrunArgs
```

## Automate builds with Github and Travis CI
[TravisCI](https://travis-ci.org/)
Open Source TravisCI infrastructure to automate builds on each commit.

## Code and Test Coverage
* Unit Testing: 
[Junit](http://junit.org/junit4/)
Junit Test Cases for unit testing.
Test File: src/Test/java/BookStoreTest.java
  
* Code Coverage:
[JaCoCo](http://www.jacoco.org/)
[CodeCov](https://codecov.io/)
Open Source tools JaCoCo and CodeCov to analyse code coverage and publish report on each commit.

## More About Project

### Integrate and scale application with other web services of a large online bookseller:
* The application uses Singleton Pattern to ensure there is only one instance of the BookStore.
* The BookStore class implements methods declared in the interface. 
  The interface itself can be extended to add other functionalities of large online bookstores.
  
### TODO:
* All properties of customer and BookStore are assumed to be integers. 
  Change implementation to accomodate floating point values.
* Implement other functionalities of BookStore - Manage Book Inventory, save Customer Purchase History.
