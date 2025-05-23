package tencent.im.oidb.cmd0xbab;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xbab$GroupSetReq extends MessageMicro<cmd0xbab$GroupSetReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 48}, new String[]{"group_code", "doc_url", "privilege_flag", "policy", "only", "exp_set_time"}, new Object[]{0L, "", 0, 0, Boolean.FALSE, 0}, cmd0xbab$GroupSetReq.class);
    public final PBUInt64Field group_code = PBField.initUInt64(0);
    public final PBStringField doc_url = PBField.initString("");
    public final PBUInt32Field privilege_flag = PBField.initUInt32(0);
    public final PBUInt32Field policy = PBField.initUInt32(0);
    public final PBBoolField only = PBField.initBool(false);
    public final PBUInt32Field exp_set_time = PBField.initUInt32(0);
}
