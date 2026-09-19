Type of [[Autogeek/4 UX-projecting/Entity list|entity list]] with recommended cars.

Principles:
- Contains only [[Autogeek/4 UX-projecting/Entities/Autoprom/Model/Model|model]] and [[Autogeek/4 UX-projecting/Entities/Autoprom/Generation/Generation|generations]];
- If the user is not logged in, it contains information from the [[Autogeek/3 Data architecture/Maps/Modules/Main/Popular|popular]] list;
- Recommendations are prioritized from the following:
	- Favorites;
	- Views (last 3 months).
- The list is automatically sorted and cannot be edited.

Wired with:
- On site:
	- [[Autogeek/3 Data architecture/Maps/Modules/Secondary/Main menu|Main menu]];
- In telegram bot:
	- Command "/recomended"