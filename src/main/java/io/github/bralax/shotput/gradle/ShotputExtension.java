package io.github.bralax.shotput.gradle;

import io.github.bralax.shotput.Config;

import java.io.File;


/** The config of the plugin. */
public class ShotputExtension extends Config {

    public File srcDir;

    public File outputDir;

    public Boolean generateExcel;

    public Boolean generateHTML;

    public Boolean generateOpenAPI;
}