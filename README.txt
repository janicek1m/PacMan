=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=
CIS 120 Game Project README
PennKey: jankim
=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=

===================
=: Core Concepts :=
===================

- List the four core concepts, the features they implement, and why each feature
  is an appropriate use of the concept. Incorporate the feedback you got after
  submitting your proposal.

  1. 2D Arrays
  A 2D array was used to represent the Pac-Man maze. I used a 2D array of chars,
  which store the current state of each 25*25 square on the playing board. The following is a 
  key of the chars used and what they correspond with:
	  'w' - wall
	  's' - small dot
	  'p' - power pellet
	  'e' - eaten small dot
	  'o' - eaten power pellet
  When Pac-Man ate a small dot or power pellet, the char at the location corresponding to the 2D
  array was updated accordingly. I iterated over the array when drawing the maze. In addition, the 2D 
  array ensured that Pac-Man or ghosts wouldn't move onto or through a wall by accessing entries of the 
  array via methods like isNextCellNavigable(). By restricting the ghosts to inside the walls of the playing 
  area, an ArrayIndexOutOfBounds exception was avoided. Similarly, the Pacman move() ensured that Pac-Man wouldn't
  move outside the bounds of the 2D array. The array was also encapsulated properly, being a private variable of the
  Wall class and only being accessible by a getter. Because of the grid/square playing area needed in Pac-Man, the 2D
  area was best suited to represent each "square" of the playing area. I decided to use a char 2D array because I could
  easily remember what each char represented, unlike using integers, and because chars take up less space than strings.
		
  2. I/O
  I/O was used to read and write a scores.txt file, keeping track of saved Pac-Man scores. I/O is an appropriate use of the 
  concept because it allows for the storage of user data in an accessible and easy to export form, a text file. I used a BufferedWriter 
  to add new score entries to the scores.txt file after a game was over. The user would be prompted to input their name via JOptionPane
  so that their name and score could be stored in the file. Each line on the file represented one game in the format Name-Score. When
  adding the new score, I defined a new object, Scorer, along with a Scorer Comparator to sort the scores in the file before writing.
  To display the scores, a BufferedReader was use to read each line of the scores.txt file. Each line was separated into two parts,
  name and score, so that scores could be displayed in a JOptionPane when the user selects the "Scores" button.
  
  3. Inheritance/Subtyping for Dynamic Dispatch
  I created an abstract Ghost class that three subtypes of ghosts, AvoidGhost, RandomGhost, and PatrolGhost, extended. I decided to use
  an abstract class because subtypes needed to inherit several methods and variables. For example, all ghosts have frightenedMode and 
  isDead variables along with related methods, as well as a randomDirection() method that returns a random direction. Originally, I 
  intended to use a ghost interface, however after implementing the interface, I refactored my code to use an abstract class instead 
  because I found myself copy and pasting a lot of code as I created each subtype. The ghosts primarily differ in their move() functions. 
  The AvoidGhost moves in the opposite direction of Pac-Man, the RandomGhost moves randomly, and the PatrolGhost only moves when Pac-Man
  is nearby.

  4. Testable Component
  The main state of my game was represented by the playing area, the 2D array, the score, and the number of lives. I tested various 
  scenarios that could change the char values of the array to ensure that the array was properly updated. I also tested interactions 
  between Pac-Man and ghosts to ensure that lives and score would update properly. Events I tested for include: When Pac-Man eats a 
  small dot, When Pac-Man eats a large dot, When Pac-Man eats a ghost in frightenedMode, When Pac-Man intersects a ghost and losts 
  a life, and how each ghost subtype moves, whether randomly or in response to Pac-Man. Within these events, I tested for edge cases.

=========================
=: Your Implementation :=
=========================

- Provide an overview of each of the classes in your code, and what their
  function is in the overall game.
  AvoidGhost.java: AvoidGhost is a subtype of Ghost. It's function is to create the AvoidGhost, which moves in the opposite direction
  of Pac-Man. 
  Ghost.java: Ghost is an abstract class. It's function is to define common methods and behaviors that can be inherited by all of the 
  Ghost subclasses. These common behaviors include whether or not the ghost is dead and whether or not the ghost is frightened.
  Lives.java: Lives is a GameObj class that renders the images that represent each of Pac-Man's 3 lives in the game. The Lives are
  displayed on the bottom left of the game.
  Pacman.java: Pac-Man is the user-controlled game object. When a user presses the arrow key, Pac-Man moves in the direction of the key.
  Pac-Man also eats dots, power pellets, and in frightenedMode, blue ghosts to increase the score. Pac-Man also has 3 lives. This class
  also manages what happens when Pac-Man intersects a ghost, either losing a life or eating the ghost.
  PatrolGhost.java: AvoidGhost is a subtype of Ghost. It's function is to create the PatrolGhost game object, which moves only when Pac-
  Man is nearby.
  RandomGhost.java: RandomGhost is a subtype of Ghost. It's function is to create the RandomGhost game object, which moves in random 
  directions when possible.
  Scorer.java: The scorer class's function is to store a player's name and score so that it can be sorted and written in the scores.txt file
  by a filewriter. The scorer class allows the program to avoid using Maps when storing a list of player score data. 
  ScoreSorter.java: The ScoreSorter's function is to override the compare function so that two scorers are compared solely by score. This is
  so that scores are sorted from highest to lowest when displayed.
  Wall.java: The wall class stores the 2D array, the "blueprint" for the playing area of the game. 

- Were there any significant stumbling blocks while you were implementing your
  game (related to your design, or otherwise)?
  A big stumbling block was understanding how to move Pac-Man and the ghosts so that they wouldn't move through or on-to a 
  wall. I found it difficult when using GameObj's move function, as it was hard to connect the position of Pac-Man to its corresponding
  row and column in a 2D array. Instead, Pac-Man moves the distance of the size of a block every time a key is pressed, ensuring that 
  Pac-Man is always corresponds to one element in the 2D array.

- Evaluate your design. Is there a good separation of functionality? How well is
  private state encapsulated? What would you refactor, if given the chance?
  I believe the private state is well encapsulated. Public state was only used to access
  final state variables, ensuring that important game elements, such as the maze, were encapsulated.
  If given the change, I would better design the Ghost abstract class and subclasses so that only one constructor would be necessary.
  I found this difficult to implement because each ghost has a different corresponding image file.


========================
=: External Resources :=
========================

- Cite any external resources (libraries, images, tutorials, etc.) that you may
  have used while implementing your game.
  Pac-Man Image: https://www.pngkey.com/png/full/23-237769_pac-man-pixel-art-pac-man.png
  Red Ghost Image: https://static.wikia.nocookie.net/pacman/images/5/56/Vulnerable-ghost.png/revision/latest?cb=20181106204925
  Orange Ghost Image: https://giantbomb1.cbsistatic.com/uploads/scale_small/8/87790/2469743-orange.png
  Pink Ghost Image: https://giantbomb1.cbsistatic.com/uploads/scale_small/8/87790/2469744-pinky.png
  Frightened Ghost Image: https://static.wikia.nocookie.net/pacman/images/5/56/Vulnerable-ghost.png/revision/latest?cb=20181106204925
