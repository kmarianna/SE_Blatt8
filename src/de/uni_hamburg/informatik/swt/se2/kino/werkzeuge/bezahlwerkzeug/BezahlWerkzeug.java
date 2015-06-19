package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.bezahlwerkzeug;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.bezahlwerkzeug.BezahlWerkzeugUI;

/**
 * Das Bezahlwerkzeug. Mit diesem Werkzeug wird ein Fenster aufgerufen, welches den zu zahlenden Preis anzeigt.
 * Es kann ein gezahlter Betrag eingegeben werden und dann über Ok bestätigt werden, sofern der Restbetrag >= 0 ist.
 */
public class BezahlWerkzeug
{
    // UI zum Werkzeug
    private BezahlWerkzeugUI _ui;
    
    //Der zu zahlende Preis
    private final int _preis;
    
    //Gibt an, ob der Verkauf erfolgreich war
    private boolean _verkaufen;
    
    
    /**
     * Initialisiert das BezahlWerkzeug.
     * 
     * @param preis der zu zahlenden Preis für die ausgewählten Plätze
     */
    public BezahlWerkzeug(int preis)
    {
        _preis = preis;
        _ui = new BezahlWerkzeugUI(_preis);
        _ui.setRestbetrag(_preis * -1);
        _ui.setButtonOkKlickbar(false);
        registriereUIAktion();
        _ui.zeigeFenster();
        _ui.setFocusImTextfeld();
    }
    
    /**
     * Prüft, ob der gezahlte Betrag ausreichend ist.
     * 
     * @return true, wenn restbetrag >= 0
     * 
     * @ensure return != null
     */
    private boolean istRestbetragAusreichend(int restbetrag)
    {
        return restbetrag >= 0;
    }
    
    /**
     * Errechnet den Restbetrag
     * 
     * @param preis zu zahlender Preis
     * @param zahlung eingegebene Zahlung
     * 
     * @return restbetrag
     */
    private int berechneRestbetrag(int preis, int zahlung)
    {
        return (zahlung - preis);
    }
    
    /**
     * Erzeugt und registriert die Beobachter, die die UI Elemente beobachten.
     */
    private void registriereUIAktion()
    {
        _ui.getButtonOK().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                zahlungAktzeptieren();
            }
        });
        
        _ui.getButtonAbbrechen().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                zahlungAbbrechen();
            }
        });
        
        _ui.getFieldBezahlt().addActionListener(new ActionListener()
        {
           @Override
           public void actionPerformed(ActionEvent e)
           {
               aktualisiereRestbetrag();
           }
        });
    }
    
    /**
     * Schreibt den aktuellen Restbetrag in das GUI Fenster
     */
    private void aktualisiereRestbetrag()
    {
        int restbetrag = berechneRestbetrag(_preis, _ui.getFieldBezahltInhalt());
        
        _ui.setRestbetrag(restbetrag);
        _ui.setButtonOkKlickbar(istRestbetragAusreichend(restbetrag));
    }
    
    /**
     * schließt das GUI Fenster und markiert den Bezahlvorgang als erfolgreich.
     */
    private void zahlungAktzeptieren()
    {
        _ui.schliesseFenster();
        _verkaufen = true;
    }
    
    /**
     * schließt das GUI Fenster und markiert den Bezahlvorgang als gescheitert.
     */
    private void zahlungAbbrechen()
    {
        _ui.schliesseFenster();
        _verkaufen = false;
    }
    
    /**
     * liefert einen boolschen Wert, ob der Bezahlvorgang erfolgreich war
     * 
     * @return true, wenn Bezahlvorgang erfolgreich.
     */
    public boolean getVerkauf()
    {
//        boolean result = _verkaufen;
        return _verkaufen;
    }
}

