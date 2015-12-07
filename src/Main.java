import slotmachine.logic.CheckForInt;
import slotmachine.logic.MachineLogic;
import slotmachine.userinterface.UserInterface;

import java.util.Scanner;

/**
 * Created by Iaroslav on 06.12.2015.
 */
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
        System.out.println(userInterface.WELCOME);

        // Вывод ко-ва монет на счету
        System.out.println(userInterface.BALANCE + machineLogic.getBalance());

        // цикл обработки ввода монет
        do{
            // приглашение на ввод монет
            System.out.print(userInterface.ADDCOINS);
            // получаем строку и проверяем числовая ли она
            Scanner addCoins = new Scanner(System.in);
            String isCoins = addCoins.nextLine();
            boolean isInt = CheckForInt.isInteger(isCoins);
            /*
            проверка на переменную ВЫХОД
            проверка на число
            иначе повторное приглашение на ввод и повтор цикла
            */
            if (isCoins.equals(userInterface.EXIT)){
                System.exit(0);
            } else if(isInt){
                try {
                    coinBalance = Integer.parseInt(isCoins);
                    if(coinBalance > 0 && coinBalance < 101){
                        addCoin = false;
                        machineLogic.setBalance(coinBalance);
                    } else {
                        System.out.println(userInterface.INCORRECT);
                    }
                } catch (NumberFormatException e) {
                    System.out.println(userInterface.INCORRECT);
                }
            } else {
                System.out.println(userInterface.INCORRECT);
            }
        } while(addCoin);

        // Вывод ко-ва монет на счету
        System.out.println(userInterface.BALANCE + machineLogic.getBalance());

        // реализация игры
        do {
            // приглашение начать игру или выйти
            System.out.println(userInterface.STARTGAME);
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
                    if(select == 1){
                        int[] gameArray = machineLogic.sequence();
                        String[] outArray = userInterface.outFormat(gameArray);

                        for (int i = 0; i < outArray.length; i++){
                            System.out.println(outArray[i]);
                        }

                        if (machineLogic.getBalance()==0){
                            lostEverything = true;
                            game = false;
                        } else if (machineLogic.getBalance() > 500){
                            takeAll = true;
                            game = false;
                        } else {
                            if(machineLogic.isWin()){
                                System.out.println(userInterface.YOUWIN + machineLogic.getCurrentWin());
                                System.out.println(userInterface.BALANCE + machineLogic.getBalance());
                            } else {
                                System.out.println(userInterface.YOULOSE);
                                System.out.println(userInterface.BALANCE + machineLogic.getBalance());
                            }
                        }

                    } else if (select == 2){
                        game = false;
                    } else {
                        System.out.println(userInterface.NOTSELECT);
                    }
                } catch (NumberFormatException e) {
                    System.out.println(userInterface.NOTSELECT);
                }
            } else {
                System.out.println(userInterface.NOTSELECT);
            }

        } while (game);

        // окончание игры, обналичка или потеря всего
        if (lostEverything){
            System.out.println(userInterface.LOOSER);
        } else if (takeAll){
            System.out.println(userInterface.GAMEOVER);
            System.out.println(userInterface.FINISHGAME + machineLogic.getBalance());
            System.out.println(userInterface.TAKEPRIZE);
        } else {
            System.out.println(userInterface.FINISHGAME + machineLogic.getBalance());
            System.out.println(userInterface.TAKEPRIZE);
        }
    }
}