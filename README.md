# Plugin base for Play2!

## Description

This is plugin base for play 2.0

## Usage

### 1. Install the module dependency

Edit your play project file `project/Build.scala` and adjust the following settings

```scala
    val appDependencies = Seq(
      "jp.greative" % "play2-plugin-base_2.9.1" % "0.1"
      // Add your project dependencies here,
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = JAVA).settings(
      resolvers += "Greative Repository" at "https://github.com/karad/maven-repo/raw/master/release/"
      // Add your own project settings here      
    )
```

### 2. Insert your view template

```
@import tags._

@main() {
    
    @hello()

}
```

output is

```
Hello world!
```

## Licence

This software is licensed under the Apache 2 license, quoted below.

Copyright 2012 Greative (http://greative.jp).

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this project except in compliance with the License. You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0.

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.