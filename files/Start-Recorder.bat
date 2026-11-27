@echo off
setlocal enabledelayedexpansion
set "BIN=%~dp0bin\64bit"
set "PROF=Recorder_CPU"
set "GPUS="
for /f "skip=1 delims=" %%G in ('wmic path win32_VideoController get name') do set "GPUS=!GPUS! %%G"
echo !GPUS! | findstr /i "Intel" >nul && set "PROF=Recorder_Intel"
echo !GPUS! | findstr /i "AMD Radeon" >nul && set "PROF=Recorder_AMD"
echo !GPUS! | findstr /i "NVIDIA GeForce" >nul && set "PROF=Recorder_NVIDIA"
cd /d "%BIN%"
start "" obs64.exe --portable --profile "%PROF%" --collection "Minecraft"
exit /b
