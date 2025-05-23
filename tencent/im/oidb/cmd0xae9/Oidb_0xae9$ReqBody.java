package tencent.im.oidb.cmd0xae9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0xae9$ReqBody extends MessageMicro<Oidb_0xae9$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"get_list_req", "get_add_time_req"}, new Object[]{null, null}, Oidb_0xae9$ReqBody.class);
    public Oidb_0xae9$GetListReq get_list_req = new Oidb_0xae9$GetListReq();
    public Oidb_0xae9$GetAddTimeReq get_add_time_req = new MessageMicro<Oidb_0xae9$GetAddTimeReq>() { // from class: tencent.im.oidb.cmd0xae9.Oidb_0xae9$GetAddTimeReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"group_code"}, new Object[]{0L}, Oidb_0xae9$GetAddTimeReq.class);
        public final PBUInt64Field group_code = PBField.initUInt64(0);
    };
}
