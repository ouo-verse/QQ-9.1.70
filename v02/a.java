package v02;

import android.content.Context;
import android.util.Pair;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ$\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u0014\u0010\u000b\u001a\u00020\u00078\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lv02/a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/emoticonview/IPicEmoticonInfo;", "emoticonInfo", "Landroid/util/Pair;", "", "a", "b", "I", "sDensity", "<init>", "()V", "qqguild-df-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f440715a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final int sDensity = 320;

    a() {
    }

    @NotNull
    public final Pair<Integer, Integer> a(@NotNull Context context, @Nullable IPicEmoticonInfo emoticonInfo) {
        int emoWidth;
        Intrinsics.checkNotNullParameter(context, "context");
        int i3 = context.getResources().getDisplayMetrics().densityDpi;
        if (emoticonInfo == null) {
            return new Pair<>(0, 0);
        }
        int i16 = 200;
        if (emoticonInfo.emoWidth() == 0) {
            emoWidth = 200;
        } else {
            emoWidth = emoticonInfo.emoWidth();
        }
        if (emoticonInfo.emoHeight() != 0) {
            i16 = emoticonInfo.emoHeight();
        }
        if (emoticonInfo.emoExtWidth() != 0 && emoticonInfo.emoExtHeight() != 0) {
            emoWidth = emoticonInfo.emoExtWidth();
            i16 = emoticonInfo.emoExtHeight();
        }
        if (emoWidth != i16) {
            emoWidth = i16;
        }
        int i17 = sDensity;
        return new Pair<>(Integer.valueOf(((emoWidth * i3) + (i17 >> 1)) / i17), Integer.valueOf(((i16 * i3) + (i17 >> 1)) / i17));
    }
}
