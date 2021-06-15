package io.github.bralax.shotput.gradle;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import java.util.HashMap;
import java.util.Map;

import io.github.bralax.shotput.Config;


/**
 * The gradle plugin.
 */
public class ShotputPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        project.getExtensions().create("shotputSetting", ShotputExtension.class);
        /*Map<String, Object> taskSettings = new HashMap<>();
        taskSettings.put("name", "apidoc");
        taskSettings.put("task", ShotputTask.class);
        taskSettings.put("group", "Documentation");
        taskSettings.put("description", "A task to generate documentation with ShotPut");
        project.getTasks().create(taskSettings);*/
        project.getTasks().register("apidoc", ShotputTask.class);
    }
}
