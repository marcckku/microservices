:::

@echo off
setlocal

rem Maven wrapper script for Windows

set MAVEN_HOME=%~dp0\.mvn\wra
set MAVEN_OPTS=-Xmx1024m -XX:MaxPermSize=256m

if not exist "%MAVEN_HOME%\bin\mvn" (
    echo "Maven not found. Please install Maven or set MAVEN_HOME."
    exit /b 1
)

"%MAVEN_HOME%\bin\mvn" %*
endlocal
exit /b %ERRORLEVEL%