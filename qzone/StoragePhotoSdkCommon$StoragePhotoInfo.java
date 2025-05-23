package qzone;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.biz.lebasearch.Utils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import s4.c;

/* loaded from: classes29.dex */
public final class StoragePhotoSdkCommon$StoragePhotoInfo extends MessageMicro<StoragePhotoSdkCommon$StoragePhotoInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"primary_info", "secondary_info"}, new Object[]{null, null}, StoragePhotoSdkCommon$StoragePhotoInfo.class);
    public StoragePhotoSdkCommon$PhotoPrimaryInfo primary_info = new MessageMicro<StoragePhotoSdkCommon$PhotoPrimaryInfo>() { // from class: qzone.StoragePhotoSdkCommon$PhotoPrimaryInfo
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField albumid;
        public final PBUInt64Field batchid;
        public final PBBytesField bucket;
        public final PBUInt32Field chid;
        public final PBUInt32Field fid;
        public final PBUInt64Field filter;
        public final PBUInt32Field invisible;
        public final PBBytesField lloccode;
        public final PBUInt32Field modify_time;
        public final PBUInt32Field order;
        public final PBBytesField origin_uuid;
        public final PBUInt32Field r_chid;
        public final PBUInt32Field r_fid;
        public final PBUInt32Field s_chid;
        public final PBUInt32Field s_fid;
        public final PBUInt32Field shoot_time;
        public final PBBytesField sloccode;
        public final PBBytesField source_albumid;
        public final PBUInt32Field upload_time;

        static {
            String[] strArr = {"albumid", "lloccode", "chid", Utils.KEY_BUSINESS_ID, "sloccode", "s_chid", "s_fid", "origin_uuid", "r_chid", "r_fid", QZoneJsConstants.DYNAMIC_ALBUM_INVISIBLE, c.BATCHID, "filter", "shoot_time", c.UPLOAD_TIME, "modify_time", "order", "bucket", "source_albumid"};
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 48, 56, 66, 72, 80, 88, 96, 104, 112, 120, 128, 136, 146, 154}, strArr, new Object[]{byteStringMicro, byteStringMicro, 0, 0, byteStringMicro, 0, 0, byteStringMicro, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, byteStringMicro, byteStringMicro}, StoragePhotoSdkCommon$PhotoPrimaryInfo.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.albumid = PBField.initBytes(byteStringMicro);
            this.lloccode = PBField.initBytes(byteStringMicro);
            this.chid = PBField.initUInt32(0);
            this.fid = PBField.initUInt32(0);
            this.sloccode = PBField.initBytes(byteStringMicro);
            this.s_chid = PBField.initUInt32(0);
            this.s_fid = PBField.initUInt32(0);
            this.origin_uuid = PBField.initBytes(byteStringMicro);
            this.r_chid = PBField.initUInt32(0);
            this.r_fid = PBField.initUInt32(0);
            this.invisible = PBField.initUInt32(0);
            this.batchid = PBField.initUInt64(0L);
            this.filter = PBField.initUInt64(0L);
            this.shoot_time = PBField.initUInt32(0);
            this.upload_time = PBField.initUInt32(0);
            this.modify_time = PBField.initUInt32(0);
            this.order = PBField.initUInt32(0);
            this.bucket = PBField.initBytes(byteStringMicro);
            this.source_albumid = PBField.initBytes(byteStringMicro);
        }
    };
    public StoragePhotoSdkCommon$PhotoSecondaryInfo secondary_info = new MessageMicro<StoragePhotoSdkCommon$PhotoSecondaryInfo>() { // from class: qzone.StoragePhotoSdkCommon$PhotoSecondaryInfo
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField append_info;
        public final PBUInt32Field browser;
        public final PBUInt32Field camer;
        public final PBBytesField camera_type;
        public final PBUInt32Field forumindex;
        public final PBUInt32Field frame;
        public final PBUInt32Field grade;
        public final PBUInt32Field gradetimes;
        public final PBUInt32Field handset;
        public final PBUInt32Field is_censored;
        public final PBBytesField lloccode;
        public final PBUInt32Field origin;
        public final PBUInt32Field origin_height;
        public final PBUInt32Field origin_size;
        public final PBUInt32Field origin_type;
        public final PBUInt32Field origin_width;
        public final PBBytesField owner;
        public final PBBytesField owner_name;
        public final PBUInt32Field owner_type;
        public final PBBytesField photo_desc;
        public final PBUInt32Field photo_height;
        public final PBUInt32Field photo_size;
        public final PBUInt32Field photo_type;
        public final PBUInt32Field photo_width;
        public final PBUInt32Field refer;
        public final PBUInt32Field reserv2;
        public final PBUInt32Field reserv3;
        public final PBBytesField reserv4;
        public final PBBytesField shoot_para;
        public final PBBytesField title;
        public final PBUInt32Field user_ip;

        static {
            String[] strArr = {"lloccode", "camer", "title", "photo_type", "owner", "owner_name", "owner_type", "user_ip", "gradetimes", "photo_size", "photo_width", "photo_height", "is_censored", "browser", "forumindex", TtmlNode.ATTR_TTS_ORIGIN, "origin_size", "origin_width", "origin_height", "origin_type", "handset", "camera_type", "photo_desc", "shoot_para", "append_info", "grade", "refer", AIInput.KEY_FRAME, "reserv2", "reserv3", "reserv4"};
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 42, 50, 56, 64, 72, 80, 96, 104, 112, 120, 128, 136, 144, 152, 160, 168, 176, 186, 194, 202, 210, 216, 224, 232, 240, 248, 258}, strArr, new Object[]{byteStringMicro, 0, byteStringMicro, 0, byteStringMicro, byteStringMicro, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, 0, 0, 0, byteStringMicro}, StoragePhotoSdkCommon$PhotoSecondaryInfo.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.lloccode = PBField.initBytes(byteStringMicro);
            this.camer = PBField.initUInt32(0);
            this.title = PBField.initBytes(byteStringMicro);
            this.photo_type = PBField.initUInt32(0);
            this.owner = PBField.initBytes(byteStringMicro);
            this.owner_name = PBField.initBytes(byteStringMicro);
            this.owner_type = PBField.initUInt32(0);
            this.user_ip = PBField.initUInt32(0);
            this.gradetimes = PBField.initUInt32(0);
            this.photo_size = PBField.initUInt32(0);
            this.photo_width = PBField.initUInt32(0);
            this.photo_height = PBField.initUInt32(0);
            this.is_censored = PBField.initUInt32(0);
            this.browser = PBField.initUInt32(0);
            this.forumindex = PBField.initUInt32(0);
            this.origin = PBField.initUInt32(0);
            this.origin_size = PBField.initUInt32(0);
            this.origin_width = PBField.initUInt32(0);
            this.origin_height = PBField.initUInt32(0);
            this.origin_type = PBField.initUInt32(0);
            this.handset = PBField.initUInt32(0);
            this.camera_type = PBField.initBytes(byteStringMicro);
            this.photo_desc = PBField.initBytes(byteStringMicro);
            this.shoot_para = PBField.initBytes(byteStringMicro);
            this.append_info = PBField.initBytes(byteStringMicro);
            this.grade = PBField.initUInt32(0);
            this.refer = PBField.initUInt32(0);
            this.frame = PBField.initUInt32(0);
            this.reserv2 = PBField.initUInt32(0);
            this.reserv3 = PBField.initUInt32(0);
            this.reserv4 = PBField.initBytes(byteStringMicro);
        }
    };
}
