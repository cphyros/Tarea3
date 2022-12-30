public class movil {

      private int id, t1, t2;
      private coordenada XY;

      public movil() {

      }

      public movil(int id, int t1, int t2, int x, int y) {
            this.id = id;
            this.t1 = t1;
            this.t2 = t2;
            XY = new coordenada(x, y);
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
            return XY.getX();
      }

      public int getY() {
            return XY.getY();
      }

      public String toString() {
            return "[" + t1 + "," + t2 + "]" + "," + "(" + getX() + "," + getY() + ")";
      }
}
