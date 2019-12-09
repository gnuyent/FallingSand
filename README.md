# Program 8 - Falling Sand

FallingSand is a paint program that models different materials within a physical environment. 
It paints materials to a canvas, where each have different properties that interact with each 
other and the surrounding world.

## Material Functionality
Empty - Replaces the material with an empty void.

Metal - Sits there. Water goes around it usually.
 
Water - Levels into a container if placed in one. Affected by gravity. 

Sand - Attracted to the ground. Absorbs water.

Ice - Has a 90% chance to turn water into ice.

Gas - Displaces water and sand vertically. Fills into vertically-covered containers.

Cloud - Rises to the top and becomes rain. Turns into water after a while.

Dirty Water - Precipitate from interaction between Gas and Cloud.

Dirty Sand - Interaction between Dirty Water and Sand.

## Folder Structure
```
doc/ - Javadoc for program
src/main/java/com/bnguyen/fallingsand - Main program files
src/main/java/com/bnguyen/fallingsand/materials - Materials available in program
src/main/java/com/bnguyen/fallingsand/materials/util - Common interface
```

## Constant Variables
| 0     | 1     | 2    | 3     | 4   | 5   | 6   |
|-------|-------|------|-------|-----|-----|-----|
| Empty | Metal | Sand | Water | Ice | Gas |Cloud|

## Functionality Added
-   Changed program structure to resemble Maven Standard Directory Layout
### SandDisplay
#### Constructor
-	ButtonNames array changed to a List
-	Reset added as a button

#### actionPerformed
-	Checks if Reset was clicked
-	Uses abstract Material class

### SandLab
-   Constants moved to abstract Material class
-   Main method moved to FallingSandRunner
-   Material array field added
-   Reset boolean added
-   Added reset method

#### Constructor
-   Constructs Material array
-   Constructs names array from Material's getName method

#### locationClicked
-   Implemented

#### updateDisplay
-   Implemented
-   Checks if reset was clicked

#### run
-   Runs each materials' step function with foreach loop

### Materials
-   Abstracted all materials from SandLab class

### Adding new materials
In order to add new materials, certain files need to be updated.

1. Instantiate the object in the array within the main method of `FallingSandRunner`

2. Add an incremented `final` integer to the `Constants` interface

3. Add a `switch case` to both `match` methods in the `Material` class

4. Create the class inside the `materials/` directory and extend/implement as necessary

5. Ensure the constructor of each new material sets a `color` and `name` by using the respective setter methods

6. Implement the `equals` method