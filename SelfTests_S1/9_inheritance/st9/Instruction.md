# Self-Test 9 - Inheritance

## Exercise:

The Animal class represents an animal with a hunger level that goes up or down depending on the animal's activities.

### Animal
```
- hungerLevel : int  // 0 is not hungry
  Animal() // hungerLevel is 0
  Animal(int aHungerLevel)

+ abstract play() : void
+ abstract speak() : String

+ getHungerLevel() : int
+ setHungerLevel(int aLevel) : void

+ eat() : void  // sets hungerLevel to 0
+ toString() : String
```


Create two subclasses (`Dog` and `Cat`) of the abstract `Animal` class (**do not change the `Animal` class**).

The abstract methods must be implemented in both Dog and Cat.  Consider the remaining methods defined in Animal.java and determine which methods should be inherited as-is, which should be overridden, and what method(s) need to be added, given the following properties of dogs and cats:

---
* Dogs have a name.  
Dogs are constructed with a hunger level of 30 by default  
Their hunger level doubles when they play.   
Their hunger level reduces by half when they eat (use integer division)    
When they speak, dogs say "Grrrrrr" if the hunger level is >= 50   
    otherwise they say "woof".     
Dogs can doTricks, which increases the hunger level by 20.    

* Cats have a name.  
Cats are constructed with a hunger level of 10 by default  
Their hunger level increases by 20 when they play.  
Their hunger level reduces to zero when they eat.  
If the hunger level is >= 85 they say "REOW",  
if 30 <= hunger level < 85, they say "meow",  
otherwise they say  "purrrr"  
Cats can catchMice, which decreases the hunger level by half.
---
Write a demo program.
