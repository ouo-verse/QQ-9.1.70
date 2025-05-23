package sp3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.open.base.MD5Utils;
import java.util.HashMap;
import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a extends SQLiteOpenHelper {
    protected static HashMap<Long, a> C = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    protected String f434124d;

    /* renamed from: e, reason: collision with root package name */
    protected HashSet<Integer> f434125e;

    /* renamed from: f, reason: collision with root package name */
    protected Context f434126f;

    /* renamed from: h, reason: collision with root package name */
    protected volatile boolean f434127h;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f434128i;

    /* renamed from: m, reason: collision with root package name */
    protected int f434129m;

    protected a(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i3) {
        super(context, str, cursorFactory, i3);
        this.f434125e = new HashSet<>();
        this.f434126f = null;
        this.f434127h = false;
        this.f434128i = true;
        this.f434129m = 0;
        this.f434124d = str;
        this.f434126f = context;
    }

    public static synchronized a e(Context context, long j3) {
        a aVar;
        synchronized (a.class) {
            aVar = C.get(Long.valueOf(j3));
            if (aVar == null) {
                a aVar2 = new a(context, MD5Utils.encodeHexStr(String.valueOf(j3) + "_opensdk"), null, 74);
                C.put(Long.valueOf(j3), aVar2);
                aVar = aVar2;
            }
        }
        return aVar;
    }

    public void a(int i3) {
        synchronized (this) {
            if (this.f434125e.add(Integer.valueOf(i3))) {
                this.f434129m++;
            }
        }
    }

    public void d() {
        this.f434126f.deleteDatabase(this.f434124d);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase sQLiteDatabase;
        synchronized (this) {
            try {
                try {
                    sQLiteDatabase = super.getWritableDatabase();
                } catch (Throwable unused) {
                    d();
                    try {
                        sQLiteDatabase = super.getWritableDatabase();
                    } catch (Throwable unused2) {
                        sQLiteDatabase = null;
                    }
                    if (this.f434127h) {
                    }
                }
                if (this.f434127h) {
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    d();
                    try {
                        sQLiteDatabase = super.getWritableDatabase();
                    } catch (Throwable unused3) {
                    }
                    this.f434127h = false;
                }
            } catch (Throwable th5) {
                if (this.f434127h) {
                    d();
                    try {
                        super.getWritableDatabase();
                    } catch (Throwable unused4) {
                    }
                    this.f434127h = false;
                }
                throw th5;
            }
        }
        return sQLiteDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        this.f434127h = true;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        this.f434127h = true;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }
}
