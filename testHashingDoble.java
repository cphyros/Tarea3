
public class testHashingDoble {
      public static void main(String[] args) {
            HashingDoble table = new HashingDoble(7);
            int idM1 = 1020;
            int idM2 = 1050;
            autito m1 = new autito(idM1, 1, 8, 500, 600);
            autito m1_1 = new autito(idM1, 9, 10, 250, 300);
            autito m1_2 = new autito(idM1, 15, 18, 300, 1000);
            autito m2 = new autito(idM2, 2, 10, 100, 200);
            autito m2_1 = new autito(idM2, 20, 30, 100, 400);
            autito m2_2 = new autito(idM2, 32, 40, 200, 200);
            table.insert(m1);
            table.insert(m1_1);
            table.insert(m1_2);
            table.insert(m2);
            table.insert(m2_1);
            table.insert(m2_2);
            

            table.displayTable();
            System.out.println("--------FIND ELEMENTS--------");
            
            table.findTrayectoria(1050);
          
            
      }
}
