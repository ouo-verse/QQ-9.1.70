package v4;

import NS_MOBILE_FEEDS.cell_pic;
import NS_MOBILE_FEEDS.s_picdata;
import NS_MOBILE_FEEDS.s_picurl;
import NS_MOBILE_QUN.Album;
import android.content.ContentValues;
import android.database.Cursor;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.util.e;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends com.qzone.component.cache.database.a {
    public static final String ALBUMDESC = "albumdesc";
    public static final String ALBUMID = "albumid";
    public static final String ALBUMNAME = "albumname";
    public static final String ALBUMNUM = "albumnum";
    public static final String ALBUMRIGHTS = "albumrights";
    public static final String ATTACHINFO = "attachinfo";
    public static final String CREATETIME = "createtime";
    public static final IDBCacheDataWrapper.a<a> DB_CREATOR = new C11391a();
    public static final String LASTUPLOADTIME = "lastuploadtime";
    public static final String LLOC = "lloc";
    public static final String MODIFYTIME = "modifytime";
    public static final String OWNERUIN = "ownerUin";
    public static final String QUNID = "qunid";
    public static final String TYPE_ALBUMDESC = "TEXT";
    public static final String TYPE_ALBUMID = "TEXT UNIQUE";
    public static final String TYPE_ALBUMNAME = "TEXT";
    public static final String TYPE_ALBUMNUM = "INTEGER";
    public static final String TYPE_ALBUMRIGHTS = "INTEGER";
    public static final String TYPE_ATTACHINFO = "TEXT";
    public static final String TYPE_CREATETIME = "INTEGER";
    public static final String TYPE_LASTUPLOADTIME = "INTEGER";
    public static final String TYPE_LLOC = "TEXT";
    public static final String TYPE_MODIFYTIME = "INTEGER";
    public static final String TYPE_OWNERUIN = "INTEGER";
    public static final String TYPE_QUNID = "TEXT";
    public static final int VERSION = 1;
    public String albumdesc;
    public String albumid;
    public String albumname;
    public int albumnum;
    public int albumrights;
    public String qunId;
    public int createtime = 0;
    public int modifytime = 0;
    public int lastuploadtime = 0;
    public String attachinfo = "";
    public String lloc = "";
    public long owneruin = 0;
    public boolean isFake = false;

    /* compiled from: P */
    /* renamed from: v4.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    class C11391a implements IDBCacheDataWrapper.a<a> {
        C11391a() {
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromCursor(Cursor cursor) {
            a aVar = new a();
            aVar.albumname = cursor.getString(cursor.getColumnIndex("albumname"));
            aVar.albumid = cursor.getString(cursor.getColumnIndex("albumid"));
            aVar.albumnum = cursor.getInt(cursor.getColumnIndex("albumnum"));
            aVar.albumrights = cursor.getInt(cursor.getColumnIndex("albumrights"));
            aVar.albumdesc = cursor.getString(cursor.getColumnIndex("albumdesc"));
            aVar.qunId = cursor.getString(cursor.getColumnIndex(a.QUNID));
            aVar.createtime = cursor.getInt(cursor.getColumnIndex("createtime"));
            aVar.modifytime = cursor.getInt(cursor.getColumnIndex(a.MODIFYTIME));
            aVar.lastuploadtime = cursor.getInt(cursor.getColumnIndex(a.LASTUPLOADTIME));
            aVar.attachinfo = cursor.getString(cursor.getColumnIndex("attachinfo"));
            aVar.lloc = cursor.getString(cursor.getColumnIndex("lloc"));
            aVar.owneruin = cursor.getLong(cursor.getColumnIndex("ownerUin"));
            return aVar;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public String sortOrder() {
            return "lastuploadtime DESC";
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public IDBCacheDataWrapper.c[] structure() {
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c("albumname", "TEXT"), new IDBCacheDataWrapper.c("albumid", "TEXT UNIQUE"), new IDBCacheDataWrapper.c("albumnum", "INTEGER"), new IDBCacheDataWrapper.c("albumrights", "INTEGER"), new IDBCacheDataWrapper.c("albumdesc", "TEXT"), new IDBCacheDataWrapper.c(a.QUNID, "TEXT"), new IDBCacheDataWrapper.c("createtime", "INTEGER"), new IDBCacheDataWrapper.c(a.MODIFYTIME, "INTEGER"), new IDBCacheDataWrapper.c(a.LASTUPLOADTIME, "INTEGER"), new IDBCacheDataWrapper.c("attachinfo", "TEXT"), new IDBCacheDataWrapper.c("lloc", "TEXT"), new IDBCacheDataWrapper.c("ownerUin", "INTEGER")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 1;
        }
    }

    public static a createFromResponse(cell_pic cell_picVar, String str, String str2) {
        s_picdata s_picdataVar;
        Map<Integer, s_picurl> map;
        s_picurl s_picurlVar;
        PictureUrl n3;
        String str3;
        if (cell_picVar == null) {
            return null;
        }
        a aVar = new a();
        aVar.albumname = cell_picVar.albumname.trim();
        aVar.albumid = cell_picVar.albumid;
        aVar.albumnum = cell_picVar.albumnum;
        aVar.albumrights = cell_picVar.albumrights;
        aVar.albumdesc = cell_picVar.desc.trim();
        aVar.lastuploadtime = cell_picVar.lastupdatetime;
        aVar.qunId = str;
        aVar.attachinfo = str2;
        ArrayList<s_picdata> arrayList = cell_picVar.picdata;
        if (arrayList != null && arrayList.size() > 0 && (s_picdataVar = cell_picVar.picdata.get(0)) != null && (map = s_picdataVar.photourl) != null) {
            if (map.get(11) == null) {
                s_picurlVar = s_picdataVar.photourl.get(3);
            } else {
                s_picurlVar = s_picdataVar.photourl.get(11);
            }
            if (s_picurlVar != null && (n3 = e.n(s_picurlVar)) != null && (str3 = n3.url) != null) {
                aVar.lloc = str3;
            }
        }
        aVar.owneruin = cell_picVar.uin;
        return aVar;
    }

    public int hashCode() {
        String str = this.albumid;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.qunId;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put("albumname", this.albumname);
        contentValues.put("albumid", this.albumid);
        contentValues.put("albumnum", Integer.valueOf(this.albumnum));
        contentValues.put("albumrights", Integer.valueOf(this.albumrights));
        contentValues.put("albumdesc", this.albumdesc);
        contentValues.put(QUNID, this.qunId);
        contentValues.put("createtime", Integer.valueOf(this.createtime));
        contentValues.put(MODIFYTIME, Integer.valueOf(this.modifytime));
        contentValues.put(LASTUPLOADTIME, Integer.valueOf(this.lastuploadtime));
        contentValues.put("attachinfo", this.attachinfo);
        contentValues.put("lloc", this.lloc);
        contentValues.put("ownerUin", Long.valueOf(this.owneruin));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        String str = this.albumid;
        if (str == null) {
            if (aVar.albumid != null) {
                return false;
            }
        } else if (!str.equals(aVar.albumid)) {
            return false;
        }
        String str2 = this.qunId;
        if (str2 == null) {
            if (aVar.qunId != null) {
                return false;
            }
        } else if (!str2.equals(aVar.qunId)) {
            return false;
        }
        return true;
    }

    public static a createFromResponse(Album album) {
        if (album == null) {
            return null;
        }
        a aVar = new a();
        aVar.albumname = album.name;
        aVar.albumid = album.albumid;
        aVar.albumnum = album.total;
        aVar.albumrights = album.priv;
        aVar.albumdesc = album.desc;
        aVar.qunId = album.qunid;
        aVar.createtime = album.createtime;
        aVar.modifytime = album.moditytime;
        aVar.lastuploadtime = album.lastuploadtime;
        return aVar;
    }
}
