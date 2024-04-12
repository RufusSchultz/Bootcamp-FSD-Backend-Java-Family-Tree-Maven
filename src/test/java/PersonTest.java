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
        assertEquals(dad, child.getFather());
        assertEquals(mom, child.getMother());
    }

    @Test
    void personShouldHaveChildAdded() {
        //arrange
        Person parent = new Person("Ma", "Flodder", 'F', 44);
        Person child = new Person("Kees", "Flodder", 'F',22);

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
    void getGrandChildren() {
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
}