# Dynamic Rock/Paper/Scissors Game

# Description Of Game
This game is based on the original rules that rock beats scissor, paper beats rock, scissors beats paper, etc. However in this version
you may switch to a new set of game pieces each time you win! So for example lets say currently rock, paper, and scissors are in play. You 
can switch them out for fire, water, and air if you win at the end of the round. The game creates a player at the start then plays out a 
round with the default set. You can create a new player or play with the one your already using. If you try to create a player that 
already exists you can switch to that player. All players have scores that you can look at the end to see who's winning!

# Purpose
This game was made to explore some features of Java 12, Git VCS, and other Java Features such as Switch expressions, Recursion, Enums, Arrays, Arraylists, Hashmaps, and System design. Coding with system design in mind was interesting. I played around with Observable, State, MVC, and somewhat Unidrectional Data Flow (UDF) patterns and researched a few more like Model View Presenter (MVP) and Model View ViewModel (MVVM). Then came to MVC but kept the data flow of MVP and realized that it benefit me the most as im getting into android development. I knew certain patterns would play better with others and certain languages but this project made me realize to what 
extent that really meant. It really just depends on what you need to solve.

# System Design Examples/Briefly Explained
- **State Pattern:** Object that alters its behavior when state changes (Vending machine inventory and currency change).
- **Observable Pattern:** Object everyone observes, then objects that watch it change (Button in java with actionlistener).
- **Unidrectional Data Flow:** Data Flows in one direction (Meant to keep things clean and simple in Mobile/Web).
- **Model View Controller:** Model is the object, View is just to display, and Controller receives input and controls flow.
- **Model View Presenter:** Similar to MVC but user goes through the view, presenter is between the Model and View.
- **Model View ViewModel:** Mix between Observer Pattern and MVP uses two way data binding to ensure sync.
- For more details please follow the links down below.

# Research Materials
- [Model View Controller Guide 1](http://www.newthinktank.com/2013/02/mvc-java-tutorial/)
- [Model View Controller Guide 2](https://www.tutorialspoint.com/design_pattern/mvc_pattern.htm)
- [MVC/MVP/MVVM](https://medium.com/@ankit.sinhal/mvc-mvp-and-mvvm-design-pattern-6e169567bbad)
- [Unidrection Data Flow (UDF)](https://www.exclamationlabs.com/blog/the-case-for-unidirectional-data-flow/)
- [State Design Pattern](https://www.geeksforgeeks.org/state-design-pattern/)
- [Observable Design Pattern](https://www.vogella.com/tutorials/DesignPatternObserver/article.html)

# Pictures
![Screenshot1](https://github.com/EliasAFZ/RockPaperScissors/blob/master/Screenshots/Screenshot%20(99).png)
![Screenshot2](https://github.com/EliasAFZ/RockPaperScissors/blob/master/Screenshots/Screenshot%20(101).png)
![Screenshot3](https://github.com/EliasAFZ/RockPaperScissors/blob/master/Screenshots/Screenshot%20(100).png)
