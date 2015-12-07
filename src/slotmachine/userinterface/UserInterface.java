package slotmachine.userinterface;

/**
 * Created by Iaroslav on 06.12.2015.
 */
public class UserInterface {

    public final String WELCOME     = "Добро пожаловать в игру \"Однорукий бандит\" \n" + "Для начала игры необходимо внести монеты в автомат. Принимаемая величина от 1 до 100.";
    public final String EXIT        = "exit";
    public final String ADDCOINS    = "Внесите монеты (или " + EXIT + " для выхода): ";
    public final String INCORRECT   = "Некорректное значение монет. Принимаемая величина от 1 до 100.";
    public final String BALANCE     = "Монет на игровом счету: ";
    public final String STARTGAME   = "Введите 1 - запустить барабан (ставка 1 монета) \n" + "Введите 2 - для окончания игры и получения выиграша";
    public final String NOTSELECT   = "Некорректный выбор.";
    public final String YOUWIN      = "Ваш выиргыш: ";
    public final String YOULOSE     = "Вы не выиграли.";
    public final String LOOSER      = "Вы все проиграли :( ";
    public final String GAMEOVER    = "Вы разорили автомат";
    public final String FINISHGAME  = "Игра окончена \n" + "Количество монет которые вы выиграли: ";
    public final String TAKEPRIZE   = "Заберите выигрыш в лотке для выдачи. Спасибо за игру.";

    private final String[] barrelArray = {"BAR", "Лимон", "Вишня", "Груша", "Персик", "777"};

    // получаем массив из выпавших интов и форматируем в массив строк, который понятнее для играющего
    public String[] outFormat(int[] barrelInt){
        String[] barrelString = new String[3];
        for (int i = 0; i < 3; i++){
            barrelString[i] = barrelArray[barrelInt[i]];
        }

        String[] outFormat = new String[5];
        String first = barrelString[0];
        int a = first.length();
        String second = barrelString[1];
        int b = second.length();
        String third = barrelString[2];
        int c = third.length();
        int temp = a + b + c + 16;
        String line1 = "";
        String line2 = "x";
        String line3 = "";

        for (int i = 0; i < temp; i++ ){
            line1 = line1 + "x";
        }
        outFormat[0] = line1;
        outFormat[4] = line1;

        for (int i = 0; i < a+4; i++ ){
            line2 = line2 + " ";
        }
        line2 = line2 + "x";

        for (int i = 0; i < b+4; i++ ){
            line2 = line2 + " ";
        }
        line2 = line2 + "x";

        for (int i = 0; i < c+4; i++ ){
            line2 = line2 + " ";
        }
        line2 = line2 + "x";
        outFormat[1] = line2;
        outFormat[3] = line2;

        line3 = "x  " + barrelString[0] + "  x  " + barrelString[1] + "  x  " + barrelString[2] + "  x";
        outFormat[2] = line3;



        return outFormat;
    }

}
