# ShotPut Gradle
## What is this?
This is a gradle plugin connected to [ShotPut](https://github.com/bralax/ShotPut). It allows you to generate documentation as a gradle task.

## How To Use
This plugin can be easily added to a build.gradle file.
Just add the following to your `build.gradle` file.
```GROOVY
plugin {
    ...
    id 'io.github.bralax.shotput' version '0.1.1'
    ...
}
```

The system offers a number of options you can configure for the resulting output.
To do so, add the following section to the build.gradle file:
```GROOVY
shotputSetting {
    // Settings taken from the config.yml when not using gradle
    title = 'Example Title'
    description = 'The description of the API'
    intro = 'HTML string that will end up as the top section of the HTML documentation'
    baseUrl = 'http://example.base.url.com' // The base url of api used for example endpoints
    interactive = true //Whether to offer the ability to send test requests
    languages = ['java'] // Example request languages. Currently only java (unirest) is supported
    logo = 'path/to/logo/file'
    
    // Settings moved from the command line when not using gradle
    srcDir = layout.getProjectDirectory().dir('src')
    outputDir = layout.getProjectDirectory().dir('docs')
    generateExcel = true // Whether to generate a csv describing the endpoints
    generateHTML = true // Whether to generate html/markdown documentation
    generateOpenAPI = false //Whether to generate open api specs. Currently experimental
}
```

## Documenting
See the [ShotPut Documentation](https://github.com/bralax/ShotPut) on how to document your endpoints