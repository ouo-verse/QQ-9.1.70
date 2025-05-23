package us3;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.api.ProcessConstant;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\b\u00a8\u0006\f"}, d2 = {"Lus3/j;", "", "", "procName", "", "a", "b", "", "[Ljava/lang/String;", "PROC_PLUGIN_ARRAY", "<init>", "()V", "minibox-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final j f439989a = new j();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String[] PROC_PLUGIN_ARRAY = {ProcessConstant.MINI_BOX_P00, ProcessConstant.MINI_BOX_P01, ProcessConstant.MINI_BOX_P02, ProcessConstant.MINI_BOX_P03, ProcessConstant.MINI_BOX_P04, ProcessConstant.MINI_BOX_P05};

    j() {
    }

    @JvmStatic
    public static final boolean a(@Nullable String procName) {
        boolean z16;
        String str;
        boolean endsWith$default;
        if (procName != null && procName.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        String[] strArr = PROC_PLUGIN_ARRAY;
        int length = strArr.length;
        int i3 = 0;
        while (true) {
            str = null;
            if (i3 >= length) {
                break;
            }
            String str2 = strArr[i3];
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(procName, str2, false, 2, null);
            if (endsWith$default) {
                str = str2;
                break;
            }
            i3++;
        }
        if (str != null) {
            return true;
        }
        return false;
    }

    @JvmStatic
    public static final boolean b(@Nullable String procName) {
        boolean z16;
        boolean endsWith$default;
        if (procName != null && procName.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        endsWith$default = StringsKt__StringsJVMKt.endsWith$default(procName, ProcessConstant.MINI_BOX_CORE, false, 2, null);
        if (endsWith$default) {
            return true;
        }
        return a(procName);
    }
}
