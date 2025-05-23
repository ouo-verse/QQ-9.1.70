package tencent.im.oidb.cmd0xf00;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xf00$ReqBody extends MessageMicro<oidb_0xf00$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint64_group_code", "msg_group_info_ext"}, new Object[]{0L, null}, oidb_0xf00$ReqBody.class);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public oidb_0xf00$GroupInfoExt msg_group_info_ext = new oidb_0xf00$GroupInfoExt();
}
