package tencent.im.group_pro_proto.msgpush;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tenpay.sdk.util.QWSoterConstans;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class servtype$QuestionChannelSystemMsg extends MessageMicro<servtype$QuestionChannelSystemMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{QWSoterConstans.CGI_KEY_BUSI_TYPE, "busi_data"}, new Object[]{0, ByteStringMicro.EMPTY}, servtype$QuestionChannelSystemMsg.class);
    public final PBUInt32Field busi_type = PBField.initUInt32(0);
    public final PBBytesField busi_data = PBField.initBytes(ByteStringMicro.EMPTY);
}
