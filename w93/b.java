package w93;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.wink.utils.ar;
import com.tencent.smtt.utils.Md5Utils;
import ga3.l;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0002J9\u0010\u000f\u001a\u00020\u0006\"\u000e\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0017"}, d2 = {"Lw93/b;", "", "", "eTagKey", "Ljava/io/File;", "pbFile", "", "a", "e", "eTag", "c", "Lcom/tencent/mobileqq/pb/MessageMicro;", "T", "eTagValue", "pbRsp", "g", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/pb/MessageMicro;)V", "f", "b", "", "d", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f445085a = new b();

    b() {
    }

    private final void a(String eTagKey, File pbFile) {
        if (pbFile != null) {
            pbFile.delete();
        }
        ar.f326685a.l(eTagKey);
        w53.b.a("WinkRequestETagUtils", "saveETag failed : remove eTagKey:" + eTagKey);
    }

    private final File c(String eTag) {
        if (TextUtils.isEmpty(eTag)) {
            return null;
        }
        return new File(u53.e.f438387d, Md5Utils.getMD5(eTag));
    }

    private final String e(String eTagKey) {
        return ar.f326685a.i(eTagKey, "");
    }

    @NotNull
    public final String b(@NotNull String eTagKey) {
        Intrinsics.checkNotNullParameter(eTagKey, "eTagKey");
        String e16 = e(eTagKey);
        File c16 = c(e16);
        boolean z16 = false;
        if (c16 != null && c16.exists()) {
            z16 = true;
        }
        if (!z16) {
            return "";
        }
        return e16;
    }

    @Nullable
    public final byte[] d(@NotNull String eTagKey) {
        Intrinsics.checkNotNullParameter(eTagKey, "eTagKey");
        File c16 = c(e(eTagKey));
        if (c16 != null && c16.exists()) {
            return l.e(c16);
        }
        return null;
    }

    public final void f(@NotNull String eTagKey) {
        Intrinsics.checkNotNullParameter(eTagKey, "eTagKey");
        String e16 = e(eTagKey);
        if (!TextUtils.isEmpty(e16)) {
            File c16 = c(e16);
            if (c16 != null) {
                c16.delete();
            }
            ar.f326685a.l(eTagKey);
        }
    }

    public final <T extends MessageMicro<T>> void g(@NotNull String eTagKey, @Nullable String eTagValue, @Nullable T pbRsp) {
        String str;
        Intrinsics.checkNotNullParameter(eTagKey, "eTagKey");
        f(eTagKey);
        if (!TextUtils.isEmpty(eTagValue) && pbRsp != null) {
            File c16 = c(eTagValue);
            if (l.j(c16, pbRsp.toByteArray())) {
                ar arVar = ar.f326685a;
                if (eTagValue == null) {
                    str = "";
                } else {
                    str = eTagValue;
                }
                arVar.r(eTagKey, str);
                w53.b.a("WinkRequestETagUtils", "saveETag success : eTagKey:" + eTagKey + ", eTagValue:" + eTagValue);
                return;
            }
            a(eTagKey, c16);
            return;
        }
        a(eTagKey, null);
    }
}
