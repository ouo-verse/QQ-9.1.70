package tencent.im.oidb.cmd0xac5;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xac5$RspBody extends MessageMicro<cmd0xac5$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_now_data"}, new Object[]{ByteStringMicro.EMPTY}, cmd0xac5$RspBody.class);
    public final PBBytesField bytes_now_data = PBField.initBytes(ByteStringMicro.EMPTY);
}
