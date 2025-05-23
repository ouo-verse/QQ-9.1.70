package zv1;

import com.tencent.mobileqq.guild.util.as;
import com.tencent.state.data.SquareJSConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0003H\u0007\u00a8\u0006\u000b"}, d2 = {"Lzv1/e;", "", "", "", SquareJSConst.Params.PARAMS_UIN_LIST, "b", "guildId", "", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f453536a = new e();

    e() {
    }

    @JvmStatic
    public static final boolean a(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        if (!as.h(guildId, 30001) && !as.h(guildId, 30002) && !as.h(guildId, 30003) && !as.h(guildId, 30004) && !as.h(guildId, 30005) && !as.h(guildId, 30006) && !as.h(guildId, 30007)) {
            return false;
        }
        return true;
    }

    @JvmStatic
    @NotNull
    public static final String b(@NotNull List<String> uinList) {
        Intrinsics.checkNotNullParameter(uinList, "uinList");
        if (uinList.size() == 1) {
            return uinList.get(0);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("{");
        int size = uinList.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (i3 == uinList.size() - 1) {
                sb5.append("\u201c");
                sb5.append(uinList.get(i3));
                sb5.append("\u201d}");
            } else {
                sb5.append("\u201c");
                sb5.append(uinList.get(i3));
                sb5.append("\u201d, ");
            }
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
        return sb6;
    }
}
