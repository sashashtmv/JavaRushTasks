package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;
import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.undo.UndoManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class View extends JFrame implements ActionListener {
    private Controller controller;
    //панель с двумя вкладками
    private JTabbedPane tabbedPane = new JTabbedPane();
    //компонент для визуального редактирования html
    private JTextPane htmlTextPane = new JTextPane();
    //компонент для редактирования html в виде текста, он будет отображать код html (теги и их содержимое)
    private JEditorPane plainTextPane = new JEditorPane();

    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);

    public UndoListener getUndoListener() {
        return undoListener;
    }
    //будет вызваться при выборе пунктов меню, у которых наше представление указано в виде слушателя событий
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String result = actionEvent.getActionCommand();
        if(result.equals("Новый")) controller.createNewDocument();
        if(result.equals("Открыть")) controller.openDocument();
        if(result.equals("Сохранить")) controller.saveDocument();
        if(result.equals("Сохранить как...")) controller.saveDocumentAs();
        if(result.equals("Выход")) controller.exit();
        if(result.equals("О программе")) showAbout();
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void init(){
        initGui();
        //добавляем слушателя событий нашего окна
        FrameListener frameListener = new FrameListener(this);
        addWindowListener(frameListener);
        //показываем наше окно
        setVisible(true);
    }

    public void exit(){
        controller.exit();
    }

    //будут отвечать за инициализацию меню и панелей редактора
    public void initMenuBar(){

        JMenuBar menuBar = new JMenuBar();
        MenuHelper.initFileMenu(this, menuBar );
        MenuHelper.initEditMenu(this, menuBar);
        MenuHelper.initStyleMenu(this, menuBar);
        MenuHelper.initAlignMenu(this, menuBar);
        MenuHelper.initColorMenu(this, menuBar);
        MenuHelper.initFontMenu(this, menuBar);
        MenuHelper.initHelpMenu(this, menuBar);

        getContentPane().add(menuBar, BorderLayout.NORTH);

    }

    public void initEditor(){
        htmlTextPane.setContentType("text/html");
        //Добавляем вкладку в панель tabbedPane с именем "HTML"
        JScrollPane jScrollPane = new JScrollPane(htmlTextPane);
        tabbedPane.addTab("HTML", jScrollPane);
        //Добавляем вкладку в панель tabbedPane с именем "Текст"
        JScrollPane jScrollPane1 = new JScrollPane(plainTextPane);
        tabbedPane.addTab("Текст", jScrollPane1);
        //Устанавливаем предпочтительный размер панели tabbedPane
        tabbedPane.setPreferredSize(null);
        //добавляeтся слушатель изменений в tabbedPane - TabbedPaneChangeListener через метод addChangeListener
        tabbedPane.addChangeListener(new TabbedPaneChangeListener(this));
        //Добавлять по центру панели контента текущего фрейма нашу панель с вкладками
        //Получить панель контента текущего фрейма можно с помощью метода getContentPane()
        getContentPane().add(tabbedPane, BorderLayout.CENTER);



    }

    //будет инициализировать графический интерфейс
    public void initGui(){
        initMenuBar();
        initEditor();
        //подгоняет размер экрана под все компоненты, входящие в него
        pack();
    }


    public View(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            ExceptionHandler.log(e);
        }

    }

    public boolean canUndo() {
        return undoManager.canUndo();
    }

    public boolean canRedo() {
        return undoManager.canRedo();
    }
    //отменяет последнее действие
    public void undo(){
        try {
            undoManager.undo();
        }catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }
    //возвращает ранее отмененное действие
    public void redo(){
        try {
            undoManager.redo();
        }catch (Exception e){
            ExceptionHandler.log(e);
        }

    }
    //должен сбрасывать все правки в менеджере undoManager
    public void resetUndo(){
        undoManager.discardAllEdits();
    }
    //определяющий текущую вкладку
    public boolean isHtmlTabSelected(){
        if(tabbedPane.getSelectedIndex() == 0) return true;
        else return false;
    }
    //должен выбирать вкладку и сбрасывать все правки
    public void selectHtmlTab(){
        tabbedPane.setSelectedIndex(0);
        resetUndo();
    }
    //должен устанавливать документ в панель редактирования
    public void update(){
        htmlTextPane.setDocument(controller.getDocument());
    }
    //должен показывать диалоговое окно с информацией о программе
    public void showAbout(){
        JOptionPane.showMessageDialog(getContentPane(), "Version 1.0", "About", JOptionPane.INFORMATION_MESSAGE);
    }
    //метод вызывается, когда произошла смена выбранной вкладки
    public void selectedTabChanged() {
        if(tabbedPane.getSelectedIndex()==0){
            controller.setPlainText(plainTextPane.getText());
        }else if(tabbedPane.getSelectedIndex()==1)
            plainTextPane.setText(controller.getPlainText());

        resetUndo();
    }



}
