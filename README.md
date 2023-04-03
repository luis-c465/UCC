# UCC

UCC game for AP Computer Science AB 2022-2023 in Ivan Rico's class

## Dependencies for running

- [Java 1.8](https://www.oracle.com/java/technologies/javase/javase8-archive-downloads.html) or [higher](https://adoptium.net/)

## Running

- First download the **[Latest release](https://github.com/luis-c465/UCC/releases/latest)**
- Then run in the command line _(Or just double click on the file)_
  ```bash
  java -jar [path to downloaded jar file]
  ```

## Building

### Dependencies

- **[Maven v3.8.4](https://maven.apache.org/download.cgi)**

### How to build

Run the following in the [command line](https://www.freecodecamp.org/news/how-to-use-the-cli-beginner-guide/#how-to-locate-your-cli)

```bash
mvn clean compile assembly:single
```

- Then the **Executable Jar** `ucc.jar` will be in the root folder 🎉

## Project Requirements

Due: **Mon, Apr 17 2023** @1 AM
