package com.javarush.task.task32.task3209;


import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

public class Controller {
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view) {
        this.view = view;
    }

    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        //устанавливаем у представления контроллер
        view.setController(controller);
        //инициализируем представление
        view.init();
        //инициализируем контроллер
        controller.init();
    }

    public HTMLDocument getDocument() {
        return document;
    }

    public void init(){
        createNewDocument();
    }

    public void exit(){
        System.exit(0);
    }
    //будет сбрасывать текущий документ
    public void resetDocument(){
        if(document != null) {
            document.removeUndoableEditListener(view.getUndoListener());
        }
            //Создавать новый документ по умолчанию
            document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
            //Добавлять новому документу слушателя правок
            document.addUndoableEditListener(view.getUndoListener());
            view.update();
    }
    //будет записывать переданный текст с html тегами в документ document
    public void setPlainText(String text){
        resetDocument();
        StringReader stringReader = new StringReader(text);
        try {
            new HTMLEditorKit().read(stringReader, document, 0);
        } catch (IOException | BadLocationException e) {
            ExceptionHandler.log(e);
        }
    }
    //должен получать текст из документа со всеми html тегами
    public String getPlainText(){
        StringWriter stringWriter = new StringWriter();
        try {
            new HTMLEditorKit().write(stringWriter, document, 0, document.getLength());
        } catch (IOException | BadLocationException | NullPointerException e) {
            ExceptionHandler.log(e);
        }
        String result = stringWriter.toString();
        return result;
    }

    public void createNewDocument() {
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML редактор");
        view.resetUndo();
        currentFile = null;
        
    }

    public void openDocument() {
        //Переключать представление на html вкладку
        view.selectHtmlTab();
        //Создать новый объект для выбора файла
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new HTMLFileFilter());
        //Показывать диалоговое окно "Save File" для выбора файла
        jFileChooser.setDialogTitle("Open");
        int selection = jFileChooser.showOpenDialog(view);
        //Если пользователь подтвердит выбор файла:
        //Сохранять выбранный файл в поле currentFile
        if(selection == JFileChooser.APPROVE_OPTION){
            currentFile = jFileChooser.getSelectedFile();
            resetDocument();
            //Сбросить документ
            //Устанавливать имя файла в качестве заголовка окна представления
            view.setTitle(currentFile.getName());
            try(FileReader reader = new FileReader(currentFile)) {

                //Переписывать данные из документа document в объекта FileWriter-а
                new HTMLEditorKit().read(reader, document,0);
            } catch (IOException | BadLocationException e) {
                ExceptionHandler.log(e);
            }
            view.resetUndo();
        }
    }

    public void saveDocument() {
        view.selectHtmlTab();
        if (currentFile==null){
            saveDocumentAs();
        }
        else {
            try(FileWriter fileWriter = new FileWriter(currentFile)){
                new HTMLEditorKit().write(fileWriter,document,0,document.getLength());
            }
            catch (IOException | BadLocationException e){ExceptionHandler.log(e);}

        }

    }

    public void saveDocumentAs() {
        //Переключать представление на html вкладку
        view.selectHtmlTab();
        //Создать новый объект для выбора файла
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new HTMLFileFilter());
        //Показывать диалоговое окно "Save File" для выбора файла
        jFileChooser.setDialogTitle("Save File");
        int selection = jFileChooser.showSaveDialog(view);
        //Если пользователь подтвердит выбор файла:
        //Сохранять выбранный файл в поле currentFile
        if(selection == JFileChooser.APPROVE_OPTION){
            currentFile = jFileChooser.getSelectedFile();
            //Устанавливать имя файла в качестве заголовка окна представления
            view.setTitle(currentFile.getName());
            try(FileWriter writer = new FileWriter(currentFile)) {

                //Переписывать данные из документа document в объекта FileWriter-а
                new HTMLEditorKit().write(writer, document,0, document.getLength());
            } catch (IOException | BadLocationException e) {
                ExceptionHandler.log(e);
            }
        }

    }
}
