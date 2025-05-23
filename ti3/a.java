package ti3;

import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J\u001a\u0010\n\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\bH&J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH&J\u001c\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0013"}, d2 = {"Lti3/a;", "", "", "downloadText", "launchText", "", "c", "modConfigJson", "", FavEmoConstant.ROAMING_TYPE_PANEL, "b", "progressTitle", "", "progress", "onProgress", "", "errorCode", "errorMessage", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public interface a {
    void a(int errorCode, String errorMessage);

    void b(String modConfigJson, boolean needDownload);

    void c(String downloadText, String launchText);

    void onProgress(String progressTitle, float progress);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: ti3.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static final class C11291a {
        public static /* synthetic */ void b(a aVar, int i3, String str, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    str = "";
                }
                aVar.a(i3, str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onCheckFailed");
        }

        public static /* synthetic */ void a(a aVar, String str, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z16 = false;
                }
                aVar.b(str, z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onCheckComplete");
        }
    }
}
