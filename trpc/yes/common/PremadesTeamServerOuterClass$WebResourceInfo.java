package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes30.dex */
public final class PremadesTeamServerOuterClass$WebResourceInfo extends MessageMicro<PremadesTeamServerOuterClass$WebResourceInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"business_id", "down_url", "file_size"}, new Object[]{"", "", 0}, PremadesTeamServerOuterClass$WebResourceInfo.class);
    public final PBStringField business_id = PBField.initString("");
    public final PBStringField down_url = PBField.initString("");
    public final PBInt32Field file_size = PBField.initInt32(0);
}
