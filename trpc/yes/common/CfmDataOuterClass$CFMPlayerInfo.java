package trpc.yes.common;

import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes30.dex */
public final class CfmDataOuterClass$CFMPlayerInfo extends MessageMicro<CfmDataOuterClass$CFMPlayerInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 800}, new String[]{GdtGetUserInfoHandler.KEY_AREA, "partition", "platid", "openid", "yes_uid"}, new Object[]{0, 0, 0, "", 0L}, CfmDataOuterClass$CFMPlayerInfo.class);
    public final PBInt32Field area = PBField.initInt32(0);
    public final PBInt32Field partition = PBField.initInt32(0);
    public final PBInt32Field platid = PBField.initInt32(0);
    public final PBStringField openid = PBField.initString("");
    public final PBUInt64Field yes_uid = PBField.initUInt64(0);
}
