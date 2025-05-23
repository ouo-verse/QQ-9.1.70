package tn1;

import android.content.Context;
import com.tencent.mobileqq.widget.selectorview.QActionSheet;
import com.tencent.mobileqq.widget.selectorview.QPickerView;
import com.tencent.mobileqq.widget.selectorview.i;
import com.tencent.util.QQToastUtil;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0001\u0012B^\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012%\b\u0002\u0010$\u001a\u001f\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001c\u0012\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010%\u00a2\u0006\u0004\b3\u00104J\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0007R\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR4\u0010$\u001a\u001f\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001c8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001f\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010%8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010&\u001a\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010+R\u0016\u0010/\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010.R\u0014\u00102\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u00101\u00a8\u00065"}, d2 = {"Ltn1/c;", "", "", "selectTimeMs", "beginTimeMs", "g", "selectTime", "", h.F, "i", "Lmqq/util/WeakReference;", "Landroid/content/Context;", "a", "Lmqq/util/WeakReference;", "getContext", "()Lmqq/util/WeakReference;", "context", "", "b", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "c", "J", "getStartTime", "()J", "startTime", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "selectedTime", "d", "Lkotlin/jvm/functions/Function1;", "e", "()Lkotlin/jvm/functions/Function1;", "callback", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "f", "()Lkotlin/jvm/functions/Function0;", "dismissEndCallback", "Lcom/tencent/mobileqq/widget/selectorview/i;", "Lcom/tencent/mobileqq/widget/selectorview/i;", "mTimePicker", "Ltn1/a;", "Ltn1/a;", "mTimeAdapter", "Ljava/util/Calendar;", "Ljava/util/Calendar;", "mCurCalendar", "<init>", "(Lmqq/util/WeakReference;Ljava/lang/String;JLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<Context> context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String title;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final long startTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Function1<Long, Unit> callback;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Function0<Unit> dismissEndCallback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private i mTimePicker;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private tn1.a mTimeAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Calendar mCurCalendar;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0004\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Ltn1/c$b;", "", "", "a", "MILLISECONDS_OF_DAY", "J", "", "TIME_PATTERN", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: tn1.c$b, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            Calendar calendar = Calendar.getInstance();
            calendar.add(11, 1);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            return calendar.getTimeInMillis();
        }

        Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(@NotNull WeakReference<Context> context, @NotNull String title, long j3, @Nullable Function1<? super Long, Unit> function1, @Nullable Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(title, "title");
        this.context = context;
        this.title = title;
        this.startTime = j3;
        this.callback = function1;
        this.dismissEndCallback = function0;
        this.mTimeAdapter = new tn1.a(j3);
        Calendar calendar = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(calendar, "getInstance()");
        this.mCurCalendar = calendar;
        i iVar = new i(context, title, this.mTimeAdapter, new QPickerView.f() { // from class: tn1.b
            @Override // com.tencent.mobileqq.widget.selectorview.QPickerView.f
            public final void onItemSelected(int i3, int i16) {
                c.b(c.this, i3, i16);
            }
        });
        this.mTimePicker = iVar;
        iVar.i(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(c this$0, int i3, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    this$0.mCurCalendar.set(12, i16);
                    return;
                }
                return;
            }
            this$0.mCurCalendar.set(11, i16);
            return;
        }
        this$0.mCurCalendar.setTimeInMillis(this$0.startTime + (i16 * 86400000));
    }

    private final long g(long selectTimeMs, long beginTimeMs) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(selectTimeMs);
        calendar.set(13, 0);
        calendar.set(12, 0);
        calendar.set(11, 0);
        calendar.set(14, 0);
        long timeInMillis = calendar.getTimeInMillis();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(beginTimeMs);
        calendar2.set(13, 0);
        calendar2.set(12, 0);
        calendar2.set(11, 0);
        calendar2.set(14, 0);
        return timeInMillis - calendar2.getTimeInMillis();
    }

    @Nullable
    public final Function1<Long, Unit> e() {
        return this.callback;
    }

    @Nullable
    public final Function0<Unit> f() {
        return this.dismissEndCallback;
    }

    public final void h(long selectTime) {
        this.mCurCalendar.setTimeInMillis(selectTime);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(selectTime);
        int i3 = calendar.get(11);
        int i16 = calendar.get(12);
        this.mTimePicker.o((int) (g(selectTime, this.startTime) / 86400000), i3, i16);
    }

    public final void i() {
        this.mTimePicker.m();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"tn1/c$a", "Lcom/tencent/mobileqq/widget/selectorview/QActionSheet$f;", "", "onDismiss", "t", "onConfirm", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements QActionSheet.f {
        a() {
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void onConfirm() {
            if (c.this.mCurCalendar.getTimeInMillis() <= System.currentTimeMillis()) {
                QQToastUtil.showQQToast(-1, "\u8bbe\u7f6e\u65f6\u95f4\u5df2\u8fc7\u671f");
                return;
            }
            Function1<Long, Unit> e16 = c.this.e();
            if (e16 != null) {
                e16.invoke(Long.valueOf(c.this.mCurCalendar.getTimeInMillis()));
            }
            c.this.mTimePicker.c();
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void t() {
            Function0<Unit> f16 = c.this.f();
            if (f16 != null) {
                f16.invoke();
            }
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void onDismiss() {
        }
    }
}
