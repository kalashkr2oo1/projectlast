Feature: seach for carwash services

  Scenario: justdail finding top car wash
    Given user is on the justdail page
    Then click on later button
    Then select location
    Then select current location
    Then click on search bar
    Then search carwash
    Then click on search
    Then click on applyfilter
    Then scroll to four star
    Then click on apply
    Then print name and phone no. of the carwash

  Scenario: freelisting page registration
    Given user is on free listing page
    Then click on phone number input box
    Then enter a wrong phone no.
    Then click on start now
    Then capture the error message
    Then display the error message

  Scenario: gym page dropdown menu items
    Given user is on main page
    Then click on gym page
    Then finding and printing all dropdown menus
