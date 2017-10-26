# ContactsSimple
A simple Address book using https://randomuser.me/

### Overall Approach
This project is a sample application on how to utilize RecyclerView and AbstractDataBinder to create reusable components. This project uses the Model-View-Presenter architecture which allows for the presenter to be unit-tested very easily. The project also uses GSON and a custom wrapped around okHttp to return responses that are Java objects instead of Strings.

### Platform
The app is coded all in Java and using Gradle for building.

### Features
* Ability to grab an array of 50 contacts from [Random User](https://randomuser.me/)
* Display a List of Contacts
* Display a page to show more details of contacts
* Travis Implemention with Unit Test.

### The Future
* Add ability to call contacts, just like native address book.
* Ability to edit contact information
* Ability to add new contacts
* Add debug enviroment with data stubbing (for development purposes).

### Increasing Robustness
* Increase modularity by moving things into separate repositories (ie Networking)
* Use Kotlin language to make code easier to read.
* Increase unit test / UI test coverage using Espresso and RoboElectric
