//package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge;
//
//import java.awt.BorderLayout;
//import java.awt.FlowLayout;
//
//import javax.swing.JButton;
//import javax.swing.JDialog;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//import javax.swing.BoxLayout;
//import javax.swing.JLabel;
//import javax.swing.JTextField;
//
//public class BezahlWerkzeugUI extends JDialog
//{
//
//    private final JPanel contentPanel = new JPanel();
//    private JTextField _restbetragTextfeld;
//    private JTextField _preisTextfeld;
//    private JTextField _gezahltTextfeld;
//    private JButton _okButton;
//    private JButton _cancelButton;
//
//     
//
//    /**
//     * Create the dialog.
//     */
//    public BezahlWerkzeugUI(int preis)
//    {
//        
//        setBounds(100, 100, 450, 300);
//        getContentPane().setLayout(new BorderLayout());
//        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
//        getContentPane().add(contentPanel, BorderLayout.CENTER);
//        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
//        {
//            JPanel panel = new JPanel();
//            contentPanel.add(panel);
//            {
//                JLabel preisLabel = new JLabel("Zu Zahlen:");
//                panel.add(preisLabel);
//            }
//            {
//                _preisTextfeld = new JTextField();
//                panel.add(_preisTextfeld);
//                _preisTextfeld.setColumns(10);
//                _preisTextfeld.setText(Integer.toString(preis));
//            }
//        }
//        {
//            JPanel panel = new JPanel();
//            contentPanel.add(panel);
//            {
//                JLabel gezaltLabel = new JLabel("Bezahlt:");
//                panel.add(gezaltLabel);
//            }
//            {
//                _gezahltTextfeld = new JTextField();
//                panel.add(_gezahltTextfeld);
//                _gezahltTextfeld.setColumns(10);
//            }
//        }
//        {
//            JPanel panel = new JPanel();
//            contentPanel.add(panel);
//            panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
//            {
//                JLabel restbetragLabel = new JLabel("Restbetrag:");
//                panel.add(restbetragLabel);
//            }
//            {
//                _restbetragTextfeld = new JTextField();
//                panel.add(_restbetragTextfeld);
//                _restbetragTextfeld.setColumns(10);
//            }
//        }
//        {
//            JPanel buttonPane = new JPanel();
//            getContentPane().add(buttonPane, BorderLayout.SOUTH);
//            buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
//            {
//               _okButton = new JButton("OK");
//                _okButton.setActionCommand("OK");
//                buttonPane.add(_okButton);
//                getRootPane().setDefaultButton(_okButton);
//            }
//            {
//                _cancelButton = new JButton("Cancel");
//                _cancelButton.setActionCommand("Cancel");
//                buttonPane.add(_cancelButton);
//            }
//        }
//        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//    }
//    
//    public void zeigeFenster()
//    {
//        setVisible(true);
//    }
//    
//    public void schliesseFenster()
//    {
//       dispose(); 
//    }
//    
//    public void setOkButtonKlickbar(boolean klickbar)
//    {
//            _okButton.setEnabled(klickbar);
//    }
//    
//    public void setRestbetrag(int restbetrag)
//    {
//        _restbetragTextfeld.setText(Integer.toString(restbetrag));
//    }
//    
//    public int getGezahltTextfeldInhalt()
//    {
//        return Integer.parseInt(_gezahltTextfeld.getText());
//    }
//    
//    public JTextField getGezahltTextfeld()
//    {
//        return _gezahltTextfeld;
//    }
//    
//    public JButton getOkButton()
//    {
//        return _okButton;
//    }
//
//    public JButton getAbbrechenButton()
//    {
//        return _cancelButton;
//    }
//}
