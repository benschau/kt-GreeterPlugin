# GreeterPlugin

## Description
A simple example of a Minecraft plugin, written in Kotlin (+Gradle Kotlin DSL).

All this plugin does is greet any users with "{name} joins the fold!" whenever
they join the server. You should see the output in-game and in the server
logs. 

Feel free to use with impunity. 

## Why do this?
Using Maven makes me want to tear my hair out. Having to r/w XML tags feels 
wrong and outdated, or I'm just not familiar enough with Maven to know the purpose
for it. 

So, I figured I would try another popular build system, Gradle. As far as I am 
concerned, in the couple days of using it, I was able to figure out how to 
do a proper build for a Minecraft (Paper) plugin. That having been said, it seems
like I will eventually need some Groovy knowledge if the build gets any more complex
than it is.
