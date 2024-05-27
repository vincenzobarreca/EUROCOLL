package model;

import java.io.Serializable;

public class Moneta implements Serializable {
    private final int anno;
    private final boolean commemorativa;
    private final Taglio taglio;

    public enum Taglio {
        UN_CENTESIMO(0.01,
                "Castel del Monte",
                "un_cent.png",
                "Nel campo Castel del Monte, fatto costruire da Federico II di Svevia nel XIII secolo.\nIn basso il monogramma della Repubblica Italiana \"RI\", con a sinistra il segno di zecca \"R\" e a destra le iniziali dell'autore Eugenio Driutti \"ED\".\nIn alto l'anno di conio.\nSul bordo esterno 12 stelle a cinque punte rappresentanti l'Unione Europea."),
        DUE_CENTESIMI(0.02,
                "Mole Antonelliana",
                "due_cent.png",
                "Nel campo la Mole Antonelliana di Torino, progettata nel 1863 da Alessandro Antonelli.\nA sinistra il monogramma della Repubblica Italiana \"RI\"; a destra il segno di zecca \"R\" e l'anno di conio.\nIn basso le iniziali dell'autrice Luciana De Simoni \"LDS\".\nSul bordo esterno 12 stelle a cinque punte rappresentanti l'Unione Europea."),
        CINQUE_CENTESIMI(0.05,
                "Colosseo",
                "cinque_cent.png",
                "Nel campo il Colosseo o Anfiteatro Flavio, che l'Imperatore Vespasiano iniziò a costruire intorno al 75 d.C. e che l'Imperatore Tito inaugurò nell'80 d.C.\nIn alto a destra il monogramma della Repubblica Italiana \"RI\", a sinistra il segno di zecca \"R\".\nIn basso l'anno di conio e le iniziali dell'autore Ettore Lorenzo Frapiccini \"ELF\".\nSul bordo esterno 12 stelle a cinque punte rappresentanti l'Unione Europea."),
        DIECI_CENTESIMI(0.10,
                "Nascita di Venere",
                "dieci_cent.png",
                "Nel campo particolare della \"Nascita di Venere\" di Sandro Botticelli, conservata a Firenze Galleria degli Uffizi.\nA sinistra il monogramma della Repubblica Italiana \"RI\" e l'anno di conio; a destra del collo di Venere il segno di zecca \"R\".\nFra le stelle n.7 e.8 le iniziali dell'autrice Claudia Momoni \"CM\".\nSul bordo esterno 12 stelle a cinque punte rappresentanti l'Unione Europea."),
        VENTI_CENTESIMI(0.20,
                "Forme uniche della continuità nello spazio",
                "venti_cent.png",
                "Nel campo \"Forme uniche di continuità nello spazio\", opera del 1913 dello scultore futurista Umberto Boccioni (1882-1916).\nA sinistra il monogramma della Repubblica Italiana \"RI\"; a destra il segno di zecca \"R\" e l'anno di conio; in basso le iniziali dell'autrice Maria Angela Cassol \"M.A.C.\".\nSul bordo esterno 12 stelle a cinque punte rappresentanti l'Unione Europea."),
        CINQUANTA_CENTESIMI(0.50,
                "Statua equestre di Marco Aurelio",
                "cinquanta_cent.png",
                "Nel campo monumento equestre di Marco Aurelio e pavimentazione michelangiolesca della piazza del Campidoglio in Roma.\nA destra il monogramma della Repubblica Italiana \"RI\"; a sinistra il segno di zecca \"R\".\nIn basso l'anno di conio e le iniziale dell'autore Roberto Mauri \"M\".\nSul bordo esterno 12 stelle a cinque punte rappresentanti l'Unione Europea."),
        UN_EURO(1.00,
                "Uomo Vitruviano",
                "un_euro.png",
                "L'Uomo Vitruviano: disegno di Leonardo da Vinci sulle misure proporzionali del corpo umano.\nSopra il monogramma della Repubblica Italiana \"RI\"; a sinistra il segno di zecca \"R\" e a destra l'anno di conio.\nSul bordo esterno 12 stelle a cinque punte rappresentanti l'Unione Europea; sopra la stella n. 7 le iniziali dell'autrice Laura Cretara \"LC\"."),
        DUE_EURO(2.00,
                "Dante Alighieri",
                "due_euro.png",
                "Nel campo ritratto di Dante Alighieri, tratto dal Parnaso di Raffaello Sanzio situato nelle Stanza della segnatura nei Musei Vaticani.\nA sinistra il monogramma della Repubblica Italiana \"RI\", l'anno di conio e il segno di zecca \"R\".\nIn basso le iniziali dell'autrice Maria Carmela Colaneri \"M.C.C.\".\nSul bordo esterno 12 stelle a cinque punte rappresentanti l'Unione Europea.");

        private final double valore;
        private final String nome;
        private final String pathImage;
        private final String descrizione;

        Taglio(double valore, String nome, String pathImmagine, String descrizione) {
            this.valore = valore;
            this.nome = nome;
            this.pathImage = pathImmagine;
            this.descrizione = descrizione;
        }

        public String getNome() {
            return nome;
        }

        public double getValore() {
            return valore;
        }

        public String getPathImage() {
            return pathImage;
        }

        public String getDescrizione() {
            return descrizione;
        }
    }


    public Moneta(int anno, boolean commemorativa, Taglio taglio){
        this.anno = anno;
        this.commemorativa = commemorativa;
        this.taglio = taglio;
    }

    public Moneta(int anno, Taglio taglio){
        this(anno,false,taglio);
    }

    public Moneta(int anno){
        this(anno,true,Taglio.DUE_EURO);
    }

    public final int getAnno() {
        return this.anno;
    }

    public final Taglio getTaglio() {
        return this.taglio;
    }

    public boolean isCommemorativa() {
        return this.commemorativa;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null) return false;
        if(this == obj) return true;
        if(this.getClass() != obj.getClass()) return false;
        Moneta other = (Moneta) obj;
        if(this.getAnno() != other.getAnno()) return false;
        if(this.isCommemorativa() != other.isCommemorativa()) return false;
        return this.getTaglio() == other.getTaglio();
    }
    @Override
    public String toString(){
        return String.valueOf(this.anno);
    }

}
