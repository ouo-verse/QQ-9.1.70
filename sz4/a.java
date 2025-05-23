package sz4;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class a<T> {

    /* renamed from: a, reason: collision with root package name */
    public SQLiteDatabase f435064a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f435065b;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f435066c = new AtomicBoolean(false);

    public a(Context context) {
        this.f435065b = context;
        d();
    }

    public abstract long a();

    public abstract long b(f fVar);

    public abstract boolean c(ArrayList arrayList);

    public final void d() {
        try {
            if (!e() && !this.f435066c.getAndSet(true)) {
                Context context = this.f435065b;
                if (b.f435067d == null) {
                    synchronized (b.class) {
                        if (b.f435067d == null) {
                            b.f435067d = new b(context.getApplicationContext());
                        }
                    }
                }
                SQLiteDatabase writableDatabase = b.f435067d.getWritableDatabase();
                this.f435064a = writableDatabase;
                writableDatabase.enableWriteAheadLogging();
            }
        } catch (Exception unused) {
            this.f435066c.set(false);
        }
    }

    public final boolean e() {
        SQLiteDatabase sQLiteDatabase = this.f435064a;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            return true;
        }
        return false;
    }

    public abstract ArrayList f();
}
