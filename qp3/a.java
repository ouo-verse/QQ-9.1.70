package qp3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.open.base.f;
import com.tencent.upload.network.session.cache.SessionDbHelper;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a extends SQLiteOpenHelper {

    /* renamed from: d, reason: collision with root package name */
    protected static String f429184d = "sys_image";

    /* renamed from: e, reason: collision with root package name */
    protected static final String[] f429185e = {"key", "maxage", "updatetime", SessionDbHelper.MODIFIED_DATE, "local"};

    /* renamed from: f, reason: collision with root package name */
    protected static final byte[] f429186f = new byte[1];

    public a(Context context) {
        super(context, "appcenterImagedb.db", (SQLiteDatabase.CursorFactory) null, 4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r13v8 */
    public d a(String str) {
        d dVar;
        SQLiteDatabase sQLiteDatabase;
        Throwable th5;
        Cursor cursor;
        synchronized (f429186f) {
            dVar = null;
            try {
                try {
                    try {
                        sQLiteDatabase = getReadableDatabase();
                        try {
                            cursor = sQLiteDatabase.query(f429184d, f429185e, "key=?", new String[]{str}, null, null, null);
                        } catch (Exception e16) {
                            e = e16;
                            cursor = null;
                        } catch (Throwable th6) {
                            th5 = th6;
                            str = 0;
                            if (str != 0) {
                                str.close();
                            }
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.close();
                            }
                            throw th5;
                        }
                    } catch (Exception e17) {
                        e = e17;
                        cursor = null;
                        sQLiteDatabase = null;
                    } catch (Throwable th7) {
                        sQLiteDatabase = null;
                        th5 = th7;
                        str = 0;
                    }
                    try {
                        if (cursor.getCount() > 0) {
                            cursor.moveToFirst();
                            dVar = c(cursor);
                        }
                        cursor.close();
                    } catch (Exception e18) {
                        e = e18;
                        e.printStackTrace();
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        }
                        return dVar;
                    }
                    sQLiteDatabase.close();
                } catch (Throwable th8) {
                    th5 = th8;
                }
            } catch (Throwable th9) {
                throw th9;
            }
        }
        return dVar;
    }

    public void b(d dVar) {
        synchronized (f429186f) {
            if (dVar == null) {
                return;
            }
            SQLiteDatabase sQLiteDatabase = null;
            try {
                try {
                    SQLiteDatabase writableDatabase = getWritableDatabase();
                    try {
                        try {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("key", dVar.f429190a);
                            contentValues.put("maxage", Long.valueOf(dVar.f429192c));
                            contentValues.put("updatetime", Long.valueOf(dVar.f429193d));
                            contentValues.put(SessionDbHelper.MODIFIED_DATE, Long.valueOf(dVar.f429194e));
                            contentValues.put("local", dVar.f429195f);
                            f.e("ImageDbHelper", ">>insert img:" + dVar.f429190a);
                            try {
                                writableDatabase.delete(f429184d, "key='" + dVar.f429190a + "'", null);
                            } catch (Exception e16) {
                                e16.printStackTrace();
                            }
                            writableDatabase.insert(f429184d, null, contentValues);
                            writableDatabase.close();
                        } catch (Throwable th5) {
                            th = th5;
                            sQLiteDatabase = writableDatabase;
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.close();
                            }
                            throw th;
                        }
                    } catch (Exception e17) {
                        e = e17;
                        sQLiteDatabase = writableDatabase;
                        f.j("ImageDbHelper", "insert image err", e);
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        }
                    }
                } catch (Exception e18) {
                    e = e18;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }
    }

    protected d c(Cursor cursor) {
        d dVar = new d();
        dVar.f429190a = cursor.getString(0);
        dVar.f429192c = cursor.getLong(1);
        dVar.f429193d = cursor.getLong(2);
        dVar.f429194e = cursor.getLong(3);
        dVar.f429195f = cursor.getString(4);
        return dVar;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE " + f429184d + " (key VARCHAR(50),local VARCHAR(50),maxage BIGINT,updatetime BIGINT," + SessionDbHelper.MODIFIED_DATE + " BIGINT,PRIMARY KEY(key))");
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        if (i3 != i16) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + f429184d + ";");
            onCreate(sQLiteDatabase);
        }
    }
}
