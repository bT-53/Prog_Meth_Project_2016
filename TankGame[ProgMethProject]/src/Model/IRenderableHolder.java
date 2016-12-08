package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class IRenderableHolder {
	
	public static final IRenderableHolder instance = new IRenderableHolder();
	private List<IRenderable> entities;
	private Comparator<IRenderable> comparator;
	
	public IRenderableHolder() {
		entities = new ArrayList<>();
		comparator = (IRenderable o1, IRenderable o2) -> {
			if (o1.getZ() > o2.getZ())
				return 1;
			return -1;
		};
	}
	
	public void addEntity(IRenderable e) {
		entities.add(e);
		Collections.sort(entities, comparator);
	}
	
	public List<IRenderable> getEntities() {
		return entities;
	}
}
