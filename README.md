# CroneExpressionParser
This application help to parse the crone expression!

## Requirement 
- JDK 8 or 11 
- Intellij or Eclips IDE (not necessary)
- Lombok plugin
- Jnit library

## Run
You can complie the whole project and then run ApplicationStrater.java, it is the entry point of the application and will ask you ro input the crone expression to be parsed

## Crone Expression

Crone expression takes in the below fileds:

minute hour day_of_month month day_of _week commad_to_run

*	any value , and below is how they are treated
* for minute -> "Every Minute"
* for hour -> "Every Hour"
* for day of month -> "Every Day Of Month"
* for month -> "Every Month of Year"
* for day of week -> "Every Day Of Week"

,	value list separator
for instance 1,2,3,4,5 

-	range of values
for instance 1-20

/	step values
for instance */12, we can only have * as the numerator in the step function

Below are the valid ranges for various fields
minute -> 0 to 59
houe ->  0 to 23
day of month ->  1 to 31
month. ->  1 to 12
day of week -> 0 to 6

## Reference: 
We have referred the below link for this parser
https://crontab.guru/ 


## Class Diagram
![uml_diagram](https://user-images.githubusercontent.com/15605254/133329501-c5302026-18f8-43a3-accd-405619e25c95.png)

## Project Structure
<img width="402" alt="Screenshot 2021-09-15 at 12 34 26 AM" src="https://user-images.githubusercontent.com/15605254/133329540-03701250-0299-422d-a99e-55a82825e2f6.png">






