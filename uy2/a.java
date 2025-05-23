package uy2;

import android.view.MotionEvent;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    protected InterfaceC11376a f440604a;

    /* renamed from: b, reason: collision with root package name */
    protected c f440605b;

    /* renamed from: c, reason: collision with root package name */
    protected boolean f440606c;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f440607d;

    /* renamed from: e, reason: collision with root package name */
    protected boolean f440608e;

    /* renamed from: f, reason: collision with root package name */
    protected boolean f440609f = true;

    /* renamed from: g, reason: collision with root package name */
    protected float f440610g;

    /* renamed from: h, reason: collision with root package name */
    protected float f440611h;

    /* renamed from: i, reason: collision with root package name */
    private b f440612i;

    /* compiled from: P */
    /* renamed from: uy2.a$a, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public interface InterfaceC11376a {
        b findDraggableByPos(float f16, float f17);

        boolean onDrag(b bVar, float f16, float f17);

        void onDrop(c cVar, b bVar, float f16, float f17);

        void onMove(b bVar, float f16, float f17);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface b {
        void a(InterfaceC11376a interfaceC11376a, float f16, float f17);

        void b(InterfaceC11376a interfaceC11376a, c cVar, float f16, float f17);

        boolean c(InterfaceC11376a interfaceC11376a, float f16, float f17);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface c {
        boolean a(float f16, float f17);

        boolean b(InterfaceC11376a interfaceC11376a, b bVar, float f16, float f17);

        void c(InterfaceC11376a interfaceC11376a, b bVar, float f16, float f17);

        boolean d(InterfaceC11376a interfaceC11376a, b bVar, float f16, float f17);

        void e(InterfaceC11376a interfaceC11376a, b bVar, float f16, float f17);
    }

    public a(InterfaceC11376a interfaceC11376a, c cVar, boolean z16) {
        if (interfaceC11376a != null && cVar != null) {
            this.f440604a = interfaceC11376a;
            this.f440605b = cVar;
            return;
        }
        throw new IllegalArgumentException("DragSource and DropTarget shouldn't be null!");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0029, code lost:
    
        if (r7 != 3) goto L46;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(MotionEvent motionEvent) {
        float x16;
        float y16;
        if (this.f440606c) {
            x16 = motionEvent.getRawX();
            y16 = motionEvent.getRawY();
        } else {
            x16 = motionEvent.getX();
            y16 = motionEvent.getY();
        }
        float f16 = x16 + this.f440610g;
        float f17 = y16 + this.f440611h;
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (this.f440607d) {
                        this.f440604a.onMove(this.f440612i, f16, f17);
                        this.f440612i.a(this.f440604a, f16, f17);
                        if (this.f440609f) {
                            if (this.f440605b.a(f16, f17)) {
                                if (!this.f440608e) {
                                    this.f440608e = true;
                                    this.f440609f = this.f440605b.b(this.f440604a, this.f440612i, f16, f17);
                                }
                                this.f440605b.e(this.f440604a, this.f440612i, f16, f17);
                            } else if (this.f440608e) {
                                this.f440608e = false;
                                this.f440605b.c(this.f440604a, this.f440612i, f16, f17);
                            }
                        }
                        return true;
                    }
                }
            }
            if (this.f440607d) {
                if (this.f440605b.a(f16, f17) && this.f440605b.d(this.f440604a, this.f440612i, f16, f17)) {
                    this.f440604a.onDrop(this.f440605b, this.f440612i, f16, f17);
                    this.f440612i.b(this.f440604a, this.f440605b, f16, f17);
                } else {
                    this.f440604a.onDrop(null, this.f440612i, f16, f17);
                    this.f440612i.b(this.f440604a, null, f16, f17);
                }
                this.f440607d = false;
                this.f440608e = false;
                this.f440609f = true;
                return true;
            }
        } else {
            b findDraggableByPos = this.f440604a.findDraggableByPos(f16, f17);
            this.f440612i = findDraggableByPos;
            if (findDraggableByPos != null) {
                if (this.f440604a.onDrag(findDraggableByPos, f16, f17) && this.f440612i.c(this.f440604a, f16, f17)) {
                    this.f440607d = true;
                }
                return true;
            }
        }
        return false;
    }

    public void b(float f16, float f17) {
        this.f440610g = f16;
        this.f440611h = f17;
    }
}
