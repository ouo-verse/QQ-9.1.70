package qm2;

import androidx.annotation.NonNull;
import km2.f;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a implements f.c {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    final f f429066a;

    /* renamed from: b, reason: collision with root package name */
    boolean f429067b = false;

    /* renamed from: c, reason: collision with root package name */
    float f429068c;

    /* renamed from: d, reason: collision with root package name */
    float f429069d;

    /* renamed from: e, reason: collision with root package name */
    float f429070e;

    public a(@NonNull f fVar) {
        this.f429066a = fVar;
    }

    @Override // km2.f.c
    public void a(float f16, float f17, float f18) {
        this.f429068c = f16;
        this.f429069d = f17;
        this.f429070e = f18;
    }

    public float b() {
        return this.f429068c;
    }

    public float c() {
        return this.f429069d;
    }

    public synchronized void d() {
        if (!this.f429067b) {
            this.f429067b = true;
            this.f429066a.b(this);
        }
    }

    public synchronized void e() {
        if (this.f429067b) {
            this.f429067b = false;
            this.f429066a.c(this);
        }
    }
}
