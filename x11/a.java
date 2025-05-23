package x11;

import android.util.Log;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J&\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\t\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\n\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\r"}, d2 = {"Lx11/a;", "Lx11/c;", "", "tag", "msg", "", "e", "", ReportConstant.COSTREPORT_TRANS, "i", "d", "<init>", "()V", "docx_local_edit_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public final class a implements c {
    @Override // x11.c
    public void d(@Nullable String tag, @Nullable String msg2) {
        if (msg2 == null) {
            msg2 = "";
        }
        Log.d(tag, msg2);
    }

    @Override // x11.c
    public void e(@Nullable String tag, @Nullable String msg2) {
        if (msg2 == null) {
            msg2 = "";
        }
        Log.e(tag, msg2);
    }

    @Override // x11.c
    public void i(@Nullable String tag, @Nullable String msg2) {
        if (msg2 == null) {
            msg2 = "";
        }
        Log.i(tag, msg2);
    }

    @Override // x11.c
    public void e(@Nullable String tag, @Nullable String msg2, @Nullable Throwable tr5) {
        if (msg2 == null) {
            msg2 = "";
        }
        Log.e(tag, msg2, tr5);
    }
}
