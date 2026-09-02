Entity / Identity / Attributes / Responsibility \
Customer / customerId / name, email, phone / Hold customer profile \
Account / accountId / owner, balance / Hold account details \
Transaction / transactionNumber / amount, from, to / Log transactions

## Relationships
- One customer can own zero or more accounts
- One account can have zero or more transactions
- Each transaction can only belong to one account
- Each account can only belong to one customer

## SRP - Single Responsibility Principle
Main should manage menu input, BankService should coordinate banking operations, and domain classes should protect their own state.