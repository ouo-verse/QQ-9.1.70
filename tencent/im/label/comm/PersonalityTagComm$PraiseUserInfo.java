package tencent.im.label.comm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class PersonalityTagComm$PraiseUserInfo extends MessageMicro<PersonalityTagComm$PraiseUserInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint64_praise_uin", "str_nick"}, new Object[]{0L, ""}, PersonalityTagComm$PraiseUserInfo.class);
    public final PBUInt64Field uint64_praise_uin = PBField.initUInt64(0);
    public final PBStringField str_nick = PBField.initString("");
}
