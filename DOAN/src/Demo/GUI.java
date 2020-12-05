package Demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import IOStream.Input;
import Data.TableData;
import Banker.BankerAlgorithm;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GUI extends JFrame {
	ArrayList<TableData> arrayListMax = null;
	ArrayList<TableData> arrayListAllo = null;
	ArrayList<TableData> arrayListNeed = null;
	ArrayList<TableData> arrayListAvali = null;
	ArrayList<TableData> arrayListWork = null;

	private DefaultTableModel defaultTableModelMax;
	private DefaultTableModel defaultTableModelAllo;
	private DefaultTableModel defaultTableModelNeed;
	private DefaultTableModel defaultTableModelAvail;
	private DefaultTableModel defaultTableModelWork;

	private JPanel contentPane;
	private JTable tblMax;
	private JTable tblAllo;
	private JTable tblNeed;
	private JTextField txtQ;
	private JTextField txtP;
	private JTable tblAvail;
	private JTable tblWork;
	JLabel lblResult;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GUI() {
		/// Thiết lập các trường cho giao diện ///
		setAlwaysOnTop(true);
		setFont(new Font("Dialog", Font.BOLD, 12));
		setTitle("ĐỒ ÁN HỆ ĐIỀU HÀNH");
		setBackground(new Color(189, 183, 107));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1400, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0xCC, 0xFF, 0xCC));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel(
				"Xây Dựng Chương Trình Mô Phỏng Giải Thuật Nhà Băng Của Dijsktra Để Dự Đoán Deadlock");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setForeground(Color.BLUE);

		JScrollPane scrollPane = new JScrollPane();

		JLabel lblNewLabel_1 = new JLabel("BẢNG DỮ LIỆU MAX");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));

		JScrollPane scrollPane_1 = new JScrollPane();

		JLabel lblNewLabel_2 = new JLabel("BẢNG DỮ LIỆU ALLOCATION");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setForeground(Color.BLUE);

		JScrollPane scrollPane_2 = new JScrollPane();

		JLabel lblNewLabel_3 = new JLabel("BẢNG DỮ LIỆU NEED");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setForeground(Color.BLUE);

		JLabel lblNewLabel_4 = new JLabel("SỐ TIẾN TRÌNH  P (<=10):");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setForeground(Color.BLUE);

		txtQ = new JTextField();
		txtQ.setForeground(Color.RED);
		txtQ.setFont(new Font("Tahoma", Font.BOLD, 11));
		//txtQ.setEnabled(false);
		txtQ.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("SỐ TÀI NGUYÊN  R (<=10):");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setForeground(Color.BLUE);

		txtP = new JTextField();
		txtP.setForeground(Color.RED);
		txtP.setFont(new Font("Tahoma", Font.BOLD, 11));
		//txtP.setEnabled(false);
		txtP.setColumns(10);

		JScrollPane scrollPane_3 = new JScrollPane();

		JLabel lblNewLabel_6 = new JLabel("BẢNG DỮ LIỆU WORK KHI THỰC THI CÁC TIẾN TRÌNH");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setForeground(Color.BLUE);

		JScrollPane scrollPane_4 = new JScrollPane();

		JLabel lblBngDLiu = new JLabel("BẢNG DỮ LIỆU AVAILABLE");
		lblBngDLiu.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBngDLiu.setForeground(new Color(0, 0, 255));
		
		/// Tạo nút nhấn ///
		JButton btnCreData = new JButton("RUN");
		btnCreData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int q= Integer.parseInt(txtQ.getText());
					int p= Integer.parseInt(txtP.getText());
					
					if (p<0 ||q<0 ||q>10 ||q>10) {
						lblResult.setText("Dữ liệu nhập thiếu hoặc sai");
						return ;
					}
					
					BankerAlgorithm BankerAlgorithm = new BankerAlgorithm(q,p);
					BankerAlgorithm.CreateData();
					BankerAlgorithm.RunProcessor();
					//int q = Data.getQ();
					//int p = Data.getP();
					txtQ.setText(q + "");
					txtP.setText("" + p);

					Input Input = new Input();
					
					/// Max ///
					defaultTableModelMax = (DefaultTableModel) tblMax.getModel();
					arrayListMax = Input.showTable("TableMaxData.txt");
					while (defaultTableModelMax.getRowCount() > 0)
						defaultTableModelMax.removeRow(0);
					for (TableData TableData : arrayListMax) {
						defaultTableModelMax.addRow(new Object[] { TableData.getRow1(), TableData.getRow2(),
								TableData.getRow3(), TableData.getRow4(), TableData.getRow5(), TableData.getRow6(),
								TableData.getRow7(), TableData.getRow8(), TableData.getRow9(), TableData.getRow10(),
								TableData.getRow11() });
					}
					
					/// Allocation ///
					defaultTableModelAllo = (DefaultTableModel) tblAllo.getModel();
					arrayListAllo = Input.showTable("TableAllocationData.txt");
					while (defaultTableModelAllo.getRowCount() > 0)
						defaultTableModelAllo.removeRow(0);
					for (TableData TableData : arrayListAllo) {
						defaultTableModelAllo.addRow(new Object[] { TableData.getRow1(), TableData.getRow2(),
								TableData.getRow3(), TableData.getRow4(), TableData.getRow5(), TableData.getRow6(),
								TableData.getRow7(), TableData.getRow8(), TableData.getRow9(), TableData.getRow10(),
								TableData.getRow11() });
					}
					
					/// Need ///
					defaultTableModelNeed = (DefaultTableModel) tblNeed.getModel();
					arrayListNeed = Input.showTable("TableNeedData.txt");
					while (defaultTableModelNeed.getRowCount() > 0)
						defaultTableModelNeed.removeRow(0);
					for (TableData TableData : arrayListNeed) {
						defaultTableModelNeed.addRow(new Object[] { TableData.getRow1(), TableData.getRow2(),
								TableData.getRow3(), TableData.getRow4(), TableData.getRow5(), TableData.getRow6(),
								TableData.getRow7(), TableData.getRow8(), TableData.getRow9(), TableData.getRow10(),
								TableData.getRow11() });
					}
					
					/// Available ///
					defaultTableModelAvail = (DefaultTableModel) tblAvail.getModel();
					arrayListAvali = Input.showTable("TableAvailableData.txt");
					while (defaultTableModelAvail.getRowCount() > 0)
						defaultTableModelAvail.removeRow(0);
					for (TableData TableData : arrayListAvali) {
						defaultTableModelAvail.addRow(new Object[] { TableData.getRow1(), TableData.getRow2(),
								TableData.getRow3(), TableData.getRow4(), TableData.getRow5(), TableData.getRow6(),
								TableData.getRow7(), TableData.getRow8(), TableData.getRow9(), TableData.getRow10(),
								TableData.getRow11() });
					}
					
					/// Work ///
					defaultTableModelWork = (DefaultTableModel) tblWork.getModel();
					File file = new File("TableWorkData.txt");
					while (defaultTableModelWork.getRowCount() > 0)
						defaultTableModelWork.removeRow(0);
					if (file.exists()) {
						arrayListWork = Input.showTable("TableWorkData.txt");
						for (TableData TableData : arrayListWork) {
							defaultTableModelWork.addRow(new Object[] { TableData.getRow1(), TableData.getRow2(),
									TableData.getRow3(), TableData.getRow4(), TableData.getRow5(), TableData.getRow6(),
									TableData.getRow7(), TableData.getRow8(), TableData.getRow9(), TableData.getRow10(),
									TableData.getRow11() });
						}
					}

					/// Xóa Work cũ ///
					String result = Input.showResult("TableResult.txt");
					lblResult.setText(result);
					try {
						if (file.exists()) {
							boolean checkDeleteFile = new Input().deleteFile("TableWorkData.txt");
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				} catch (Exception e) {
					lblResult.setText("Dữ liệu nhập thiếu hoặc sai");
				}
				

			}
		});
		btnCreData.setBackground(new Color(255, 215, 0).CYAN);
		btnCreData.setForeground(new Color(0, 0, 128));

		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					boolean checkDeleteFile = new Input().deleteFile("TableWorkData.txt");
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.exit(0);
			}
		});
		
		/// Tạo giao diện người dùng /// 
		lblResult = new JLabel("");
		lblResult.setForeground(Color.BLACK);
		lblResult.setFont(new Font("Times New Roman", Font.BOLD, 17));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		
		/// Các trường được nhóm theo hàng ngang ///
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addPreferredGap(ComponentPlacement.RELATED, 150, Short.MAX_VALUE).addComponent(lblNewLabel_1)
						.addPreferredGap(ComponentPlacement.RELATED, 250, Short.MAX_VALUE).addComponent(lblNewLabel_2)
						.addPreferredGap(ComponentPlacement.RELATED, 300, Short.MAX_VALUE).addComponent(lblNewLabel_3)
						.addGap(180))
				.addGroup(gl_contentPane.createSequentialGroup().addGap(58).addComponent(lblNewLabel_4)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(txtQ, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblNewLabel_5)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(txtP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(
										gl_contentPane.createSequentialGroup().addComponent(lblNewLabel).addGap(275))))
				.addGroup(gl_contentPane.createSequentialGroup().addGap(600).addComponent(lblBngDLiu)
						.addContainerGap(829, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup().addGap(525).addComponent(lblNewLabel_6)
						.addContainerGap(841, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 444, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 441, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(scrollPane_2,
										GroupLayout.PREFERRED_SIZE, 438, GroupLayout.PREFERRED_SIZE))
						.addGap(750)
						.addGroup(gl_contentPane.createSequentialGroup().addComponent(scrollPane_4,
								GroupLayout.PREFERRED_SIZE, 1335, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(580).addComponent(lblResult,
								GroupLayout.PREFERRED_SIZE, 315, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup().addComponent(scrollPane_3,
								GroupLayout.PREFERRED_SIZE, 1335, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(500).addComponent(btnCreData)
								.addGap(200).addComponent(btnExit)))
						.addContainerGap()));
		
		/// Các trường được nhóm theo cột dọc /// 
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_4)
								.addComponent(txtQ, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_5).addComponent(txtP, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_3).addComponent(lblNewLabel_1))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								// .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
								.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE) // )
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
								.createSequentialGroup().addGap(18).addComponent(lblBngDLiu)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(scrollPane_4, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
								.addGap(18).addComponent(lblNewLabel_6).addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 204,
										GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(10).addComponent(lblResult).addGap(15)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnCreData).addComponent(btnExit)))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		
		/// Dữ liệu được thể hiện trên bảng ///
		tblAvail = new JTable();
		tblAvail.setEnabled(false);
		tblAvail.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "", "R[1]", "R[2]", "R[3]", "R[4]", "R[5]", "R[6]", "R[7]", "R[8]", "R[9]", "R[10]" }));
		scrollPane_4.setViewportView(tblAvail);

		tblWork = new JTable();
		tblWork.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "", "R[1]", "R[2]", "R[3]", "R[4]", "R[5]", "R[6]", "R[7]", "R[8]", "R[9]", "R[10]" }));
		tblWork.setEnabled(false);
		scrollPane_3.setViewportView(tblWork);

		tblNeed = new JTable();
		tblNeed.setModel(new DefaultTableModel(new Object[][] {

		}, new String[] { "", "R[1]", "R[2]", "R[3]", "R[4]", "R[5]", "R[6]", "R[7]", "R[8]", "R[9]", "R[10]" }));
		tblNeed.setEnabled(false);
		scrollPane_2.setViewportView(tblNeed);

		tblAllo = new JTable();
		tblAllo.setEnabled(false);
		tblAllo.setModel(new DefaultTableModel(new Object[][] {

		}, new String[] { "", "R[1]", "R[2]", "R[3]", "R[4]", "R[5]", "R[6]", "R[7]", "R[8]", "R[9]", "R[10]" }));
		scrollPane_1.setViewportView(tblAllo);

		tblMax = new JTable();
		tblMax.setEnabled(false);
		tblMax.setModel(new DefaultTableModel(new Object[][] {

		}, new String[] { "", "R[1]", "R[2]", "R[3]", "R[4]", "R[5]", "R[6]", "R[7]", "R[8]", "R[9]", "R[10]" }));
		scrollPane.setViewportView(tblMax);
		contentPane.setLayout(gl_contentPane);
	}
}
