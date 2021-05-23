Feature: EditLead in the Leaftaps application

Background:

Given Launch Chrome Browser
When Load URL 'http://leaftaps.com/opentaps/'
And Type the username as 'DemoSalesManager'
And Type the password as 'crmsfa'
And Click login button
And Click CRMSFA link for Edit Lead
Then Click on Lead for Edit Lead

Scenario Outline: Edit Lead with Multiple data

When click on the Find Leads link
And Enter firstname as <fName>
And click on the find leads button 
And Click on first resulting lead
And Get existing company name 
And click on Edit option 
And clear existing value and update new Company name as <orgname>
And click on update button 
Then Verify changed company value 

Examples:
|fname|orgname|
|Vishali|Atos|
|Vishali|CTS|