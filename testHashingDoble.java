
public class testHashingDoble {
      public static void main(String[] args) {
            HashingDoble table = new HashingDoble(7);

            int idM1 = 1020;
            int idM2 = 1050;

            movil m1 = new movil(idM1, 1, 8, 500, 600);
            movil m1_1 = new movil(idM1, 9, 10, 250, 300);
            movil m1_2 = new movil(idM1, 15, 18, 300, 1000);
            movil m2 = new movil(idM2, 2, 10, 100, 200);
            movil m2_1 = new movil(idM2, 20, 30, 100, 400);
            movil m2_2 = new movil(idM2, 32, 40, 200, 200);

            table.insert(m1);
            table.insert(m1_1);
            table.insert(m1_2);
            table.insert(m2);
            table.insert(m2_1);
            table.insert(m2_2);

            System.out.println("");

            table.displayTable();

            System.out.println("");

            int num = 1050;
            table.Trayectoria(num);
            System.out.println("");
            table.Distancia(num);

      }
}
