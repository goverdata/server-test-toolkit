package org.test.toolkit.database.resultset.handle;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.test.toolkit.database.exception.DbExecuteException;

public class ToMapListHandle implements ResultSetHandle<List<HashMap<String, ?>>> {

	@Override
	public List<HashMap<String, ?>> handle(ResultSet resultSet) {
		List<HashMap<String, ?>> list = new ArrayList<HashMap<String, ?>>();
		try {
			while (resultSet.next()) {
				HashMap<String, Object> hashMap = new HashMap<String, Object>();
				ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
				int columnCount = resultSetMetaData.getColumnCount();
				for (int index = 1; index <= columnCount; index++) {
					String key = resultSetMetaData.getColumnName(index);
					Object value = resultSet.getObject(index);
					hashMap.put(key, value);
				}

				list.add(hashMap);
			}
			return list;
		} catch (SQLException e) {
			throw new DbExecuteException(e.getMessage(), e);
		}
	}

}
