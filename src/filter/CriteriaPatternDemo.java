package filter;

import java.util.ArrayList;
import java.util.List;

public class CriteriaPatternDemo {
public static void main(String[] args) {
	List<Person> persons=new ArrayList<Person>();
	//添加person
	persons.add(new Person("Robert","Male", "Single"));
	persons.add(new Person("John","Male", "Married"));
	persons.add(new Person("Laura","Female", "Married"));
	persons.add(new Person("Diana","Female", "Single"));
	persons.add(new Person("Mike","Male", "Single"));
	persons.add(new Person("Bobby","Male", "Single"));
	//将添加的人分类
	Criteria male=new CriteriaMale();
	Criteria female=new CriteriaFemale();
	Criteria single=new CriteriaSingle();
	Criteria singleMale=new AndCriteria(single,male);
	Criteria singleOrFemale=new OrCriteria(single,male);
	//输出male
	System.out.println("Males:");
	printPersons(male.meetCriteria(persons));
	//输出famale
	System.out.println("\nFamale:");
	printPersons(female.meetCriteria(persons));
	//输出Single Males
	System.out.println("\n Single Males");
	printPersons(singleMale.meetCriteria(persons));
	//输出Single Or Females
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
