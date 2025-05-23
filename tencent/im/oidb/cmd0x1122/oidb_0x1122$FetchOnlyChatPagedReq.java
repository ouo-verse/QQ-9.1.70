package tencent.im.oidb.cmd0x1122;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class oidb_0x1122$FetchOnlyChatPagedReq extends MessageMicro<oidb_0x1122$FetchOnlyChatPagedReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"start_index"}, new Object[]{0}, oidb_0x1122$FetchOnlyChatPagedReq.class);
    public final PBUInt32Field start_index = PBField.initUInt32(0);
}
