package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRelation$TempMsgCommRespBody extends MessageMicro<QQCircleRelation$TempMsgCommRespBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_err_msg;
    public final PBBytesField bytes_token;
    public final PBSInt32Field sint32_result = PBField.initSInt32(0);
    public final PBUInt64Field uint64_from_uin;
    public final PBUInt64Field uint64_to_uin;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42}, new String[]{"sint32_result", "bytes_err_msg", "uint64_from_uin", "uint64_to_uin", "bytes_token"}, new Object[]{0, byteStringMicro, 0L, 0L, byteStringMicro}, QQCircleRelation$TempMsgCommRespBody.class);
    }

    public QQCircleRelation$TempMsgCommRespBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_err_msg = PBField.initBytes(byteStringMicro);
        this.uint64_from_uin = PBField.initUInt64(0L);
        this.uint64_to_uin = PBField.initUInt64(0L);
        this.bytes_token = PBField.initBytes(byteStringMicro);
    }
}
