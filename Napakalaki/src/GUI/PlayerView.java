
package GUI;

import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import napakalaki.CultistPlayer;
import napakalaki.Napakalaki;
import napakalaki.Player;
import napakalaki.Treasure;

/**
 *
 * @author alex
 */
public class PlayerView extends javax.swing.JPanel {

    private Player playerModel;
    private Napakalaki napakalakiModel;
    private NapakalakiView napakalakiFrame;
    
    /**
     * Creates new form PlayerView
     */
    public PlayerView() {
        initComponents();
    }
    
    public void setPlayer(Player p) {
        playerModel = p;
        name.setText(p.getName());
        level.setText(Integer.toString(p.getLevel()));
        combatLevel.setText(Integer.toString(p.getCombatLevel()));
        enemy.setText(p.getEnemy().getName());
        pendingBadConsequence.setPendingBC(p.getPendingBadConsequence());
        if(p instanceof CultistPlayer){
            cultist.setText("Sí");
            totalCultist.setText(Integer.toString(CultistPlayer.getTotalCultistPlayers()));
        }   
        else
            cultist.setText("No");
        this.fillTreasurePanel(visibleTreasures, p.getVisibleTreasures());
        this.fillTreasurePanel(hiddenTreasures, p.getHiddenTreasures());
        
        setNapakalakiModel();
        
        repaint();
        revalidate();
    }
    
    private void fillTreasurePanel(JPanel aPanel, ArrayList<Treasure> aList) {
        
        // Se elimina la información antigua, si la hubiera
        
        aPanel.removeAll();
        
        // Se recorre la lista de tesoros construyendo y añadiendo sus vistas
        // al panel
        
        for(Treasure t : aList) {
            TreasureView aTreasureView = new TreasureView();
            aTreasureView.setTreasure(t);
            aTreasureView.setVisible(true);
            aPanel.add(aTreasureView);
        }
        
        // Se fuerza la actualización visual del panel
        
        aPanel.repaint();
        aPanel.revalidate();
    }

    public void setNapakalakiModel() {
        napakalakiModel = Napakalaki.getInstance();
        repaint();
    }
    
    public void setNapakalakiView(NapakalakiView n){
        napakalakiFrame = n;
    }
    
    private ArrayList<Treasure> getSelectedTreasures(JPanel panel){
        ArrayList<Treasure> selected = new ArrayList();
        TreasureView tv;
        
        for(Component c:panel.getComponents()){
            tv = (TreasureView) c;
            if(tv.isSelected())
                selected.add(tv.getTreasure());
        }
        
        return selected;
    }
    
    void setStealEnabled(boolean set){
        stealButton.setEnabled(set);
    }
    
    void setMakeVisibleEnabled(boolean set){
        setVisibleButton.setEnabled(set);
    }
    
    void setDiscardButtonEnabled(boolean set){
        discardButton.setEnabled(set);
    }
    
    void setDiscardAllEnabled(boolean set){
        discardAllButton.setEnabled(set);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        stealButton = new javax.swing.JButton();
        setVisibleButton = new javax.swing.JButton();
        discardButton = new javax.swing.JButton();
        discardAllButton = new javax.swing.JButton();
        playerAttributes = new javax.swing.JPanel();
        combatLevelLabel = new javax.swing.JLabel();
        levelLabel = new javax.swing.JLabel();
        enemyLabel = new javax.swing.JLabel();
        cultisitLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        level = new javax.swing.JLabel();
        combatLevel = new javax.swing.JLabel();
        enemy = new javax.swing.JLabel();
        cultist = new javax.swing.JLabel();
        totalCultistsLabel = new javax.swing.JLabel();
        totalCultist = new javax.swing.JLabel();
        vTreasuresLabel = new javax.swing.JLabel();
        visibleTreasures = new javax.swing.JPanel();
        hTreasuresLabel = new javax.swing.JLabel();
        hiddenTreasures = new javax.swing.JPanel();
        pendingBadConsequence = new GUI.PendingBadConsequence();

        stealButton.setText("Robar");
        stealButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stealButtonActionPerformed(evt);
            }
        });

        setVisibleButton.setText("Equipar");
        setVisibleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setVisibleButtonActionPerformed(evt);
            }
        });

        discardButton.setText("Descartar");
        discardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discardButtonActionPerformed(evt);
            }
        });

        discardAllButton.setText("Descartar todos");
        discardAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discardAllButtonActionPerformed(evt);
            }
        });

        playerAttributes.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        combatLevelLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        combatLevelLabel.setText("Nivel de combate:");

        levelLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        levelLabel.setText("Nivel:");

        enemyLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        enemyLabel.setText("Enemigo:");

        cultisitLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        cultisitLabel.setText("Sectario:");

        nameLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        nameLabel.setText("Jugador:");

        name.setForeground(new java.awt.Color(18, 25, 253));

        enemy.setForeground(new java.awt.Color(171, 6, 6));

        totalCultistsLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        totalCultistsLabel.setText("Número de sectarios:");

        javax.swing.GroupLayout playerAttributesLayout = new javax.swing.GroupLayout(playerAttributes);
        playerAttributes.setLayout(playerAttributesLayout);
        playerAttributesLayout.setHorizontalGroup(
            playerAttributesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playerAttributesLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(playerAttributesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(playerAttributesLayout.createSequentialGroup()
                        .addComponent(totalCultistsLabel)
                        .addGap(18, 18, 18)
                        .addComponent(totalCultist))
                    .addGroup(playerAttributesLayout.createSequentialGroup()
                        .addComponent(cultisitLabel)
                        .addGap(18, 18, 18)
                        .addComponent(cultist))
                    .addGroup(playerAttributesLayout.createSequentialGroup()
                        .addComponent(levelLabel)
                        .addGap(18, 18, 18)
                        .addComponent(level))
                    .addGroup(playerAttributesLayout.createSequentialGroup()
                        .addComponent(nameLabel)
                        .addGap(18, 18, 18)
                        .addComponent(name))
                    .addGroup(playerAttributesLayout.createSequentialGroup()
                        .addComponent(combatLevelLabel)
                        .addGap(18, 18, 18)
                        .addComponent(combatLevel))
                    .addGroup(playerAttributesLayout.createSequentialGroup()
                        .addComponent(enemyLabel)
                        .addGap(18, 18, 18)
                        .addComponent(enemy)))
                .addContainerGap(237, Short.MAX_VALUE))
        );
        playerAttributesLayout.setVerticalGroup(
            playerAttributesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playerAttributesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(playerAttributesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(name))
                .addGap(18, 18, 18)
                .addGroup(playerAttributesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(levelLabel)
                    .addComponent(level))
                .addGap(18, 18, 18)
                .addGroup(playerAttributesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combatLevelLabel)
                    .addComponent(combatLevel))
                .addGap(18, 18, 18)
                .addGroup(playerAttributesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enemyLabel)
                    .addComponent(enemy))
                .addGap(18, 18, 18)
                .addGroup(playerAttributesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cultisitLabel)
                    .addComponent(cultist))
                .addGap(18, 18, 18)
                .addGroup(playerAttributesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalCultistsLabel)
                    .addComponent(totalCultist))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        vTreasuresLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        vTreasuresLabel.setText("Tesoros Visibles");

        visibleTreasures.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        visibleTreasures.setLayout(new java.awt.GridLayout());

        hTreasuresLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        hTreasuresLabel.setText("Tesoros Ocultos");

        hiddenTreasures.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        hiddenTreasures.setLayout(new java.awt.GridLayout(1, 0));

        pendingBadConsequence.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(playerAttributes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(visibleTreasures, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pendingBadConsequence, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(discardAllButton)
                            .addComponent(discardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(setVisibleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(stealButton, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(hiddenTreasures, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addComponent(vTreasuresLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(hTreasuresLabel)
                .addGap(202, 202, 202))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {discardAllButton, discardButton, setVisibleButton, stealButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(stealButton)
                        .addGap(18, 18, 18)
                        .addComponent(setVisibleButton)
                        .addGap(18, 18, 18)
                        .addComponent(discardButton)
                        .addGap(18, 18, 18)
                        .addComponent(discardAllButton))
                    .addComponent(playerAttributes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pendingBadConsequence, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hTreasuresLabel)
                    .addComponent(vTreasuresLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(visibleTreasures, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(hiddenTreasures, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void setVisibleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setVisibleButtonActionPerformed
        ArrayList<Treasure> selHidden = getSelectedTreasures(hiddenTreasures);
        napakalakiModel.makeTreasuresVisible(selHidden);
        setPlayer(napakalakiModel.getCurrentPlayer());
    }//GEN-LAST:event_setVisibleButtonActionPerformed

    private void discardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discardButtonActionPerformed
        ArrayList<Treasure> selVisible = getSelectedTreasures(visibleTreasures);
        ArrayList<Treasure> selHidden = getSelectedTreasures(hiddenTreasures);

        napakalakiModel.discardVisibleTreasures(selVisible);
        napakalakiModel.discardHiddenTreasures(selHidden);

        setPlayer(napakalakiModel.getCurrentPlayer());
        napakalakiFrame.updateFrame();
    }//GEN-LAST:event_discardButtonActionPerformed

    private void discardAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discardAllButtonActionPerformed
        napakalakiModel.getCurrentPlayer().discardAllTreasures();
        setPlayer(napakalakiModel.getCurrentPlayer());
        napakalakiFrame.updateFrame();
    }//GEN-LAST:event_discardAllButtonActionPerformed

    private void stealButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stealButtonActionPerformed
        napakalakiModel.getCurrentPlayer().stealTreasure();

        if(!napakalakiModel.getCurrentPlayer().canISteal())
            stealButton.setEnabled(false);

        setPlayer(napakalakiModel.getCurrentPlayer());
    }//GEN-LAST:event_stealButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel combatLevel;
    private javax.swing.JLabel combatLevelLabel;
    private javax.swing.JLabel cultisitLabel;
    private javax.swing.JLabel cultist;
    private javax.swing.JButton discardAllButton;
    private javax.swing.JButton discardButton;
    private javax.swing.JLabel enemy;
    private javax.swing.JLabel enemyLabel;
    private javax.swing.JLabel hTreasuresLabel;
    private javax.swing.JPanel hiddenTreasures;
    private javax.swing.JLabel level;
    private javax.swing.JLabel levelLabel;
    private javax.swing.JLabel name;
    private javax.swing.JLabel nameLabel;
    private GUI.PendingBadConsequence pendingBadConsequence;
    private javax.swing.JPanel playerAttributes;
    private javax.swing.JButton setVisibleButton;
    private javax.swing.JButton stealButton;
    private javax.swing.JLabel totalCultist;
    private javax.swing.JLabel totalCultistsLabel;
    private javax.swing.JLabel vTreasuresLabel;
    private javax.swing.JPanel visibleTreasures;
    // End of variables declaration//GEN-END:variables
}
