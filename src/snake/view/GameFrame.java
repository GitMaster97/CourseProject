package snake.view;

import snake.controller.GameController;

/**
 *
 * @author Miroslav
 */
public class GameFrame extends javax.swing.JFrame {
    GameController controller;
    private boolean paused;
    
    private static GameFrame instance;

    /**
     * Creates new form GameFrame
     */
    private GameFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {

        fieldPanel1 = new snake.view.FieldPanel();
        pauseButton = new javax.swing.JButton();
        stopButton = new javax.swing.JButton();
        startButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        levelLabel = new javax.swing.JLabel();
        infoLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fieldPanel1.setPreferredSize(new java.awt.Dimension(400, 400));

        javax.swing.GroupLayout fieldPanel1Layout = new javax.swing.GroupLayout(fieldPanel1);
        fieldPanel1.setLayout(fieldPanel1Layout);
        fieldPanel1Layout.setHorizontalGroup(
            fieldPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        fieldPanel1Layout.setVerticalGroup(
            fieldPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        pauseButton.setText("Пауза");
        pauseButton.setEnabled(false);
        pauseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseButtonActionPerformed(evt);
            }
        });

        stopButton.setText("Стоп");
        stopButton.setEnabled(false);
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });

        startButton.setText("Старт");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Управление: W - вверх S - вниз A - влево D - вправо");

        levelLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        levelLabel.setForeground(new java.awt.Color(25, 0, 0));
        levelLabel.setText("Уровень 1");

        infoLabel.setText("            ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fieldPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(9, 9, 9)
                            .addComponent(pauseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(29, 29, 29)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(levelLabel)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(57, 57, 57)
                                    .addComponent(stopButton, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addComponent(infoLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(fieldPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(infoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(levelLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startButton)
                    .addComponent(pauseButton)
                    .addComponent(stopButton))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//event_startButtonActionPerformed
        controller.start();

        setEnabledPauseButton(true);
        setEnabledStopButton(true);
        setEnabledStartButton(false);

        fieldPanel1.requestFocus();
    }//GEN-LAST:event_startButtonActionPerformed

    private void pauseButtonActionPerformed(java.awt.event.ActionEvent evt) {//event_pauseButtonActionPerformed
        if(!paused) {
            controller.pause();
            paused = true;
            pauseButton.setText("Продолжить");
        }
        else {
            controller.resume();
            paused = false;
            pauseButton.setText("Пауза");
        }
        fieldPanel1.requestFocus();
    }//event_pauseButtonActionPerformed

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//event_stopButtonActionPerformed
        controller.stop();
        fieldPanel1.requestFocus();
    }//event_stopButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static GameFrame create() {
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
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        instance = new GameFrame();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                instance.setVisible(true);
            }
        });

        return instance;
    }

    public void setController(GameController controller) {
        this.controller = controller;
        fieldPanel1.setController(controller);
    }

    public FieldPanel getFieldPanel() {
        return fieldPanel1;
    }

    public static GameFrame getInstance()  {
        return instance;
    }

    public void setEnabledStartButton(boolean status) {
        startButton.setEnabled(status);
    }
    public void setEnabledPauseButton(boolean status) {
        pauseButton.setEnabled(status);
    }
    public void setEnabledStopButton(boolean status) {
        stopButton.setEnabled(status);
    }

    public void resetPauseButton() {
        if(paused) {
            paused = false;
            pauseButton.setText("Пауза");
        }
    }


    // Variables declaration - do not modify//variables
    private snake.view.FieldPanel fieldPanel1;
    public static javax.swing.JLabel infoLabel;
    private javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel levelLabel;
    private javax.swing.JButton pauseButton;
    private javax.swing.JButton startButton;
    private javax.swing.JButton stopButton;
    // End of variables declaration//variables
}
