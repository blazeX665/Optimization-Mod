[General]
Name=@NAME@

[Video]
BaseCX=1920
BaseCY=1080
OutputCX=1920
OutputCY=1080
FPSType=0
FPSCommon=60
ScaleType=bicubic

[Audio]
SampleRate=48000
ChannelSetup=Stereo

[Output]
Mode=Advanced

[AdvOut]
RecType=Standard
RecFormat=mkv
RecTracks=3
RecEncoder=@ENC@
Track1Bitrate=192
Track2Bitrate=192

[Hotkeys]
OBSBasic.StartRecording={"bindings":[{"key":"OBS_KEY_F9"}]}
OBSBasic.StopRecording={"bindings":[{"key":"OBS_KEY_F9"}]}
