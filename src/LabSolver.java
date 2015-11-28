public class LabSolver {

    public static void main(String[] args) {
        int width = 10;
        int height = 10;
        if (args.length > 1) {
            width = Integer.parseInt(args[0]);
            height = Integer.parseInt(args[1]);
        }
        Labyrinth l = new LabSwing(width,height);
        System.out.println("\nCreated a random labyrinth:");
        System.out.println(l);
        boolean success = findPath(0,0,width-1,height-1,l);
        if (success) {
            System.out.println("Solution found:");
            System.out.println(l);
        } else {
            System.out.println("Failed to find a solution. (Bug in LabSolver.java)");
        }
    }

    public static boolean findPath(int x0, int y0, int x1, int y1, Labyrinth l) {
        try { //if you want to see the recursion step-by-step
            Thread.sleep(300);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        //System.out.println(l);

        if ((x0 == x1) && (y0 == y1)) { //if correct path is found, set final mark and return true
            l.setMark(x0, y0, true);
            return true;
        }

        if (l.canMove(Labyrinth.Direction.RIGHT, x0, y0) && !l.getMark(x0+1, y0)) { //if no wall or mark is in the way
            l.setMark(x0, y0, true); //set mark on current position
            if(findPath(x0 + 1, y0, x1, y1, l)) { //try to continue from the next position
                return true; //if the correct path was eventually found, return true
            } //else don't return anything and try going down instead...
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
        l.setMark(x0, y0, false); //if all ways are blocked, remove current position mark and return false (move back
        return false;             //in the recursion) until another alternative is possible
    }
}
