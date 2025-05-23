package ua1;

import android.graphics.Color;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;
import ua1.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0016\u0010\u000b\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR&\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lua1/b;", "Lcom/tencent/freesia/IConfigData;", "", "toString", "", "d", "Z", "showEntry", "", "e", "I", "bannerInterval", "Ljava/util/ArrayList;", "Ltr2/c;", "Lkotlin/collections/ArrayList;", "f", "Ljava/util/ArrayList;", "mEntryItems", "<init>", "()V", h.F, "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class b implements IConfigData {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public boolean showEntry = true;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public int bannerInterval = 10;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public ArrayList<tr2.c> mEntryItems = new ArrayList<>(4);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lua1/b$a;", "", "", "content", "Lua1/b;", "b", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ua1.b$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int c(tr2.c cVar, tr2.c cVar2) {
            return cVar.f437178b - cVar2.f437178b;
        }

        @JvmStatic
        @NotNull
        public final b b(@NotNull String content) {
            Intrinsics.checkNotNullParameter(content, "content");
            try {
                b bVar = new b();
                JSONObject jSONObject = new JSONObject(content);
                bVar.showEntry = jSONObject.optBoolean("showEntrance", false);
                bVar.bannerInterval = jSONObject.optInt("bannerInterval", 10);
                JSONArray optJSONArray = jSONObject.optJSONArray(HippyControllerProps.ARRAY);
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        Object obj = optJSONArray.get(i3);
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
                        JSONObject jSONObject2 = (JSONObject) obj;
                        tr2.c cVar = new tr2.c();
                        cVar.f437177a = jSONObject2.optInt("id");
                        cVar.f437178b = jSONObject2.optInt("order");
                        cVar.f437179c = jSONObject2.optString("title");
                        cVar.f437180d = jSONObject2.optString(QQWinkConstants.TAB_SUBTITLE);
                        cVar.f437181e = Color.parseColor(jSONObject2.optString("bgColor"));
                        cVar.f437182f = jSONObject2.optString("imageUrl");
                        bVar.mEntryItems.add(cVar);
                    }
                }
                Collections.sort(bVar.mEntryItems, new Comparator() { // from class: ua1.a
                    @Override // java.util.Comparator
                    public final int compare(Object obj2, Object obj3) {
                        int c16;
                        c16 = b.Companion.c((tr2.c) obj2, (tr2.c) obj3);
                        return c16;
                    }
                });
                QLog.d("TogetherEntryConfigData", 2, "confBean = " + bVar);
                return bVar;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("TogetherEntryConfigData", 1, "parse e:", e16.toString());
                }
                return new b();
            }
        }

        Companion() {
        }
    }

    @NotNull
    public String toString() {
        StringBuilder sb5 = new StringBuilder(50);
        sb5.append("showEntry=");
        sb5.append(this.showEntry);
        sb5.append(",bannerInterval=");
        sb5.append(this.bannerInterval);
        sb5.append(",mEntryItems.size=");
        sb5.append(this.mEntryItems.size());
        Iterator<tr2.c> it = this.mEntryItems.iterator();
        while (it.hasNext()) {
            tr2.c next = it.next();
            sb5.append(",entry_title=");
            sb5.append(next.f437179c);
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
        return sb6;
    }
}
