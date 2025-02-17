@echo off
setlocal

rem Maven wrapper for Windows

set MAVEN_HOME=%~dp0\.mvn\wra
set MAVEN_OPTS=-Xmx1024m -XX:MaxPermSize=256m

if not exist "%MAVEN_HOME%\bin\mvn" (
    echo "Maven not found. Please install Maven."
    exit /b 1
)

"%MAVEN_HOME%\bin\mvn" %*