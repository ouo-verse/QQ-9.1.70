package tencent.im.group_pro_proto.reportsvr;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.persistence.EntityManager;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ReportSvr$Record extends MessageMicro<ReportSvr$Record> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField table_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<ByteStringMicro> fields = PBField.initRepeat(PBBytesField.__repeatHelper__);

    static {
        String[] strArr = {EntityManager.KEY_TABLE_NAME, "fields"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, strArr, new Object[]{byteStringMicro, byteStringMicro}, ReportSvr$Record.class);
    }
}
