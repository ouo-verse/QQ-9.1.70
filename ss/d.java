package ss;

import android.os.Bundle;
import cooperation.peak.PeakConstants;
import kotlin.Metadata;
import kotlin.text.StringsKt___StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\r"}, d2 = {"Lss/d;", "", "Landroid/os/Bundle;", "bundle", "", "key", "", "c", "originStr", "b", "a", "<init>", "()V", "aelight-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f434421a = new d();

    d() {
    }

    private final void c(Bundle bundle, String key) {
        if (bundle.containsKey(key)) {
            bundle.putString(key, b(bundle.getString(key, "")));
        }
    }

    @Nullable
    public final Bundle a(@Nullable Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putAll(bundle);
        c(bundle2, PeakConstants.KEY_TROOP_GROUP_NAME);
        c(bundle2, "uinname");
        return bundle2;
    }

    @NotNull
    public final String b(@Nullable String originStr) {
        char first;
        char first2;
        char last;
        if (originStr == null) {
            return "null";
        }
        if (originStr.length() > 2) {
            StringBuilder sb5 = new StringBuilder();
            first2 = StringsKt___StringsKt.first(originStr);
            sb5.append(first2);
            sb5.append('*');
            last = StringsKt___StringsKt.last(originStr);
            sb5.append(last);
            return sb5.toString();
        }
        if (originStr.length() == 2) {
            StringBuilder sb6 = new StringBuilder();
            first = StringsKt___StringsKt.first(originStr);
            sb6.append(first);
            sb6.append('*');
            return sb6.toString();
        }
        return originStr;
    }
}
