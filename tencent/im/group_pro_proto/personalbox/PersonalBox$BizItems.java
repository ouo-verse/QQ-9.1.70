package tencent.im.group_pro_proto.personalbox;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class PersonalBox$BizItems extends MessageMicro<PersonalBox$BizItems> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"biz_type", "items", "extra_info"}, new Object[]{0L, null, ByteStringMicro.EMPTY}, PersonalBox$BizItems.class);
    public final PBUInt64Field biz_type = PBField.initUInt64(0);
    public final PBRepeatMessageField<PersonalBox$Item> items = PBField.initRepeatMessage(PersonalBox$Item.class);
    public final PBBytesField extra_info = PBField.initBytes(ByteStringMicro.EMPTY);
}
