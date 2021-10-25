public interface Tree <T extends Comparable <T> >{
	public void add(T item);
	public boolean contains(T item);
	public int size();
	public void inOrderPrint();
	public String toString();
}
