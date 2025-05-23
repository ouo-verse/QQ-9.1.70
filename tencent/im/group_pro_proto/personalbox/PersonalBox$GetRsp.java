package tencent.im.group_pro_proto.personalbox;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes29.dex */
public final class PersonalBox$GetRsp extends MessageMicro<PersonalBox$GetRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"biz_items"}, new Object[]{null}, PersonalBox$GetRsp.class);
    public final PBRepeatMessageField<PersonalBox$BizItems> biz_items = PBField.initRepeatMessage(PersonalBox$BizItems.class);
}
