package wk;

import android.os.Bundle;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import common.config.service.QzoneConfig;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lwk/b;", "", "", "tabWnsKey", "", "b", "Landroid/os/Bundle;", "bundle", "", "a", "tabKey", "c", "", "Ljava/util/List;", "SUPPORTED_TABS", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f445744a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final List<String> SUPPORTED_TABS;

    static {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{QQWinkConstants.HOME_SHOW_CAPTURE_TAB, QQWinkConstants.HOME_SHOW_PICKER_TAB, QQWinkConstants.HOME_SHOW_TEMPLATE_TAB});
        SUPPORTED_TABS = listOf;
    }

    b() {
    }

    private final boolean b(String tabWnsKey) {
        return QzoneConfig.getInstance().getConfig("qqcircle", tabWnsKey, 1) == 1;
    }

    public final void a(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        bundle.putBoolean(QQWinkConstants.HOME_SHOW_CAPTURE_TAB, true);
        bundle.putBoolean(QQWinkConstants.HOME_SHOW_PICKER_TAB, true);
        if (bundle.getBoolean("from_qun", false)) {
            return;
        }
        bundle.putBoolean(QQWinkConstants.HOME_SHOW_TEMPLATE_TAB, b(QzoneConfig.SECONDARY_KEY_WINK_ENABLE_QZONE_TEMPLATE_TAB));
    }

    public final void c(String tabKey, Bundle bundle) {
        Intrinsics.checkNotNullParameter(tabKey, "tabKey");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Iterator<String> it = SUPPORTED_TABS.iterator();
        while (it.hasNext()) {
            bundle.putBoolean(it.next(), false);
        }
        bundle.putBoolean(tabKey, true);
    }
}
