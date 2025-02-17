@echo off
setlocal

set MAVEN_HOME=%~dp0\.mvn\w
set MAVEN_OPTS=-Xmx1024m -XX:MaxPermSize=256m

if exist "%MAVEN_HOME%\bin\mvn" (
    "%MAVEN_HOME%\bin\mvn" %*
) else (
    echo "Maven not found. Please install Maven."
)

endlocal