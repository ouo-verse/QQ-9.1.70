package qzone;

import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import cooperation.qzone.webviewplugin.QZoneJsConstants;

/* loaded from: classes29.dex */
public final class StorageNTSdkExtInfo$PhotoDataUploadRspExtInfo extends MessageMicro<StorageNTSdkExtInfo$PhotoDataUploadRspExtInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"user_info", "img_infos", "upload_retcode", "album_info"}, new Object[]{null, null, 0, null}, StorageNTSdkExtInfo$PhotoDataUploadRspExtInfo.class);
    public StoragePhotoSdkCommon$UserInfo user_info = new MessageMicro<StoragePhotoSdkCommon$UserInfo>() { // from class: qzone.StoragePhotoSdkCommon$UserInfo
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBUInt32Field bitmap;
        public final PBBytesField cover_albumid;
        public final PBBytesField cover_photoid;
        public final PBUInt32Field create_time;
        public final PBUInt32Field disk_quota;
        public final PBUInt32Field disk_used;
        public final PBBytesField email;
        public final PBUInt32Field last_login_time;
        public final PBUInt32Field order_type;
        public final PBUInt32Field reserv1;
        public final PBUInt32Field reserv2;
        public final PBUInt32Field reserv3;
        public final PBBytesField reserv4;
        public final PBBytesField userid;

        static {
            String[] strArr = {"userid", "disk_quota", "disk_used", AlbumCacheData.CREATE_TIME, "last_login_time", "cover_albumid", "cover_photoid", "email", MimeHelper.IMAGE_SUBTYPE_BITMAP, "order_type", "reserv1", "reserv2", "reserv3", "reserv4"};
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 50, 58, 66, 72, 80, 88, 96, 104, 114}, strArr, new Object[]{byteStringMicro, 0, 0, 0, 0, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, 0, 0, 0, byteStringMicro}, StoragePhotoSdkCommon$UserInfo.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.userid = PBField.initBytes(byteStringMicro);
            this.disk_quota = PBField.initUInt32(0);
            this.disk_used = PBField.initUInt32(0);
            this.create_time = PBField.initUInt32(0);
            this.last_login_time = PBField.initUInt32(0);
            this.cover_albumid = PBField.initBytes(byteStringMicro);
            this.cover_photoid = PBField.initBytes(byteStringMicro);
            this.email = PBField.initBytes(byteStringMicro);
            this.bitmap = PBField.initUInt32(0);
            this.order_type = PBField.initUInt32(0);
            this.reserv1 = PBField.initUInt32(0);
            this.reserv2 = PBField.initUInt32(0);
            this.reserv3 = PBField.initUInt32(0);
            this.reserv4 = PBField.initBytes(byteStringMicro);
        }
    };
    public final PBRepeatMessageField<StoragePhotoSdkCommon$ImgInfo> img_infos = PBField.initRepeatMessage(StoragePhotoSdkCommon$ImgInfo.class);
    public final PBSInt32Field upload_retcode = PBField.initSInt32(0);
    public StoragePhotoSdkCommon$StorageAlbumInfo album_info = new MessageMicro<StoragePhotoSdkCommon$StorageAlbumInfo>() { // from class: qzone.StoragePhotoSdkCommon$StorageAlbumInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"primary_info", "secondary_info"}, new Object[]{null, null}, StoragePhotoSdkCommon$StorageAlbumInfo.class);
        public StoragePhotoSdkCommon$AlbumPrimaryInfo primary_info = new MessageMicro<StoragePhotoSdkCommon$AlbumPrimaryInfo>() { // from class: qzone.StoragePhotoSdkCommon$AlbumPrimaryInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88}, new String[]{"albumid", "total", "disk_used", QZoneJsConstants.DYNAMIC_ALBUM_INVISIBLE, AlbumCacheData.CREATE_TIME, "modify_time", "album_class", "last_upload", "order", "filter", "album_type"}, new Object[]{ByteStringMicro.EMPTY, 0, 0, 0, 0, 0, 0, 0, 0, 0L, 0}, StoragePhotoSdkCommon$AlbumPrimaryInfo.class);
            public final PBBytesField albumid = PBField.initBytes(ByteStringMicro.EMPTY);
            public final PBUInt32Field total = PBField.initUInt32(0);
            public final PBUInt32Field disk_used = PBField.initUInt32(0);
            public final PBUInt32Field invisible = PBField.initUInt32(0);
            public final PBUInt32Field create_time = PBField.initUInt32(0);
            public final PBUInt32Field modify_time = PBField.initUInt32(0);
            public final PBUInt32Field album_class = PBField.initUInt32(0);
            public final PBUInt32Field last_upload = PBField.initUInt32(0);
            public final PBUInt32Field order = PBField.initUInt32(0);
            public final PBUInt64Field filter = PBField.initUInt64(0);
            public final PBUInt32Field album_type = PBField.initUInt32(0);
        };
        public StoragePhotoSdkCommon$AlbumSecondaryInfo secondary_info = new MessageMicro<StoragePhotoSdkCommon$AlbumSecondaryInfo>() { // from class: qzone.StoragePhotoSdkCommon$AlbumSecondaryInfo
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBBytesField album_desc;
            public final PBBytesField albumid;
            public final PBUInt32Field anonymity;
            public final PBBytesField bgmusic;
            public final PBBytesField bgpic;
            public final PBUInt32Field bitmap;
            public final PBUInt32Field browser;
            public final PBBytesField class_name;
            public final PBUInt32Field comment;
            public final PBBytesField cover;
            public final PBBytesField friend_list;
            public final PBBytesField owner;
            public final PBBytesField password;

            /* renamed from: qa, reason: collision with root package name */
            public final PBBytesField f430346qa;
            public final PBUInt32Field reserv1;
            public final PBUInt32Field reserv3;
            public final PBBytesField reserv4;
            public final PBUInt32Field style;
            public final PBBytesField title;

            static {
                String[] strArr = {"albumid", "title", "owner", MimeHelper.IMAGE_SUBTYPE_BITMAP, AlbumCacheData.ANONYMITY, "style", "browser", "comment", "qa", "album_desc", "cover", NotificationActivity.PASSWORD, "bgmusic", "bgpic", PictureConst.KEY_CLASSNAME, "friend_list", "reserv1", "reserv3", "reserv4"};
                ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 48, 56, 64, 74, 82, 90, 98, 106, 114, 122, 130, 136, 144, 154}, strArr, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, 0, 0, 0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, byteStringMicro}, StoragePhotoSdkCommon$AlbumSecondaryInfo.class);
            }

            {
                ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                this.albumid = PBField.initBytes(byteStringMicro);
                this.title = PBField.initBytes(byteStringMicro);
                this.owner = PBField.initBytes(byteStringMicro);
                this.bitmap = PBField.initUInt32(0);
                this.anonymity = PBField.initUInt32(0);
                this.style = PBField.initUInt32(0);
                this.browser = PBField.initUInt32(0);
                this.comment = PBField.initUInt32(0);
                this.f430346qa = PBField.initBytes(byteStringMicro);
                this.album_desc = PBField.initBytes(byteStringMicro);
                this.cover = PBField.initBytes(byteStringMicro);
                this.password = PBField.initBytes(byteStringMicro);
                this.bgmusic = PBField.initBytes(byteStringMicro);
                this.bgpic = PBField.initBytes(byteStringMicro);
                this.class_name = PBField.initBytes(byteStringMicro);
                this.friend_list = PBField.initBytes(byteStringMicro);
                this.reserv1 = PBField.initUInt32(0);
                this.reserv3 = PBField.initUInt32(0);
                this.reserv4 = PBField.initBytes(byteStringMicro);
            }
        };
    };
}
