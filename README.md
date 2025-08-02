# Kotlin + Bazel Example
[**Bazel Configuration**](#bazel-configuration)
| [**Requirements**](#requirements)
| [**Windows-specific information**](#windows-specific-information)

A minimal, professional template demonstrating how to configure [Bazel](https://bazel.build) to 
build, run and debug Kotlin code (using the [IntelliJ IDEA](https://www.jetbrains.com/idea/) IDE with the official
[Bazel plugin](https://plugins.jetbrains.com/plugin/22977-bazel)).

## Project Structure

```
.
├── MODULE.bazel         # Bzlmod configuration
├── .bazelrc             # Bazel runtime configuration
├── .bazelversion        # Pinned Bazel version
├── BUILD.bazel          # Kotlin toolchain definition
└── src/
    ├── BUILD.bazel      # Build targets definition
    ├── main/
        ├── java/
        │   └── org/
        │       └── example/
        │           └── Main.java    # Entry point (necessary for MS Windows)
        └── kotlin/
            └── org/
                └── example/
                    └── FileUtil.kt  # Kotlin utility class
```

## Bazel Configuration

This project demonstrates modern Bazel configuration with Bzlmod:

### MODULE.bazel
- Uses Bzlmod for dependency management (Bazel's module system)
- Depends on `rules_kotlin` version 2.1.8 for Kotlin support
- Configures Maven repositories for external dependencies
- Registers a custom Kotlin toolchain

### .bazelrc
- Sets Java language version to 17 and runtime to JDK 21
- Enables Windows-specific configuration with `--legacy_external_runfiles`
- Contains workarounds for known issues with `rules_kotlin` on MS Windows

### BUILD.bazel (root)
- Defines Kotlin toolchain with language and API version 2.0
- Sets JVM target to 17
- Configures Kotlin compiler options

### src/BUILD.bazel
- Defines three targets:
  - `main_lib`: Java library containing Main.java
  - `utils_lib`: Kotlin library containing FileUtil.kt
  - `Main`: Java binary with the main class `org.example.Main`
- Uses Java binary wrapper instead of `kt_jvm_binary` for Windows compatibility

## Application Overview

The example demonstrates Java-Kotlin interoperability (due to known Windows-specific issues when 
it comes to debugging):
- Java entry point (`Main.java`) calls Kotlin utility class
- Kotlin utility (`FileUtil.kt`) provides file extension extraction functionality

## Build & Run

Build the application:
```bash
bazel build //src:Main
```

Run the application:
```bash
bazel run //src:Main
```

Expected output:
```
The file extension is: .txt
```

## Requirements
- Bazel 8.x (use `bazelisk` for version management)
  - For Windows, it is recommended to install [Bazelisk](https://github.com/bazelbuild/bazelisk) 
  through [Chocolatey](https://chocolatey.org/): `choco install bazelisk`
- Optional: IntelliJ IDEA with [Bazel plugin](https://plugins.jetbrains.com/plugin/22977-bazel)

## Windows-specific information
Running Bazel on Windows requires at the time of writing a few workarounds:
- Use Java binary wrapper instead of `kt_jvm_binary`
  - The `kt_jvm_binary` rule does not (at this moment) support debugging (with IntelliJ) on Windows
- Set `--legacy_external_runfiles` to avoid issues with runfiles
  - It is known that on Windows runfiles are not properly resolved and this error is thrown 
  `LAUNCHER ERROR: Rlocation failed on _main/external/rules_kotlin++rules_kotlin_extensions+com_github_jetbrains_kotlin_git/lib/annotations-13.0.jar, path doesn't exist in MANIFEST file`

## GitHub CI/CD
This repository contains a GitHub Actions `workflow` that builds the source code on Windows, Linux, 
and macOS.
It should provide a good starting point for CI/CD pipelines utilizing Bazel with Kotlin.
The workflow is not complete and must be extended to include testing and deployment steps 
that make sense for your project.

## References
- [Bazel Documentation](https://bazel.build/docs)
- [Bazelisk](https://github.com/bazelbuild/bazelisk)
- [Bzlmod Documentation](https://bazel.build/external/module)
- [Chocolatey](https://chocolatey.org/)

## License
Licensed under the BSD 3-Clause License http://opensource.org/licenses/bsd-3-clause. This project may not be copied, 
modified, or distributed except according to those terms.
