# rosetta2-compile-test-kotlin

A simple program for measuring compile performance on Rosetta 2 versus native arm64 JDK's. 

## About

I wanted to see the compile times of a simple Kotlin hello-world program on a native arm64 JDK versus non-native JDK. This program compiles a hello-world app 20 times and averages the time. 

I used SDKMAN to manage JDK's
Native JDK -> `11.0.13-zulu`
Non-Native JDK -> `11.0.11.j9-adpt`

Contains the following applications, written in Kotlin
1) hello-world (self explanatory) 
2) Simple timer program to evaluate how long it takes to compile hello-world. This program compiles hello-world 20 times and averages the time across each. 

## How to Run
1) Clone repo
2) Open terminal, change directories to `src` folder
3) Compile timer program, `kotlinc timer.kt -include-runtime -d timer.jar`
4) Run timer program, `java -jar timer.jar`

Sample output on non-native JDK:
```shell
......
  13.953s
  12.758s
  12.29s
  8.754s
  8.619s
  8.448s
Average Runtime: 10.8s
```

Sample output on native arm64 JDK:
```shell
......
  2.614s
  2.567s
  2.575s
  2.59s
  2.59s
  2.577s
Average Runtime: 2.59s
```
