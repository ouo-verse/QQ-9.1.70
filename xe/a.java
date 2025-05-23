package xe;

import com.qzone.reborn.configx.g;
import common.config.service.QzoneConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0002R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\t\u00a8\u0006\r"}, d2 = {"Lxe/a;", "", "", "d", "a", "c", "b", "f", "e", "Ljava/lang/Boolean;", "mEnableFixScrollBugWhenFloatingWindowMode", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f447839a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static Boolean mEnableFixScrollBugWhenFloatingWindowMode;

    a() {
    }

    public final boolean a() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_BUGFIX_DISABLE_BLUR_CREATE_SCALED_BITMAP, 1) == 1;
    }

    public final boolean b() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_QZONE_FROM_QFS, QzoneConfig.QZONE_CONFIG_DISABLE_SHOW_INTIMATE_ALBUM_TAB, 1) == 1;
    }

    public final boolean c() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_QZONE_FROM_QFS, QzoneConfig.QZONE_CONFIG_DISABLE_UNPRAISED_ICON_CUSTOM, 1, false) == 1;
    }

    public final boolean d() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_BUGFIX_ENABLE_FACADE_SHOW_ASYNC, 1) == 1;
    }

    public final boolean e() {
        if (mEnableFixScrollBugWhenFloatingWindowMode == null) {
            mEnableFixScrollBugWhenFloatingWindowMode = Boolean.valueOf(g.f53821a.b().H());
        }
        Boolean bool = mEnableFixScrollBugWhenFloatingWindowMode;
        Intrinsics.checkNotNull(bool);
        return bool.booleanValue();
    }

    public final boolean f() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_QZONE_FROM_QFS, QzoneConfig.QZONE_CONFIG_ENABLE_HACK_ON_RESUME_EXP, 1) == 1;
    }
}
