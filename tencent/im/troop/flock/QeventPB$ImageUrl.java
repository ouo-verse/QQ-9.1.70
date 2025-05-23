package tencent.im.troop.flock;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class QeventPB$ImageUrl extends MessageMicro<QeventPB$ImageUrl> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"level_type", "url", "width", "height"}, new Object[]{0, "", 0, 0}, QeventPB$ImageUrl.class);
    public final PBUInt32Field level_type = PBField.initUInt32(0);
    public final PBStringField url = PBField.initString("");
    public final PBUInt32Field width = PBField.initUInt32(0);
    public final PBUInt32Field height = PBField.initUInt32(0);
}
