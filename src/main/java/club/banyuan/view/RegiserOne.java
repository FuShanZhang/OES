package club.banyuan.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static club.banyuan.controller.CheckRegister.*;

class RegisterOne extends JFrame {

    /**
     * Creates new form zhuce
     */
    public RegisterOne() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        regUserName = new JLabel();
        regUserNameInput = new JTextField();
        regPassword = new JLabel();
        regPasswordInput = new JTextField();
        regName = new JLabel();
        regNameInput = new JTextField();
        regId = new JLabel();
        regIdInput = new JTextField();
        regEmail = new JLabel();
        regEmailInput = new JTextField();
        regAddBatton = new JButton();
        regTitle = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        regUserName.setText("用户名：");

        regUserNameInput.setToolTipText("字母开头,允许5-16字节,允许字母数字下划线");

        regPassword.setText("密   码：");

        regPasswordInput.setToolTipText("必须包含大小写字母和数字的组合,不能使用特殊字符,长度在 8-16 之间");

        regName.setText("姓   名：");

        regNameInput.setToolTipText("支持少数民族和生僻字,长度2-20之间,少数民族中间使用·");

        regId.setText("学   号：");

        regIdInput.setToolTipText("至少1位数字");

        regEmail.setText("邮   箱：");

        regAddBatton.setText("注册");
        regAddBatton.setToolTipText("");
        regAddBatton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkUserName(regUserNameInput.getText());
                if (checkUserName(regUserNameInput.getText())&&checkPwd(regPasswordInput.getText())&&checkName(regNameInput.getText())&&checkStuNum(regIdInput.getText())&&checkEmail(regEmailInput.getText())) {
                    JOptionPane.showMessageDialog(new JLabel(),"注册成功！");
                    System.out.println(checkUserName(regUserName.getText()));
                    dispose();
                    Login.loginwin.setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(new JLabel(),"输入不合法，不符合规定字段已被重置");
                    if (!checkUserName(regUserNameInput.getText())) {
                        regUserNameInput.setText("");
                    }
                    if (!checkPwd(regPasswordInput.getText())) {
                        regPasswordInput.setText("");
                    }
                    if (!checkName(regNameInput.getText())) {
                        regNameInput.setText("");
                    }
                    if (!checkStuNum(regIdInput.getText())) {
                        regIdInput.setText("");
                    }
                    if (!checkEmail(regEmailInput.getText())) {
                        regEmailInput.setText("");
                    }
                }
            }
        });

        regTitle.setFont(new java.awt.Font("Lucida Grande", 0, 28)); // NOI18N
        regTitle.setHorizontalAlignment(SwingConstants.CENTER);
        regTitle.setText("注  册");
        regTitle.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
        regTitle.setHorizontalTextPosition(SwingConstants.CENTER);


        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(62, 62, 62)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                .addComponent(regId)
                                                                .addGap(27, 27, 27)
                                                                .addComponent(regIdInput, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                        .addComponent(regName)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(regNameInput, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                        .addComponent(regPassword)
                                                                        .addGap(27, 27, 27)
                                                                        .addComponent(regPasswordInput, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(regUserName)
                                                                .addGap(27, 27, 27)
                                                                .addComponent(regUserNameInput, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                .addComponent(regEmail)
                                                                .addGap(27, 27, 27)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(regEmailInput, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                                .addComponent(regAddBatton, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(68, 68, 68))))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(87, 87, 87)
                                                .addComponent(regTitle, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(62, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(regTitle, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(regUserName)
                                        .addComponent(regUserNameInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(regPassword)
                                        .addComponent(regPasswordInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(regName)
                                        .addComponent(regNameInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(regId)
                                        .addComponent(regIdInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(regEmail)
                                        .addComponent(regEmailInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addComponent(regAddBatton, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    /**
     */
    public static void start() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegisterOne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterOne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterOne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterOne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterOne().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private JButton regAddBatton;
    private JLabel regEmail;
    private JTextField regEmailInput;
    private JLabel regId;
    private JTextField regIdInput;
    private JLabel regName;
    private JTextField regNameInput;
    private JLabel regPassword;
    private JTextField regPasswordInput;
    private JLabel regTitle;
    private JLabel regUserName;
    private JTextField regUserNameInput;
    // End of variables declaration
}
