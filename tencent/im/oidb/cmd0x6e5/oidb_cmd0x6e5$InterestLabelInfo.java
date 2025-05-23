package tencent.im.oidb.cmd0x6e5;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x6e5$InterestLabelInfo extends MessageMicro<oidb_cmd0x6e5$InterestLabelInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_interest_label_id", "bytes_interest_label_name"}, new Object[]{0, ByteStringMicro.EMPTY}, oidb_cmd0x6e5$InterestLabelInfo.class);
    public final PBUInt32Field uint32_interest_label_id = PBField.initUInt32(0);
    public final PBBytesField bytes_interest_label_name = PBField.initBytes(ByteStringMicro.EMPTY);
}
