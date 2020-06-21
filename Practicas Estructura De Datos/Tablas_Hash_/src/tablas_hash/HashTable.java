/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablas_hash;

/**
 *
 * @author Luis Toraya
 */
class HashTable {
    int llave;
    Nodo nodo;

    public HashTable(int key) {
        this.llave = key;
    }

    public void insertElement(int element){
        if (nodo == null) {
            nodo = new Nodo();
            nodo.setData(element);
        } else {
            Nodo temp = nodo;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            Nodo newNode = new Nodo();
            newNode.setData(element);
            newNode.setPrev(temp);
            temp.setNext(newNode);
        }
    }

    public void printTable(){
        Nodo temp = nodo;
        System.out.print("LLAVE (" + llave + "): ");
        if(temp.getNext()==null){
            if (temp.isEmpty()) {
                System.out.println("LA PILA ESTA VACIA");
            } else {
                System.out.print(temp.getData());
                System.out.println(" ");
            }
        } else{
            while(temp.getNext()!=null){
                System.out.print(temp.getData());
                if(temp.getNext()!=null){
                    System.out.print("->");
                }
                temp = temp.getNext();
            }
            System.out.print(temp.getData());
            System.out.println(" ");
        }
    }

    public void deleteInTable(int element){
        Nodo temp = nodo;
        if(temp.getNext()==null){
            System.out.println("LA PILA ESTA VACIA");
            nodo.setEmpty(true);
        } else{
            while(temp.getNext()!=null){
                if (temp.getData() == element && temp.getPrev() == null) {
                    temp.getNext().setPrev(null);
                    nodo = temp.getNext();
                    return;
                }
                if (temp.getData() == element) {
                    temp.getPrev().setNext(temp.getNext());
                    temp.getNext().setPrev(temp.getPrev());
                    return;
                }
                temp = temp.getNext();
            }
            if (temp.getData() == element && temp.getNext() == null) {
                temp.getPrev().setNext(null);
                temp.setPrev(null);
                return;
            }
            System.out.println("EL ELEMENTO NO SE ENCUENTRA");
            System.out.println(" ");
        }
    }

    public boolean searchInTable(int element){
        Nodo temp = nodo;
        System.out.print("LLAVE (" + llave + "): ");
        if(temp.getNext()==null){
            System.out.print("LA PILA ESTA VACIA Y ");
        } else{
            while(temp.getNext()!=null){
                if (temp.getData() == element) {
                    return true;
                }
                temp = temp.getNext();
            }
            if (temp.getData() == element) {
                return true;
            }
        }
        return false;
    }


}
