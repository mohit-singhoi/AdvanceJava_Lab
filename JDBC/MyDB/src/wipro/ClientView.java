package wipro;

import java.util.List;

public class ClientView {
	public static void main(String[] args) {
EmpDAO da=new EmpDAO();
//	List<EmpBean> list =da.view();
//	for(EmpBean p:list){
//	System.out.println(p.getId() + " " + p.getName()+" " + p.getSalary()+ " " + p.getDeptno());
//	}

	EmpBean p =da.view(118);
	
		System.out.println(p.getId() + " " + p.getName()+" " + p.getSalary()+ " " + p.getDeptno());
	
}
}
