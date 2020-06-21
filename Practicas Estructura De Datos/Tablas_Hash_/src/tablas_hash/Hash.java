/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablas_hash;

/*
Integrantes:
Luis Guillermo Toraya Novelo
*/

import java.util.Scanner;

public class Hash{
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
        System.out.println("Terminado");
    }
    public static void menu() {
        HashTable[] hashTable = new HashTable[0];
        int[] numbers;
        int size = 0, llave, opc, eliminar, buscar;
        boolean firstUnlock = false, secondUnlock = false;

        do {
            System.out.println("Ingresa La Opcion A Realizar");
            System.out.println("1 - Insertar");
            System.out.println("2 - Eliminar");
            System.out.println("3 - Buscar");
            System.out.println("4 - Salir");
            System.out.print("Opcion: ");
            opc = scanner.nextInt();
            switch(opc) {
                case 1:
                    System.out.print("Cual Será El Tamaño De La Hash Table?: ");
                    size = scanner.nextInt();
                    System.out.println(" ");
                    hashTable = new HashTable[size];
                    for (int i = 0; i < size; i++) {
                        hashTable[i] = new HashTable(i);
                    }
                    numbers = new int[5*size];
                    for (int i = 0; i < 5*size; i++) {
                        numbers[i] = (int)(Math.random() * (5*size + 1) + 0);
                        llave = (numbers[i] % size);
                        hashTable[llave].insertElement(numbers[i]);
                    }
                    for (int i = 0; i < size ; i++) {
                        hashTable[i].printTable();
                    }
                    firstUnlock = true;
                    secondUnlock = true;
                    break;
                case 2:
                    if (firstUnlock){
                        System.out.println(" ");
                        for (int i = 0; i < size ; i++) {
                            hashTable[i].printTable();
                        }
                        System.out.println(" ");
                        System.out.print("Que Elemento Desea Borrar? ");
                        eliminar = scanner.nextInt();
                        System.out.println(" ");
                        llave = (eliminar % size);
                        if (llave < size) {
                            hashTable[llave].deleteInTable(eliminar);
                            hashTable[llave].printTable();
                        } else {
                            System.out.println("El Elemento Ingresado No Existe En La Tabla");
                        }
                    } else {
                        System.out.println("No Se Han Ingresado Los Elementos, NO Hay Nada Que Eliminar");
                    }
                    break;
                case 3:
                    if (secondUnlock) {
                        System.out.print("Que Elemento Quiere Encontrar: ");
                        buscar = scanner.nextInt();
                        System.out.println(" ");
                        for (int i = 0; i < size ; i++) {
                            if (hashTable[i].searchInTable(buscar)) {
                                System.out.println("El Elemento " + buscar + " Se Encuentra En La Tabla Con La Llave (" + i + ")");
                            } else {
                                System.out.println("El Elemento No Se Encuentra");
                            }
                        }
                    } else {
                        System.out.println("No Se Han Ingresado Los Elementos, No Se Puede Encontrar Nada");
                    }
                    break;

            }
            System.out.println(" ");
        } while (opc != 4);

    }
}
//-----------------------------------------------------------------------------------------


