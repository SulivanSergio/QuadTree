package GL;




public class QuadTree {
	
	
	Rect dimension; 
	boolean divided;
	QuadTree noroeste;
	QuadTree nordeste;
	QuadTree sudoeste;
	QuadTree sudeste;
	
	public QuadTree(Rect dimension)
	{
		divided = false;
		this.dimension = dimension;
		
	}
	
	public void Subdivide()
	{
		
		if(!divided)
		{
			Rect no = new Rect(dimension.x, dimension.y,dimension.width/2,dimension.height/2);
			Form.instance.Paint(no);
			noroeste = new QuadTree(no);
			
			Rect ne = new Rect(dimension.x + dimension.width/2, dimension.y,dimension.width/2,dimension.height/2);
			Form.instance.Paint(ne);
			nordeste = new QuadTree(ne);
			
			Rect so = new Rect(dimension.x, dimension.y + dimension.height/2,dimension.width/2,dimension.height/2);
			Form.instance.Paint(so);
			sudoeste = new QuadTree(so);
			
			Rect se = new Rect(dimension.x + dimension.width/2, dimension.y + dimension.height/2,dimension.width/2,dimension.height/2);
			Form.instance.Paint(se);
			sudeste = new QuadTree(se);
			
		}
		
		
	}
	
}
