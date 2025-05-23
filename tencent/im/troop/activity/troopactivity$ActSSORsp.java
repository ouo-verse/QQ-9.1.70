package tencent.im.troop.activity;

import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class troopactivity$ActSSORsp extends MessageMicro<troopactivity$ActSSORsp> {
    public static final int BODY_FIELD_NUMBER = 4;
    public static final int CMD_FIELD_NUMBER = 3;
    public static final int ERR_CODE_FIELD_NUMBER = 1;
    public static final int ERR_MSG_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{CheckForwardServlet.KEY_ERR_CODE, "err_msg", "cmd", "body"}, new Object[]{10000, "", 0, ByteStringMicro.EMPTY}, troopactivity$ActSSORsp.class);
    public final PBEnumField err_code = PBField.initEnum(10000);
    public final PBStringField err_msg = PBField.initString("");
    public final PBEnumField cmd = PBField.initEnum(0);
    public final PBBytesField body = PBField.initBytes(ByteStringMicro.EMPTY);
}
