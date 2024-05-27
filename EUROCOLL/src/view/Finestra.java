package view;

import model.Catalogo;
import model.Moneta;
import model.MonetaCommemorativa;
import model.Utente;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class Finestra extends JFrame{
    private JPanel pannello1;
    private JPanel pannello2;
    private Utente utente;
    private Catalogo catalogo;
    public Finestra(boolean accesso,Utente utente,Catalogo catalogo){
        super("EUROCOLL");
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(Finestra.class.getResource("assets" + File.separator + "euro.png")));
        this.setIconImage(icon.getImage());
        this.utente=utente;
        this.catalogo=catalogo;
        Container c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(204, 229, 255));
        this.pannello1=this.primaSchermata(accesso);
        c.add(this.pannello1);
        this.setSize(new Dimension(1100,600));
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                synchronized (Finestra.this) {
                    Finestra.this.notify();
                }
            }
        });
    }
    public Finestra(){
        this(false,null,null);
    }
    public final Catalogo getCatalogo() {
        return this.catalogo;
    }
    public final Utente getUtente(){
        return this.utente;
    }
    public void cambiaPagina(JPanel paginaSuccessiva){
        if(this.pannello1==null){
            this.pannello1=paginaSuccessiva;
            this.getContentPane().add(this.pannello1);
            this.pannello2.setVisible(false);
            this.pannello1.setVisible(true);
            this.pannello2=null;
        }
        else{
            this.pannello2=paginaSuccessiva;
            this.getContentPane().add(this.pannello2);
            this.pannello1.setVisible(false);
            this.pannello2.setVisible(true);
            this.pannello1=null;
        }
    }

    //SCHERMATE SOFTWARE
    public JPanel primaSchermata(boolean accesso){
        JPanel pannelloPreRegistrazione = new JPanel();
        pannelloPreRegistrazione.setLayout(null);
        pannelloPreRegistrazione.setBounds(10, 10, 1060, 540);
        pannelloPreRegistrazione.setBackground(new Color(204, 229, 255));

        //nome
        JLabel label = new JLabel("EUROCOLL");
        label.setBounds(330,50,400,100);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 48));
        label.setForeground(new Color(30, 144, 255));
        pannelloPreRegistrazione.add(label);

        //immagine
        ImageIcon imageIcon = new ImageIcon(Objects.requireNonNull(Finestra.class.getResource("assets" + File.separator + "euro.png")));
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(330, 180, 400, 200);
        pannelloPreRegistrazione.add(imageLabel);

        //bottone
        JButton button;
        if(accesso){
            button = new JButton("Accedi");
            button.setToolTipText("Bentornato, clicca per accedere.");

        }
        else{
            button = new JButton("Registrati");
            button.setToolTipText("Benvenuto, clicca per registrarti.");
        }
        button.setFont(new Font("Arial", Font.PLAIN, 24));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(30, 144, 255));
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setBounds(430,450,200,40);
        button.addActionListener(e -> {
            this.cambiaPagina(this.secondaSchermata(accesso));
        });
        pannelloPreRegistrazione.add(button);
        return pannelloPreRegistrazione;
    }

    public JPanel secondaSchermata(boolean accesso){
        JPanel pannelloPreRegistrazione = new JPanel();
        pannelloPreRegistrazione.setLayout(null);
        pannelloPreRegistrazione.setBounds(10, 10, 1060, 540);
        pannelloPreRegistrazione.setBackground(new Color(204, 229, 255));

        //accesso-registrati
        JLabel label;
        if(accesso){
            label = new JLabel("ACCESSO");
        }
        else{
            label = new JLabel("REGISTRAZIONE");
        }
        label.setBounds(330,70,400,100);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 48));
        label.setForeground(new Color(30, 144, 255));
        pannelloPreRegistrazione.add(label);

        // Label e campo di testo per il nickname
        JLabel nicknameLabel = new JLabel("Nickname:");
        nicknameLabel.setBounds(400, 220, 100, 30);
        pannelloPreRegistrazione.add(nicknameLabel);

        JTextField nicknameField = new JTextField();
        nicknameField.setBounds(510, 220, 200, 30);
        pannelloPreRegistrazione.add(nicknameField);

        // Label e campo di testo per la password
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(400, 320, 100, 30);
        pannelloPreRegistrazione.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(510, 320, 200, 30);
        pannelloPreRegistrazione.add(passwordField);

        // Bottone
        JButton button;
        if (accesso) {
            button = new JButton("Accedi");
            button.setToolTipText("Clicca per accedere.");
        } else {
            button = new JButton("Registrati");
            button.setToolTipText("Clicca per registrarti.");
        }
        button.setFont(new Font("Arial", Font.PLAIN, 24));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(30, 144, 255));
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setBounds(430, 420, 200, 40);
        button.addActionListener(e -> {
            if(accesso){
                if(this.utente.checkUtente(nicknameField.getText(),new String(passwordField.getPassword()))){
                    this.cambiaPagina(this.schermataScelta());
                }
                else{
                    JOptionPane.showMessageDialog(
                            null,
                            "Il nickname o la password inserita è scorretta.\nRiprova!",
                            "Errore d'accesso",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
            else{
                if(nicknameField.getText().length() >=4 && new String(passwordField.getPassword()).length() >=4){
                    this.utente = new Utente(nicknameField.getText(),new String(passwordField.getPassword()));
                    this.catalogo = new Catalogo();
                    JOptionPane.showMessageDialog(
                            null,
                            "Registrazione avvenuta con successo! \nAccedi da ora in poi sempre con queste credenziali.",
                            "Registrazione completata",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    this.cambiaPagina(this.schermataScelta());
                }
                else{
                    JOptionPane.showMessageDialog(
                            null,
                            "Il nickname e la password inserite devono essere almeno lunghe quattro caratteri.\nRiprova!",
                            "Errore",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });
        pannelloPreRegistrazione.add(button);


        return pannelloPreRegistrazione;
    }

    public JPanel schermataScelta(){
        JPanel pannelloSchermataScelta = new JPanel();
        pannelloSchermataScelta.setLayout(null);
        pannelloSchermataScelta.setBounds(10, 10, 1060, 540);
        pannelloSchermataScelta.setBackground(new Color(204, 229, 255));

        Border bordoBlu = BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLUE, 2),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        );

        // Primo JPanel
        JPanel primoPanello = new JPanel();
        primoPanello.setLayout(null);
        primoPanello.setBounds(280, 50, 500, 200);
        primoPanello.setBackground(Color.WHITE);
        primoPanello.setBorder(bordoBlu);

        JLabel labelVisualizza = new JLabel("VISUALIZZA O AGGIORNA LA TUA COLLEZIONE");
        labelVisualizza.setBounds(50, 10, 400, 30);
        labelVisualizza.setVerticalAlignment(SwingConstants.CENTER);
        labelVisualizza.setHorizontalAlignment(SwingConstants.CENTER);
        labelVisualizza.setFont(new Font("Arial", Font.BOLD, 14));
        labelVisualizza.setForeground(new Color(30, 144, 255));
        primoPanello.add(labelVisualizza);

        ImageIcon imageVisualizza = new ImageIcon(Objects.requireNonNull(Finestra.class.getResource("assets" + File.separator + "occhio.png")));
        JLabel imageLabelVisualizza = new JLabel(imageVisualizza);
        imageLabelVisualizza.setBounds(150, 45, 200, 150);
        primoPanello.add(imageLabelVisualizza);

        primoPanello.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cambiaPagina(sceltaVisita());
            }
        });
        pannelloSchermataScelta.add(primoPanello);

        // Secondo JPanel
        JPanel secondoPanello = new JPanel();
        secondoPanello.setLayout(null);
        secondoPanello.setBounds(280, 300, 500, 200);
        secondoPanello.setBackground(Color.WHITE);
        secondoPanello.setBorder(bordoBlu);

        JLabel labelInserisci = new JLabel("INSERISCI UNA NUOVA MONETA AL CATALOGO");
        labelInserisci.setBounds(50, 10, 400, 30);
        labelInserisci.setVerticalAlignment(SwingConstants.CENTER);
        labelInserisci.setHorizontalAlignment(SwingConstants.CENTER);
        labelInserisci.setFont(new Font("Arial", Font.BOLD, 14));
        labelInserisci.setForeground(new Color(30, 144, 255));
        secondoPanello.add(labelInserisci);

        ImageIcon imageInserisci = new ImageIcon(Objects.requireNonNull(Finestra.class.getResource("assets" + File.separator + "piu.png")));
        JLabel imageLabelInserisci = new JLabel(imageInserisci);
        imageLabelInserisci.setBounds(190, 55, 120, 120);
        secondoPanello.add(imageLabelInserisci);

        secondoPanello.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cambiaPagina(schermataAggiungiMoneta());
            }
        });

        pannelloSchermataScelta.add(secondoPanello);

        return pannelloSchermataScelta;
    }

    public JPanel sceltaVisita(){
        JPanel pannellosceltaVisita = new JPanel();
        pannellosceltaVisita.setLayout(null);
        pannellosceltaVisita.setBounds(10, 10, 1060, 540);
        pannellosceltaVisita.setBackground(new Color(204, 229, 255));

        Border bordoBlu = BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLUE, 2),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        );

        //Torna indietro
        JLabel indietro = new JLabel("<");
        indietro.setBounds(15,15,30,30);
        indietro.setHorizontalAlignment(SwingConstants.CENTER);
        indietro.setVerticalAlignment(SwingConstants.CENTER);
        indietro.setFont(new Font("Arial", Font.BOLD, 26));
        indietro.setForeground(new Color(30, 144, 255));
        indietro.setToolTipText("Torna indietro");
        indietro.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cambiaPagina(schermataScelta());
            }
        });
        pannellosceltaVisita.add(indietro);

        //Primo JPanel
        JPanel pannelloDivisionale = new JPanel();
        pannelloDivisionale.setLayout(null);
        pannelloDivisionale.setBounds(280, 25, 500, 150);
        pannelloDivisionale.setBackground(Color.WHITE);
        pannelloDivisionale.setBorder(bordoBlu);

        JLabel labelDivisionale = new JLabel("DIVISIONALI");
        labelDivisionale.setBounds(20,20,200,50);
        labelDivisionale.setVerticalAlignment(SwingConstants.CENTER);
        labelDivisionale.setHorizontalAlignment(SwingConstants.LEFT);
        labelDivisionale.setFont(new Font("Arial", Font.BOLD, 23));
        labelDivisionale.setForeground(new Color(30, 144, 255));
        pannelloDivisionale.add(labelDivisionale);

        JLabel labelcontaDivisionale = new JLabel(this.utente.numeroDivisionaliCollezionate() + "/" + this.catalogo.numeroDivisionali());
        labelcontaDivisionale.setBounds(35,65,100,30);
        labelcontaDivisionale.setVerticalAlignment(SwingConstants.CENTER);
        labelcontaDivisionale.setHorizontalAlignment(SwingConstants.LEFT);
        labelcontaDivisionale.setFont(new Font("Arial", Font.BOLD, 12));
        labelcontaDivisionale.setForeground(new Color(30, 144, 255));
        pannelloDivisionale.add(labelcontaDivisionale);

        JLabel labeltotaleDivisionale = new JLabel("€" + String.format("%.2f",this.utente.totaleValoreDivisionaliCollezionate()) + "/" + String.format("%.2f",this.catalogo.totaleValoreDivisionali()));
        labeltotaleDivisionale.setBounds(35,85,100,30);
        labeltotaleDivisionale.setVerticalAlignment(SwingConstants.CENTER);
        labeltotaleDivisionale.setHorizontalAlignment(SwingConstants.LEFT);
        labeltotaleDivisionale.setFont(new Font("Arial", Font.BOLD, 12));
        labeltotaleDivisionale.setForeground(new Color(30, 144, 255));
        pannelloDivisionale.add(labeltotaleDivisionale);

        ImageIcon imageDivisionale = new ImageIcon(Objects.requireNonNull(Finestra.class.getResource("assets" + File.separator + "divisionali.png")));
        JLabel imageLabelDivisionale = new JLabel();
        imageLabelDivisionale.setBounds(300, 10, 130, 130);
        imageLabelDivisionale.setIcon(imageDivisionale);
        Image image1 = imageDivisionale.getImage().getScaledInstance(130, 130, Image.SCALE_SMOOTH);
        imageDivisionale.setImage(image1);
        pannelloDivisionale.add(imageLabelDivisionale);

        pannelloDivisionale.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cambiaPagina(sceltaTaglioDivisionale());
            }
        });

        pannellosceltaVisita.add(pannelloDivisionale);

        //Secondo JPanel
        JPanel pannelloCommemorative = new JPanel();
        pannelloCommemorative.setLayout(null);
        pannelloCommemorative.setBounds(280, 195, 500, 150);
        pannelloCommemorative.setBackground(Color.WHITE);
        pannelloCommemorative.setBorder(bordoBlu);

        JLabel labelCommemorativa = new JLabel("COMMEMORATIVE");
        labelCommemorativa.setBounds(20,20,220,50);
        labelCommemorativa.setVerticalAlignment(SwingConstants.CENTER);
        labelCommemorativa.setHorizontalAlignment(SwingConstants.LEFT);
        labelCommemorativa.setFont(new Font("Arial", Font.BOLD, 23));
        labelCommemorativa.setForeground(new Color(30, 144, 255));
        pannelloCommemorative.add(labelCommemorativa);

        JLabel labelcontaCommemorative = new JLabel(this.utente.numeroCommemorativeCollezionate() + "/" + this.catalogo.numeroCommemorative());
        labelcontaCommemorative.setBounds(35,65,100,30);
        labelcontaCommemorative.setVerticalAlignment(SwingConstants.CENTER);
        labelcontaCommemorative.setHorizontalAlignment(SwingConstants.LEFT);
        labelcontaCommemorative.setFont(new Font("Arial", Font.BOLD, 12));
        labelcontaCommemorative.setForeground(new Color(30, 144, 255));
        pannelloCommemorative.add(labelcontaCommemorative);

        JLabel labeltotaleCommemorative = new JLabel("€" + String.format("%.2f",this.utente.totaleValoreCommemorativeCollezionate()) + "/" + String.format("%.2f",this.catalogo.totaleValoreCommemorative()));
        labeltotaleCommemorative.setBounds(35,85,100,30);
        labeltotaleCommemorative.setVerticalAlignment(SwingConstants.CENTER);
        labeltotaleCommemorative.setHorizontalAlignment(SwingConstants.LEFT);
        labeltotaleCommemorative.setFont(new Font("Arial", Font.BOLD, 12));
        labeltotaleCommemorative.setForeground(new Color(30, 144, 255));
        pannelloCommemorative.add(labeltotaleCommemorative);

        ImageIcon imageCommemorativa = new ImageIcon(Objects.requireNonNull(Finestra.class.getResource("assets" + File.separator + "commemorative.png")));
        JLabel imageLabelCommemorativa = new JLabel();
        imageLabelCommemorativa.setBounds(300, 10, 150, 130);
        imageLabelCommemorativa.setIcon(imageCommemorativa);
        Image image2 = imageCommemorativa.getImage().getScaledInstance(130, 130, Image.SCALE_SMOOTH);
        imageCommemorativa.setImage(image2);
        pannelloCommemorative.add(imageLabelCommemorativa);

        pannelloCommemorative.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cambiaPagina(sceltaCommemorativa());
            }
        });

        pannellosceltaVisita.add(pannelloCommemorative);

        //Terzo JPanel
        JPanel pannelloStatistiche = new JPanel();
        pannelloStatistiche.setLayout(null);
        pannelloStatistiche.setBounds(280, 365, 500, 150);
        pannelloStatistiche.setBackground(Color.WHITE);
        pannelloStatistiche.setBorder(bordoBlu);

        JLabel labelStatistiche = new JLabel("STATISTICHE");
        labelStatistiche.setBounds(20,20,180,50);
        labelStatistiche.setVerticalAlignment(SwingConstants.CENTER);
        labelStatistiche.setHorizontalAlignment(SwingConstants.LEFT);
        labelStatistiche.setFont(new Font("Arial", Font.BOLD, 23));
        labelStatistiche.setForeground(new Color(30, 144, 255));
        pannelloStatistiche.add(labelStatistiche);

        JLabel labelcontaTotale = new JLabel((this.utente.numeroCommemorativeCollezionate() + this.utente.numeroDivisionaliCollezionate()) + "/" + (this.catalogo.numeroCommemorative() + this.catalogo.numeroDivisionali()));
        labelcontaTotale.setBounds(35,65,100,30);
        labelcontaTotale.setVerticalAlignment(SwingConstants.CENTER);
        labelcontaTotale.setHorizontalAlignment(SwingConstants.LEFT);
        labelcontaTotale.setFont(new Font("Arial", Font.BOLD, 12));
        labelcontaTotale.setForeground(new Color(30, 144, 255));
        pannelloStatistiche.add(labelcontaTotale);

        JLabel labeltotaleTotale = new JLabel("€" + String.format("%.2f",this.utente.totaleValoreCommemorativeCollezionate() + this.utente.totaleValoreDivisionaliCollezionate()) + "/" + String.format("%.2f",this.catalogo.totaleValoreCommemorative()+this.catalogo.totaleValoreDivisionali()));
        labeltotaleTotale.setBounds(35,85,100,30);
        labeltotaleTotale.setVerticalAlignment(SwingConstants.CENTER);
        labeltotaleTotale.setHorizontalAlignment(SwingConstants.LEFT);
        labeltotaleTotale.setFont(new Font("Arial", Font.BOLD, 12));
        labeltotaleTotale.setForeground(new Color(30, 144, 255));
        pannelloStatistiche.add(labeltotaleTotale);

        ImageIcon imageStatistiche = new ImageIcon(Objects.requireNonNull(Finestra.class.getResource("assets" + File.separator + "statistica.png")));
        JLabel imageLabelStatistiche = new JLabel();
        imageLabelStatistiche.setBounds(300, 10, 130, 130);
        imageLabelStatistiche.setIcon(imageStatistiche);
        Image image3 = imageStatistiche.getImage().getScaledInstance(130, 130, Image.SCALE_SMOOTH);
        imageStatistiche.setImage(image3);
        pannelloStatistiche.add(imageLabelStatistiche);

        pannelloStatistiche.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cambiaPagina(schermataStatistiche());
            }
        });

        pannellosceltaVisita.add(pannelloStatistiche);

        return pannellosceltaVisita;
    }

    public JPanel schermataStatistiche(){
        JPanel pannelloStatistiche = new JPanel();
        pannelloStatistiche.setLayout(null);
        pannelloStatistiche.setBounds(10, 10, 1060, 540);
        pannelloStatistiche.setBackground(new Color(204, 229, 255));

        Border bordoNero = BorderFactory.createLineBorder(Color.BLACK, 2);

        //Torna indietro
        JLabel indietro = new JLabel("<");
        indietro.setBounds(15,15,30,30);
        indietro.setHorizontalAlignment(SwingConstants.CENTER);
        indietro.setVerticalAlignment(SwingConstants.CENTER);
        indietro.setFont(new Font("Arial", Font.BOLD, 26));
        indietro.setForeground(new Color(30, 144, 255));
        indietro.setToolTipText("Torna indietro");
        indietro.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cambiaPagina(schermataScelta());
            }
        });
        pannelloStatistiche.add(indietro);

        //pannello bianco
        JPanel contenuto = new JPanel();
        contenuto.setLayout(null);
        contenuto.setBounds(200,30,660 ,480 );
        contenuto.setBackground(Color.WHITE);
        contenuto.setBorder(bordoNero);

        //Titolo
        JLabel labelTitolo = new JLabel("STATISTICA PER TAGLIO");
        labelTitolo.setBounds(0,20,660,30);
        labelTitolo.setVerticalAlignment(SwingConstants.CENTER);
        labelTitolo.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitolo.setFont(new Font("Arial", Font.BOLD, 20));
        labelTitolo.setForeground(Color.BLACK);
        contenuto.add(labelTitolo);

        //Statistica per ogni taglio
        Moneta.Taglio[] tagli = Moneta.Taglio.values();
        int[] boundsx = {20,180,340,500,20,180,340,500};
        int[] boundsy = {85,85,85,85,275,275,275,275};
        for(int i = 0; i < tagli.length; i++){
            JPanel pan = new JPanel();
            pan.setLayout(null);
            pan.setBackground(Color.WHITE);
            pan.setBounds(boundsx[i],boundsy[i],140,140);
            pan.setBorder(bordoNero);

            //Titolo
            JLabel labelValore = new JLabel("€" + String.format("%.2f", tagli[i].getValore()));
            labelValore.setBounds(0,4,140,10);
            labelValore.setVerticalAlignment(SwingConstants.CENTER);
            labelValore.setHorizontalAlignment(SwingConstants.CENTER);
            labelValore.setFont(new Font("Arial", Font.BOLD, 10));
            labelValore.setForeground(Color.BLACK);
            pan.add(labelValore);

            //Immagine
            ImageIcon imageDivisionale = new ImageIcon(Objects.requireNonNull(Finestra.class.getResource("assets" + File.separator + "divisionali" + File.separator + tagli[i].getPathImage())));
            JLabel imageLabelDivisionale = new JLabel();
            imageLabelDivisionale.setBounds(25,16,90,90);
            imageLabelDivisionale.setIcon(imageDivisionale);
            Image image = imageDivisionale.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
            imageDivisionale.setImage(image);
            pan.add(imageLabelDivisionale);

            //Striscia
            JPanel striscia = new JPanel();
            striscia.setLayout(null);
            striscia.setBounds(30,109,80,12);
            striscia.setBackground(Color.WHITE);
            striscia.setBorder(bordoNero);

            JPanel strisciaColorata = new JPanel();
            strisciaColorata.setBackground(Color.GREEN);
            strisciaColorata.setBounds(2,2, (int) ((76*this.utente.numeroMonetePerTaglioCollezionate(tagli[i]))/(this.catalogo.numeroMonetePerTaglio(tagli[i]))),8);
            striscia.add(strisciaColorata);

            pan.add(striscia);

            //tot/tot
            JLabel labelCollezionateSuPresenti = new JLabel(this.utente.numeroMonetePerTaglioCollezionate(tagli[i]) + "/" + this.catalogo.numeroMonetePerTaglio(tagli[i]));
            labelCollezionateSuPresenti.setBounds(0,126,140,12);
            labelCollezionateSuPresenti.setVerticalAlignment(SwingConstants.CENTER);
            labelCollezionateSuPresenti.setHorizontalAlignment(SwingConstants.CENTER);
            labelCollezionateSuPresenti.setFont(new Font("Arial", Font.BOLD, 10));
            labelCollezionateSuPresenti.setForeground(Color.BLACK);
            pan.add(labelCollezionateSuPresenti);

            contenuto.add(pan);
        }

        pannelloStatistiche.add(contenuto);

        return pannelloStatistiche;
    }

    public JPanel schermataAggiungiMoneta(){
        JPanel pannelloAggiuntaMoneta = new JPanel();
        pannelloAggiuntaMoneta.setLayout(null);
        pannelloAggiuntaMoneta.setBounds(10, 10, 1060, 540);
        pannelloAggiuntaMoneta.setBackground(new Color(204, 229, 255));

        //Torna indietro
        JLabel indietro = new JLabel("<");
        indietro.setBounds(15,15,30,30);
        indietro.setHorizontalAlignment(SwingConstants.CENTER);
        indietro.setVerticalAlignment(SwingConstants.CENTER);
        indietro.setFont(new Font("Arial", Font.BOLD, 26));
        indietro.setForeground(new Color(30, 144, 255));
        indietro.setToolTipText("Torna indietro");
        indietro.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cambiaPagina(schermataScelta());
            }
        });
        pannelloAggiuntaMoneta.add(indietro);

        //Titolo
        JLabel labelTitolo = new JLabel("AGGIUNGI UNA NUOVA MONETA");
        labelTitolo.setBounds(100,50,860,100);
        labelTitolo.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitolo.setFont(new Font("Arial", Font.BOLD, 35));
        labelTitolo.setForeground(new Color(30, 144, 255));
        pannelloAggiuntaMoneta.add(labelTitolo);

        //pannello aggiunta divisionale
        JPanel pannelloDivisionale = new JPanel();
        pannelloDivisionale.setLayout(null);
        pannelloDivisionale.setBackground(new Color(204, 229, 255));
        pannelloDivisionale.setBounds(230,200,600,400);

        JLabel annoDivisionale = new JLabel("Anno:");
        annoDivisionale.setVerticalAlignment(SwingConstants.CENTER);
        annoDivisionale.setHorizontalAlignment(SwingConstants.RIGHT);
        annoDivisionale.setFont(new Font("Arial", Font.BOLD, 15));
        annoDivisionale.setBounds(0, 20, 280, 40);
        pannelloDivisionale.add(annoDivisionale);

        JTextField inserisciAnnoDivisionale = new JTextField();
        inserisciAnnoDivisionale.setBounds(320, 25, 70, 30);
        pannelloDivisionale.add(inserisciAnnoDivisionale);

        JLabel taglio = new JLabel("Taglio:");
        taglio.setVerticalAlignment(SwingConstants.CENTER);
        taglio.setHorizontalAlignment(SwingConstants.RIGHT);
        taglio.setFont(new Font("Arial", Font.BOLD, 15));
        taglio.setBounds(0, 80, 280, 40);
        pannelloDivisionale.add(taglio);

        JComboBox<Moneta.Taglio> taglioComboBox = new JComboBox<>(Moneta.Taglio.values());
        taglioComboBox.setBounds(320, 85, 190, 30);

        pannelloDivisionale.add(taglioComboBox);

        JButton aggiungiDivisionale = new JButton("AGGIUNGI DIVISIONALE");
        aggiungiDivisionale.setToolTipText("Clicca per aggiungere una nuova divisionale al catalogo.");
        aggiungiDivisionale.setFont(new Font("Arial", Font.PLAIN, 15));
        aggiungiDivisionale.setForeground(Color.WHITE);
        aggiungiDivisionale.setBackground(new Color(30, 144, 255));
        aggiungiDivisionale.setBorderPainted(false);
        aggiungiDivisionale.setFocusPainted(false);
        aggiungiDivisionale.setBounds(200, 170, 200, 40);
        aggiungiDivisionale.addActionListener(e -> {
            if(! inserisciAnnoDivisionale.getText().matches("\\d{4}")){
                JOptionPane.showMessageDialog(
                        null,
                        "L'anno è stato specificato scorrettamente.\nRiprova!",
                        "Errore anno",
                        JOptionPane.ERROR_MESSAGE
                );
            }
            else{
                Moneta.Taglio taglioSelezionato = (Moneta.Taglio) taglioComboBox.getSelectedItem();
                if(taglioSelezionato == null){
                    JOptionPane.showMessageDialog(
                            null,
                            "Seleziona almeno un taglio di moneta.",
                            "Errore taglio",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
                else{
                    int annataAttesa = this.catalogo.annataPiuRecentePerTaglioDivisionale(taglioSelezionato) + 1;
                    int annataInserita = Integer.parseInt(inserisciAnnoDivisionale.getText());
                    if(annataAttesa != annataInserita){
                        JOptionPane.showMessageDialog(
                                null,
                                "Inserisci prima l'anno " + annataAttesa,
                                "Errore anno",
                                JOptionPane.ERROR_MESSAGE
                        );
                    }
                    else{
                        this.catalogo.aggiungiMonetaDivisionaleAlCatalogo(new Moneta(annataInserita,taglioSelezionato));
                        JOptionPane.showMessageDialog(
                                null,
                                "La moneta è stata inserita con successo al catalogo!",
                                "Moneta inserita",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                    }
                }
            }
        });

        pannelloDivisionale.add(aggiungiDivisionale);

        pannelloAggiuntaMoneta.add(pannelloDivisionale);

        //pannello aggiunta commemorativa
        JPanel pannelloCommemorativo = new JPanel();
        pannelloCommemorativo.setLayout(null);
        pannelloCommemorativo.setBackground(new Color(204, 229, 255));
        pannelloCommemorativo.setVisible(false);
        pannelloCommemorativo.setBounds(230,200,600,400);

        JLabel annoCommemorativa = new JLabel("Anno:");
        annoCommemorativa.setVerticalAlignment(SwingConstants.CENTER);
        annoCommemorativa.setHorizontalAlignment(SwingConstants.RIGHT);
        annoCommemorativa.setFont(new Font("Arial", Font.BOLD, 15));
        annoCommemorativa.setBounds(0, 20, 280, 40);
        pannelloCommemorativo.add(annoCommemorativa);

        JTextField inserisciAnnoCommemorativa = new JTextField();
        inserisciAnnoCommemorativa.setBounds(320, 30, 70, 30);
        pannelloCommemorativo.add(inserisciAnnoCommemorativa);

        JLabel nomeCommemorativa = new JLabel("Nome:");
        nomeCommemorativa.setVerticalAlignment(SwingConstants.CENTER);
        nomeCommemorativa.setHorizontalAlignment(SwingConstants.RIGHT);
        nomeCommemorativa.setFont(new Font("Arial", Font.BOLD, 15));
        nomeCommemorativa.setBounds(0, 80, 280, 40);
        pannelloCommemorativo.add(nomeCommemorativa);

        JTextField inserisciNomeCommemorativa = new JTextField();
        inserisciNomeCommemorativa.setBounds(320, 90, 250, 30);
        pannelloCommemorativo.add(inserisciNomeCommemorativa);

        JLabel descrizioneCommemorativa = new JLabel("Descrizione:");
        descrizioneCommemorativa.setVerticalAlignment(SwingConstants.CENTER);
        descrizioneCommemorativa.setHorizontalAlignment(SwingConstants.RIGHT);
        descrizioneCommemorativa.setFont(new Font("Arial", Font.BOLD, 15));
        descrizioneCommemorativa.setBounds(0, 140, 280, 40);
        pannelloCommemorativo.add(descrizioneCommemorativa);

        JTextArea inserisciDescrizioneCommemorativa = new JTextArea();
        inserisciDescrizioneCommemorativa.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(inserisciDescrizioneCommemorativa);
        scrollPane.setBounds(320, 150, 250, 60);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        pannelloCommemorativo.add(scrollPane);

        JLabel pathImmagine = new JLabel("Path immagine:");
        pathImmagine.setVerticalAlignment(SwingConstants.CENTER);
        pathImmagine.setHorizontalAlignment(SwingConstants.RIGHT);
        pathImmagine.setFont(new Font("Arial", Font.BOLD, 15));
        pathImmagine.setBounds(0, 230, 280, 40);
        pannelloCommemorativo.add(pathImmagine);

        JTextField inserisciPathImmagineCommemorativa = new JTextField();
        inserisciPathImmagineCommemorativa.setBounds(320, 240, 250, 30);
        pannelloCommemorativo.add(inserisciPathImmagineCommemorativa);

        JButton aggiungiCommemorativa = new JButton("AGGIUNGI COMMEMORATIVA");
        aggiungiCommemorativa.setToolTipText("Clicca per aggiungere una nuova commemorativa al catalogo.");
        aggiungiCommemorativa.setFont(new Font("Arial", Font.PLAIN, 15));
        aggiungiCommemorativa.setForeground(Color.WHITE);
        aggiungiCommemorativa.setBackground(new Color(30, 144, 255));
        aggiungiCommemorativa.setBorderPainted(false);
        aggiungiCommemorativa.setFocusPainted(false);
        aggiungiCommemorativa.setBounds(175, 290, 250, 40);
        aggiungiCommemorativa.addActionListener(e->{
            if(! inserisciAnnoCommemorativa.getText().matches("\\d{4}")){
                JOptionPane.showMessageDialog(
                        null,
                        "L'anno è stato specificato scorrettamente.\nRiprova!",
                        "Errore anno",
                        JOptionPane.ERROR_MESSAGE
                );
            }
            else{
                int anno = Integer.parseInt(inserisciAnnoCommemorativa.getText());
                String nome = inserisciNomeCommemorativa.getText();
                String descrizione = inserisciDescrizioneCommemorativa.getText();
                if(nome.equals("") || descrizione.equals("")){
                    JOptionPane.showMessageDialog(
                            null,
                            "Il nome o la descrizione non è stata specificata.\nRiprova!",
                            "Errore nome/descrizione",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
                else{
                    String pathImm = inserisciPathImmagineCommemorativa.getText();
                    File fileInserito = new File(pathImm);
                    ImageIcon imageIcon = new ImageIcon(fileInserito.getPath());
                    String nomeFileDestinazione="newimm1.png";
                    File nuovoFile = new File("out/production/EUROCOLL/view/assets/commemorative/" + nomeFileDestinazione);
                    int num = 2;
                    while(nuovoFile.exists()){
                        nomeFileDestinazione = nomeFileDestinazione.replaceAll("\\d+",String.valueOf(num));
                        nuovoFile = new File("out/production/EUROCOLL/view/assets/commemorative/" + nomeFileDestinazione);
                        num++;
                    }
                    try{
                        ImageIO.write(ImageIO.read(fileInserito), "png", nuovoFile);
                        if(this.catalogo.aggiungiMonetaCommemorativaAlCatalogo(new MonetaCommemorativa(anno,nome,nomeFileDestinazione,descrizione))){
                            JOptionPane.showMessageDialog(
                                    null,
                                    "La moneta è stata inserita con successo al catalogo!",
                                    "Moneta inserita",
                                    JOptionPane.INFORMATION_MESSAGE
                            );
                        }
                        else{
                            JOptionPane.showMessageDialog(
                                    null,
                                    "La moneta è già stata inserita",
                                    "Errore",
                                    JOptionPane.ERROR_MESSAGE
                            );
                            nuovoFile.delete();
                        }

                    } catch (IOException ignored) {
                        JOptionPane.showMessageDialog(
                                null,
                                "Si è verificato un errore durante il salvataggio dell'immagine.",
                                "Errore",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        pannelloCommemorativo.add(aggiungiCommemorativa);

        pannelloAggiuntaMoneta.add(pannelloCommemorativo);

        //Label Commemorativa
        JLabel isCommemorativa = new JLabel("Commemorativa:");
        isCommemorativa.setVerticalAlignment(SwingConstants.CENTER);
        isCommemorativa.setHorizontalAlignment(SwingConstants.RIGHT);
        isCommemorativa.setFont(new Font("Arial", Font.BOLD, 15));
        isCommemorativa.setBounds(390, 160, 120, 40);
        pannelloAggiuntaMoneta.add(isCommemorativa);

        //Combobox divisionale
        JCheckBox checkBox = new JCheckBox();
        checkBox.setBounds(550, 170, 20,20);
        checkBox.setSelected(false);
        checkBox.addActionListener(e -> {
            if (checkBox.isSelected()) {
                pannelloDivisionale.setVisible(false);
                pannelloCommemorativo.setVisible(true);
            } else {
                pannelloCommemorativo.setVisible(false);
                pannelloDivisionale.setVisible(true);
            }
        });
        pannelloAggiuntaMoneta.add(checkBox);

        return pannelloAggiuntaMoneta;
    }

    public JPanel sceltaTaglioDivisionale(){
        JPanel pannellosceltaTaglio = new JPanel();
        pannellosceltaTaglio.setLayout(null);
        pannellosceltaTaglio.setBounds(10, 10, 1060, 540);
        pannellosceltaTaglio.setBackground(new Color(204, 229, 255));

        Border bordoBlu = BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLUE, 2),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        );

        //Torna indietro
        JLabel indietro = new JLabel("<");
        indietro.setBounds(15,15,30,30);
        indietro.setHorizontalAlignment(SwingConstants.CENTER);
        indietro.setVerticalAlignment(SwingConstants.CENTER);
        indietro.setFont(new Font("Arial", Font.BOLD, 26));
        indietro.setForeground(new Color(30, 144, 255));
        indietro.setToolTipText("Torna indietro");
        indietro.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cambiaPagina(sceltaVisita());
            }
        });
        pannellosceltaTaglio.add(indietro);

        //Titolo
        JLabel label = new JLabel("SELEZIONA TAGLIO");
        label.setBounds(330,20,400,105);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 30));
        label.setForeground(new Color(30, 144, 255));
        pannellosceltaTaglio.add(label);

        //tutti JPanel per taglio
        int[] boundsx = {100,340,580,820,100,340,580,820};
        int[] boundsy = {150,150,150,150,330,330,330,330};
        Moneta.Taglio[] tagli = Moneta.Taglio.values();
        for(int i=0;i<tagli.length;i++){
            JPanel pan = new JPanel();
            pan.setLayout(null);
            pan.setBorder(bordoBlu);
            if(this.utente.isPresentDivisionale(tagli[i])){
                pan.setBackground(new Color(186, 232, 169));
            }
            pan.setBounds(boundsx[i],boundsy[i],140,140);

            //labelTaglio
            JLabel labelTaglio = new JLabel("€" + String.format("%.2f",tagli[i].getValore()));
            labelTaglio.setBounds(0,5,140,20);
            labelTaglio.setHorizontalAlignment(SwingConstants.CENTER);
            labelTaglio.setVerticalAlignment(SwingConstants.CENTER);
            labelTaglio.setFont(new Font("Arial", Font.BOLD, 16));
            labelTaglio.setForeground(new Color(30, 144, 255));
            pan.add(labelTaglio);

            //labelImmagine
            ImageIcon imageDivisionale = new ImageIcon(Objects.requireNonNull(Finestra.class.getResource("assets" + File.separator + "divisionali" + File.separator + tagli[i].getPathImage())));
            JLabel imageLabelDivisionale = new JLabel();
            imageLabelDivisionale.setBounds(17, 30, 105, 105);
            imageLabelDivisionale.setIcon(imageDivisionale);
            Image image = imageDivisionale.getImage().getScaledInstance(105, 105, Image.SCALE_SMOOTH);
            imageDivisionale.setImage(image);
            pan.add(imageLabelDivisionale);

            int new_i = i;
            pan.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    cambiaPagina(schermataTaglioDivisionale(tagli[new_i]));
                }
            });

            pannellosceltaTaglio.add(pan);
        }

        return pannellosceltaTaglio;
    }

    public JPanel sceltaCommemorativa(){
        JPanel pannellosceltaCommemorativa = new JPanel();
        pannellosceltaCommemorativa.setLayout(null);
        pannellosceltaCommemorativa.setBounds(10, 10, 1060, 540);
        pannellosceltaCommemorativa.setBackground(new Color(204, 229, 255));

        Border bordoNero = BorderFactory.createLineBorder(Color.BLACK, 2);
        BasicScrollBarUI stileBarra = new BasicScrollBarUI(){
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new Color(0, 0, 0);
                this.thumbDarkShadowColor = new Color(0, 0, 0);
                this.thumbHighlightColor = new Color(0, 0, 0);
                this.thumbLightShadowColor = new Color(0, 0, 0);
            }

            @Override
            protected JButton createDecreaseButton(int orientation) {
                return createZeroButton();
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                return createZeroButton();
            }

            private JButton createZeroButton() {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(0, 0));
                button.setMinimumSize(new Dimension(0, 0));
                button.setMaximumSize(new Dimension(0, 0));
                return button;
            }
        };

        //Torna Indietro
        JLabel indietro = new JLabel("<");
        indietro.setBounds(15,15,30,30);
        indietro.setHorizontalAlignment(SwingConstants.CENTER);
        indietro.setVerticalAlignment(SwingConstants.CENTER);
        indietro.setFont(new Font("Arial", Font.BOLD, 26));
        indietro.setForeground(new Color(30, 144, 255));
        indietro.setToolTipText("Torna indietro");
        indietro.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cambiaPagina(sceltaVisita());
            }
        });
        pannellosceltaCommemorativa.add(indietro);

        //Titolo
        JLabel label = new JLabel("SELEZIONA COMMEMORATIVA");
        label.setBounds(280,20,500,100);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 30));
        label.setForeground(new Color(30, 144, 255));
        pannellosceltaCommemorativa.add(label);

        //Scroll contenente monete commemorative
        List<MonetaCommemorativa> moneteC = this.catalogo.moneteCommemorative();
        int numeroMoneteCommemorative = moneteC.size();
        JPanel contenuto = new JPanel();
        contenuto.setLayout(null);
        contenuto.setPreferredSize(new Dimension(639, (((numeroMoneteCommemorative-1)/4)+1)*150+60));
        contenuto.setBackground(Color.WHITE);

        int[] x = {30,180,330,480};

        for(int i = 0; i<numeroMoneteCommemorative;i++){
            JPanel pan = new JPanel();
            pan.setBounds(x[i%4],30 + ((i/4)*150),120,120);
            pan.setBorder(bordoNero);
            if(this.utente.isPresent(moneteC.get(i))){
                pan.setBackground(new Color(186, 232, 169));
            }
            else{
                pan.setBackground(Color.WHITE);
            }
            //Label Anno
            JLabel labelAnno = new JLabel(String.valueOf(moneteC.get(i).getAnno()));
            labelAnno.setBounds(0,2,120,10);
            labelAnno.setHorizontalAlignment(SwingConstants.CENTER);
            labelAnno.setVerticalAlignment(SwingConstants.CENTER);
            labelAnno.setFont(new Font("Arial", Font.BOLD, 10));
            pan.add(labelAnno);

            //Label Immagine
            ImageIcon imageCommemorativa = new ImageIcon(Objects.requireNonNull(Finestra.class.getResource("assets/commemorative/" + moneteC.get(i).getPathimm())));
            JLabel imageLabelCommemorativa = new JLabel();
            imageLabelCommemorativa.setBounds(12, 13, 90, 90);
            imageLabelCommemorativa.setIcon(imageCommemorativa);
            Image image = imageCommemorativa.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
            imageCommemorativa.setImage(image);
            pan.add(imageLabelCommemorativa);

            int new_i = i;
            pan.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    cambiaPagina(schermataCommemorativa(moneteC.get(new_i)));
                }
            });

            contenuto.add(pan);
        }

        JScrollPane scrollMoneteCommemorative = new JScrollPane(contenuto);
        scrollMoneteCommemorative.setBounds(200,140,660,300);
        scrollMoneteCommemorative.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollMoneteCommemorative.getVerticalScrollBar().setUI(stileBarra);
        scrollMoneteCommemorative.setBorder(bordoNero);

        pannellosceltaCommemorativa.add(scrollMoneteCommemorative);

        return pannellosceltaCommemorativa;
    }

    public JPanel schermataCommemorativa(MonetaCommemorativa moneta){
        JPanel pannelloCommemorativa = new JPanel();
        pannelloCommemorativa.setLayout(null);
        pannelloCommemorativa.setBounds(10, 10, 1060, 540);
        pannelloCommemorativa.setBackground(new Color(204, 229, 255));

        Border bordoNero = BorderFactory.createLineBorder(Color.BLACK, 2);
        BasicScrollBarUI stileBarra = new BasicScrollBarUI(){
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new Color(0, 0, 0);
                this.thumbDarkShadowColor = new Color(0, 0, 0);
                this.thumbHighlightColor = new Color(0, 0, 0);
                this.thumbLightShadowColor = new Color(0, 0, 0);
            }

            @Override
            protected JButton createDecreaseButton(int orientation) {
                return createZeroButton();
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                return createZeroButton();
            }

            private JButton createZeroButton() {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(0, 0));
                button.setMinimumSize(new Dimension(0, 0));
                button.setMaximumSize(new Dimension(0, 0));
                return button;
            }
        };

        //Torna Indietro
        JLabel indietro = new JLabel("<");
        indietro.setBounds(15,15,30,30);
        indietro.setHorizontalAlignment(SwingConstants.CENTER);
        indietro.setVerticalAlignment(SwingConstants.CENTER);
        indietro.setFont(new Font("Arial", Font.BOLD, 26));
        indietro.setForeground(new Color(30, 144, 255));
        indietro.setToolTipText("Torna indietro");
        indietro.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cambiaPagina(sceltaCommemorativa());
            }
        });
        pannelloCommemorativa.add(indietro);

        //Pannello Bianco
        JPanel contenuto = new JPanel();
        contenuto.setLayout(null);
        contenuto.setBounds(200,30,660 ,480 );
        contenuto.setBackground(Color.WHITE);
        contenuto.setBorder(bordoNero);

        //TITOLO
        JLabel labelTitolo = new JLabel(moneta.getNome());
        labelTitolo.setBounds(0,10,660,30);
        labelTitolo.setVerticalAlignment(SwingConstants.CENTER);
        labelTitolo.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitolo.setFont(new Font("Arial", Font.BOLD, 20));
        labelTitolo.setForeground(Color.BLACK);
        contenuto.add(labelTitolo);

        //IMMAGINE
        ImageIcon imageCommemorativa = new ImageIcon(Objects.requireNonNull(Finestra.class.getResource("assets" + File.separator + "commemorative" + File.separator + moneta.getPathimm())));
        JLabel imageLabelCommemorativa = new JLabel();
        imageLabelCommemorativa.setBounds(120, 60, 210, 210);
        imageLabelCommemorativa.setIcon(imageCommemorativa);
        Image image = imageCommemorativa.getImage().getScaledInstance(210, 210, Image.SCALE_SMOOTH);
        imageCommemorativa.setImage(image);
        contenuto.add(imageLabelCommemorativa);

        //DESCRIZIONE
        JTextArea textAreaDescrizione = new JTextArea(moneta.getDescrizione());
        textAreaDescrizione.setLineWrap(true);
        textAreaDescrizione.setWrapStyleWord(true);
        textAreaDescrizione.setEditable(false);
        textAreaDescrizione.setAlignmentX(JTextArea.CENTER_ALIGNMENT);
        textAreaDescrizione.setAlignmentY(JTextArea.CENTER_ALIGNMENT);

        JScrollPane scrollDescrizione = new JScrollPane(textAreaDescrizione);
        scrollDescrizione.setBounds(150, 300, 360, 150);
        scrollDescrizione.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollDescrizione.getVerticalScrollBar().setUI(stileBarra);
        scrollDescrizione.setBorder(bordoNero);
        contenuto.add(scrollDescrizione);

        //CHECKBOX
        JCheckBox checkBox = new JCheckBox();
        checkBox.setBounds(450, 120, 20,20);
        checkBox.setSelected(this.utente.isPresentCommemorativa(moneta));
        checkBox.addActionListener(e -> {
            if (checkBox.isSelected()) {
                this.utente.aggiungiMonetaAllaCollezione(moneta);
            } else {
                this.utente.rimuoviMonetaDallaCollezione(moneta);
            }
        });
        contenuto.add(checkBox);

        pannelloCommemorativa.add(contenuto);

        return pannelloCommemorativa;
    }

    public JPanel schermataTaglioDivisionale(Moneta.Taglio taglio){
        JPanel pannelloTaglioDivisionale = new JPanel();
        pannelloTaglioDivisionale.setLayout(null);
        pannelloTaglioDivisionale.setBounds(10, 10, 1060, 540);
        pannelloTaglioDivisionale.setBackground(new Color(204, 229, 255));

        Border bordoNero = BorderFactory.createLineBorder(Color.BLACK, 2);
        BasicScrollBarUI stileBarra = new BasicScrollBarUI(){
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new Color(0, 0, 0);
                this.thumbDarkShadowColor = new Color(0, 0, 0);
                this.thumbHighlightColor = new Color(0, 0, 0);
                this.thumbLightShadowColor = new Color(0, 0, 0);
            }

            @Override
            protected JButton createDecreaseButton(int orientation) {
                return createZeroButton();
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                return createZeroButton();
            }

            private JButton createZeroButton() {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(0, 0));
                button.setMinimumSize(new Dimension(0, 0));
                button.setMaximumSize(new Dimension(0, 0));
                return button;
            }
        };

        //Torna indietro
        JLabel indietro = new JLabel("<");
        indietro.setBounds(15,15,30,30);
        indietro.setHorizontalAlignment(SwingConstants.CENTER);
        indietro.setVerticalAlignment(SwingConstants.CENTER);
        indietro.setFont(new Font("Arial", Font.BOLD, 26));
        indietro.setForeground(new Color(30, 144, 255));
        indietro.setToolTipText("Torna indietro");
        indietro.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cambiaPagina(sceltaTaglioDivisionale());
            }
        });
        pannelloTaglioDivisionale.add(indietro);

        //Pannello Bianco
        JPanel contenuto = new JPanel();
        contenuto.setLayout(null);
        contenuto.setBounds(200,30,660 ,480 );
        contenuto.setBackground(Color.WHITE);
        contenuto.setBorder(bordoNero);

        //Titolo
        JLabel labelTitolo = new JLabel(taglio.getNome());
        labelTitolo.setBounds(0,15,660,20);
        labelTitolo.setVerticalAlignment(SwingConstants.CENTER);
        labelTitolo.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitolo.setFont(new Font("Arial", Font.BOLD, 20));
        labelTitolo.setForeground(Color.BLACK);
        contenuto.add(labelTitolo);

        //Immagine
        ImageIcon imageMoneta = new ImageIcon(Objects.requireNonNull(Finestra.class.getResource("assets" + File.separator + "divisionali" + File.separator + taglio.getPathImage())));
        JLabel imageLabelMoneta = new JLabel();
        imageLabelMoneta.setBounds(280,50,100,100);
        imageLabelMoneta.setIcon(imageMoneta);
        Image image = imageMoneta.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        imageMoneta.setImage(image);
        contenuto.add(imageLabelMoneta);

        //Descrizione
        JTextArea textAreaDescrizione = new JTextArea(taglio.getDescrizione());
        textAreaDescrizione.setBounds(150, 165, 360, 100);
        textAreaDescrizione.setLineWrap(true);
        textAreaDescrizione.setWrapStyleWord(true);
        textAreaDescrizione.setEditable(false);
        textAreaDescrizione.setAlignmentX(JTextArea.CENTER_ALIGNMENT);
        textAreaDescrizione.setAlignmentY(JTextArea.CENTER_ALIGNMENT);

        JScrollPane scrollDescrizione = new JScrollPane(textAreaDescrizione);
        scrollDescrizione.setBounds(150, 165, 360, 100);
        scrollDescrizione.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollDescrizione.getVerticalScrollBar().setUI(stileBarra);
        scrollDescrizione.setBorder(bordoNero);
        contenuto.add(scrollDescrizione);

        //ANNATE
        List<Moneta> moneteTaglioOrdinatePerAnno = this.catalogo.monetaDivisionalePerTaglio(taglio);
        JPanel pannelloMonete = new JPanel();
        pannelloMonete.setLayout(null);
        pannelloMonete.setPreferredSize(new Dimension(178, moneteTaglioOrdinatePerAnno.size() * 30));

        for(int i = 0; i < moneteTaglioOrdinatePerAnno.size();i++){
            JPanel pan = new JPanel();
            pan.setLayout(null);
            pan.setBounds(0,i*30,178,30);
            if(i%2 == 0){
                pan.setBackground(Color.WHITE);
            }
            else{
                pan.setBackground(new Color(200,200,200));
            }
            JLabel labelAnno = new JLabel(String.valueOf(moneteTaglioOrdinatePerAnno.get(i).getAnno()));
            labelAnno.setBounds(10,5,30,20);
            pan.add(labelAnno);

            //aggiungi una casella cliccabile
            JCheckBox checkBox = new JCheckBox();
            checkBox.setBounds(150, 5, 20, 20);
            checkBox.setSelected(this.utente.isPresent(moneteTaglioOrdinatePerAnno.get(i)));
            int newi = i;
            checkBox.addActionListener(e -> {
                if (checkBox.isSelected()) {
                    this.utente.aggiungiMonetaAllaCollezione(moneteTaglioOrdinatePerAnno.get(newi));
                } else {
                    this.utente.rimuoviMonetaDallaCollezione(moneteTaglioOrdinatePerAnno.get(newi));
                }
            });
            pan.add(checkBox);

            pannelloMonete.add(pan);
        }

        JScrollPane scrollMonete = new JScrollPane(pannelloMonete);
        scrollMonete.setBounds(230,280,200,180);
        scrollMonete.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollMonete.getVerticalScrollBar().setUI(stileBarra);
        scrollMonete.setBorder(bordoNero);
        contenuto.add(scrollMonete);

        pannelloTaglioDivisionale.add(contenuto);
        return pannelloTaglioDivisionale;
    }

}
