package xx4;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.tencent.zplan.record.model.ZPlanRecordResource;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class b implements xx4.a {

    /* renamed from: a, reason: collision with root package name */
    private final RoomDatabase f449003a;

    /* renamed from: b, reason: collision with root package name */
    private final EntityInsertionAdapter<ZPlanRecordResource> f449004b;

    /* renamed from: c, reason: collision with root package name */
    private final EntityDeletionOrUpdateAdapter<ZPlanRecordResource> f449005c;

    /* renamed from: d, reason: collision with root package name */
    private final SharedSQLiteStatement f449006d;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    class a extends EntityInsertionAdapter<ZPlanRecordResource> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, ZPlanRecordResource zPlanRecordResource) {
            if (zPlanRecordResource.getKey() == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, zPlanRecordResource.getKey());
            }
            if (zPlanRecordResource.getLocalPath() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, zPlanRecordResource.getLocalPath());
            }
            if (zPlanRecordResource.getRemoteUrl() == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, zPlanRecordResource.getRemoteUrl());
            }
            supportSQLiteStatement.bindLong(4, zPlanRecordResource.getTimestamp());
            supportSQLiteStatement.bindLong(5, zPlanRecordResource.getSource());
            supportSQLiteStatement.bindLong(6, zPlanRecordResource.getActionId());
            if (zPlanRecordResource.getDressKey() == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindString(7, zPlanRecordResource.getDressKey());
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `RecordResource` (`resourceKey`,`localPath`,`remoteUrl`,`timestamp`,`source`,`actionId`,`dressKey`) VALUES (?,?,?,?,?,?,?)";
        }
    }

    /* compiled from: P */
    /* renamed from: xx4.b$b, reason: collision with other inner class name */
    /* loaded from: classes27.dex */
    class C11576b extends EntityDeletionOrUpdateAdapter<ZPlanRecordResource> {
        C11576b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, ZPlanRecordResource zPlanRecordResource) {
            if (zPlanRecordResource.getKey() == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, zPlanRecordResource.getKey());
            }
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM `RecordResource` WHERE `resourceKey` = ?";
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    class c extends SharedSQLiteStatement {
        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM RecordResource";
        }
    }

    public b(RoomDatabase roomDatabase) {
        this.f449003a = roomDatabase;
        this.f449004b = new a(roomDatabase);
        this.f449005c = new C11576b(roomDatabase);
        this.f449006d = new c(roomDatabase);
    }

    public static List<Class<?>> c() {
        return Collections.emptyList();
    }

    @Override // xx4.a
    public void a(ZPlanRecordResource zPlanRecordResource) {
        this.f449003a.assertNotSuspendingTransaction();
        this.f449003a.beginTransaction();
        try {
            this.f449005c.handle(zPlanRecordResource);
            this.f449003a.setTransactionSuccessful();
        } finally {
            this.f449003a.endTransaction();
        }
    }

    @Override // xx4.a
    public void b(ZPlanRecordResource zPlanRecordResource) {
        this.f449003a.assertNotSuspendingTransaction();
        this.f449003a.beginTransaction();
        try {
            this.f449004b.insert((EntityInsertionAdapter<ZPlanRecordResource>) zPlanRecordResource);
            this.f449003a.setTransactionSuccessful();
        } finally {
            this.f449003a.endTransaction();
        }
    }

    @Override // xx4.a
    public void clear() {
        this.f449003a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.f449006d.acquire();
        this.f449003a.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.f449003a.setTransactionSuccessful();
        } finally {
            this.f449003a.endTransaction();
            this.f449006d.release(acquire);
        }
    }

    @Override // xx4.a
    public ZPlanRecordResource get(String str) {
        String string;
        String string2;
        String string3;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM RecordResource WHERE resourceKey LIKE ? LIMIT 1", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.f449003a.assertNotSuspendingTransaction();
        ZPlanRecordResource zPlanRecordResource = null;
        String string4 = null;
        Cursor query = DBUtil.query(this.f449003a, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "resourceKey");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "localPath");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "remoteUrl");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "timestamp");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "source");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "actionId");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "dressKey");
            if (query.moveToFirst()) {
                if (query.isNull(columnIndexOrThrow)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow);
                }
                if (query.isNull(columnIndexOrThrow2)) {
                    string2 = null;
                } else {
                    string2 = query.getString(columnIndexOrThrow2);
                }
                if (query.isNull(columnIndexOrThrow3)) {
                    string3 = null;
                } else {
                    string3 = query.getString(columnIndexOrThrow3);
                }
                long j3 = query.getLong(columnIndexOrThrow4);
                int i3 = query.getInt(columnIndexOrThrow5);
                int i16 = query.getInt(columnIndexOrThrow6);
                if (!query.isNull(columnIndexOrThrow7)) {
                    string4 = query.getString(columnIndexOrThrow7);
                }
                zPlanRecordResource = new ZPlanRecordResource(string, string2, string3, j3, i3, i16, string4);
            }
            return zPlanRecordResource;
        } finally {
            query.close();
            acquire.release();
        }
    }
}
