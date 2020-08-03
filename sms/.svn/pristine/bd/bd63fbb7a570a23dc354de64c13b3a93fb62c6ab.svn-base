
package iSMS.web.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "imagesView")
@SessionScoped
public class ImagesView implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<String> images;
	
	// @PostConstruct
	public void init() {
		
		images = new ArrayList<String>();
		for (int i = 1; i <= 12; i++) {
			images.add("car" + i + ".jpg");
		}
	}
	
	public List<String> getImages() {
		
		return images;
	}
}
