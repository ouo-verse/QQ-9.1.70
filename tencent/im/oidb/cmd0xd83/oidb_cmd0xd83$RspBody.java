package tencent.im.oidb.cmd0xd83;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xd83$RspBody extends MessageMicro<oidb_cmd0xd83$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint32_entrance", "rpt_block_list", "bytes_cookies"}, new Object[]{0, null, ByteStringMicro.EMPTY}, oidb_cmd0xd83$RspBody.class);
    public final PBUInt32Field uint32_entrance = PBField.initUInt32(0);
    public final PBRepeatMessageField<oidb_cmd0xd83$BlockedInfo> rpt_block_list = PBField.initRepeatMessage(oidb_cmd0xd83$BlockedInfo.class);
    public final PBBytesField bytes_cookies = PBField.initBytes(ByteStringMicro.EMPTY);
}
