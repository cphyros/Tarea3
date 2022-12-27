public class HashingDoble {
      autito[] hashArray;
      int arraySize;
      int size = 0; // numero de elementos

      public HashingDoble(int noOfSlots) {
            if (isPrime(noOfSlots)) {
                  hashArray = new autito[noOfSlots];
                  arraySize = noOfSlots;
            } else {
                  int primeCount = getNextPrime(noOfSlots);
                  hashArray = new autito[primeCount];
                  arraySize = primeCount;

                  System.out.println("El tamaño dado para la Tabla Hash: " + noOfSlots + " no es un numero primo");
                  System.out.println("El tamaño de la tabla Hash fue cambiado a: " + primeCount);
            }
      }

      public void insert(autito num) {
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

      public void findTrayectoria(int num) {
            for (int i = 0; i < arraySize; i++) {
                  if (hashArray[i] != null) {
                        if(hashArray[i].getId() == num) {
                              System.out.println("[" + i + "] " + hashArray[i].toString());
                        }
                  }
            }

      }

      private boolean isPrime(int num) {
            for (int i = 2; i * i <= num; i++) {
                  if (num % i == 0) {
                        return false;
                  }
            }
            return true;
      }

      private int getNextPrime(int minNumber) {
            for (int i = minNumber; true; i++) {
                  if (isPrime(i)) {
                        return i;
                  }
            }
      }

      // retorna index
      private int hashFunc1(int num) {
            // int hashVal = word.hashCode();
            int hashVal = num;
            hashVal = hashVal % arraySize;

            if (hashVal < 0) {
                  hashVal += arraySize;
            }
            return hashVal; // donde se va a insertar
      }

      // retorna el tamaño del salto; mayor que cero
      private int hashFunc2(int num) {
            // int hashVal = word.hashCode();
            int hashVal = num;
            hashVal = hashVal % arraySize;

            if (hashVal < 0) {
                  hashVal += arraySize;
            }

            return 3 - hashVal % 3;
      }
      
}
