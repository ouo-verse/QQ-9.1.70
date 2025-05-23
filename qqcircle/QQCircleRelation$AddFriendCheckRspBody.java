package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRelation$AddFriendCheckRspBody extends MessageMicro<QQCircleRelation$AddFriendCheckRspBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_ext;
    public final PBBytesField bytes_notice;
    public final PBBytesField bytes_reason;
    public final PBUInt32Field uint32_permission;
    public final PBUInt32Field uint32_reason;
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42, 50}, new String[]{"uint32_result", "bytes_reason", "uint32_reason", "uint32_permission", "bytes_notice", "bytes_ext"}, new Object[]{0, byteStringMicro, 0, 0, byteStringMicro, byteStringMicro}, QQCircleRelation$AddFriendCheckRspBody.class);
    }

    public QQCircleRelation$AddFriendCheckRspBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_reason = PBField.initBytes(byteStringMicro);
        this.uint32_reason = PBField.initUInt32(0);
        this.uint32_permission = PBField.initUInt32(0);
        this.bytes_notice = PBField.initBytes(byteStringMicro);
        this.bytes_ext = PBField.initBytes(byteStringMicro);
    }
}
