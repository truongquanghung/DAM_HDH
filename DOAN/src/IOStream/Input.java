package IOStream;

import java.io.*;
import java.util.ArrayList;

import Data.TableData;

/// Đọc dữ liệu từ File ///

public class Input {
	public ArrayList<TableData> showTable(String path) {
		ArrayList<TableData> arrayList = new ArrayList<TableData>();
		try {
			FileInputStream fileInputStream = new FileInputStream(path);
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String line = bufferedReader.readLine();
			String[] list = null;
			// TableData bean = new TableData();
			while (line != null) {
				if (line.length() > 0) {

					list = line.split("-");
					int l = list.length;
					if (l == 11) {
						TableData bean = new TableData(list[0], list[1], list[2], list[3], list[4], list[5], list[6],
								list[7], list[8], list[9], list[10]);
						arrayList.add(bean);
					} else if (l == 10) {
						TableData bean = new TableData(list[0], list[1], list[2], list[3], list[4], list[5], list[6],
								list[7], list[8], list[9]);
						arrayList.add(bean);
					} else if (l == 9) {
						TableData bean = new TableData(list[0], list[1], list[2], list[3], list[4], list[5], list[6],
								list[7], list[8]);
						arrayList.add(bean);
					} else if (l == 8) {
						TableData bean = new TableData(list[0], list[1], list[2], list[3], list[4], list[5], list[6],
								list[7]);
						arrayList.add(bean);
					} else if (l == 7) {
						TableData bean = new TableData(list[0], list[1], list[2], list[3], list[4], list[5], list[6]);
						arrayList.add(bean);
					} else if (l == 6) {
						TableData bean = new TableData(list[0], list[1], list[2], list[3], list[4], list[5]);
						arrayList.add(bean);
					} else if (l == 5) {
						TableData bean = new TableData(list[0], list[1], list[2], list[3], list[4]);
						arrayList.add(bean);
					} else if (l == 4) {
						TableData bean = new TableData(list[0], list[1], list[2], list[3]);
						arrayList.add(bean);
					} else if (l == 3) {
						TableData bean = new TableData(list[0], list[1], list[2]);
						arrayList.add(bean);
					} else if (l == 2) {
						TableData bean = new TableData(list[0], list[1]);
						arrayList.add(bean);
					} else {
						TableData bean = new TableData(list[0]);
						arrayList.add(bean);
					}
				}
				line = bufferedReader.readLine();
			}
			bufferedReader.close();
			inputStreamReader.close();
			fileInputStream.close();
			return arrayList;
		} catch (Exception e) {
			return null;
		}

	}

	public boolean deleteFile(String source) throws IOException {
		File file = new File(source);
		if (file.exists()) {
			file.delete();
			return true;
		}
		return false;
	}

	public String showResult(String path) {
		try {
			FileInputStream fileInputStream = new FileInputStream(path);
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String line;
			line = bufferedReader.readLine();
			bufferedReader.close();
			inputStreamReader.close();
			fileInputStream.close();
			return line;
		} catch (Exception e) {
			return null;
		}
	}
}
