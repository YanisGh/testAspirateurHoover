import java.util.Scanner;

public class AspirateurHoover {
    private int CoorX;
    private int CoorY;
    private char orientation;
    private int tailleGrilleX;
    private int tailleGrilleY;

    public AspirateurHoover(int CoorX, int CoorY, char orientation, int tailleGrilleX, int tailleGrilleY) {
        this.CoorX = CoorX;
        this.CoorY = CoorY;
        this.orientation = orientation;
        this.tailleGrilleX = tailleGrilleX;
        this.tailleGrilleY = tailleGrilleY;
    }
    //Methode pour éxécuter les instructions après avoir tout renseigné
    public void executeInstructions(String instructions) {
        for (char instruction : instructions.toCharArray()) {
            switch (instruction) {
                case 'D':
                    droite();
                    break;
                case 'G':
                    gauche();
                    break;
                case 'A':
                    avancer();
                    break;
                default:
                    throw new IllegalArgumentException("Instruction non valide : " + instruction);
            }
        }
    }
    //Methode pour tourner a droite
    private void droite() {
        switch (orientation) {
            case 'N':
                orientation = 'E';
                break;
            case 'E':
                orientation = 'S';
                break;
            case 'S':
                orientation = 'W';
                break;
            case 'W':
                orientation = 'N';
                break;
        }
    }
  //Pour tourner a gauche
    private void gauche() {
        switch (orientation) {
            case 'N':
                orientation = 'W';
                break;
            case 'E':
                orientation = 'N';
                break;
            case 'S':
                orientation = 'E';
                break;
            case 'W':
                orientation = 'S';
                break;
        }
    }
  //Pour avancer
    private void avancer() {
        switch (orientation) {
            case 'N':
            	CoorY = CoorY + 1;
                break;
            case 'E':
            	CoorX = CoorX + 1;
                break;
            case 'S':
            	CoorY = CoorY - 1;
                break;
            case 'W':
            	CoorX = CoorX - 1;
                break;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez la taille de la grille (X Y): ");
        int tailleGrilleX = scanner.nextInt();
        int tailleGrilleY = scanner.nextInt();

        System.out.print("Entrez la position initiale (X Y Orientation): ");
        int CoorX = scanner.nextInt();
        int CoorY = scanner.nextInt();
        char initialOrientation = scanner.next().charAt(0);

        System.out.print("Instruction a suivre: ");
        String instructions = scanner.next();

        scanner.close();

        AspirateurHoover hoover = new AspirateurHoover(CoorX, CoorY, initialOrientation, tailleGrilleX, tailleGrilleY );
        hoover.executeInstructions(instructions);

        System.out.println("Position finale : x= " + hoover.CoorX + " y= " + hoover.CoorY + " orientation= " + hoover.orientation);
    }
}
