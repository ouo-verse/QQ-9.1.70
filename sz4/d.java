package sz4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class d extends a<f> {
    public d(Context context) {
        super(context);
    }

    @Override // sz4.a
    public final long a() {
        if (!e()) {
            return 0L;
        }
        try {
            return DatabaseUtils.queryNumEntries(this.f435064a, "biz");
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0L;
        }
    }

    @Override // sz4.a
    public final long b(f fVar) {
        if (!e()) {
            return -1L;
        }
        try {
            ContentValues contentValues = new ContentValues(4);
            contentValues.put("eventId", fVar.f435070b);
            contentValues.put("data", fVar.f435071c);
            contentValues.put(WadlProxyConsts.CREATE_TIME, Long.valueOf(System.currentTimeMillis()));
            contentValues.put("monitorKey", fVar.f435072d);
            return this.f435064a.insert("biz", null, contentValues);
        } catch (Exception e16) {
            e16.printStackTrace();
            return -1L;
        }
    }

    @Override // sz4.a
    public final boolean c(ArrayList arrayList) {
        if (!e()) {
            return false;
        }
        try {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                f fVar = (f) it.next();
                this.f435064a.delete("biz", "id = " + fVar.f435069a, null);
            }
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    @Override // sz4.a
    public final ArrayList f() {
        if (!e()) {
            return null;
        }
        try {
            Cursor query = this.f435064a.query("biz", e.f435068a, null, null, null, null, "id ASC LIMIT + 100");
            try {
                ArrayList arrayList = new ArrayList();
                while (query.moveToNext()) {
                    arrayList.add(new f(query.getLong(0), query.getString(1), query.getBlob(2), query.getString(3)));
                }
                query.close();
                return arrayList;
            } finally {
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }
}
