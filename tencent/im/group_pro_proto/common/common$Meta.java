package tencent.im.group_pro_proto.common;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class common$Meta extends MessageMicro<common$Meta> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{ShortVideoConstants.FROM_UIN, "login_sig"}, new Object[]{0L, null}, common$Meta.class);
    public final PBUInt64Field from_uin = PBField.initUInt64(0);
    public common$LoginSig login_sig = new MessageMicro<common$LoginSig>() { // from class: tencent.im.group_pro_proto.common.common$LoginSig
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uint32_type", "bytes_sig", "uint32_appid"}, new Object[]{0, ByteStringMicro.EMPTY, 0}, common$LoginSig.class);
        public final PBUInt32Field uint32_type = PBField.initUInt32(0);
        public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    };
}
