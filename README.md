# ATM
## Description 

This is a Java based ATM project. This application allows the user to view the transaction history for a specific account, withdraw, transfer and deposit funds using an intuitive text-based user interface. 

## Importance 

This repository is important as it shows my understanding of Java and Object-oriented programming. It also provides insights to my understanding and comprehension of Java fundamentals such as classes, objects, hashing, arraylists and encapsulation.

## Installation

To install this project locally, open the repository in your web browser: [ATM](https://github.com/Darren0422/ATM). On the repository page, click on the green "Code" button located near the top-right of the page. From the dropdown menu, select "Download ZIP". This will start the download of the repository as a ZIP file to your computer. Save it on your local storage device. 

<img width="1728" alt="Screenshot 2024-01-05 at 13 28 01" src="https://github.com/Darren0422/ATM/assets/134398985/af53bdb4-006a-437e-9d56-66238972d3e4">

##  Usage

You may open this file with a code editor of your choice, such as, VSCode and gain access to the written lines of code.
Run the program in your editor of choice.

<img width="1728" alt="Screenshot 2024-01-05 at 13 31 28" src="https://github.com/Darren0422/ATM/assets/134398985/e250f39c-d4c2-4237-94cd-8ace880c1a70">

## ATM Project
### Classes 
#### ATM (main)
The ATM class is the main class of the ATM application. It creates the new user instance so a login can occur and holds the functionailty for the user interactions.

#### Bank
The Bank class represents a bank. It manages users and accounts associated with this bank. 

##### Properties:
name: The name of the bank.
users: An ArrayList that holds instances of the User class (all users associated with the bank).
accounts: An ArrayList that holds instances of the Account class (all accounts associated with the bank).


#### User
The User class represents a user object in the banking application.

##### Properties:
firstName: The first name of the user.
lastName: The last name of the user.
uuid: The UUID (universally unique identifier) of the user.
pinHash: The SHA-256 hash of the user's PIN.
accounts: An ArrayList that holds instances of the Account class (all accounts associated with the specific user object).

#### Account
The Account class represents a financial account within the banking application that is associated with a User.

##### Properties:
name: The name of the account (e.g., "Savings" or "Cheque").
uuid: Universally unique identifier (UUID) assigned to each account. It provides a unique reference for each account.
accHolder: Reference to the User object that holds this account. This establishes a relationship between the account and the user.
transactions: An ArrayList containing instances of the Transaction class. Each Transaction object represents a financial transaction associated with this account.

#### Transaction 
The Transaction class represents an individual financial transaction that occurs within a banking application that is assoicated with the Account of the User.

##### Properties:
amount: The monetary amount of the transaction (positive for deposits or negative for withdrawals).
timestamp: The date and time when the transaction occurred. 
Reference: A reference for the transaction.
transactionAccount: Reference to the Account object in which the transaction was made. This establishes a relationship between the transaction and the account of the User involved.

### Features  
#### Login 
The user is prompted to enter their "User ID" and corresponding "Pin". This prompt will repeat until successful or the user quits. 
It allows an authorised user to continue to the user menu of the ATM.

<img width="1387" alt="Screenshot 2024-01-05 at 13 34 19" src="https://github.com/Darren0422/ATM/assets/134398985/dbe7ebca-ce82-4bd9-9e83-3eadd370ce6f">


#### User Menu
The user is then prompted to enter their choice for the option they would like to make use of. This prompt will repeat until a valid option is selected or the user quits.

<img width="1387" alt="Screenshot 2024-01-05 at 13 34 31" src="https://github.com/Darren0422/ATM/assets/134398985/6e68d964-73bc-4496-a9c9-16a4b44e82af">

##### Transaction History 
The user is shown an account summary and prompted to select the account they wish to see the transaction history of. The transaction history of the specified account is then displayed. 

<img width="1387" alt="Screenshot 2024-01-05 at 13 40 28" src="https://github.com/Darren0422/ATM/assets/134398985/04fd1155-16cc-4f14-8e91-24a5c9a8e5e3">

##### Withdrawl
The user is shown an account summary and prompted to select the account they wish to withdraw the funds from. The user must specify the amount and a reference for the withdrawl.

<img width="1387" alt="Screenshot 2024-01-05 at 13 39 33" src="https://github.com/Darren0422/ATM/assets/134398985/58fceca0-ebc0-42de-9b1a-02c1fe9a7cec">

##### Deposit
The user is shown an account summary and prompted to select the account they wish to deposit the funds to. The user must specify the amount and a reference for the deposit.

<img width="1387" alt="Screenshot 2024-01-05 at 13 36 36" src="https://github.com/Darren0422/ATM/assets/134398985/1d56ade8-2953-40f7-b24c-4c129120346d">

##### Transfer
The user is shown an account summary and prompted to select the account they wish to withdraw the funds from and then select the account they wish to transfer the funds to. The user must specify the amount for the transfer.

<img width="1387" alt="Screenshot 2024-01-05 at 13 37 42" src="https://github.com/Darren0422/ATM/assets/134398985/1529a499-8c23-421a-8d7d-01c025278da7">

##### Quit
The user quits the ATM application and they are returned to the Login prompt. 

## Credits
[Darren Chen](https://github.com/Darren0422)
[TechLiterate]([https://github.com/Darren0422](https://www.youtube.com/channel/UCwSohBPdCzjnO8xW0y5hSTg/about)https://www.youtube.com/channel/UCwSohBPdCzjnO8xW0y5hSTg/about)
