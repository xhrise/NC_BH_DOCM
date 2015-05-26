package nc.impl.docmng;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

import nc.bs.dao.BaseDAO;
import nc.bs.dao.DAOException;
import nc.impl.am.db.processor.ColumnSetProcessor;
import nc.impl.am.db.processor.ListMapProcessor;
import nc.itf.docmng.IFilePathGenerator;
import nc.jdbc.framework.SQLParameter;
import nc.jdbc.framework.processor.ColumnListProcessor;
import nc.vo.docmng.power.util.SQLUtil;

public class FilePathGeneratorImpl implements IFilePathGenerator {

	@Override
	public Map<String, String> getFilePathWithName(Map<String, String> mapName,
			Map<String, String> mapPK) throws DAOException {
		BaseDAO bd = new BaseDAO();
		for (Map.Entry<String, String> ety : mapPK.entrySet()) {
			StringBuilder sb = new StringBuilder();
			String doctype = ety.getValue();
			SQLParameter sp = new SQLParameter();
			sp.addParam(doctype);
		    List<String> list = (List<String>) bd
					.executeQuery(SQLUtil.FILEPATH_SQL_MS, sp,
							new ColumnListProcessor("name"));
			String[] names = list.toArray(new String[0]);
			for (int i = names.length-1;i>=0;i--) {
				sb.append(names[i]);
				sb.append(File.separator);
			}
			sb.append(mapName.get(ety.getKey()));
			ety.setValue(sb.toString());
		}
		return mapPK;
	}

}
