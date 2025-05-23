package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class GetLocalPhone$GuidChangeMibaoData extends MessageMicro<GetLocalPhone$GuidChangeMibaoData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"str_guid_wording", "str_guid_url", "uint32_compare_state"}, new Object[]{"", "", 0}, GetLocalPhone$GuidChangeMibaoData.class);
    public final PBStringField str_guid_wording = PBField.initString("");
    public final PBStringField str_guid_url = PBField.initString("");
    public final PBUInt32Field uint32_compare_state = PBField.initUInt32(0);
}
