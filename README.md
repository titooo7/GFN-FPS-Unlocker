# GFN-FPS-Unlocker
LSPosed / EdXposed module for GFN RTX 3080 users with an 120Hz Android device that isn't officially supported to receive a 120FPS GFN stream.

### Steps to use:
1. You need a rooted Android device, but DO NOT ROOT your  device unless you are ok with the CONS that rooting an Android brings nowadays!
2. Install Magisk, [LSPosed](https://github.com/LSPosed/LSPosed) Or [EdXposed](https://github.com/ElderDrivers/EdXposed).  
3. Install the apk of this app (available from [Releases](https://github.com/titooo7/GFN-FPS-Unlocker/releases) page.)  
4. Open LSPosed / EdXposed app and enable the module. For LSPosed, GeForce NOW will be automatically selected as a target app to receive spoofed data.  
5. Reboot, open the app GFN 120FPS Unlocker and apply changes. (It will clear the data of GeForce NOW app).  

### How does this module work?
This module spoof the `BRAND`, `MANUFACTURER`, `MODEL`, `FINGERPRINT`, `BOARD`, `HARDWARE` of your phone. 
By default, the values are spoofed only for GeForce NOW, but you can enable it for other apps as well in LSPosed (just make sure to untick the option "Make sure to spoof only in GeForce NOW")

### Will it work with my 120Hz Android phone/tablet?
It has been confirmed to work on Samsung devices with a 120Hz display, it might or might not work on 120Hz Android devices from other brands.
If it doesn't work for your 120Hz device then most likely the manufacturer ROM is the one to blame, don't blame Nvidia nor myself.

### On wich devices did you test it?
Galaxy A52s: Perfect results streaming at 720p 120FPS. Terrible results streaming at 1080p 120FPS probably due to lack of power on my device.
Xiaomi Pad 5: It doesn't work, spoofing those values isn't enough

### TO-DO
Spoofing ro.sf.lcd_density. On devices like Xiaomi Pad 5 it needs to be changed to 450 otherwise it won't enable the 120fps option. I tried to do it but failed miserable (probably easy to do for a real dev).

### Disclaimer!!
The user takes sole responsibility for any damage that might arise due to use of this module.  
This includes physical damage (to device), injury, data loss, and also legal matters.
This project was made as a learning initiative and the developer cannot be held liable in any way for the use of it.


