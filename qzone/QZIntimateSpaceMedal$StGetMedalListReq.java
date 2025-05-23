package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateSpaceMedal$StGetMedalListReq extends MessageMicro<QZIntimateSpaceMedal$StGetMedalListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"space_id", "attach_info"}, new Object[]{"", ""}, QZIntimateSpaceMedal$StGetMedalListReq.class);
    public final PBStringField space_id = PBField.initString("");
    public final PBStringField attach_info = PBField.initString("");
}
