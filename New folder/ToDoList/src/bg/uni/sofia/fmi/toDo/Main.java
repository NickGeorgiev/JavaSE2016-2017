package bg.uni.sofia.fmi.toDo;
import bg.uni.sofia.fmi.toDo.Task;
import bg.uni.sofia.fmi.toDo.Status;
import java.time.LocalDate;
import bg.uni.sofia.fmi.toDo.Menu;
public class Main {

	public static void main(String[] args) {
		Task a = new Task("task1", "yes no no", 1, Status.DONE, LocalDate.now().plusDays(5));
		Task b = new Task("task2", "yes no no", 5, Status.INITIAL, LocalDate.now().plusDays(4));
		Task c = new Task("task3", "yes yes yes", 3, Status.IN_PROGRESS, LocalDate.now().plusDays(2));
		Task d = new Task("task4", "yes no yes", 4, Status.DONE, LocalDate.now());
		Task[] arr={a,b,c,d};
		Menu F = new Menu(arr);
		F.Prompt();
	}

}
