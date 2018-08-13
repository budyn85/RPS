package com.kodilla.rps;


public class WinnerResolver {

    public static Winner getWinner(Weapon userWeapon, Weapon computerWeapon) {

        if(userWeapon==Weapon.SCISSORS){
          switch (computerWeapon){
              case ROCK:return Winner.COMPUTER;
              case PAPER:return Winner.HUMAN;
              default:return Winner.TIE;
          }
        }else if(userWeapon==Weapon.ROCK){
            switch (computerWeapon) {
                case ROCK:
                    return Winner.TIE;
                case PAPER:
                    return Winner.COMPUTER;
                default:
                    return Winner.HUMAN;
            }

        }else{
            switch (computerWeapon) {
                case ROCK:
                    return Winner.HUMAN;
                case PAPER:
                    return Winner.TIE;
                default:
                    return Winner.COMPUTER;
            }

        }


    }
}
