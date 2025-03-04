#  UI tests:
##  Authentication tests:

## 01 User should be successfully authorized entering valid data

1. Go to [authorization page](https://app.qase.io/login) 
2. Enter valid email
3. Enter valid password
4. Click "Sign in" button

#### Expected result: User is successfully authorized 

-----
## 02 User should not be successfully authorized entering valid email and no password

1. Go to [authorization page](https://app.qase.io/login) 
2. Enter valid email
3. Click "Sign in" button
#### Expected result: User see the error message "This field is required"

-----
## 03 User should not be successfully authorized entering no email and valid password

1. Go to [authorization page](https://app.qase.io/login)
2. Enter valid password
3. Click "Sign in" button
#### Expected result: User see the error message "This field is required"

---
## 04 User should not be successfully authorized entering no data

1. Go to [authorization page](https://app.qase.io/login) 
2. Click "Sign in" button
#### Expected result: User see the error message under each email and password fields "This field is required"

---

## Project tests: 

## 01 User should successfully create new project entering valid project name and code
Preconditions: user is authorized

1. Go to [project page](https://app.qase.io/projects)
2. Click "Create new project" button
3. Enter project name that contains 1-255 characters
4. Enter project code that contains 2-10 uppercase latin characters 
5. Click "Create project" button
#### Expected result: Project is successfully created

---
## 02 User should successfully create new project and delete it
Preconditions: user is authorized

1. Go to [project page](https://app.qase.io/projects)
2. Click "Create new project" button
3. Enter project name that contains 1-255 characters
4. Enter project code that contains 2-10 uppercase latin characters
5. Click "Create project" button
6. Go to [project page](https://app.qase.io/projects)
7. Click action menu on the right side of the page near created project
8. Click Delete button
#### Expected result: Project is successfully deleted

---
## 03 User should not successfully create new project entering project code that contains less than 2 characters
Preconditions: user is authorized

1. Go to [project page](https://app.qase.io/projects)
2. Click "Create new project" button
3. Enter project name that contains 1-255 characters
4. Enter project code that contains less than 2 characters
5. Click "Create project" button
#### Expected result: User see the error message under project code field "The code must be at least 2 characters."

---
## 04 User should not successfully create new project entering project code that contains more than 10 characters
Preconditions: user is authorized

1. Go to [project page](https://app.qase.io/projects)
2. Click "Create new project" button
3. Enter project name that contains 1-255 characters
4. Enter project code that contains more than 10 characters
5. Click "Create project" button
#### Expected result: User see the error message under project code field "The code may not be greater than 10 characters." 

---
