package tests.testng.objects;

public interface Button {
    //Смотрим имя кнопки
    public String getTextOfElement();

    //Проверяем наличие кнопки
    public Boolean getButton();

    //Пробуем нажать на кнопку
    public void clickButton() throws InterruptedException;

    //Смотрим текст в всплывающем окне
    public void getTextPunktWindow();
}