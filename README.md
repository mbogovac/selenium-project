# Vivify Test

## Manual Testing
- Documents for manual testing are located under docs folder

## Postman 
- Postman collections are located under postman folder

## Automation tasks
- Frontend tests(using PageObjectModel):
    - Login
    - Create Gallery
    - Edit Gallery
    - Comment Gallery
    - Delete Gallery
    - Logout

- Backend API:
    - Checking request status - 200:
        - GET gallery
        - POST comment 
        - PUT gallery
        - DELETE gallery
    - Checking request status - 201 or 202:
        - POST gallery


## How to run
- Run any of test files as Maven Build and set goals value: test