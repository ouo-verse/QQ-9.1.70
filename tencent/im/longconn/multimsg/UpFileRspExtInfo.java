package tencent.im.longconn.multimsg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class UpFileRspExtInfo extends MessageMicro<UpFileRspExtInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_msg_res_id"}, new Object[]{ByteStringMicro.EMPTY}, UpFileRspExtInfo.class);
    public final PBBytesField bytes_msg_res_id = PBField.initBytes(ByteStringMicro.EMPTY);
}
