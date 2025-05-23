package zm;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0006\u00a8\u0006\u000b"}, d2 = {"Lzm/d;", "", "", "d", "e", "c", "", "b", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f452771a = new d();

    d() {
    }

    private final boolean d() {
        boolean g16 = com.qzone.reborn.a.g(com.qzone.reborn.a.f52169a, "exp_qqvideo_publisher_united_new", false, 2, null);
        QLog.d("QZPublishQQVideoConfig", 1, "isInQQVideoPublisherUnitedNew, ret:" + g16);
        return g16;
    }

    private final boolean e() {
        boolean g16 = com.qzone.reborn.a.g(com.qzone.reborn.a.f52169a, "exp_qqvideo_publisher_united_with_memory", false, 2, null);
        QLog.d("QZPublishQQVideoConfig", 1, "isInQQVideoPublisherUnitedWithMemory, ret:" + g16);
        return g16;
    }

    public final String a() {
        String str;
        if (d()) {
            String a16 = com.qzone.reborn.a.f52169a.a("exp_qqvideo_publisher_united_new");
            str = a16 != null ? a16 : "";
            QLog.d("QZPublishQQVideoConfig", 1, "getQQVideoExpGroupId, ret:" + str);
            return str;
        }
        if (e()) {
            String a17 = com.qzone.reborn.a.f52169a.a("exp_qqvideo_publisher_united_with_memory");
            str = a17 != null ? a17 : "";
            QLog.d("QZPublishQQVideoConfig", 1, "getQQVideoExpGroupId, ret:" + str);
            return str;
        }
        QLog.d("QZPublishQQVideoConfig", 1, "getQQVideoExpGroupId, ret:");
        return "";
    }

    public final String b() {
        if (d()) {
            QLog.d("QZPublishQQVideoConfig", 1, "getQQVideoExpId, ret:1091613");
            return "1091613";
        }
        if (e()) {
            QLog.d("QZPublishQQVideoConfig", 1, "getQQVideoExpId, ret:1096866");
            return "1096866";
        }
        QLog.d("QZPublishQQVideoConfig", 1, "getQQVideoExpId, ret:");
        return "";
    }

    public final boolean c() {
        if (!gd.a.f401926a.c("KEY_CLOSE_QQ_VIDEO", false)) {
            return true;
        }
        QLog.e("QZPublishQQVideoConfig", 1, "isHitQQVideoExperiment, force close ");
        return false;
    }
}
