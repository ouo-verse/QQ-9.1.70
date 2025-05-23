package ur2;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.utils.QQCustomDialog;
import java.util.Map;
import javax.annotation.Nullable;
import tr2.f;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface a {
    void a(Context context, int i3, int i16, int i17, @Nullable Map<String, f> map, @Nullable Bundle bundle);

    QQCustomDialog b();

    void c(f fVar, int i3, String str, long j3, long j16, Object obj);

    void d(Context context, String str, int i3, int i16, Bundle bundle);

    boolean e(Context context, String str, int i3, int i16, @Nullable Map<String, f> map, @Nullable Bundle bundle);

    boolean f(Context context, String str, int i3, int i16, @Nullable Map<String, f> map, @Nullable Bundle bundle);

    boolean g(Context context, String str, int i3, int i16, boolean z16, Map<String, f> map, @Nullable Bundle bundle);

    String getBusinessName();

    void onDestroy();
}
