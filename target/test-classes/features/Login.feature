Feature: Login into Application

Scenario Outline: Positive test validating login
Given Initialize the browser with chrome
And Navigate to "http://www.qaclickacademy.com/" site
And Click on Login lnk in home page to land on secure sign in page
When User enters <username> and <password> and logs in
#Then verify user is logged in
And close all chrome browsers

Examples:

|username		 |password	|
|test99@gmail.com|123456    |
|test12@gmail.com|123		|