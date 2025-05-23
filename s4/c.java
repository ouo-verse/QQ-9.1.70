package s4;

import NS_MOBILE_FEEDS.cell_pic;
import NS_MOBILE_FEEDS.s_picdata;
import NS_MOBILE_FEEDS.s_picurl;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import android.text.TextUtils;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes36.dex */
public class c extends com.qzone.component.cache.database.a {
    public static final String ALBUMANSWER = "albumanswer";
    public static final String ALBUMDESC = "albumdesc";
    public static final String ALBUMID = "albumid";
    public static final String ALBUMLBS = "ipo";
    public static final String ALBUMNAME = "albumname";
    public static final String ALBUMNUM = "albumnum";
    public static final String ALBUMQUESTION = "albumquestion";
    public static final String ALBUMRIGHTS = "albumrights";
    public static final String APPID = "appid";
    public static final String BATCHID = "batchid";
    public static final String BUSIPARAM = "busiparam";
    public static final String CELLID = "cellid";
    public static final String CLIENT_KEY = "client_key";
    public static final IDBCacheDataWrapper.a<c> DB_CREATOR = new a();
    public static final String LAST_REFRESH_TIME = "last_refresh_time";
    public static final String LLOC = "lloc";
    public static final String OWNERUIN = "ownerUin";
    public static final String PICS = "pics";
    public static final String TYPE_ALBUMANSWER = "TEXT";
    public static final String TYPE_ALBUMDESC = "TEXT";
    public static final String TYPE_ALBUMID = "TEXT";
    public static final String TYPE_ALBUMLBS = "TEXT";
    public static final String TYPE_ALBUMNAME = "TEXT";
    public static final String TYPE_ALBUMNUM = "INTEGER";
    public static final String TYPE_ALBUMQUESTION = "TEXT";
    public static final String TYPE_ALBUMRIGHTS = "INTEGER";
    public static final String TYPE_APPID = "INTEGER";
    public static final String TYPE_BATCHID = "TEXT";
    public static final String TYPE_BUSIPARAM = "BLOB";
    public static final String TYPE_CELLID = "TEXT";
    public static final String TYPE_CLIENT_KEY = "TEXT";
    public static final String TYPE_LAST_REFRESH_TIME = "INTEGER";
    public static final String TYPE_LLOC = "TEXT";
    public static final String TYPE_OWNERUIN = "INTEGER";
    public static final String TYPE_PICS = "BLOB";
    public static final String TYPE_UGCKEY = "TEXT";
    public static final String TYPE_UPLOADNUM = "INTEGER";
    public static final String TYPE_UPLOAD_TIME = "INTEGER";
    public static final String TYPE_VIDEO_INFO = "BLOB";
    public static final String UGCKEY = "ugckey";
    public static final String UPLOADNUM = "uploadnum";
    public static final String UPLOAD_TIME = "upload_time";
    public static final String VIDEO_INFO = "video_info";
    public String albumanswer;
    public String albumdesc;
    public String albumid;
    public String albumname;
    public int albumnum;
    public String albumquestion;
    public int albumrights;
    public int appid;
    public String batchid;
    public Map<Integer, String> busiParam;
    public String cellid;
    public String clientKey;
    public long lastRefreshTime;
    public String lbs;
    public String lloc;
    public int mUploadTime;
    public long ownerUin;
    public ArrayList<PictureItem> pics = new ArrayList<>();
    public String ugckey;
    public int uploadnum;
    public VideoInfo videoInfo;

    /* compiled from: P */
    /* loaded from: classes36.dex */
    class a implements IDBCacheDataWrapper.a<c> {
        a() {
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c createFromCursor(Cursor cursor) {
            c cVar = new c();
            cVar.albumname = cursor.getString(cursor.getColumnIndex("albumname"));
            cVar.albumid = cursor.getString(cursor.getColumnIndex("albumid"));
            cVar.batchid = cursor.getString(cursor.getColumnIndex(c.BATCHID));
            cVar.albumnum = cursor.getInt(cursor.getColumnIndex("albumnum"));
            cVar.uploadnum = cursor.getInt(cursor.getColumnIndex("uploadnum"));
            cVar.albumrights = cursor.getInt(cursor.getColumnIndex("albumrights"));
            cVar.albumquestion = cursor.getString(cursor.getColumnIndex("albumquestion"));
            cVar.albumanswer = cursor.getString(cursor.getColumnIndex("albumanswer"));
            cVar.lloc = cursor.getString(cursor.getColumnIndex("lloc"));
            cVar.albumdesc = cursor.getString(cursor.getColumnIndex("albumdesc"));
            cVar.lbs = cursor.getString(cursor.getColumnIndex(c.ALBUMLBS));
            cVar.ownerUin = cursor.getLong(cursor.getColumnIndex("ownerUin"));
            cVar.mUploadTime = cursor.getInt(cursor.getColumnIndex(c.UPLOAD_TIME));
            byte[] blob = cursor.getBlob(cursor.getColumnIndex(c.PICS));
            if (blob != null) {
                try {
                    Parcel obtain = Parcel.obtain();
                    obtain.unmarshall(blob, 0, blob.length);
                    obtain.setDataPosition(0);
                    cVar.pics = ParcelableWrapper.createArrayListFromParcel(obtain);
                    OaidMonitor.parcelRecycle(obtain);
                } catch (Exception e16) {
                    QZLog.w(e16);
                }
            }
            cVar.lastRefreshTime = cursor.getLong(cursor.getColumnIndex("last_refresh_time"));
            cVar.appid = cursor.getInt(cursor.getColumnIndex("appid"));
            cVar.cellid = cursor.getString(cursor.getColumnIndex(c.CELLID));
            byte[] blob2 = cursor.getBlob(cursor.getColumnIndex(c.BUSIPARAM));
            if (blob2 != null) {
                try {
                    Parcel obtain2 = Parcel.obtain();
                    obtain2.unmarshall(blob2, 0, blob2.length);
                    obtain2.setDataPosition(0);
                    cVar.busiParam = obtain2.readHashMap(getClass().getClassLoader());
                    OaidMonitor.parcelRecycle(obtain2);
                } catch (Exception e17) {
                    QZLog.w(e17);
                }
            }
            cVar.ugckey = cursor.getString(cursor.getColumnIndex(c.UGCKEY));
            cVar.clientKey = cursor.getString(cursor.getColumnIndex("client_key"));
            byte[] blob3 = cursor.getBlob(cursor.getColumnIndex("video_info"));
            if (blob3 != null) {
                try {
                    Parcel obtain3 = Parcel.obtain();
                    obtain3.unmarshall(blob3, 0, blob3.length);
                    obtain3.setDataPosition(0);
                    cVar.videoInfo = (VideoInfo) ParcelableWrapper.createDataFromParcel(obtain3);
                    OaidMonitor.parcelRecycle(obtain3);
                } catch (Exception e18) {
                    QZLog.w(e18);
                }
            }
            return cVar;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public String sortOrder() {
            return null;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public IDBCacheDataWrapper.c[] structure() {
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c("albumname", "TEXT"), new IDBCacheDataWrapper.c("albumid", "TEXT"), new IDBCacheDataWrapper.c(c.BATCHID, "TEXT"), new IDBCacheDataWrapper.c("albumnum", "INTEGER"), new IDBCacheDataWrapper.c("uploadnum", "INTEGER"), new IDBCacheDataWrapper.c("albumrights", "INTEGER"), new IDBCacheDataWrapper.c("albumquestion", "TEXT"), new IDBCacheDataWrapper.c("albumanswer", "TEXT"), new IDBCacheDataWrapper.c("lloc", "TEXT"), new IDBCacheDataWrapper.c("albumdesc", "TEXT"), new IDBCacheDataWrapper.c(c.ALBUMLBS, "TEXT"), new IDBCacheDataWrapper.c("ownerUin", "INTEGER"), new IDBCacheDataWrapper.c(c.UPLOAD_TIME, "INTEGER"), new IDBCacheDataWrapper.c(c.PICS, "BLOB"), new IDBCacheDataWrapper.c("last_refresh_time", "INTEGER"), new IDBCacheDataWrapper.c("appid", "INTEGER"), new IDBCacheDataWrapper.c(c.CELLID, "TEXT"), new IDBCacheDataWrapper.c(c.BUSIPARAM, "BLOB"), new IDBCacheDataWrapper.c(c.UGCKEY, "TEXT"), new IDBCacheDataWrapper.c("client_key", "TEXT"), new IDBCacheDataWrapper.c("video_info", "BLOB")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 18;
        }
    }

    public boolean isVideo() {
        PictureUrl pictureUrl;
        VideoInfo videoInfo = this.videoInfo;
        return (videoInfo == null || (pictureUrl = videoInfo.coverUrl) == null || TextUtils.isEmpty(pictureUrl.url)) ? false : true;
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put("albumname", this.albumname);
        contentValues.put("albumid", this.albumid);
        contentValues.put(BATCHID, this.batchid);
        contentValues.put("albumnum", Integer.valueOf(this.albumnum));
        contentValues.put("uploadnum", Integer.valueOf(this.uploadnum));
        contentValues.put("albumrights", Integer.valueOf(this.albumrights));
        contentValues.put("albumquestion", this.albumquestion);
        contentValues.put("albumanswer", this.albumanswer);
        contentValues.put("lloc", this.lloc);
        contentValues.put("albumdesc", this.albumdesc);
        contentValues.put(ALBUMLBS, this.lbs);
        contentValues.put("ownerUin", Long.valueOf(this.ownerUin));
        contentValues.put(UPLOAD_TIME, Integer.valueOf(this.mUploadTime));
        Parcel obtain = Parcel.obtain();
        ParcelableWrapper.writeArrayListToParcel(obtain, 0, this.pics);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        contentValues.put(PICS, marshall);
        contentValues.put("last_refresh_time", Long.valueOf(this.lastRefreshTime));
        contentValues.put("appid", Integer.valueOf(this.appid));
        contentValues.put(CELLID, this.cellid);
        Parcel obtain2 = Parcel.obtain();
        obtain2.writeMap(this.busiParam);
        byte[] marshall2 = obtain2.marshall();
        OaidMonitor.parcelRecycle(obtain2);
        contentValues.put(BUSIPARAM, marshall2);
        contentValues.put(UGCKEY, this.ugckey);
        contentValues.put("client_key", this.clientKey);
        Parcel obtain3 = Parcel.obtain();
        ParcelableWrapper.writeDataToParcel(obtain3, 0, this.videoInfo);
        byte[] marshall3 = obtain3.marshall();
        OaidMonitor.parcelRecycle(obtain3);
        contentValues.put("video_info", marshall3);
    }

    public static c createFromResponse(cell_pic cell_picVar, long j3, int i3, String str, String str2, String str3, int i16, Map<Integer, String> map, String str4, VideoInfo videoInfo) {
        String str5;
        s_picurl s_picurlVar;
        if (cell_picVar == null) {
            return null;
        }
        c cVar = new c();
        String str6 = cell_picVar.albumname;
        if (str6 != null) {
            str5 = str6.trim();
        } else {
            str5 = "";
        }
        cVar.albumname = str5;
        String str7 = cell_picVar.albumid;
        if (str7 == null) {
            cVar.albumid = str;
        } else {
            cVar.albumid = str7;
        }
        cVar.albumnum = cell_picVar.albumnum;
        cVar.albumrights = cell_picVar.albumrights;
        cVar.albumquestion = cell_picVar.albumquestion.trim();
        cVar.albumanswer = cell_picVar.albumanswer.trim();
        ArrayList<s_picdata> arrayList = cell_picVar.picdata;
        if (arrayList != null && arrayList.size() != 0) {
            if (cell_picVar.picdata.get(0).photourl.get(11) == null) {
                s_picurlVar = cell_picVar.picdata.get(0).photourl.get(3);
            } else {
                s_picurlVar = cell_picVar.picdata.get(0).photourl.get(11);
            }
            cVar.lloc = s_picurlVar.url;
        }
        cVar.albumdesc = cell_picVar.desc.trim().toString();
        cVar.lbs = str3;
        cVar.ownerUin = j3;
        cVar.mUploadTime = i3;
        cVar.uploadnum = cell_picVar.uploadnum;
        ArrayList<s_picdata> arrayList2 = cell_picVar.picdata;
        int size = arrayList2 != null ? arrayList2.size() : 0;
        if (size > cell_picVar.uploadnum) {
            cVar.uploadnum = size;
        }
        for (int i17 = 0; i17 < size; i17++) {
            s_picdata s_picdataVar = cell_picVar.picdata.get(i17);
            if (s_picdataVar != null) {
                cVar.pics.add(com.qzone.proxy.feedcomponent.util.e.m(s_picdataVar));
            }
        }
        cVar.lastRefreshTime = System.currentTimeMillis();
        cVar.appid = i16;
        cVar.cellid = str;
        cVar.batchid = str2;
        cVar.busiParam = map;
        cVar.ugckey = str4;
        cVar.videoInfo = videoInfo;
        return cVar;
    }
}
