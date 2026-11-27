[Setup]
AppName=Game Recorder
AppVersion=1.0
DefaultDirName={localappdata}\GameRecorder
DefaultGroupName=Game Recorder
PrivilegesRequired=lowest
OutputDir=dist
OutputBaseFilename=GameRecorder-Setup
Compression=lzma2
SolidCompression=yes
DisableProgramGroupPage=yes

[Files]
Source: "build\app\*"; DestDir: "{app}"; Flags: recursesubdirs createallsubdirs

[Icons]
Name: "{userdesktop}\Game Recorder"; Filename: "{app}\Start-Recorder.bat"; WorkingDir: "{app}"; IconFilename: "{app}\bin\64bit\obs64.exe"
Name: "{group}\Game Recorder"; Filename: "{app}\Start-Recorder.bat"; WorkingDir: "{app}"; IconFilename: "{app}\bin\64bit\obs64.exe"

[Run]
Filename: "{app}\Start-Recorder.bat"; Description: "Run Game Recorder"; Flags: postinstall nowait skipifsilent
