package bg.uni.sofia.fmi.toDo;
import bg.uni.sofia.fmi.toDo.Status;
import java.time.*;
public class Task implements Comparable<Task> {
	private String name;
	private String description;
	private int priority;
	private Status status;
	private LocalDate deadline;
	
	
	
	public Task(String name,String description,int priority,Status status,LocalDate deadline)
	{
		this.name = name;
		this.description=description;
		this.priority=priority;
		this.status = status;
		this.deadline = deadline;
	}
	@Override
	public String toString()
	{
		return name + "\n" + description+"\n" + priority + "\n" + status.toString() + "\n" + deadline.toString();
	}
	
	public LocalDate getDeadLine()
	{
		return deadline;
	}
	
	public Status getStatus()
	{
		return status;
	}
	
	public boolean Soon(int howSoon)
	{
		return ((status == Status.IN_PROGRESS || status == Status.INITIAL) && (deadline.minusDays(howSoon).isBefore(LocalDate.now())));
	}
	
	@Override
	public int compareTo(Task otherTask) {
        if(priority == otherTask.priority) return 0;
        if(priority < otherTask.priority) return -1;
        else return 1;
    }
}
