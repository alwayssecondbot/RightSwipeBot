Type of [[Autogeek/4 UX-projecting/Entity list|entity list]] with [[Autogeek/4 UX-projecting/Entities/Users/Offer/Offer|offers]], which user has added to the app.

Principles:
- It is intendes as module which allows to add [[Autogeek/4 UX-projecting/Entities/Autoprom/Variation/Variation|variations]] of car for selling;
- There can be only [[Autogeek/4 UX-projecting/Entities/Users/Offer/Offer|offers]] in list;
- You cannot add an entity to the module if the account is [[Autogeek/3 Data architecture/Maps/Modules/Main/Autorization and Registration|not verified]].

Wired with:
- On site:
	- [[Autogeek/3 Data architecture/Maps/Modules/Secondary/Assistant menu|Assistant menu]] - available only if user has been autorized;
	- [[Autogeek/3 Data architecture/Maps/Modules/Main/About profile|About profile]];
- In telegram bot:
	- Command "/in_sale" - available only if user has been autorized;
	- [[Autogeek/3 Data architecture/Maps/Modules/Main/About profile|About profile]].