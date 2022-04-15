package moe.lumii;

import moe.lumii.snake.Snake;
import moe.lumii.snake.utils.OSType;

public final class Start {
    static {
        final String architecture = System.getProperty("os.arch");
        final String opSystem = System.getProperty("os.name").toLowerCase();
        final boolean isArm64 = architecture.contains("arm64");
        final boolean isAmd64 = architecture.contains("amd64");
        final boolean isX64 = architecture.contains("x64");
        final boolean isOverX86 = (isArm64 || isAmd64 || isX64);
        final OSType osType;
        if (opSystem.contains("win"))
            osType = isOverX86 ? OSType.WINDOWS_64x : OSType.WINDOWS_32x;
        else if (opSystem.contains("linux") || opSystem.contains("unix"))
            osType = isX64 ? OSType.LINUX_x64 : isArm64 ? OSType.LINUX_arm64 : OSType.LINUX_arm32;
        else if (opSystem.contains("mac") || opSystem.contains("sunos") || opSystem.contains("solaris")
                || opSystem.contains("darwin"))
            osType = OSType.MACOS_x64;
        else osType = OSType.LINUX_arm32;
        OSType.setCurrentOS(osType);
    }

    public static void main(final String... args) {
        Snake.getInstance().run();
    }
}
