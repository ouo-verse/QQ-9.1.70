package qzone;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes29.dex */
public final class QZonePhotoDegrade$QueryNotifyMsgReq extends MessageMicro<QZonePhotoDegrade$QueryNotifyMsgReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"scene", "plat", "cookie"}, new Object[]{0, 0, ByteStringMicro.EMPTY}, QZonePhotoDegrade$QueryNotifyMsgReq.class);
    public final PBEnumField scene = PBField.initEnum(0);
    public final PBEnumField plat = PBField.initEnum(0);
    public final PBBytesField cookie = PBField.initBytes(ByteStringMicro.EMPTY);
}
