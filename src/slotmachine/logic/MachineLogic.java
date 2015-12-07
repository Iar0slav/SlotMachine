package slotmachine.logic;

/**
 * Created by Iaroslav on 06.12.2015.
 */
public class MachineLogic {

    // храним баланс игрока
    private int balance     = 0;
    private int bet         = 1;
    private int currentWin  = 0;
    private boolean isWin   = false;

    // массив барабана
    /*
    Лимон (7)   - 1
    Вишня (6)   - 2
    Груша (5)   - 3
    Персик (4)  - 4
    777 (2)     - 5
    BAR (1)     - 0
     */
    private int[] barrel = {1, 1, 1, 1, 1, 1, 1,
                            2, 2, 2, 2, 2, 2,
                            3, 3, 3, 3, 3,
                            4, 4, 4, 4,
                            5, 5,
                            0};

    // собираем массив выпавших комбинаций, 3 слота
    public int[] sequence (){
        // храним выпавшую комбинацию
        int[] seqArray = new int[3];
        for (int i = 0; i < 3; i++){
            seqArray[i] = randomBarrel();
        }
        isWin = winCheck(seqArray);
        return seqArray;
    }

    // выбираем рандомно число из массива барабана
    private int randomBarrel (){
        int i;
        i = barrel[(int)(Math.random()*25)];
        return i;
    }

    /*
    проверяем массив на выиграшную комбинацию
    если выпала получаем выиграш и добавляем к балансу
    если нет - вычитаем из баланса ставку
     */
    private boolean winCheck(int[] seqArray){
        if (seqArray[0]==seqArray[1] && seqArray[1]==seqArray[2]){
            isWin = true;
            switch (seqArray[1]){
                case 0:
                    currentWin = bet * 100;
                    balance = balance - bet + currentWin;
                    break;
                case 1:
                    currentWin = bet * 10;
                    balance = balance - bet + currentWin;
                    break;
                case 2:
                    currentWin = bet * 20;
                    balance = balance - bet + currentWin;
                    break;
                case 3:
                    currentWin = bet * 30;
                    balance = balance - bet + currentWin;
                    break;
                case 4:
                    currentWin = bet * 40;
                    balance = balance - bet + currentWin;
                    break;
                case 5:
                    currentWin = bet * 50;
                    balance = balance - bet + currentWin;
                    break;
                default:
                    currentWin = 0;
                    balance = balance - bet;
                    isWin = false;
                    break;
            }
        } else {
            currentWin = 0;
            balance = balance - bet;
            isWin = false;
        }

        return isWin;
    }


    // геттры сеттеры

    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getCurrentWin() {
        return currentWin;
    }

    public boolean isWin() {
        return isWin;
    }
}
