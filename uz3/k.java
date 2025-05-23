package uz3;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.rfw.barrage.data.RFWViewBarrage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes25.dex */
public abstract class k extends f<RFWViewBarrage> {

    /* renamed from: b, reason: collision with root package name */
    private final SparseArray<List<a>> f440688b = new SparseArray<>();

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        protected final View f440689a;

        /* renamed from: b, reason: collision with root package name */
        private RectF f440690b = new RectF();

        /* renamed from: c, reason: collision with root package name */
        private Paint f440691c = new Paint();

        public a(View view) {
            if (view != null) {
                this.f440689a = view;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }

        private View d(View view, float f16, float f17) {
            RectF rectF = new RectF();
            Iterator<View> it = view.getTouchables().iterator();
            View view2 = null;
            boolean z16 = false;
            while (it.hasNext()) {
                View next = it.next();
                if (next != null) {
                    float x16 = next.getX();
                    float y16 = next.getY();
                    wz3.b.b("RFWViewBarrageRender", "[getTouchTargetView] left: ", Float.valueOf(x16), " | top: ", Float.valueOf(y16), " | touchableView: ", next);
                    rectF.set(x16, y16, next.getMeasuredWidth() + x16, next.getHeight() + y16);
                    if (!rectF.contains(f16, f17)) {
                        continue;
                    } else if (next.equals(view)) {
                        z16 = true;
                    } else if (next instanceof ViewGroup) {
                        view2 = d(view, f16 - x16, f17 - f16);
                    } else {
                        return next;
                    }
                }
            }
            if (z16 && view2 == null) {
                return view;
            }
            return view2;
        }

        public void a(Canvas canvas) {
            if (canvas == null) {
                return;
            }
            this.f440690b.set(0.0f, 0.0f, this.f440689a.getMeasuredWidth(), this.f440689a.getMeasuredHeight());
            this.f440691c.setAlpha((int) (this.f440689a.getAlpha() * 255.0f));
            int saveLayer = canvas.saveLayer(this.f440690b, this.f440691c, 31);
            this.f440689a.draw(canvas);
            canvas.restoreToCount(saveLayer);
        }

        public int b() {
            return this.f440689a.getMeasuredHeight();
        }

        public int c() {
            return this.f440689a.getMeasuredWidth();
        }

        public View e(vz3.h hVar) {
            if (hVar == null) {
                return null;
            }
            return d(this.f440689a, hVar.a(), hVar.b());
        }

        public void f(int i3, int i16, int i17, int i18) {
            this.f440689a.layout(i3, i16, i17, i18);
        }

        public void g(int i3, int i16) {
            this.f440689a.measure(i3, i16);
        }
    }

    public abstract int h(Object obj);

    @Override // uz3.f
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public wz3.a e(RFWViewBarrage rFWViewBarrage) {
        a aVar;
        if (rFWViewBarrage == null) {
            return new wz3.a(0.0f, 0.0f);
        }
        int h16 = h(rFWViewBarrage.l());
        List<a> list = this.f440688b.get(h16);
        if (list == null) {
            list = new ArrayList<>();
            this.f440688b.put(h16, list);
        }
        if (list.isEmpty()) {
            list.add(k(h16));
        }
        if (!list.isEmpty()) {
            aVar = list.remove(0);
        } else {
            aVar = null;
        }
        if (aVar == null) {
            wz3.b.a("RFWViewBarrageRender", "[measure] current view holder should not be null.");
            return new wz3.a(0.0f, 0.0f);
        }
        j(h16, aVar, rFWViewBarrage);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(rFWViewBarrage.F(), Integer.MIN_VALUE);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(rFWViewBarrage.E(), Integer.MIN_VALUE);
        aVar.g(makeMeasureSpec, makeMeasureSpec2);
        int c16 = aVar.c();
        int b16 = aVar.b();
        aVar.f(0, 0, c16, b16);
        wz3.b.i("RFWViewBarrageRender", "[measure] widthMeasureSpec: ", Integer.valueOf(makeMeasureSpec), " | heightMeasureSpec: ", Integer.valueOf(makeMeasureSpec2), " | measureWidth: ", Integer.valueOf(c16), " | measureHeight: ", Integer.valueOf(b16));
        rFWViewBarrage.L0(aVar);
        rFWViewBarrage.k0(aVar.c());
        rFWViewBarrage.j0(aVar.b());
        return new wz3.a(aVar.c(), aVar.b());
    }

    public abstract void j(int i3, a aVar, RFWViewBarrage rFWViewBarrage);

    public abstract a k(int i3);

    @Override // uz3.f
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void f(Canvas canvas, RFWViewBarrage rFWViewBarrage, tz3.i iVar, float f16, float f17) {
        a H0;
        if (rFWViewBarrage == null || canvas == null || (H0 = rFWViewBarrage.H0()) == null) {
            return;
        }
        if (!rFWViewBarrage.I0()) {
            H0.g(View.MeasureSpec.makeMeasureSpec(H0.c(), 1073741824), View.MeasureSpec.makeMeasureSpec(H0.b(), 1073741824));
            H0.f(0, 0, H0.c(), H0.b());
            rFWViewBarrage.K0(true);
        }
        canvas.save();
        canvas.translate(f16, f17);
        H0.a(canvas);
        canvas.restore();
    }

    @Override // uz3.f
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void g(RFWViewBarrage rFWViewBarrage) {
        a H0;
        if (rFWViewBarrage != null && (H0 = rFWViewBarrage.H0()) != null) {
            int h16 = h(rFWViewBarrage.l());
            List<a> list = this.f440688b.get(h16);
            if (list == null) {
                list = new ArrayList<>();
                this.f440688b.put(h16, list);
            }
            list.add(H0);
            rFWViewBarrage.L0(null);
        }
    }
}
