@echo off
echo Credits Plugin Build Script
echo ========================

REM Check if Java is installed
java -version >nul 2>&1
if %ERRORLEVEL% NEQ 0 (
    echo Java is not installed or not in PATH.
    echo Please install JDK 17 or newer from https://www.oracle.com/java/technologies/downloads/
    echo After installation, make sure Java is in your PATH.
    pause
    exit /b 1
)

REM Check if Maven is installed
mvn -version >nul 2>&1
if %ERRORLEVEL% NEQ 0 (
    echo Maven is not installed or not in PATH.
    echo Downloading Maven wrapper...
    
    REM Download Maven Wrapper
    powershell -Command "& {Invoke-WebRequest -Uri 'https://github.com/takari/maven-wrapper/raw/master/mvnw.cmd' -OutFile 'mvnw.cmd'}"
    powershell -Command "& {Invoke-WebRequest -Uri 'https://github.com/takari/maven-wrapper/raw/master/mvnw' -OutFile 'mvnw'}"
    powershell -Command "& {Invoke-WebRequest -Uri 'https://github.com/takari/maven-wrapper/raw/master/.mvn/wrapper/maven-wrapper.jar' -OutFile '.mvn/wrapper/maven-wrapper.jar'}"
    powershell -Command "& {Invoke-WebRequest -Uri 'https://github.com/takari/maven-wrapper/raw/master/.mvn/wrapper/maven-wrapper.properties' -OutFile '.mvn/wrapper/maven-wrapper.properties'}"
    
    echo Using Maven wrapper for build.
    set MVN_CMD=mvnw.cmd
) else (
    set MVN_CMD=mvn
)

REM Create directories if they don't exist
if not exist ".mvn\wrapper" mkdir ".mvn\wrapper"

echo Building plugin...
%MVN_CMD% clean package

if %ERRORLEVEL% NEQ 0 (
    echo Build failed.
    pause
    exit /b 1
)

echo Build successful!
echo The plugin JAR file is located in the target directory.
echo Copy the JAR file to your server's plugins folder to install.

pause
