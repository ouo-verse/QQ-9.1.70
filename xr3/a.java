package xr3;

import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.luggage.wxa.q2.e;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.qmethod.pandoraex.core.o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Map<String, List<b>> f448435a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public static final ArrayList<b> f448436b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: xr3.a$a, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public class C11561a implements Comparator {
        C11561a() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            b bVar = (b) obj;
            b bVar2 = (b) obj2;
            int hashCode = Arrays.hashCode(new Object[]{bVar.f448437a, bVar.f448438b, bVar.f448439c, Integer.valueOf(bVar.f448440d)});
            int hashCode2 = Arrays.hashCode(new Object[]{bVar2.f448437a, bVar2.f448438b, bVar2.f448439c, Integer.valueOf(bVar2.f448440d)});
            if (hashCode < hashCode2) {
                return -1;
            }
            if (hashCode == hashCode2) {
                return 0;
            }
            return 1;
        }
    }

    static {
        ArrayList<b> arrayList = new ArrayList<>();
        f448436b = arrayList;
        arrayList.add(new b("com/tencent/qqlive/module/videoreport/VideoReport", "setPageSampleRate", "(Ljava/util/Map;)V", 1, "com/tencent/mobileqq/data/dt/QQDtSamplingManager", "setPageSampleRate", "(Ljava/util/Map;)V", 1, 1));
        arrayList.add(new b("com/tencent/qqlive/module/videoreport/VideoReport", "setPageSampleRate", "(Ljava/lang/String;F)V", 1, "com/tencent/mobileqq/data/dt/QQDtSamplingManager", "setPageSampleRate", "(Ljava/lang/String;F)V", 2, 2));
        arrayList.add(new b("com/tencent/qqlive/module/videoreport/VideoReport", "setElementSampleRate", "(Ljava/util/Map;)V", 1, "com/tencent/mobileqq/data/dt/QQDtSamplingManager", "setElementSampleRate", "(Ljava/util/Map;)V", 1, 1));
        arrayList.add(new b("com/tencent/qqlive/module/videoreport/VideoReport", "setElementSampleRate", "(Ljava/lang/String;F)V", 1, "com/tencent/mobileqq/data/dt/QQDtSamplingManager", "setElementSampleRate", "(Ljava/lang/String;F)V", 2, 2));
        arrayList.add(new b("org/libpag/PAGFile", "Load", "(Landroid/content/res/AssetManager;Ljava/lang/String;)Lorg/libpag/PAGFile;", 1, "com/tencent/aelight/camera/ae/util/PagViewMonitor", "Load", "(Landroid/content/res/AssetManager;Ljava/lang/String;)Lorg/libpag/PAGFile;", 2, 2));
        arrayList.add(new b("org/libpag/PAGFile", "Load", "(Ljava/lang/String;)Lorg/libpag/PAGFile;", 1, "com/tencent/aelight/camera/ae/util/PagViewMonitor", "Load", "(Ljava/lang/String;)Lorg/libpag/PAGFile;", 1, 1));
        arrayList.add(new b("org/libpag/PAGLayer", "finalize", "()V", 4, "com/tencent/aelight/camera/ae/util/PagViewMonitor", "finalize", "(Lorg/libpag/PAGLayer;)V", 0, 1));
        arrayList.add(new b("com/tencent/mobileqq/persistence/EntityManager", SQLiteDatabase.OPERATE_TYPE_EXEC_SQL, "(Ljava/lang/String;)Z", 1, "com/tencent/mobileqq/perf/block/DBMethodProxy", SQLiteDatabase.OPERATE_TYPE_EXEC_SQL, "(Lcom/tencent/mobileqq/persistence/EntityManager;Ljava/lang/String;)Z", 1, 2));
        arrayList.add(new b("com/tencent/mobileqq/persistence/EntityManager", SQLiteDatabase.OPERATE_TYPE_RAW_QUERY, "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Ljava/util/List;", 1, "com/tencent/mobileqq/perf/block/DBMethodProxy", SQLiteDatabase.OPERATE_TYPE_RAW_QUERY, "(Lcom/tencent/mobileqq/persistence/EntityManager;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Ljava/util/List;", 5, 6));
        arrayList.add(new b("com/tencent/mobileqq/persistence/EntityManager", SQLiteDatabase.OPERATE_TYPE_RAW_QUERY, "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/String;)Ljava/util/List;", 1, "com/tencent/mobileqq/perf/block/DBMethodProxy", SQLiteDatabase.OPERATE_TYPE_RAW_QUERY, "(Lcom/tencent/mobileqq/persistence/EntityManager;Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/String;)Ljava/util/List;", 3, 4));
        arrayList.add(new b("com/tencent/mobileqq/persistence/EntityManager", "find", "(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;", 1, "com/tencent/mobileqq/perf/block/DBMethodProxy", "find", "(Lcom/tencent/mobileqq/persistence/EntityManager;Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;", 2, 3));
        arrayList.add(new b("com/tencent/mobileqq/persistence/EntityManager", "find", "(Ljava/lang/Class;[Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;", 1, "com/tencent/mobileqq/perf/block/DBMethodProxy", "find", "(Lcom/tencent/mobileqq/persistence/EntityManager;Ljava/lang/Class;[Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;", 2, 3));
        arrayList.add(new b("com/tencent/mobileqq/persistence/EntityManager", "find", "(Ljava/lang/Class;J)Lcom/tencent/mobileqq/persistence/Entity;", 1, "com/tencent/mobileqq/perf/block/DBMethodProxy", "find", "(Lcom/tencent/mobileqq/persistence/EntityManager;Ljava/lang/Class;J)Lcom/tencent/mobileqq/persistence/Entity;", 2, 3));
        arrayList.add(new b("com/tencent/mobileqq/persistence/EntityManager", "find", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;", 1, "com/tencent/mobileqq/perf/block/DBMethodProxy", "find", "(Lcom/tencent/mobileqq/persistence/EntityManager;Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;", 3, 4));
        arrayList.add(new b("android/app/ActivityManager", "getProcessMemoryInfo", "([I)[Landroid/os/Debug$MemoryInfo;", 1, "com/tencent/mobileqq/perf/block/SystemMethodProxy", "getProcessMemoryInfo", "(Landroid/app/ActivityManager;[I)[Landroid/os/Debug$MemoryInfo;", 1, 2));
        arrayList.add(new b("android/app/ActivityManager", "getRunningAppProcesses", "()Ljava/util/List;", 1, "com/tencent/mobileqq/perf/block/SystemMethodProxy", "getRunningAppProcesses", "(Landroid/app/ActivityManager;)Ljava/util/List;", 0, 1));
        arrayList.add(new b("android/os/Debug", "getMemoryInfo", "(Landroid/app/ActivityManager;[I)[Landroid/os/Debug$MemoryInfo;", 1, "com/tencent/mobileqq/perf/block/SystemMethodProxy", "getMemoryInfo", "(Landroid/app/ActivityManager;[I)[Landroid/os/Debug$MemoryInfo;", 2, 2));
        arrayList.add(new b("android/os/Debug", "getPss", "()J", 1, "com/tencent/mobileqq/perf/block/SystemMethodProxy", "getPss", "()J", 0, 0));
        arrayList.add(new b("android/telephony/TelephonyManager", "getCallState", "()I", 1, "com/tencent/mobileqq/perf/block/SystemMethodProxy", "getCallState", "(Landroid/telephony/TelephonyManager;)I", 0, 1));
        arrayList.add(new b("android/media/AudioManager", "getStreamVolume", "(I)I", 1, "com/tencent/mobileqq/perf/block/SystemMethodProxy", "getStreamVolume", "(Landroid/media/AudioManager;I)I", 1, 2));
        arrayList.add(new b("android/os/BatteryManager", "getIntProperty", "(I)I", 1, "com/tencent/mobileqq/perf/block/SystemMethodProxy", "getIntProperty", "(Landroid/os/BatteryManager;I)I", 1, 2));
        arrayList.add(new b("android/os/Process", "killProcess", "(I)V", 1, "com/tencent/mobileqq/perf/block/SystemMethodProxy", "killProcess", "(I)V", 1, 1));
        arrayList.add(new b("java/lang/Object", "wait", "()V", 1, "com/tencent/mobileqq/perf/block/LockMethodProxy", "wait", "(Ljava/lang/Object;)V", 0, 1));
        arrayList.add(new b("java/lang/Thread", "sleep", "(J)V", 1, "com/tencent/mobileqq/perf/block/LockMethodProxy", "sleep", "(J)V", 1, 1));
        arrayList.add(new b("java/lang/Thread", "sleep", "(JJ)V", 1, "com/tencent/mobileqq/perf/block/LockMethodProxy", "sleep", "(JJ)V", 2, 2));
        arrayList.add(new b("com/tencent/beacon/event/UserAction", "onUserActionToTunnel", "(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/Map;ZZ)Z", 1, "com/tencent/mobileqq/perf/block/ReportMethodProxy", "onUserActionToTunnel", "(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/Map;ZZ)Z", 8, 8));
        arrayList.add(new b("com/tencent/beacon/event/UserAction", "onUserActionToTunnel", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;ZZ)Z", 1, "com/tencent/mobileqq/perf/block/ReportMethodProxy", "onUserActionToTunnel", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;ZZ)Z", 5, 5));
        arrayList.add(new b("eipc/EIPCClient", "callServer", "(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Leipc/EIPCResult;", 1, "com/tencent/mobileqq/perf/block/BinderMethodProxy", "callServer", "(Leipc/EIPCClient;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Leipc/EIPCResult;", 3, 4));
        arrayList.add(new b("android/content/ContentResolver", "delete", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", 1, "com/tencent/qqperf/monitor/file/ExternalDirFileOperationMonitor", "delete", "(Landroid/content/ContentResolver;Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", 3, 4));
        arrayList.add(new b("android/os/Build", "MODEL", "Ljava/lang/String;", 6, "com/tencent/qmethod/pandoraex/monitor/DeviceInfoMonitor", "getModel", "()Ljava/lang/String;", 0, 0));
        arrayList.add(new b("android/os/Build", "SERIAL", "Ljava/lang/String;", 6, "com/tencent/qmethod/pandoraex/monitor/DeviceInfoMonitor", "getSerialByField", "()Ljava/lang/String;", 0, 0));
        arrayList.add(new b("android/os/Build", "getSerial", "()Ljava/lang/String;", 1, "com/tencent/qmethod/pandoraex/monitor/DeviceInfoMonitor", "getSerialByMethod", "()Ljava/lang/String;", 0, 0));
        arrayList.add(new b("android/content/ClipboardManager", "clearPrimaryClip", "()V", 1, "com/tencent/qmethod/pandoraex/monitor/ClipboardMonitor", "clearPrimaryClip", "(Landroid/content/ClipboardManager;)V", 0, 1));
        arrayList.add(new b("android/content/ClipboardManager", "getPrimaryClipDescription", "()Landroid/content/ClipDescription;", 1, "com/tencent/qmethod/pandoraex/monitor/ClipboardMonitor", "getPrimaryClipDescription", "(Landroid/content/ClipboardManager;)Landroid/content/ClipDescription;", 0, 1));
        arrayList.add(new b("android/content/ClipboardManager", "getPrimaryClip", "()Landroid/content/ClipData;", 1, "com/tencent/qmethod/pandoraex/monitor/ClipboardMonitor", "getPrimaryClip", "(Landroid/content/ClipboardManager;)Landroid/content/ClipData;", 0, 1));
        arrayList.add(new b("android/content/ClipboardManager", "getText", "()Ljava/lang/CharSequence;", 1, "com/tencent/qmethod/pandoraex/monitor/ClipboardMonitor", "getText", "(Landroid/content/ClipboardManager;)Ljava/lang/CharSequence;", 0, 1));
        arrayList.add(new b("android/content/ClipboardManager", "hasPrimaryClip", "()Z", 1, "com/tencent/qmethod/pandoraex/monitor/ClipboardMonitor", "hasPrimaryClip", "(Landroid/content/ClipboardManager;)Z", 0, 1));
        arrayList.add(new b("android/content/ClipboardManager", "hasText", "()Z", 1, "com/tencent/qmethod/pandoraex/monitor/ClipboardMonitor", "hasText", "(Landroid/content/ClipboardManager;)Z", 0, 1));
        arrayList.add(new b("android/content/ClipboardManager", "setPrimaryClip", "(Landroid/content/ClipData;)V", 1, "com/tencent/qmethod/pandoraex/monitor/ClipboardMonitor", "setPrimaryClip", "(Landroid/content/ClipboardManager;Landroid/content/ClipData;)V", 1, 2));
        arrayList.add(new b("android/content/ClipboardManager", IECSearchBar.METHOD_SET_TEXT, "(Ljava/lang/CharSequence;)V", 1, "com/tencent/qmethod/pandoraex/monitor/ClipboardMonitor", IECSearchBar.METHOD_SET_TEXT, "(Landroid/content/ClipboardManager;Ljava/lang/CharSequence;)V", 1, 2));
        arrayList.add(new b("android/content/ClipboardManager", "addPrimaryClipChangedListener", "(Landroid/content/ClipboardManager$OnPrimaryClipChangedListener;)V", 1, "com/tencent/qmethod/pandoraex/monitor/ClipboardMonitor", "addPrimaryClipChangedListener", "(Landroid/content/ClipboardManager;Landroid/content/ClipboardManager$OnPrimaryClipChangedListener;)V", 1, 2));
        arrayList.add(new b("android/content/ClipboardManager", "removePrimaryClipChangedListener", "(Landroid/content/ClipboardManager$OnPrimaryClipChangedListener;)V", 1, "com/tencent/qmethod/pandoraex/monitor/ClipboardMonitor", "removePrimaryClipChangedListener", "(Landroid/content/ClipboardManager;Landroid/content/ClipboardManager$OnPrimaryClipChangedListener;)V", 1, 2));
        arrayList.add(new b("android/telephony/TelephonyManager", "getDeviceId", "()Ljava/lang/String;", 1, "com/tencent/qmethod/pandoraex/monitor/DeviceInfoMonitor", "getDeviceId", "(Landroid/telephony/TelephonyManager;)Ljava/lang/String;", 0, 1));
        arrayList.add(new b("android/telephony/TelephonyManager", "getDeviceId", "(I)Ljava/lang/String;", 1, "com/tencent/qmethod/pandoraex/monitor/DeviceInfoMonitor", "getDeviceId", "(Landroid/telephony/TelephonyManager;I)Ljava/lang/String;", 1, 2));
        arrayList.add(new b("android/telephony/TelephonyManager", "getImei", "()Ljava/lang/String;", 1, "com/tencent/qmethod/pandoraex/monitor/DeviceInfoMonitor", "getImei", "(Landroid/telephony/TelephonyManager;)Ljava/lang/String;", 0, 1));
        arrayList.add(new b("android/telephony/TelephonyManager", "getImei", "(I)Ljava/lang/String;", 1, "com/tencent/qmethod/pandoraex/monitor/DeviceInfoMonitor", "getImei", "(Landroid/telephony/TelephonyManager;I)Ljava/lang/String;", 1, 2));
        arrayList.add(new b("android/telephony/TelephonyManager", "getLine1Number", "()Ljava/lang/String;", 1, "com/tencent/qmethod/pandoraex/monitor/DeviceInfoMonitor", "getLine1Number", "(Landroid/telephony/TelephonyManager;)Ljava/lang/String;", 0, 1));
        arrayList.add(new b("android/telephony/TelephonyManager", "getSimSerialNumber", "()Ljava/lang/String;", 1, "com/tencent/qmethod/pandoraex/monitor/DeviceInfoMonitor", "getSimSerialNumber", "(Landroid/telephony/TelephonyManager;)Ljava/lang/String;", 0, 1));
        arrayList.add(new b("android/telephony/TelephonyManager", "getSubscriberId", "()Ljava/lang/String;", 1, "com/tencent/qmethod/pandoraex/monitor/DeviceInfoMonitor", "getSubscriberId", "(Landroid/telephony/TelephonyManager;)Ljava/lang/String;", 0, 1));
        arrayList.add(new b("android/telephony/TelephonyManager", "getSubscriberId", "(I)Ljava/lang/String;", 1, "com/tencent/qmethod/pandoraex/monitor/DeviceInfoMonitor", "getSubscriberId", "(Landroid/telephony/TelephonyManager;I)Ljava/lang/String;", 1, 2));
        arrayList.add(new b("android/telephony/TelephonyManager", "getSimOperator", "()Ljava/lang/String;", 1, "com/tencent/qmethod/pandoraex/monitor/DeviceInfoMonitor", "getSimOperator", "(Landroid/telephony/TelephonyManager;)Ljava/lang/String;", 0, 1));
        arrayList.add(new b("android/telephony/TelephonyManager", "getNetworkOperator", "()Ljava/lang/String;", 1, "com/tencent/qmethod/pandoraex/monitor/DeviceInfoMonitor", "getNetworkOperator", "(Landroid/telephony/TelephonyManager;)Ljava/lang/String;", 0, 1));
        arrayList.add(new b("android/telephony/TelephonyManager", "getMeid", "()Ljava/lang/String;", 1, "com/tencent/qmethod/pandoraex/monitor/DeviceInfoMonitor", "getMeid", "(Landroid/telephony/TelephonyManager;)Ljava/lang/String;", 0, 1));
        arrayList.add(new b("android/telephony/TelephonyManager", "getMeid", "(I)Ljava/lang/String;", 1, "com/tencent/qmethod/pandoraex/monitor/DeviceInfoMonitor", "getMeid", "(Landroid/telephony/TelephonyManager;I)Ljava/lang/String;", 1, 2));
        arrayList.add(new b("android/telephony/TelephonyManager", "getUiccCardsInfo", "()Ljava/util/List;", 1, "com/tencent/qmethod/pandoraex/monitor/DeviceInfoMonitor", "getUiccCardsInfo", "(Landroid/telephony/TelephonyManager;)Ljava/util/List;", 0, 1));
        arrayList.add(new b("android/telephony/TelephonyManager", "getCellLocation", "()Landroid/telephony/CellLocation;", 1, "com/tencent/qmethod/pandoraex/monitor/LocationMonitor", "getCellLocation", "(Landroid/telephony/TelephonyManager;)Landroid/telephony/CellLocation;", 0, 1));
        arrayList.add(new b("android/telephony/TelephonyManager", "getAllCellInfo", "()Ljava/util/List;", 1, "com/tencent/qmethod/pandoraex/monitor/LocationMonitor", "getAllCellInfo", "(Landroid/telephony/TelephonyManager;)Ljava/util/List;", 0, 1));
        arrayList.add(new b("android/telephony/TelephonyManager", "requestCellInfoUpdate", "(Ljava/util/concurrent/Executor;Landroid/telephony/TelephonyManager$CellInfoCallback;)V", 1, "com/tencent/qmethod/pandoraex/monitor/LocationMonitor", "requestCellInfoUpdate", "(Landroid/telephony/TelephonyManager;Ljava/util/concurrent/Executor;Landroid/telephony/TelephonyManager$CellInfoCallback;)V", 2, 3));
        arrayList.add(new b("android/telephony/TelephonyManager", "requestNetworkScan", "(Landroid/telephony/NetworkScanRequest;Ljava/util/concurrent/Executor;Landroid/telephony/TelephonyScanManager$NetworkScanCallback;)Landroid/telephony/NetworkScan;", 1, "com/tencent/qmethod/pandoraex/monitor/LocationMonitor", "requestNetworkScan", "(Landroid/telephony/TelephonyManager;Landroid/telephony/NetworkScanRequest;Ljava/util/concurrent/Executor;Landroid/telephony/TelephonyScanManager$NetworkScanCallback;)Landroid/telephony/NetworkScan;", 3, 4));
        arrayList.add(new b("android/telephony/TelephonyManager", "getServiceState", "()Landroid/telephony/ServiceState;", 1, "com/tencent/qmethod/pandoraex/monitor/LocationMonitor", "getServiceState", "(Landroid/telephony/TelephonyManager;)Landroid/telephony/ServiceState;", 0, 1));
        arrayList.add(new b("android/telephony/TelephonyManager", "listen", "(Landroid/telephony/PhoneStateListener;I)V", 1, "com/tencent/qmethod/pandoraex/monitor/LocationMonitor", "listen", "(Landroid/telephony/TelephonyManager;Landroid/telephony/PhoneStateListener;I)V", 2, 3));
        arrayList.add(new b("android/telephony/TelephonyManager", "getNetworkType", "()I", 1, "com/tencent/qmethod/pandoraex/monitor/NetworkMonitor", "getNetworkType", "(Landroid/telephony/TelephonyManager;)I", 0, 1));
        arrayList.add(new b("android/telephony/TelephonyManager", "getDataNetworkType", "()I", 1, "com/tencent/qmethod/pandoraex/monitor/NetworkMonitor", "getDataNetworkType", "(Landroid/telephony/TelephonyManager;)I", 0, 1));
        arrayList.add(new b("android/provider/Settings$Secure", "getString", "(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;", 1, "com/tencent/qmethod/pandoraex/monitor/DeviceInfoMonitor", "getString", "(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;", 2, 2));
        arrayList.add(new b("android/provider/Settings$Secure", "getLong", "(Landroid/content/ContentResolver;Ljava/lang/String;)J", 1, "com/tencent/qmethod/pandoraex/monitor/DeviceInfoMonitor", "getLong", "(Landroid/content/ContentResolver;Ljava/lang/String;)J", 2, 2));
        arrayList.add(new b("android/provider/Settings$System", "getString", "(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;", 1, "com/tencent/qmethod/pandoraex/monitor/DeviceInfoMonitor", "getStringSystem", "(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;", 2, 2));
        arrayList.add(new b("android/telephony/SubscriptionManager", "getActiveSubscriptionInfoList", "()Ljava/util/List;", 1, "com/tencent/qmethod/pandoraex/monitor/DeviceInfoMonitor", "getActiveSubscriptionInfoList", "(Landroid/telephony/SubscriptionManager;)Ljava/util/List;", 0, 1));
        arrayList.add(new b("android/telephony/SubscriptionManager", "getAccessibleSubscriptionInfoList", "()Ljava/util/List;", 1, "com/tencent/qmethod/pandoraex/monitor/DeviceInfoMonitor", "getAccessibleSubscriptionInfoList", "(Landroid/telephony/SubscriptionManager;)Ljava/util/List;", 0, 1));
        arrayList.add(new b("android/telephony/SubscriptionManager", "getCompleteActiveSubscriptionInfoList", "()Ljava/util/List;", 1, "com/tencent/qmethod/pandoraex/monitor/DeviceInfoMonitor", "getCompleteActiveSubscriptionInfoList", "(Landroid/telephony/SubscriptionManager;)Ljava/util/List;", 0, 1));
        arrayList.add(new b("android/telephony/SubscriptionManager", "getOpportunisticSubscriptions", "()Ljava/util/List;", 1, "com/tencent/qmethod/pandoraex/monitor/DeviceInfoMonitor", "getOpportunisticSubscriptions", "(Landroid/telephony/SubscriptionManager;)Ljava/util/List;", 0, 1));
        arrayList.add(new b("android/telephony/SubscriptionManager", "getActiveSubscriptionInfo", "(I)Landroid/telephony/SubscriptionInfo;", 1, "com/tencent/qmethod/pandoraex/monitor/DeviceInfoMonitor", "getActiveSubscriptionInfo", "(Landroid/telephony/SubscriptionManager;I)Landroid/telephony/SubscriptionInfo;", 1, 2));
        arrayList.add(new b("android/telephony/SubscriptionManager", "getActiveSubscriptionInfoForSimSlotIndex", "(I)Landroid/telephony/SubscriptionInfo;", 1, "com/tencent/qmethod/pandoraex/monitor/DeviceInfoMonitor", "getActiveSubscriptionInfoForSimSlotIndex", "(Landroid/telephony/SubscriptionManager;I)Landroid/telephony/SubscriptionInfo;", 1, 2));
        arrayList.add(new b("android/net/wifi/WifiManager", "getConnectionInfo", "()Landroid/net/wifi/WifiInfo;", 1, "com/tencent/qmethod/pandoraex/monitor/LocationMonitor", "getConnectionInfo", "(Landroid/net/wifi/WifiManager;)Landroid/net/wifi/WifiInfo;", 0, 1));
        arrayList.add(new b("android/net/wifi/WifiManager", "startScan", "()Z", 1, "com/tencent/qmethod/pandoraex/monitor/NetworkMonitor", "startScan", "(Landroid/net/wifi/WifiManager;)Z", 0, 1));
        arrayList.add(new b("android/net/wifi/WifiManager", "getScanResults", "()Ljava/util/List;", 1, "com/tencent/qmethod/pandoraex/monitor/NetworkMonitor", "getScanResults", "(Landroid/net/wifi/WifiManager;)Ljava/util/List;", 0, 1));
        arrayList.add(new b("android/net/wifi/WifiManager", "getConfiguredNetworks", "()Ljava/util/List;", 1, "com/tencent/qmethod/pandoraex/monitor/NetworkMonitor", "getConfigureNetworks", "(Landroid/net/wifi/WifiManager;)Ljava/util/List;", 0, 1));
        arrayList.add(new b("android/net/wifi/WifiManager", "getDhcpInfo", "()Landroid/net/DhcpInfo;", 1, "com/tencent/qmethod/pandoraex/monitor/NetworkMonitor", "getDhcpInfo", "(Landroid/net/wifi/WifiManager;)Landroid/net/DhcpInfo;", 0, 1));
        arrayList.add(new b("android/location/LocationManager", "requestLocationUpdates", "(Ljava/lang/String;JFLandroid/location/LocationListener;)V", 1, "com/tencent/qmethod/pandoraex/monitor/LocationMonitor", "requestLocationUpdates", "(Landroid/location/LocationManager;Ljava/lang/String;JFLandroid/location/LocationListener;)V", 4, 5));
        arrayList.add(new b("android/location/LocationManager", "requestLocationUpdates", "(Ljava/lang/String;JFLandroid/location/LocationListener;Landroid/os/Looper;)V", 1, "com/tencent/qmethod/pandoraex/monitor/LocationMonitor", "requestLocationUpdates", "(Landroid/location/LocationManager;Ljava/lang/String;JFLandroid/location/LocationListener;Landroid/os/Looper;)V", 5, 6));
        arrayList.add(new b("android/location/LocationManager", "requestLocationUpdates", "(JFLandroid/location/Criteria;Landroid/location/LocationListener;Landroid/os/Looper;)V", 1, "com/tencent/qmethod/pandoraex/monitor/LocationMonitor", "requestLocationUpdates", "(Landroid/location/LocationManager;JFLandroid/location/Criteria;Landroid/location/LocationListener;Landroid/os/Looper;)V", 5, 6));
        arrayList.add(new b("android/location/LocationManager", "requestLocationUpdates", "(Ljava/lang/String;JFLandroid/app/PendingIntent;)V", 1, "com/tencent/qmethod/pandoraex/monitor/LocationMonitor", "requestLocationUpdates", "(Landroid/location/LocationManager;Ljava/lang/String;JFLandroid/app/PendingIntent;)V", 4, 5));
        arrayList.add(new b("android/location/LocationManager", "requestLocationUpdates", "(JFLandroid/location/Criteria;Landroid/app/PendingIntent;)V", 1, "com/tencent/qmethod/pandoraex/monitor/LocationMonitor", "requestLocationUpdates", "(Landroid/location/LocationManager;JFLandroid/location/Criteria;Landroid/app/PendingIntent;)V", 4, 5));
        arrayList.add(new b("android/location/LocationManager", "getLastKnownLocation", "(Ljava/lang/String;)Landroid/location/Location;", 1, "com/tencent/qmethod/pandoraex/monitor/LocationMonitor", "getLastKnownLocation", "(Landroid/location/LocationManager;Ljava/lang/String;)Landroid/location/Location;", 1, 2));
        arrayList.add(new b("android/location/LocationManager", "requestSingleUpdate", "(Ljava/lang/String;Landroid/location/LocationListener;Landroid/os/Looper;)V", 1, "com/tencent/qmethod/pandoraex/monitor/LocationMonitor", "requestSingleUpdate", "(Landroid/location/LocationManager;Ljava/lang/String;Landroid/location/LocationListener;Landroid/os/Looper;)V", 3, 4));
        arrayList.add(new b("android/location/LocationManager", "requestSingleUpdate", "(Landroid/location/Criteria;Landroid/location/LocationListener;Landroid/os/Looper;)V", 1, "com/tencent/qmethod/pandoraex/monitor/LocationMonitor", "requestSingleUpdate", "(Landroid/location/LocationManager;Landroid/location/Criteria;Landroid/location/LocationListener;Landroid/os/Looper;)V", 3, 4));
        arrayList.add(new b("android/location/LocationManager", "requestSingleUpdate", "(Ljava/lang/String;Landroid/app/PendingIntent;)V", 1, "com/tencent/qmethod/pandoraex/monitor/LocationMonitor", "requestSingleUpdate", "(Landroid/location/LocationManager;Ljava/lang/String;Landroid/app/PendingIntent;)V", 2, 3));
        arrayList.add(new b("android/location/LocationManager", "requestSingleUpdate", "(Landroid/location/Criteria;Landroid/app/PendingIntent;)V", 1, "com/tencent/qmethod/pandoraex/monitor/LocationMonitor", "requestSingleUpdate", "(Landroid/location/LocationManager;Landroid/location/Criteria;Landroid/app/PendingIntent;)V", 2, 3));
        arrayList.add(new b("android/location/LocationManager", "removeUpdates", "(Landroid/app/PendingIntent;)V", 1, "com/tencent/qmethod/pandoraex/monitor/LocationMonitor", "removeUpdates", "(Landroid/location/LocationManager;Landroid/app/PendingIntent;)V", 1, 2));
        arrayList.add(new b("android/location/LocationManager", "removeUpdates", "(Landroid/location/LocationListener;)V", 1, "com/tencent/qmethod/pandoraex/monitor/LocationMonitor", "removeUpdates", "(Landroid/location/LocationManager;Landroid/location/LocationListener;)V", 1, 2));
        arrayList.add(new b("android/location/LocationManager", "addGpsStatusListener", "(Landroid/location/GpsStatus$Listener;)Z", 1, "com/tencent/qmethod/pandoraex/monitor/LocationMonitor", "addGpsStatusListener", "(Landroid/location/LocationManager;Landroid/location/GpsStatus$Listener;)Z", 1, 2));
        arrayList.add(new b("android/bluetooth/BluetoothAdapter", "startDiscovery", "()Z", 1, "com/tencent/qmethod/pandoraex/monitor/LocationMonitor", "startDiscovery", "(Landroid/bluetooth/BluetoothAdapter;)Z", 0, 1));
        arrayList.add(new b("android/bluetooth/BluetoothAdapter", "startLeScan", "(Landroid/bluetooth/BluetoothAdapter$LeScanCallback;)Z", 1, "com/tencent/qmethod/pandoraex/monitor/LocationMonitor", "startLeScan", "(Landroid/bluetooth/BluetoothAdapter;Landroid/bluetooth/BluetoothAdapter$LeScanCallback;)Z", 1, 2));
        arrayList.add(new b("android/bluetooth/BluetoothAdapter", "startLeScan", "([Ljava/util/UUID;Landroid/bluetooth/BluetoothAdapter$LeScanCallback;)Z", 1, "com/tencent/qmethod/pandoraex/monitor/LocationMonitor", "startLeScan", "(Landroid/bluetooth/BluetoothAdapter;[Ljava/util/UUID;Landroid/bluetooth/BluetoothAdapter$LeScanCallback;)Z", 2, 3));
        arrayList.add(new b("android/bluetooth/BluetoothAdapter", "getAddress", "()Ljava/lang/String;", 1, "com/tencent/qmethod/pandoraex/monitor/NetworkMonitor", "getAddress", "(Landroid/bluetooth/BluetoothAdapter;)Ljava/lang/String;", 0, 1));
        arrayList.add(new b("android/bluetooth/le/BluetoothLeScanner", "startScan", "(Landroid/bluetooth/le/ScanCallback;)V", 1, "com/tencent/qmethod/pandoraex/monitor/LocationMonitor", "startScan", "(Landroid/bluetooth/le/BluetoothLeScanner;Landroid/bluetooth/le/ScanCallback;)V", 1, 2));
        arrayList.add(new b("android/bluetooth/le/BluetoothLeScanner", "startScan", "(Ljava/util/List;Landroid/bluetooth/le/ScanSettings;Landroid/bluetooth/le/ScanCallback;)V", 1, "com/tencent/qmethod/pandoraex/monitor/LocationMonitor", "startScan", "(Landroid/bluetooth/le/BluetoothLeScanner;Ljava/util/List;Landroid/bluetooth/le/ScanSettings;Landroid/bluetooth/le/ScanCallback;)V", 3, 4));
        arrayList.add(new b("android/bluetooth/le/BluetoothLeScanner", "startScan", "(Ljava/util/List;Landroid/bluetooth/le/ScanSettings;Landroid/app/PendingIntent;)I", 1, "com/tencent/qmethod/pandoraex/monitor/LocationMonitor", "startScan", "(Landroid/bluetooth/le/BluetoothLeScanner;Ljava/util/List;Landroid/bluetooth/le/ScanSettings;Landroid/app/PendingIntent;)I", 3, 4));
        arrayList.add(new b("android/telephony/gsm/GsmCellLocation", "getCid", "()I", 1, "com/tencent/qmethod/pandoraex/monitor/LocationMonitor", "getCid", "(Landroid/telephony/gsm/GsmCellLocation;)I", 0, 1));
        arrayList.add(new b("android/telephony/cdma/CdmaCellLocation", "getBaseStationId", "()I", 1, "com/tencent/qmethod/pandoraex/monitor/LocationMonitor", "getBaseStationId", "(Landroid/telephony/cdma/CdmaCellLocation;)I", 0, 1));
        arrayList.add(new b("android/telephony/CellIdentityCdma", "getBasestationId", "()I", 1, "com/tencent/qmethod/pandoraex/monitor/LocationMonitor", "getBaseStationId", "(Landroid/telephony/CellIdentityCdma;)I", 0, 1));
        arrayList.add(new b("android/telephony/CellIdentityGsm", "getCid", "()I", 1, "com/tencent/qmethod/pandoraex/monitor/LocationMonitor", "getCid", "(Landroid/telephony/CellIdentityGsm;)I", 0, 1));
        arrayList.add(new b("android/telephony/CellIdentityLte", "getCi", "()I", 1, "com/tencent/qmethod/pandoraex/monitor/LocationMonitor", "getCellCid", "(Landroid/telephony/CellIdentityLte;)I", 0, 1));
        arrayList.add(new b("android/telephony/CellIdentityWcdma", "getCid", "()I", 1, "com/tencent/qmethod/pandoraex/monitor/LocationMonitor", "getCellCid", "(Landroid/telephony/CellIdentityWcdma;)I", 0, 1));
        arrayList.add(new b("android/telephony/CellIdentityTdscdma", "getCid", "()I", 1, "com/tencent/qmethod/pandoraex/monitor/LocationMonitor", "getCellCid", "(Landroid/telephony/CellIdentityTdscdma;)I", 0, 1));
        arrayList.add(new b("android/location/LocationProvider", "requiresNetwork", "()Z", 1, "com/tencent/qmethod/pandoraex/monitor/LocationMonitor", "requiresNetwork", "(Landroid/location/LocationProvider;)Z", 0, 1));
        arrayList.add(new b("android/location/LocationProvider", "requiresSatellite", "()Z", 1, "com/tencent/qmethod/pandoraex/monitor/LocationMonitor", "requiresSatellite", "(Landroid/location/LocationProvider;)Z", 0, 1));
        arrayList.add(new b("android/location/LocationProvider", "requiresCell", "()Z", 1, "com/tencent/qmethod/pandoraex/monitor/LocationMonitor", "requiresCell", "(Landroid/location/LocationProvider;)Z", 0, 1));
        arrayList.add(new b("android/location/Location", "getAccuracy", "()F", 1, "com/tencent/qmethod/pandoraex/monitor/LocationMonitor", "getAccuracy", "(Landroid/location/Location;)F", 0, 1));
        arrayList.add(new b("android/net/wifi/WifiInfo", "getMacAddress", "()Ljava/lang/String;", 1, "com/tencent/qmethod/pandoraex/monitor/NetworkMonitor", "getMacAddress", "(Landroid/net/wifi/WifiInfo;)Ljava/lang/String;", 0, 1));
        arrayList.add(new b("android/net/wifi/WifiInfo", "getSSID", "()Ljava/lang/String;", 1, "com/tencent/qmethod/pandoraex/monitor/NetworkMonitor", "getSSID", "(Landroid/net/wifi/WifiInfo;)Ljava/lang/String;", 0, 1));
        arrayList.add(new b("android/net/wifi/WifiInfo", "getBSSID", "()Ljava/lang/String;", 1, "com/tencent/qmethod/pandoraex/monitor/NetworkMonitor", "getBSSID", "(Landroid/net/wifi/WifiInfo;)Ljava/lang/String;", 0, 1));
        arrayList.add(new b("android/net/wifi/WifiInfo", "getIpAddress", "()I", 1, "com/tencent/qmethod/pandoraex/monitor/NetworkMonitor", "getIpAddress", "(Landroid/net/wifi/WifiInfo;)I", 0, 1));
        arrayList.add(new b("android/net/wifi/WifiInfo", "toString", "()Ljava/lang/String;", 1, "com/tencent/qmethod/pandoraex/monitor/NetworkMonitor", "wifiToStr", "(Landroid/net/wifi/WifiInfo;)Ljava/lang/String;", 0, 1));
        arrayList.add(new b("java/net/NetworkInterface", "getNetworkInterfaces", "()Ljava/util/Enumeration;", 1, "com/tencent/qmethod/pandoraex/monitor/NetworkMonitor", "getNetworkInterfaces", "()Ljava/util/Enumeration;", 0, 0));
        arrayList.add(new b("java/net/NetworkInterface", "getHardwareAddress", "()[B", 1, "com/tencent/qmethod/pandoraex/monitor/NetworkMonitor", "getHardwareAddress", "(Ljava/net/NetworkInterface;)[B", 0, 1));
        arrayList.add(new b("java/net/NetworkInterface", "getInetAddresses", "()Ljava/util/Enumeration;", 1, "com/tencent/qmethod/pandoraex/monitor/NetworkMonitor", "getInetAddresses", "(Ljava/net/NetworkInterface;)Ljava/util/Enumeration;", 0, 1));
        arrayList.add(new b("java/net/NetworkInterface", "getInterfaceAddresses", "()Ljava/util/List;", 1, "com/tencent/qmethod/pandoraex/monitor/NetworkMonitor", "getInterfaceAddresses", "(Ljava/net/NetworkInterface;)Ljava/util/List;", 0, 1));
        arrayList.add(new b("android/net/NetworkInfo", "getExtraInfo", "()Ljava/lang/String;", 1, "com/tencent/qmethod/pandoraex/monitor/NetworkMonitor", "netGetExInfo", "(Landroid/net/NetworkInfo;)Ljava/lang/String;", 0, 1));
        arrayList.add(new b("android/net/NetworkInfo", "getType", "()I", 1, "com/tencent/qmethod/pandoraex/monitor/NetworkMonitor", "getType", "(Landroid/net/NetworkInfo;)I", 0, 1));
        arrayList.add(new b("android/net/NetworkInfo", "getSubtype", "()I", 1, "com/tencent/qmethod/pandoraex/monitor/NetworkMonitor", "getSubtype", "(Landroid/net/NetworkInfo;)I", 0, 1));
        arrayList.add(new b("android/net/NetworkInfo", "getTypeName", "()Ljava/lang/String;", 1, "com/tencent/qmethod/pandoraex/monitor/NetworkMonitor", "getTypeName", "(Landroid/net/NetworkInfo;)Ljava/lang/String;", 0, 1));
        arrayList.add(new b("android/net/NetworkCapabilities", "hasTransport", "(I)Z", 1, "com/tencent/qmethod/pandoraex/monitor/NetworkMonitor", "hasTransport", "(Landroid/net/NetworkCapabilities;I)Z", 1, 2));
        arrayList.add(new b("android/app/Activity", "requestPermissions", "([Ljava/lang/String;I)V", 1, "com/tencent/qmethod/pandoraex/monitor/PermissionMonitor", "requestPermissions", "(Landroid/app/Activity;[Ljava/lang/String;I)V", 2, 3));
        arrayList.add(new b("android/content/ContentResolver", "query", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", 1, "com/tencent/qmethod/pandoraex/monitor/ContactsMonitor", "query", "(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", 5, 6));
        arrayList.add(new b("android/content/ContentResolver", "query", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/database/Cursor;", 1, "com/tencent/qmethod/pandoraex/monitor/ContactsMonitor", "query", "(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/database/Cursor;", 6, 7));
        arrayList.add(new b("android/content/ContentResolver", "query", "(Landroid/net/Uri;[Ljava/lang/String;Landroid/os/Bundle;Landroid/os/CancellationSignal;)Landroid/database/Cursor;", 1, "com/tencent/qmethod/pandoraex/monitor/ContactsMonitor", "query", "(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Landroid/os/Bundle;Landroid/os/CancellationSignal;)Landroid/database/Cursor;", 4, 5));
        arrayList.add(new b("android/content/pm/PackageManager", "getInstalledPackages", "(I)Ljava/util/List;", 1, "com/tencent/qmethod/pandoraex/monitor/InstalledAppListMonitor", "getInstalledPackages", "(Landroid/content/pm/PackageManager;I)Ljava/util/List;", 1, 2));
        arrayList.add(new b("android/content/pm/PackageManager", "getInstalledApplications", "(I)Ljava/util/List;", 1, "com/tencent/qmethod/pandoraex/monitor/InstalledAppListMonitor", "getInstalledApplications", "(Landroid/content/pm/PackageManager;I)Ljava/util/List;", 1, 2));
        arrayList.add(new b("android/content/pm/PackageManager", "queryIntentActivities", "(Landroid/content/Intent;I)Ljava/util/List;", 1, "com/tencent/qmethod/pandoraex/monitor/InstalledAppListMonitor", "queryIntentActivities", "(Landroid/content/pm/PackageManager;Landroid/content/Intent;I)Ljava/util/List;", 2, 3));
        arrayList.add(new b("android/content/pm/PackageManager", "queryIntentServices", "(Landroid/content/Intent;I)Ljava/util/List;", 1, "com/tencent/qmethod/pandoraex/monitor/InstalledAppListMonitor", "queryIntentServices", "(Landroid/content/pm/PackageManager;Landroid/content/Intent;I)Ljava/util/List;", 2, 3));
        arrayList.add(new b("android/content/pm/PackageManager", "getLaunchIntentForPackage", "(Ljava/lang/String;)Landroid/content/Intent;", 1, "com/tencent/qmethod/pandoraex/monitor/InstalledAppListMonitor", "getLaunchIntentForPackage", "(Landroid/content/pm/PackageManager;Ljava/lang/String;)Landroid/content/Intent;", 1, 2));
        arrayList.add(new b("android/content/pm/PackageManager", "getPackageInfo", "(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;", 1, "com/tencent/qmethod/pandoraex/monitor/InstalledAppListMonitor", "getPackageInfo", "(Landroid/content/pm/PackageManager;Ljava/lang/String;I)Landroid/content/pm/PackageInfo;", 2, 3));
        arrayList.add(new b("android/content/pm/PackageManager", "getPackageInfo", "(Landroid/content/pm/VersionedPackage;I)Landroid/content/pm/PackageInfo;", 1, "com/tencent/qmethod/pandoraex/monitor/InstalledAppListMonitor", "getPackageInfo", "(Landroid/content/pm/PackageManager;Landroid/content/pm/VersionedPackage;I)Landroid/content/pm/PackageInfo;", 2, 3));
        arrayList.add(new b("android/hardware/camera2/CameraManager", "openCamera", "(Ljava/lang/String;Landroid/hardware/camera2/CameraDevice$StateCallback;Landroid/os/Handler;)V", 1, "com/tencent/qmethod/pandoraex/monitor/CameraMonitor", "openCamera", "(Landroid/hardware/camera2/CameraManager;Ljava/lang/String;Landroid/hardware/camera2/CameraDevice$StateCallback;Landroid/os/Handler;)V", 3, 4));
        arrayList.add(new b("android/hardware/camera2/CameraManager", "openCamera", "(Ljava/lang/String;Ljava/util/concurrent/Executor;Landroid/hardware/camera2/CameraDevice$StateCallback;)V", 1, "com/tencent/qmethod/pandoraex/monitor/CameraMonitor", "openCamera", "(Landroid/hardware/camera2/CameraManager;Ljava/lang/String;Ljava/util/concurrent/Executor;Landroid/hardware/camera2/CameraDevice$StateCallback;)V", 3, 4));
        arrayList.add(new b("android/hardware/Camera", "open", "()Landroid/hardware/Camera;", 1, "com/tencent/qmethod/pandoraex/monitor/CameraMonitor", "open", "()Landroid/hardware/Camera;", 0, 0));
        arrayList.add(new b("android/hardware/Camera", "open", "(I)Landroid/hardware/Camera;", 1, "com/tencent/qmethod/pandoraex/monitor/CameraMonitor", "open", "(I)Landroid/hardware/Camera;", 1, 1));
        arrayList.add(new b("android/hardware/Camera", "takePicture", "(Landroid/hardware/Camera$ShutterCallback;Landroid/hardware/Camera$PictureCallback;Landroid/hardware/Camera$PictureCallback;)V", 1, "com/tencent/qmethod/pandoraex/monitor/CameraMonitor", "takePicture", "(Landroid/hardware/Camera;Landroid/hardware/Camera$ShutterCallback;Landroid/hardware/Camera$PictureCallback;Landroid/hardware/Camera$PictureCallback;)V", 3, 4));
        arrayList.add(new b("android/hardware/Camera", "takePicture", "(Landroid/hardware/Camera$ShutterCallback;Landroid/hardware/Camera$PictureCallback;Landroid/hardware/Camera$PictureCallback;Landroid/hardware/Camera$PictureCallback;)V", 1, "com/tencent/qmethod/pandoraex/monitor/CameraMonitor", "takePicture", "(Landroid/hardware/Camera;Landroid/hardware/Camera$ShutterCallback;Landroid/hardware/Camera$PictureCallback;Landroid/hardware/Camera$PictureCallback;Landroid/hardware/Camera$PictureCallback;)V", 4, 5));
        arrayList.add(new b("android/media/MediaRecorder", "setVideoSource", "(I)V", 1, "com/tencent/qmethod/pandoraex/monitor/CameraMonitor", "setVideoSource", "(Landroid/media/MediaRecorder;I)V", 1, 2));
        arrayList.add(new b("android/media/MediaRecorder", "start", "()V", 1, "com/tencent/qmethod/pandoraex/monitor/AudioMonitor", "start", "(Landroid/media/MediaRecorder;)V", 0, 1));
        arrayList.add(new b("android/media/MediaRecorder", "setAudioSource", "(I)V", 1, "com/tencent/qmethod/pandoraex/monitor/AudioMonitor", "setAudioSource", "(Landroid/media/MediaRecorder;I)V", 1, 2));
        arrayList.add(new b("android/hardware/camera2/CameraDevice", "createCaptureRequest", "(I)Landroid/hardware/camera2/CaptureRequest$Builder;", 1, "com/tencent/qmethod/pandoraex/monitor/CameraMonitor", "createCaptureRequest", "(Landroid/hardware/camera2/CameraDevice;I)Landroid/hardware/camera2/CaptureRequest$Builder;", 1, 2));
        arrayList.add(new b("android/hardware/camera2/CameraDevice", "createCaptureRequest", "(ILjava/util/Set;)Landroid/hardware/camera2/CaptureRequest$Builder;", 1, "com/tencent/qmethod/pandoraex/monitor/CameraMonitor", "createCaptureRequest", "(Landroid/hardware/camera2/CameraDevice;ILjava/util/Set;)Landroid/hardware/camera2/CaptureRequest$Builder;", 2, 3));
        arrayList.add(new b("android/hardware/camera2/CameraCaptureSession", "setRepeatingRequest", "(Landroid/hardware/camera2/CaptureRequest;Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;Landroid/os/Handler;)I", 1, "com/tencent/qmethod/pandoraex/monitor/CameraMonitor", "setRepeatingRequest", "(Landroid/hardware/camera2/CameraCaptureSession;Landroid/hardware/camera2/CaptureRequest;Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;Landroid/os/Handler;)I", 3, 4));
        arrayList.add(new b("android/media/AudioRecord", "startRecording", "()V", 1, "com/tencent/qmethod/pandoraex/monitor/AudioMonitor", "startRecording", "(Landroid/media/AudioRecord;)V", 0, 1));
        arrayList.add(new b("android/media/AudioRecord", "startRecording", "(Landroid/media/MediaSyncEvent;)V", 1, "com/tencent/qmethod/pandoraex/monitor/AudioMonitor", "startRecording", "(Landroid/media/AudioRecord;Landroid/media/MediaSyncEvent;)V", 1, 2));
        arrayList.add(new b("android/telephony/SmsManager", "sendTextMessage", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/app/PendingIntent;Landroid/app/PendingIntent;)V", 1, "com/tencent/qmethod/pandoraex/monitor/SmsMonitor", "sendTextMessage", "(Landroid/telephony/SmsManager;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/app/PendingIntent;Landroid/app/PendingIntent;)V", 5, 6));
        arrayList.add(new b("android/telephony/SmsManager", "sendTextMessage", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/app/PendingIntent;Landroid/app/PendingIntent;J)V", 1, "com/tencent/qmethod/pandoraex/monitor/SmsMonitor", "sendTextMessage", "(Landroid/telephony/SmsManager;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/app/PendingIntent;Landroid/app/PendingIntent;J)V", 6, 7));
        arrayList.add(new b("android/hardware/SensorManager", "getSensors", "()I", 1, "com/tencent/qmethod/pandoraex/monitor/SensorMonitor", "getSensors", "(Landroid/hardware/SensorManager;)I", 0, 1));
        arrayList.add(new b("android/hardware/SensorManager", "getSensorList", "(I)Ljava/util/List;", 1, "com/tencent/qmethod/pandoraex/monitor/SensorMonitor", "getSensorList", "(Landroid/hardware/SensorManager;I)Ljava/util/List;", 1, 2));
        arrayList.add(new b("android/hardware/SensorManager", "getDynamicSensorList", "(I)Ljava/util/List;", 1, "com/tencent/qmethod/pandoraex/monitor/SensorMonitor", "getDynamicSensorList", "(Landroid/hardware/SensorManager;I)Ljava/util/List;", 1, 2));
        arrayList.add(new b("android/hardware/SensorManager", "getDefaultSensor", "(I)Landroid/hardware/Sensor;", 1, "com/tencent/qmethod/pandoraex/monitor/SensorMonitor", "getDefaultSensor", "(Landroid/hardware/SensorManager;I)Landroid/hardware/Sensor;", 1, 2));
        arrayList.add(new b("android/hardware/SensorManager", "getDefaultSensor", "(IZ)Landroid/hardware/Sensor;", 1, "com/tencent/qmethod/pandoraex/monitor/SensorMonitor", "getDefaultSensor", "(Landroid/hardware/SensorManager;IZ)Landroid/hardware/Sensor;", 2, 3));
        arrayList.add(new b("android/hardware/SensorManager", "registerListener", "(Landroid/hardware/SensorListener;I)Z", 1, "com/tencent/qmethod/pandoraex/monitor/SensorMonitor", "registerListener", "(Landroid/hardware/SensorManager;Landroid/hardware/SensorListener;I)Z", 2, 3));
        arrayList.add(new b("android/hardware/SensorManager", "registerListener", "(Landroid/hardware/SensorListener;II)Z", 1, "com/tencent/qmethod/pandoraex/monitor/SensorMonitor", "registerListener", "(Landroid/hardware/SensorManager;Landroid/hardware/SensorListener;II)Z", 3, 4));
        arrayList.add(new b("android/hardware/SensorManager", "registerListener", "(Landroid/hardware/SensorEventListener;Landroid/hardware/Sensor;I)Z", 1, "com/tencent/qmethod/pandoraex/monitor/SensorMonitor", "registerListener", "(Landroid/hardware/SensorManager;Landroid/hardware/SensorEventListener;Landroid/hardware/Sensor;I)Z", 3, 4));
        arrayList.add(new b("android/hardware/SensorManager", "registerListener", "(Landroid/hardware/SensorEventListener;Landroid/hardware/Sensor;II)Z", 1, "com/tencent/qmethod/pandoraex/monitor/SensorMonitor", "registerListener", "(Landroid/hardware/SensorManager;Landroid/hardware/SensorEventListener;Landroid/hardware/Sensor;II)Z", 4, 5));
        arrayList.add(new b("android/hardware/SensorManager", "registerListener", "(Landroid/hardware/SensorEventListener;Landroid/hardware/Sensor;ILandroid/os/Handler;)Z", 1, "com/tencent/qmethod/pandoraex/monitor/SensorMonitor", "registerListener", "(Landroid/hardware/SensorManager;Landroid/hardware/SensorEventListener;Landroid/hardware/Sensor;ILandroid/os/Handler;)Z", 4, 5));
        arrayList.add(new b("android/hardware/SensorManager", "registerListener", "(Landroid/hardware/SensorEventListener;Landroid/hardware/Sensor;IILandroid/os/Handler;)Z", 1, "com/tencent/qmethod/pandoraex/monitor/SensorMonitor", "registerListener", "(Landroid/hardware/SensorManager;Landroid/hardware/SensorEventListener;Landroid/hardware/Sensor;IILandroid/os/Handler;)Z", 5, 6));
        arrayList.add(new b("android/hardware/SensorManager", "requestTriggerSensor", "(Landroid/hardware/TriggerEventListener;Landroid/hardware/Sensor;)Z", 1, "com/tencent/qmethod/pandoraex/monitor/SensorMonitor", "requestTriggerSensor", "(Landroid/hardware/SensorManager;Landroid/hardware/TriggerEventListener;Landroid/hardware/Sensor;)Z", 2, 3));
        arrayList.add(new b("android/hardware/SensorManager", "registerDynamicSensorCallback", "(Landroid/hardware/SensorManager$DynamicSensorCallback;)V", 1, "com/tencent/qmethod/pandoraex/monitor/SensorMonitor", "registerDynamicSensorCallback", "(Landroid/hardware/SensorManager;Landroid/hardware/SensorManager$DynamicSensorCallback;)V", 1, 2));
        arrayList.add(new b("android/hardware/SensorManager", "registerDynamicSensorCallback", "(Landroid/hardware/SensorManager$DynamicSensorCallback;Landroid/os/Handler;)V", 1, "com/tencent/qmethod/pandoraex/monitor/SensorMonitor", "registerDynamicSensorCallback", "(Landroid/hardware/SensorManager;Landroid/hardware/SensorManager$DynamicSensorCallback;Landroid/os/Handler;)V", 2, 3));
        arrayList.add(new b("android/os/Parcel", "writeInterfaceToken", "(Ljava/lang/String;)V", 1, "com/tencent/qmethod/pandoraex/monitor/OaidMonitor", "writeParcelToken", "(Landroid/os/Parcel;Ljava/lang/String;)V", 1, 2));
        arrayList.add(new b("android/os/Parcel", "recycle", "()V", 1, "com/tencent/qmethod/pandoraex/monitor/OaidMonitor", "parcelRecycle", "(Landroid/os/Parcel;)V", 0, 1));
        arrayList.add(new b("android/os/IBinder", "transact", "(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z", 1, "com/tencent/qmethod/pandoraex/monitor/OaidMonitor", "binderTransact", "(Landroid/os/IBinder;ILandroid/os/Parcel;Landroid/os/Parcel;I)Z", 4, 5));
        arrayList.add(new b("java/lang/Runtime", "exec", "(Ljava/lang/String;[Ljava/lang/String;Ljava/io/File;)Ljava/lang/Process;", 1, "com/tencent/qmethod/pandoraex/monitor/RuntimeMonitor", "exec", "(Ljava/lang/Runtime;Ljava/lang/String;[Ljava/lang/String;Ljava/io/File;)Ljava/lang/Process;", 3, 4));
        arrayList.add(new b("java/lang/Runtime", "exec", "([Ljava/lang/String;[Ljava/lang/String;Ljava/io/File;)Ljava/lang/Process;", 1, "com/tencent/qmethod/pandoraex/monitor/RuntimeMonitor", "exec", "(Ljava/lang/Runtime;[Ljava/lang/String;[Ljava/lang/String;Ljava/io/File;)Ljava/lang/Process;", 3, 4));
        arrayList.add(new b("java/lang/Runtime", "exec", "(Ljava/lang/String;)Ljava/lang/Process;", 1, "com/tencent/qmethod/pandoraex/monitor/RuntimeMonitor", "exec", "(Ljava/lang/Runtime;Ljava/lang/String;)Ljava/lang/Process;", 1, 2));
        arrayList.add(new b("java/lang/Runtime", "exec", "([Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/Process;", 1, "com/tencent/qmethod/pandoraex/monitor/RuntimeMonitor", "exec", "(Ljava/lang/Runtime;[Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/Process;", 2, 3));
        arrayList.add(new b("java/lang/Runtime", "exec", "([Ljava/lang/String;)Ljava/lang/Process;", 1, "com/tencent/qmethod/pandoraex/monitor/RuntimeMonitor", "exec", "(Ljava/lang/Runtime;[Ljava/lang/String;)Ljava/lang/Process;", 1, 2));
        arrayList.add(new b("com/android/id/impl/IdProviderImpl", e.NAME, "(Landroid/content/Context;)Ljava/lang/String;", 1, "com/tencent/qmethod/pandoraex/monitor/OaidMonitor", "getMIOaid", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 1, 2));
        a();
    }

    public static void a() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[Before removeDuplication] size: ");
        ArrayList<b> arrayList = f448436b;
        sb5.append(arrayList.size());
        o.a("ReflectContainer", sb5.toString());
        b(arrayList);
        o.a("ReflectContainer", "[parseConfigs] size: " + arrayList.size());
        Iterator<b> it = arrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.f448440d != 6) {
                o.a("ReflectContainer", "[parseConfigs] strategy: " + next);
                String e16 = c.e(next.f448437a);
                next.f448437a = e16;
                next.f448441e = c.e(next.f448441e);
                List<b> arrayList2 = new ArrayList<>();
                Map<String, List<b>> map = f448435a;
                if (map.containsKey(e16)) {
                    arrayList2 = map.get(e16);
                }
                arrayList2.add(next);
                map.put(e16, arrayList2);
            }
        }
    }

    private static void b(List<b> list) {
        TreeSet treeSet = new TreeSet(new C11561a());
        treeSet.addAll(list);
        list.clear();
        list.addAll(treeSet);
    }
}
