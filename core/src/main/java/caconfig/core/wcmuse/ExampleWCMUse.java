package caconfig.core.wcmuse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.caconfig.ConfigurationBuilder;

import com.adobe.cq.sightly.WCMUsePojo;
import com.day.cq.wcm.api.Page;

import caconfig.core.caconfig.ExampleConfiguration;

public class ExampleWCMUse extends WCMUsePojo {
	private ExampleConfiguration config;

	@Override
	public void activate() throws Exception {
		config = getResource().adaptTo(ConfigurationBuilder.class).as(ExampleConfiguration.class);
		// TODO Auto-generated method stub
	}
	
	public String getCustomValue() {
		return config.customValue();
	}
	
	public List<Page> getCustomList() {
		List<Page> result = new ArrayList<Page>();
		String path = config.customValue();
		Page page = getPageManager().getPage(path);
		if (page != null) {
			Iterator<Page> iterator = page.listChildren();
			while (iterator.hasNext()) {
				result.add(iterator.next());
			}
		}
		return result;
	}
}