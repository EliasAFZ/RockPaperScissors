# Dynamic Rock/Paper/Scissors

# Purpose
This game was made to explore some features of Java 12 and things such as Switch expressions, Recursion, Enums, Arrays, Arraylists, 
Hashmaps, and System design. Coding with system design in mind was interesting. I played around with Observable, State, and somewhat 
Unidrectional Data Flow (UDF) patterns and researched a few more like Model View Presenter (MVP) and Model View ViewModel (MVVM). Then 
came to MVC and realized that it was best suited for my code scenario. I knew certain patterns would play better with others and 
certain languages but this project made me realize to what extent that really meant. It really just depends on what you need to solve.

# System Design Scenario Examples 
- **State Pattern:**An example would be A traffic light as it has different but concrete states (green, yellow, red, etc).
- **Observable Pattern:** would be a user subscribing to a service the observable pattern allows all 
- **Unidrectional Data Flow:** geared torwards Mobile/Web
- **Model View Controller:** geared torwards Mobile/Web
- **Model View Presenter:** geared torwards Mobile/Web
- **Model View ViewModel:** geared torwards Mobile/Web

# Description
This game is based on the original rules that rock beats scissor, paper beats rock, scissors beats paper, etc. However in this version
you may switch to a new set of game pieces each time you win! So for example lets say currently rock, paper, and scissors are in play. You 
can switch them out for fire, water, and air if you win at the end of the round. The game creates a player at the start then plays out a 
round with the default set. You can create a new player or play with the one your already using. If you try to create a player that 
already exists you can switch to that player. All players have scores that you can look at the end to see who's winning!
