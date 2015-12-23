import slotmachine.logic.CheckForInt;
import slotmachine.logic.MachineLogic;
import slotmachine.userinterface.LocalizationRu;
import slotmachine.userinterface.UserInterface;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        UserInterface userInterface = new UserInterface();
        MachineLogic machineLogic = new MachineLogic();

        int coinBalance;
        boolean addCoin         = true;
        boolean game            = true;
        boolean lostEverything  = false;
        boolean takeAll         = false;

        // Приветствие
        System.out.println(LocalizationRu.WELCOME);

        // Вывод ко-ва монет на счету
        System.out.println(LocalizationRu.BALANCE + machineLogic.getBalance());

        // цикл обработки ввода монет
        do{
            // приглашение на ввод монет
            System.out.print(LocalizationRu.ADDCOINS);
            // получаем строку и проверяем числовая ли она
            Scanner addCoins = new Scanner(System.in);
            String isCoins = addCoins.nextLine();
            boolean isInt = CheckForInt.isInteger(isCoins);
            /*
            проверка на переменную ВЫХОД
            проверка на число
            иначе повторное приглашение на ввод и повтор цикла
            */
            if (isCoins.equals(LocalizationRu.EXIT)){
                System.exit(0);
            } else if(isInt){
                try {
                    coinBalance = Integer.parseInt(isCoins);
                    if(coinBalance > 0 && coinBalance < 101){
                        addCoin = false;
                        machineLogic.setBalance(coinBalance);
                    } else {
                        System.out.println(LocalizationRu.INCORRECT);
                    }
                } catch (NumberFormatException e) {
                    System.out.println(LocalizationRu.INCORRECT);
                }
            } else {
                System.out.println(LocalizationRu.INCORRECT);
            }
        } while(addCoin);

        // Вывод кол-ва монет на счету
        System.out.println(LocalizationRu.BALANCE + machineLogic.getBalance());

        // реализация игры
        do {
            // приглашение начать игру или выйти
            System.out.println(LocalizationRu.STARTGAME);
            // получаем строку и проверяем числовая ли она
            Scanner gameOrNot = new Scanner(System.in);
            String isGame = gameOrNot.nextLine();
            boolean isInt = CheckForInt.isInteger(isGame);
            /*
            проверка на число
            проверка на 1 - тогда игра, или 2 - тогда выход
            иначе повторное приглашение на ввод и повтор цикла
            */
            if (isInt){
                try {
                    int select = Integer.parseInt(isGame);
                    // игра
                    if(select == 1){

                        // получение выигрышной комбинации
                        int[] gameArray = machineLogic.sequence();

                        // преобразование комбинации в текстовый вид и форматирование вывода
                        String[] outArray = userInterface.getFormattedArray(gameArray);

                        // вывод комбинации
                        for (int i = 0; i < outArray.length; i++){
                            System.out.println(outArray[i]);
                        }

                        // если баланс после очередной игры ==0 то конец игры
                        if (machineLogic.getBalance()==0){
                            lostEverything = true;
                            game = false;

                            // если баланс >500 то тоже конец игры и выдача выигрыша
                        } else if (machineLogic.getBalance() > 500){
                            takeAll = true;
                            game = false;
                            // иначе если ставка сыграла то печать суммы выигрыша
                            // если не сыграла то печать проигрыша
                        } else {
                            if(machineLogic.isWin()){
                                System.out.println(LocalizationRu.YOUWIN + machineLogic.getCurrentWin());
                                System.out.println(LocalizationRu.BALANCE + machineLogic.getBalance());
                            } else {
                                System.out.println(LocalizationRu.YOULOSE);
                                System.out.println(LocalizationRu.BALANCE + machineLogic.getBalance());
                            }
                        }

                    } else if (select == 2){ // выход из игры
                        game = false;
                    } else {
                        System.out.println(LocalizationRu.NOTSELECT);
                    }
                } catch (NumberFormatException e) {
                    System.out.println(LocalizationRu.NOTSELECT);
                }
            } else {
                System.out.println(LocalizationRu.NOTSELECT);
            }

        } while (game);

        // окончание игры, обналичка или потеря всего
        if (lostEverything){
            System.out.println(LocalizationRu.LOOSER);
        } else if (takeAll){
            System.out.println(LocalizationRu.GAMEOVER);
            System.out.println(LocalizationRu.FINISHGAME + machineLogic.getBalance());
            System.out.println(LocalizationRu.TAKEPRIZE);
        } else {
            System.out.println(LocalizationRu.FINISHGAME + machineLogic.getBalance());
            System.out.println(LocalizationRu.TAKEPRIZE);
        }
    }
}
