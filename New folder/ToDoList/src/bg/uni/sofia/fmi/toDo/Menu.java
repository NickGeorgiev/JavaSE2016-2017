package bg.uni.sofia.fmi.toDo;
import bg.uni.sofia.fmi.toDo.ToDO;
import bg.uni.sofia.fmi.toDo.Task;
public class Menu {
	private ToDO list;
	public Menu(Task[] list)
	{
		this.list = new ToDO(list);
	}
	public void Prompt()
	{
		//Simple work test, without real prompt
		list.ViewByPriority();
		System.out.println("---");
		System.out.println("---");
		System.out.println("---");
		list.ViewInProgress();
		System.out.println("---");
		list.ViewInThe3Days();
	}
}
