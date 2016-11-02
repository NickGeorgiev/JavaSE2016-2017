package bg.uni.sofia.fmi.toDo;
import java.util.Arrays;

import bg.uni.sofia.fmi.toDo.Task;
public class ToDO {
	private Task[] tasks;
	public ToDO(Task[] tasks)
	{
		int size = tasks.length;
		this.tasks = new Task[size];
		this.tasks = tasks;
	}
	public void ViewByPriority()
	{
		Arrays.sort(tasks);
		for(int i=0;i<tasks.length;i++)
		{
			System.out.println(tasks[i].toString());
			System.out.println("---");
		}
	}
	public void ViewInProgress()
	{
		for(int i=0;i<tasks.length;i++)
		{
			if(tasks[i].getStatus()==Status.IN_PROGRESS){
				System.out.println(tasks[i].toString());
			}
		}
	}
	public void ViewInThe3Days()
	{
		for(int i=0;i<tasks.length;i++)
		{
			if(tasks[i].Soon(3)){
				System.out.println(tasks[i]);
			}
		}
	}
}
