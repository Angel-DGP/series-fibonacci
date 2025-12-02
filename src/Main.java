import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Ingrese la cantidad de elementos que desea generar: ");
        int n=sc.nextInt();
        int a=0,b=1,fib=0,posiblePrimo=2,contadorPrimos=0,denominador=1,bloque=1,cerosEnBloque=1,unosEnBloque=2,indexEnBloque=0;
        boolean usarRaiz=false;
        float sumaTotal = 0f;
        for(int i=0;i<n;i++){
            if(i==0) fib=0;
            else if(i==1) fib=1;
            else{fib=a+b;a=b;b=fib;}
            int primo=0;
            while(contadorPrimos<=i){
                boolean esPrimo=true;
                for(int j=2;j<=Math.sqrt(posiblePrimo);j++){
                    if(posiblePrimo%j==0){esPrimo=false;break;}
                }
                if(esPrimo){primo=posiblePrimo;contadorPrimos++;}
                posiblePrimo++;
            }
            usarRaiz=(indexEnBloque>=cerosEnBloque);
            indexEnBloque++;
            if(indexEnBloque>=cerosEnBloque+unosEnBloque){bloque++;cerosEnBloque+=2;unosEnBloque+=2;indexEnBloque=0;}
            float resultado;
            if(!usarRaiz) resultado=(float)(Math.pow(fib,primo)/denominador);
            else resultado=(float)Math.sqrt((float)fib/(float)denominador);
            // Aplicar signo: + si no usa raíz, - si usa raíz
            if(usarRaiz) sumaTotal -= resultado;
            else sumaTotal += resultado;
            if(usarRaiz){
                System.out.println((i+1)+". - √((" + fib + ")/" + denominador + ") = " + resultado);
            }else{
                System.out.println((i+1)+". + (" + fib + ")^" + primo + " / " + denominador + " = " + resultado);
            }
            denominador++;
        }
        System.out.println("Sumatoria total = " + sumaTotal);
    }
}
