// Armadillo 4000 ASCII title courtesy http://www.patorjk.com/software/taag
// ASCII art armadillo courtesy https://jmilor.startlogic.com/asciiart/ARMADILO.TXT

import java.io.IOException;

public class UserInterface {

    public UserInterface() {
    }


    ///////////////////////////////////////////////////
    //                                               //
    //   Displays the Armadillo 4000 splash screen   //
    //                                               //
    ///////////////////////////////////////////////////

    public static void displaySplashScreen() throws IOException {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println("     *                                                                                           *");
        System.out.println("     *                                                                                           *");
        System.out.println("     *            _                             _ _ _ _         _  _    ___   ___   ___          *");
        System.out.println("     *           / \\   _ __ _ __ ___   __ _  __| (_) | | ___   | || |  / _ \\ / _ \\ / _ \\         *");
        System.out.println("     *          / _ \\ | '__| '_ ` _ \\ / _` |/ _` | | | |/ _ \\  | || |_| | | | | | | | | |        *");
        System.out.println("     *         / ___ \\| |  | | | | | | (_| | (_| | | | | (_) | |__   _| |_| | |_| | |_| |        *");
        System.out.println("     *        /_/   \\_\\_|  |_| |_| |_|\\__,_|\\__,_|_|_|_|\\___/     |_|  \\___/ \\___/ \\___/         *");
        System.out.println("     *                                                                                           *");
        System.out.println("     *                                         ,.-----__                                         *");
        System.out.println("     *                                      ,:::://///,:::-.                                     *");
        System.out.println("     *                                     /:''/////// ``:::`;/|/                                *");
        System.out.println("     *                                    /'   ||||||     :://'`\\                                *");
        System.out.println("     *                                  .' ,   ||||||     `/(  e \\                               *");
        System.out.println("     *                            -===~__-'\\__X_`````\\_____/~`-._ `.                             *");
        System.out.println("     *                                        ~~        ~~       `~-'                            *");
        System.out.println("     *                                                                                           *");
        System.out.println("     *                                                                                           *");
        System.out.println("     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println();
        System.out.println();
        System.out.println("                                        Press enter to continue");
        System.in.read();
        System.out.println();
    }


    ////////////////////////////////////////////
    //                                        //
    //   Displays the Main Menu and accepts   //
    //   the user's menu selection            //
    //                                        //
    ////////////////////////////////////////////

    public static void displayMainMenu() {
        System.out.println();
        System.out.println();
        System.out.println("                                           M a i n   M e n u");
        System.out.println("                                      ---------------------------");
        System.out.println("                                      1 - Monitor a Stock on NYSE");
        System.out.println("                                      2 - Monitor a Cryptocurrency");
        System.out.println("                                      3 - About Armadillo 4000");
        System.out.println("                                      4 - Exit Program");
        System.out.println();
        System.out.println("                                      To make a selection, enter the");
        System.out.print("                                      corresponding number: ");
    }

    public static void displayMainMenuInputError() {
        System.out.println();
        System.out.println();
        System.out.println("                                   !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("                                   !!                               !!");
        System.out.println("                                   !!   I N V A L I D   I N P U T   !!");
        System.out.println("                                   !!   =========================   !!");
        System.out.println("                                   !!   The Main Menu selection     !!");
        System.out.println("                                   !!   must be a number between    !!");
        System.out.println("                                   !!   1 and 4.                    !!");
        System.out.println("                                   !!                               !!");
        System.out.println("                                   !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }


    ///////////////////////////////////////////////
    //                                           //
    //   Displays the Monitor Options menu and   //
    //   accepts the user's menu selection       //
    //                                           //
    ///////////////////////////////////////////////

    public static void displayMonitorOptionsMenu() {
        System.out.println();
        System.out.println();
        System.out.println("                                      M o n i t o r   O p t i o n s");
        System.out.println("                                      -----------------------------");
        System.out.println("                                      1 - Percent Increase/Decrease");
        System.out.println("                                      2 - Relative Strength Index");
        System.out.println("                                      3 - Simple Moving Average");
        System.out.println();
        System.out.println("                                      To make a selection, enter the");
        System.out.print("                                      corresponding number: ");
    }

    public static void displayMonitorOptionsMenuInputError() {
        System.out.println();
        System.out.println();
        System.out.println("                                   !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("                                   !!                               !!");
        System.out.println("                                   !!   I N V A L I D   I N P U T   !!");
        System.out.println("                                   !!   =========================   !!");
        System.out.println("                                   !!   The Monitor Options menu    !!");
        System.out.println("                                   !!   selection must be a number  !!");
        System.out.println("                                   !!   between 1 and 3.            !!");
        System.out.println("                                   !!                               !!");
        System.out.println("                                   !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }

    public static void requestStockSymbolInput() {
        System.out.println();
        System.out.println("                                      Enter the ticker symbol of");
        System.out.print("                                      a stock to monitor: ");
    }

    public static void displayWaitTimeMessage() {
        System.out.println();
        System.out.println("                                      This may take a moment...");
        System.out.println();
    }

    public static void displayInvalidStockSymbolError() {
        System.out.println();
        System.out.println("                                   !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("                                   !!                             !!");
        System.out.println("                                   !!        I N V A L I D        !!");
        System.out.println("                                   !!   S T O C K   S Y M B O L   !!");
        System.out.println("                                   !!   =======================   !!");
        System.out.println("                                   !!   Monitoring is available   !!");
        System.out.println("                                   !!   only for stocks that      !!");
        System.out.println("                                   !!   are currently traded      !!");
        System.out.println("                                   !!   on the New York Stock     !!");
        System.out.println("                                   !!   Exchange (NYSE).          !!");
        System.out.println("                                   !!                             !!");
        System.out.println("                                   !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println();
    }

    public static void displayPercentIncreaseInputError() {
        System.out.println();
        System.out.println();
        System.out.println("                                   !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("                                   !!                               !!");
        System.out.println("                                   !!   I N V A L I D   I N P U T   !!");
        System.out.println("                                   !!   =========================   !!");
        System.out.println("                                   !!   The percent increase must   !!");
        System.out.println("                                   !!   be a number above 0.        !!");
        System.out.println("                                   !!                               !!");
        System.out.println("                                   !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println();
    }

    public static void displayPercentDecreaseInputError() {
        System.out.println();
        System.out.println();
        System.out.println("                                   !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("                                   !!                               !!");
        System.out.println("                                   !!   I N V A L I D   I N P U T   !!");
        System.out.println("                                   !!   =========================   !!");
        System.out.println("                                   !!   The percent decrease must   !!");
        System.out.println("                                   !!   be a number above 0 and     !!");
        System.out.println("                                   !!   less than or equal to 100.  !!");
        System.out.println("                                   !!                               !!");
        System.out.println("                                   !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println();
    }
    public static void displayAlertChangeOption() {
        System.out.println();
        System.out.println();
        System.out.println("                                      Would you like to keep these");
        System.out.println("                                      alert settings?");
        System.out.println();
        System.out.println("                                      Enter N to enter new percent");
        System.out.println("                                      increase/decrease alert values");
        System.out.print("                                      or Y to continue configuration: ");
    }

    public static void requestRSIPeriodInput() {
        System.out.println("                                      Enter a time period in days to");
        System.out.println("                                      be used for the calculation of");
        System.out.print("                                      the relative strength index: ");
    }

    public static void displayInputTypeError() {
        System.out.println();
        System.out.println();
        System.out.println("                                   !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("                                   !!                               !!");
        System.out.println("                                   !!   I N V A L I D   I N P U T   !!");
        System.out.println("                                   !!   =========================   !!");
        System.out.println("                                   !!     The time period must      !!");
        System.out.println("                                   !!     be a number in days.      !!");
        System.out.println("                                   !!                               !!");
        System.out.println("                                   !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println();
        System.out.println();
    }

    public static void displayRSIPeriodInputError() {
        System.out.println();
        System.out.println("                                   !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("                                   !!                               !!");
        System.out.println("                                   !!   I N V A L I D   I N P U T   !!");
        System.out.println("                                   !!   =========================   !!");
        System.out.println("                                   !!   The time period must be     !!");
        System.out.println("                                   !!   more than 1 day and less    !!");
        System.out.println("                                   !!   than 270 days.              !!");
        System.out.println("                                   !!                               !!");
        System.out.println("                                   !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println();
        System.out.println();
    }

    public static void requestSMAShortPeriodInput() {
        System.out.println("                                      Enter the length of time in days to");
        System.out.println("                                      be used in the calculation of the");
        System.out.print("                                      SHORT-TERM simple moving average: ");
    }

    public static void displaySMAPeriodLengthInputError() {
        System.out.println();
        System.out.println("                                   !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("                                   !!                               !!");
        System.out.println("                                   !!   I N V A L I D   I N P U T   !!");
        System.out.println("                                   !!   =========================   !!");
        System.out.println("                                   !!     The time period must      !!");
        System.out.println("                                   !!     be more than 1 day.       !!");
        System.out.println("                                   !!                               !!");
        System.out.println("                                   !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println();
        System.out.println();
    }

    public static void requestSMALongPeriodInput() {
        System.out.println("                                      Enter a time period in days to");
        System.out.println("                                      be used for the calculation of the");
        System.out.print("                                      LONG-TERM simple moving average: ");
    }

    public static void displaySMAPeriodOrderInputError() {
        System.out.println();
        System.out.println("                                   !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("                                   !!                               !!");
        System.out.println("                                   !!   I N V A L I D   I N P U T   !!");
        System.out.println("                                   !!   =========================   !!");
        System.out.println("                                   !!     The short-term period     !!");
        System.out.println("                                   !!     must be less than the     !!");
        System.out.println("                                   !!     long-term period.         !!");
        System.out.println("                                   !!                               !!");
        System.out.println("                                   !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println();
        System.out.println();
    }

    public static void requestCryptocurrencySymbolInput() {
        System.out.println();
        System.out.println("                                      Enter the cryptocurrency");
        System.out.println("                                      symbol of a digital currency");
        System.out.print("                                      to monitor: ");
    }

    public static void displayCryptocurrencySymbolInputError() {
        System.out.println();
        System.out.println("                                   !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("                                   !!                           !!");
        System.out.println("                                   !!    M O N I T O R I N G    !!");
        System.out.println("                                   !!   U N A V A I L A B L E   !!");
        System.out.println("                                   !!   =====================   !!");
        System.out.println("                                   !!   Monitoring of this      !!");
        System.out.println("                                   !!   digital currency is     !!");
        System.out.println("                                   !!   currently unavailable.  !!");
        System.out.println("                                   !!                           !!");
        System.out.println("                                   !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println();
    }

    public static void displayConfigurationComplete() {
        System.out.println();
        System.out.println("                                      --------------------------");
        System.out.println("                                      Configuration is complete.");
        System.out.println("                                      Ready to begin monitoring!");
        System.out.println("                                      --------------------------");
    }


    //////////////////////////////////////////////////
    //                                              //
    //   Begins the monitoring process or returns   //
    //   to the main menu based on user input       //
    //                                              //
    //////////////////////////////////////////////////

    public static void displayReturnOrMonitorOption() {
        System.out.println();
        System.out.println();
        System.out.println("                                      Would you like to return to");
        System.out.println("                                      the main menu to configure");
        System.out.println("                                      another item for monitoring?");
        System.out.println();
        System.out.println("                                      Enter Y to return to the main");
        System.out.println("                                      menu or N to start monitoring");
        System.out.print("                                      your financial items: ");
    }

    public static void displayReturnOrMonitorOptionInputError() {
        System.out.println();
        System.out.println("                                   !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("                                   !!                               !!");
        System.out.println("                                   !!   I N V A L I D   I N P U T   !!");
        System.out.println("                                   !!   =========================   !!");
        System.out.println("                                   !!     Indicate a choice by      !!");
        System.out.println("                                   !!     entering only a Y or      !!");
        System.out.println("                                   !!     an N.                     !!");
        System.out.println("                                   !!                               !!");
        System.out.println("                                   !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }


    //////////////////////////////////////////////////
    //                                              //
    //   Displays the About Armadillo 4000 screen   //
    //                                              //
    //////////////////////////////////////////////////

    public static void displayAboutScreen() throws IOException {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println("     *                                                                                           *");
        System.out.println("     *                                                                                           *");
        System.out.println("     *            _                             _ _ _ _         _  _    ___   ___   ___          *");
        System.out.println("     *           / \\   _ __ _ __ ___   __ _  __| (_) | | ___   | || |  / _ \\ / _ \\ / _ \\         *");
        System.out.println("     *          / _ \\ | '__| '_ ` _ \\ / _` |/ _` | | | |/ _ \\  | || |_| | | | | | | | | |        *");
        System.out.println("     *         / ___ \\| |  | | | | | | (_| | (_| | | | | (_) | |__   _| |_| | |_| | |_| |        *");
        System.out.println("     *        /_/   \\_\\_|  |_| |_| |_|\\__,_|\\__,_|_|_|_|\\___/     |_|  \\___/ \\___/ \\___/         *");
        System.out.println("     *                                                                                           *");
        System.out.println("     *                                         ,.-----__                                         *");
        System.out.println("     *                                      ,:::://///,:::-.                                     *");
        System.out.println("     *                                     /:''/////// ``:::`;/|/                                *");
        System.out.println("     *                                    /'   ||||||     :://'`\\                                *");
        System.out.println("     *                                  .' ,   ||||||     `/(  e \\                               *");
        System.out.println("     *                            -===~__-'\\__X_`````\\_____/~`-._ `.                             *");
        System.out.println("     *                                        ~~        ~~       `~-'                            *");
        System.out.println("     *                                                                                           *");
        System.out.println("     *                                       Version 241.3                                       *");
        System.out.println("     *                                                                                           *");
        System.out.println("     *                                                                                           *");
        System.out.println("     *                              D e v e l o p m e n t   T e a m                              *");
        System.out.println("     *                              -------------------------------                              *");
        System.out.println("     *                                                                                           *");
        System.out.println("     *          Zach Cockle                 Sean Dunbar               Juergen Kriz               *");
        System.out.println("     *          Senior Programmer           Lead Programmer           Graphic Designer           *");
        System.out.println("     *                                                                                           *");
        System.out.println("     *                         Ryan Mock                 Sunveer Sandhu                          *");
        System.out.println("     *                         Systems Analyst           Project Manager                         *");
        System.out.println("     *                                                                                           *");
        System.out.println("     *                                                                                           *");
        System.out.println("     *                                S p e c i a l   T h a n k s                                *");
        System.out.println("     *                                ---------------------------                                *");
        System.out.println("     *                                                                                           *");
        System.out.println("     *                                 Jendy Wu - Project Mentor                                 *");
        System.out.println("     *                                                                                           *");
        System.out.println("     *                                                                                           *");
        System.out.println("     *                                                                                           *");
        System.out.println("     *                                                                                           *");
        System.out.println("     *                                A l s o   A v a i l a b l e                                *");
        System.out.println("     *                                  f r o m   Z o o T e c h                                  *");
        System.out.println("     *                               ============================                                *");
        System.out.println("     *                                                                                           *");
        System.out.println("     *                     Lobster 700       FireAnt 5000       Platypus 900                     *");
        System.out.println("     *                                                                                           *");
        System.out.println("     *                                                                                           *");
        System.out.println("     *                       (C) 1985-2018 ZooTech Inc. All rights reserved.                     *");
        System.out.println("     *                                                                                           *");
        System.out.println("     *                                                                                           *");
        System.out.println("     *                                                                                           *");
        System.out.println("     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println();
        System.out.println();
        System.out.println("                                         Press enter to continue");
        System.in.read();
        System.out.println();
    }


    ///////////////////////////////////////////////////////
    //                                                   //
    //   Displays the About Armadillo 4000 exit screen   //
    //                                                   //
    ///////////////////////////////////////////////////////

    public static void displayExitMessage() {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("                                      ,.-----__");
        System.out.println("                                   ,:::://///,:::-.");
        System.out.println("                                  /:''/////// ``:::`;/|/     .--------------.");
        System.out.println("                                 /'   ||||||     :://'`\\     |   Goodbye!   |");
        System.out.println("                               .' ,   ||||||     `/(  e \\    /--------------'");
        System.out.println("                         -===~__-'\\__X_`````\\_____/~`-._ `.                 ");
        System.out.println("                                     ~~        ~~       `~-'");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }


    //////////////////////////////////////////////
    //                                          //
    //   Continuously displays financial data   //
    //   if this option is chosen by the user   //
    //                                          //
    //////////////////////////////////////////////

    public static void displayRealtimeMonitorOption() {
        System.out.println();
        System.out.println();
        System.out.println("                                      Would you like to view monitored");
        System.out.println("                                      financial data in real-time?");
        System.out.println();
        System.out.println("                                      Enter Y to view data in real-time");
        System.out.println("                                      or N to only display notification");
        System.out.print("                                      alerts: ");
    }

    public static void displayMonitoringInitiatedConfirmation() {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("                                               ,.-----__");
        System.out.println("                                            ,:::://///,:::-.");
        System.out.println("                                           /:''/////// ``:::`;/|/");
        System.out.println("                                          /'   ||||||     :://'`\\");
        System.out.println("                                        .' ,   ||||||     `/(  e \\");
        System.out.println("                                  -===~__-'\\__X_`````\\_____/~`-._ `.");
        System.out.println("                                              ~~        ~~       `~-'");
        System.out.println();
        System.out.println();
        System.out.println("                             M o n i t o r i n g   I n i t i a t e d . . .");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }
}