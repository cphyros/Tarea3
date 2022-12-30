public class HashingDoble {

      movil[] hashArray;
      int arraySize;
      int size = 0; // numero de elementos

      public HashingDoble(int numDeSlots) {
            if (esPrimo(numDeSlots)) {
                  hashArray = new movil[numDeSlots];
                  arraySize = numDeSlots;
            } else {
                  int numPrimo = getNextPrime(numDeSlots);
                  hashArray = new movil[numPrimo];
                  arraySize = numPrimo;

                  System.out.println("El tamaño dado para la Tabla Hash: " + numDeSlots + " no es un numero primo");
                  System.out.println("El tamaño de la tabla Hash fue cambiado a: " + numPrimo);
            }
      }

      public void insert(movil num) {
            int hashVal = hashFunc1(num.getId());
            int stepSize = hashFunc2(num.getId());

            while (hashArray[hashVal] != null) {
                  hashVal = hashVal + stepSize;
                  hashVal = hashVal % arraySize;
            }

            hashArray[hashVal] = num;

            System.out.println("Elemento insertado: " + num.getId());
            size++;
      }

      public int find(int num) {
            int hashVal = hashFunc1(num);
            int stepSize = hashFunc2(num);

            while (hashArray[hashVal] != null) {
                  if (hashArray[hashVal].getId() == num) {
                        return hashArray[hashVal].getId();
                  }
                  hashVal = hashVal + stepSize;
                  hashVal = hashVal % arraySize;

            }
            return hashArray[hashVal].getId();
      }

      // imprime la tabla hash
      public void displayTable() {
            System.out.println("Tabla: ");
            for (int i = 0; i < arraySize; i++) {
                  if (hashArray[i] != null) {
                        System.out.print("[" + i + "] " + hashArray[i].getId() + ", " + hashArray[i].getT1() + ", "
                                    + hashArray[i].getT2() + ", " + hashArray[i].getX() + ", " + hashArray[i].getY());
                  } else {
                        System.out.print("[" + i + "] " + "**");
                  }
                  System.out.println("");
            }
      }

      // Imprime la trayectoria del movil ingresado en tiempo O(l)
      public void Trayectoria(int num) {
            int hashVal = hashFunc1(num);
            int stepSize = hashFunc2(num);
            int plus = 0;
            System.out.println("Trayectoria del movil " + num + ": ");
            while (hashArray[hashVal] != null) {
                  if (hashArray[hashVal] != null && hashArray[hashVal].getId() == num) {
                        System.out.println(hashArray[hashVal].toString());
                  }
                  plus++;
                  stepSize = stepSize * plus;
                  hashVal = hashVal + stepSize;
                  hashVal = hashVal % arraySize;

            }
      }

      // metodo que navega por la trayectoria del movil ingresado guardando sus
      // posiciones en tiempo O(l)
      // Termina imprimiendo la suma de todas sus posiciones
      public void Distancia(int num) {
            int hashVal = hashFunc1(num);
            int stepSize = hashFunc2(num);
            int plus = 0;
            coordenada P1 = null;
            coordenada P2 = null;
            double distancia = 0;
            System.out.println("Distancia de la trayectoria del movil " + num + ": ");
            while (hashArray[hashVal] != null) {
                  if (hashArray[hashVal].getId() == num) {
                        int x = hashArray[hashVal].getX();
                        int y = hashArray[hashVal].getY();
                        P1 = new coordenada(x, y);
                  }
                  plus++;
                  stepSize = stepSize * plus;
                  hashVal = hashVal + stepSize;
                  hashVal = hashVal % arraySize;

                  if (hashArray[hashVal] != null && hashArray[hashVal].getId() == num) {
                        int x = hashArray[hashVal].getX();
                        int y = hashArray[hashVal].getY();
                        P2 = new coordenada(x, y);
                        distancia += dist(P1, P2);

                  }

            }
            System.out.println(distancia);

      }
      ///// METODOS PRIVADOS /////

      // Metodo privado para calcular la distancia entre dos puntos
      private double dist(coordenada P1, coordenada P2) {
            double distancia = 0;
            if (P1 != null && P2 != null) {
                  distancia = Math.sqrt((P1.getX() - P2.getX()) * (P1.getX() - P2.getX())
                              + (P1.getY() - P2.getY()) * (P1.getY() - P2.getY()));
            }

            return distancia;
      }

      // Verifica si el tamaño del array es un numero primo
      private boolean esPrimo(int num) {
            for (int i = 2; i * i <= num; i++) {
                  if (num % i == 0) {
                        return false;
                  }
            }
            return true;
      }

      // Si el tamaño de la lista no es primo lo cambia al siguiente numero primo
      // cercano
      private int getNextPrime(int minNumber) {
            for (int i = minNumber; true; i++) {
                  if (esPrimo(i)) {
                        return i;
                  }
            }
      }

      // retorna index mayor que cero
      private int hashFunc1(int num) {
            int hashVal = num;
            hashVal = hashVal % arraySize;

            if (hashVal < 0) {
                  hashVal += arraySize;
            }
            return hashVal; // donde se va a insertar
      }

      // retorna el tamaño del salto mayor que cero
      private int hashFunc2(int num) {
            int hashVal = num;
            hashVal = hashVal % arraySize;

            if (hashVal < 0) {
                  hashVal += arraySize;
            }

            return 3 - hashVal % 3; // Se usa un numero menor que el numero del tamaño del array
      }

}
