Feature: Dropdown Practice
@dropDown
Scenario: User should be able to login with correct credentials

Given User is on the dropdowns page of practice tool

Then User should see below info in month dropdown
| January   |
| February  |
| March     |
| April     |
| May       |
| June      |
| July      |
| August    |
| September |
| October   |
| November  |
| December  |