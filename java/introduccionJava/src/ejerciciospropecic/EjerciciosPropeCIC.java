/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciospropecic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author art
 */
public class EjerciciosPropeCIC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        menu();
    }
    
    public static void menu() throws IOException{
        Scanner sc = new Scanner(System.in);
        int option=0;
        while(true){
            System.out.println("\nSeleccione el numero del programa que requiere:");
            System.out.println("1. Conversion de grados centigrados a Fahrenheit");
            System.out.println("2. Conversion de Km/h a m/s");
            System.out.println("3. Cifras separadas de un numero de 3 cifras");
            System.out.println("4. Mostrar los numeros perfectos entre 1 y 1000");
            System.out.println("5. Obtener numero de palabras en una frase");
            System.out.println("6. Cociente de dos numeros de forma iterativa");
            System.out.println("7. Cociente de dos numeros de forma recursiva");
            System.out.println("8. Convertir entero en decimal a binario de forma iterativa");
            System.out.println("9. Convertir entero en decimal a binario de forma recursiva");
            System.out.println("10. Suma de dos numero entero de forma iterativa");
            System.out.println("11. Suma de dos numero entero de forma recursiva");
            System.out.println("12. Calcular el residuo de forma iterativa");
            System.out.println("13. Calcular el residuo de forma recursiva");
            System.out.println("14. Encontrar los numeros enteros dentro de un archivo");
            System.out.println("15. Salir\n");
            System.out.print("Opcion: ");
            
            try {
                option = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Opcion no valida, digite solo un numero del menu");
                menu();
            }
            
            switch(option){
                case 1:
                    ej1();
                    break;
                    
                case 2:
                    ej2();
                    break;
                    
                case 3:
                    ej3();
                    break;
                    
                case 4:
                    ej4();
                    break;
                    
                case 5:
                    ej5();
                    break;
                    
                case 6:
                    ej6();
                    break;
                    
                case 7:
                    ej6_recursive();
                    break;
                    
                case 8:
                    ej7();
                    break;
                    
                case 9:
                    ej7_recursive();
                    break;
                
                case 10:
                    ej8();
                    break;
                    
                case 11:
                    ej8_recursive();
                    break;
                    
                case 12:
                    ej9();
                    break;
                    
                case 13:
                    ej9_recursive();
                    break;
                    
                case 14:
                    ej10();
                    break;
                    
                case 15:
                    System.out.println("Bye :D!");
                    return;
                    
                default:
                    System.out.println("Opcion no valida, digite solo un numero del menu");
                    menu();
            }
            System.in.read();//Espera un enter
        }
    }
    
    public static void ej1()throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introuzca los grados centigrados: ");
        double c = sc.nextDouble();//Leer un double
        c = 32 + (9 * c) / 5 ;//Conversion
        System.out.println("La equivalencia en grados Farengeith es " + c + "\n");
    }
    
    public static void ej2()throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introuzca la velocidad en Km/h: ");
        double aux = sc.nextDouble();//Leer un double
        aux = 5 * aux / 18 ;
        System.out.println("La equivalencia en m/s es " + aux);
    }
    
    public static void ej3()throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introuzca un número entero de 3 digitos: ");
        int number;
        try{
            number = sc.nextInt();//Leer un entero
        }catch(Exception e){
            System.out.println("Introduzca un numero entero");
            return;
        }

        String aux = Integer.toString(number);
        
        if(aux.length() != 3){
            System.out.println("Su número no es de 3 cifras");
            return;
        }
       
        for(int i=0; i<aux.length(); i++){
            System.out.println("Cifra " + (i+1) + " :" + aux.charAt(i));
        }
        
    }
    
    public static void ej4()throws IOException {
        System.out.println("Numeros perfectos entre 1 y 1000:");
        int suma;
        for(int i=1; i<=1000; i++){
            suma = 0;
            for(int j=1; j<i; j++){
                
                if (i%j == 0){
                    suma += j;
                }
            }
            if(suma == i){
                System.out.println("" + i);
            }
        }
    }
    
    public static void ej5()throws IOException {
        BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Introuzca su frase: ");
        
        String frase = consola.readLine();
        ArrayList<String> palabras = new ArrayList<String>();
        
        String palabra = "";
        for(int i = 0; i<frase.length(); i++){
            if(frase.charAt(i) != ' '){
                palabra += frase.charAt(i);
            }else if(palabra != ""){
                palabras.add(palabra);
                palabra = "";
            }
            
            if(i == frase.length()-1 && palabra!=""){
                palabras.add(palabra);
            }
        }
        
        /*for(String p : palabras){
            System.out.println(p);
        }*/
        System.out.println(palabras.size() + " palabras");
    }
    
    public static void ej6()throws IOException {
        Scanner sc = new Scanner(System.in);
        double dividendo;
        double divisor;

        try{
            System.out.print("Introuzca el dividendo: ");
            dividendo = sc.nextDouble();//Leer un numero
            System.out.print("Introuzca el divisor: ");
            divisor = sc.nextDouble();//Leer un numero

        }catch(Exception e){
            System.out.println("Introduzca un numero");
            return;
        }

        if(divisor>dividendo){
            System.out.println("Cociente=0");
            return;
        }
        
        int cociente = 0;
        while(true){
            if(divisor>dividendo){
                break;
            }
            dividendo -= divisor;
            cociente++;
        }
        
        System.out.println("Cociente="+cociente);
    }
    
    public static void ej6_recursive()throws IOException {
        Scanner sc = new Scanner(System.in);
        double dividendo;
        double divisor;

        try{
            System.out.print("Introuzca el dividendo: ");
            dividendo = sc.nextDouble();//Leer un numero
            System.out.print("Introuzca el divisor: ");
            divisor = sc.nextDouble();//Leer un numero

        }catch(Exception e){
            System.out.println("Introduzca un numero");
            return;
        }

        int count = 0;
        int cociente = div(divisor, dividendo, count);
        System.out.println("Cociente="+cociente);
    }
    
    public static int div(double divisor, double dividendo, int count){
        if(divisor>dividendo){
            return count;
        }
        
        dividendo -= divisor;
        count++;
        return div(divisor, dividendo, count);
    }
    
    public static void ej7_recursive()throws IOException {
        Scanner sc = new Scanner(System.in);
        int decimal;

        try{
            System.out.print("Introuzca el numero decimal: ");
            decimal = sc.nextInt();//Leer un numero
        }catch(Exception e){
            System.out.println("Introduzca un numero");
            return;
        }

        StringBuilder binario = new StringBuilder("");
        binario = bin(decimal, binario);
        
        System.out.println("Binario="+binario.reverse().toString());
    }
    
    public static StringBuilder bin(int decimal, StringBuilder binario){
        if(decimal == 1 || decimal == 0){
            return binario.append(decimal);
        }
        
        binario.append(decimal%2);
        return bin(decimal/2, binario);
    }
    
    public static void ej7()throws IOException {
        Scanner sc = new Scanner(System.in);
        int decimal;

        try{
            System.out.print("Introuzca el numero decimal: ");
            decimal = sc.nextInt();//Leer un numero
            if(decimal<0){
                System.out.println("Introduzca un numero entero positivo");
                return;
            }
        }catch(Exception e){
            System.out.println("Introduzca un numero entero positivo");
            return;
        }

        StringBuilder binario = new StringBuilder("");
        while(true){
            if(decimal == 1 || decimal == 0){
                binario.append(decimal);
                break;
            }
            binario.append(decimal%2);
            decimal /= 2;
        }
        System.out.println("Binario="+binario.reverse().toString());
    }
    
    public static void ej8_recursive()throws IOException {
        Scanner sc = new Scanner(System.in);
        int num1;
        int num2;


        try{
            System.out.print("Introuzca el primer numero: ");
            num1 = sc.nextInt();//Leer un numero
            System.out.print("Introuzca el segundo numero: ");
            num2 = sc.nextInt();//Leer un numero
        }catch(Exception e){
            System.out.println("Introduzca un numero");
            return;
        }

        boolean negativo = false;
        if(num2<0){
            num1 *= -1;
            num2 *= -1;
            negativo = true;
        }
        
        int sumaResultado = suma(num1, num2);         
        if(negativo){
            sumaResultado *= -1;
        }
               
        System.out.println("Suma = "+ sumaResultado);
    }
    
    public static int suma(int num1, int num2){
        if(num2 == 0){
            return num1;
        } else{
            return 1 + suma(num1, num2 - 1);                                                                              
        }
    }
    
    public static void ej8()throws IOException {
        Scanner sc = new Scanner(System.in);
        int num1;
        int num2;

        try{
            System.out.print("Introuzca el primer numero: ");
            num1 = sc.nextInt();//Leer un numero
            System.out.print("Introuzca el segundo numero: ");
            num2 = sc.nextInt();//Leer un numero
        }catch(Exception e){
            System.out.println("Introduzca un numero");
            return;
        }

        int sumaResultado=0;
        if (num1 == 0){
            System.out.println("Suma = "+ num2);
            return;
        }
        
        if (num2 == 0){
            System.out.println("Suma = "+ num1);
            return;
        }
        
        boolean negativo = false;
        if(num2<0){
            num1 *= -1;
            num2 *= -1;
            negativo = true;
        }
        
        while(true){
            if(num2 == 0) {
                sumaResultado += num1;
                break;
            }else{
                sumaResultado += 1;
                num2--;
            }
        }
        
        if(negativo){
            sumaResultado *= -1;
        }
        System.out.println("Suma = "+ sumaResultado);
    }
    
    public static void ej9()throws IOException {
        Scanner sc = new Scanner(System.in);
        double dividendo;
        double divisor;

        try{
            System.out.print("Introuzca el dividendo: ");
            dividendo = sc.nextDouble();//Leer un numero
            System.out.print("Introuzca el divisor: ");
            divisor = sc.nextDouble();//Leer un numero

        }catch(Exception e){
            System.out.println("Introduzca un numero");
            return;
        }

        if(divisor>dividendo){
            System.out.println("Residuo=" + (int)dividendo);
            return;
        }
        
        int residuo = 0;
        while(true){
            if(divisor>dividendo){
                residuo = (int)dividendo;
                break;
            }
            dividendo -= divisor;
        }
        
        System.out.println("Residuo="+residuo);
    }
    
    public static void ej9_recursive()throws IOException {
        Scanner sc = new Scanner(System.in);
        double dividendo;
        double divisor;

        try{
            System.out.print("Introuzca el dividendo: ");
            dividendo = sc.nextDouble();//Leer un numero
            System.out.print("Introuzca el divisor: ");
            divisor = sc.nextDouble();//Leer un numero

        }catch(Exception e){
            System.out.println("Introduzca un numero");
            return;
        }

        if(divisor>dividendo){
            System.out.println("Residuo=" + (int)dividendo);
            return;
        }
        
        int residuo = resto(divisor, dividendo);
        System.out.println("Residuo="+residuo);
    }
    
    public static int resto(double divisor, double dividendo){
        if(divisor>dividendo){
            return (int)dividendo;
        }
        
        dividendo -= divisor;
        return resto(divisor, dividendo);
    }
    
    public static void ej10() throws FileNotFoundException, IOException{
        
        BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Introuzca la dirección absoluta del archivo (si quiere probar con el texto de prueba escriba test): ");
        String path = consola.readLine();
        
        //path = "";
        if(path.equals("test")){
            path = "D:\\Documentos\\Propedecutico CIC\\Progra\\EjerciciosPropeCIC\\src\\ejerciciospropecic\\texto.txt";
        }
        
        File file = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        String palabra;
        while ((st = br.readLine()) != null){
            palabra = "";
            for(int i = 0; i<st.length(); i++){
                if(st.charAt(i) != ' '){
                    palabra += st.charAt(i);
                }else if(palabra != ""){
                    //palabras.add(palabra);
                    //System.out.println("Add" + palabra);
                    
                    if(isNumber(palabra)){
                        numbers.add(Integer.parseInt(palabra));                    
                    }
                    palabra = "";
                }

                if(i == st.length()-1 && isNumber(palabra)){
                    numbers.add(Integer.parseInt(palabra));
                }
            }
        }
        System.out.println("Numeros dentro del texto: ");
        for(Integer number : numbers){
            System.out.println(number.toString());
        }
    }
    
    public static boolean isNumber(String s){
        try {
            int aux = Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
