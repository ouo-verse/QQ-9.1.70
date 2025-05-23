package qzone;

import com.tencent.mobileqq.mini.servlet.GameHallAuthServerlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class qzoneMigration$QueryJobRsp extends MessageMicro<qzoneMigration$QueryJobRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField job_id = PBField.initString("");
    public final PBEnumField job_status = PBField.initEnum(0);
    public final PBEnumField auth_status = PBField.initEnum(0);
    public final PBBoolField show_tool_tips = PBField.initBool(false);
    public final PBBoolField owner_agree = PBField.initBool(false);

    static {
        String[] strArr = {"job_id", "job_status", GameHallAuthServerlet.AUTH_STATUS, "show_tool_tips", "owner_agree"};
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40}, strArr, new Object[]{"", 0, 0, bool, bool}, qzoneMigration$QueryJobRsp.class);
    }
}
