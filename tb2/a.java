package tb2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/* compiled from: P */
/* loaded from: classes9.dex */
public class a implements RecyclerView.OnItemTouchListener {

    /* renamed from: a, reason: collision with root package name */
    private GestureDetector f435793a;

    /* renamed from: b, reason: collision with root package name */
    private View f435794b;

    /* renamed from: c, reason: collision with root package name */
    private RecyclerView f435795c;

    /* compiled from: P */
    /* renamed from: tb2.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    class C11281a extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f435796d;

        C11281a(b bVar) {
            this.f435796d = bVar;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            b bVar;
            if (a.this.f435794b != null && (bVar = this.f435796d) != null) {
                bVar.a(a.this.f435794b, a.this.f435795c.getChildPosition(a.this.f435794b));
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            b bVar;
            if (a.this.f435794b != null && (bVar = this.f435796d) != null) {
                bVar.onItemClick(a.this.f435794b, a.this.f435795c.getChildPosition(a.this.f435794b));
                return true;
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface b {
        void a(View view, int i3);

        void onItemClick(View view, int i3);
    }

    public a(Context context, b bVar) {
        this.f435793a = new GestureDetector(context, new C11281a(bVar));
    }

    @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        this.f435793a.onTouchEvent(motionEvent);
        this.f435794b = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
        this.f435795c = recyclerView;
        return false;
    }

    @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
    public void onRequestDisallowInterceptTouchEvent(boolean z16) {
    }

    @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
    }
}
