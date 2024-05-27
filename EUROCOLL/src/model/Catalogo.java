package model;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class Catalogo implements Serializable{
    List<Moneta> moneteDaCollezione;

    public Catalogo(){
        this.moneteDaCollezione = new ArrayList<>();

        //tutte le monete divisionali
        for(Moneta.Taglio taglio: Moneta.Taglio.values()){
            for(int i = 2002;i<2025;i++){
                this.moneteDaCollezione.add(new Moneta(i,taglio));
            }
        }

        //tutte le monete commemorative
        this.moneteDaCollezione.add(new MonetaCommemorativa(
                2004,
                "World Food Programme",
                "wolrdFoodProgramme.png",
                "In primo piano il globo terrestre con la scritta \"WORLD FOOD PROGRAMME\", da cui nascono rigogliosi i tre elementi fondamentali dell'alimentazione: il grano, il mais ed il riso.\nA destra il monogramma della Repubblica Italiana “RI” e le iniziali \"UP\" dell'autrice Uliana Pernazza; a sinistra il segno di zecca “R”; in basso il millesimo di conio “2004”.\nSul bordo esterno 12 stelle a cinque punte, in gruppi di quattro, rappresentanti l'Unione Europea."));
        this.moneteDaCollezione.add(new MonetaCommemorativa(2005,
                "Primo anniversario Costituzione Europea",
                "costeuropea.png",
                "Nel campo rappresentazione allegorica del ratto di Europa da parte di Zeus sotto forma di toro, che sorregge la penna ed il trattato della Costituzione sottoscritto dai venticinque rappresentanti degli Stati della Comunità europea.\nIn alto a sinistra segno di zecca “R”; a ore 7 lungo la giunzione tra i due metalli le iniziali “M.C.C.”  dell’autrice Maria Carmela Colaneri; a destra il millesimo di conio  “2005”; in basso il monogramma della Repubblica Italiana “RI”.\nSul bordo esterno 12 stelle a cinque punte rappresentanti l'Unione Europea (nella parte superiore) e la scritta “COSTITUZIONE EUROPEA” (nella parte inferiore)."));
        this.moneteDaCollezione.add(new MonetaCommemorativa(
                2006,
                "XX Olimpiadi Invernali Torino 2006",
                "olimpiadi.png",
                "Al centro della moneta atleta impegnato nella discesa di una gara agonistica; dietro, una composizione di elementi grafici stilizzati: a sinistra in alto il monogramma della Repubblica italiana “RI” con sotto il segno di zecca “R” e la raffigurazione della Mole Antonelliana con alla base la scritta “TORINO”; a destra in alto la scritta “GIOCHI INVERNALI”; a fianco della figura, disposto in posizione verticale, il millesimo di conio “2006” e le iniziali “M.C.C.” dell’autrice Maria Carmela Colaneri.\nSul bordo esterno 12 stelle a cinque punte rappresentanti l'Unione Europea."));
        this.moneteDaCollezione.add(new MonetaCommemorativa(
                2007,
                "50° anniversario Trattati di Roma",
                "trattati.png",
                "Al centro della moneta il trattato firmato dai sei Stati membri fondatori, sormontato dalla parola “EUROPA”; sul fondo la pavimentazione, disegnata da Michelangelo, di Piazza del Campidoglio a Roma dove sono stati firmati i Trattati il 25 marzo 1957.\nIn basso a sinistra il millesimo “2007”, a destra il segno di zecca “R” Roma; in alto, in una composizione ad arco su due righe, le scritte “TRATTATI DI ROMA” e “50° ANNIVERSARIO”; in basso ad arco la scritta “REPUBBLICA ITALIANA”. Sul bordo esterno 12 stelle a cinque punte rappresentanti l'Unione Europea. Autore H. Andexlinger."));
        this.moneteDaCollezione.add(new MonetaCommemorativa(
                2008,
                "60° anniversario Dichiarazione Universale dei diritti dell’uomo",
                "dirittiuomo.png",
                "Al centro della moneta figura femminile e maschile con i simboli della pace, dell'alimentazione e del lavoro rappresentati all'ulivo, dal grano e dalla ruota dentata.\nAl centro il  monogramma  della Repubblica italiana “RI”, con il filo spinato a simbolo  del  diritto  alla  libertà;  ai lati; a sinistra l'anno di emissione  “2008”;  a  destra  le  iniziali  dell'autrice Maria Carmela Colaneri  “MCC” e il segno di zecca “R”; in basso “60°” formato da anelli di catena e la scritta  “DIRITTI  UMANI”.\nSul bordo esterno 12 stelle a cinque punte rappresentanti l'Unione Europea."));
        this.moneteDaCollezione.add(new MonetaCommemorativa(
                2009,
                "200° anniversario nascita Louis Braille",
                "braille.png",
                "Al centro raffigurazione di una mano in posizione di lettura sulle pagine di un libro; in alto due gabbiani in volo, simbolo del sapere libero e universale.\nIn verticale la scritta “LOUIS BRAILLE 19019 2009”.\nIn basso, Louis Braille, composto con il metodo di scrittura a rilievo.\nSotto la mano, il segno di zecca “R” e in basso le iniziali dell'autrice Maria Carmela Colaneri “MCC”.\nSul bordo esterno 12 stelle a cinque punte rappresentanti l'Unione Europea."));
        this.moneteDaCollezione.add(new MonetaCommemorativa(
                2009,
                "10° anniversario Unione Economica e Monetaria",
                "unionemonetaria.png",
                "Al centro della moneta il disegno scelto dai cittadini dell’UE tramite un concorso.\nQuesto rappresenta l’euro come ultima tappa nella lunga storia del commercio, dal baratto preistorico, evocato dal disegno deliberatamente primitivo, all'unione economica e monetaria.\nAl di sopra ad arco la scritta “REPUBBLICA ITALIANA”; in basso la scritta “UEM 1999-2009”;  a destra il segno di zecca “R”.\nSul bordo esterno 12 stelle a cinque punte rappresentanti l'Unione Europea. Autore: Georgios Stamatopoulos, le cui iniziali 'ΓΣ' si trovano sopra l’anno 2009."));
        this.moneteDaCollezione.add(new MonetaCommemorativa(
                2010,
                "200° anniviversario nascita Camillo Benso di Cavour",
                "cavour.png",
                "Al centro della moneta si trova un dettaglio del ritratto dello statista italiano (dipinto da Francesco Hayez nel 1864).\nA sinistra figurano la scritta “CAVOUR” ed il monogramma della Repubblica italiana “RI”; a destra il segno di zecca “R”, le date “1810” e “2010” e le iniziali dell’autrice Claudia Momoni “C.M.”.\nSul bordo esterno 12 stelle a cinque punte rappresentanti l'Unione Europea."));
        this.moneteDaCollezione.add(new MonetaCommemorativa(
                2011,
                "150° anniversario Unità d’Italia",
                "unitaitalia.png",
                "Al centro della moneta il logo ufficiale dei 150 anni dell' unità d'Italia, che si compone di 3 bandiere italiane simboleggianti le ricorrenze dell' unità italiana avvenute nel 1911, 1961 e 2011.\nAl di sopra ad arco la scritta “150° DELL’UNITA’ D’ITALIA”; a destra il monogramma della Repubblica italiana “RI”; in basso le date “1861 > 2011”, il segno di zecca “R” e le iniziali dell’autore Ettore Lorenzo Frapiccini “ELF”.\nSul bordo esterno 12 stelle a cinque punte rappresentanti l'Unione Europea."));
        this.moneteDaCollezione.add(new MonetaCommemorativa(
                2012,
                "100° anniversario morte Giovanni Pascoli",
                "pascoli.png",
                "Al centro della moneta un ritratto del poeta romagnolo, Giovanni Pascoli.\nA destra l'anno di emissione \"2012\" e il monogramma della Repubblica italiana \"RI\"; a sinistra l'anno della morte \"1912\", il segno di zecca “R” e le iniziali dell'autrice Maria Carmela Colaneri \"MCC\"; in basso ad arco la scritta \"G. PASCOLI\".\nSul bordo esterno 12 stelle a cinque punte rappresentanti l'Unione Europea."));
        this.moneteDaCollezione.add(new MonetaCommemorativa(
                2012,
                "10 anni di banconote e monete in euro",
                "dieciannieuro.png",
                "Al centro della moneta il disegno scelto dai cittadini dell’UE tramite un concorso.\nIl disegno simboleggia l’importanza che l’euro riveste per la vita dei cittadini (rappresentata dalle persone), gli scambi (la nave), l’industria (la fabbrica) e l’energia (le centrali eoliche).\nAl di sopra ad arco la scritta “REPUBBLICA ITALIANA”; a destra il segno di zecca “R”; in basso le date “2002 2012”.\nSul bordo esterno 12 stelle a cinque punte rappresentanti l'Unione Europea. Autore: Helmut Andexlinger."));
        this.moneteDaCollezione.add(new MonetaCommemorativa(
                2013,
                "200° anniversario nascita di Giuseppe Verdi",
                "verdi.png",
                "Al centro della moneta il busto di tre quarti di Giuseppe Verdi; a sinistra il monogramma della Rebubblica Italiana \"RI\" e l'anno di nascita del compositore \"1813\"; a destra il segno di zecca \"R\" e l'anno di emissione \"2013\"; in basso la scritta \"G.VERDI\" e le iniziali dell’autrice Maria Carmela Colaneri \"MCC\".\nSul bordo esterno 12 stelle a cinque punte rappresentanti l'Unione Europea."));
        this.moneteDaCollezione.add(new MonetaCommemorativa(
                2013,
                "700° anniversario nascita Giovanni Boccaccio",
                "boccaccio.png",
                "Al centro della moneta il volto di Giovanni Boccaccio, di tre quarti, rivolto verso destra, tratto dall'affresco di Andrea del Castagno, 1450 circa (Firenze - Galleria degli Uffizi); in basso la scritta “BOCCACCIO 1313 2013”; a destra il monogramma della Rebubblica Italiana \"RI\", il segno di zecca \"R\" e le iniziali dell’autore Roberto Mauri “m”.\nSul bordo esterno 12 stelle a cinque punte rappresentanti l'Unione Europea."));
        this.moneteDaCollezione.add(new MonetaCommemorativa(
                2014,
                "200° anniversario fondazione Arma dei Carabinieri",
                "carabinieri.png",
                "Al centro della moneta reinterpretazione della scultura \"Pattuglia di Carabinieri Nella tormenta\" realizzato nel 1973 da Antonio Berti; a destra il monogramma della Repubblica Italiana \"RI\" e il millesimo di conio \"2014\"; a sinistra l'anno \"1814\"; in alto il segno di zecca \"R\"; in basso la scritta \"CARABINIERI\" e le iniziali dell'autrice Luciana De Simoni \"LDS\".\nSul bordo esterno 12 stelle a cinque punte rappresentanti l'Unione Europea."));
        this.moneteDaCollezione.add(new MonetaCommemorativa(
                2014,
                "450° anniversario nascita Galileo Galilei",
                "galilei.png",
                "Al centro della moneta ritratto di Galileo Galilei tratto dal dipinto di Justus Sustermans, 1536 (Firenze, Galleria degli Uffizi); in alto ad arco la scritta \"GALILEO GALILEI\"; a destra  il segno di zecca \"R\" e il cannocchiale con lente obiettiva di Galileo Galilei (Firenze, Museo Galileo); a sinistra il monogramma della Repubblica Italiana \"RI\"; in basso la scritta \"1564*2014\" e le iniziali dell'autrice Claudia Momoni \"CM\".\nSul bordo esterno 12 stelle a cinque punte rappresentanti l'Unione Europea."));
        this.moneteDaCollezione.add(new MonetaCommemorativa(
                2015,
                "World Expo Milano 2015",
                "expo.png",
                "Al centro della moneta una composizione che simboleggia la fertilità della Terra; su un semicerchio, che rappresenta la sfera terrestre, un seme bagnato dall’acqua sta per germogliare; sopra la Terra un tralcio di vite, un ramoscello d’ulivo e una spiga spuntano da un tronco d’albero; intorno ad arco la scritta \"NUTRIRE IL PIANETA\"; a sinistra le iniziali dell’autrice Maria Grazia Urbani \"MGU\"; a destra il monogramma della Repubblica italiana \"RI\" e il segno di zecca \"R\"; al centro il logo di EXPO MILANO 2015.\nSul bordo esterno 12 stelle a cinque punte rappresentanti l'Unione Europea."));
        this.moneteDaCollezione.add(new MonetaCommemorativa(
                2015,
                "750° anniversario nascita Dante Alighieri",
                "dante.png",
                "Al centro della moneta Dante Alighieri con la Divina Commedia nella mano sinistra e alle spalle la montagna del Purgatorio (particolare del dipinto 'Allegoria della Divina Commedia' di Domenico Michelino del 1465 nella cattedrale di Santa Maria del Fiore a Firenze); a destra il segno di zecca \"R\"; in alto il monogramma della Repubblica italiana \"RI\" e ad arco la scritta \"DANTE ALIGHIERI\"; in basso le date \"1265\" \"2015\" e le iniziali dell'autore Silvia Petrassi \"S.P.\".\nSul bordo esterno 12 stelle a cinque punte rappresentanti l'Unione Europea."));
        this.moneteDaCollezione.add(new MonetaCommemorativa(
                2015,
                "30° anniversario bandiera europea",
                "bandieraeuropea.png",
                "Al centro della moneta è raffigurata la bandiera dell'UE quale simbolo dell'unione di popoli e culture che condividono visioni e ideali per un futuro comune migliore.\nLe dodici stelle che si trasformano in figure umane rappresentano la nascita di una nuova Europa.\nIn alto a destra figurano, a semicerchio, il paese di emissione \"REPUBBLICA ITALIANA\" e gli anni \"1985-2015\"; a destra, fra la bandiera e gli anni, figura il segno di zecca \"R\".\nIn basso a destra le iniziali dell'autore Georgios Stamatopoulos.\nSul bordo esterno 12 stelle a cinque punte rappresentanti l'Unione Europea."));
        this.moneteDaCollezione.add(new MonetaCommemorativa(
                2016,
                "550° anniversario morte Donatello",
                "donatello.png",
                "Al centro della moneta la Testa del David di Donatello (particolare scultura in bronzo conservata a Firenze, Museo Nazione del Bargello); in alto il segno di zecca \"R\"; a sinistra il monogramma della Repubblica italiana \"RI\"; sotto, su due righe, gli anni \"1466\" e \"2016\"; a destra le iniziali dell'autore Claudia Momoni \"C.M.\"; in basso ad arco la scritta \"DONATELLO\".\nSul bordo esterno 12 stelle a cinque punte rappresentanti l'Unione Europea."));
        this.moneteDaCollezione.add(new MonetaCommemorativa(
                2016,
                "2200° anniversario morte Tito Maccio Plauto",
                "plauto.png",
                "Al centro della moneta mosaico romano del I secolo a.C., raffigurante le maschere tragica e comica; a sinistra il segno di zecca \"R\"; a destra le iniziali dell'autrice Luciana De Simoni \"LDS\"; in alto il monogramma della Repubblica italiana \"RI\"; in basso gli anni \"184 A.C.\" \"2016\" e la scritta \"PLAUTO\".\nSul bordo esterno 12 stelle a cinque punte rappresentanti l'Unione Europea."));
        this.moneteDaCollezione.add(new MonetaCommemorativa(
                2017,
                "400° anniv. completamento basilica di San Marco a Venezia",
                "venezia.png",
                "Al centro della moneta la facciata della Basilica di San Marco a Venezia; in alto la scritta \"VENEZIA\" e il segno di zecca \"R\"; in basso la scritta \"SAN MARCO\" e il monogramma della Repubblica italiana \"RI\" con ai lati le date \"1617\" e \"2017\"; a destra le iniziali dell'autrice Luciana De Simoni \"LDS\".\nSul bordo esterno 12 stelle a cinque punte rappresentanti l'Unione Europea."));
        this.moneteDaCollezione.add(new MonetaCommemorativa(
                2017,
                "2000° anniversario morte Tito Livio",
                "tito.png",
                "Al centro della moneta il busto dello storico romano Tito Livio, tratto da un’opera di Lorenzo Larese Moretti; a sinistra il monogramma della Repubblica italiana \"RI\" e le iniziali dell'autrice Claudia Momoni \"C.M.\"; a destra \"17\" e \"2017\", rispettivamente anno della scomparsa di Tito Livio e anno di emissione della moneta, e il segno di zecca \"R\"; in basso la scritta \"TITO • LIVIO\".\nSul bordo esterno 12 stelle a cinque punte rappresentanti l'Unione Europea."));
        this.moneteDaCollezione.add(new MonetaCommemorativa(
                2018,
                "70° anniversario Costituzione Repubblica Italiana",
                "costituzione.png",
                "Enrico De Nicola, capo provvisorio dello Stato, firma l’atto di promulgazione della Costituzione della Repubblica italiana il 27 dicembre 1947; alla sua destra, Alcide De Gasperi, presidente del Consiglio, alla sua sinistra Umberto Terracini, presidente dell’Assemblea costituente italiana.\nIn alto la scritta \"COSTITUZIONE\" e il monogramma della Repubblica italiana \"RI\"; in basso la scritta \"CON SICURA COSCIENZA\", il segno di zecca \"R\" e le date \"1948 • 2018\", rispettivamente l’anno dell’entrata in vigore della Costituzione italiana e l’anno di emissione della moneta; a sinistra le iniziali “UP” dell'autrice Uliana Pernazza.\nSul bordo esterno 12 stelle a cinque punte rappresentanti l'Unione Europea."));
        this.moneteDaCollezione.add(new MonetaCommemorativa(
                2018,
                "60° anniversario Ministero della Salute",
                "salute.png",
                "Il disegno raffigura una rappresentazione allegorica della salute, accompagnata da alcuni elementi simbolo delle attività del ministero: ambiente, ricerca, alimentazione e medicina.\nA sinistra il monogramma della Repubblica italiana \"RI\"; in alto il segno di zecca \"R\"; in basso le iniziali “SP” dell'autrice Silvia Petrassi.\nIn alto a semicerchio la scritta \"MINISTERO DELLA SALUTE\" e le date \"1958-2018\".\nSul bordo esterno 12 stelle a cinque punte rappresentanti l'Unione Europea."));
        this.moneteDaCollezione.add(new MonetaCommemorativa(
                2019,
                "500° anniversario morte Leonardo da Vinci",
                "leonardo.png",
                "Il disegno raffigura un particolare del dipinto \"Dama con l’ermellino\" di Leonardo da Vinci (museo Czartoryski di Cracovia). A sinistra la scritta \"LEONARDO\", le iniziali dell'autrice Maria Angela Cassol \"MAC\" e il monogramma della Repubblica italiana \"RI\"; a destra il segno di zecca \"R\", e le date \"1519-2019\", rispettivamente l’anno della morte di Leonardo e il millesimo di conio.\nSul bordo esterno 12 stelle a cinque punte rappresentanti l'Unione Europea."));
        this.moneteDaCollezione.add(new MonetaCommemorativa(
                2020,
                "80° anniversario Fondazione Corpo Nazionale dei Vigili del Fuoco",
                "vigili.png",
                "Al centro, il logo del Corpo nazionale dei Vigili del fuoco. A sinistra il monogramma della Repubblica italiana \"RI\"; a destra l'anno di emissione \"2020\" e il segno di zecca \"R\", identificativo della Zecca di Roma; in basso le iniziali dell'autrice Luciana De Simoni \"LDS\"; intorno ad arco la scritta \"CORPO NAZIONALE DEI VIGILI DEL FUOCO.\nSul bordo esterno 12 stelle a cinque punte rappresentanti l'Unione Europea."));
        this.moneteDaCollezione.add(new MonetaCommemorativa(
                2020,
                "150º anniversario nascita Maria Montessori",
                "montessori.png",
                "Al centro un ritratto di Maria Montessori in una composizione geometrica con elementi didattici tratti dal suo sistema educativo, con alla sua sinistra la scritta in verticale \"MARIA\" e al di sotto la scritta \"MONTESSORI\".\nA destra il monogramma della Repubblica italiana \"RI\"; in alto l'anno \"1870\"; in basso a sinistra il segno di zecca \"R\", al centro l'anno di emissione \"2020\" e a destra le iniziali dell'autrice Luciana De Simoni \"LDS\".\nSul bordo esterno 12 stelle a cinque punte rappresentanti l'Unione Europea."));
        this.moneteDaCollezione.add(new MonetaCommemorativa(
                2021,
                "150° anniversario Roma Capitale d'Italia",
                "romacapitale.png",
                "Al centro un particolare della Dea Roma, scultura di Angelo Zanelli, inserita al centro dell'Altare della Patria; in alto, la scritta \"ROMA CAPITALE\"; a destra le date \"•1871•2021•\"; a sinistra il monogramma della Repubblica italiana \"RI\" e il segno di zecca \"R\"; in basso le iniziali dell'autrice Uliana Pernazza \"UP\".\nSul bordo esterno 12 stelle a cinque punte rappresentanti l'Unione Europea."));
        this.moneteDaCollezione.add(new MonetaCommemorativa(
                2021,
                "Professioni sanitarie",
                "professionisanitarie.png",
                "Al centro un uomo e una donna in abbigliamento sanitario, con mascherina, stetoscopio e cartella medica, che rappresentano i medici e gli infermieri in prima linea nella lotta contro la COVID-19. In alto la scritta \"GRAZIE\"; a destra il simbolo del cuore; a sinistra una riproduzione della croce medica; al centro il monogramma della Repubblica italiana \"RI\"; a destra il segno di zecca \"R\"; in basso a sinistra le iniziali dell’autrice Claudia Momoni \"C.M.\", al centro l'anno di emissione \"2021\".\nSul bordo esterno 12 stelle a cinque punte rappresentanti l'Unione Europea."));
        this.moneteDaCollezione.add(new MonetaCommemorativa(
                2022,
                "170º anniversario Polizia di Stato",
                "polizia.png",
                "Al centro due agenti della Polizia di Stato, una donna e un uomo, rappresentati in piedi davanti a un’automobile della polizia. In alto ad arco la scritta \"POLIZIA DI STATO\", a destra il monogramma della Repubblica italiana \"RI\", acronimo della Repubblica italiana; in basso a sinistra il segno di zecca \"R\", al centro le iniziali della disegnatrice Annalisa Masini \"AM\", e a destra le date \"1852-2022\".\nSul bordo esterno 12 stelle a cinque punte rappresentanti l'Unione Europea."));
        this.moneteDaCollezione.add(new MonetaCommemorativa(
                2022,
                "30º anniversario morte di Giovanni Falcone e Paolo Borsellino",
                "falconeborsellino.png",
                "Al centro i ritratti dei due magistrati Giovanni Falcone e Paolo Borsellino e si ispira a una foto scattata da Tony Gentile.\nIn alto ad arco la scritta \"FALCONE - BORSELLINO\", al di sotto della quale gli anni \"1992-2022\" e tra di essi il monogramma della Repubblica italiana \"RI\", acronimo della Repubblica italiana; a destra il segno di zecca \"R\", a sinistra le iniziali del disegnatore Valerio de Seta \"VdS\".\nSul bordo esterno 12 stelle a cinque punte rappresentanti l'Unione Europea."));
        this.moneteDaCollezione.add(new MonetaCommemorativa(
                2022,
                "35º anniversario Programma Erasmus",
                "erasmus.png",
                "A destra un ritratto di Erasmo da Rotterdam riprodotto su un fascio di maglie che attraversa il fondo centrale della moneta formando il numero 35; sopra l'immagine le scritte \"1987-2022\" \"ERASMUS PROGRAMME\"; in basso il segno di zecca \"R\"; al centro il monogramma della Repubblica italiana \"RI\"; sopra la mano destra le iniziali dell'autore Joaquin Jimenez \"JJ\".\nSul bordo esterno 12 stelle a cinque punte rappresentanti l'Unione Europea."));
        this.moneteDaCollezione.add(new MonetaCommemorativa(
                2023,
                "100° anniversario Aeronautica militare",
                "areonautica.png",
                "Al centro della moneta il numero \"100\", attraversato da una scia di condensazione con un velivolo storico all'estremità inferiore sinistra e un moderno jet da combattimento all'estremità superiore destra, uniti da una linea semicircolare con gli anni \"1923\" e \"2023\".\nIn basso la scritta \"AERONAUTICA MILITARE\"; in alto il monogramma della Repubblica italiana \"RI\"; a sinistra il segno di zecca \"R\"; a destra le iniziali dell'autore Valerio de Seta \"VdS\".\nSul bordo esterno 12 stelle a cinque punte rappresentanti l'Unione Europea."));
        this.moneteDaCollezione.add(new MonetaCommemorativa(
                2023,
                "150º anniversario morte Alessandro Manzoni",
                "manzoni.png",
                "A destra della moneta il ritratto a mezzo profilo di Alessandro Manzoni (1785 – 1873), ispirato al ritratto dello scrittore italiano sulla banconota da 100.000 lire del 1967, con a destra le iniziali dell'autore Antonio Vecchio \"AV\" e il segno di zecca \"R\"; a sinistra la scritta “ALESSANDRO MANZONI”, il monogramma della Repubblica Italiana \"RI\" e gli anni \"1873 - 2023\".\nSul bordo esterno 12 stelle a cinque punte rappresentanti l'Unione Europea."));
        this.moneteDaCollezione.add(new MonetaCommemorativa(
                2024,
                "250° anniversario Fondazione Guardia di Finanza",
                "finanza.png",
                "Al centro della moneta una versione stilizzata dello stemma araldico della Guardia di Finanza, che comprende vari elementi: la montagna, il mare, il cielo e il grifone, animale mitologico che, secondo la leggenda, veglia sulla protezione del tesoro, simboleggiato dallo scrigno del tesoro dello stato e dalla corona con torrette.\nIn basso il monogramma della Repubblica italiana \"RI\" e le date “1774-2024”; a destra il segno di zecca \"R\" e le iniziali dell'autrice Marta Bonifacio “MB”; in alto ad arco la scritta “GUARDIA DI FINANZA”.\nSul bordo esterno 12 stelle a cinque punte rappresentanti l'Unione Europea."));
        this.moneteDaCollezione.add(new MonetaCommemorativa(
                2024,
                "Rita Levi-Montalcini",
                "montalcini.png",
                "Al centro della moneta un ritratto a mezzo busto di Rita Levi-Montalcini, ispirato alla fotografia di Manuela Fabbri; sullo sfondo un microscopio, tratto da una medaglia disegnata da Gino Levi-Montalcini, il fratello, la cui base è a forma di ferro di cavallo, un portafortuna in vista dell'assegnazione del premio Nobel per la medicina nel 1986.\nIn alto in forma circolare la scritta \"RITA LEVI-MONTALCINI\"; a sinistra il monogramma della Repubblica italiana \"RI\" e il segno di zecca \"R\"; in basso l'anno di emissione \"2024\" e a destra le iniziali dell'autrice Silvia Petrassi \"SP\".\nSul bordo esterno 12 stelle a cinque punte rappresentanti l'Unione Europea."));
    }

    public List<Moneta> monetaDivisionalePerTaglio(Moneta.Taglio taglio){
        return this.moneteDaCollezione.stream()
                .filter(moneta -> !moneta.isCommemorativa() && moneta.getTaglio() == taglio)
                .sorted(Comparator.comparing(Moneta::getAnno))
                .collect(Collectors.toList());
    }
    public List<MonetaCommemorativa> moneteCommemorative(){
        return this.moneteDaCollezione.stream()
                .filter(Moneta::isCommemorativa)
                .map(moneta->(MonetaCommemorativa)moneta)
                .sorted(Comparator.comparing(Moneta::getAnno))
                .collect(Collectors.toList());
    }

    public boolean aggiungiMonetaDivisionaleAlCatalogo(Moneta moneta){
        if(this.moneteDaCollezione.contains(moneta)){
            return false;
        }
        else{
            this.moneteDaCollezione.add(moneta);
            return true;
        }
    }

    public boolean aggiungiMonetaCommemorativaAlCatalogo(MonetaCommemorativa moneta){
        if(this.moneteDaCollezione.contains(moneta)){
            return false;
        }
        else{
            this.moneteDaCollezione.add(moneta);
            return true;
        }
    }

    public long numeroDivisionali(){
        return this.moneteDaCollezione.stream()
                .filter(m->! m.isCommemorativa())
                .count();
    }

    public long numeroCommemorative(){
        return  this.moneteDaCollezione.stream()
                .filter(Moneta::isCommemorativa)
                .count();
    }

    public double totaleValoreDivisionali(){
        return this.moneteDaCollezione.stream()
                .filter(m->! m.isCommemorativa())
                .mapToDouble(moneta->moneta.getTaglio().getValore())
                .sum();
    }

    public double totaleValoreCommemorative(){
        return this.moneteDaCollezione.stream()
                .filter(Moneta::isCommemorativa)
                .mapToDouble(moneta->moneta.getTaglio().getValore())
                .sum();
    }

    public long numeroMonetePerTaglio(Moneta.Taglio taglio){
        return this.moneteDaCollezione.stream()
                .filter(m->m.getTaglio() == taglio)
                .count();
    }

    public int annataPiuRecentePerTaglioDivisionale(Moneta.Taglio taglio){
        return this.moneteDaCollezione.stream()
                .filter(m->m.getTaglio()==taglio && (!m.isCommemorativa()))
                .mapToInt(Moneta::getAnno)
                .max().getAsInt();
    }
}
