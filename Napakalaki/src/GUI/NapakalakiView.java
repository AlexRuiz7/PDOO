
package GUI;

import javax.swing.JOptionPane;
import napakalaki.CombatResult;
import napakalaki.Napakalaki;

/**
 *
 * @author alex
 */
public class NapakalakiView extends javax.swing.JFrame {

    /**
     * Creates new form NapakalakiView
     */
    
    private Napakalaki napakalakiModel;
    
    public NapakalakiView() {
        initComponents();
    }

    
    public void setNapakalakiModel(Napakalaki napakalakiModel) {
        this.napakalakiModel = napakalakiModel;
        playerView.setPlayer(napakalakiModel.getCurrentPlayer());
        playerView.setNapakalakiView(this);
        monsterView.setMonsterModel(napakalakiModel.getCurrentMonster());
        
        combatButton.setEnabled(false);
        monsterView.setVisible(false);
        nextTurnButton.setEnabled(false);
        showMonsterButton.setEnabled(true);
        
        playerView.setStealEnabled(false);
        
        repaint();
        revalidate();
    }
    
    public void updateFrame(){
        if(napakalakiModel.nextTurnAllowed())
            nextTurnButton.setEnabled(true);
        
        repaint();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        monsterView = new GUI.MonsterView();
        showMonsterButton = new javax.swing.JButton();
        combatButton = new javax.swing.JButton();
        nextTurnButton = new javax.swing.JButton();
        playerView = new GUI.PlayerView();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Napakalaki");

        monsterView.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        showMonsterButton.setText("Ver Monstruo");
        showMonsterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showMonsterButtonActionPerformed(evt);
            }
        });

        combatButton.setText("¡¡ Combatir !!");
        combatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combatButtonActionPerformed(evt);
            }
        });

        nextTurnButton.setText("Pasar turno");
        nextTurnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextTurnButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(playerView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(monsterView, javax.swing.GroupLayout.PREFERRED_SIZE, 962, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(showMonsterButton)
                        .addGap(206, 206, 206)
                        .addComponent(combatButton)
                        .addGap(182, 182, 182)
                        .addComponent(nextTurnButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(playerView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(monsterView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showMonsterButton)
                    .addComponent(combatButton)
                    .addComponent(nextTurnButton))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void showMonsterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showMonsterButtonActionPerformed
        napakalakiModel.getCurrentMonster();
        
        combatButton.setEnabled(true);
        monsterView.setVisible(true);
        playerView.setMakeVisibleEnabled(false);
        playerView.setStealEnabled(false);
        playerView.setDiscardButtonEnabled(false);
        playerView.setDiscardAllEnabled(false);
    }//GEN-LAST:event_showMonsterButtonActionPerformed

    
    private void combatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combatButtonActionPerformed
        CombatResult result = napakalakiModel.developCombat();
           
          switch(result){
            case WINGAME : 
                JOptionPane.showMessageDialog(null, napakalakiModel.getCurrentPlayer().getName() + " ha ganado la partida !");
                System.exit(0);
                break;
            case WIN :
                JOptionPane.showMessageDialog(null, "Ganaste el combate");
                break;
            case LOSE :
                JOptionPane.showMessageDialog(null, "Has perdido el combate, te toca cumplir el mal rollo");
                break;
            case LOSEANDCONVERT :
                JOptionPane.showMessageDialog(null, "Has perdido el combate, además ahora eres sectario");
                break;
           }    
        
        showMonsterButton.setEnabled(false);
        combatButton.setEnabled(false);
        monsterView.setVisible(true);
        playerView.setMakeVisibleEnabled(true);
        playerView.setDiscardButtonEnabled(true);
        playerView.setDiscardAllEnabled(true);
        
        if(napakalakiModel.getCurrentPlayer().canISteal())
            playerView.setStealEnabled(true);
        
        playerView.setPlayer(napakalakiModel.getCurrentPlayer());
        
        if(napakalakiModel.nextTurnAllowed())
            nextTurnButton.setEnabled(true);
    }//GEN-LAST:event_combatButtonActionPerformed

    
    private void nextTurnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextTurnButtonActionPerformed
        napakalakiModel.nextTurn();
        setNapakalakiModel(Napakalaki.getInstance());
    }//GEN-LAST:event_nextTurnButtonActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton combatButton;
    private GUI.MonsterView monsterView;
    private javax.swing.JButton nextTurnButton;
    private GUI.PlayerView playerView;
    private javax.swing.JButton showMonsterButton;
    // End of variables declaration//GEN-END:variables
}