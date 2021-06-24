package models.validators;

import java.util.ArrayList;
import java.util.List;

import models.Schedule;

public class ScheduleValidator {

	//入力チェック
	public static List<String> validate(Schedule s){
		List<String> errors = new ArrayList<String>();

		//案件名の空白チェック
		String project_title_error = validateProjectTitle(s.getProject_title());
		if(!project_title_error.equals("")) {
			errors.add(project_title_error);
		}

		String ordering_company_error = validateOrderingCompany(s.getOrdering_company());

		if(!ordering_company_error.equals("")) {
			errors.add(ordering_company_error);
		}

		return errors;
	}

	private static String validateProjectTitle(String project_title) {
    	if(project_title == null || project_title.equals("")) {
    		return "案件名を入力してください";
    	}
    	return "";
	}


	private static String validateOrderingCompany(String ordering_company) {
    	if(ordering_company == null || ordering_company.equals("")) {
        	return "上位会社（発注元企業）を入力してください";
    	}
    	return "";
	}



}
