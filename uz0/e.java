package uz0;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.AudioRecordingConfiguration;
import android.os.Build;
import com.tencent.component.utils.LogUtil;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static AudioManager f440642a;

    public static int a() {
        AudioManager audioManager;
        List list;
        if (Build.VERSION.SDK_INT >= 24 && (audioManager = f440642a) != null) {
            try {
                list = audioManager.getActiveRecordingConfigurations();
            } catch (Exception unused) {
                LogUtil.w("AudioManagerUtil", "getActiveRecordingCount -> get ActiveRecordingConfigurations failed");
                list = null;
            }
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return 0;
    }

    public static AudioManager b() {
        return f440642a;
    }

    public static synchronized int c() {
        synchronized (e.class) {
            if (f440642a == null) {
                d(tz0.a.a());
            }
            AudioManager audioManager = f440642a;
            if (audioManager == null) {
                LogUtil.i("AudioManagerUtil", "getHeadPhoneAudioType: audiomanager is null,return default value");
                return 1;
            }
            boolean isBluetoothA2dpOn = audioManager.isBluetoothA2dpOn();
            boolean isWiredHeadsetOn = f440642a.isWiredHeadsetOn();
            LogUtil.i("AudioManagerUtil", "isBluetoothA2dpOn: " + isBluetoothA2dpOn + ", isWiredHeadsetOn: " + isWiredHeadsetOn);
            AudioDeviceInfo[] devices = f440642a.getDevices(2);
            if (devices != null) {
                for (AudioDeviceInfo audioDeviceInfo : devices) {
                    int type = audioDeviceInfo.getType();
                    LogUtil.i("AudioManagerUtil", "deviceInfoType=" + h(type));
                    if (type != 8 && type != 7) {
                        if (type != 22 && type != 3 && type != 4 && type != 11 && type != 12 && type != 5) {
                        }
                        isWiredHeadsetOn = true;
                        break;
                    }
                    isBluetoothA2dpOn = true;
                    break;
                }
                LogUtil.i("AudioManagerUtil", "api aboveorEqual m ,isBlueTooth=" + isBluetoothA2dpOn + ",isWiredHeadSet = " + isWiredHeadsetOn);
            }
            if (isWiredHeadsetOn) {
                return 2;
            }
            if (!isBluetoothA2dpOn) {
                return 1;
            }
            return 3;
        }
    }

    public static void d(Context context) {
        if (f440642a == null) {
            try {
                f440642a = (AudioManager) context.getSystemService("audio");
            } catch (Exception e16) {
                LogUtil.e("AudioManagerUtil", "initAudioManager -> " + e16.getMessage());
            }
            if (f440642a == null && tz0.a.a() != null) {
                try {
                    f440642a = (AudioManager) tz0.a.a().getSystemService("audio");
                } catch (Exception e17) {
                    LogUtil.e("AudioManagerUtil", "initAudioManager -> " + e17.getMessage());
                }
            }
        }
    }

    public static boolean e() {
        if (a() > 1) {
            return true;
        }
        return false;
    }

    public static boolean f() {
        AudioManager audioManager;
        List list;
        int clientAudioSource;
        int clientAudioSessionId;
        AudioDeviceInfo audioDevice;
        if (Build.VERSION.SDK_INT >= 24 && (audioManager = f440642a) != null) {
            try {
                list = audioManager.getActiveRecordingConfigurations();
            } catch (Exception unused) {
                LogUtil.w("AudioManagerUtil", "isAudioRecordOccupied() -> get ActiveRecordingConfigurations failed");
                list = null;
            }
            if (list == null || list.size() <= 0) {
                return false;
            }
            Iterator it = list.iterator();
            if (!it.hasNext()) {
                return false;
            }
            AudioRecordingConfiguration audioRecordingConfiguration = (AudioRecordingConfiguration) it.next();
            clientAudioSource = audioRecordingConfiguration.getClientAudioSource();
            clientAudioSessionId = audioRecordingConfiguration.getClientAudioSessionId();
            LogUtil.i("AudioManagerUtil", String.format("isAudioRecordOccupied() -> audioSource:%d, sessionId:%d", Integer.valueOf(clientAudioSource), Integer.valueOf(clientAudioSessionId)));
            audioDevice = audioRecordingConfiguration.getAudioDevice();
            if (audioDevice != null) {
                LogUtil.i("AudioManagerUtil", String.format("isAudioRecordOccupied() -> device info[productName:%s, type:%d]", audioDevice.getProductName(), Integer.valueOf(audioDevice.getType())));
            }
            return true;
        }
        return false;
    }

    public static boolean g() {
        if (c() == 1) {
            return true;
        }
        return false;
    }

    private static String h(int i3) {
        switch (i3) {
            case 1:
                return "built-in earphone speaker";
            case 2:
                return "built-in speaker";
            case 3:
                return "wired headset";
            case 4:
                return "wired headphones";
            case 5:
                return "line analog";
            case 6:
                return "line digital";
            case 7:
                return "Bluetooth device typically used for telephony";
            case 8:
                return "Bluetooth device supporting the A2DP profile";
            case 9:
                return "HDMI";
            case 10:
                return "HDMI audio return channel";
            case 11:
                return "USB device";
            case 12:
                return "USB accessory";
            case 13:
                return "DOCK";
            case 14:
                return "FM";
            case 15:
                return "built-in microphone";
            case 16:
                return "FM tuner";
            case 17:
                return "TV tuner";
            case 18:
                return "telephony";
            case 19:
                return "auxiliary line-level connectors";
            case 20:
                return "IP";
            case 21:
                return "BUS";
            case 22:
                return "usg headset";
            default:
                return "unknown type=" + i3;
        }
    }
}
