package tencent.im.trpc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.state.square.guide.step.base.BaseStep;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TrpcMbm$MbManagementResponse extends MessageMicro<TrpcMbm$MbManagementResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{BaseStep.KEY_STEP_ERR_INFO_SER, "set_mbphone_rsp"}, new Object[]{null, null}, TrpcMbm$MbManagementResponse.class);
    public TrpcMbm$ErrorInfo error_info = new TrpcMbm$ErrorInfo();
    public TrpcMbm$SetMbPhoneRsp set_mbphone_rsp = new MessageMicro<TrpcMbm$SetMbPhoneRsp>() { // from class: tencent.im.trpc.TrpcMbm$SetMbPhoneRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], TrpcMbm$SetMbPhoneRsp.class);
    };
}
