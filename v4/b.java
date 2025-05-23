package v4;

import NS_MOBILE_FEEDS.s_picdata;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import android.text.TextUtils;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.util.e;
import com.qzone.util.image.ImageInfo;
import com.qzone.util.image.NetImageInfo;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b extends com.qzone.component.cache.database.a {
    public static final String ALBUMID = "albumid";
    public static final String ATTACHINFO = "attachinfo";
    public static final String CLIENTKEY = "clientkey";
    public static final String CURKEY = "curkey";
    public static final IDBCacheDataWrapper.a<b> DB_CREATOR = new a();
    public static final String DESC = "desc";
    public static final int FAKE = 0;
    public static final String FAKETYPE = "faketype";
    public static final String LLOC = "lloc";
    public static final String PIC_DATA = "pic_data";
    public static final String TYPE_ALBUMID = "TEXT";
    public static final String TYPE_ATTACHINFO = "TEXT";
    public static final String TYPE_CLIENTKEY = "TEXT";
    public static final String TYPE_CURKEY = "TEXT";
    public static final String TYPE_DESC = "TEXT";
    public static final String TYPE_FAKETYPE = "INTEGER";
    public static final String TYPE_LLOC = "TEXT UNIQUE";
    public static final String TYPE_PIC_DATA = "BLOB";
    public static final String TYPE_UNIKEY = "TEXT";
    public static final String TYPE_UPLOADTIME = "INTEGER";
    public static final String UNIKEY = "unikey";
    public static final String UPLOADTIME = "uploadtime";
    public static final int VERSION = 4;
    public PictureItem picItem;
    public String lloc = "";
    public String desc = "";
    public long uploadtime = 0;
    public String unikey = "";
    public String curkey = "";
    public String albumid = "";
    public String attachinfo = "";
    public String clientkey = "";
    public int fakeType = 1;
    public int index = 0;
    public boolean timevisible = false;

    /* compiled from: P */
    /* loaded from: classes36.dex */
    class a implements IDBCacheDataWrapper.a<b> {
        a() {
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b createFromCursor(Cursor cursor) {
            b bVar = new b();
            bVar.lloc = cursor.getString(cursor.getColumnIndex("lloc"));
            bVar.clientkey = cursor.getString(cursor.getColumnIndex(b.CLIENTKEY));
            bVar.desc = cursor.getString(cursor.getColumnIndex("desc"));
            bVar.uploadtime = cursor.getInt(cursor.getColumnIndex("uploadtime"));
            bVar.unikey = cursor.getString(cursor.getColumnIndex(b.UNIKEY));
            bVar.curkey = cursor.getString(cursor.getColumnIndex(b.CURKEY));
            bVar.albumid = cursor.getString(cursor.getColumnIndex("albumid"));
            bVar.attachinfo = cursor.getString(cursor.getColumnIndex("attachinfo"));
            bVar.fakeType = cursor.getInt(cursor.getColumnIndex(b.FAKETYPE));
            byte[] blob = cursor.getBlob(cursor.getColumnIndex(b.PIC_DATA));
            if (blob != null) {
                try {
                    Parcel obtain = Parcel.obtain();
                    obtain.unmarshall(blob, 0, blob.length);
                    obtain.setDataPosition(0);
                    bVar.picItem = (PictureItem) ParcelableWrapper.createDataFromParcel(obtain);
                    OaidMonitor.parcelRecycle(obtain);
                } catch (Exception e16) {
                    QZLog.w(e16);
                }
            }
            return bVar;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public String sortOrder() {
            return "uploadtime DESC";
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public IDBCacheDataWrapper.c[] structure() {
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c("lloc", "TEXT UNIQUE"), new IDBCacheDataWrapper.c(b.CLIENTKEY, "TEXT"), new IDBCacheDataWrapper.c("desc", "TEXT"), new IDBCacheDataWrapper.c("uploadtime", "INTEGER"), new IDBCacheDataWrapper.c(b.UNIKEY, "TEXT"), new IDBCacheDataWrapper.c(b.CURKEY, "TEXT"), new IDBCacheDataWrapper.c("albumid", "TEXT"), new IDBCacheDataWrapper.c("attachinfo", "TEXT"), new IDBCacheDataWrapper.c(b.FAKETYPE, "INTEGER"), new IDBCacheDataWrapper.c(b.PIC_DATA, "BLOB")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 4;
        }
    }

    public static b createFakePhoto(String str, String str2, ImageInfo imageInfo) {
        b bVar = new b();
        bVar.fakeType = 0;
        bVar.albumid = str2;
        if (imageInfo != null) {
            bVar.lloc = imageInfo.mPath;
            bVar.desc = imageInfo.mDescription;
            PictureItem pictureItem = new PictureItem();
            bVar.picItem = pictureItem;
            PictureUrl pictureUrl = pictureItem.currentUrl;
            String str3 = imageInfo.mPath;
            pictureUrl.url = str3;
            pictureItem.bigUrl.url = str3;
        }
        bVar.uploadtime = System.currentTimeMillis() / 1000;
        return bVar;
    }

    public int hashCode() {
        String str = this.albumid;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.lloc;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public boolean isFake() {
        return this.fakeType == 0;
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put("lloc", this.lloc);
        contentValues.put(CLIENTKEY, this.clientkey);
        contentValues.put("desc", this.desc);
        contentValues.put("uploadtime", Long.valueOf(this.uploadtime));
        contentValues.put(UNIKEY, this.unikey);
        contentValues.put(CURKEY, this.curkey);
        contentValues.put("albumid", this.albumid);
        contentValues.put("attachinfo", this.attachinfo);
        contentValues.put(FAKETYPE, Integer.valueOf(this.fakeType));
        Parcel obtain = Parcel.obtain();
        ParcelableWrapper.writeDataToParcel(obtain, 0, this.picItem);
        contentValues.put(PIC_DATA, obtain.marshall());
        OaidMonitor.parcelRecycle(obtain);
    }

    public static b createFromResponse(s_picdata s_picdataVar) {
        if (s_picdataVar == null) {
            return null;
        }
        b bVar = new b();
        bVar.lloc = s_picdataVar.lloc;
        bVar.uploadtime = s_picdataVar.uUploadTime;
        bVar.desc = s_picdataVar.desc;
        bVar.curkey = s_picdataVar.curlikekey;
        bVar.unikey = s_picdataVar.orglikekey;
        String str = s_picdataVar.clientkey;
        bVar.clientkey = str;
        if (TextUtils.isEmpty(str)) {
            bVar.clientkey = bVar.lloc;
        }
        bVar.picItem = e.m(s_picdataVar);
        return bVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        b bVar = (b) obj;
        String str = this.albumid;
        if (str == null) {
            if (bVar.albumid != null) {
                return false;
            }
        } else if (!str.equals(bVar.albumid)) {
            return false;
        }
        String str2 = this.lloc;
        if (str2 == null) {
            if (bVar.lloc != null) {
                return false;
            }
        } else if (!str2.equals(bVar.lloc)) {
            return false;
        }
        return this.clientkey.equals(bVar.clientkey);
    }

    public static b createFakePhoto(String str, String str2, NetImageInfo netImageInfo) {
        b bVar = new b();
        bVar.fakeType = 0;
        bVar.albumid = str2;
        if (netImageInfo != null) {
            bVar.lloc = netImageInfo.mSmallPath;
            PictureItem pictureItem = new PictureItem();
            bVar.picItem = pictureItem;
            pictureItem.bigUrl.url = netImageInfo.mBigPath;
            pictureItem.currentUrl.url = netImageInfo.mSmallPath;
        }
        bVar.uploadtime = System.currentTimeMillis() / 1000;
        return bVar;
    }
}
