#----------------------------------
# Empty Cucumber .feature file
#----------------------------------
    
Feature: Get/Save user credentials
    Scenario: Get user
        Given A dialog
        When the dialog opens
        Then the user should be read from the file
