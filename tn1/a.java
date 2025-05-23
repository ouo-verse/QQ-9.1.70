package tn1;

import com.tencent.mobileqq.widget.selectorview.QPickerView;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\f\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016R\u0017\u0010\u0010\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Ltn1/a;", "Lcom/tencent/mobileqq/widget/selectorview/QPickerView$e;", "", "c", "row", "", "b", "a", "getColumnCount", "column", "getRowCount", "getText", "", "J", "getStartTime", "()J", "startTime", "Ljava/util/Calendar;", "Ljava/util/Calendar;", "mCurCalendar", "<init>", "(J)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a implements QPickerView.e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long startTime;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Calendar mCurCalendar;

    public a(long j3) {
        this.startTime = j3;
        Calendar calendar = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(calendar, "getInstance()");
        this.mCurCalendar = calendar;
    }

    private final String a(int row) {
        int i3 = this.mCurCalendar.get(1);
        int i16 = this.mCurCalendar.get(2);
        int i17 = this.mCurCalendar.get(5);
        Calendar calendar = Calendar.getInstance();
        int i18 = calendar.get(1);
        int i19 = calendar.get(2);
        int i26 = calendar.get(5);
        if (i3 == i18 && i16 == i19 && i17 == i26) {
            return "\u4eca\u5929";
        }
        return (i16 + 1) + "\u6708" + i17 + "\u65e5";
    }

    private final String b(int row) {
        if (row >= 10) {
            return String.valueOf(row);
        }
        return "0" + row;
    }

    private final int c() {
        Calendar calendar = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(calendar, "getInstance()");
        Calendar calendar2 = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(calendar2, "getInstance()");
        calendar2.add(1, 1);
        return (int) ((calendar2.getTimeInMillis() - calendar.getTimeInMillis()) / 86400000);
    }

    @Override // com.tencent.mobileqq.widget.selectorview.QPickerView.e
    public int getColumnCount() {
        return 3;
    }

    @Override // com.tencent.mobileqq.widget.selectorview.QPickerView.e
    public int getRowCount(int column) {
        if (column != 0) {
            if (column != 1) {
                if (column != 2) {
                    return 0;
                }
                return 60;
            }
            return 24;
        }
        return c();
    }

    @Override // com.tencent.mobileqq.widget.selectorview.QPickerView.e
    @NotNull
    public String getText(int column, int row) {
        if (column != 0) {
            if (column != 1) {
                if (column != 2) {
                    return "";
                }
                this.mCurCalendar.set(12, row);
                return b(row);
            }
            this.mCurCalendar.set(11, row);
            return b(row);
        }
        this.mCurCalendar.setTimeInMillis(this.startTime + (row * 86400000));
        return a(row);
    }
}
