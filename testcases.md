## 01 User should be successfully authorized entering valid data

1. Go to [authorization page](https://app.qase.io/login) 
2. Enter valid email
3. Enter valid password
4. Click "Sign in" button

##### Expected result: User is successfully authorized 

-----
## 02 User should not be successfully authorized entering valid email and invalid password

1. Go to [authorization page](https://app.qase.io/login) 
2. Enter valid email
3. Enter invalid password
4. Click "Sign in" button
##### Expected result: User see the alert "These credentials do not match our records."

-----
## 03 User should not be successfully authorized entering invalid email and valid password

1. Go to [authorization page](https://app.qase.io/login) 
2. Enter invalid email
3. Enter valid password
4. Click "Sign in" button
##### Expected result: User see the alert "These credentials do not match our records."

---
## 04 User should not be successfully authorized entering no data

1. Go to [authorization page](https://app.qase.io/login) 
2. Click "Sign in" button
##### Expected result: User see the error message under each email and password fields "This field is required"

---
## 05 User should successfully create new project entering valid project name
Preconditions: user is authorized

1. Go to [project page](https://app.qase.io/projects)
2. Click "Create new project" button
3. Enter project name that contains 1-255 characters
4. Click "Create project" button
##### Expected result: Project is successfully created

---
## 06 User should not successfully create new project entering invalid project name
Preconditions: user is authorized

1. Go to [project page](https://app.qase.io/projects)
2. Click "Create new project" button
3. Enter project name that contains more than 255 characters
4. Click "Create project" button
##### Expected result: User see the error message under project name field "The title may not be greater than 255 characters." *AND* the alert "Data is invalid."

---
## 07 User should not successfully create new project entering no data
Preconditions: user is authorized

1. Go to [project page](https://app.qase.io/projects)
2. Click "Create new project" button
3. Click "Create project" button
##### Expected result: User see the alert "Заполните это поле" below the project name field

---
## 08 User should not successfully create new project entering no project code
Preconditions: user is authorized

1. Go to [project page](https://app.qase.io/projects)
2. Click "Create new project" button
3. Enter project name that contains 1-255 characters
4. Delete data in project code field
5. Click "Create project" button
##### Expected result: User see the alert "Заполните это поле" below the project code field

---
## 09 User should not successfully create new project entering project code that contains more than 10 characters
Preconditions: user is authorized

1. Go to [project page](https://app.qase.io/projects)
2. Click "Create new project" button
3. Enter project name that contains 1-255 characters
4. Enter project code that contains more than 10 characters
5. Click "Create project" button
##### Expected result: User see the error message under project code field "The code may not be greater than 10 characters." *AND* the alert "Data is invalid."

---
