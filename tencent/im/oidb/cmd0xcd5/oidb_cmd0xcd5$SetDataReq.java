package tencent.im.oidb.cmd0xcd5;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xcd5$SetDataReq extends MessageMicro<oidb_cmd0xcd5$SetDataReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"pb_data"}, new Object[]{ByteStringMicro.EMPTY}, oidb_cmd0xcd5$SetDataReq.class);
    public final PBBytesField pb_data = PBField.initBytes(ByteStringMicro.EMPTY);
}
