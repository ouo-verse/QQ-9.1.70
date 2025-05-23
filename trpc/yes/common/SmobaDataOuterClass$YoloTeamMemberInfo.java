package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class SmobaDataOuterClass$YoloTeamMemberInfo extends MessageMicro<SmobaDataOuterClass$YoloTeamMemberInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42, 48, 56, 64, 72, 80, 88, 96, 800, 808}, new String[]{"roleid", "openid", "partition", "nickname", "headurl", "showrankgrade", "isleader", "scoreofgrade", "gender", "pvplevel", "defaultshowrankgrade", "defaultscoreofgrade", "uid", "yes_uid"}, new Object[]{0L, "", 0, "", "", 0, 0, 0, 0, 0, 0, 0, 0L, 0L}, SmobaDataOuterClass$YoloTeamMemberInfo.class);
    public final PBUInt64Field roleid = PBField.initUInt64(0);
    public final PBStringField openid = PBField.initString("");
    public final PBUInt32Field partition = PBField.initUInt32(0);
    public final PBStringField nickname = PBField.initString("");
    public final PBStringField headurl = PBField.initString("");
    public final PBUInt32Field showrankgrade = PBField.initUInt32(0);
    public final PBUInt32Field isleader = PBField.initUInt32(0);
    public final PBUInt32Field scoreofgrade = PBField.initUInt32(0);
    public final PBUInt32Field gender = PBField.initUInt32(0);
    public final PBUInt32Field pvplevel = PBField.initUInt32(0);
    public final PBUInt32Field defaultshowrankgrade = PBField.initUInt32(0);
    public final PBUInt32Field defaultscoreofgrade = PBField.initUInt32(0);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBUInt64Field yes_uid = PBField.initUInt64(0);
}
