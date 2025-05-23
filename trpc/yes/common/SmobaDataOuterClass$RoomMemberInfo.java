package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class SmobaDataOuterClass$RoomMemberInfo extends MessageMicro<SmobaDataOuterClass$RoomMemberInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 50, 58, 64, 72, 80, 88, 800, 808}, new String[]{"openid", "partition", "camp_no", "isleader", "mempos", "nickname", "headurl", "showrankgrade", "scoreofgrade", "pvplevel", "roleid", "uid", "yes_uid"}, new Object[]{"", 0, 0, 0, 0, "", "", 0, 0, 0, 0L, 0L, 0L}, SmobaDataOuterClass$RoomMemberInfo.class);
    public final PBStringField openid = PBField.initString("");
    public final PBUInt32Field partition = PBField.initUInt32(0);
    public final PBInt32Field camp_no = PBField.initInt32(0);
    public final PBInt32Field isleader = PBField.initInt32(0);
    public final PBUInt32Field mempos = PBField.initUInt32(0);
    public final PBStringField nickname = PBField.initString("");
    public final PBStringField headurl = PBField.initString("");
    public final PBUInt32Field showrankgrade = PBField.initUInt32(0);
    public final PBUInt32Field scoreofgrade = PBField.initUInt32(0);
    public final PBUInt32Field pvplevel = PBField.initUInt32(0);
    public final PBUInt64Field roleid = PBField.initUInt64(0);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBUInt64Field yes_uid = PBField.initUInt64(0);
}
