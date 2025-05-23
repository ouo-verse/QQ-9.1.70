package tencent.im.oidb.cmd0xe27;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xe27$InOutQQ extends MessageMicro<oidb_cmd0xe27$InOutQQ> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"enum_biz_id", "uint32_timestamp"}, new Object[]{1, 0}, oidb_cmd0xe27$InOutQQ.class);
    public final PBEnumField enum_biz_id = PBField.initEnum(1);
    public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
}
