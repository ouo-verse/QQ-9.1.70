package tencent.im.oidb.cmd0x9ae;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x9ae$ReqBody extends MessageMicro<cmd0x9ae$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"enum_req_source", "uint32_need_forcewin"}, new Object[]{0, 0}, cmd0x9ae$ReqBody.class);
    public final PBEnumField enum_req_source = PBField.initEnum(0);
    public final PBUInt32Field uint32_need_forcewin = PBField.initUInt32(0);
}
