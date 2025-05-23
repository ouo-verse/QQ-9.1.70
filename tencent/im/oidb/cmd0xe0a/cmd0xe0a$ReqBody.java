package tencent.im.oidb.cmd0xe0a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xe0a$ReqBody extends MessageMicro<cmd0xe0a$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{"client", "group_id", "group_type", "mode"}, new Object[]{null, 0L, 0, 0}, cmd0xe0a$ReqBody.class);
    public cmd0xe0a$ClientInfo client = new MessageMicro<cmd0xe0a$ClientInfo>() { // from class: tencent.im.oidb.cmd0xe0a.cmd0xe0a$ClientInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"platform", "version"}, new Object[]{0, ""}, cmd0xe0a$ClientInfo.class);
        public final PBUInt32Field platform = PBField.initUInt32(0);
        public final PBStringField version = PBField.initString("");
    };
    public final PBUInt64Field group_id = PBField.initUInt64(0);
    public final PBUInt32Field group_type = PBField.initUInt32(0);
    public final PBUInt32Field mode = PBField.initUInt32(0);
}
