# Junit Tester
# Quick Start
Please refer to the main README.

# Contributions
## big lines
* Clone/pull the repository on your computer
    ```bash
    git clone https://github.com/jubiiz/ECSE250Tester.git
    ```
    or 
    ```bash
    git pull origin main
    ```
* Make your changes
* Pull from Git again to make sure you have the most up to date version <br> 
    * Merge your changes with the most up to date version if needed
* Push your changes

## Git guidelines
* **Write meaningful commit messages**
* **Use issues to keep track of unfinished tests**

## Code Guidelines
see [this online best practices guide for unit testing](https://howtodoinjava.com/best-practices/unit-testing-best-practices-junit-reference-guide/#:~:text=Unit%20Testing%20Best%20Practices%201%201.%20Unit%20Testing,unit%20at%20a%20time%20...%203%203.%20Summary)

* **Naming Convention**
If you disagree with them, let me know and we can change them. <br>
    * **Test class names** should match the following pattern: ```ClassNameTest.java```  (e.g. ```MyStackTest.java```)
    * **Test names** should name the class, the sub-unit being tested (method name most likely), and the test being performed. E.g. ```MyStack_push_returnsFalseWhenElementIsNull```

    <br>
* **In doubt, ask on Ed**

* **"A test should fail for a single reason"** <br>
    Otherwise, there's a separate test that should be checking the other case.

* **Don't invoke non-required code**<br>
    Do not use any class method which is not required in the assignment. Use reflection to check the values of private fields. This ensures that anyone can use this tester. Make your own tests if you really want to.
    <br>
    * define the needed private fields atop the test class (as private variables)

* **Use the appropriate assertion statement** <br>
    Ex: use ```assertTrue``` to check the boolean return of a function rather than ```assertEquals(true, myFct())```

* **Use the appropriate test type** <br>
    Ex: use parametrized tests if you want to test multiple inputs the same way.

* **Do not print anything** <br>
    Write tests is the other tester if you want to print stuff

* **Don't leave tests behind** <br>
    Let the team know about unfinished tests through GitHub Issues. A ```//todo``` comment is less of a good standard but is better than nothing.
