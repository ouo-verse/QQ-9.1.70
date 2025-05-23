package qzone;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import s4.c;

/* loaded from: classes29.dex */
public final class QZonePhotoDegrade$PhotoInfo extends MessageMicro<QZonePhotoDegrade$PhotoInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField ablum_id;
    public final PBInt64Field create_time;
    public final PBUInt64Field hd_pic_size;
    public final PBUInt64Field original_pic_size;
    public final PBBytesField photo_id;
    public final PBRepeatMessageField<QZonePhotoDegrade$PicInfo> pics;
    public final PBInt64Field recover_time;
    public final PBEnumField status;

    static {
        String[] strArr = {"photo_id", "ablum_id", c.PICS, "status", AlbumCacheData.CREATE_TIME, "recover_time", "original_pic_size", "hd_pic_size"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 48, 56, 64}, strArr, new Object[]{byteStringMicro, byteStringMicro, null, 0, 0L, 0L, 0L, 0L}, QZonePhotoDegrade$PhotoInfo.class);
    }

    public QZonePhotoDegrade$PhotoInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.photo_id = PBField.initBytes(byteStringMicro);
        this.ablum_id = PBField.initBytes(byteStringMicro);
        this.pics = PBField.initRepeatMessage(QZonePhotoDegrade$PicInfo.class);
        this.status = PBField.initEnum(0);
        this.create_time = PBField.initInt64(0L);
        this.recover_time = PBField.initInt64(0L);
        this.original_pic_size = PBField.initUInt64(0L);
        this.hd_pic_size = PBField.initUInt64(0L);
    }
}
