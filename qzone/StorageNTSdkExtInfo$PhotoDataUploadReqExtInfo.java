package qzone;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class StorageNTSdkExtInfo$PhotoDataUploadReqExtInfo extends MessageMicro<StorageNTSdkExtInfo$PhotoDataUploadReqExtInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field album_maxphoto;
    public final PBBytesField albumid;
    public StoragePhotoSdkCommon$CompressStrategyInfo compress_strategy_info;
    public final PBBytesField echo_msg;
    public final PBUInt32Field is_keep_origin;
    public StoragePhotoSdkCommon$StoragePhotoInfo photo_info;
    public final PBStringField sha1;
    public final PBUInt32Field terminal_type;
    public final PBStringField terminal_ver;
    public final PBUInt32Field user_diskquota;
    public final PBStringField user_id;

    static {
        String[] strArr = {"albumid", "photo_info", "user_diskquota", "album_maxphoto", "is_keep_origin", "compress_strategy_info", "sha1", AudienceReportConst.TERMINAL_TYPE, "terminal_ver", "user_id", "echo_msg"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 50, 58, 64, 74, 82, 802}, strArr, new Object[]{byteStringMicro, null, 0, 0, 0, null, "", 0, "", "", byteStringMicro}, StorageNTSdkExtInfo$PhotoDataUploadReqExtInfo.class);
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [qzone.StoragePhotoSdkCommon$CompressStrategyInfo] */
    public StorageNTSdkExtInfo$PhotoDataUploadReqExtInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.albumid = PBField.initBytes(byteStringMicro);
        this.photo_info = new StoragePhotoSdkCommon$StoragePhotoInfo();
        this.user_diskquota = PBField.initUInt32(0);
        this.album_maxphoto = PBField.initUInt32(0);
        this.is_keep_origin = PBField.initUInt32(0);
        this.compress_strategy_info = new MessageMicro<StoragePhotoSdkCommon$CompressStrategyInfo>() { // from class: qzone.StoragePhotoSdkCommon$CompressStrategyInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"is_vip_user", "watermark_pic", "watermark_word"}, new Object[]{0, 0, ByteStringMicro.EMPTY}, StoragePhotoSdkCommon$CompressStrategyInfo.class);
            public final PBUInt32Field is_vip_user = PBField.initUInt32(0);
            public final PBUInt32Field watermark_pic = PBField.initUInt32(0);
            public final PBBytesField watermark_word = PBField.initBytes(ByteStringMicro.EMPTY);
        };
        this.sha1 = PBField.initString("");
        this.terminal_type = PBField.initUInt32(0);
        this.terminal_ver = PBField.initString("");
        this.user_id = PBField.initString("");
        this.echo_msg = PBField.initBytes(byteStringMicro);
    }
}
