/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demonlp;

import java.awt.Color;
import java.awt.List;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

/**
 *
 * @author admin
 */
public class NLPDemoFrm extends javax.swing.JFrame {

    /**
     * Creates new form NLPDemoFrm
     */
    public NLPDemoFrm() throws ClassNotFoundException, SQLException {
        initComponents();
        txtInputSentense.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 5));
        txtPartOfSentence.setEditable(false);

    }

    public NLPDemoFrm(String username) throws ClassNotFoundException, SQLException {
        initComponents();
        lbUsername.setText(username);
    }

    public JTextArea getTxtPartOfSentence() {
        return txtPartOfSentence;
    }
    DefaultListModel model = new DefaultListModel();
    String[] partOfSentence = null;
    String[] subjectArray = {"i", "you", "we", "they", "he", "she", "it"};
    String[] tobeArray = {"am", "is", "are"};
    String[] auxilaryVerbArray = {"do", "does", "did", "have", "has"};
    String[] possessiveAdjArray = {"my", "your", "our", "their", "his", "her", "its"};
    String[] objectArray = {"me", "you", "us", "them", "him", "her", "it"};

    ArrayList<String> listSubject = new ArrayList<>();
    ArrayList<String> listObject = new ArrayList<>();
    ArrayList<String> listVerb = new ArrayList<>();
    ArrayList<String> listTobe = new ArrayList<>();
    ArrayList<String> listAuxilaryVerb = new ArrayList<>();
    ArrayList<String> listPossessiveAdj = new ArrayList<>();

    ArrayList<String> listAdj = new ArrayList<>();
    ArrayList<String> listAdv = new ArrayList<>();
    ArrayList<String> listConjunct = new ArrayList<>();
    ArrayList<String> listPrep = new ArrayList<>();
    ArrayList<String> listInterjection = new ArrayList<>();
    ArrayList<String> listNoun = new ArrayList<>();
    ArrayList<String> listPronoun = new ArrayList<>();

    private void resetData() {
        txtInputSentense.setText("");
        txtInputSentense.requestFocus();
        txtPartOfSentence.setText("");
        lstResult.removeAll();
        btnSubmit.setEnabled(true);
        model.removeAllElements();
        lstResult.setModel(model);
        clearAllList();
    }

    private void clearAllList() {
        listAdj.clear();
        listAdv.clear();
        listAuxilaryVerb.clear();
        listConjunct.clear();
        listInterjection.clear();
        listNoun.clear();
        listObject.clear();
        listPossessiveAdj.clear();
        listPrep.clear();
        listPronoun.clear();
        listSubject.clear();
        listTobe.clear();
        listVerb.clear();
    }

    private String displayItemOfList() {
        String strDisplayItem = "";

        if (!listSubject.isEmpty()) {
            strDisplayItem += "\n Subject: " + listSubject;
        }
        if (!listObject.isEmpty()) {
            strDisplayItem += "\n Object:   " + listObject;
        }
        if (!listVerb.isEmpty()) {
            strDisplayItem += "\n Verb: " + listVerb;
        }
        if (!listTobe.isEmpty()) {
            strDisplayItem += "\n Tobe: " + listTobe;
        }
        if (!listAuxilaryVerb.isEmpty()) {
            strDisplayItem += "\n Auxilary verb:   " + listAuxilaryVerb;
        }
        if (!listPossessiveAdj.isEmpty()) {
            strDisplayItem += "\n Possessive adj:  " + listPossessiveAdj;
        }
        if (!listAdj.isEmpty()) {
            strDisplayItem += "\n Adjective:    " + listAdj;
        }
        if (!listAdv.isEmpty()) {
            strDisplayItem += "\n Adverb:   " + listAdv;
        }
        if (!listNoun.isEmpty()) {
            strDisplayItem += "\n Noun: " + listNoun;
        }
        if (!listPronoun.isEmpty()) {
            strDisplayItem += "\n Pronoun:  " + listPronoun;
        }
        if (!listConjunct.isEmpty()) {
            strDisplayItem += "\n Conjunction:  " + listConjunct;
        }
        if (!listInterjection.isEmpty()) {
            strDisplayItem += "\n Interjection: " + listInterjection;
        }
        if (!listPrep.isEmpty()) {
            strDisplayItem += "\n Prepostion:  " + listPrep;
        }
        if (listSubject.isEmpty() && listNoun.isEmpty()) {
            strDisplayItem += "\n Your sentence missing Subject \n";
        }
        if (listTobe.isEmpty() && listVerb.isEmpty()) {
            strDisplayItem += "\n Your sentence missing Main Verb \n";
        }
        return strDisplayItem;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtPartOfSentence = new javax.swing.JTextArea();
        txtInputSentense = new javax.swing.JTextField();
        btnRefresh = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lbUsername = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstResult = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(3, 185, 151));

        jLabel1.setFont(new java.awt.Font("Meiryo", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(241, 141, 158));
        jLabel1.setText("ENGLISH STRUCTURE CHECKING");

        txtPartOfSentence.setBackground(new java.awt.Color(187, 229, 211));
        txtPartOfSentence.setColumns(20);
        txtPartOfSentence.setForeground(new java.awt.Color(51, 51, 51));
        txtPartOfSentence.setRows(5);
        txtPartOfSentence.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Your sentence includes:", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 14), new java.awt.Color(51, 51, 51))); // NOI18N

        txtInputSentense.setBackground(new java.awt.Color(187, 229, 211));
        txtInputSentense.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        txtInputSentense.setForeground(new java.awt.Color(102, 102, 102));
        txtInputSentense.setAlignmentY(1.0F);
        txtInputSentense.setBorder(null);

        btnRefresh.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        btnRefresh.setForeground(new java.awt.Color(0, 102, 102));
        btnRefresh.setText("Refresh");
        btnRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRefreshMouseClicked(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(0, 102, 102));
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnSubmit.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        btnSubmit.setForeground(new java.awt.Color(0, 102, 102));
        btnSubmit.setText("Submit");
        btnSubmit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSubmitMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Input Sentence");

        lbUsername.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 18)); // NOI18N
        lbUsername.setForeground(new java.awt.Color(251, 211, 3));
        lbUsername.setText("Hai Anh Pham");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/NLP_Image/login-icon.png"))); // NOI18N

        lstResult.setBackground(new java.awt.Color(187, 229, 211));
        lstResult.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Do you mean: ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 14), new java.awt.Color(51, 51, 51))); // NOI18N
        lstResult.setSelectionBackground(new java.awt.Color(251, 211, 3));
        lstResult.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstResultMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lstResult);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(87, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(153, 153, 153))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(btnSubmit)
                                .addGap(44, 44, 44)
                                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtPartOfSentence, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addComponent(jScrollPane1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(13, 13, 13)
                                .addComponent(txtInputSentense, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(85, 85, 85))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtInputSentense, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPartOfSentence)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        jLabel1.getAccessibleContext().setAccessibleName("lblFormName");
        txtPartOfSentence.getAccessibleContext().setAccessibleName("txtPartOfSentence");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefreshMouseClicked
        resetData();
    }//GEN-LAST:event_btnRefreshMouseClicked

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        System.exit(1);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSubmitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSubmitMouseClicked
        // TODO add your handling code here:
        System.out.println("Starting...");
        btnSubmit.setEnabled(false);
        clearAllList();
        String checkSequenceOfPart = "";
        String result = "";

        //check is txtInputSentense null or not?
        if (txtInputSentense.getText().equals("")) {
            JOptionPane.showConfirmDialog(rootPane, "Input Sentences is empty!", "Caution", JOptionPane.CLOSED_OPTION);
        } else {
            //Step1: analysis sentence
            // setup a word array from input sentence.
            String sentences = txtInputSentense.getText().toString();
            partOfSentence = sentences.split(" ");

            for (int i = 0; i < partOfSentence.length; i++) {
                LogicHandles logicHandles = new LogicHandles();
                String strOriginal = logicHandles.checkTailOfWord(partOfSentence[i]);
                String strTemp = partOfSentence[i];
                partOfSentence[i] = strOriginal;

                //check if word is Subject
                if (logicHandles.checkSpecialTypeWord(subjectArray, partOfSentence[i])) {
                    listSubject.add(partOfSentence[i]);
                }
                //check if word is tobe
                if (logicHandles.checkSpecialTypeWord(tobeArray, partOfSentence[i])) {
                    listTobe.add(partOfSentence[i]);
                }
                //check if word is auxilary verb
                if (logicHandles.checkSpecialTypeWord(auxilaryVerbArray, partOfSentence[i])) {
                    listAuxilaryVerb.add(partOfSentence[i]);
                }
                //check if word is possessive adjective 
                if (logicHandles.checkSpecialTypeWord(possessiveAdjArray, partOfSentence[i])) {
                    listPossessiveAdj.add(partOfSentence[i]);
                }
                //check if word is Object
                if (logicHandles.checkSpecialTypeWord(objectArray, partOfSentence[i])) {
                    listObject.add(partOfSentence[i]);
                }
                //check others word type in Dtabase.
                try {
                    DatabaseHandles db = new DatabaseHandles();

                    //check if word is Verb
                    if (db.getWordTypeOf("entries", partOfSentence[i]).contains(CommonDefine.VERB)) {
                        //partOfSentence[i] = strOriginal;
                        listVerb.add(strTemp);
                    }

                    //check if word is Adjective
                    if (db.getWordTypeOf("entries", partOfSentence[i]).contains(CommonDefine.ADJECTIVE)) {
                        listAdj.add(partOfSentence[i]);
                    }

                    //check if word is Adverb
                    if (db.getWordTypeOf("entries", partOfSentence[i]).contains(CommonDefine.ADVERB)) {
                        listAdv.add(partOfSentence[i]);
                    }

                    //check if word is Conjunction
                    if (db.getWordTypeOf("entries", partOfSentence[i]).contains(CommonDefine.CONJUNCTION)) {
                        listConjunct.add(partOfSentence[i]);
                    }

                    //check if word is Interjection
                    if (db.getWordTypeOf("entries", partOfSentence[i]).contains(CommonDefine.INTERJECTION)) {
                        listInterjection.add(partOfSentence[i]);
                    }

                    //check if word is Noun
                    if (db.getWordTypeOf("entries", partOfSentence[i]).contains(CommonDefine.NOUN)) {
                        listNoun.add(partOfSentence[i]);
                    }

                    //check if word is Preposition
                    if (db.getWordTypeOf("entries", partOfSentence[i]).contains(CommonDefine.PREPOSITION)) {
                        listPrep.add(partOfSentence[i]);
                    }

                    //check if word is Pronoun
                    if (db.getWordTypeOf("entries", partOfSentence[i]).contains(CommonDefine.PRONOUN)) {
                        if (listObject.contains(partOfSentence[i])) {
                            continue;
                        } else {
                            listPronoun.add(partOfSentence[i]);
                        }
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(NLPDemoFrm.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(NLPDemoFrm.class.getName()).log(Level.SEVERE, null, ex);
                }
                //check the sequence of sentense parts
                if ((!logicHandles.isContainInList(partOfSentence[0], listSubject) && !logicHandles.isContainInList(partOfSentence[0], listNoun))
                        || (!logicHandles.isContainInList(partOfSentence[1], listVerb) && !logicHandles.isContainInList(partOfSentence[1], listTobe))) {
                    checkSequenceOfPart = "Wrong Sentence \n";
                        deleteNoun();
                       result = checkNounOrObject();
                } else {
                    checkSequenceOfPart = "Right Sentence \n";
                    result = txtInputSentense.getText();
                }
            }
            //to display part of sentence
            txtPartOfSentence.setText(checkSequenceOfPart + displayItemOfList());
        }
        model.addElement(result);
        lstResult.setModel(model);
        System.out.println(model);

    }//GEN-LAST:event_btnSubmitMouseClicked

    private void lstResultMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstResultMouseClicked
        // TODO add your handling code here
        String value = lstResult.getSelectedValue().toString();
        JOptionPane.showConfirmDialog(rootPane, value, "You mean:", JOptionPane.YES_NO_OPTION);
        if (true) {
            System.out.println("ok");
        } else {
            System.out.println("not ok");
        }
    }//GEN-LAST:event_lstResultMouseClicked

    private String checkNounOrObject(){
        if(listObject.size() != 0){
            return showResultReWriteCaseObject();
        } else{
            return showResultReWriteCaseNoun();
        }
    }
    
    private String showResultReWriteCaseNoun(){
        String totalResult = "";
        String strV = "";
        if(listSubject.size() >0){
            for (int indexS = 0; indexS < listSubject.size(); indexS++) {
                String strS = listSubject.get(indexS);
                if(listTobe.size() == 0){
                    for (int indexV = 0; indexV < listVerb.size();indexV++){
                        strV = listVerb.get(indexV);
                    }
                } else{
                    for (int indexT = 0; indexT < listTobe.size();indexT++){
                            strV = listTobe.get(indexT);
                    }
                }
                for (int indexN = 0; indexN < listNoun.size();indexN++) {
                    String strN = listNoun.get(indexN);
                    totalResult = strS+" "+strV+" "+strN+" \n";
                }
            }
        } else {
            // ko co subject 
            for(int indexN = 0; indexN < listNoun.size();indexN++) {
                String strN = listNoun.get(indexN);
                for(int indexV = 0; indexV < listVerb.size();indexV++) {
                     strV = listVerb.get(indexV);
                    for(int indexAdv = 0; indexAdv < listAdv.size(); indexAdv++) {
                    String strO = listAdv.get(indexAdv);
                    totalResult = strN+" "+strV+" "+listAdv+" \n";
                    }
                }
            }     
        }
        
         return totalResult;
    }
    
    private String showResultReWriteCaseObject(){
        String totalResult = "";
        
        
            for(int indexS = 0; indexS < listSubject.size();indexS++) {
                String strS = listSubject.get(indexS);
                for(int indexV = 0; indexV < listVerb.size();indexV++) {
                    String strV = listVerb.get(indexV);
                    for(int indexO = 0; indexO < listObject.size(); indexO++) {
                        String strO = listObject.get(indexO);
                        totalResult = strS+" "+strV+" "+strO+" \n";
                    }
                }
            }
         return totalResult;
    }
    
    private void deleteNoun() {
        for (int i = 0; i < listNoun.size();i++) {
            if(checkExistInVerb(listNoun.get(i)) || checkExistInTobe(listNoun.get(i))){
                listNoun.remove(i);
            }
        } 
    }
    
    private boolean checkExistInVerb(String str) {
    
        for (int i = 0; i < listVerb.size();i++) {
            if(str == listVerb.get(i)){
                return true;
            }
        }
        return false;
    }
    private boolean checkExistInTobe(String str) {
    
        for (int i = 0; i < listTobe.size();i++) {
            if(str == listTobe.get(i)){
                return true;
            }
        }
        return false;
    }
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
            java.util.logging.Logger.getLogger(NLPDemoFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NLPDemoFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NLPDemoFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NLPDemoFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new NLPDemoFrm().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(NLPDemoFrm.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(NLPDemoFrm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbUsername;
    private javax.swing.JList lstResult;
    private javax.swing.JTextField txtInputSentense;
    private javax.swing.JTextArea txtPartOfSentence;
    // End of variables declaration//GEN-END:variables
}
