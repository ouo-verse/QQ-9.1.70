package tencent.im.s2c.msgtype0x210.submsgtype0x90;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x90$NotifyItem extends MessageMicro<SubMsgType0x90$NotifyItem> {
    public static final int UINT32_PROPERTYID_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_propertyid"}, new Object[]{0}, SubMsgType0x90$NotifyItem.class);
    public final PBUInt32Field uint32_propertyid = PBField.initUInt32(0);
}
