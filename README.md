# GFN-FPS-Unlocker
LSPosed / EdXposed module to enable FullHD 120FPS streaming on some 120Hz phones with 120FPS support via GFN RTX 3080 subscription.

### Steps to use:
1. Install Magisk, [LSPosed](https://github.com/LSPosed/LSPosed) Or [EdXposed](https://github.com/ElderDrivers/EdXposed).  
2. Install the apk of this app (available from [Releases](https://github.com/titooo7/GFN-FPS-Unlocker/releases) page.)  
3. Open LSPosed / EdXposed app and enable the module. For LSPosed, GeForce NOW will be automatically selected as a target app to receive spoofed data.  
4. Reboot, open the app GFN 120FPS Unlocker and apply changes. (It will clear the data of GeForce NOW app).  

### How does this module work?
This module spoof some `build.prop` information like `BRAND`, `MANUFACTURER`, `MODEL`, `FINGERPRINT`, `BOARD`, `HARDWARE`. 
By default the values are spoofed only for GeForce NOW app, but you can spoof for other apps as well if you enable it in LSPosed and also untick the option "Make sure to spoof only in GeForce NOW"

### TO-DO
Spoofing Platform props. I tried to do it but then most of the values wouldn't be spoofed.

### Disclaimer!!
Do not root your Android device unless you are ok with the cons that rooting a phone brings nowadays.
The user takes sole responsibility for any damage that might arise due to use of this module.  
This includes physical damage (to device), injury, data loss, and also legal matters.
This project was made as a learning initiative and the developer cannot be held liable in any way for the use of it.

This has been tested on Samsung 120Hz devices. It might or might not work in 120Hz Android devices from other brands. If it doesn't then most likely the manufacturer ROM of your device is the one to blame, don't blame Nvidia nor myself.

