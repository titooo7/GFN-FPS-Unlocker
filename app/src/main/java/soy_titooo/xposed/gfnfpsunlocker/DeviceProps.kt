package soy_titooo.xposed.gfnfpsunlocker

/**
 * Build values taken from:
 * Pixel 6:
 * https://github.com/DotOS/android_frameworks_base/blob/dot12/core/java/com/android/internal/util/custom/PixelPropsUtils.java
 * Also from
 * https://github.com/DotOS/android_frameworks_base/commit/3f7ea7d070017ed1f38035333f084865865698b2
 *
 * Features taken from:
 * https://t.me/PixelProps
 * https://github.com/DotOS/android_vendor_dot/blob/dot12/prebuilt/common/etc/pixel_2016_exclusive.xml
 * https://github.com/ayush5harma/PixelFeatureDrops/tree/master/system/etc/sysconfig
 */
object DeviceProps {

    /**
     * Class to store different feature flags for different pixels.
     * @param displayName String to show to user to customize flag selection. Example "Pixel 2020"
     * Also note that these display names are what is actually stored in shared preferences.
     * The actual feature flags are then derived from the display names.
     * @param featureFlags List of actual features spoofed to GeForce NOW for that particular [displayName].
     * Example, for [displayName] = "Pixel 2020", [featureFlags] = listOf("com.google.android.feature.PIXEL_2020_EXPERIENCE")
     */
    class Features(
        val displayName: String,
        val featureFlags: List<String>,
    ) {
        constructor(displayName: String, vararg featureFlags: String) : this(
            displayName,
            featureFlags.toList()
        )
    }

    /**
     * List of all possible feature flags.
     * CHRONOLOGY IS IMPORTANT. Elements are arranged in accordance of device release date.
     */
    val allFeatures = listOf(

        Features(
            "Pixel 2021", // Pixel 6 Pro
            "com.google.android.feature.PIXEL_2021_EXPERIENCE",
            "com.google.android.apps.photos.PIXEL_2021_PRELOAD",
        ),
    )

    /**
     * Example if [featureLevel] = "Pixel 2020", return will have
     * list of all elements from [allFeatures] from "Pixel 2016" i.e. index = 0,
     * to "Pixel 2020" i.e index = 6, both inclusive.
     */
    private fun getFeaturesUpTo(featureLevel: String): List<Features> {
        val allFeatureDisplayNames = allFeatures.map { it.displayName }
        val levelIndex = allFeatureDisplayNames.indexOf(featureLevel)
        return if (levelIndex == -1) listOf()
        else {
            allFeatures.withIndex().filter { it.index <= levelIndex }.map { it.value }
        }
    }

    /**
     * Class storing android version information to be faked.
     *
     * @param label Just a string to show the user. Not spoofed.
     * @param release Corresponds to `ro.build.version.release`. Example values: "12", "11", "8.1.0" etc.
     * @param sdk Corresponds to `ro.build.version.sdk`.
     */
    data class AndroidVersion(
        val label: String,
        val release: String,
        val sdk: Int,
    ) {
        fun getAsMap() = hashMapOf(
            Pair("RELEASE", release),
            Pair("SDK_INT", sdk),
            Pair("SDK", sdk.toString()),
        )
    }

    /**
     * List of all major android versions.
     * Pixel 1 series launched with nougat, so that is the lowest version.
     */
    val allAndroidVersions = listOf(
        AndroidVersion("Nougat 7.1.2", "7.1.2", 25),
        AndroidVersion("Oreo 8.1.0", "8.1.0", 27),
        AndroidVersion("Pie 9.0", "9", 28),
        AndroidVersion("Q 10.0", "10", 29),
        AndroidVersion("R 11.0", "11", 30),
        AndroidVersion("S 12.0", "12", 31),
    )

    /**
     * Get instance of [AndroidVersion] from specified [label].
     * Send null if no such label.
     */
    fun getAndroidVersionFromLabel(label: String) = allAndroidVersions.find { it.label == label }

    /**
     * Class to contain device names and their respective build properties.
     * @param deviceName Actual device names, example "Pixel 4a".
     * @param props Contains the device properties to spoof.
     * @param featureLevelName Points to the features expected to be spoofed from [allFeatures],
     * from "Pixel 2016" up to this level.
     */
    data class DeviceEntries(
        val deviceName: String,
        val props: HashMap<String, String>,
        val featureLevelName: String,
        val androidVersion: AndroidVersion?,
    )

    /**
     * List of all devices and their build props
     * NVIDIA SHIELD TV PRO 2019
     * ASUS ROG 5 Series ZS673KS
     * SNAPDRAGON SAMSUNG GALAXY S20 FE 5G (the one we use currently) - r8q r8qxxx SM-G781B
     * GOOGLE PIXEL 6 PRO
     * Pending to add Samsung Galaxy S21+ SM-G9960 - t2q - EXYNOS because Im sure there will be some placebo lovers who will think that spoofing the Exynos version will make a difference
     */
    val allDevices = listOf(

        DeviceEntries("None", hashMapOf(), "None", null),

        DeviceEntries(
            "Shield TV Pro",
            hashMapOf(
                Pair("BRAND", "NVIDIA"),
                Pair("MANUFACTURER", "NVIDIA"),
                Pair("DEVICE", "mdarcy"),
                Pair("PRODUCT", "mdarcy"),
                Pair("MODEL", "SHIELD Android TV"),
                Pair(
                    "FINGERPRINT",
                    "NVIDIA/mdarcy/mdarcy:11/RQ1A.210105.003/7094531_2999.9831:user/release-keys"
                ),
                //Pair("BOARD", "???"),
                //Pair("HARDWARE", "???"),
                //Pair("TYPE", "???"),
            ),
            "",
            getAndroidVersionFromLabel("R 11.0"),
        ),

        DeviceEntries(
            "ASUS ROG 5",
            hashMapOf(
                Pair("BRAND", "asus"),
                Pair("MANUFACTURER", "asus"),
                Pair("DEVICE", "ASUS_I005_1"),
                Pair("PRODUCT", "WW_I005D"),
                Pair("MODEL", "ASUS_I005DA"),
                Pair(
                    "FINGERPRINT",
                    "asus/WW_I005D/ASUS_I005_1:11/RKQ1.201022.002/18.0840.2103.26-0:user/release-keys"
                ),
                Pair("BOARD", "lahaina"),
                Pair("HARDWARE", "qcom"),
                Pair("TYPE", "Phone"),
                //Pair("PLATFORM", "lahaina"), this is not a prop from android.os.Build so using it breaks the above
            ),
            "",
            getAndroidVersionFromLabel("R 11.0"),
        ),

        DeviceEntries(
            "SAMSUNG",
            hashMapOf(
                Pair("BRAND", "samsung"),
                Pair("MANUFACTURER", "samsung"),
                Pair("DEVICE", "r8q"),
                Pair("PRODUCT", "r8qxxx"),
                Pair("MODEL", "SM-G781B"),
                Pair(
                    "FINGERPRINT",
                    "samsung/r8qxxx/r8q:10/QP1A.190711.020/G781BXXU1ATJ5:user/release-keys"
                ),
                Pair("BOARD", "kona"),
                Pair("HARDWARE", "qcom"),
                Pair("TYPE", "Phone"),
                Pair("ID", "QP1A.190711.020"),
                Pair("DISPLAY", "r8qxxx-user 10 QP1A.190711.020 G781BXXU1ATJ5 release-keys"),
                Pair("INCREMENTAL", "G781BXXU1ATJ5"),
                //Pair("PLATFORM", "kona"), this is not a prop from android.os.Build so using it breaks the above


            ),
            "",
            getAndroidVersionFromLabel("S 12.0"),
        ),

        DeviceEntries(
            "PIXEL 6 PRO",
            hashMapOf(
                Pair("BRAND", "google"),
                Pair("MANUFACTURER", "Google"),
                Pair("DEVICE", "raven"),
                Pair("PRODUCT", "raven"),
                Pair("MODEL", "Pixel 6 Pro"),
                Pair(
                    "FINGERPRINT",
                    "google/raven/raven:12/SD1A.210817.036/7805805:user/release-keys"
                ),
                Pair("HARDWARE", "raven"),
                Pair("BOARD", "raven"),
                Pair("TYPE", "Phone"),
                //Pair("PLATFORM", "gs101"), this is not a prop from android.os.Build so using it breaks the above
            ),
            "Pixel 2021",
            getAndroidVersionFromLabel("S 12.0"),
        ),
    )

    /**
     * Get instance of [DeviceEntries] from a supplied [deviceName].
     */
    fun getDeviceProps(deviceName: String?) = allDevices.find { it.deviceName == deviceName }

    /**
     * Call [getFeaturesUpTo] using a device name rather than feature level.
     * Used in spinner in main activity.
     */
    fun getFeaturesUpToFromDeviceName(deviceName: String?): Set<String> {
        return getDeviceProps(deviceName)?.let {
            getFeaturesUpTo(it.featureLevelName).map { it.displayName }.toSet()
        } ?: setOf()
    }

    /**
     * Default name of device to spoof.
     */
    val defaultDeviceName = "SAMSUNG"

    /**
     * Default feature level to spoof up to. Corresponds to what is expected for the device in [defaultDeviceName].
     */
    val defaultFeatures = getFeaturesUpTo("Pixel 2020")

}