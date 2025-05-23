package sl0;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a implements View.OnTouchListener {

    /* renamed from: d, reason: collision with root package name */
    private int f433942d;

    /* renamed from: e, reason: collision with root package name */
    private int f433943e;

    /* renamed from: f, reason: collision with root package name */
    private int f433944f;

    /* renamed from: h, reason: collision with root package name */
    private int f433945h;

    /* renamed from: i, reason: collision with root package name */
    private b f433946i;

    public a(b bVar) {
        this.f433946i = bVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f433946i == null) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    int rawX = (int) motionEvent.getRawX();
                    int rawY = (int) motionEvent.getRawY();
                    int i3 = rawX - this.f433944f;
                    int i16 = rawY - this.f433945h;
                    this.f433944f = rawX;
                    this.f433945h = rawY;
                    this.f433946i.f(i3, i16, view);
                }
            } else {
                int rawX2 = (int) motionEvent.getRawX();
                int rawY2 = (int) motionEvent.getRawY();
                int scaledTouchSlop = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
                if (Math.abs(rawX2 - this.f433942d) < scaledTouchSlop && Math.abs(rawY2 - this.f433943e) < scaledTouchSlop) {
                    this.f433946i.e((int) motionEvent.getX(), (int) motionEvent.getY(), view);
                } else if (rawX2 > 0) {
                    this.f433946i.d(rawX2, rawY2, view);
                }
            }
        } else {
            this.f433942d = (int) motionEvent.getRawX();
            int rawY3 = (int) motionEvent.getRawY();
            this.f433943e = rawY3;
            this.f433944f = this.f433942d;
            this.f433945h = rawY3;
        }
        return false;
    }
}
