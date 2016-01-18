package Annotations.TextToFileSaver;

/**
 * Created by Ыг on 18.01.2016.
 */
/**
 * Created by Ыг on 15.01.2016.
 * 2. Написать класс TextContainer, который содержит в себе строку.
 * С помощью механизма аннотаций указать
 1) в какой файл должен сохраниться текст
 2) метод, который выполнит сохранение. Написать класс Saver,
 который сохранит поле класса TextContainer в указанный файл.
 @SaveTo(path=“c:\\file.txt”)
 class Container {
 String text = “…”;
 @Saver
 public void save(..) {…}
 }
 */
@SaveTo(path = "C:\\Users\\Ыг\\Desktop\\JAVA\\Random\\src\\main\\java\\Annotations\\TextToFileSaver\\SavedTxt.txt")
public class TextContainer {

    private String textTosave;

    public TextContainer(String textToSave){
        this.textTosave = textToSave;
    }


}