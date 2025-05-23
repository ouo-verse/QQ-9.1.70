package qzone;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class QZonePhotoDegrade$PicInfo extends MessageMicro<QZonePhotoDegrade$PicInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{"url", "type", "width", "height"}, new Object[]{ByteStringMicro.EMPTY, 0, 0, 0}, QZonePhotoDegrade$PicInfo.class);
    public final PBBytesField url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBUInt32Field width = PBField.initUInt32(0);
    public final PBUInt32Field height = PBField.initUInt32(0);
}
