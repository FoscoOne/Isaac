package forms;

public class Tools extends javax.swing.JPanel {

    private static boolean isViewMode = true;
    private static boolean isEditMode = false;
    private static boolean isDrawMode = false;
    private static String shape = "Rectangle";
    private static boolean isDebugMode = false;

    public Tools() {
        initComponents();
        jPanelModeDraw.setVisible(false);
    }

    public static boolean isViewMode() {
        return isViewMode;
    }

    public static boolean isEditMode() {
        return isEditMode;
    }

    public static boolean isDrawMode() {
        return isDrawMode;
    }

    public static String getShapeName() {
        if (isDrawMode) {
            return shape;
        } else {
            return null;
        }
    }
    
    public static void setDebugModeOn() {
        isDebugMode = true;
    }
    
    public static void setDebugModeOff() {
        isDebugMode = false;
    }
    
    public static boolean isDebugModeOn() {
        return isDebugMode;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupMod = new javax.swing.ButtonGroup();
        buttonGroupModDraw = new javax.swing.ButtonGroup();
        jPanelMode = new javax.swing.JPanel();
        jRadioButtonNahled = new javax.swing.JRadioButton();
        jRadioButtonEditovani = new javax.swing.JRadioButton();
        jRadioButtonKresleni = new javax.swing.JRadioButton();
        jPanelModeDraw = new javax.swing.JPanel();
        jRadioButtonRectangle = new javax.swing.JRadioButton();
        jRadioButtonCircle = new javax.swing.JRadioButton();

        setDoubleBuffered(false);

        jPanelMode.setBorder(javax.swing.BorderFactory.createTitledBorder("Mód"));

        buttonGroupMod.add(jRadioButtonNahled);
        jRadioButtonNahled.setSelected(true);
        jRadioButtonNahled.setText("Náhled");
        jRadioButtonNahled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonNahledActionPerformed(evt);
            }
        });

        buttonGroupMod.add(jRadioButtonEditovani);
        jRadioButtonEditovani.setText("Editování");
        jRadioButtonEditovani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonEditovaniActionPerformed(evt);
            }
        });

        buttonGroupMod.add(jRadioButtonKresleni);
        jRadioButtonKresleni.setText("Kreslení");
        jRadioButtonKresleni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonKresleniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelModeLayout = new javax.swing.GroupLayout(jPanelMode);
        jPanelMode.setLayout(jPanelModeLayout);
        jPanelModeLayout.setHorizontalGroup(
            jPanelModeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelModeLayout.createSequentialGroup()
                .addGroup(jPanelModeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonEditovani)
                    .addComponent(jRadioButtonNahled)
                    .addComponent(jRadioButtonKresleni))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelModeLayout.setVerticalGroup(
            jPanelModeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelModeLayout.createSequentialGroup()
                .addComponent(jRadioButtonNahled)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonEditovani)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonKresleni))
        );

        jPanelModeDraw.setBorder(javax.swing.BorderFactory.createTitledBorder("Mód - kreslení"));

        buttonGroupModDraw.add(jRadioButtonRectangle);
        jRadioButtonRectangle.setSelected(true);
        jRadioButtonRectangle.setText("Čtverec / Obdelník");
        jRadioButtonRectangle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonRectangleActionPerformed(evt);
            }
        });

        buttonGroupModDraw.add(jRadioButtonCircle);
        jRadioButtonCircle.setText("Elipsa");
        jRadioButtonCircle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonCircleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelModeDrawLayout = new javax.swing.GroupLayout(jPanelModeDraw);
        jPanelModeDraw.setLayout(jPanelModeDrawLayout);
        jPanelModeDrawLayout.setHorizontalGroup(
            jPanelModeDrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelModeDrawLayout.createSequentialGroup()
                .addGroup(jPanelModeDrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonRectangle)
                    .addComponent(jRadioButtonCircle))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelModeDrawLayout.setVerticalGroup(
            jPanelModeDrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelModeDrawLayout.createSequentialGroup()
                .addComponent(jRadioButtonRectangle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonCircle))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanelModeDraw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelMode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelModeDraw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(473, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

private void jRadioButtonKresleniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonKresleniActionPerformed
    setMode();
}//GEN-LAST:event_jRadioButtonKresleniActionPerformed

private void jRadioButtonEditovaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonEditovaniActionPerformed
    setMode();
}//GEN-LAST:event_jRadioButtonEditovaniActionPerformed

private void jRadioButtonNahledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonNahledActionPerformed
    setMode();
}//GEN-LAST:event_jRadioButtonNahledActionPerformed

private void jRadioButtonRectangleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonRectangleActionPerformed
    setShape();
}//GEN-LAST:event_jRadioButtonRectangleActionPerformed

private void jRadioButtonCircleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonCircleActionPerformed
    setShape();
}//GEN-LAST:event_jRadioButtonCircleActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupMod;
    private javax.swing.ButtonGroup buttonGroupModDraw;
    private javax.swing.JPanel jPanelMode;
    private javax.swing.JPanel jPanelModeDraw;
    private javax.swing.JRadioButton jRadioButtonCircle;
    private javax.swing.JRadioButton jRadioButtonEditovani;
    private javax.swing.JRadioButton jRadioButtonKresleni;
    private javax.swing.JRadioButton jRadioButtonNahled;
    private javax.swing.JRadioButton jRadioButtonRectangle;
    // End of variables declaration//GEN-END:variables

    private void setMode() {
        if (jRadioButtonNahled.isSelected()) {
            isViewMode = true;
            isDrawMode = false;
            isEditMode = false;
            System.out.println("View Mode");
            jPanelModeDraw.setVisible(false);
        }
        if (jRadioButtonKresleni.isSelected()) {
            isViewMode = false;
            isDrawMode = true;
            isEditMode = false;
            System.out.println("Draw Mode");
            jPanelModeDraw.setVisible(true);
        }
        if (jRadioButtonEditovani.isSelected()) {
            isViewMode = false;
            isDrawMode = false;
            isEditMode = true;
            System.out.println("Edit Mode");
            jPanelModeDraw.setVisible(false);
        }
    }

    private void setShape() {
        if (jRadioButtonRectangle.isSelected()) {
            shape = "Rectangle";
        } else if (jRadioButtonCircle.isSelected()) {
            shape = "Circle";
        } else {
            shape = "Rectangle";
        }
    }
}
