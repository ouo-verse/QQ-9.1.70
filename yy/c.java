package yy;

import UserGrowth.stNotifyMsg;
import UserGrowth.stSchema;

/* compiled from: P */
/* loaded from: classes36.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private int f451387a;

    /* renamed from: b, reason: collision with root package name */
    private int f451388b;

    /* renamed from: c, reason: collision with root package name */
    private String f451389c = "message";

    /* renamed from: d, reason: collision with root package name */
    private C11639c f451390d;

    /* renamed from: e, reason: collision with root package name */
    private stNotifyMsg f451391e;

    /* renamed from: f, reason: collision with root package name */
    private b f451392f;

    /* renamed from: g, reason: collision with root package name */
    private a f451393g;

    /* compiled from: P */
    /* loaded from: classes36.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private int f451400a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f451401b;

        public b(int i3, boolean z16) {
            this.f451400a = i3;
            this.f451401b = z16;
        }

        public boolean a() {
            return this.f451401b;
        }
    }

    /* compiled from: P */
    /* renamed from: yy.c$c, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static class C11639c {

        /* renamed from: a, reason: collision with root package name */
        private int f451402a;

        /* renamed from: b, reason: collision with root package name */
        private String f451403b;

        /* renamed from: c, reason: collision with root package name */
        private int f451404c;

        /* renamed from: d, reason: collision with root package name */
        private stSchema f451405d;

        public C11639c(int i3, String str, int i16, stSchema stschema) {
            this.f451402a = i3;
            this.f451403b = str;
            this.f451404c = i16;
            this.f451405d = stschema;
        }

        public int a() {
            return this.f451402a;
        }

        public String b() {
            return this.f451403b;
        }

        public int c() {
            return this.f451404c;
        }

        public void d(int i3) {
            this.f451404c = i3;
        }
    }

    public c() {
    }

    public stNotifyMsg a() {
        return this.f451391e;
    }

    public a b() {
        return this.f451393g;
    }

    public b c() {
        return this.f451392f;
    }

    public C11639c d() {
        return this.f451390d;
    }

    public String e() {
        return this.f451389c;
    }

    public int f() {
        return this.f451388b;
    }

    public int g() {
        return this.f451387a;
    }

    public void h(String str) {
        this.f451389c = str;
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f451394a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f451395b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f451396c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f451397d;

        /* renamed from: e, reason: collision with root package name */
        private int f451398e;

        /* renamed from: f, reason: collision with root package name */
        private int f451399f;

        public a(int i3) {
            this.f451399f = 0;
            this.f451398e = i3;
        }

        public boolean a() {
            return this.f451397d;
        }

        public boolean b() {
            return this.f451396c;
        }

        public int c() {
            return this.f451399f;
        }

        public int d() {
            return this.f451398e;
        }

        public boolean e() {
            return this.f451394a;
        }

        public boolean f() {
            return this.f451395b;
        }

        public void g(int i3) {
            this.f451399f = i3;
        }

        public void h(int i3) {
            this.f451398e = i3;
        }

        public a(boolean z16, boolean z17, boolean z18, boolean z19) {
            this.f451398e = 0;
            this.f451399f = 0;
            this.f451394a = z16;
            this.f451395b = z17;
            this.f451396c = z18;
            this.f451397d = z19;
        }
    }

    public c(int i3, int i16, C11639c c11639c, b bVar, stNotifyMsg stnotifymsg, a aVar) {
        this.f451387a = i3;
        this.f451388b = i16;
        this.f451390d = c11639c;
        this.f451391e = stnotifymsg;
        this.f451392f = bVar;
        this.f451393g = aVar;
    }
}
