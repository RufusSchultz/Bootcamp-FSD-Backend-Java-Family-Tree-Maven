import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String middleName;
    private String lastName;
    private char sex;
    private int age;
    private Person mother;
    private Person father;
    private Person partner;
    private List<Person> siblings = new ArrayList<Person>();
    private List<Person> children = new ArrayList<Person>();
    private List<Pet> pets = new ArrayList<Pet>();

    public Person(String name, String lastName, char sex, int age) {
        this.name = name;
        this.lastName = lastName;
        this.sex = sex;
        this.age = age;
    }

    public Person(String name, String middleName, String lastName, char sex, int age) {
        this.name = name;
        this.middleName = middleName;
        this.lastName = lastName;
        this.sex = sex;
        this.age = age;
    }

    public void addParents(Person father, Person mother) {
        setFather(father);
        setMother(mother);
    }

    public void addChild(Person child) {
        children.add(child);
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public void addSibling(Person sibling) {
        siblings.add(sibling);
    }

    public List<Person> getGrandChildren() {
        List<Person> grandChildren = new ArrayList<>();
        List<Person> children = getChildren();

        for (Person child : children) {
            grandChildren.addAll(child.getChildren());
        }

//        Duplicate code to help me better understand foreach loops:
//        for (int i = 0; i < children.size(); i++) {
//            grandChildren.addAll(children.get(i).getChildren());
//        }

        return grandChildren;
    }

    public List<Pet> getPetsOfGrandChildren() {
        List<Person> grandChildren = getGrandChildren();
        List<Pet> petsOfGrandChildren = new ArrayList<Pet>();

        for (Person grandchild : grandChildren) {
            petsOfGrandChildren.addAll(grandchild.getPets());
        }

        return petsOfGrandChildren;
    }

    public void addPartner(Person partner) {
        setPartner(partner);
    }

    public List<Person> getNieces() {
        List<Person> nieces = new ArrayList<>();
        List<Person> siblings = getSiblings();

        for (Person sibling : siblings) {
            List<Person> niblings = sibling.getChildren();

            for (Person nibling : niblings) {
                if (nibling.getSex() == 'F') {
                    nieces.add(nibling);
                }
            }
        }

//        Duplicate code to help me better understand foreach loops:
//        for (int i = 0; i < siblings.size(); i++) {
//            List<Person> niblings = siblings.get(i).getChildren();
//
//            for (int j = 0; j < niblings.size(); j++) {
//                if (niblings.get(j).getSex() == 'F') {
//                    nieces.add(niblings.get(j));
//                }
//            }
//        }

        return nieces;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public List<Person> getSiblings() {
        return siblings;
    }

    public void setSiblings(List<Person> siblings) {
        this.siblings = siblings;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void setChildren(List<Person> children) {
        this.children = children;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public Person getPartner() {
        return partner;
    }

    public void setPartner(Person partner) {
        this.partner = partner;
    }
}
