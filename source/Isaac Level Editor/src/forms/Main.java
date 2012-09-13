package forms;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Main extends javax.swing.JFrame {

    private final Preview preview;
    private final Tools tools;
    private String savePath = null;

    public Main() {
        initComponents();
        preview = new Preview();
        tools = new Tools();
        add(preview, BorderLayout.CENTER);
        add(tools, BorderLayout.EAST);
        pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screenSize.width - getWidth()) / 2,
                (screenSize.height - getHeight()) / 2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuSoubor = new javax.swing.JMenu();
        jMenuItemNovy = new javax.swing.JMenuItem();
        jMenuItemUlozit = new javax.swing.JMenuItem();
        jMenuItemUlozitJako = new javax.swing.JMenuItem();
        jMenuItemOtevrit = new javax.swing.JMenuItem();
        jMenuItemImportovat = new javax.swing.JMenuItem();
        jMenuItemExportovat = new javax.swing.JMenuItem();
        jMenuItemZavrit = new javax.swing.JMenuItem();
        jMenuUpravit = new javax.swing.JMenu();
        jMenuZobrazit = new javax.swing.JMenu();
        jMenuItemPodrobnostiObjektu = new javax.swing.JMenuItem();
        jMenuNapoveda = new javax.swing.JMenu();
        jMenuItemOvladani = new javax.swing.JMenuItem();
        jMenuItemAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Isaac Level Editor");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jMenuSoubor.setText("Soubor");

        jMenuItemNovy.setText("Nový");
        jMenuItemNovy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemNovyActionPerformed(evt);
            }
        });
        jMenuSoubor.add(jMenuItemNovy);

        jMenuItemUlozit.setText("Uložit");
        jMenuItemUlozit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemUlozitActionPerformed(evt);
            }
        });
        jMenuSoubor.add(jMenuItemUlozit);

        jMenuItemUlozitJako.setText("Uložit jako...");
        jMenuItemUlozitJako.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemUlozitJakoActionPerformed(evt);
            }
        });
        jMenuSoubor.add(jMenuItemUlozitJako);

        jMenuItemOtevrit.setText("Otevřít");
        jMenuItemOtevrit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemOtevritActionPerformed(evt);
            }
        });
        jMenuSoubor.add(jMenuItemOtevrit);

        jMenuItemImportovat.setText("Importovat");
        jMenuItemImportovat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemImportovatActionPerformed(evt);
            }
        });
        jMenuSoubor.add(jMenuItemImportovat);

        jMenuItemExportovat.setText("Exportovat");
        jMenuItemExportovat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExportovatActionPerformed(evt);
            }
        });
        jMenuSoubor.add(jMenuItemExportovat);

        jMenuItemZavrit.setText("Zavřít");
        jMenuItemZavrit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemZavritActionPerformed(evt);
            }
        });
        jMenuSoubor.add(jMenuItemZavrit);

        jMenuBar1.add(jMenuSoubor);

        jMenuUpravit.setText("Upravit");
        jMenuBar1.add(jMenuUpravit);

        jMenuZobrazit.setText("Zobrazit");

        jMenuItemPodrobnostiObjektu.setText("Podrobnosti objektů");
        jMenuItemPodrobnostiObjektu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPodrobnostiObjektuActionPerformed(evt);
            }
        });
        jMenuZobrazit.add(jMenuItemPodrobnostiObjektu);

        jMenuBar1.add(jMenuZobrazit);

        jMenuNapoveda.setText("Nápověda");

        jMenuItemOvladani.setText("Ovládání");
        jMenuItemOvladani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemOvladaniActionPerformed(evt);
            }
        });
        jMenuNapoveda.add(jMenuItemOvladani);

        jMenuItemAbout.setText("O programu");
        jMenuItemAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAboutActionPerformed(evt);
            }
        });
        jMenuNapoveda.add(jMenuItemAbout);

        jMenuBar1.add(jMenuNapoveda);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    exit();
}//GEN-LAST:event_formWindowClosing

private void jMenuItemNovyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemNovyActionPerformed
    if (preview.isInit()) {
        int rv = JOptionPane.showConfirmDialog(jMenuItemNovy, "Chcete zavřít současný projekt a otevřít nový?");
        if (rv == JOptionPane.OK_OPTION) {
            preview.reinit();
            savePath = null;
        }
    } else {
        preview.init();
        savePath = null;
    }
}//GEN-LAST:event_jMenuItemNovyActionPerformed

private void jMenuItemZavritActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemZavritActionPerformed
    exit();
}//GEN-LAST:event_jMenuItemZavritActionPerformed

private void jMenuItemExportovatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExportovatActionPerformed
    notSupportedYet();
}//GEN-LAST:event_jMenuItemExportovatActionPerformed

private void jMenuItemImportovatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemImportovatActionPerformed
    notSupportedYet();
}//GEN-LAST:event_jMenuItemImportovatActionPerformed

private void jMenuItemOtevritActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemOtevritActionPerformed
    JFileChooser jfc = new JFileChooser();
    if (jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
        preview.load(jfc.getSelectedFile().getPath());
        savePath = null;
    }
}//GEN-LAST:event_jMenuItemOtevritActionPerformed

private void jMenuItemUlozitJakoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemUlozitJakoActionPerformed
    JFileChooser jfc = new JFileChooser();
    if (jfc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
        savePath = jfc.getSelectedFile().getPath() + ".dat";
        preview.save(jfc.getSelectedFile().getPath() + ".dat");
    }
}//GEN-LAST:event_jMenuItemUlozitJakoActionPerformed

private void jMenuItemUlozitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemUlozitActionPerformed
    if (savePath != null) {
        preview.save(savePath);
    } else {
        JFileChooser jfc = new JFileChooser();
        if (jfc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            savePath = jfc.getSelectedFile().getPath() + ".dat";
            preview.save(jfc.getSelectedFile().getPath() + ".dat");
        }
    }
}//GEN-LAST:event_jMenuItemUlozitActionPerformed

private void jMenuItemPodrobnostiObjektuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPodrobnostiObjektuActionPerformed
    if (preview.isInit()) {
        if (Tools.isDebugModeOn()) {
            Tools.setDebugModeOff();
        } else {
            Tools.setDebugModeOn();
        }
        preview.repaint();
    }
}//GEN-LAST:event_jMenuItemPodrobnostiObjektuActionPerformed

private void jMenuItemOvladaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemOvladaniActionPerformed
    notSupportedYet();
}//GEN-LAST:event_jMenuItemOvladaniActionPerformed

private void jMenuItemAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAboutActionPerformed
    notSupportedYet();
}//GEN-LAST:event_jMenuItemAboutActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemAbout;
    private javax.swing.JMenuItem jMenuItemExportovat;
    private javax.swing.JMenuItem jMenuItemImportovat;
    private javax.swing.JMenuItem jMenuItemNovy;
    private javax.swing.JMenuItem jMenuItemOtevrit;
    private javax.swing.JMenuItem jMenuItemOvladani;
    private javax.swing.JMenuItem jMenuItemPodrobnostiObjektu;
    private javax.swing.JMenuItem jMenuItemUlozit;
    private javax.swing.JMenuItem jMenuItemUlozitJako;
    private javax.swing.JMenuItem jMenuItemZavrit;
    private javax.swing.JMenu jMenuNapoveda;
    private javax.swing.JMenu jMenuSoubor;
    private javax.swing.JMenu jMenuUpravit;
    private javax.swing.JMenu jMenuZobrazit;
    // End of variables declaration//GEN-END:variables

    private void exit() {
        int rv = JOptionPane.showConfirmDialog(this, "Opravdu chcete program ukončit?");
        if (rv == JOptionPane.OK_OPTION) {
            System.exit(0);
        }
    }

    private void notSupportedYet() {
        JOptionPane.showMessageDialog(this, "Ve vývoji...");
    }
}
