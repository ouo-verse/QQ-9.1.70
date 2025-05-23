package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.medal.common$MedalInfo;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x7a8$MedalNews extends MessageMicro<cmd0x7a8$MedalNews> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint64_fri_uin", "str_fri_nick", "msg_medal"}, new Object[]{0L, "", null}, cmd0x7a8$MedalNews.class);
    public final PBUInt64Field uint64_fri_uin = PBField.initUInt64(0);
    public final PBStringField str_fri_nick = PBField.initString("");
    public common$MedalInfo msg_medal = new common$MedalInfo();
}
