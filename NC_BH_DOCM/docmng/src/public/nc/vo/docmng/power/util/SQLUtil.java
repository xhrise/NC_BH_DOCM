package nc.vo.docmng.power.util;

public class SQLUtil {
	public static String All_POWERITEM_SQL = "select t.pk_doctype pk_busipower,t.code,t.name,t.pid from docmng_doctype t where t.pk_group=? and dr=0";

	public static String ASSIGN_POWERITEM_SQL = "select doctype.pk_doctype pk_busipower,doctype.code,doctype.name,doctype.pid,detail.pk_detail,detail.ts from docmng_dmpowerdetail detail left join docmng_doctype doctype on detail.pk_doctype = doctype.pk_doctype where detail.pk_power=?";
	
	public static String FILEPATH_SQL="select name from docmng_doctype start with pk_doctype=? connect by prior pid=pk_doctype";
	
	public static String FILEPATH_SQL_MS="with t as (select * from docmng_doctype where pk_doctype = ? union all select docmng_doctype.* from t,docmng_doctype where t.pid = docmng_doctype.pk_doctype) select name from t";
}
