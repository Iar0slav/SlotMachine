package slotmachine.userinterface;

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

    // получаем отформатированный масив строк для вывода в консоль
    public String[] getFormattedArray(int[] barrelInt){
        return formatting(barrelInt);
    }

    // формируев масив строк для красивой выдачи
    private String[] formatting(int[] barrelInt){

        // промежуточный массив вместо чисел названия элементов
        String[] barrelString = changeFormat(barrelInt);

        // далее готовим красивый вывод, пока не очень красивым кодом...
        String[] outFormat = new String[5];

        int a = barrelString[0].length();
        int b = barrelString[1].length();
        int c = barrelString[2].length();
        int temp = a + b + c + 16;
        String line04 = "";
        String line13 = "x";
        String line2 = "";

        // строки первая и пятая
        for (int i = 0; i < temp; i++ ){
            line04 = line04 + "x";
        }
        outFormat[0] = line04;
        outFormat[4] = line04;

        // строки вторая и четвертая
        for (int i = 0; i < a+4; i++ ){
            line13 = line13 + " ";
        }
        line13 = line13 + "x";

        for (int i = 0; i < b+4; i++ ){
            line13 = line13 + " ";
        }
        line13 = line13 + "x";

        for (int i = 0; i < c+4; i++ ){
            line13 = line13 + " ";
        }
        line13 = line13 + "x";
        outFormat[1] = line13;
        outFormat[3] = line13;

        // строка третья
        line2 = "x  " + barrelString[0] + "  x  " + barrelString[1] + "  x  " + barrelString[2] + "  x";
        outFormat[2] = line2;

        return outFormat;
    }

    // преобразуем масив интов в массив элементов, который понятнее для играющего
    private String[] changeFormat(int[] barrelInt){
        String[] barrelString = new String[3];
        for (int i = 0; i < 3; i++){
            barrelString[i] = barrelArray[barrelInt[i]];
        }
        return barrelString;
    }
}
