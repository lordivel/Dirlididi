# REST Api Description

## /PROBLEM endpoint

This endpoit is intended for posting, modifying and accessing problems

Method | description
---- | -------------------
GET: | returns the information of ALL problems
GET {id} : | returns the information of the problem with the specified id
POST : | adds a new problem to the list

## /PROBLEM/{id}/SOLUTION endpoint
This enpoint is intended for the user to post solutions to problems

Method | description
---- | --------------------
GET: | returns the answer this user has submited to the problem, if any
POST: | adds a solution for this problem for this user, extra parameters identify which user is sending the solution

## /LOGIN endpoit
This endpoint is intended for authentication purposes

Method | description
---- | ------------------------
POST: | do login to the server


## /ACCOUNT endpoint
This endpoint is intended for user information and account creationg
Method | description
---- | ------------------------
POST: | creates account for a new user
GET: | lists all the current users in the system, can only be made by a admnistrator
GET {id} | lists the information about an user, including listing all the problems for which he has submited an solutions (extra)


## /PROBLEM/{id}/TEST endpoint
This endpoint is intended for Test case submition for problems

Method | description
---- | -------------------------
POST: | creates a new test case
GET: | returns all the test cases for a problem
GET {testid} : | returns the information of one specific test case

Application location: http://jbosswildfly-dirlididiativ.rhcloud.com/

Git Repository: https://github.com/lordivel/Dirlididi
