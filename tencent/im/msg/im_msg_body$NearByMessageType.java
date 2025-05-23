package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class im_msg_body$NearByMessageType extends MessageMicro<im_msg_body$NearByMessageType> {
    public static final int ETypeClearingImg = 2;
    public static final int ETypeClearingText = 1;
    public static final int ETypeDefault = 0;
    public static final int ETypeIdentify = 1;
    public static final int ETypeNormal = 0;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_type", "uint32_identify_type"}, new Object[]{0, 0}, im_msg_body$NearByMessageType.class);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_identify_type = PBField.initUInt32(0);
}
