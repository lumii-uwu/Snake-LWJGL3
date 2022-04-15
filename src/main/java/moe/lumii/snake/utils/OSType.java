package moe.lumii.snake.utils;

public enum OSType {

    WINDOWS_32x("windows", "x86"),
    WINDOWS_64x("windows", "x64"),
    LINUX_arm32("linux", "arm32"),
    LINUX_arm64("linux", "arm64"),
    LINUX_x64("linux", "x64"),
    MACOS_x64("macos", "x64");

    private static OSType currentOS = null;

    OSType(final String name, final String arch) {}

    public static OSType getCurrentOS() {
        return currentOS;
    }

    public static void setCurrentOS(final OSType osType) {
        currentOS = osType;
    }

}
