package vm2;

import androidx.annotation.IntRange;
import com.tencent.mobileqq.statistics.ReportController;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0002J\u0010\u0010\n\u001a\u00020\u00022\b\b\u0001\u0010\t\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004\u00a8\u0006\u000e"}, d2 = {"Lvm2/c;", "", "", "d", "", "toggle", "b", "e", "", "action", "c", "a", "<init>", "()V", "qq-richmediabrowser-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f441865a = new c();

    c() {
    }

    public final void a(boolean action) {
        String str;
        if (action) {
            str = "0X800C205";
        } else {
            str = "0X800C206";
        }
        String str2 = str;
        ReportController.o(null, "dc00898", "", "", str2, str2, 0, 0, "", "", "", "");
    }

    public final void b(boolean toggle) {
        ReportController.o(null, "dc00898", "", "", "0X800C202", "0X800C202", toggle ? 1 : 0, 0, "", "", "", "");
    }

    public final void c(@IntRange(from = 0, to = 1) int action) {
        ReportController.o(null, "dc00898", "", "", "0X800C204", "0X800C204", action, 0, "", "", "", "");
    }

    public final void d() {
        ReportController.o(null, "dc00898", "", "", "0X800C201", "0X800C201", 0, 0, "", "", "", "");
    }

    public final void e() {
        ReportController.o(null, "dc00898", "", "", "0X800C203", "0X800C203", 0, 0, "", "", "", "");
    }
}
