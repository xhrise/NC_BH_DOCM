package nc.itf.docmng;

import java.util.Map;

import nc.bs.dao.DAOException;

public interface IFilePathGenerator {
	
	public Map<String, String> getFilePathWithName(Map<String, String> mapName,Map<String,String> mapPK) throws DAOException;
}
