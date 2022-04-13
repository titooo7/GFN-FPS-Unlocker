# GFN-FPS-Unlocker
LSPosed / EdXposed module to enable FullHD 120FPS streaming on some 120Hz phones with 120FPS support via GFN RTX 3080 subscription. 
Tested on LSPosed by [soy_titooo](https://github.com/titooo7)  

[Development repo](https://github.com/titooo7/GFN-FPS-Unlocker.git)  


### Steps to use:
1. Install Magisk, [LSPosed](https://github.com/LSPosed/LSPosed) Or [EdXposed](https://github.com/ElderDrivers/EdXposed).  
2. Install the apk of this app (available from [Releases](https://github.com/titooo7/GFN-FPS-Unlocker/releases) page.)  
3. Open LSPosed / EdXposed app and enable the module. For LSPosed, GeForce NOW will be automatically selected.  
4. Reboot,  open the app and apply changes. (Applying changes will clear data of GeForce NOWs app).  

### How does this module work?
This module spoof some `build.prop` information like `BRAND`, `MANUFACTURER`, `MODEL`, `FINGERPRINT`, `BOARD`, `HARDWARE`. By default the values are spoofed only for GeForce NOW app.

### TO-DO
Spoofing Platform props. I tried to do it but then most of the values wouldn't be spoofed.

### Disclaimer!!
Do not root your Android device unless you are ok with the cons that rooting a phone brings nowadays.
The user takes sole responsibility for any damage that might arise due to use of this module.  
This includes physical damage (to device), injury, data loss, and also legal matters.
This project was made as a learning initiative and the developer cannot be held liable in any way for the use of it.
