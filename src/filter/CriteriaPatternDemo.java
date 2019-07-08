package filter;

import java.util.ArrayList;
import java.util.List;

public class CriteriaPatternDemo {
public static void main(String[] args) {
	List<Person> persons=new ArrayList<Person>();
	//���person
	persons.add(new Person("Robert","Male", "Single"));
	persons.add(new Person("John","Male", "Married"));
	persons.add(new Person("Laura","Female", "Married"));
	persons.add(new Person("Diana","Female", "Single"));
	persons.add(new Person("Mike","Male", "Single"));
	persons.add(new Person("Bobby","Male", "Single"));
	//����ӵ��˷���
	Criteria male=new CriteriaMale();
	Criteria female=new CriteriaFemale();
	Criteria single=new CriteriaSingle();
	Criteria singleMale=new AndCriteria(single,male);
	Criteria singleOrFemale=new OrCriteria(single,male);
	//���male
	System.out.println("Males:");
	printPersons(male.meetCriteria(persons));
	//���famale
	System.out.println("\nFamale:");
	printPersons(female.meetCriteria(persons));
	//���Single Males
	System.out.println("\n Single Males");
	printPersons(singleMale.meetCriteria(persons));
	//���Single Or Females
	System.out.println("\n Single Or Females");
	printPersons(singleOrFemale.meetCriteria(persons));
	}
public static void printPersons(List<Person> persons) {
	for(Person person:persons) {
		System.out.println("Person : [ Name : " + person.getName() 
        +", Gender : " + person.getGender() 
        +", Marital Status : " + person.getMaritalStatus()
        +" ]");
	}
	
}
}
