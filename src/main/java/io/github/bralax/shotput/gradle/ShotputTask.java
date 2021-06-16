package io.github.bralax.shotput.gradle;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;
import org.gradle.api.Project;

import io.github.bralax.shotput.Config;
import io.github.bralax.shotput.Shotput;

import java.io.File;
import java.io.IOException;

/** The task for generating documentation. */
public class ShotputTask extends DefaultTask {

    /**
     * The task to be added.
     * @throws IOException if the specified soure or destination folder does not exist
     */
    @TaskAction
    public void generate() throws IOException {
        ShotputExtension config = getProject().getExtensions().findByType(ShotputExtension.class);
        if (config == null) {
            return;
        }
        Project project = this.getProject();
        File src = config.srcDir != null ? config.srcDir : project.file("src/main/java/");
        File out = config.outputDir != null ? config.outputDir : project.file("docs/");
        Shotput.setLogger(project.getLogger());
        Shotput shot = new Shotput(config, 
                                   src, 
                                   config.generateExcel != null ? config.generateExcel : false, 
                                   config.generateHTML != null ? config.generateHTML : false, 
                                   config.generateOpenAPI != null ? config.generateOpenAPI : false, 
                                   out);
        shot.start();
    }

    @Override
    public String getGroup() {
        return "Documentation";
    }

    @Override
    public String getDescription() {
        return "A task to generate documentation with ShotPut";
    }
}
