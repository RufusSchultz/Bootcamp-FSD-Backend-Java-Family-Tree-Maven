import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void childShouldHaveAMomAndDadAdded() {
        //arrange
        Person dad = new Person("Kyle", "Reese", 'M', 25);
        Person mom = new Person("Sarah", "Connor", 'F', 25);
        Person child = new Person("John", "Connor", 'M', 5);

        //act
        child.addParents(dad, mom);

        //assert
        assertEquals("Kyle", child.getFather().getName());
        assertEquals("Sarah", child.getMother().getName());
    }

    @Test
    void personShouldHaveChildAdded() {
        //arrange
        Person parent = new Person("Ma", "Flodder", 'F', 44);
        Person child = new Person("Kees", "Flodder", 'F', 22);

        //act
        parent.addChild(child);

        //assert
        assertEquals(1, parent.getChildren().size());

    }

    @Test
    void personShouldHavePetAdded() {
        //arrange
        Person owner = new Person("Timmy", "Something", 'M', 8);
        Pet pet = new Pet("Lassie", 4, "Dog");

        //act
        owner.addPet(pet);

        //assert
        assertEquals(1, owner.getPets().size());

    }

    @Test
    void personShouldHaveSiblingAdded() {
        //arrange
        Person p1 = new Person("Frank", "de Boer", 'M', 55);
        Person p2 = new Person("Ronald", "de Boer", 'M', 55);

        //act
        p1.addSibling(p2);

        //assert
        assertEquals(1, p1.getSiblings().size());

    }

    @Test
    void grandChildrenShouldBeReturned() {
        //arrange
        Person granddad = new Person("Cor", "Snor", 'M', 75);
        Person dad = new Person("Bert", "Snor", 'M', 50);
        Person son = new Person("Jan", "Snor", 'M', 25);
        Person daughter = new Person("Bep", "Snor", 'F', 23);

        //act
        granddad.addChild(dad);
        dad.addChild(son);
        dad.addChild(daughter);

        //assert
        assertEquals(2, granddad.getGrandChildren().size());

    }

    @Test
    void everyPetOfEveryGrandChildShouldBeReturned() {
        //arrange
        Person granddad = new Person("Cor", "Snor", 'M', 75);
        Person dad = new Person("Bert", "Snor", 'M', 50);
        Person son = new Person("Jan", "Snor", 'M', 25);
        Person daughter = new Person("Bep", "Snor", 'F', 23);
        Pet dog = new Pet("Rover", 2, "dog");
        Pet cat = new Pet("Pluis", 7, "cat");
        Pet goldfish = new Pet("Visstick", 3, "goldfish");

        //act
        granddad.addChild(dad);
        dad.addChild(son);
        dad.addChild(daughter);
        son.addPet(dog);
        daughter.addPet(cat);
        daughter.addPet(goldfish);

        //assert
        assertEquals(3, granddad.getPetsOfGrandChildren().size());

    }

    @Test
    void everyNieceShouldBeReturned() {
        //arrange
        Person guy = new Person("Jan", "Kort", 'M', 32);
        Person sister = new Person("Jantien", "Kort", 'F', 30);
        Person niece1 = new Person("Corrie", "Lang", 'F', 5);
        Person nephew1 = new Person("Roderick", "Lang", 'M', 3);
        Person brother = new Person("Klaas", "Kort", 'M', 33);
        Person niece2 = new Person("Truus", "Kort", 'F', 3);
        Person niece3 = new Person("Miep", "Kort", 'F', 1);

        //act
        guy.addSibling(sister);
        guy.addSibling(brother);
        sister.addChild(niece1);
        sister.addChild(nephew1);
        brother.addChild(niece2);
        brother.addChild(niece3);

        //assert
        assertEquals(3, guy.getNieces().size());

    }

    @Test
    void shouldNotBeSingleAnymore() {
        //arrange
        Person harry = new Person("Harry", "Redhead", 'M', 40);
        Person megan = new Person("Megan", "Marvel", 'F', 39);

        //act
        harry.addPartner(megan);

        //assert
        assertEquals("Megan", harry.getPartner().getName());

    }

    @Test
    void ratioMalesToFemalesInChildrenShouldBeReturned() {
        //arrange
        Person mom = new Person("Linda", "DePinda", 'F', 66);
        Person daughter1 = new Person("Lies", "Boer", 'F', 44);
        Person daughter2 = new Person("Clarice", "DePinda", 'F', 30);
        Person daughter3 = new Person("AnneLies", "DePinda", 'F', 29);
        Person daughter4 = new Person("Tugba", "DePinda", 'F', 26);
        Person son1 = new Person("Kwik", "DePinda", 'M', 42);
        Person son2 = new Person("Kwek", "DePinda", 'M', 40);
        Person son3 = new Person("Kwak", "DePinda", 'M', 38);


        //act
        mom.addChild(daughter1);
        mom.addChild(daughter2);
        mom.addChild(daughter3);
        mom.addChild(daughter4);
        mom.addChild(son1);
        mom.addChild(son2);
        mom.addChild(son3);


        //assert
        assertEquals(0.75, mom.malesToFemalesRatioInChildren());
    }
}