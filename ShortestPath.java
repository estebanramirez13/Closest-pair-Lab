/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package shortestpath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author santi
 */
public class ShortestPath {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<int[]> coordinates = new ArrayList<int[]>();
        
        for (int i = 0; i < 6; i++) {
            int equis = -6 + (int)(Math.random() * ((6 - (-6)) + 1));
            int fx = -6 + (int)(Math.random() * ((6 - (-6)) + 1));
            int[] arr = {equis, fx};
            coordinates.add(arr);
        }
        
        System.out.println("Las coordenadas que se generaron fueron las siguientes:");
        
        for (int i = 0; i < 6; i++) {
            int[] arr = coordinates.get(i);
            System.out.println("[" + arr[0] + "," + arr[1] + "]");
        }
        
        //Se ordena de forma ascendente el array de coordenadas
        Collections.sort(coordinates, new Comparator<int[]>() {
         public int compare(int[] a, int[] b) {
              if(a[0] - b[0]==0) {
                  return a[1]-b[1];
              }else
                  return a[0]-b[0];
              }
        });
        
        // Ordenamos el arraylist con respecto a x
        System.out.println("La lista ordenada de forma ascendente es la siguiente: ");
        for (int i = 0; i < 6; i++) {
            int[] arr = coordinates.get(i);
            System.out.println("[" + arr[0] + "," + arr[1] + "]");
        }
        
        System.out.println("Brute Force Method");
        bruteForce(coordinates);
        
        System.out.println("Recursion Method");
        int[] coor1 = {0,0};
        int[] coor2 = {0,0};
        float distancia = Recursion(coordinates, coor1, coor2, 0, 0, 1000);
    }
    
    public static void bruteForce(ArrayList<int[]> coordenadas) {
        float distancia = 1000;
        int[] coor1 = {0,0};
        int[] coor2 = {0,0};
        
        for (int i = 0; i < 6; i++) {
            int[] arr = coordenadas.get(i);
            System.out.println("Distancia entre los puntos y [" + arr[0] + "," + arr[1] + "]");
            for (int j = 0; j < 6; j++) {
                if (i != j) {
                    int[] arr1 = coordenadas.get(j);
                    float dist = (float) Math.sqrt((arr1[0] - arr[0]) * (arr1[0] - arr[0]) + (arr1[1] - arr[1]) * (arr1[1] - arr[1]));
                    System.out.println("Distancia ([" + arr[0] + "," + arr[1] + "]) ([" + arr1[0] + "," + arr1[1] + "]) = " + dist);
                    if (dist < distancia) {
                        distancia = dist;
                        coor1 = arr;
                        coor2 = arr1;
                    }
                }
            }
            System.out.println("");
        }
        System.out.println("La distancia más corta encontrada entre todos los puntos es = " + distancia + " y hace referencia a los puntos [" + coor1[0] + "," + coor1[1] + "]");
    }
    
    public static float Recursion(ArrayList<int[]> coordenadas, int[] coor1, int[] coor2, int i, int j, float distancia) {
        if (i < 6) {
            int[] arr = coordenadas.get(i);
            if (j < 6) {
                if (i != j) {
                    int[] arr1 = coordenadas.get(j);
                    float dist = (float) Math.sqrt((arr1[0] - arr[0]) * (arr1[0] - arr[0]) + (arr1[1] - arr[1]) * (arr1[1] - arr[1]));
                    
                    System.out.println("Distancia ([" + arr[0] + "," + arr[1] + "]) ([" + arr1[0] + "," + arr1[1] + "]) = " + dist);
                    if (dist < distancia) {
                        distancia = dist;
                        coor1 = arr;
                        coor2 = arr1;
                    }
                }
                return Recursion(coordenadas, coor1, coor2, i, j+1, distancia);
            } else {
                System.out.println("");
                return Recursion(coordenadas, coor1, coor2, i+1, 0, distancia);
            }
        }
        System.out.println("La distancia más corta encontrada entre todos los puntos es = " + distancia + " y hace referencia a los puntos [" + coor1[0] + "," + coor1[1] + "]");
        return distancia;
    }
    
}
     

