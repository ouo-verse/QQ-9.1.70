package qg4;

import com.tencent.mobileqq.qqlive.api.config.QQLiveSDKConfigHelper;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.raft.raftframework.sla.SLAReporter;

/* compiled from: P */
/* loaded from: classes26.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static final String f428917a = QQLiveSDKConfigHelper.getQQLiveAppId();

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f428918b = {SLAReporter.PERMISSION_NET, "android.permission.ACCESS_NETWORK_STATE", "android.permission.ACCESS_WIFI_STATE"};

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f428919c = {SLAReporter.PERMISSION_NET, "android.permission.ACCESS_NETWORK_STATE", "android.permission.ACCESS_WIFI_STATE", QQPermissionConstants.Permission.RECORD_AUDIO, "android.permission.MODIFY_AUDIO_SETTINGS", "android.permission.BLUETOOTH", QQPermissionConstants.Permission.CAMERA};
}
