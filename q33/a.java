package q33;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.OGEntityManager;
import com.tencent.mobileqq.persistence.SQLiteOpenHelperFacade;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.mobileqq.vas.updatesystem.db.entity.LocalFileMd5Entity;
import com.tencent.mobileqq.vas.updatesystem.db.entity.LocalUpdateEntity;
import com.tencent.mobileqq.vas.updatesystem.db.entity.ShouldUpdateEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a extends EntityManagerFactory {
    public a(String str) {
        super(str);
    }

    public static void a(String str, SQLiteDatabase sQLiteDatabase) {
        Class cls;
        Cursor rawQuery = sQLiteDatabase.rawQuery("select distinct tbl_name from Sqlite_master", null);
        ArrayList arrayList = new ArrayList();
        if (rawQuery != null) {
            while (rawQuery.moveToNext()) {
                String decode = SecurityUtile.decode(rawQuery.getString(0));
                Cursor rawQuery2 = sQLiteDatabase.rawQuery("select sql from sqlite_master where type=? and name=?", new String[]{"table", decode});
                if (rawQuery2 != null) {
                    try {
                        if (decode.equals(LocalUpdateEntity.TABLE_NAME)) {
                            cls = LocalUpdateEntity.class;
                        } else if (decode.equals(ShouldUpdateEntity.TABLE_NAME)) {
                            cls = ShouldUpdateEntity.class;
                        } else if (decode.equals(LocalFileMd5Entity.TABLE_NAME)) {
                            cls = LocalFileMd5Entity.class;
                        } else {
                            cls = Class.forName(str + "." + decode);
                        }
                        OGEntityManager.extractedStatementByReflect(arrayList, decode, rawQuery2, cls);
                    } catch (ClassNotFoundException unused) {
                    }
                    rawQuery2.close();
                }
            }
            rawQuery.close();
        }
        com.tencent.mobileqq.app.SQLiteDatabase.beginTransactionLog();
        sQLiteDatabase.beginTransaction();
        try {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                sQLiteDatabase.execSQL((String) it.next());
            }
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            sQLiteDatabase.endTransaction();
            com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
        }
    }

    @Override // com.tencent.mobileqq.persistence.EntityManagerFactory
    public SQLiteOpenHelper build(String str) {
        if (this.dbHelper == null) {
            this.mInnerDbHelper = SQLiteOpenHelperFacade.getHelper(this, "vas_update_system_database.db", 1);
            this.dbHelper = new SQLiteOpenHelper(this.mInnerDbHelper);
        }
        return this.dbHelper;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.EntityManagerFactory
    public void createDatabase(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new ShouldUpdateEntity()));
        sQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new LocalUpdateEntity()));
        sQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new LocalFileMd5Entity()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.EntityManagerFactory
    public String getPackageName() {
        return "com.tencent.mobileqq.vas.updatesystem.db";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.EntityManagerFactory
    public void upgradeDatabase(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        QLog.i("VasUpdateEntityManagerF", 1, "[DB]|upgrade. oldVer=" + i3 + ", newVer=" + i16);
        a(getPackageName(), sQLiteDatabase);
    }
}
