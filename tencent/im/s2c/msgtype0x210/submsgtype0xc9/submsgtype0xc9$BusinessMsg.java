package tencent.im.s2c.msgtype0x210.submsgtype0xc9;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0xc9$BusinessMsg extends MessageMicro<submsgtype0xc9$BusinessMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{QQHealthReportApiImpl.MSG_TYPE_KEY, "bytes_msg_data", "bool_tab_visible"}, new Object[]{0, ByteStringMicro.EMPTY, Boolean.FALSE}, submsgtype0xc9$BusinessMsg.class);
    public final PBEnumField msg_type = PBField.initEnum(0);
    public final PBBytesField bytes_msg_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBoolField bool_tab_visible = PBField.initBool(false);
}
