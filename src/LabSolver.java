public class LabSolver {

    public static void main(String[] args) {
        int width = 20;
        int height = 10;
        if (args.length > 1) {
            width = Integer.parseInt(args[0]);
            height = Integer.parseInt(args[1]);
        }
        Labyrinth l = new Lab(width,height);
        System.out.println("\nCreated a random labyrinth:");
        System.out.println(l);
        long startTime = System.currentTimeMillis();
        boolean success = findPath(0,0,width-1,height-1,l);
        long elapseTime = System.currentTimeMillis() - startTime;
        System.out.println(elapseTime);
        if (success) {
            System.out.println("Solution found:");
            System.out.println(l);
        } else {
            System.out.println("Failed to find a solution. (Bug in LabSolver.java)");
        }
    }

    public static boolean findPath(int x0, int y0, int x1, int y1, Labyrinth l) {
        /*try { //Om man vill se steg f�r steg hur rekursionen fungerar
            Thread.sleep(300);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        System.out.println(l);*/

        if ((x0 == x1) && (y0 == y1)) {
            l.setMark(x0, y0, true);
            return true;
        }

        if (l.canMove(Labyrinth.Direction.RIGHT, x0, y0) && !l.getMark(x0+1, y0)) {
            l.setMark(x0, y0, true);
            if(findPath(x0 + 1, y0, x1, y1, l)) {
                return true;
            }
        }
        if (l.canMove(Labyrinth.Direction.DOWN, x0, y0) && !l.getMark(x0, y0+1)) {
            l.setMark(x0, y0, true);
            if(findPath(x0, y0 + 1, x1, y1, l)) {
                return true;
            }
        }
        if (l.canMove(Labyrinth.Direction.LEFT, x0, y0) && !l.getMark(x0-1, y0)) {
            l.setMark(x0, y0, true);
            if(findPath(x0 - 1, y0, x1, y1, l)) {
                return true;
            }
        }
        if (l.canMove(Labyrinth.Direction.UP, x0, y0) && !l.getMark(x0, y0-1)) {
            l.setMark(x0, y0, true);
            if(findPath(x0, y0 - 1, x1, y1, l)) {
                return true;
            }
        }
        l.setMark(x0, y0, false);
        return false;
    }
}
