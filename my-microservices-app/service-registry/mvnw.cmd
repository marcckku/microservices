:::
@echo off
setlocal

rem Maven wrapper script for Windows

set MAVEN_HOME=%~dp0\.mvn\wrapper
set MAVEN_OPTS=-Xmx1024m -XX:MaxPermSize=256m

if not exist "%MAVEN_HOME%\mvnw.cmd" (
    echo "Maven wrapper not found. Please ensure you have the correct project structure."
    exit /b 1
)

"%MAVEN_HOME%\mvnw" %*
exit /b %ERRORLEVEL%
:::