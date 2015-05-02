package test;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dialogomvc.JDialogMVC;

public class DialogoAlgo extends JDialogMVC<ControladorDialogoAlgo,ModeloDialogoAlgo>{

	private static final long serialVersionUID = -4674431693216225783L;

	public DialogoAlgo(Frame padre,final ControladorDialogoAlgo controlador, ModeloDialogoAlgo modelo) {
		super(padre, controlador,modelo);
		setSize(300, 300);
		JPanel pnl = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JButton b = new JButton("Clickkkk");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.aumentarContador();
			}
		});
		pnl.add(b);
		add(pnl,BorderLayout.CENTER);
	}

	@Override
	public void update(Observable o, Object arg) {
		JOptionPane.showMessageDialog(null, getModelo().getContador());
	}
}
