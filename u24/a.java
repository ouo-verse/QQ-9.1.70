package u24;

import com.tencent.mobileqq.aio.utils.b;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lu24/a;", "", "", "panelId", "", "a", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f438155a = new a();

    a() {
    }

    public final void a(int panelId) {
        HashMap hashMap = new HashMap();
        hashMap.put("is_red_tips", "0");
        hashMap.put("operation_entry", b.f194119a.f(panelId));
        b.l("em_bas_input_box_shortcut_bar", hashMap);
    }
}
