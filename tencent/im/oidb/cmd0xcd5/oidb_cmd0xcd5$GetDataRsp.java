package tencent.im.oidb.cmd0xcd5;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xcd5$GetDataRsp extends MessageMicro<oidb_cmd0xcd5$GetDataRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"flag", "pb_data"}, new Object[]{0, ByteStringMicro.EMPTY}, oidb_cmd0xcd5$GetDataRsp.class);
    public final PBUInt32Field flag = PBField.initUInt32(0);
    public final PBBytesField pb_data = PBField.initBytes(ByteStringMicro.EMPTY);
}
