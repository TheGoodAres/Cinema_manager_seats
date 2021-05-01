package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = in.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seatsPerRow = in.nextInt();
        String[][] seats = new String[rows+1][seatsPerRow + 1];
        initialize(seats);
        int rowNumber;
        int seatNumber;
        int ticketPurchased = 0;
        int numberOfSeats = rows * seatsPerRow;
        int currentIncome = 0;
        int totalIncome;
        boolean loop = true;
        do
        {
            draw(seats);
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            int answer = in.nextInt();
            if (answer == 1)
            {
                draw(seats);
            }
            else if (answer == 2)
            {
                boolean loops = true;
                do {
                    boolean loop1 = true;
                    do {
                        System.out.println("Enter a row number:");
                        rowNumber = in.nextInt();
                        System.out.println("Enter a seat number in that row:");
                        seatNumber = in.nextInt();
                        if (rowNumber > rows || rowNumber < 0 || seatNumber < 0 || seatNumber > seatsPerRow) {
                            System.out.println("Wrong input!");
                        } else {
                            loop1 = false;
                        }
                    } while (loop1);
                    if (!seats[rowNumber][seatNumber].equals(" B")) {
                        seats[rowNumber][seatNumber] = " B";

                        int priceTicket;
                        if (numberOfSeats <= 60) {
                            priceTicket = 10;
                            currentIncome += 10;
                        } else {
                            if (rowNumber <= (rows / 2)) {
                                priceTicket = 10;
                                currentIncome += 10;
                            } else {
                                priceTicket = 8;
                                currentIncome += 8;
                            }
                        }
                        ticketPurchased++;
                        System.out.println();
                        System.out.println("Ticket price: $" + priceTicket);
                        loops = false;
                    } else {
                        System.out.println("That ticket has already been purchased!");
                    }
                }while (loops);
            }
            else if(answer == 3)
            {
                System.out.printf("Number of purchased tickets: %d\n",ticketPurchased);
                double percentage;
                if(ticketPurchased > 0) {
                    percentage = (ticketPurchased / Double.parseDouble(String.valueOf(numberOfSeats))) * 100;
                }
                else
                {
                    percentage = 0;
                }
                System.out.printf("Percentage: %.2f%%%n",percentage);
                System.out.println("Current income: $" + currentIncome);
                if(numberOfSeats <= 60)
                {
                    totalIncome = numberOfSeats * 10;
                }
                else
                {
                    totalIncome = (rows/2 * seatsPerRow) * 10 + ((rows - rows/2) * seatsPerRow) * 8;
                }
                System.out.println("Total income: $"+totalIncome);
            }
            else if (answer == 0)
            {
                loop = false;
            }

        } while(loop);
    }
    public static void draw(String[][] seats)
    {
        System.out.println("Cinema:");
        for(int i = 0; i < seats.length; i++)
        {
            for(int z = 0; z < seats[0].length; z++)
            {
                if(i == 0)
                {
                    System.out.print(seats[i][z] + " ");
                }
                else
                {
                    System.out.print(seats[i][z]);
                }
            }
            System.out.println();
        }
    }
    public static void initialize(String[][] seats)
    {
        for(int i = 0; i < seats.length; i++)
        {
            for(int z = 0; z < seats[0].length ; z++)
            {
                if((i == 0 && z == 0))
                {
                    seats[i][z] = " ";
                }
                else if(i == 0)
                {
                    seats[i][z] = String.valueOf(z);
                }
                else if(z == 0)
                {
                    seats[i][z] = String.valueOf(i);
                }
                else
                {
                    seats[i][z] = " S";
                }
            }
        }
    }
}
