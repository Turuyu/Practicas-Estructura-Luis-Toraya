/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busqueda;

/*
Integrantes:
Luis Guillermo Toraya Novelo
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Preguntas_20 {

    static Scanner scan = new Scanner(System.in);
    static int contador = 1;
    static int lim_a = 0, lim_b = 0, data = 0;

    public static void main(String[] args) {
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        menu();
        fakeBinarySearch(lim_a, lim_b, data, integerArrayList);

    }

    public static void menu(){
        do{
            System.out.println("INGRESA EL INTERVALO DEL ARREGLO");
            System.out.print("ELEMENTO MÁS BAJO: ");
            lim_a = scan.nextInt();
            System.out.print("ELEMENTO MÁS ALTO: ");
            lim_b = scan.nextInt();
            System.out.println(" ");

            if (lim_b <= lim_a) {
                System.out.println("ERROR EN EL RANGO");
                System.out.println("INGRESAR OTRA VEZ");
            } else {
                break;
            }
        } while (true);
        System.out.println("EL INTERVALO ES ["+lim_a+","+lim_b+"]");
        System.out.print("INGRESA EL ELEMENTO A BUSCAR: ");
        data = scan.nextInt();
    }

    public static void fakeBinarySearch(int lim_a, int lim_b, int data, ArrayList<Integer> integerArrayList) {
        int div;

        for(int i = lim_a; i <= lim_b; i++) {
            integerArrayList.add(i);
        }

        div = (integerArrayList.size() - 1)/2;
        System.out.print(integerArrayList.get(div) + " ");

        if (data == integerArrayList.get(div)) {
            System.out.println(" ");
            System.out.println("ELEMENTO " + integerArrayList.get(div) + " ENCONTRADO EN EL INTENTO " + contador);
        } else if (data < integerArrayList.get(div)) {
            contador++;
            fakeBinarySearch(lim_a, integerArrayList.get(div) , data, integerArrayList = new ArrayList<>());

        } else {
            contador++;
            fakeBinarySearch(integerArrayList.get(div), lim_b, data, integerArrayList = new ArrayList<>());
        }
    }
}