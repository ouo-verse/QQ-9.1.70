package tencent.im.oidb.cmd0x4d4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.trunk.Qworkflow.Qworkflow$Workflow;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x4d4$UpdateFailure extends MessageMicro<oidb_0x4d4$UpdateFailure> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_error_msg;
    public final PBBytesField bytes_workflow_id;
    public Qworkflow$Workflow msg_workflow;
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"uint32_result", "bytes_error_msg", "bytes_workflow_id", "msg_workflow"}, new Object[]{0, byteStringMicro, byteStringMicro, null}, oidb_0x4d4$UpdateFailure.class);
    }

    public oidb_0x4d4$UpdateFailure() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_error_msg = PBField.initBytes(byteStringMicro);
        this.bytes_workflow_id = PBField.initBytes(byteStringMicro);
        this.msg_workflow = new Qworkflow$Workflow();
    }
}
