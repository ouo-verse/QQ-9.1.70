package qa3;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\b"}, d2 = {"Lqa3/a;", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "", "a", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f428766a = new a();

    a() {
    }

    @NotNull
    public final String a(@Nullable MetaMaterial material) {
        int i3;
        if (material != null) {
            i3 = material.usageCnt;
        } else {
            i3 = 0;
        }
        if (i3 >= 10000) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(Locale.getDefault(), "%.1f\u4e07\u4eba\u4f7f\u7528", Arrays.copyOf(new Object[]{Float.valueOf(i3 / 10000.0f)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
            return format;
        }
        if (i3 >= 100) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format(Locale.getDefault(), "%d\u4eba\u4f7f\u7528", Arrays.copyOf(new Object[]{Integer.valueOf(i3)}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(locale, format, *args)");
            return format2;
        }
        return "\u8fd1\u671f\u4e0a\u67b6";
    }
}
