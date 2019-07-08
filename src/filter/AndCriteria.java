package filter;

import java.util.ArrayList;
import java.util.List;

public class AndCriteria implements Criteria  {
	private Criteria  criteria;
	private Criteria  otherCriteria;
	
	public AndCriteria(Criteria criteria, Criteria otherCriteria) {
		this.criteria=criteria;
		this.otherCriteria=otherCriteria;
	}
	@Override
	public List<Person> meetCriteria(List<Person> persons) {
		List<Person> firstCriteriaPersons=new ArrayList<Person>();
		
		return otherCriteria.meetCriteria(firstCriteriaPersons);
	}

}
