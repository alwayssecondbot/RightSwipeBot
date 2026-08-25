Module which contains information about [[Autogeek/4 UX-projecting/Entities/Users/Account/Account|account]] of product user.
Has next sections:
- About user;
- About account;
- Preferences;
- [[Autogeek/4 UX-projecting/Entities/Users/Offer/Offer|Offers]].

If user looks on information about the account under which the user logged in:
- About user:
	- Linked accounts;
	- Full name;
	- Login;
	- Email;
	- Phone number;
	- Country;
	- Drive since;
	- Birth date;
- About account:
	- id;
	- Account type: private/corporation;
	- Wallet *in plans*;
	- Registered at;
	- Last seen online;
- Preferences:
	- [[Autogeek/3 Data architecture/Maps/Modules/Main/Favourite|Favourite]] cars (don't  confused with [[Autogeek/3 Data architecture/Maps/Modules/Main/Liked|liked]]);
	- Relates with driving stype: agressive/calm/dynamic/careful;
	- Own cars (almost as [[Autogeek/4 UX-projecting/Entities/Users/Offer/Tables/Offers|offers]]);
	- List of preferences in car properties;
- [[Autogeek/4 UX-projecting/Entities/Users/Offer/Tables/Offers|Offers]]:
	- Active offers;
	- Inactive offers;

If user looks on information about the other accounts:
- About user:
	- Full name;
	- Country;
- About account:
	- Account type: private/corporation;
	- Registered at;
	- Last seen online;
- [[Autogeek/4 UX-projecting/Entities/Users/Offer/Tables/Offers|Offers]]:
	- Active offers;
	- Inactive offers.


Wired with:
- On site:
	- Name-link in full view of [[Autogeek/4 UX-projecting/Entities/Users/Offer/Offer|offer]];
	- [[Autogeek/3 Data architecture/Maps/Modules/Secondary/Assistant menu|Assistant menu]] - if user hasn't logged in, he will be sent to [[Autogeek/3 Data architecture/Maps/Modules/Main/Autorization and Registration|autorization and registration]];
- In telegram bot:
	- Command "/me" -  if user hasn't logged in, he will be sent to [[Autogeek/3 Data architecture/Maps/Modules/Main/Autorization and Registration|autorization and registration]];
	- Name-link in full view of [[Autogeek/4 UX-projecting/Entities/Users/Offer/Offer|offer]].