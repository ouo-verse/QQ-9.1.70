package tencent.im.oidb.cmd0xece;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xece$ReqBody extends MessageMicro<oidb_0xece$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"group_id", "client_info", "from", "miniapp_protect"}, new Object[]{0L, null, 0, 0}, oidb_0xece$ReqBody.class);
    public final PBUInt64Field group_id = PBField.initUInt64(0);
    public oidb_0xece$ClientInfo client_info = new oidb_0xece$ClientInfo();
    public final PBUInt32Field from = PBField.initUInt32(0);
    public final PBUInt32Field miniapp_protect = PBField.initUInt32(0);
}
