import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmSquareEquation extends JFrame {

	private JPanel contentPane;
	private JTextField textA;
	private JTextField textB;
	private JTextField textC;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmSquareEquation frame = new frmSquareEquation();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmSquareEquation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textA = new JTextField();
		textA.setBounds(10, 45, 46, 20);
		contentPane.add(textA);
		textA.setColumns(10);
		
		JLabel lblTaskName = new JLabel("Квадратное уравнение");
		lblTaskName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTaskName.setBounds(10, 11, 171, 23);
		contentPane.add(lblTaskName);
		
		JLabel lblA = new JLabel("x^2 +");
		lblA.setBounds(66, 48, 36, 14);
		contentPane.add(lblA);
		
		textB = new JTextField();
		textB.setColumns(10);
		textB.setBounds(112, 45, 46, 20);
		contentPane.add(textB);
		
		JLabel lblB = new JLabel("x +");
		lblB.setBounds(160, 48, 46, 14);
		contentPane.add(lblB);
		
		textC = new JTextField();
		textC.setColumns(10);
		textC.setBounds(184, 45, 46, 20);
		contentPane.add(textC);
		
		JLabel lblC = new JLabel("=0");
		lblC.setBounds(240, 48, 63, 14);
		contentPane.add(lblC);
		
		JLabel lblSolution = new JLabel("");
		lblSolution.setBounds(10, 141, 249, 14);
		contentPane.add(lblSolution);
		
		JButton btnNewButton = new JButton("Решить уравнение");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				double a,b,c;
				//////////////A
				try
				{
					a = Double.parseDouble(textA.getText());
				}
				catch (NumberFormatException nfe)
				{
					a = 0.0;
					textA.setText("0.0");
				}
				//////////////B
				try
				{
					b = Double.parseDouble(textB.getText());
				}
				catch (NumberFormatException nfe)
				{
					b = 0.0;
					textB.setText("0.0");
				}
				/////////////C
				try
				{
					c = Double.parseDouble(textC.getText());
				}
				catch (NumberFormatException nfe)
				{
					c = 0.0;
					textA.setText("0.0");
				}
				
				double D = b*b-4*a*c; //Дискриминант
				double x1,x2;
				String Sol = "";
				if (D<0.0)
				Sol = "Действительных корней нет";
				else if (D>0.&&a!=0.)
				{
					x1=(-b+Math.sqrt(D))/(2.*a);
					x2=(-b-Math.sqrt(D))/(2.*a);
					Sol="Корни: x1 = " + x1 + ", x2 = " + x2; 
				}
				else if (D==0.0&&a!=0.0)
				{
					x1=-b/(2.*a);
					Sol = "Корень x = " + x1; 
				}
				
				else if (a==0&&b!=0.)
				{
					x1=-c/b;
					Sol = "Корень x = " + x1; 
				}
				lblSolution.setText(Sol);
			}
		});
		
		btnNewButton.setBounds(10, 76, 148, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblL = new JLabel("Решение");
		lblL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblL.setBounds(10, 107, 171, 23);
		contentPane.add(lblL);
		
		
		
	}
}
