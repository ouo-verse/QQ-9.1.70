package qp2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\n\u0010\u0001\u001a\u00020\u0000*\u00020\u0000\u001a\n\u0010\u0003\u001a\u00020\u0000*\u00020\u0002\u00a8\u0006\u0004"}, d2 = {"", "b", "", "a", "qqsearch-api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class f {
    public static final int a(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            return new JSONObject(str).optInt("total_count", -1);
        } catch (Exception unused) {
            return -1;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x0010. Please report as an issue. */
    public static final int b(int i3) {
        if (i3 != 1 && i3 != 2 && i3 != 6 && i3 != 7 && i3 != 16) {
            switch (i3) {
                default:
                    switch (i3) {
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                            break;
                        default:
                            switch (i3) {
                                case 39:
                                case 40:
                                    return 6003;
                                case 41:
                                case 42:
                                    return 6007;
                                default:
                                    return -1;
                            }
                    }
                case 19:
                case 20:
                case 21:
                    return 6002;
            }
        }
        return 6002;
    }
}
