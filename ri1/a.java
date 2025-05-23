package ri1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;

/* compiled from: P */
/* loaded from: classes13.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final int f431477a;

    /* renamed from: b, reason: collision with root package name */
    public final String f431478b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f431479c;

    a(int i3, @NonNull String str, @Nullable Object obj) {
        this.f431477a = i3;
        this.f431478b = str;
        this.f431479c = obj;
    }

    public static a a(int i3) {
        return c(i3, String.valueOf(i3), null);
    }

    public static a b(int i3, @NonNull String str) {
        return c(i3, str, null);
    }

    public static a c(int i3, @NonNull String str, Object obj) {
        return new a(i3, str, obj);
    }

    public static a e(int i3, String str, IGProSecurityResult iGProSecurityResult) {
        if (i3 != 0) {
            return c(i3, str, iGProSecurityResult);
        }
        if (!ch.p(iGProSecurityResult)) {
            return c(-200, iGProSecurityResult.getStrPrompt(), iGProSecurityResult);
        }
        return c(i3, str, iGProSecurityResult);
    }

    public static a f() {
        return g("OK");
    }

    public static a g(@NonNull String str) {
        return c(0, str, null);
    }

    public boolean d() {
        if (this.f431477a == 0) {
            return true;
        }
        return false;
    }

    @NonNull
    public String toString() {
        return "GuildError{code=" + this.f431477a + ", message='" + this.f431478b + "', what=" + this.f431479c + '}';
    }
}
