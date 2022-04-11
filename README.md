# UIDemo
It is a small framework that combined Selenium and Cucumber for data driven testing.

The Test Steps are defined in stepDefinitions/Steps.java
feature/UIDemo.feature keeps the Test Cases
The Test report can be found:target/cucumber-reports/cucumber-html-reports

With the designed test cases the result are both passed
![image](https://user-images.githubusercontent.com/34325238/162667802-9845d224-425b-44fc-8c10-7808a81b21ce.png)

However, when manual checking the website, I found there's a minor displaying issue, you might want to check with your team:

However, when I manual check the website, I found there's a minor displaying issue, you might want to check with your team:

Steps to reproduce:
Go to https://www.maui-rentals.com/ or https://www.britz.com/
pick a date for Pick Up Date
Then click on the Drop Off Date picker, click on next arrow, then the date picker appears under the PickUpDate but not DropOffDate

![image](https://user-images.githubusercontent.com/34325238/162668520-a90a47c5-9610-4c66-9182-13d32511921f.png)
