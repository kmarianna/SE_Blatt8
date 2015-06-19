package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.bezahlwerkzeug;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Dialog.ModalityType;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BezahlWerkzeugUI {
	private JDialog _dialog; 

	private JPanel _hauptpanel;

	private JLabel _labelZuZahlen;
	private JTextField _fieldZuZahlen;

	private JLabel _labelBezahlt;
	private JTextField _fieldBezahlt;

	private JLabel _labelRestbetrag;
	private JTextField _fieldRestbetrag;

	private JPanel _buttonpanel;

	private JButton _buttonAbbrechen;
	private JButton _buttonOK;
	

	/**
	 * KONSTRUKTOR-KOMMENTAR: BLABLABLA
	 */
	public BezahlWerkzeugUI(int preis) 
	{
		initDialog();

		initHauptpanel(preis);
		initButtonpanel();
	}

	private void initDialog() 
	{
		_dialog = new JDialog(); 
		_dialog.setTitle("Bezahlvorgang");
		_dialog.setModalityType(ModalityType.APPLICATION_MODAL);
		_dialog.setBounds(150, 150, 0, 0);
		_dialog.setLayout(new BorderLayout()); // Parameter für Border-Layout???
	}

	private void initHauptpanel(int preis) 
	{
		_hauptpanel = new JPanel();
		_hauptpanel.setLayout(new GridLayout(3, 2));

		initZuZahlen(preis);
		initBezahlt();
		initRestbetrag();

		_dialog.add(_hauptpanel, BorderLayout.CENTER);
	}

	private void initZuZahlen(int preis) 
	{
		_labelZuZahlen = new JLabel("Zu zahlender Betrag: ");
		_fieldZuZahlen = new JTextField(10);
		_fieldZuZahlen.setText(Integer.toString(preis));
		_fieldZuZahlen.setEditable(false);
		_hauptpanel.add(_labelZuZahlen);
		_hauptpanel.add(_fieldZuZahlen);
		
	}

	private void initBezahlt() 
	{
		_labelBezahlt = new JLabel("Bezahlter Betrag: ");
		_fieldBezahlt = new JTextField(10);
		_hauptpanel.add(_labelBezahlt);
		_hauptpanel.add(_fieldBezahlt);

	}

	private void initRestbetrag() 
	{
		_labelRestbetrag = new JLabel("Rückgeld: ");
		_fieldRestbetrag = new JTextField(10);
		_fieldRestbetrag.setEditable(false);
		_hauptpanel.add(_labelRestbetrag);
		_hauptpanel.add(_fieldRestbetrag);
	}

	private void initButtonpanel() 
	{
		_buttonpanel = new JPanel();

		initButtonAbbrechen();
		initButtonOK();

		_dialog.add(_buttonpanel, BorderLayout.SOUTH);
	}

	private void initButtonAbbrechen() 
	{
		_buttonAbbrechen = new JButton("Abbrechen");
		_buttonpanel.add(_buttonAbbrechen);
	}

	private void initButtonOK() 
	{
		_buttonOK = new JButton("OK");
		_buttonpanel.add(_buttonOK);
	}

	public void zeigeFenster() 
	{
		_dialog.pack();
		_dialog.setVisible(true);
	}

	public void schliesseFenster() 
	{
		_dialog.dispose();
	}

	public JTextField getFieldZuZahlen() 
	{
		return _fieldZuZahlen;
	}

	public JTextField getFieldBezahlt() 
	{
		return _fieldBezahlt;
	}

	public JTextField getFieldRestbetrag() 
	{
		return _fieldRestbetrag;
	}

	public JButton getButtonAbbrechen() 
	{
		return _buttonAbbrechen;
	}

	public JButton getButtonOK() 
	{
		return _buttonOK;
	}

	public void setButtonOkKlickbar(boolean klickbar) 
	{
		_buttonOK.setEnabled(klickbar);
	}
	
	 public void setRestbetrag(int restbetrag)
	 {
	 _fieldRestbetrag.setText(Integer.toString(restbetrag));
	 }
	
	 public int getFieldBezahltInhalt()
	 {
	 return Integer.parseInt(_fieldBezahlt.getText());
	 }
	 
	 public void setFocusImTextfeld()
	 {
		 _fieldBezahlt.requestFocus();
		 _fieldBezahlt.setCaretPosition(0);
	 }
}
