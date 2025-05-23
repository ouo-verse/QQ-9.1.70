package s84;

import com.tencent.mobileqq.R;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.TipsElementData;
import com.tencent.sqshow.zootopia.data.config.CloudModBtnType;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R0\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\tj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004`\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Ls84/b;", "", "", "barType", "Ls84/a;", "a", "b", "I", "CLOUD_MOD_BTN_DRAWABLE", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "c", "Ljava/util/HashMap;", "buttonStyleMap", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f433495a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final int CLOUD_MOD_BTN_DRAWABLE = R.drawable.hg8;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<Integer, a> buttonStyleMap;

    static {
        HashMap<Integer, a> hashMapOf;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(1, new a(13.0f, 13.5f, 0.0f, 0.0f, R.drawable.hg8, TipsElementData.DEFAULT_COLOR, true, 10.0f, 12.5f, 5.0f)), TuplesKt.to(2, new a(12.0f, 14.0f, 0.0f, 0.0f, R.drawable.hg8, TipsElementData.DEFAULT_COLOR, true, 9.5f, 12.5f, 5.5f)), TuplesKt.to(3, new a(16.0f, 24.25f, 0.0f, 0.0f, R.drawable.hg8, TipsElementData.DEFAULT_COLOR, true, 12.5f, 16.0f, 5.5f)), TuplesKt.to(4, new a(9.0f, 12.5f, 0.0f, 0.0f, R.drawable.hg8, TipsElementData.DEFAULT_COLOR, true, 7.5f, 9.5f, 3.5f)), TuplesKt.to(5, new a(15.0f, 24.25f, 0.0f, 0.0f, R.drawable.hg8, TipsElementData.DEFAULT_COLOR, true, 11.5f, 15.0f, 4.0f)));
        buttonStyleMap = hashMapOf;
    }

    b() {
    }

    public final a a(@CloudModBtnType int barType) {
        return buttonStyleMap.get(Integer.valueOf(barType));
    }
}
