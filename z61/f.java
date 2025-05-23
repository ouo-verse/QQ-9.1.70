package z61;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.conditionsearch.widget.TimeSelectView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.util.Calendar;
import java.util.Date;

/* compiled from: P */
/* loaded from: classes10.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    protected int f452023a;

    /* renamed from: b, reason: collision with root package name */
    protected int f452024b;

    /* renamed from: c, reason: collision with root package name */
    protected int f452025c;

    /* renamed from: d, reason: collision with root package name */
    protected int f452026d;

    /* renamed from: e, reason: collision with root package name */
    private TimeSelectView f452027e;

    /* renamed from: f, reason: collision with root package name */
    private ActionSheet f452028f;

    /* renamed from: g, reason: collision with root package name */
    private b f452029g;

    /* renamed from: h, reason: collision with root package name */
    protected long f452030h;

    /* renamed from: i, reason: collision with root package name */
    private int f452031i;

    /* renamed from: j, reason: collision with root package name */
    c f452032j = new c();

    /* renamed from: k, reason: collision with root package name */
    protected Context f452033k;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements TimeSelectView.i {
        a() {
        }

        @Override // com.tencent.mobileqq.conditionsearch.widget.TimeSelectView.i
        public void a(View view) {
            f.this.f452028f.dismiss();
            ReportController.o(null, "dc00898", "", "", "0X800AE80", "0X800AE80", 0, 0, "", "", "", "");
        }

        @Override // com.tencent.mobileqq.conditionsearch.widget.TimeSelectView.i
        public void b() {
            if (f.this.f452029g != null) {
                f.this.f452029g.a(-1L);
            }
            f.this.f452028f.dismiss();
            ReportController.o(null, "dc00898", "", "", "0X800B411", "0X800B411", 0, 0, "", "", "", "");
        }

        @Override // com.tencent.mobileqq.conditionsearch.widget.TimeSelectView.i
        public void onConfirmBtClicked() {
            String str;
            QLog.d("UpComingMsgLogic.UpcomingTimeSelector", 4, "onConfirm: ");
            if (f.this.f452029g != null) {
                f.this.f452029g.a(f.this.f452030h);
            }
            f.this.f452028f.dismiss();
            f fVar = f.this;
            int f16 = fVar.f(fVar.f452030h);
            if (f.this.f452027e.h(0) == 0) {
                f fVar2 = f.this;
                if (fVar2.f452025c < 23) {
                    str = fVar2.i(fVar2.f452027e.h(1));
                    ReportController.o(null, "dc00898", "", "", "0X800AE7F", "0X800AE7F", f.this.f452031i, f16, "", "", str, "");
                }
            }
            str = f.this.f452027e.h(1) + f.this.f452033k.getString(R.string.f172172pq);
            ReportController.o(null, "dc00898", "", "", "0X800AE7F", "0X800AE7F", f.this.f452031i, f16, "", "", str, "");
        }

        @Override // com.tencent.mobileqq.conditionsearch.widget.TimeSelectView.i
        public void onItemSelected(int i3, int i16) {
            f.this.n(i3, i16);
            QLog.d("UpComingMsgLogic.UpcomingTimeSelector", 4, "column: " + i3 + ", row: " + i16);
            if (i3 == 0) {
                f.this.f452027e.j(1);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface b {
        void a(long j3);
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class c implements TimeSelectView.j {
        c() {
        }

        @Override // com.tencent.mobileqq.conditionsearch.widget.TimeSelectView.j
        public int getColumnCount() {
            return 2;
        }

        @Override // com.tencent.mobileqq.conditionsearch.widget.TimeSelectView.j
        public int getRowCount(int i3) {
            if (i3 != 0) {
                if (i3 != 1) {
                    return 1;
                }
                if (f.this.f452027e.h(0) == 0) {
                    f fVar = f.this;
                    if (fVar.f452025c < 23) {
                        return fVar.h();
                    }
                }
                return 24;
            }
            if (f.this.f452025c >= 23) {
                return 365;
            }
            return 366;
        }

        @Override // com.tencent.mobileqq.conditionsearch.widget.TimeSelectView.j
        public String getText(int i3, int i16) {
            int i17;
            String str;
            if (i3 != 0) {
                if (i3 != 1) {
                    return "";
                }
                if (f.this.f452027e.h(0) == 0) {
                    f fVar = f.this;
                    if (fVar.f452025c < 23) {
                        str = fVar.i(i16);
                        return "" + str;
                    }
                }
                str = i16 + f.this.f452033k.getString(R.string.f172172pq);
                return "" + str;
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setFirstDayOfWeek(1);
            if (f.this.f452025c < 23) {
                i17 = i16;
            } else {
                i17 = i16 + 1;
            }
            calendar.add(6, i17);
            String str2 = "" + f.this.g(i16, calendar);
            if (QLog.isColorLevel()) {
                QLog.d("UpComingMsgLogic.UpcomingTimeSelector", 1, str2 + " day_of_week " + calendar.get(7) + "\n" + calendar.getTime().toString());
                return str2;
            }
            return str2;
        }
    }

    public f(Context context) {
        this.f452033k = context;
        TimeSelectView timeSelectView = (TimeSelectView) LayoutInflater.from(context).inflate(R.layout.gxe, (ViewGroup) null);
        this.f452027e = timeSelectView;
        timeSelectView.i(this.f452032j);
        ActionSheet createMenuSheet = ActionSheet.createMenuSheet(context);
        this.f452028f = createMenuSheet;
        createMenuSheet.setCloseAutoRead(true);
        this.f452028f.setActionContentView(this.f452027e, null);
        this.f452027e.setPickListener(new a());
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(long j3) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, this.f452023a);
        calendar.set(6, this.f452024b);
        calendar.set(11, this.f452025c);
        calendar.set(12, this.f452026d);
        long timeInMillis = (j3 - calendar.getTimeInMillis()) / 86400000;
        calendar.setTime(new Date(j3));
        if (timeInMillis < 0) {
            return 0;
        }
        if (timeInMillis == 0) {
            return 1;
        }
        if (timeInMillis <= 7) {
            return 2;
        }
        if (calendar.get(1) == this.f452023a) {
            return 3;
        }
        return 4;
    }

    private void j(int i3, Calendar calendar) {
        int h16 = this.f452027e.h(1);
        if (i3 == 0 && this.f452025c < 23) {
            k(h16, calendar);
        } else {
            calendar.set(12, 0);
            calendar.set(11, h16);
        }
    }

    private void k(int i3, Calendar calendar) {
        if (i3 == 0) {
            calendar.add(12, 30);
        } else if (i3 <= 3) {
            calendar.add(11, i3);
        } else {
            calendar.add(11, i3);
            calendar.set(12, 0);
        }
    }

    private void l() {
        long currentTimeMillis = System.currentTimeMillis();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(currentTimeMillis));
        this.f452023a = calendar.get(1);
        this.f452024b = calendar.get(6);
        this.f452025c = calendar.get(11);
        this.f452026d = calendar.get(12);
    }

    private void m() {
        long currentTimeMillis = System.currentTimeMillis();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(currentTimeMillis));
        if (this.f452025c < 23) {
            calendar.add(12, 30);
        } else {
            calendar.add(6, 1);
            calendar.set(11, 0);
            calendar.set(12, 0);
        }
        calendar.set(13, 0);
        calendar.set(14, 0);
        this.f452030h = calendar.getTimeInMillis();
        q(0, 0);
        q(1, 0);
    }

    private void q(int i3, int i16) {
        this.f452027e.setSelection(i3, i16);
        if (i3 == 0) {
            this.f452027e.j(1);
        } else {
            this.f452027e.j(0);
        }
    }

    protected String g(int i3, Calendar calendar) {
        String str = "";
        if (calendar.get(1) != this.f452023a) {
            str = "" + calendar.get(1) + this.f452033k.getString(R.string.f242907vu);
        }
        String str2 = str + (calendar.get(2) + 1) + this.f452033k.getString(R.string.cae) + calendar.get(5) + this.f452033k.getString(R.string.aiu);
        if (this.f452025c >= 23) {
            i3++;
        }
        if (i3 == 0) {
            return this.f452033k.getString(R.string.i3f);
        }
        if (i3 == 1) {
            return str2 + " " + this.f452033k.getString(R.string.i3g);
        }
        if (i3 == 2) {
            return str2 + " " + this.f452033k.getString(R.string.f170173i4);
        }
        if (i3 <= 7) {
            return str2 + " " + z61.b.d(calendar.get(7));
        }
        return str2;
    }

    protected int h() {
        int i3 = this.f452025c;
        if (i3 >= 20) {
            return 4;
        }
        return 24 - i3;
    }

    protected String i(int i3) {
        if (i3 == 0) {
            return String.format(this.f452033k.getString(R.string.yuo), 30);
        }
        if (i3 > 0 && i3 <= 3) {
            return String.format(this.f452033k.getString(R.string.yul), Integer.valueOf(i3));
        }
        if (i3 > 3 && i3 < h()) {
            return (this.f452025c + i3) + this.f452033k.getString(R.string.f172172pq);
        }
        return "";
    }

    protected void n(int i3, int i16) {
        int i17;
        int h16;
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, this.f452023a);
        calendar.set(6, this.f452024b);
        calendar.set(11, this.f452025c);
        calendar.set(12, this.f452026d);
        if (i3 != 0) {
            if (i3 == 1) {
                if (this.f452025c < 23) {
                    h16 = this.f452027e.h(0);
                } else {
                    h16 = this.f452027e.h(0) + 1;
                }
                calendar.add(6, h16);
                if (this.f452027e.h(0) == 0 && this.f452025c < 23) {
                    k(i16, calendar);
                } else {
                    calendar.set(12, 0);
                    calendar.set(11, i16);
                }
            }
        } else {
            if (this.f452025c < 23) {
                i17 = i16;
            } else {
                i17 = i16 + 1;
            }
            calendar.add(6, i17);
            j(i16, calendar);
        }
        calendar.set(13, 0);
        calendar.set(14, 0);
        this.f452030h = calendar.getTimeInMillis();
        if (QLog.isColorLevel()) {
            QLog.d("UpComingMsgLogic.UpcomingTimeSelector", 4, "year: " + calendar.get(1) + "\nmonth: " + calendar.get(2) + "\nday: " + calendar.get(5) + "\ntimeStamp: " + this.f452030h);
        }
    }

    public void o(int i3) {
        this.f452031i = i3;
        l();
        m();
        this.f452028f.show();
    }

    public void p(b bVar) {
        this.f452029g = bVar;
    }
}
