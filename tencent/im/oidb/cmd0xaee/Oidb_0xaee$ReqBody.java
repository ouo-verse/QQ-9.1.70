package tencent.im.oidb.cmd0xaee;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0xaee$ReqBody extends MessageMicro<Oidb_0xaee$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"group_code", "list_req", "admin_req"}, new Object[]{0L, null, null}, Oidb_0xaee$ReqBody.class);
    public final PBUInt64Field group_code = PBField.initUInt64(0);
    public Oidb_0xaee$ListReq list_req = new MessageMicro<Oidb_0xaee$ListReq>() { // from class: tencent.im.oidb.cmd0xaee.Oidb_0xaee$ListReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], Oidb_0xaee$ListReq.class);
    };
    public Oidb_0xaee$AdminReq admin_req = new MessageMicro<Oidb_0xaee$AdminReq>() { // from class: tencent.im.oidb.cmd0xaee.Oidb_0xaee$AdminReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], Oidb_0xaee$AdminReq.class);
    };
}
