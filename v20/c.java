package v20;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.tencent.ad.tangram.analysis.sqlite.AdAnalysisSQLiteColumns;
import com.tencent.biz.qqcircle.comment.recpic.QFSRecPicInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: P */
/* loaded from: classes4.dex */
public final class c implements v20.b {

    /* renamed from: a, reason: collision with root package name */
    private final RoomDatabase f440796a;

    /* renamed from: b, reason: collision with root package name */
    private final EntityInsertionAdapter<QFSRecPicInfo> f440797b;

    /* renamed from: c, reason: collision with root package name */
    private final v20.a f440798c = new v20.a();

    /* renamed from: d, reason: collision with root package name */
    private final v20.d f440799d = new v20.d();

    /* renamed from: e, reason: collision with root package name */
    private final SharedSQLiteStatement f440800e;

    /* renamed from: f, reason: collision with root package name */
    private final SharedSQLiteStatement f440801f;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a extends EntityInsertionAdapter<QFSRecPicInfo> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, QFSRecPicInfo qFSRecPicInfo) {
            if (qFSRecPicInfo.getPath() == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, qFSRecPicInfo.getPath());
            }
            if (qFSRecPicInfo.getPhotoId() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, qFSRecPicInfo.getPhotoId());
            }
            supportSQLiteStatement.bindLong(3, qFSRecPicInfo.getStrategy());
            supportSQLiteStatement.bindLong(4, qFSRecPicInfo.getMediaWidth());
            supportSQLiteStatement.bindLong(5, qFSRecPicInfo.getMediaHeight());
            String a16 = c.this.f440798c.a(qFSRecPicInfo.g());
            if (a16 == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, a16);
            }
            String a17 = c.this.f440799d.a(qFSRecPicInfo.i());
            if (a17 == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindString(7, a17);
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `rec_pic_info_table` (`path`,`photoId`,`strategy`,`mediaWidth`,`mediaHeight`,`similarityList`,`typeList`) VALUES (?,?,?,?,?,?,?)";
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class b extends SharedSQLiteStatement {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM rec_pic_info_table";
        }
    }

    /* compiled from: P */
    /* renamed from: v20.c$c, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    class C11388c extends SharedSQLiteStatement {
        C11388c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM rec_pic_info_table WHERE path = ?";
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class d implements Callable<List<QFSRecPicInfo>> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RoomSQLiteQuery f440805d;

        d(RoomSQLiteQuery roomSQLiteQuery) {
            this.f440805d = roomSQLiteQuery;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<QFSRecPicInfo> call() throws Exception {
            String string;
            String string2;
            String string3;
            String string4;
            Cursor query = DBUtil.query(c.this.f440796a, this.f440805d, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "path");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "photoId");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY);
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "mediaWidth");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "mediaHeight");
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "similarityList");
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "typeList");
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    QFSRecPicInfo qFSRecPicInfo = new QFSRecPicInfo();
                    if (query.isNull(columnIndexOrThrow)) {
                        string = null;
                    } else {
                        string = query.getString(columnIndexOrThrow);
                    }
                    qFSRecPicInfo.n(string);
                    if (query.isNull(columnIndexOrThrow2)) {
                        string2 = null;
                    } else {
                        string2 = query.getString(columnIndexOrThrow2);
                    }
                    qFSRecPicInfo.o(string2);
                    qFSRecPicInfo.q(query.getInt(columnIndexOrThrow3));
                    qFSRecPicInfo.m(query.getInt(columnIndexOrThrow4));
                    qFSRecPicInfo.l(query.getInt(columnIndexOrThrow5));
                    if (query.isNull(columnIndexOrThrow6)) {
                        string3 = null;
                    } else {
                        string3 = query.getString(columnIndexOrThrow6);
                    }
                    qFSRecPicInfo.p(c.this.f440798c.b(string3));
                    if (query.isNull(columnIndexOrThrow7)) {
                        string4 = null;
                    } else {
                        string4 = query.getString(columnIndexOrThrow7);
                    }
                    qFSRecPicInfo.r(c.this.f440799d.b(string4));
                    arrayList.add(qFSRecPicInfo);
                }
                return arrayList;
            } finally {
                query.close();
            }
        }

        protected void finalize() {
            this.f440805d.release();
        }
    }

    public c(RoomDatabase roomDatabase) {
        this.f440796a = roomDatabase;
        this.f440797b = new a(roomDatabase);
        this.f440800e = new b(roomDatabase);
        this.f440801f = new C11388c(roomDatabase);
    }

    public static List<Class<?>> e() {
        return Collections.emptyList();
    }

    @Override // v20.b
    public void a(QFSRecPicInfo qFSRecPicInfo) {
        this.f440796a.assertNotSuspendingTransaction();
        this.f440796a.beginTransaction();
        try {
            this.f440797b.insert((EntityInsertionAdapter<QFSRecPicInfo>) qFSRecPicInfo);
            this.f440796a.setTransactionSuccessful();
        } finally {
            this.f440796a.endTransaction();
        }
    }

    @Override // v20.b
    public void delete(String str) {
        this.f440796a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.f440801f.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.f440796a.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.f440796a.setTransactionSuccessful();
        } finally {
            this.f440796a.endTransaction();
            this.f440801f.release(acquire);
        }
    }

    @Override // v20.b
    public void deleteAll() {
        this.f440796a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.f440800e.acquire();
        this.f440796a.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.f440796a.setTransactionSuccessful();
        } finally {
            this.f440796a.endTransaction();
            this.f440800e.release(acquire);
        }
    }

    @Override // v20.b
    public LiveData<List<QFSRecPicInfo>> getAllData() {
        return this.f440796a.getInvalidationTracker().createLiveData(new String[]{"rec_pic_info_table"}, false, new d(RoomSQLiteQuery.acquire("SELECT * FROM rec_pic_info_table", 0)));
    }
}
