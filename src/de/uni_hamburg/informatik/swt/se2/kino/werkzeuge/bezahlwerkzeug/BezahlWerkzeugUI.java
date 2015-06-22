package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.bezahlwerkzeug;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Dialog.ModalityType;
import java.text.NumberFormat;

import javax.print.attribute.standard.JobName;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

public class BezahlWerkzeugUI {
	private JDialog _dialog;

	private JPanel _hauptpanel;

	private JLabel _labelZuZahlen;
	private JTextField _fieldZuZahlen;

	private JLabel _labelBezahlt;
	
	
	// Ich bin mir wegen der Form nicht so ganz sicher, aber so ist das Feld für alphanumerische Einträge
	// gespert. Sprich es dürfen nur Zahlen eingegeben werden. fgsfg
	
	private NumberFormat _format = NumberFormat.getInstance();
    private NumberFormatter _formatter = new NumberFormatter(_format);
    private JFormattedTextField _fieldBezahlt; 
    

	private JLabel _labelRestbetrag;
	private JTextField _fieldRestbetrag;

	private JPanel _buttonpanel;

	private JButton _buttonAbbrechen;
	private JButton _buttonOK;

	/**
	 * Initialisert die Oberfläche.
	 * @param preis Der zu zahlende Betrag 
	 */
	public BezahlWerkzeugUI(int preis) 
	{
		initDialog();

		initHauptpanel(preis);
		initButtonpanel();
	}

	/**
	 * Initialisiert das Fenster.
	 */
	private void initDialog() {
		_dialog = new JDialog();
		_dialog.setTitle("Bezahlvorgang");
		_dialog.setModalityType(ModalityType.APPLICATION_MODAL);
		_dialog.setBounds(150, 150, 0, 0);
		_dialog.setLayout(new BorderLayout()); // Parameter für Border-Layout???
	}

	/**
	 * Initialisiert das Hauptpanel des Fensters. In dem Hauptpanel
	 * befinden sich alle für die Funktionen wichtigen Textfelder und Labels.
	 * @param preis Der zu zahlende Betrag
	 */
	private void initHauptpanel(int preis) {
		_hauptpanel = new JPanel();
		_hauptpanel.setLayout(new GridLayout(3, 2));

		initZuZahlen(preis);
		initBezahlt();
		initRestbetrag();

		_dialog.add(_hauptpanel, BorderLayout.CENTER);
	}

	/**
	 * Initialisiert das Textfeld für den zu zahlenden Betrag und das dazugehörige Label.
	 * @param preis Der zu zahlende Betrag
	 */
	private void initZuZahlen(int preis) 
	{
		_labelZuZahlen = new JLabel("Zu zahlender Betrag: ");
		_fieldZuZahlen = new JTextField(10);
		_fieldZuZahlen.setText(Integer.toString(preis));
		_fieldZuZahlen.setEditable(false);
		_hauptpanel.add(_labelZuZahlen);
		_hauptpanel.add(_fieldZuZahlen);
	}

	/**
	 * Initialisiert das Textfeld für den bezahlten Betrag und das dazugehörige Label.
	 */
	private void initBezahlt() 
	{
		_labelBezahlt = new JLabel("Bezahlter Betrag: ");
		
		_format.setGroupingUsed(false);
		_formatter.setAllowsInvalid(false);
		_fieldBezahlt = new JFormattedTextField(_formatter);
		_hauptpanel.add(_labelBezahlt);
		_hauptpanel.add(_fieldBezahlt);
	}

	/**
	 * Initialisiert das Textfeld für den Restbetrag und das dazugehörige Label.
	 */
	private void initRestbetrag() 
	{
		_labelRestbetrag = new JLabel("Rückgeld: ");
		_fieldRestbetrag = new JTextField(10);
		_fieldRestbetrag.setEditable(false);
		_hauptpanel.add(_labelRestbetrag);
		_hauptpanel.add(_fieldRestbetrag);
	}

	/**
	 * Initialisiert das Buttonpanel des Fensters. In dem Buttonpanel
	 * befinden sich alle Buttons des Fensters.
	 */
	private void initButtonpanel() 
	{
		_buttonpanel = new JPanel();

		initButtonAbbrechen();
		initButtonOK();

		_dialog.add(_buttonpanel, BorderLayout.SOUTH);
	}

	/**
	 * Initialisiert den Abbrechen-Button.
	 */
	private void initButtonAbbrechen()
	{
		_buttonAbbrechen = new JButton("Abbrechen");
		_buttonpanel.add(_buttonAbbrechen);
	}

	/**
	 * Initialisiert den Ok-Button.
	 */
	private void initButtonOK() 
	{
		_buttonOK = new JButton("OK");
		_buttonpanel.add(_buttonOK);
	}

	/**
	 * Macht das Fenster sichtbar.
	 */
	public void zeigeFenster() 
	{
		_dialog.pack();
		_dialog.setVisible(true);
	}

	/**
	 * Schließt das Fenster.
	 */
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

	
	
	public JButton getButtonAbbrechen() {
		return _buttonAbbrechen;
	}

	public JButton getButtonOK() 
	{
		return _buttonOK;
	}

	/**
	 * Macht den Ok-Button klickbar.
	 * @param klickbar True wenn der Button angeklickt werden kann, sonst false
	 */
	public void setButtonOkKlickbar(boolean klickbar) 
	{
		_buttonOK.setEnabled(klickbar);
	}

	/**
	 * Setzt den Restbetrag.
	 * @param restbetrag Das Rückgeld
	 */
	public void setRestbetrag(int restbetrag) 
	{
		_fieldRestbetrag.setText(Integer.toString(restbetrag));
	}

	
	public int getFieldBezahltInhalt() 
	{
		return Integer.parseInt(_fieldBezahlt.getText());
	}

	/**
	  * Setzt den Cursor in das editierbare Textfeld.
	  */
	public void setFocusImTextfeld() {
		_fieldBezahlt.requestFocus();
		_fieldBezahlt.setCaretPosition(0);
	}
}
