package teste;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.AgendaDeContatosController;
import vo.ContatoVO;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JDesktopPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class AdicionarContatoView extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtDdd;
	private JTextField txtTel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
           System.err.println(ex);
        }
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdicionarContatoView frame = new AdicionarContatoView();
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
	public AdicionarContatoView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setForeground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtId = new JTextField();
		txtId.setBounds(110, 30, 38, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setBounds(110, 82, 154, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtDdd = new JTextField();
		txtDdd.setBounds(110, 125, 38, 20);
		contentPane.add(txtDdd);
		txtDdd.setColumns(10);
		
		txtTel = new JTextField();
		txtTel.setBounds(110, 172, 154, 20);
		contentPane.add(txtTel);
		txtTel.setColumns(10);
		
		JButton Salvar = new JButton("Salvar");
		Salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				/*Criar a classe de contato*/
				ContatoVO contatoVO = new ContatoVO();
				/*Popula os dados do contato*/
				int txt = Integer.parseInt(txtId.getText());
				contatoVO.setId(txt);
				contatoVO.setNome(txtNome.getText());
				contatoVO.setDdd(txtDdd.getText());
				contatoVO.setTelefone(txtTel.getText());
				/*Criar a classe controller*/
				AgendaDeContatosController agendaDeContatosController = new AgendaDeContatosController();
				/*Salva o contato no BD*/
				boolean salvou = agendaDeContatosController.salvarContato(contatoVO);
				/*Teste de asserção*/
				assertTrue(salvou);
				
			}
		});
		Salvar.setBounds(314, 228, 89, 23);
		contentPane.add(Salvar);
		
		JLabel ID = new JLabel("ID");
		ID.setHorizontalAlignment(SwingConstants.LEFT);
		ID.setBounds(10, 33, 46, 14);
		contentPane.add(ID);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(10, 85, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("DDD");
		lblNewLabel_2.setBounds(10, 128, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Telefone");
		lblNewLabel_3.setBounds(10, 175, 46, 14);
		contentPane.add(lblNewLabel_3);
	}
}
