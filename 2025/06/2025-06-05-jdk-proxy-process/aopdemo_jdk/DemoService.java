package mine.projects.aopdemo_jdk;

import org.springframework.stereotype.Service;

@Service
public class DemoService implements DemoInterface {
	public void save() {
		System.out.println("Save run");
	}
}

