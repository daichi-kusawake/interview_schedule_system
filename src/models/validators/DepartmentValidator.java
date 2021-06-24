package models.validators;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import models.Department;
import utils.DBUtil;
import utils.RegexUtil;

public class DepartmentValidator {

	//部署情報登録・更新時の入力データの妥当性チェックを行う
	public static List<String> validate(Department d, Boolean departmentCodeDuplicateCheckFlag) {

		//エラーメッセージ格納用リストのインスタンス生成
		List<String> errors = new ArrayList<String>();

		//部署コードチェックメソッドの呼び出し
        String code_error = validateDepartmentCode(d.getDepartment_code(), departmentCodeDuplicateCheckFlag);

        //code_errorが空でなけれがエラーメッセージリストに追加
        if(!code_error.equals("")) {
            errors.add(code_error);
        }

        String name_error = validateDepartmentName(d.getDepartment_name());
        //code_errorが空でなけれがエラーメッセージリストに追加
        if(!name_error.equals("")) {
            errors.add(name_error);
        }
        return errors;
    }

	//部署コードの入力データの妥当性チェック
	private static String validateDepartmentCode(String department_code,boolean departmentCodeDuplicateCheckFlag){
		// 必須入力チェック
        if(department_code == null || department_code.equals("")) {
            return "部署コードを入力してください。";
        }
        // 型桁チェック
        //未記入(RegexUtilクラスのhalfWidthNumberCheckメソッドを呼び出して、戻り値（チェック結果）を取得する。)
        if(department_code.length()!=2||!RegexUtil.halfWidthNumberCheck(department_code)){
        	return "部署コードは半角数字２桁で入力してください";
        }

        //すでに登録されている部署コードとの重複チェック
        if(departmentCodeDuplicateCheckFlag) {
        	//EntityManagerオブジェクトにDBUtilクラスのcreateEntityManagerメソッドの戻り値を代入する
            EntityManager em = DBUtil.createEntityManager();
            //データ件数を取得
            long departments_count = (long)em.createNamedQuery("checkRegisteredDepartmentCode", Long.class).setParameter("department_code",department_code ).getSingleResult();
            em.close();
            if(departments_count > 0) {
                return "入力された部署コードの情報はすでに存在しています。";
            }
        }
        return "";
	}
	// 部署名の入力データの妥当性チェックを行う
    private static String validateDepartmentName(String department_name) {
        //部署名の必須入力チェック
    	if(department_name == null ||department_name.equals("")) {
            return "部署名を入力してください。";
        }

        return "";
    }


}
