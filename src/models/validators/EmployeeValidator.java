package models.validators;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import models.Employee;
import utils.DBUtil;
import utils.RegexUtil;

public class EmployeeValidator {
    public static List<String> validate(Employee e, Boolean employeeCodeDuplicateCheckFlag,
            Boolean passwordCheckFlag) {
        List<String> errors = new ArrayList<String>();

        String employee_code_error = validateEmployeeCode(e.getEmployee_code(), employeeCodeDuplicateCheckFlag);
        if(!employee_code_error.equals("")) {
            errors.add(employee_code_error);
        }

        String employee_name_error = validateEmployeeName(e.getEmployee_name());
        if(!employee_name_error.equals("")) {
            errors.add(employee_name_error);
        }

        String password_error = validatePassword(e.getPassword(), passwordCheckFlag);
        if(!password_error.equals("")) {
            errors.add(password_error);
        }

        return errors;
    }

    // 社員番号
    private static String validateEmployeeCode(String employee_code, Boolean employeeCodeDuplicateCheckFlag) {
        // 必須入力チェック
        if(employee_code == null || employee_code.equals("")) {
            return "社員番号を入力してください。";
        }

        // 型桁チェック
        if(employee_code.length() != 4 || !RegexUtil.halfWidthNumberCheck(employee_code)) {
            return "社員番号は半角数字4桁で入力してください";
        }

        // すでに登録されている社員番号との重複チェック
        if(employeeCodeDuplicateCheckFlag) {
            EntityManager em = DBUtil.createEntityManager();
            long employees_count = (long)em.createNamedQuery("checkRegisteredEmployeeCode", Long.class)
                    .setParameter("employee_code", employee_code).getSingleResult();
            em.close();
            if(employees_count > 0) {
                return "入力された社員番号の情報はすでに存在しています。";
            }
        }
        return "";
    }

    // 社員名の必須入力チェック
    private static String validateEmployeeName(String employee_name) {
        if(employee_name == null || employee_name.equals("")) {
            return "氏名を入力してください。";
        }
        return "";
    }

    // パスワードの必須入力チェック
    private static String validatePassword(String password, Boolean passwordCheckFlag) {
        // パスワードを変更する場合のみ実行
        if(passwordCheckFlag && (password == null || password.equals(""))) {
            return "パスワードを入力してください。";
        }
        return "";
    }

}
