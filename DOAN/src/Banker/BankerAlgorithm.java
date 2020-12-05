package Banker;

import java.util.Random;

import IOStream.Output;
import Data.Data;

public class BankerAlgorithm {
	private Data data = new Data();
	Output output = new Output();
	public BankerAlgorithm(int u, int v) {
		data.setQ(u);
		data.setP(v);
	}
	public BankerAlgorithm() {
		Random random = new Random();
		int q = random.nextInt(10) + 1;
		data.setQ(q);
		int p = random.nextInt(10) + 1;
		data.setP(p);
	}
	public void CreateData() {
		Random random = new Random();
		int p=data.getP();
		int q=data.getQ();
		/// Khởi tạo bảng Max ///
		int[][] maMax = new int[q][p];
		for (int i = 0; i < q; i++) {
			for (int j = 0; j < p; j++) {
				maMax[i][j] = random.nextInt(10);
			}
		}
		data.setMax(maMax);
		boolean checkMax = output.luuFileTableMax(maMax, q, p);

		/// Khởi tạo bảng Allocation với điều kiện Allocation[i][j] < Max[i][j] ///
		int[][] Allo = new int[q][p];
		for (int i = 0; i < q; i++) {
			for (int j = 0; j < p; j++) {
				do {
					Allo[i][j] = random.nextInt(10);
				} while (Allo[i][j] > maMax[i][j]);

			}

		}
		data.setAllocation(Allo);
		boolean checkAllo = output.luuFileTableAllocation(Allo, q, p);

		/// Khởi tạo bảng Available ///
		int[] Avai = new int[p];
		for (int i = 0; i < p; i++) {
			Avai[i] = random.nextInt(10);
		}
		data.setAvailable(Avai);
		boolean checkAvailable = output.luuFileTableAvailable(Avai, p);

		/// Khởi tạo bảng Need ///
		int need[][] = new int[q][p];
		for (int i = 0; i < q; i++) {
			for (int j = 0; j < p; j++) {
				need[i][j] = maMax[i][j] - Allo[i][j];
			}
		}
		data.setNeed(need);
		boolean checkNeed = output.luuFileTableNeed(need, q, p);
	}

	public void Update_Q(int k) {
		/// Cập nhập bảng Work khi thực thi tiến trình k ///
		int q = data.getQ();
		int p = data.getP();

		int arr[] = new int[p];
		arr = data.getAvailable();
		int arrAllocation[][] = new int[q][p];
		arrAllocation = data.getAllocation();
		for (int j = 0; j < p; j++) {
			arr[j] += arrAllocation[k][j];
		}
		boolean checkWork = output.luuFileTableWork(arr, p, k);
		data.setAvailable(arr);
	}

	public void RunProcessor() {
		//BankerAlgorithm actionBanker = new BankerAlgorithm(u,v);
		/// Lấy dữ liệu sau khi random ///
		int q = data.getQ();
		int p = data.getP();
		int arrNeed[][] = new int[q][p];
		arrNeed = data.getNeed();
		int arr[] = new int[p];

		/// Giải thuật Banker giúp kiểm tra trạng thái an toàn ///
		boolean danhDau[] = new boolean[10];
		for (int i = 0; i < q; i++) {
			danhDau[i] = false;
		}
		boolean check = true;
		while (check) {
			for (int i = 0; i < q; i++) {
				arr = data.getAvailable();
				if (danhDau[i] == false) {
					boolean kt = true;
					for (int j = 0; j < p; j++) {
						if (arrNeed[i][j] > arr[j]) {
							kt = false;
						}
					}
					if (kt == true) {
						this.Update_Q(i);
						danhDau[i] = true;
						i = -1;
					}
				}
			}
			check = false;
		}
		boolean t = true;
		for (int i = 0; i < q; i++) {
			if (danhDau[i] == false) {
				t = false;
			}
		}
		if (t) {
			boolean checkresult = output.luuFileResult("Hệ thống an toàn");
		} else {
			boolean checkresult = output.luuFileResult("Hệ thống không an toàn");
		}

	}

}
