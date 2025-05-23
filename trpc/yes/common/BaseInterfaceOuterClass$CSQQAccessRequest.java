package trpc.yes.common;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class BaseInterfaceOuterClass$CSQQAccessRequest extends MessageMicro<BaseInterfaceOuterClass$CSQQAccessRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 72, 82}, new String[]{"base_info", "req_header", "body_type", "req_body"}, new Object[]{null, null, 0, ByteStringMicro.EMPTY}, BaseInterfaceOuterClass$CSQQAccessRequest.class);
    public BaseInterfaceOuterClass$CSQQAccessBaseInfo base_info = new BaseInterfaceOuterClass$CSQQAccessBaseInfo();
    public BaseInterfaceOuterClass$CSQQAccessReqHeader req_header = new BaseInterfaceOuterClass$CSQQAccessReqHeader();
    public final PBEnumField body_type = PBField.initEnum(0);
    public final PBBytesField req_body = PBField.initBytes(ByteStringMicro.EMPTY);
}
