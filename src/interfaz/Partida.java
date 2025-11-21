/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaz;

import interfaz.clasesAuxiliares.AnimatorSwing;
import interfaz.clasesAuxiliares.FadeOverlay;
import java.awt.Color;
import java.awt.Cursor;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JLayeredPane;
import javax.swing.JViewport;
import logica.Categoria;
import logica.Juego;
import logica.Jugador;
import logica.PartidaLogica;
import logica.Pregunta;
import persistencia.Excepciones;
import persistencia.Respaldo;
import persistencia.Serializador;

/**
 *
 * @author hexal
 */
public class Partida extends javax.swing.JFrame {
    private PartidaLogica partida;
    private Juego juego; 
    /**
     * Creates new form PrePartida
     */
    public Partida(PartidaLogica partida) throws ClassNotFoundException, Excepciones {
        initComponents();
        juego = Juego.getInstance();
        this.partida = partida;
        
        botonSalir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        AnimatorSwing.floatAnimation(fondo, 6, 0.01);
        textPregunta.setOpaque(false);
        textPregunta.setBackground(new Color(0, 0, 0, 0)); // Totalmente transparente
        textPregunta.setBorder(BorderFactory.createEmptyBorder()); // Sin bordes
        textPregunta.setEditable(false); // Solo lectura
        textR4.setOpaque(false);
        textR4.setBackground(new Color(0, 0, 0, 0)); // Totalmente transparente
        textR4.setBorder(BorderFactory.createEmptyBorder()); // Sin bordes
        textR4.setEditable(false); // Solo lectura
        textR2.setOpaque(false);
        textR2.setBackground(new Color(0, 0, 0, 0)); // Totalmente transparente
        textR2.setBorder(BorderFactory.createEmptyBorder()); // Sin bordes
        textR2.setEditable(false); // Solo lectura
               textR1.setOpaque(false);
        textR1.setBackground(new Color(0, 0, 0, 0)); // Totalmente transparente
        textR1.setBorder(BorderFactory.createEmptyBorder()); // Sin bordes
        textR1.setEditable(false); // Solo lectura
                   textR3.setOpaque(false);
        textR3.setBackground(new Color(0, 0, 0, 0)); // Totalmente transparente
        textR3.setBorder(BorderFactory.createEmptyBorder()); // Sin bordes
        textR3.setEditable(false); // Solo lectura
        
        // Fade de entrada al abrir la aplicación
         FadeOverlay overlay = new FadeOverlay(10, 10, Color.WHITE, () -> {
             // Esto se ejecuta cuando termina el fade
             System.out.println("Fade completado!");
         });
         getLayeredPane().add(overlay, JLayeredPane.MODAL_LAYER);
         overlay.setBounds(0, 0, getWidth(), getHeight());
         overlay.start();
     

        

    }
    
    public void iniciarPartida(){
        /*
         tengo que hacer la spartidas para los jugadores
         el jugador me indica la cantidad de rondas. una ronda es que todos los jugadores hayan completado su turno. 
         para saber eso tengo que calcular la cantidada de rondas que va a haber (rondas*persona=partidas)
         ahora se las partidas, pero como lo hago aca?
         puedo hacer un for ya que se la cantidad de partidas que se van a jugar, y tengo un contador en mi clase.
         el for tendria que ser aca adentro despeus del init components.
         se repetiria tantas veces como rondas yo calcule. 
         voy a usar la misma interfaz varias veces, cambiano los textos.
        ahora tengo todos los jugadores. tengo que, primero que nada, hacer un contador que cuando llegue a 3 se reinicie, para
        ir viendo qeu jugador
        turno tiene que ser siempre un numero entre 0 y 1 o hasta 3 dependiendo la cantidad de jugadores que haya
         bueno a tengo resuelto lo de los usuarios, ahora tengo que ver de donde saco las preguntas. el tipo de preguntas que se
         van a hacer podria perfectamente sacarlo de la clase prePartida y ponerlas en un array preguntas en partidaLogica
         eso estaria bueno poruqe me evita hacerlo aca que ya es un despelote 
         y de ahi puedo agarrar un numero random del arraylist (que no me acuerdo como se hacia) y poner regutnaas random.
         voy a dejar que se repitan poruqe si tenes poquitas y no se pueden repetir entonces se rompe todo. voy a hacer le array
         ese de preguntas para ponerlo en la clase la otra
         hasta ahora ya deberian tener los valores asignados todos los campos de texto. ahora me faltan 2 cosas:
         el tiempo y la respuesta de la pregunta+puntaje
         creo que va a ser mas facil tratar de atinar a ver como es uqe se consigue el puntaje
         l apersona va a tocar uno de lso 4 botones. la cagada es qe los botonos no son lo que tiene el texto, pero tengo
         los otros cosos vinculados con el mismo numero asi qeu no pasa nada
         bueno, consigo el texto y lo comparo con la respuesta correcta. si son iguales entonces sumo un punto "localmente"
         (en el array coordinado que tengo para putnos). lo que no se es si sin cooldown me va a esperar a que conteste. no no
         va a esperar. dejar dar click al boton tiene que dejar asi que de eso no me preocupo. lo que tengo que hacer eahora es,
         antes de pegarme 3 tiros, ponerle a los botones que si los clickeas te agarra la respuesta en una variable string y la compara
         con la correca. si esta bien, al jugador que le corresponda el turno se lleva el putno
         */
        
        //comentarios porque si no me mareo
        
        //pongo la categoria desde ya en a interfaz
        cat1.setText(partida.getCategotia());
        cat2.setText(partida.getCategotia());
        cat3.setText(partida.getCategotia());
        
        
        //la cantidad de partidas va a ser los jugadoeres*las rondas
        int cantPartidas = (partida.getJugadores().size())*(partida.getRondas());
        //lo guardamos en partida porque si
        partida.setCantPartidas(cantPartidas);
        //variable para contar de quien es el turno
        int turno = 0;
        int i;
        
        //for que va a ir partida por partida
        for(i = 0; i < partida.getCantPartidas(); i++){
            if(turno == partida.getJugadores().size()){
                turno=0;
            }
            //el jugador que le corresponde el turno
            Jugador j = partida.getJugadores().get(turno);
            //guardamos el nombre en una variable para que se vea mas prolijo
            String user = j.getNombre();
            
            //ponemos los detalles en la interfaz
            usuario1.setText(user);
            usuario2.setText(user);
            usuario3.setText(user);
            
            //creamos un objeto que sirve para obtener numeros random
            Random rand = new Random();
            //numero random para que toquen preguntas random del array
            int random = rand.nextInt(partida.getPreguntas().size());
            
            //la pregunta
            Pregunta pregunta = partida.getPreguntas().get(random);
            
            //lleno en la interfaz
            textPregunta.setText(pregunta.getPregunta());

            //numeros para que las preguntas salgan random
            boolean repetido;
            //al principio van a ser todos -1 porque si son 0 (valor inicial) wl while que viene ahora no anda bien
            int[] numeros = {-1, -1, -1, -1};
            //no se si esta andando, lo dudo
            for (i = 0; i<4; i++){
                repetido=true;
                while (repetido){
                    random = rand.nextInt(4);
                    
                    if(random != numeros[0]){
                        if(random != numeros[1]){
                            if(random != numeros[2]){
                                repetido=false;
                            }  
                        }  
                    }
                }
            numeros[i] = random;
                  
            }
                 
            textR1.setText(pregunta.getPosiblesRespuestas().get(numeros[0]));
            textR2.setText(pregunta.getPosiblesRespuestas().get(numeros[1]));
            textR3.setText(pregunta.getPosiblesRespuestas().get(numeros[2]));
            textR4.setText(pregunta.getPosiblesRespuestas().get(numeros[3]));
            
            turno++;
        }
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        botonSalir = new javax.swing.JButton();
        textPregunta = new javax.swing.JTextField();
        textR4 = new javax.swing.JTextField();
        textR2 = new javax.swing.JTextField();
        textR1 = new javax.swing.JTextField();
        textR3 = new javax.swing.JTextField();
        botonRespuesta1 = new javax.swing.JButton();
        botonRespuesta2 = new javax.swing.JButton();
        botonRespuesta3 = new javax.swing.JButton();
        botonRespuesta4 = new javax.swing.JButton();
        exitBo = new javax.swing.JLabel();
        menuText = new javax.swing.JLabel();
        menuTextBase = new javax.swing.JLabel();
        menuTextShadow = new javax.swing.JLabel();
        usuario1 = new javax.swing.JLabel();
        usuario2 = new javax.swing.JLabel();
        usuario3 = new javax.swing.JLabel();
        cat1 = new javax.swing.JLabel();
        cat2 = new javax.swing.JLabel();
        cat3 = new javax.swing.JLabel();
        tCatText2 = new javax.swing.JLabel();
        tCatTextBase2 = new javax.swing.JLabel();
        tCatTextShadow2 = new javax.swing.JLabel();
        ronda = new javax.swing.JLabel();
        rondaBase2 = new javax.swing.JLabel();
        rondaShadow2 = new javax.swing.JLabel();
        puntos = new javax.swing.JLabel();
        puntosBase = new javax.swing.JLabel();
        puntosShadow = new javax.swing.JLabel();
        triviaRespuesta2 = new javax.swing.JLabel();
        triviaRespuesta3 = new javax.swing.JLabel();
        Pregunta = new javax.swing.JLabel();
        triviaRespuesta5 = new javax.swing.JLabel();
        triviaRespuesta6 = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 0, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonSalir.setBorderPainted(false);
        botonSalir.setContentAreaFilled(false);
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });
        jPanel1.add(botonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 110, 120));

        textPregunta.setEditable(false);
        textPregunta.setBackground(new java.awt.Color(60, 59, 64));
        textPregunta.setFont(new java.awt.Font("Pixeloid Sans", 1, 24)); // NOI18N
        textPregunta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textPregunta.setBorder(null);
        textPregunta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPreguntaActionPerformed(evt);
            }
        });
        jPanel1.add(textPregunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 300, 1010, 180));

        textR4.setEditable(false);
        textR4.setBackground(new java.awt.Color(60, 59, 64));
        textR4.setFont(new java.awt.Font("Pixeloid Sans", 1, 14)); // NOI18N
        textR4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textR4.setBorder(null);
        textR4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textR4ActionPerformed(evt);
            }
        });
        jPanel1.add(textR4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 910, 260, 80));

        textR2.setEditable(false);
        textR2.setBackground(new java.awt.Color(60, 59, 64));
        textR2.setFont(new java.awt.Font("Pixeloid Sans", 1, 14)); // NOI18N
        textR2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textR2.setBorder(null);
        textR2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textR2ActionPerformed(evt);
            }
        });
        jPanel1.add(textR2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 910, 260, 80));

        textR1.setEditable(false);
        textR1.setBackground(new java.awt.Color(60, 59, 64));
        textR1.setFont(new java.awt.Font("Pixeloid Sans", 1, 14)); // NOI18N
        textR1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textR1.setBorder(null);
        textR1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textR1ActionPerformed(evt);
            }
        });
        jPanel1.add(textR1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 690, 260, 80));

        textR3.setEditable(false);
        textR3.setBackground(new java.awt.Color(60, 59, 64));
        textR3.setFont(new java.awt.Font("Pixeloid Sans", 1, 14)); // NOI18N
        textR3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textR3.setBorder(null);
        textR3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textR3ActionPerformed(evt);
            }
        });
        jPanel1.add(textR3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 690, 260, 80));

        botonRespuesta1.setBorderPainted(false);
        botonRespuesta1.setContentAreaFilled(false);
        botonRespuesta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRespuesta1ActionPerformed(evt);
            }
        });
        jPanel1.add(botonRespuesta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 670, 300, 120));

        botonRespuesta2.setBorderPainted(false);
        botonRespuesta2.setContentAreaFilled(false);
        botonRespuesta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRespuesta2ActionPerformed(evt);
            }
        });
        jPanel1.add(botonRespuesta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 880, 300, 120));

        botonRespuesta3.setBorderPainted(false);
        botonRespuesta3.setContentAreaFilled(false);
        botonRespuesta3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRespuesta3ActionPerformed(evt);
            }
        });
        jPanel1.add(botonRespuesta3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 670, 310, 120));

        botonRespuesta4.setBorderPainted(false);
        botonRespuesta4.setContentAreaFilled(false);
        botonRespuesta4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRespuesta4ActionPerformed(evt);
            }
        });
        jPanel1.add(botonRespuesta4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 880, 320, 120));

        exitBo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/recursos/exitBtnBigger.png"))); // NOI18N
        jPanel1.add(exitBo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 130, 110));

        menuText.setFont(new java.awt.Font("Pixeloid Sans", 0, 70)); // NOI18N
        menuText.setForeground(new java.awt.Color(255, 255, 255));
        menuText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuText.setText("TURNO :");
        jPanel1.add(menuText, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, -20, 800, 190));

        menuTextBase.setFont(new java.awt.Font("Pixeloid Sans", 0, 70)); // NOI18N
        menuTextBase.setForeground(new java.awt.Color(153, 153, 153));
        menuTextBase.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuTextBase.setText("TURNO :");
        jPanel1.add(menuTextBase, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, -50, 800, 260));

        menuTextShadow.setFont(new java.awt.Font("Pixeloid Sans", 0, 70)); // NOI18N
        menuTextShadow.setForeground(new java.awt.Color(59, 113, 118));
        menuTextShadow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuTextShadow.setText("TURNO :");
        jPanel1.add(menuTextShadow, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, -50, 930, 270));

        usuario1.setFont(new java.awt.Font("Pixeloid Sans", 0, 70)); // NOI18N
        usuario1.setForeground(new java.awt.Color(255, 255, 255));
        usuario1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usuario1.setText("*USUARIO*");
        jPanel1.add(usuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, -20, 800, 190));

        usuario2.setFont(new java.awt.Font("Pixeloid Sans", 0, 70)); // NOI18N
        usuario2.setForeground(new java.awt.Color(153, 153, 153));
        usuario2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usuario2.setText("*USUARIO*");
        jPanel1.add(usuario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, -50, 800, 260));

        usuario3.setFont(new java.awt.Font("Pixeloid Sans", 0, 70)); // NOI18N
        usuario3.setForeground(new java.awt.Color(59, 113, 118));
        usuario3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usuario3.setText("*USUARIO*");
        jPanel1.add(usuario3, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, -50, 930, 270));

        cat1.setFont(new java.awt.Font("Pixeloid Sans", 0, 70)); // NOI18N
        cat1.setForeground(new java.awt.Color(255, 255, 255));
        cat1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cat1.setText("CATEGORIA:");
        jPanel1.add(cat1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, 800, 190));

        cat2.setFont(new java.awt.Font("Pixeloid Sans", 0, 70)); // NOI18N
        cat2.setForeground(new java.awt.Color(153, 153, 153));
        cat2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cat2.setText("CATEGORIA:");
        jPanel1.add(cat2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 800, 260));

        cat3.setFont(new java.awt.Font("Pixeloid Sans", 0, 70)); // NOI18N
        cat3.setForeground(new java.awt.Color(59, 113, 118));
        cat3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cat3.setText("CATEGORIA:");
        jPanel1.add(cat3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 930, 270));

        tCatText2.setFont(new java.awt.Font("Pixeloid Sans", 0, 70)); // NOI18N
        tCatText2.setForeground(new java.awt.Color(255, 255, 255));
        tCatText2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tCatText2.setText("*CATEGORIA*");
        jPanel1.add(tCatText2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 70, 800, 190));

        tCatTextBase2.setFont(new java.awt.Font("Pixeloid Sans", 0, 70)); // NOI18N
        tCatTextBase2.setForeground(new java.awt.Color(153, 153, 153));
        tCatTextBase2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tCatTextBase2.setText("*CATEGORIA*");
        jPanel1.add(tCatTextBase2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 40, 800, 260));

        tCatTextShadow2.setFont(new java.awt.Font("Pixeloid Sans", 0, 70)); // NOI18N
        tCatTextShadow2.setForeground(new java.awt.Color(59, 113, 118));
        tCatTextShadow2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tCatTextShadow2.setText("*CATEGORIA*");
        jPanel1.add(tCatTextShadow2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 40, 930, 270));

        ronda.setFont(new java.awt.Font("Pixeloid Sans", 0, 70)); // NOI18N
        ronda.setForeground(new java.awt.Color(255, 255, 255));
        ronda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ronda.setText("1");
        jPanel1.add(ronda, new org.netbeans.lib.awtextra.AbsoluteConstraints(1470, -50, 800, 190));

        rondaBase2.setFont(new java.awt.Font("Pixeloid Sans", 0, 70)); // NOI18N
        rondaBase2.setForeground(new java.awt.Color(153, 153, 153));
        rondaBase2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rondaBase2.setText("1");
        jPanel1.add(rondaBase2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1470, -80, 800, 260));

        rondaShadow2.setFont(new java.awt.Font("Pixeloid Sans", 0, 70)); // NOI18N
        rondaShadow2.setForeground(new java.awt.Color(59, 113, 118));
        rondaShadow2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rondaShadow2.setText("1");
        jPanel1.add(rondaShadow2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, -80, 930, 270));

        puntos.setFont(new java.awt.Font("Pixeloid Sans", 0, 100)); // NOI18N
        puntos.setForeground(new java.awt.Color(255, 255, 255));
        puntos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        puntos.setText("0");
        jPanel1.add(puntos, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 840, 800, 130));

        puntosBase.setFont(new java.awt.Font("Pixeloid Sans", 0, 100)); // NOI18N
        puntosBase.setForeground(new java.awt.Color(153, 153, 153));
        puntosBase.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        puntosBase.setText("0");
        jPanel1.add(puntosBase, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 810, 800, 200));

        puntosShadow.setFont(new java.awt.Font("Pixeloid Sans", 0, 100)); // NOI18N
        puntosShadow.setForeground(new java.awt.Color(59, 113, 118));
        puntosShadow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        puntosShadow.setText("0");
        jPanel1.add(puntosShadow, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 810, 930, 210));

        triviaRespuesta2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/recursos/Jugaf2.png"))); // NOI18N
        triviaRespuesta2.setText("asdad");
        jPanel1.add(triviaRespuesta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 830, 680, 190));

        triviaRespuesta3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/recursos/Jugaf2.png"))); // NOI18N
        jPanel1.add(triviaRespuesta3, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 620, 680, 190));

        Pregunta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/recursos/Pregunta.png"))); // NOI18N
        jPanel1.add(Pregunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 1580, 550));

        triviaRespuesta5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/recursos/Jugaf2.png"))); // NOI18N
        triviaRespuesta5.setText("asdad");
        jPanel1.add(triviaRespuesta5, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 830, 680, 190));

        triviaRespuesta6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/recursos/Jugaf2.png"))); // NOI18N
        triviaRespuesta6.setText("asdad");
        jPanel1.add(triviaRespuesta6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 620, 680, 190));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/recursos/Partida.png"))); // NOI18N
        jPanel1.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -50, 1920, 1080));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1921, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        try {
            Menu entrada = new Menu();
            entrada.setVisible(true);
            this.dispose();
        } catch (ClassNotFoundException ex) {
            System.getLogger(Partida.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (Excepciones ex) {
            System.getLogger(Partida.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
        
    }//GEN-LAST:event_botonSalirActionPerformed
 // SI ES CORRECTA O NO CORRECTA AÑADIR UN JOPTION PANE QUE DIGA SI ES CORRECTA O INCORRECTA LA OPCION
    
    private void textPreguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPreguntaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textPreguntaActionPerformed

    private void textR4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textR4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textR4ActionPerformed

    private void textR2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textR2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textR2ActionPerformed

    private void textR1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textR1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textR1ActionPerformed

    private void textR3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textR3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textR3ActionPerformed

    private void botonRespuesta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRespuesta1ActionPerformed
        String respuesta = textR1.getText();
        if(respuesta.equals(pregunta.))
    }//GEN-LAST:event_botonRespuesta1ActionPerformed

    private void botonRespuesta2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRespuesta2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonRespuesta2ActionPerformed

    private void botonRespuesta3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRespuesta3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonRespuesta3ActionPerformed

    private void botonRespuesta4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRespuesta4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonRespuesta4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Partida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Partida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Partida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Partida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        PartidaLogica partida = new PartidaLogica();

/* Create and display the form */
java.awt.EventQueue.invokeLater(new Runnable() {
    public void run() {
        try {
            Partida ventana = new Partida(partida); 
            ventana.setVisible(true);

            ventana.iniciarPartida();  

        } catch (ClassNotFoundException | Excepciones ex) {
            System.getLogger(Partida.class.getName());
        }
    }
});
        

       
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Pregunta;
    private javax.swing.JButton botonRespuesta1;
    private javax.swing.JButton botonRespuesta2;
    private javax.swing.JButton botonRespuesta3;
    private javax.swing.JButton botonRespuesta4;
    private javax.swing.JButton botonSalir;
    private javax.swing.JLabel cat1;
    private javax.swing.JLabel cat2;
    private javax.swing.JLabel cat3;
    private javax.swing.JLabel exitBo;
    private javax.swing.JLabel fondo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel menuText;
    private javax.swing.JLabel menuTextBase;
    private javax.swing.JLabel menuTextShadow;
    private javax.swing.JLabel puntos;
    private javax.swing.JLabel puntosBase;
    private javax.swing.JLabel puntosShadow;
    private javax.swing.JLabel ronda;
    private javax.swing.JLabel rondaBase2;
    private javax.swing.JLabel rondaShadow2;
    private javax.swing.JLabel tCatText2;
    private javax.swing.JLabel tCatTextBase2;
    private javax.swing.JLabel tCatTextShadow2;
    private javax.swing.JTextField textPregunta;
    private javax.swing.JTextField textR1;
    private javax.swing.JTextField textR2;
    private javax.swing.JTextField textR3;
    private javax.swing.JTextField textR4;
    private javax.swing.JLabel triviaRespuesta2;
    private javax.swing.JLabel triviaRespuesta3;
    private javax.swing.JLabel triviaRespuesta5;
    private javax.swing.JLabel triviaRespuesta6;
    private javax.swing.JLabel usuario1;
    private javax.swing.JLabel usuario2;
    private javax.swing.JLabel usuario3;
    // End of variables declaration//GEN-END:variables
}
