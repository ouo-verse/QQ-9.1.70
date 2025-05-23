package tencent.im.oidb.jump_url_check;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class jump_url_check$ReqJumpUrlCheckRecmd extends MessageMicro<jump_url_check$ReqJumpUrlCheckRecmd> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50}, new String[]{"uin", "jump_url", "pkg_name", QZoneDTLoginReporter.SCHEMA, "action", "activity_list"}, new Object[]{0L, "", "", "", "", null}, jump_url_check$ReqJumpUrlCheckRecmd.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBStringField jump_url = PBField.initString("");
    public final PBStringField pkg_name = PBField.initString("");
    public final PBStringField schema = PBField.initString("");
    public final PBStringField action = PBField.initString("");
    public final PBRepeatMessageField<jump_url_check$ActivityInfo> activity_list = PBField.initRepeatMessage(jump_url_check$ActivityInfo.class);
}
