public class autito {
      private int id, t1, t2, x, y;

      public autito() {

      }

      public autito(int id, int t1, int t2, int x, int y) {
            this.id = id;
            this.t1 = t1;
            this.t2 = t2;
            this.x = x;
            this.y = y;
      }

      public int getId() {
            return id;
      }

      public int getT1() {
            return t1;
      }

      public int getT2() {
            return t2;
      }

      public int getX() {
            return x;
      }

      public int getY() {
            return y;
      }

      public String toString() {
            return "[" + t1 + "," + t2 + "]" + "," + "(" + x + "," + y + ")";
      }
}
