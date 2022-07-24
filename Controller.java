public class Controller {
    private Display display; 
    private Model model; 
    
    Controller () {
        display = new Display(this); 
        model = new Model(display); 
    }

    void quit () {
        System.exit(0);
}
}
