package IOStream;

import java.io.*;

/// Xuất dữ liệu ra các File tương ứng ///

public class Output {
	public boolean luuFileTableMax(int[][] maMax, int q, int p) {
		boolean ok = false;
		File path = new File("TableMaxData.txt");
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(path);
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
			BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
			for (int i = 0; i < q; i++) {
				for (int j = 0; j < p; j++) {
					if (j == 0) {
						bufferedWriter.write("P[" + (i + 1) + "]-");
					}
					bufferedWriter.write(maMax[i][j] + "-");

				}
				bufferedWriter.newLine();
			}
			bufferedWriter.close();
			outputStreamWriter.close();
			fileOutputStream.close();
			ok = true;
			return ok;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ok;
	}

	/// Allocation
	public boolean luuFileTableAllocation(int[][] Allo, int q, int p) {
		boolean ok = false;
		File path = new File("TableAllocationData.txt");
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(path);
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
			BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
			for (int i = 0; i < q; i++) {
				for (int j = 0; j < p; j++) {
					if (j == 0) {
						bufferedWriter.write("P[" + (i + 1) + "]-");
					}
					bufferedWriter.write(Allo[i][j] + "-");
				}
				bufferedWriter.newLine();
			}
			bufferedWriter.close();
			outputStreamWriter.close();
			fileOutputStream.close();
			ok = true;
			return ok;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ok;
	}

	/// Need ///
	public boolean luuFileTableNeed(int[][] Need, int q, int p) {
		boolean ok = false;
		File path = new File("TableNeedData.txt");
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(path);
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
			BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
			for (int i = 0; i < q; i++) {
				for (int j = 0; j < p; j++) {
					if (j == 0) {
						bufferedWriter.write("P[" + (i + 1) + "]-");
					}
					bufferedWriter.write(Need[i][j] + "-");

				}
				bufferedWriter.newLine();
			}
			bufferedWriter.close();
			outputStreamWriter.close();
			fileOutputStream.close();
			ok = true;
			return ok;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ok;
	}

	/// Available ///
	public boolean luuFileTableAvailable(int[] Available, int p) {
		boolean ok = false;
		File path = new File("TableAvailableData.txt");
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(path);
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
			BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

			for (int j = 0; j < p; j++) {
				if (j == 0) {
					bufferedWriter.write(" -");
				}
				bufferedWriter.write(Available[j] + "-");
			}
			bufferedWriter.close();
			outputStreamWriter.close();
			fileOutputStream.close();
			ok = true;
			return ok;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ok;
	}

	/// Work ///
	public boolean luuFileTableWork(int[] Available, int p, int k) {
		boolean ok = false;
		File path = new File("TableWorkData.txt");
		try {
			FileWriter fw = new FileWriter(path.getName(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			for (int j = 0; j < p; j++) {
				if (j == 0) {
					bw.write("P[" + (k + 1) + "]");
				}
				bw.write("-" + Available[j]);
				if (j == p - 1) {
					bw.write("-\n");
				}
			}
			bw.close();
			ok = true;
			return ok;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ok;
	}

	/// Result ///
	public boolean luuFileResult(String result) {
		boolean ok = false;
		File path = new File("TableResult.txt");
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(path);
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
			BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
			bufferedWriter.write(result);
			bufferedWriter.close();
			outputStreamWriter.close();
			fileOutputStream.close();
			ok = true;
			return ok;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ok;
	}
}
