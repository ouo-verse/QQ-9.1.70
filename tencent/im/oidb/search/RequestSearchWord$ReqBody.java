package tencent.im.oidb.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class RequestSearchWord$ReqBody extends MessageMicro<RequestSearchWord$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"bytes_rowkey", "uint32_oper_type"}, new Object[]{ByteStringMicro.EMPTY, 0}, RequestSearchWord$ReqBody.class);
    public final PBBytesField bytes_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_oper_type = PBField.initUInt32(0);
}
