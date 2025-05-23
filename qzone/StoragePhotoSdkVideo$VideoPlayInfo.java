package qzone;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.vip.impl.VasQQSettingMeImpl;

/* loaded from: classes29.dex */
public final class StoragePhotoSdkVideo$VideoPlayInfo extends MessageMicro<StoragePhotoSdkVideo$VideoPlayInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field access_perm;
    public final PBUInt32Field bitrate;
    public final PBUInt32Field duration;
    public final PBUInt32Field expire_time;
    public final PBBytesField file_name;
    public final PBUInt64Field file_size;
    public final PBBytesField file_type;
    public final PBBytesField formatid;
    public final PBUInt32Field height;
    public final PBBytesField url;
    public final PBUInt32Field width;

    static {
        String[] strArr = {"formatid", "file_name", "access_perm", "file_size", "duration", "file_type", "url", "width", "height", "bitrate", VasQQSettingMeImpl.EXPIRE_TIME};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 50, 58, 64, 72, 80, 88}, strArr, new Object[]{byteStringMicro, byteStringMicro, 0, 0L, 0, byteStringMicro, byteStringMicro, 0, 0, 0, 0}, StoragePhotoSdkVideo$VideoPlayInfo.class);
    }

    public StoragePhotoSdkVideo$VideoPlayInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.formatid = PBField.initBytes(byteStringMicro);
        this.file_name = PBField.initBytes(byteStringMicro);
        this.access_perm = PBField.initUInt32(0);
        this.file_size = PBField.initUInt64(0L);
        this.duration = PBField.initUInt32(0);
        this.file_type = PBField.initBytes(byteStringMicro);
        this.url = PBField.initBytes(byteStringMicro);
        this.width = PBField.initUInt32(0);
        this.height = PBField.initUInt32(0);
        this.bitrate = PBField.initUInt32(0);
        this.expire_time = PBField.initUInt32(0);
    }
}
