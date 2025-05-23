package sz4;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class b extends SQLiteOpenHelper {

    /* renamed from: d, reason: collision with root package name */
    public static b f435067d;

    public b(Context context) {
        super(context, "tracker.sqlite", (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS biz ( id INTEGER PRIMARY KEY, data BLOB, eventId TEXT, createTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP, monitorKey TEXT ) ");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS apm ( id INTEGER PRIMARY KEY, data BLOB, eventId TEXT, createTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP, monitorKey TEXT  ) ");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
    }
}
