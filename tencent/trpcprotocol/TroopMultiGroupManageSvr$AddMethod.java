package tencent.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TroopMultiGroupManageSvr$AddMethod extends MessageMicro<TroopMultiGroupManageSvr$AddMethod> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"add_option", "question", "answer"}, new Object[]{0, "", ""}, TroopMultiGroupManageSvr$AddMethod.class);
    public final PBUInt32Field add_option = PBField.initUInt32(0);
    public final PBStringField question = PBField.initString("");
    public final PBStringField answer = PBField.initString("");
}
